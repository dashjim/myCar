package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GasRcdExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public GasRcdExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    protected GasRcdExample(GasRcdExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table gasrcds
     *
     * @ibatorgenerated Sun Jul 19 10:32:13 CST 2009
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;
        }

        public Criteria andFueledTimeIsNull() {
            addCriterion("fueledTime is null");
            return this;
        }

        public Criteria andFueledTimeIsNotNull() {
            addCriterion("fueledTime is not null");
            return this;
        }

        public Criteria andFueledTimeEqualTo(Date value) {
            addCriterion("fueledTime =", value, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeNotEqualTo(Date value) {
            addCriterion("fueledTime <>", value, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeGreaterThan(Date value) {
            addCriterion("fueledTime >", value, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fueledTime >=", value, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeLessThan(Date value) {
            addCriterion("fueledTime <", value, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeLessThanOrEqualTo(Date value) {
            addCriterion("fueledTime <=", value, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeIn(List values) {
            addCriterion("fueledTime in", values, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeNotIn(List values) {
            addCriterion("fueledTime not in", values, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeBetween(Date value1, Date value2) {
            addCriterion("fueledTime between", value1, value2, "fueledTime");
            return this;
        }

        public Criteria andFueledTimeNotBetween(Date value1, Date value2) {
            addCriterion("fueledTime not between", value1, value2, "fueledTime");
            return this;
        }

        public Criteria andTimeStampIsNull() {
            addCriterion("timeStamp is null");
            return this;
        }

        public Criteria andTimeStampIsNotNull() {
            addCriterion("timeStamp is not null");
            return this;
        }

        public Criteria andTimeStampEqualTo(Date value) {
            addCriterion("timeStamp =", value, "timeStamp");
            return this;
        }

        public Criteria andTimeStampNotEqualTo(Date value) {
            addCriterion("timeStamp <>", value, "timeStamp");
            return this;
        }

        public Criteria andTimeStampGreaterThan(Date value) {
            addCriterion("timeStamp >", value, "timeStamp");
            return this;
        }

        public Criteria andTimeStampGreaterThanOrEqualTo(Date value) {
            addCriterion("timeStamp >=", value, "timeStamp");
            return this;
        }

        public Criteria andTimeStampLessThan(Date value) {
            addCriterion("timeStamp <", value, "timeStamp");
            return this;
        }

        public Criteria andTimeStampLessThanOrEqualTo(Date value) {
            addCriterion("timeStamp <=", value, "timeStamp");
            return this;
        }

        public Criteria andTimeStampIn(List values) {
            addCriterion("timeStamp in", values, "timeStamp");
            return this;
        }

        public Criteria andTimeStampNotIn(List values) {
            addCriterion("timeStamp not in", values, "timeStamp");
            return this;
        }

        public Criteria andTimeStampBetween(Date value1, Date value2) {
            addCriterion("timeStamp between", value1, value2, "timeStamp");
            return this;
        }

        public Criteria andTimeStampNotBetween(Date value1, Date value2) {
            addCriterion("timeStamp not between", value1, value2, "timeStamp");
            return this;
        }

        public Criteria andTotalDistanceIsNull() {
            addCriterion("totalDistance is null");
            return this;
        }

        public Criteria andTotalDistanceIsNotNull() {
            addCriterion("totalDistance is not null");
            return this;
        }

        public Criteria andTotalDistanceEqualTo(Integer value) {
            addCriterion("totalDistance =", value, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceNotEqualTo(Integer value) {
            addCriterion("totalDistance <>", value, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceGreaterThan(Integer value) {
            addCriterion("totalDistance >", value, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalDistance >=", value, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceLessThan(Integer value) {
            addCriterion("totalDistance <", value, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("totalDistance <=", value, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceIn(List values) {
            addCriterion("totalDistance in", values, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceNotIn(List values) {
            addCriterion("totalDistance not in", values, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceBetween(Integer value1, Integer value2) {
            addCriterion("totalDistance between", value1, value2, "totalDistance");
            return this;
        }

        public Criteria andTotalDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("totalDistance not between", value1, value2, "totalDistance");
            return this;
        }

        public Criteria andLastDistanceIsNull() {
            addCriterion("lastDistance is null");
            return this;
        }

        public Criteria andLastDistanceIsNotNull() {
            addCriterion("lastDistance is not null");
            return this;
        }

        public Criteria andLastDistanceEqualTo(Short value) {
            addCriterion("lastDistance =", value, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceNotEqualTo(Short value) {
            addCriterion("lastDistance <>", value, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceGreaterThan(Short value) {
            addCriterion("lastDistance >", value, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceGreaterThanOrEqualTo(Short value) {
            addCriterion("lastDistance >=", value, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceLessThan(Short value) {
            addCriterion("lastDistance <", value, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceLessThanOrEqualTo(Short value) {
            addCriterion("lastDistance <=", value, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceIn(List values) {
            addCriterion("lastDistance in", values, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceNotIn(List values) {
            addCriterion("lastDistance not in", values, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceBetween(Short value1, Short value2) {
            addCriterion("lastDistance between", value1, value2, "lastDistance");
            return this;
        }

        public Criteria andLastDistanceNotBetween(Short value1, Short value2) {
            addCriterion("lastDistance not between", value1, value2, "lastDistance");
            return this;
        }

        public Criteria andFueledVolumIsNull() {
            addCriterion("fueledVolum is null");
            return this;
        }

        public Criteria andFueledVolumIsNotNull() {
            addCriterion("fueledVolum is not null");
            return this;
        }

        public Criteria andFueledVolumEqualTo(Float value) {
            addCriterion("fueledVolum =", value, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumNotEqualTo(Float value) {
            addCriterion("fueledVolum <>", value, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumGreaterThan(Float value) {
            addCriterion("fueledVolum >", value, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumGreaterThanOrEqualTo(Float value) {
            addCriterion("fueledVolum >=", value, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumLessThan(Float value) {
            addCriterion("fueledVolum <", value, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumLessThanOrEqualTo(Float value) {
            addCriterion("fueledVolum <=", value, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumIn(List values) {
            addCriterion("fueledVolum in", values, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumNotIn(List values) {
            addCriterion("fueledVolum not in", values, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumBetween(Float value1, Float value2) {
            addCriterion("fueledVolum between", value1, value2, "fueledVolum");
            return this;
        }

        public Criteria andFueledVolumNotBetween(Float value1, Float value2) {
            addCriterion("fueledVolum not between", value1, value2, "fueledVolum");
            return this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("money =", value, "money");
            return this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("money <>", value, "money");
            return this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("money >", value, "money");
            return this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("money >=", value, "money");
            return this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("money <", value, "money");
            return this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("money <=", value, "money");
            return this;
        }

        public Criteria andMoneyIn(List values) {
            addCriterion("money in", values, "money");
            return this;
        }

        public Criteria andMoneyNotIn(List values) {
            addCriterion("money not in", values, "money");
            return this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("money between", value1, value2, "money");
            return this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("money not between", value1, value2, "money");
            return this;
        }

        public Criteria andIsFullIsNull() {
            addCriterion("isFull is null");
            return this;
        }

        public Criteria andIsFullIsNotNull() {
            addCriterion("isFull is not null");
            return this;
        }

        public Criteria andIsFullEqualTo(Boolean value) {
            addCriterion("isFull =", value, "isFull");
            return this;
        }

        public Criteria andIsFullNotEqualTo(Boolean value) {
            addCriterion("isFull <>", value, "isFull");
            return this;
        }

        public Criteria andIsFullGreaterThan(Boolean value) {
            addCriterion("isFull >", value, "isFull");
            return this;
        }

        public Criteria andIsFullGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isFull >=", value, "isFull");
            return this;
        }

        public Criteria andIsFullLessThan(Boolean value) {
            addCriterion("isFull <", value, "isFull");
            return this;
        }

        public Criteria andIsFullLessThanOrEqualTo(Boolean value) {
            addCriterion("isFull <=", value, "isFull");
            return this;
        }

        public Criteria andIsFullIn(List values) {
            addCriterion("isFull in", values, "isFull");
            return this;
        }

        public Criteria andIsFullNotIn(List values) {
            addCriterion("isFull not in", values, "isFull");
            return this;
        }

        public Criteria andIsFullBetween(Boolean value1, Boolean value2) {
            addCriterion("isFull between", value1, value2, "isFull");
            return this;
        }

        public Criteria andIsFullNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isFull not between", value1, value2, "isFull");
            return this;
        }

        public Criteria andLPMIsNull() {
            addCriterion("LPM is null");
            return this;
        }

        public Criteria andLPMIsNotNull() {
            addCriterion("LPM is not null");
            return this;
        }

        public Criteria andLPMEqualTo(Float value) {
            addCriterion("LPM =", value, "LPM");
            return this;
        }

        public Criteria andLPMNotEqualTo(Float value) {
            addCriterion("LPM <>", value, "LPM");
            return this;
        }

        public Criteria andLPMGreaterThan(Float value) {
            addCriterion("LPM >", value, "LPM");
            return this;
        }

        public Criteria andLPMGreaterThanOrEqualTo(Float value) {
            addCriterion("LPM >=", value, "LPM");
            return this;
        }

        public Criteria andLPMLessThan(Float value) {
            addCriterion("LPM <", value, "LPM");
            return this;
        }

        public Criteria andLPMLessThanOrEqualTo(Float value) {
            addCriterion("LPM <=", value, "LPM");
            return this;
        }

        public Criteria andLPMIn(List values) {
            addCriterion("LPM in", values, "LPM");
            return this;
        }

        public Criteria andLPMNotIn(List values) {
            addCriterion("LPM not in", values, "LPM");
            return this;
        }

        public Criteria andLPMBetween(Float value1, Float value2) {
            addCriterion("LPM between", value1, value2, "LPM");
            return this;
        }

        public Criteria andLPMNotBetween(Float value1, Float value2) {
            addCriterion("LPM not between", value1, value2, "LPM");
            return this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return this;
        }

        public Criteria andPlaceIn(List values) {
            addCriterion("place in", values, "place");
            return this;
        }

        public Criteria andPlaceNotIn(List values) {
            addCriterion("place not in", values, "place");
            return this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return this;
        }

        public Criteria andRoadTypeIsNull() {
            addCriterion("roadType is null");
            return this;
        }

        public Criteria andRoadTypeIsNotNull() {
            addCriterion("roadType is not null");
            return this;
        }

        public Criteria andRoadTypeEqualTo(String value) {
            addCriterion("roadType =", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeNotEqualTo(String value) {
            addCriterion("roadType <>", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeGreaterThan(String value) {
            addCriterion("roadType >", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeGreaterThanOrEqualTo(String value) {
            addCriterion("roadType >=", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeLessThan(String value) {
            addCriterion("roadType <", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeLessThanOrEqualTo(String value) {
            addCriterion("roadType <=", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeLike(String value) {
            addCriterion("roadType like", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeNotLike(String value) {
            addCriterion("roadType not like", value, "roadType");
            return this;
        }

        public Criteria andRoadTypeIn(List values) {
            addCriterion("roadType in", values, "roadType");
            return this;
        }

        public Criteria andRoadTypeNotIn(List values) {
            addCriterion("roadType not in", values, "roadType");
            return this;
        }

        public Criteria andRoadTypeBetween(String value1, String value2) {
            addCriterion("roadType between", value1, value2, "roadType");
            return this;
        }

        public Criteria andRoadTypeNotBetween(String value1, String value2) {
            addCriterion("roadType not between", value1, value2, "roadType");
            return this;
        }

        public Criteria andGasTypeIsNull() {
            addCriterion("gasType is null");
            return this;
        }

        public Criteria andGasTypeIsNotNull() {
            addCriterion("gasType is not null");
            return this;
        }

        public Criteria andGasTypeEqualTo(String value) {
            addCriterion("gasType =", value, "gasType");
            return this;
        }

        public Criteria andGasTypeNotEqualTo(String value) {
            addCriterion("gasType <>", value, "gasType");
            return this;
        }

        public Criteria andGasTypeGreaterThan(String value) {
            addCriterion("gasType >", value, "gasType");
            return this;
        }

        public Criteria andGasTypeGreaterThanOrEqualTo(String value) {
            addCriterion("gasType >=", value, "gasType");
            return this;
        }

        public Criteria andGasTypeLessThan(String value) {
            addCriterion("gasType <", value, "gasType");
            return this;
        }

        public Criteria andGasTypeLessThanOrEqualTo(String value) {
            addCriterion("gasType <=", value, "gasType");
            return this;
        }

        public Criteria andGasTypeLike(String value) {
            addCriterion("gasType like", value, "gasType");
            return this;
        }

        public Criteria andGasTypeNotLike(String value) {
            addCriterion("gasType not like", value, "gasType");
            return this;
        }

        public Criteria andGasTypeIn(List values) {
            addCriterion("gasType in", values, "gasType");
            return this;
        }

        public Criteria andGasTypeNotIn(List values) {
            addCriterion("gasType not in", values, "gasType");
            return this;
        }

        public Criteria andGasTypeBetween(String value1, String value2) {
            addCriterion("gasType between", value1, value2, "gasType");
            return this;
        }

        public Criteria andGasTypeNotBetween(String value1, String value2) {
            addCriterion("gasType not between", value1, value2, "gasType");
            return this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return this;
        }

        public Criteria andCommentIn(List values) {
            addCriterion("comment in", values, "comment");
            return this;
        }

        public Criteria andCommentNotIn(List values) {
            addCriterion("comment not in", values, "comment");
            return this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return this;
        }

        public Criteria andUserIdIn(List values) {
            addCriterion("userId in", values, "userId");
            return this;
        }

        public Criteria andUserIdNotIn(List values) {
            addCriterion("userId not in", values, "userId");
            return this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return this;
        }

        public Criteria andLastFueledTimeIsNull() {
            addCriterion("lastFueledTime is null");
            return this;
        }

        public Criteria andLastFueledTimeIsNotNull() {
            addCriterion("lastFueledTime is not null");
            return this;
        }

        public Criteria andLastFueledTimeEqualTo(Date value) {
            addCriterion("lastFueledTime =", value, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeNotEqualTo(Date value) {
            addCriterion("lastFueledTime <>", value, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeGreaterThan(Date value) {
            addCriterion("lastFueledTime >", value, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastFueledTime >=", value, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeLessThan(Date value) {
            addCriterion("lastFueledTime <", value, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastFueledTime <=", value, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeIn(List values) {
            addCriterion("lastFueledTime in", values, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeNotIn(List values) {
            addCriterion("lastFueledTime not in", values, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeBetween(Date value1, Date value2) {
            addCriterion("lastFueledTime between", value1, value2, "lastFueledTime");
            return this;
        }

        public Criteria andLastFueledTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastFueledTime not between", value1, value2, "lastFueledTime");
            return this;
        }
    }
}