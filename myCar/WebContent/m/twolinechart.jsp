<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="service.tool.Cfg"%>
<%@page import="com.ibatis.common.util.PaginatedList"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.GasRcd"%>
<%@page import="model.Report"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %>


<%@page import="service.tool.GoogleChartAPI"%><html>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/m/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>趋势图 </title>
</head>
<body>

<jsp:include page="/m/header.jsp" flush="true" />

		<% 
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		
		//report vo
		Report report= (Report)session.getAttribute("reportVO");
		
		//list gas rcd 
		PaginatedList list = (PaginatedList)session.getAttribute(Cfg.JSP.RCD_VO_LIST);
		%>
	<br/><br/>
	<img src="<%=GoogleChartAPI.getTwoLineChart(list)%>" alt="油耗趋势图" />	
	<br/><br/>
	
	
	<% //page switch
	if(!list.isLastPage()) {%>
	<a class="Button" href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT_TWOLINE_CHART%>&pageDirection=next">&lt;&lt; 上一页</a>
	
	<%	
	}//end of if	
	if(!list.isFirstPage()) {%>
	<a class="Button" href="<%=request.getContextPath() + Cfg.SERVLET.NAME_REPORT_TWOLINE_CHART%>&pageDirection=previous">下一页 &gt;&gt;</a>
	<%	
	}//end of if	
	%>
	
	<br/><p>汇总统计：</p>
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