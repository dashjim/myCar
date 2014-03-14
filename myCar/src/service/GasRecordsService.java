/*
 * 创建日期 2009-6-8
 *
 */
package service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.CarExample;
import model.GasRcd;
import model.GasRcdExample;

import org.apache.log4j.Logger;

import service.interfaces.GasRecordsServiceI;

import com.ibatis.common.util.PaginatedList;

import dao.GasRcdDAO;
import dao.GasRcdDAOImpl;
import dao.config.DaoClient;

@SuppressWarnings("deprecation")
public class GasRecordsService implements GasRecordsServiceI
{
	private GasRcdDAO gasRcdDAO = new GasRcdDAOImpl(DaoClient.getSqlMapInstance());

	private Logger log = Logger.getLogger(this.getClass());
	
	static private GasRecordsService obj = new GasRecordsService(); 
	
	static public GasRecordsService getSingleton()	{	return obj;	}
	
	private GasRecordsService() {/*avoid to use it, use singleton instead.*/}
	
	
	public PaginatedList  getRcdsForUID(int id, int gasRcdListSize)
	{
		try
		{
			return gasRcdDAO.getRcdForUserID(id, gasRcdListSize);
		} catch (SQLException e)
		{
			log.debug("getRcdsForUID error: " + e);
		} 
		return null;
		
	}
	
	//TODO error thrown to error page! 
	public void deleteLastInputForUid(int id){
		try
		{
			log.debug("start deleteLastInputForUid id: "+id);
			String msg = gasRcdDAO.deleteLastRcdsForUserID(id);
			log.debug("deleteLastInputForUid msg: " + msg);
		} catch (SQLException e)
		{
			log.debug("deleteLastInputForUid error: " + e);
		} 
		
		
	}
	
	/**
	 * the key of the map should match the one in the xml config file.
	 * @param userName
	 * @param lineNumber 
	 * 				return how much records, like "10".
	 * @return
	 */
	public PaginatedList getRcdForName(String userName, int lineNumber)
	{
		try
		{	
			log.debug("user name and rcds per page: " +userName+" "+lineNumber);
			return gasRcdDAO.getRcdForUserName(userName, lineNumber);
			
		} catch (SQLException e)
		{
			log.error("get rcd for name error", e);
		}
		return null;
	}

	public void deleteLastRcdForID(int id)
	{
		try
		{
			gasRcdDAO.deleteByPrimaryKey(id);
		} catch (SQLException e)
		{
			log.error("get rcd for id: " + id, e);
		}
	}	
	public GasRcd getLastRcdForUserID(Integer id)
	{
		try
		{
			return gasRcdDAO.getLastRcdForUserID(id);
		} catch (SQLException e)
		{
			log.error("get rcd for id: " + id, e);
		}
		return null;
	}
	
	/**
	 * select all the rcd which lpm is null by user ID
	 * @return
	 */
	public List getRcdLPMIsNull(Integer uid)
	{
		log.debug("getRcdLPMIsNull for uid: "+ uid);
		GasRcdExample where = new GasRcdExample();
		where.createCriteria().andLPMEqualTo(Float.valueOf("0")).andUserIdEqualTo(uid);
		try
		{
			return gasRcdDAO.selectByExample(where);
		} catch (SQLException e)
		{
			log.error("getRcdLPMIsNull for id: " + uid, e);
		}
		return null;
	}

	/**
	 * Need user ID in record object.
	 */
	public boolean saveRcd(GasRcd record)
	{
		try
		{
			if (record.getUserId()!= null)
			{
				log.info("try to save rcd for user: "+ record.getUserId());
				gasRcdDAO.insertSelective(record);
				return true;
			}
		} catch (SQLException e)
		{
			log.error("save recd error", e);
		}
		log.warn("not save recd!");
		return false;
	}
	
	public void upateLPMForNotFull(List<GasRcd> rcdList)
	{
		for (Iterator iterator = rcdList.iterator(); iterator.hasNext();)
		{
			GasRcd gasRcd = (GasRcd) iterator.next();
			
			try
			{
				gasRcdDAO.updateByPrimaryKeySelective(gasRcd);
				log.debug("upateLPMForNotFull: current gasRcd id: " + gasRcd.getId());
			} catch (SQLException e)
			{
				log.error("upateLPMForNotFullByUser error", e);
			}
		}
	}
	
	/**
	 * update selectively
	 * @param rcd
	 * @return
	 */
	public boolean updateByPK(GasRcd rcd)
	{
		try
		{
			gasRcdDAO.updateByPrimaryKeySelective(rcd);
			return true;
		} catch (SQLException e)
		{
			log.error("upateLPMForNotFullByUser error", e);
		}
		return false;
	}
	
	public GasRcdDAO getGasRcdDAO()
	{
		return gasRcdDAO;
	}

	public void setGasRcdDAO(GasRcdDAO gasRcdDAO)
	{
		this.gasRcdDAO = gasRcdDAO;
	}

	public List<GasRcd> getRcdForName(String userName, String lineNumber)
	{
		// TODO 
		return null;
	}
}
