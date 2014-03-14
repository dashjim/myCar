/*
 * 创建日期 2009-7-27
 *
 */
package service.tool;


import java.util.Map;

import model.GasRcd;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * to wrap all the exceptions.
 * @author CofeMate
 */
public class BeanUtilsWrap
{
	static private Logger log = Logger.getRootLogger();
	
	/**
	 * to wrap all the exceptions.
	 * @param bean
	 * @return
	 */
	static public Object cloneBean(Object bean)
	{
		try
		{
			return BeanUtils.cloneBean(bean);
		} catch (Exception e)
		{
			log.error("can not clone Bean by Bean Utils" + e);
		}
		return null;
	}
	
	/**
	 * to wrap all the exceptions.
	 * @param bean
	 * @return
	 */
	static public Map describe(Object bean)
	{
		try
		{
			return BeanUtils.describe(bean);
		} catch (Exception e)
		{
			log.error("can not describ Bean by Bean Utils" + e);
		}
		return null;
	}

	public static void populate(Object bean, Map parameterMap)
	{
		try
		{
			BeanUtils.populate(bean, parameterMap);
		} catch (Exception e)
		{
			log.error("can not populate Bean by Bean Utils" + e);
		}
	}


}
