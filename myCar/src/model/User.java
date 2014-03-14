/***********************************************************************
 * Module:  Users.java
 * Author:  fairy
 * Purpose: Defines the Class Users
 ***********************************************************************/
package model;

import com.thoughtworks.xstream.XStream;

public class User {
	private java.lang.String name;
	private String driveYear;
	private java.lang.String pwd;
	private java.lang.String email;
	private String carID;
	/**
	 * we can use the user ID as image ID first. 
	 */
	private java.lang.String img;
	private int id;
	private java.util.Date createTime;
	private String level;
	private String loginTimes;
	private java.util.Date lastTimeLogin;
	
	public static final XStream XMLCONVERTER = new XStream();
	
	public User() {	}

	//////////////// domain methods ////////////////////
	
	public String toXML() {
		
		XMLCONVERTER.alias("user", User.class);
		return XMLCONVERTER.toXML(this); 
	}
	
	
	////////////////////////// getter and setters////////////
	
	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getPwd() {
		return pwd;
	}

	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getImg() {
		return img;
	}

	public void setImg(java.lang.String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	public String getDriveYear() {
		return driveYear;
	}

	public void setDriveYear(String driveYear) {
		this.driveYear = driveYear;
	}
	public String getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}

	public java.util.Date getLastTimeLogin() {
		return lastTimeLogin;
	}

	public void setLastTimeLogin(java.util.Date lastTimeLogin) {
		this.lastTimeLogin = lastTimeLogin;
	}

}