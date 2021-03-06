package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    public ReportExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    protected ReportExample(ReportExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
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
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table statistics
     *
     * @ibatorgenerated Sun Jul 19 10:24:15 CST 2009
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

        public Criteria andTotalGasIsNull() {
            addCriterion("totalGas is null");
            return this;
        }

        public Criteria andTotalGasIsNotNull() {
            addCriterion("totalGas is not null");
            return this;
        }

        public Criteria andTotalGasEqualTo(Float value) {
            addCriterion("totalGas =", value, "totalGas");
            return this;
        }

        public Criteria andTotalGasNotEqualTo(Float value) {
            addCriterion("totalGas <>", value, "totalGas");
            return this;
        }

        public Criteria andTotalGasGreaterThan(Float value) {
            addCriterion("totalGas >", value, "totalGas");
            return this;
        }

        public Criteria andTotalGasGreaterThanOrEqualTo(Float value) {
            addCriterion("totalGas >=", value, "totalGas");
            return this;
        }

        public Criteria andTotalGasLessThan(Float value) {
            addCriterion("totalGas <", value, "totalGas");
            return this;
        }

        public Criteria andTotalGasLessThanOrEqualTo(Float value) {
            addCriterion("totalGas <=", value, "totalGas");
            return this;
        }

        public Criteria andTotalGasIn(List values) {
            addCriterion("totalGas in", values, "totalGas");
            return this;
        }

        public Criteria andTotalGasNotIn(List values) {
            addCriterion("totalGas not in", values, "totalGas");
            return this;
        }

        public Criteria andTotalGasBetween(Float value1, Float value2) {
            addCriterion("totalGas between", value1, value2, "totalGas");
            return this;
        }

        public Criteria andTotalGasNotBetween(Float value1, Float value2) {
            addCriterion("totalGas not between", value1, value2, "totalGas");
            return this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("totalFee is null");
            return this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("totalFee is not null");
            return this;
        }

        public Criteria andTotalFeeEqualTo(Float value) {
            addCriterion("totalFee =", value, "totalFee");
            return this;
        }

        public Criteria andTotalFeeNotEqualTo(Float value) {
            addCriterion("totalFee <>", value, "totalFee");
            return this;
        }

        public Criteria andTotalFeeGreaterThan(Float value) {
            addCriterion("totalFee >", value, "totalFee");
            return this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("totalFee >=", value, "totalFee");
            return this;
        }

        public Criteria andTotalFeeLessThan(Float value) {
            addCriterion("totalFee <", value, "totalFee");
            return this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Float value) {
            addCriterion("totalFee <=", value, "totalFee");
            return this;
        }

        public Criteria andTotalFeeIn(List values) {
            addCriterion("totalFee in", values, "totalFee");
            return this;
        }

        public Criteria andTotalFeeNotIn(List values) {
            addCriterion("totalFee not in", values, "totalFee");
            return this;
        }

        public Criteria andTotalFeeBetween(Float value1, Float value2) {
            addCriterion("totalFee between", value1, value2, "totalFee");
            return this;
        }

        public Criteria andTotalFeeNotBetween(Float value1, Float value2) {
            addCriterion("totalFee not between", value1, value2, "totalFee");
            return this;
        }

        public Criteria andRecordeddayIsNull() {
            addCriterion("recordedday is null");
            return this;
        }

        public Criteria andRecordeddayIsNotNull() {
            addCriterion("recordedday is not null");
            return this;
        }

        public Criteria andRecordeddayEqualTo(Short value) {
            addCriterion("recordedday =", value, "recordedday");
            return this;
        }

        public Criteria andRecordeddayNotEqualTo(Short value) {
            addCriterion("recordedday <>", value, "recordedday");
            return this;
        }

        public Criteria andRecordeddayGreaterThan(Short value) {
            addCriterion("recordedday >", value, "recordedday");
            return this;
        }

        public Criteria andRecordeddayGreaterThanOrEqualTo(Short value) {
            addCriterion("recordedday >=", value, "recordedday");
            return this;
        }

        public Criteria andRecordeddayLessThan(Short value) {
            addCriterion("recordedday <", value, "recordedday");
            return this;
        }

        public Criteria andRecordeddayLessThanOrEqualTo(Short value) {
            addCriterion("recordedday <=", value, "recordedday");
            return this;
        }

        public Criteria andRecordeddayIn(List values) {
            addCriterion("recordedday in", values, "recordedday");
            return this;
        }

        public Criteria andRecordeddayNotIn(List values) {
            addCriterion("recordedday not in", values, "recordedday");
            return this;
        }

        public Criteria andRecordeddayBetween(Short value1, Short value2) {
            addCriterion("recordedday between", value1, value2, "recordedday");
            return this;
        }

        public Criteria andRecordeddayNotBetween(Short value1, Short value2) {
            addCriterion("recordedday not between", value1, value2, "recordedday");
            return this;
        }

        public Criteria andAvgGasPriceIsNull() {
            addCriterion("avgGasPrice is null");
            return this;
        }

        public Criteria andAvgGasPriceIsNotNull() {
            addCriterion("avgGasPrice is not null");
            return this;
        }

        public Criteria andAvgGasPriceEqualTo(Float value) {
            addCriterion("avgGasPrice =", value, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceNotEqualTo(Float value) {
            addCriterion("avgGasPrice <>", value, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceGreaterThan(Float value) {
            addCriterion("avgGasPrice >", value, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("avgGasPrice >=", value, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceLessThan(Float value) {
            addCriterion("avgGasPrice <", value, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceLessThanOrEqualTo(Float value) {
            addCriterion("avgGasPrice <=", value, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceIn(List values) {
            addCriterion("avgGasPrice in", values, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceNotIn(List values) {
            addCriterion("avgGasPrice not in", values, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceBetween(Float value1, Float value2) {
            addCriterion("avgGasPrice between", value1, value2, "avgGasPrice");
            return this;
        }

        public Criteria andAvgGasPriceNotBetween(Float value1, Float value2) {
            addCriterion("avgGasPrice not between", value1, value2, "avgGasPrice");
            return this;
        }

        public Criteria andMilesPerDayIsNull() {
            addCriterion("milesPerDay is null");
            return this;
        }

        public Criteria andMilesPerDayIsNotNull() {
            addCriterion("milesPerDay is not null");
            return this;
        }

        public Criteria andMilesPerDayEqualTo(Integer value) {
            addCriterion("milesPerDay =", value, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayNotEqualTo(Integer value) {
            addCriterion("milesPerDay <>", value, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayGreaterThan(Integer value) {
            addCriterion("milesPerDay >", value, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("milesPerDay >=", value, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayLessThan(Integer value) {
            addCriterion("milesPerDay <", value, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayLessThanOrEqualTo(Integer value) {
            addCriterion("milesPerDay <=", value, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayIn(List values) {
            addCriterion("milesPerDay in", values, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayNotIn(List values) {
            addCriterion("milesPerDay not in", values, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayBetween(Integer value1, Integer value2) {
            addCriterion("milesPerDay between", value1, value2, "milesPerDay");
            return this;
        }

        public Criteria andMilesPerDayNotBetween(Integer value1, Integer value2) {
            addCriterion("milesPerDay not between", value1, value2, "milesPerDay");
            return this;
        }

        public Criteria andAvgLPMIsNull() {
            addCriterion("avgLPM is null");
            return this;
        }

        public Criteria andAvgLPMIsNotNull() {
            addCriterion("avgLPM is not null");
            return this;
        }

        public Criteria andAvgLPMEqualTo(Float value) {
            addCriterion("avgLPM =", value, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMNotEqualTo(Float value) {
            addCriterion("avgLPM <>", value, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMGreaterThan(Float value) {
            addCriterion("avgLPM >", value, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMGreaterThanOrEqualTo(Float value) {
            addCriterion("avgLPM >=", value, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMLessThan(Float value) {
            addCriterion("avgLPM <", value, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMLessThanOrEqualTo(Float value) {
            addCriterion("avgLPM <=", value, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMIn(List values) {
            addCriterion("avgLPM in", values, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMNotIn(List values) {
            addCriterion("avgLPM not in", values, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMBetween(Float value1, Float value2) {
            addCriterion("avgLPM between", value1, value2, "avgLPM");
            return this;
        }

        public Criteria andAvgLPMNotBetween(Float value1, Float value2) {
            addCriterion("avgLPM not between", value1, value2, "avgLPM");
            return this;
        }

        public Criteria andAvgFeeIsNull() {
            addCriterion("avgFee is null");
            return this;
        }

        public Criteria andAvgFeeIsNotNull() {
            addCriterion("avgFee is not null");
            return this;
        }

        public Criteria andAvgFeeEqualTo(Float value) {
            addCriterion("avgFee =", value, "avgFee");
            return this;
        }

        public Criteria andAvgFeeNotEqualTo(Float value) {
            addCriterion("avgFee <>", value, "avgFee");
            return this;
        }

        public Criteria andAvgFeeGreaterThan(Float value) {
            addCriterion("avgFee >", value, "avgFee");
            return this;
        }

        public Criteria andAvgFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("avgFee >=", value, "avgFee");
            return this;
        }

        public Criteria andAvgFeeLessThan(Float value) {
            addCriterion("avgFee <", value, "avgFee");
            return this;
        }

        public Criteria andAvgFeeLessThanOrEqualTo(Float value) {
            addCriterion("avgFee <=", value, "avgFee");
            return this;
        }

        public Criteria andAvgFeeIn(List values) {
            addCriterion("avgFee in", values, "avgFee");
            return this;
        }

        public Criteria andAvgFeeNotIn(List values) {
            addCriterion("avgFee not in", values, "avgFee");
            return this;
        }

        public Criteria andAvgFeeBetween(Float value1, Float value2) {
            addCriterion("avgFee between", value1, value2, "avgFee");
            return this;
        }

        public Criteria andAvgFeeNotBetween(Float value1, Float value2) {
            addCriterion("avgFee not between", value1, value2, "avgFee");
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

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return this;
        }

        public Criteria andTimestampIn(List values) {
            addCriterion("timestamp in", values, "timestamp");
            return this;
        }

        public Criteria andTimestampNotIn(List values) {
            addCriterion("timestamp not in", values, "timestamp");
            return this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
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
    }
}