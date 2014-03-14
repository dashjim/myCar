<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/m/style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填表帮助</title>
</head>
<body>
	<jsp:include page="/m/header.jsp" flush="true" />
	<p><b>填表帮助</b></p>
	
	<p>*号开头的项目为必填项。</p>
	<p><b>务请如实填写</b>各必填数据！计算程序考虑到了各种可能的情况，会自动处理。<br></p>
	<p>车显油耗：如果您的汽车可以显示当前油耗，可填入，但不作为计算依据，仅作为与本程序结果之间的对比。<br></p>
	<p>如果您之前输入过数据，则输入页会默认显示上次的数据，以方便输入。</p>
	
</body>
</html>