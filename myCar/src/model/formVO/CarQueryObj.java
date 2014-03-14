/*
 * �������� 2010-7-31
 *
 */
package model.formVO;

/****
 * query database by user criteria
 * producer, car name, power range, good LPM range, bad LPM range 
 * *****/
public class CarQueryObj
{
	public CarQueryObj(){}
	
	private String prodcerName = null;
	private String carName = null;
	private float powerLower=-1;
	private float powerHigh =-1;
	private float goodLPMLower=-1;
	private float goodLPMHigh=-1;
	private float badLPMLower=-1;
	private float badLPMHigh=-1;
	private int pageSize=20;
	private String trans = "";
	
	public String getTrans()
	{
		return trans;
	}
	public void setTrans(String trans)
	{
		this.trans = trans;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public float getBadLPMHigh()
	{
		return badLPMHigh;
	}
	public void setBadLPMHigh(float badLPMHigh)
	{
		this.badLPMHigh = badLPMHigh;
	}
	public String getProdcerName()
	{
		return prodcerName;
	}
	public void setProdcerName(String prodcerName)
	{
		if ("全部汽车厂商".equalsIgnoreCase(prodcerName))
		{
			this.prodcerName = null;
		} else
		{
			this.prodcerName = prodcerName;
		}
	}
	public String getCarName()
	{
		return carName;
	}
	public void setCarName(String carName)
	{
		if ("全部车型".equalsIgnoreCase(carName))
		{
			this.carName = null;
		} else
		{
			this.carName = carName;
		}
	}
	public float getPowerLower()
	{
		return powerLower;
	}
	public void setPowerLower(float powerLower)
	{
		this.powerLower = powerLower*1000-30;
	}
	public float getPowerHigh()
	{
		return powerHigh;
	}
	public void setPowerHigh(float powerHigh)
	{
		this.powerHigh = powerHigh*1000+30;
	}
	public float getGoodLPMLower()
	{
		return goodLPMLower;
	}
	public void setGoodLPMLower(float goodLPMLower)
	{
		this.goodLPMLower = goodLPMLower;
	}
	public float getGoodLPMHigh()
	{
		return goodLPMHigh;
	}
	public void setGoodLPMHigh(float goodLPMHigh)
	{
		this.goodLPMHigh = goodLPMHigh;
	}
	public float getBadLPMLower()
	{
		return badLPMLower;
	}
	public void setBadLPMLower(float badLPMLower)
	{
		this.badLPMLower = badLPMLower;
	}


	
}
