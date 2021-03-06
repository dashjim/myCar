package model;

import java.util.Date;

public class Car {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.id
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private Integer id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.producer
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private String producer;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.model
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private String model;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.priceLevel
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private Short priceLevel;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.Year
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private Date year;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.isMt
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private Boolean isMt;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.paiLiang
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private String paiLiang;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.avgLPM
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private Byte avgLPM;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column cars.hybrid
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    private String hybrid;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.id
     *
     * @return the value of cars.id
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.id
     *
     * @param id the value for cars.id
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.producer
     *
     * @return the value of cars.producer
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public String getProducer() {
        return producer;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.producer
     *
     * @param producer the value for cars.producer
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.model
     *
     * @return the value of cars.model
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.model
     *
     * @param model the value for cars.model
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.priceLevel
     *
     * @return the value of cars.priceLevel
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public Short getPriceLevel() {
        return priceLevel;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.priceLevel
     *
     * @param priceLevel the value for cars.priceLevel
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setPriceLevel(Short priceLevel) {
        this.priceLevel = priceLevel;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.Year
     *
     * @return the value of cars.Year
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public Date getYear() {
        return year;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.Year
     *
     * @param year the value for cars.Year
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.isMt
     *
     * @return the value of cars.isMt
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public Boolean getIsMt() {
        return isMt;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.isMt
     *
     * @param isMt the value for cars.isMt
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setIsMt(Boolean isMt) {
        this.isMt = isMt;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.paiLiang
     *
     * @return the value of cars.paiLiang
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public String getPaiLiang() {
        return paiLiang;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.paiLiang
     *
     * @param paiLiang the value for cars.paiLiang
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setPaiLiang(String paiLiang) {
        this.paiLiang = paiLiang == null ? null : paiLiang.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.avgLPM
     *
     * @return the value of cars.avgLPM
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public Byte getAvgLPM() {
        return avgLPM;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.avgLPM
     *
     * @param avgLPM the value for cars.avgLPM
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setAvgLPM(Byte avgLPM) {
        this.avgLPM = avgLPM;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column cars.hybrid
     *
     * @return the value of cars.hybrid
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public String getHybrid() {
        return hybrid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column cars.hybrid
     *
     * @param hybrid the value for cars.hybrid
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    public void setHybrid(String hybrid) {
        this.hybrid = hybrid == null ? null : hybrid.trim();
    }
}