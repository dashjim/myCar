/*
 * �������� 2010-8-8
 *
 */
package filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * not in use now.
 * @author CofeMate
 *
 */
public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper
{
	  private String charset = "UTF-8";  
	   
	     public GetHttpServletRequestWrapper(HttpServletRequest request) {  
	         super(request);  
	     }  
	   
	     /** 
	      * ��ñ�װ�ζ�������úͲ��õ��ַ����� 
	      * @param request 
	      * @param charset 
	      */  
	     public GetHttpServletRequestWrapper(HttpServletRequest request,  
	             String charset) {  
	         super(request);  
	         this.charset = charset;  
	     }  
	   
	     /** 
	      * ʵ���Ͼ��ǵ��ñ���װ����������getParameter������ò�����Ȼ���ٽ��б���ת�� 
	      */  
	     public String getParameter(String name) {  
	         String value = super.getParameter(name);  
	         value = value == null ? null : convert(value);  
	         return value;  
	     }  
	   
	     public String convert(String target) {  
	         System.out.println("����ת��֮ǰ��" + target);  
	         try {  
	             return new String(target.trim().getBytes("ISO-8859-1"), charset);  
	         } catch (UnsupportedEncodingException e) {  
	             return target;  
	         }  
	     }  
}
