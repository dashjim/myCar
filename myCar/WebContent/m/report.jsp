<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="service.tool.Cfg"%>
<%@page import="com.ibatis.common.util.PaginatedList"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.GasRcd"%>
<%@page import="model.Report"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %>

<html>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/m/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表</title>
</head>
<body>

<jsp:include page="/m/header.jsp" flush="true" />
<p>最近记录：</p>
	
	<table border="1" ><!-- gas rcd table -->
		<tr>
			<th>最后<br>公里<br>数</th><th>加油<br>量／升</th><th>&nbsp;油耗&nbsp;</th><th>&nbsp;加油&nbsp;<br>日期</th><th>里程表<br>/公里</th>
		</tr>
	
		<% 
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		
		//report vo
		Report report= (Report)session.getAttribute("reportVO");
		
		//list gas rcd 
		PaginatedList list = (PaginatedList)session.getAttribute(Cfg.JSP.RCD_VO_LIST);
	    SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("yy/MM/dd");
		for(int i = 0; i< list.size(); i++)
		{
			GasRcd rcd = (GasRcd) list.get(i);
			request.setAttribute("rcd", rcd);
		%>
		<tr class="color<%=i%2%>" align="right">
			<td>${rcd.lastDistance}	</td><td>${rcd.fueledVolum}	</td>
			<td><b><%
			if(rcd.getLPM()>0) out.print(nf.format(rcd.getLPM()));
			else out.print("--");
			%></b></td>
			<td><%= df.format(rcd.getFueledTime())%></td><td>${rcd.totalDistance}</td>
		</tr>
		
		<%	
		}//end of for loop
		%>
	</table>
		<%if(list.size()>0){ %>
			<a href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT%>?action=deleteLastInput">删除最近一条记录！</a>
		<%} %>
	<% //page switch
	if(!list.isLastPage()) {%>
	<a class="Button" href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT%>?pageDirection=next">&lt;&lt; 上一页</a>
	
	<%	
	}//end of if	
	if(!list.isFirstPage()) {%>
	<a class="Button" href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT%>?pageDirection=previous">下一页 &gt;&gt;</a>
	<%	
	}//end of if	
	%>
	<p>	汇总统计：</p>
	<table border="1"><!-- report table -->
		<% 
			//Report report = (Report)session.getAttribute(Cfg.JSP.REPORT_VO); 
		%>
		<tr align="right">
			<td>平均油耗</td>	<td><b><%=nf.format(report.getAvgLPM())%></b></td>      <td>消耗总油量</td>	<td><%=nf.format(report.getTotalGas())%></td>
		</tr>
		<tr align="right">	
			<td>油料总金额</td>	<td><%=nf.format(report.getTotalFee())%></td>			<td>登记总里程</td>	<td>${reportVO.totalDistance }</td>	
		</tr>	
	</table>
	<jsp:include page="/m/footer.jsp" flush="true" />
</body>
</html>