/*
 * 创建日期 2009-7-19
 *
 */
package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import model.GasRcd;
import model.Report;

import org.apache.log4j.Logger;

import service.tool.BeanUtilsWrap;
import service.tool.Cfg;

public class CalculatingService
{
	public static Logger log = Logger.getRootLogger();
	static final ReportServeice reportServeice = ReportServeice.getSingleton();
	
	static private CalculatingService obj = new CalculatingService(); 
	
	static public CalculatingService getSingleton()	{	return obj;	}
	
	private CalculatingService(){/*avoid to use it! use singleton instead.*/	}
	
	/**
	 *  report.totalDisatnce is not like the Rcd.totalDistance, the first one is the
	 * distance has gas rcds in our system, the second one is the number directly read from car.
	 * 
	 * The function must use form bean data LastDisatnce or TOtalDistance.
	 * */ 
	public Report calculateReport(Integer uid, GasRcd gasRcd, GasRcd lastGasRcd)
	{
		
		if (lastGasRcd == null) lastGasRcd = new GasRcd();//TODO error here
		if(gasRcd == null) gasRcd = new GasRcd();//TODO throw exception here!!!
				
		Report report = reportServeice.getLastReportForUserID(uid);
		if (report == null) report = new Report();// First time query: no report in database at all.
		
		if (!(lastGasRcd.getId()==null || lastGasRcd.getId()<1))//has last rcd, so it is not the first time input
		{
			log.debug("last rcd bean before caculate: "+BeanUtilsWrap.describe(lastGasRcd));
			log.debug(report.getTotalGas() + gasRcd.getFueledVolum());
			
			report.setUserId(uid);
			report.setTotalGas(report.getTotalGas() + gasRcd.getFueledVolum());
			
			log.debug(report.getTotalFee() + gasRcd.getMoney() * gasRcd.getFueledVolum());
			//this is based on the MONEY is the mandatory field in form, otherwise we may have zero to add.  
			report.setTotalFee(report.getTotalFee() + gasRcd.getMoney() * gasRcd.getFueledVolum());
			
			// TODO: calculate total distance first -- will this be a problem for following count?  
			log.debug(gasRcd.getLastDistance() + report.getTotalDistance());
			report.setTotalDistance(gasRcd.getLastDistance() + report.getTotalDistance());
			
			log.debug(report.getTotalFee() * 10 / report.getTotalDistance());
			report.setAvgFee(report.getTotalFee() * 10 / report.getTotalDistance()); 
			
			log.debug(report.getTotalGas()/report.getTotalDistance()*100);
			
			//the first time enter data is not right.
				report.setAvgLPM(report.getTotalGas()/report.getTotalDistance()*100);
		}else {/*avglpm is zero by default*/	}
		
		report.setId(null);//because the obj is retrieved from db. 
		report.setUserId(uid);
		reportServeice.saveReport(report);
	
		return report;
	}
	
	final private GasRecordsService rcdService = GasRecordsService.getSingleton();
	
	public boolean calculatLPMForGasRcd(Integer uid, GasRcd gasRcd,	GasRcd lastGasRcd)
	{
		
		/**********************************************************************************
		 * start calculating avg LPM 
		 *********************************************************************************/
		if (gasRcd.getIsFull()== true)//full
		{
			// 1, select all the rcd which lpm is null
			List rcdLpmIsNullList = rcdService.getRcdLPMIsNull(uid);
			log.debug("rcdLpmIsNullList size: " + rcdLpmIsNullList.size());
			
			//calculate avg value 每条记录的LPM都是平均值，是一次计算，填多条记录的lpm,即便漏填一条记录也没关系
			if (rcdLpmIsNullList!=null && rcdLpmIsNullList.size()>1)
			{
				log.debug("Calculating entering the logic -- rcdLpmIsNullList!=null && rcdLpmIsNullList.size()>1");
				
				// 2, calculate totalgas and totalDisatance in the selected rcds.
				Float totalVolumum = new Float(0);
				int totalDistance = new Short("0");
				for (Iterator iterator = rcdLpmIsNullList.iterator(); iterator.hasNext();)
				{
					GasRcd rcd = (GasRcd) iterator.next();
					totalVolumum = totalVolumum + rcd.getFueledVolum();
					totalDistance = totalDistance + rcd.getLastDistance();
				}
				
				Float avgLPM = totalVolumum/totalDistance*100;							
				
				// 3, update all gasRcds 
				for (Iterator iterator = rcdLpmIsNullList.iterator(); iterator.hasNext();)
				{
					GasRcd rcd = (GasRcd) iterator.next();
					log.debug("the id for rcd to be updated: " + rcd.getId());
					rcd.setLPM(avgLPM);
				}				
				
				//4, save to db
				rcdService.upateLPMForNotFull(rcdLpmIsNullList);

			} else if(rcdLpmIsNullList!=null  && rcdLpmIsNullList.size()==1)// Gas is not full,  size is 1 这时需要判断是否漏填，只有没有漏填才能将db中最新记录的lpm设置为计算结果，否则-1(无法计算)
			{
				log.debug("Calculating entering the logic -- rcdLpmIsNullList!=null");  
				/**********************************************************************************
				 * if one rcd not be inputed to system. 
				 *********************************************************************************/				
				lastGasRcd.setLPM(gasRcd.getFueledVolum()/gasRcd.getLastDistance()*100);
				if(gasRcd.getTotalDistance()-lastGasRcd.getTotalDistance()-gasRcd.getLastDistance()> Cfg.VALUE_TO_DECIDE_IF_OMMIT)
				{
										
					log.debug("Calculating entering the logic -- decided that user forget to input one gas rcd.");	
					//TODO 用户确认漏填
					{
						lastGasRcd.setLPM(new Float(-1));
						
						try
						{
							gasRcd.setLastFueledTime(new SimpleDateFormat("yyyy-MM-dd").parse("2999-12-31"));
						} catch (ParseException e)
						{
							log.error("date formate error ",e);
						}
					}
					//未漏填
					/*{
						lastGasRcd.setLPM(gasRcd.getFueledVolum()/gasRcd.getLastDistance()*100);						
					}*/			
										
				}
				log.debug("the old gasRcd to be updated after calculate new rcd: " + BeanUtilsWrap.describe(lastGasRcd));
				rcdService.updateByPK(lastGasRcd);
			}else {
				//error
			}
			
		} else //not fulla
		{
			// can calculate! do nothing!
		}
		rcdService.saveRcd(gasRcd);
		return true;
	}
}
