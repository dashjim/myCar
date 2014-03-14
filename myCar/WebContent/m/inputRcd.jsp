<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@page import="model.GasRcd"%>
<%@page import="service.tool.Cfg"%>
    
<html>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/m/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入油耗</title>
</head>
<body>

<jsp:include page="/m/header.jsp" flush="true" />

<%
	GasRcd rcd = (GasRcd)session.getAttribute(Cfg.JSP.LAST_RCD_VO);
	request.setAttribute("rcd", rcd);
	%>
<form action="<%= request.getContextPath() + Cfg.SERVLET.NAME_GAS_FACE%>" method="post" name="GasForm">

	<input name="action" type="hidden" value="input" />

  <p align="center"><b>输入油耗</b></p>

  ${requestScope.errorMsg}<br/>
  <table>
  
  <tr>
	  <td align="right">  加油时间：<% 
	    SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("yyyy-MM-dd");
	  %></td>		
	  <td><input name="fueledTimeString" size="10" type="text" value="<%= df.format(new Date()) %>"/></td>
  </tr>
  <tr>
  	<td align="right">*总里程：</td><td><input name="totalDistance" size="8" type="text" value="${empty param.totalDistance ? rcd.totalDistance : param.totalDistance}" /> 公里</td>
  </tr>
  <tr>
  	<td align="right">*加油量：</td><td><input name="fueledVolum" size="10" type="text" value="${empty param.fueledVolum ? rcd.fueledVolum : param.fueledVolum}"/></td>
  </tr>
  <tr>
  	<td align="right">*是否加满：</td><td>    
  	  	<select name="isFull">
	  	  <option selected="selected"></option>
	  	  <option value="true">是</option>
	  	  <option value="false">否</option>
	  	</select>
	</td>
  </tr>
    <tr>
  	<td align="right">*是否漏填：</td><td>
	  	<select name="isLost">
	  	  <option selected="selected"></option>
	  	  <option value="true">无漏填</option>
	  	  <option value="false">  漏填</option>
	  	</select>
  	</td>
  </tr>
    <tr>
  	<td align="right">*单价：</td><td><input name="money" size="8" type="text" value="${empty param.money ? rcd.money : param.money}"/> 元/升</td>
  </tr>
    <tr>
  	<td align="right">*本次里程：</td><td><input name="lastDistance" size="8" type="text" value="${empty param.lastDistance ? rcd.lastDistance : param.lastDistance}" /> 公里</td>
  </tr>
    <tr>
  	<td align="right">油品类型：</td><td><input name="gasType" size="10" type="text" value="${empty param.gasType ? rcd.gasType : param.gasType}"/></td>
  </tr>
    <tr>
  	<td align="right">车显油耗：</td><td><input name="LPM" size="10" type="text" value="${param.LPM}"/></td>
  </tr>
    <tr>
  	<td align="right">加油地点：</td><td><input name="place" size="10" type="text" value="${param.place}" /></td>
  </tr>
    <tr>
  	<td align="right">道路类型：</td><td><input name="roadType" size="10" type="text" value="${param.roadType}" /></td>
  </tr>
    <tr>
  	<td align="right">说明：</td><td><input name="comment" size="10" type="text" value="${param.comment}" /></td>
  </tr>
  </table>
  <p>

    <input name="sub" type="submit" value="提交" />
  </p>
</form>
<jsp:include page="/m/footer.jsp" flush="true" />

</body>


</html>