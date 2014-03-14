/*
 * 创建日期 2010-6-6
 *
 */
package service.tool;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import servlet.ReportFace;

import model.GasRcd;

import com.ibatis.common.util.PaginatedList;

/**
 * <img src="http://chart.apis.google.com/chart?cht=lxy&chs=195x125&chd=t:-1|11.8,10.6,11.0,6.8,7.6|-1|11.8,10.9,10.8,7.6,7.8|-1|9,9&chxr=1,6.8,11.8,1&chds=6.8,11.8&chco=3072F3,ff0000,aaaaaa&chls=2,4,1&chm=s,0000ff,0,-1,3|s,00ff33,1,-1,3|s,00ff33,3,-1,3&chdl=%D3%CD%BA%C4|%D3%CD%BA%C4|%D3%CD%BA%C4&chdlp=t&chxt=x,y,x&chxl=0:%7C%7C%E6%B2%B9%E8%80%97%7C%7C" alt="Lamp" />
 * http://chart.apis.google.com/chart?cht=lxy&chs=125x125&chd=t:-1|11.8,10.6,11.0,6.8,7.6|&chxr=1,6.8,11.8,1&chds=6.8,11.8&chco=3072F3,ff0000,00ff00&chls=2,4,1&chm=s,0000ff,0,-1,3|s,00ff33,1,-1,3&chdl=油耗|移动平均&chdlp=t&chxt=x,y&chxl=0:|6月|7月
cht=lxy
chs=125x125
chd=t:-1
    11.8,10.6,11.0,6.8,7.6
    -1
    11.8,10.9,10.8,7.6,7.8
    -1
    9,9
chxr=1,6.8,11.8,1
chds=6.8,11.8
chco=3072F3,ff0000,aaaaaa
chls=2,4,1
chm=s,0000ff,0,-1,3
    s,00ff33,1,-1,3
    s,00ff33,3,-1,3
chdl=油耗
    移动平均
    总平均
chdlp=b
chxt=x,y
chxl=0:
    6月
    7月
    
    have to encode the Chinese in chart.
 * @author CofeMate
 */
public class GoogleChartAPI
{
	static Logger log = Logger.getLogger(ReportFace.class);
	public static String getTwoLineChart(List<GasRcd> list) {
		
		try
		{
			GasRcd rcd = list.get(0);
		} catch (Exception e)//cjcfat20h
		{
			//no rcd at all
			return "http://chart.apis.google.com/chart?cht=lxy&chs=225x125&chco=3072F3,ff0000,00ff00&chls=2,4,1&chm=s,0000ff,0,-1,3|s,00ff33,1,-1,3&chdlp=t&chxt=x,y&chxr=1,-1,1,1&chdl=%E6%B2%B9%E8%80%97";
		}
		
		if (list.get(0)==null)
		{
			//no rcd at all
			return "http://chart.apis.google.com/chart?cht=lxy&chs=225x125&chco=3072F3,ff0000,00ff00&chls=2,4,1&chm=s,0000ff,0,-1,3|s,00ff33,1,-1,3&chdlp=t&chxt=x,y&chxr=1,-1,1,1&chdl=%E6%B2%B9%E8%80%97";
		}
		String urlPrefix = "http://chart.apis.google.com/chart?cht=lxy&chs=225x125&chco=ff0000,ff00ff,00ff00&chls=2,4,0&chm=s,0000ff,0,-1,3|s,00ff33,1,-1,3&chdlp=t&chxt=x,y";
		String lpmDataString =""; 
		Float maxLPM =((GasRcd)(list.get(0))).getLPM(), minLPM = maxLPM;//init value will be changed.
	
		//example:
		//http://chart.apis.google.com/chart?cht=lc&chs=180x80&chd=t:4257,4305,4332,4399,4509,4543,4565,4607,4636,4677,4788,4831&chxt=x,y&chls=1.0&chxl=0:%7C%7C%E6%80%BB%E9%94%80%E9%87%8F%E8%B6%8B%E5%8A%BF%7C%7C1:%7C4257%7C%7C%7C%7C4831&chxs=0,0000DD,13&chds=4257,4831

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("MM/dd");
		String time="";
		for(int i = 0; i< list.size(); i++)
		{
			GasRcd rcd = (GasRcd) list.get(i);
			Float thisLPM = rcd.getLPM();
			
			if (thisLPM < 1)
			{
				continue;
			}
			//request.setAttribute("rcd", rcd);
			
			if (maxLPM.compareTo(thisLPM)< 0)	
			{//not bigger
				maxLPM = thisLPM;
			}else if (minLPM.compareTo(thisLPM)>0)
			{//lesser
				minLPM =thisLPM;
			}
			if (i<list.size()-1)//not the last in the list
			{
				lpmDataString += nf.format(thisLPM)+",";
				time += df.format(rcd.getFueledTime())+"|";
			}
		}
		

		if (lpmDataString.length()>1)
		{
			lpmDataString = (String) lpmDataString.subSequence(0,lpmDataString.length()-1);
		} else
		{
			lpmDataString = "0";
		}
		if ((maxLPM - minLPM)<2) 
		{
			log.debug("minLPM equals maxLPM ");
			minLPM -=1;
			maxLPM +=1;
		}
		if (minLPM <2) minLPM =new Float(2);
		//http://chart.apis.google.com/chart?cht=lxy&chs=125x125&chd=t:-1|11.8,10.6,11.0,6.8,7.6
		//&chxr=1,6.8,11.8,1&chds=6.8,11.8&chco=3072F3,ff0000,00ff00&chls=2,4,1&chm=s,0000ff,0,-1,3|s,00ff33,1,-1,3&chdl=油耗|移动平均&chdlp=t&chxt=x,y&chxl=0:|6月|7月
		String chd = "&chd=t:-1|"+lpmDataString; //data
		String chxr= "&chxr=1,"+nf.format(minLPM)+","+nf.format(maxLPM)+",1";//axis range value
		
		String chds= "&chds="+nf.format(minLPM)+","+nf.format(maxLPM); //data scale
		//chls: line style, chm: link marker
		String chxl = "&chxl=0:|"+time;
		String chdl ="";
		try
		{
			chdl = "&chdl="+ URLEncoder.encode("油耗", "UTF-8");
		} catch (UnsupportedEncodingException e1)
		{
			//TODO log it
			e1.printStackTrace();
		}
		String theURL = urlPrefix + chd+ chxr + chds +chxl+chdl;
	
		log.debug("google chart url: "+theURL);
		return theURL;
	}
	
	/**
	 * test 
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<GasRcd> al = new ArrayList<GasRcd>(5);
		GasRcd g1= new GasRcd();
		g1.setLPM(new Float(11.8));
		GasRcd g2= new GasRcd();
		g2.setLPM(new Float(7.6));
		GasRcd g3= new GasRcd();
		g3.setLPM(new Float(8.1));
		al.add(g1);
		al.add(g2);
		al.add(g3);
		System.out.println(getTwoLineChart(al));
	}
}
