/*
 * �������� 2009-6-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package service.interfaces;

import java.util.List;
import java.util.Map;
import model.GasRcd;

public interface GasRecordsServiceI 
{
	public List<GasRcd> getRcdForName(String userName, String lineNumber);
	
	public boolean saveRcd(GasRcd record);
}
 