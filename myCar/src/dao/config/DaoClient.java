/*
 * �������� 2009-3-25
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package dao.config;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DaoClient {
	 private static final SqlMapClient sqlMap;

	    //�ھ�̬�����г��Ի�����
	    static {
	        try {

	            //���������ļ������ƣ�ӳ���ļ������������У�
//	            String resource = System.getProperty("user.dir")+"\\src\\dao\\config\\SqlMapConfig.xml";

	        	String resource = "dao/config/SqlMapConfig.xml";
	        	
	            //���ù�����Resources����ȡ�������ļ�
	            Reader reader = Resources.getResourceAsReader(resource);

	            //����SqlMapClient�ӿڵı���ʵ��
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
	    	
	        //�ṩ��̬�������ؾ�̬�����еõ���SqlMapClient
	        return sqlMap;
	    }
}
