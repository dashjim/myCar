<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="service.tool.Cfg"%>
<%@page import="model.User"%>


superML.net<br/>
<b class="green">超级玛丽手机油耗</b>
	<br><br>
<div class="pm">
	你好<%
		User u = (User)session.getAttribute(Cfg.JSP.LOGIN_USER_VO); 
		if(u!=null){out.print(u.getName());}
		else{response.sendRedirect(request.getContextPath() + Cfg.JSP.PAGE_LOGIN);}//go to login
	%>
	<a href="<%=request.getContextPath() + Cfg.SERVLET.NAME_USER_FACE%>?action=forwardToInput">新输入</a>
	<a href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT%>">报表</a>
	<a href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT_TWOLINE_CHART%>">趋势图</a>
	<a href="<%=request.getContextPath() + Cfg.JSP.PAGE_LOGIN%>?action=deleteCookie">重登录</a>
</div>