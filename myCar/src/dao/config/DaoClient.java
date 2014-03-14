/*
 * 创建日期 2009-3-25
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package dao.config;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DaoClient {
	 private static final SqlMapClient sqlMap;

	    //在静态区块中初试化返回
	    static {
	        try {

	            //声明配置文件的名称（映射文件被定义在其中）
//	            String resource = System.getProperty("user.dir")+"\\src\\dao\\config\\SqlMapConfig.xml";

	        	String resource = "dao/config/SqlMapConfig.xml";
	        	
	            //利用工具类Resources来读取到配置文件
	            Reader reader = Resources.getResourceAsReader(resource);

	            //创建SqlMapClient接口的变量实例
	            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	            reader.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(
	                    "Error initializing MyAppSqlConfig class. Cause: " + e);
	        }
	    }
	    
	    /**
	     * thread safe object!!!
	     * @return
	     */
	    public static SqlMapClient getSqlMapInstance() {
	    	
	        //提供静态方法返回静态区块中得到的SqlMapClient
	        return sqlMap;
	    }
}
