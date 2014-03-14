package dao;

import java.sql.SQLException;
import java.util.List;
import model.Car;
import model.CarExample;

public interface CarDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int countByExample(CarExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int deleteByExample(CarExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int deleteByPrimaryKey(Integer id) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    void insert(Car record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    void insertSelective(Car record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    List selectByExample(CarExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    Car selectByPrimaryKey(Integer id) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int updateByExampleSelective(Car record, CarExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int updateByExample(Car record, CarExample example) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int updateByPrimaryKeySelective(Car record) throws SQLException;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table cars
     *
     * @ibatorgenerated Sun Jul 12 22:13:41 CST 2009
     */
    int updateByPrimaryKey(Car record) throws SQLException;
}