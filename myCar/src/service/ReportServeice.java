/*
 * 创建日期 2009-7-13
 *
 */
package service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Report;
import model.ReportExample;

import org.apache.log4j.Logger;

import service.exceptions.LogedException;
import service.tool.BeanUtilsWrap;
import dao.ReportDAO;
import dao.ReportDAOImpl;
import dao.config.DaoClient;

public class ReportServeice
{
	private ReportDAO reportDAO = new ReportDAOImpl(DaoClient.getSqlMapInstance());

	private Logger log = Logger.getLogger(this.getClass());
	
	static private ReportServeice obj = new ReportServeice() ;
	
	//TODO will error try to use the object pool
	@Deprecated
	static public ReportServeice getSingleton(){ return obj;}
	
	private ReportServeice() {/*avoid to use it, use singleton instead.*/}
	
	/**
	 * TODO not sure if this api will affect the date integrate
	 * @param id
	 */
	public void deleteLastUserInputForUID(int id)
	{
		try
		{
			reportDAO.deleteLastReportForUserID(id);
		} catch (SQLException e)
		{
			log.error("error while getLastReportForUserID" + e);
		}
	}

	public Report getLastReportForUserID(int id)
	{
		try
		{
			return reportDAO.getLastReportForUserID(id);
		} catch (SQLException e)
		{
			log.error("error while getLastReportForUserID" + e);
		}
		return null;
	}

	/**
	 * if has the report than return the report VO, or return null.
	 * @param id
	 * @return
	 */
	public List<Report> getReportForUserID(Integer id)
	{
		ReportExample where = new ReportExample();
		where.createCriteria().andUserIdEqualTo(id);
		try
		{
			List<Report> list = reportDAO.selectByExample(where);
			if (!list.isEmpty())return list; else return null;
		} catch (SQLException e)
		{
			log.error("error while select report for user id: " + id, e);
		}
		return null;
	}
	/**
	 * TODO We should throw exception when error happens, and handle it in view layer!
	 * TODO does not return false! should throw exception.
	 * @param report
	 * @return false - if error happens 
	 * @throws LogedException 
	 */
	public boolean saveReport(Report report) 
	{
		try
		{
			if (report == null || report.getFueledTime() == null)
			{ // This is a MUST HAVE field for database.
				report.setFueledTime(new Date());
			}
			if (report.getUserId()== 0)
			{
				throw new Exception("muse have the user ID");
			}
			log.info("new report to be saved: "	+ BeanUtilsWrap.describe(report));

			reportDAO.insertSelective(report);
			return true;
		} catch (Exception e)
		{
			log.error("error while saveReport", e);
		}
		return false;
	}
	
	public ReportDAO getReportDAO()
	{
		return reportDAO;
	}

	public void setReportDAO(ReportDAO reportDAO)
	{
		this.reportDAO = reportDAO;
	}


}
