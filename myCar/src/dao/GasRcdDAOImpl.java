package dao;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import service.tool.BeanUtilsWrap;
import service.tool.Cfg;
import servlet.ReportFace;
import model.GasRcd;
import model.GasRcdExample;
import model.Report;
import model.ReportExample;

public class GasRcdDAOImpl implements GasRcdDAO {
	static Logger log = Logger.getLogger(GasRcdDAOImpl.class);
	/**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    private SqlMapClient sqlMapClient;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public GasRcdDAOImpl(SqlMapClient sqlMapClient) {
        super();
        this.sqlMapClient = sqlMapClient;
    }
    
    /**
     * the most recent rcd is always empty because don't know how long the car can go.
     * so, we have to get the second most rcd, which has the lpm data.
     * we will delete the most recent one and 
     * 
     */
	public String deleteLastRcdsForUserID(Integer id) throws SQLException
	{
		List<GasRcd> list = getRcdForUserID(id,2);
		ReportDAOImpl rptDao = new ReportDAOImpl(this.sqlMapClient);
		if (list.size()<2)
		{
			try
			{	
				
				//if only has one rcd?
				log.debug("delete enter has one rcd logic. ");
				log.debug(" deleteByPrimaryKey key: " +list.get(0).getId());
				this.deleteByPrimaryKey(list.get(0).getId());
				//delete by user id.
				log.debug("delete rpt rcd for user: "+id);
				rptDao.deleteLastReportForUserID(id);
				
				log.debug("transaction commited");
			} catch (Exception e)
			{
				
				log.error("error while delted rcd if user only have one rcd, exception will throw out.");
				throw new SQLException("deleteLastRcdsForUserID error! "+e);
			}
			return "has one rcd only";
		}
		//has at least two rcds
		log.debug("delete: enter user has at least two rcd logic.");
		GasRcd gRcd= list.get(list.size()-1);//the record has lpm.
    	System.out.println("grcd id: "+gRcd.getId());
    	Float lastLpm = gRcd.getLPM();
    	//delete the most recent one and update the rest records which has the same lpm to 0 
		//update
    	try
		{
    		log.debug("try to update records");

    		GasRcdExample selectLastRcdsExample = new GasRcdExample();
    		selectLastRcdsExample.createCriteria().andLPMBetween(new Float(lastLpm-0.0001), new Float(lastLpm+0.0001)).andUserIdEqualTo(id);
    		List<GasRcd> lastRcdsToUpdae = selectByExample(selectLastRcdsExample);
    		log.debug("select the ones to be updated");
    		sqlMapClient.startBatch();
    		for (Iterator<GasRcd> iterator = lastRcdsToUpdae.iterator(); iterator.hasNext();)
    		{
    			GasRcd gasRcd = (GasRcd) iterator.next();
    			gasRcd.setLPM(new Float(0));
    			updateByPrimaryKeySelective(gasRcd);
    			log.debug("udated one: "+BeanUtilsWrap.describe(gasRcd));
    		}
    		sqlMapClient.executeBatch();
    		
    		//delete
    		log.debug(" deleteByPrimaryKey key: " +list.get(0).getId());
    		this.deleteByPrimaryKey(list.get(0).getId());//delete last rcd
    		//error here
    		rptDao.deleteLastReportForUserID(id);

    		log.debug(" deleteByPrimaryKey key complete");
		} catch (Exception e)
		{
			log.error("delete error");
			throw new SQLException("deleteLastRcdsForUserID error! "+e);
		}
		return "has more than two rcds";
	}

    
	@SuppressWarnings("deprecation")
	public  PaginatedList getRcdForUserName(String name, int listSize) throws SQLException
	{
		return sqlMapClient.queryForPaginatedList("gasrcds.getRcdForUserName", name, listSize);
	}
	
	@SuppressWarnings("deprecation")
	public PaginatedList getRcdForUserID(Integer id,  int listSize) throws SQLException
	{
		return sqlMapClient.queryForPaginatedList("gasrcds.getRcdForUserID", id, listSize);
	}

	public GasRcd getLastRcdForUserID(Integer id) throws SQLException
	{
		return (GasRcd) sqlMapClient.queryForObject("gasrcds.getLastRcdForUserID", id);
	}
	
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int countByExample(GasRcdExample example) throws SQLException {
        Integer count = (Integer)  sqlMapClient.queryForObject("gasrcds.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int deleteByExample(GasRcdExample example) throws SQLException {
        int rows = sqlMapClient.delete("gasrcds.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int deleteByPrimaryKey(Integer id) throws SQLException {
        GasRcd key = new GasRcd();
        key.setId(id);
        int rows = sqlMapClient.delete("gasrcds.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public void insert(GasRcd record) throws SQLException {
        sqlMapClient.insert("gasrcds.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public void insertSelective(GasRcd record) throws SQLException {
        sqlMapClient.insert("gasrcds.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public List selectByExample(GasRcdExample example) throws SQLException {
        List list = sqlMapClient.queryForList("gasrcds.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public GasRcd selectByPrimaryKey(Integer id) throws SQLException {
        GasRcd key = new GasRcd();
        key.setId(id);
        GasRcd record = (GasRcd) sqlMapClient.queryForObject("gasrcds.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int updateByExampleSelective(GasRcd record, GasRcdExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("gasrcds.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int updateByExample(GasRcd record, GasRcdExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = sqlMapClient.update("gasrcds.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int updateByPrimaryKeySelective(GasRcd record) throws SQLException {
        int rows = sqlMapClient.update("gasrcds.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    public int updateByPrimaryKey(GasRcd record) throws SQLException {
        int rows = sqlMapClient.update("gasrcds.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 12 00:32:40 CST 2009
     */
    private static class UpdateByExampleParms extends GasRcdExample {
        private Object record;

        public UpdateByExampleParms(Object record, GasRcdExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }




}