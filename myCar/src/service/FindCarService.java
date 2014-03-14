/*
 * �������� 2010-7-14
 *
 */
package service;

import java.sql.SQLException;
import java.util.List;

import model.CarBeanExample;
import model.CarBeanExample.Criteria;
import model.formVO.CarQueryObj;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.ibatis.common.util.PaginatedList;

import dao.CarBeanDAO;
import dao.CarBeanDAOImpl;
import dao.config.DaoClient;

public class FindCarService
{
	private CarBeanDAO carDao = new CarBeanDAOImpl(DaoClient.getSqlMapInstance());
	private Logger log = Logger.getLogger(this.getClass());

	public void getInitData()
	{
		// TODO 
		
	}
	/**
	 * List the car option for user to select
	 * producer, car name, power range, good LPM range, bad LPM range 
	 **/
	public String[] getProducerNames()
	{
		try{
			return carDao.getProducerNames();
		} catch (SQLException e){log.error("sql error: ", e);}
		return null;
	}
	
	/**
	 * for all car names
	 * @return
	 */
	public String[] getCarNames()
	{
		try{
			return carDao.getCarNames();
		} catch (SQLException e){log.error("sql error: ", e);}
		return null;
	}
	/****
	 * only for a producer.
	 * @throws SQLException should be catch at view layer.
	 * *****/
	
	public String[] queryCarNames(CarQueryObj qo) throws SQLException
	{
		return carDao.getCarNames(qo.getProdcerName());
	}
	

	/****
	 * query database by user criteria
	 * producer, car name, power range, good LPM range, bad LPM range 
	 * @param listSize 
	 * @throws SQLException should be catch at view layer.
	 * 
	 * TODO put the method into DAO
	 * *****/
	
	public PaginatedList queryCar(CarQueryObj qo, int listSize) throws SQLException
	{
		
		log.debug("enter querycar with qo: "+new JSONObject(qo).toString());
		CarBeanExample example = new CarBeanExample();
		Criteria query = example.createCriteria();
		example.setOrderByClause("Factor asc");
		if (qo.getProdcerName()!= null)
		{
			query.andProducerEqualTo(qo.getProdcerName());} 
		if(qo.getCarName()!=null)
		{
			query.andNameEqualTo(qo.getCarName());
		}
		if (qo.getBadLPMLower()>-1)
		{
			query.andBadLPMBetween(qo.getBadLPMLower(), qo.getBadLPMHigh());
		}
		if (qo.getPowerLower()>-1)
		{
			query.andPowerBetween(qo.getPowerLower(), qo.getPowerHigh());
		}
		if ("手动".equals(qo.getTrans()))
		{
			query.andTransLike("MT%");
		}
		if ("自动".equals(qo.getTrans()))
		{
			query.andTransLike("AT%");
		}
		if ("其它".equals(qo.getTrans()))
		{
			query.andTransNotLike("MT%");
			query.andTransNotLike("AT%");
		}
		return carDao.selectPaginnatedByExample(example, listSize);
	}
	
}
