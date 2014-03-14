/*
 * �������� 2009-3-22
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package dao.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.ibator.api.Ibator;
import org.apache.ibatis.ibator.config.IbatorConfiguration;
import org.apache.ibatis.ibator.config.xml.IbatorConfigurationParser;
import org.apache.ibatis.ibator.internal.DefaultShellCallback;

public class ibatorRuner {

	public static void main(String[] args) throws Exception {
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = false;
		   File configFile = new File(System.getProperty("user.dir")+"\\src\\dao\\config\\ibatorConfig.xml");
		   IbatorConfigurationParser cp = new IbatorConfigurationParser(warnings);
		   IbatorConfiguration config = cp.parseIbatorConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   Ibator ibator = new Ibator(config, callback, warnings);
		   ibator.generate(null);
		   System.out.println(System.getProperty("user.dir"));
		   System.out.println(warnings+"OK");
	}
}
