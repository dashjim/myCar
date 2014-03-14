/***********************************************************************
 * Module:  Statistics.java
 * Author:  fairy
 * Purpose: Defines the Class Statistics
 ***********************************************************************/
package model;

public class Statistic {
   public int totalDistance;
   public float totalGas;
   public float totalFee;
   public short recordedday;
   public float avgGasPrice;
   public int milesPerDay;
   public float avgLPM;
   public int getTotalDistance() {
	return totalDistance;
}
public void setTotalDistance(int totalDistance) {
	this.totalDistance = totalDistance;
}
public float getTotalGas() {
	return totalGas;
}
public void setTotalGas(float totalGas) {
	this.totalGas = totalGas;
}
public float getTotalFee() {
	return totalFee;
}
public void setTotalFee(float totalFee) {
	this.totalFee = totalFee;
}
public short getRecordedday() {
	return recordedday;
}
public void setRecordedday(short recordedday) {
	this.recordedday = recordedday;
}
public float getAvgGasPrice() {
	return avgGasPrice;
}
public void setAvgGasPrice(float avgGasPrice) {
	this.avgGasPrice = avgGasPrice;
}
public int getMilesPerDay() {
	return milesPerDay;
}
public void setMilesPerDay(int milesPerDay) {
	this.milesPerDay = milesPerDay;
}
public float getAvgLPM() {
	return avgLPM;
}
public void setAvgLPM(float avgLPM) {
	this.avgLPM = avgLPM;
}
public float getAvgFee() {
	return avgFee;
}
public void setAvgFee(float avgFee) {
	this.avgFee = avgFee;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public java.util.Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(java.util.Date timestamp) {
	this.timestamp = timestamp;
}
public float avgFee;
   public int id;
   public int userId;
   public java.util.Date timestamp;

}