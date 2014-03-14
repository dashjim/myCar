/*
 * 创建日期 2009-6-8
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
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
 