<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="service.tool.Cfg"%>
    <%@page import="servlet.UserFace"%>
    <%@page import="service.tool.CookieHelper"%>
    <%
    	/**log out?*/
    	if("deleteCookie".equals(request.getParameter("action")))
    	{
	    	CookieHelper.deleteCookie(request, response);
    	}else{
	    	/**log in form cookie?*/ 
	    	String cookie = CookieHelper.getNamePwdCookie(request, response);		
	    	if(!CookieHelper.COOKIE_SPLITER.equals(cookie)&& null!=cookie)
	    	{
	    		UserFace userFace = new UserFace();	
	    		userFace.doCookieLogin(request, response);
	    	}
    	}
    %>

<html>

	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/m/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>

<body>
superML.net<br/><br/>
<b class="green">欢迎来到超级玛丽手机油耗</b><br><br>
	<b>&nbsp;节油从今天开始.</b>
	<br>

	<form action="<%= request.getContextPath()+ Cfg.SERVLET.NAME_USER_FACE%>" method="post">
	 <font color="red">${requestScope.errorMsg}<br/></font>
		<input name="action" type="hidden" value="login" />
		登录到：<br/>
		<input type="radio" name="loginTarget" value="input"/>输入油耗
		<input type="radio" checked="checked" name="loginTarget" value="show"/>显示记录
		<br/><br/>
		
		用户名：<input name="name" type="text" value="${param.name}" size="10" maxlength="20" />
		<br />
		<br />密码：<input name="pwd" type="password" size="10" maxlength="10" /><br/><br/>
		
		<input type="submit" name="Submit" value="确定" /><br/><br/>
		<input type="checkbox" name="createNewUser" value="newUser"/>用上面的用户名密码注册新用户
		
	</form>
	<jsp:include page="/m/footer.jsp" flush="true" />
</body>


</html>