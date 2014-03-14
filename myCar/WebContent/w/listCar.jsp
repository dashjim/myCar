<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="servlet.www.ListCarFace"%>
    <!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
    <html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	<link href="<%= request.getContextPath()%>/w/sortCar.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%= request.getContextPath()%>/w/tbsorter/jquery.tablesorter.min.js"></script>
	<link rel="stylesheet" href="<%= request.getContextPath()%>/w/tbsorter/style.css" type="text/css" media="print, projection, screen" />
  <title>超级马力汽车油耗排行榜</title>

</head>
<body id="body">
<div class="layout" ><p align="center"><span style="font-size: 16px;">超级马力汽车油耗排行榜  -- superML.net -- </span></p>

<br/><br/>
<div id="searchContainer" style="margin: 4px">
	<%
	String[] producerNames = (String[]) application.getAttribute(ListCarFace.PRODUCER_NAMES);
	String[] carNames = (String[]) application.getAttribute(ListCarFace.CAR_NAMES);
	if(producerNames != null && carNames != null){%>
			厂商：<select id="prodcerName">
					<option>全部汽车厂商</option>
				<%for(int i = 0; i<producerNames.length; i++){%>
					<option><%=producerNames[i] %></option>
				<%}//end of for%> 
			</select>
			车型：<select id="carName">
					<option>全部车型</option>
				<%for(int i = 0; i<carNames.length; i++){%>
						<option><%=carNames[i] %></option>
				<%}//end of for%> 
			</select>
	<%}//end of if%>	
	<br/>
	排量：<select id=powerLower>
		<option>0.1</option>
		<option>1.0</option>
		<option>1.3</option>
		<option>1.6</option>
		<option>1.8</option>
		<option>2.0</option>
		<option>2.4</option>
		<option>3.0</option>
	</select>-
	<select id=powerHigh>
		<option>1.0</option>
		<option>1.3</option>
		<option>1.6</option>
		<option>1.8</option>
		<option>2.0</option>
		<option>2.4</option>
		<option>3.0</option>
		<option selected="selected">10.0</option>
	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;城市油耗：
	<select id=badLPMLower >
		<option>1.0</option>
		<option>5.0</option>
		<option>7.0</option>
		<option>9.0</option>
		<option>10</option>
		<option>12</option>
		<option>14</option>
		<option>16</option>
		<option>18</option>
	</select>-
	<select id=badLPMHigh>
		<option>5.0</option>
		<option>7.0</option>
		<option>9.0</option>
		<option>10</option>
		<option>12</option>
		<option>14</option>
		<option>16</option>
		<option>18</option>
		<option selected="selected">20</option>
	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;理论油耗：
	<select id=badLPMLower >
		<option>1.0</option>
		<option>5.0</option>
		<option>7.0</option>
		<option>9.0</option>
		<option>10</option>
		<option>12</option>
		<option>14</option>
		<option>16</option>
		<option>18</option>
	</select>-
	<select id=badLPMHigh>
		<option>5.0</option>
		<option>7.0</option>
		<option>9.0</option>
		<option>10</option>
		<option>12</option>
		<option>14</option>
		<option>16</option>
		<option>18</option>
		<option selected="selected">20</option>
	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;变速器：
	<select id=trans >
		<option>全部</option>
		<option>手动</option>
		<option>自动</option>
		<option>其它</option>
	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;每页记录：
	<select id=pageSize >
		<option>10</option>
		<option>20</option>
		<option selected="selected">40</option>
		<option>60</option>
		<option>80</option>
		<option>100</option>
	</select>
	 &nbsp;&nbsp;&nbsp;&nbsp;<button class="task_submit" id="task_new__submit">搜索</button>
</div>


<div id="compare">
	比较...
	  <table id="t2" class="tablesorter" cellspacing="1">
	  	<thead>
	  	  <tr><th>型号</th><th>厂商</th><th>车名</th><th>变速器</th><th>排量</th><th>理论油耗</th><th>城市油耗</th><th>油耗因子</th><th>删除</th></tr>
	  	</thead>
	  	<tbody id="comparelist">
	  	</tbody>
	 </table>
</div>
<br/>
	<div ><span  id="searchNote">请先搜索...</span><span style="float: right;">&lt;&lt;&nbsp;&nbsp;&gt;&gt;</span></div>


	<div id="list">
	
	  <table id="t1" class="tablesorter" cellspacing="1">
	  	<thead>
	  	  <tr><th>型号</th><th>厂商</th><th>车名</th><th>变速器</th><th>排量</th><th>理论油耗</th><th>城市油耗</th><th>油耗因子</th><th>比较</th></tr>
	  	</thead>
	  	<tbody id="carlist">
	  	</tbody>
	 </table>
	</div>

<div align="center" >superML.net 2010 版权所有</div>

</div>
</body>
    <script>

//form submit function
  $("#body button.task_submit").live('click', ajaxQuery );

  function ajaxQuery(){
	  
		$("#list").hide("fast");
		$("#searchNote").hide("slow").show("slow").html("搜索中...");
		
	  	$.post(
			"<%= request.getContextPath() + ListCarFace.SERVERT_PATH%>",
			{ "carName":$("#carName option:selected").text(),"prodcerName":$("#prodcerName option:selected").text(), 
				"powerLower":$("#powerLower option:selected").text(),"powerHigh":$("#powerHigh option:selected").text(), 
				"badLPMLower":$("#badLPMLower option:selected").text(),"badLPMHigh":$("#badLPMHigh option:selected").text(), 
				"pageSize":$("#pageSize option:selected").text(),"trans":$("#trans option:selected").text(), 
				 "<%=ListCarFace.ACTION_NAME%>":"<%=ListCarFace.ACTION_VALUE_LIST%>" },
			function(data){refreshTable(data);}
	  	);
  }
  
  //change producer selection
    $('#prodcerName').change(function () {
    	
          var str = "<%= request.getContextPath() + ListCarFace.SERVERT_PATH%>";
          str+="<%= "?"+ListCarFace.ACTION_NAME+"="+ListCarFace.ACTION_VALUE_GETCARS%>";
          
          $("#prodcerName option:selected").each(function () {
	       	  	$.post(
	       	  			str,
	       	  			{"prodcerName":$("#prodcerName option:selected").text()},
	       	  			function(data){updateCarNames(data);}
	       	  	);
              });
        });

    function updateCarNames(data) {
		var s ='<option>全部车型</option>'; 
		data= $.parseJSON(data);
		if (data.length >0) {
			for ( var i = 0; i < data.length; i++) {
				s+="<option>"+data[i]+"</option>";
			}
			$("#carName").html(s);
		}else{
			$("#carName").html("<option>全部</option>");
		}
	}

	function refreshTable(data){
			
			var data=$.parseJSON(data);
			var s = '';
		if (data.length >0) {
			for ( var i = 0; i < data.length; i++) {
				var power = ((data[i].power+30)/1000);
				power = new String(power).slice(0,3);
				var v= data[i];
				s+="<tr><td>"+v.model+"</td><td>"+v.producer+"</td><td>"+v.name+"</td><td>"+v.trans+"</td><td>"+power+"</td><td>"+v.goodLPM+"</td><td>"+v.badLPM+"</td><td>"+v.factor+"</td><td ><a id=\"lastTD\" href=\"javascript:void(0);\" onclick=\"compareIt(this)\">比较</a></td></tr>";
			}
			$("#carlist").html(s);
			$("#list").show("slow");
			
			$("#searchNote").show("slow").html("您可以对结果进行排序和比较...");
		}else{
			$("#searchNote").html("无记符合条件的记录，请使用其它条件查询！").hide("slow").show("slow");
		}
		updateTable("#t1");
	}

	function compareIt(obj){
		obj = $(obj).parent().get(0);
		obj = $(obj).parent().get(0);
		$("#comparelist").append("<tr>"+$(obj).html()+"</tr>");
		$("#comparelist #lastTD").text("删除");
	    var js = "var obj = $(this).parent().get(0); obj=$(obj).parent().get(0); $(obj).remove(); return false;";
	    // create a function from the "js" string
	    var newclick = new Function(js);
	    // clears onclick then sets click using jQuery
	    $("#comparelist #lastTD").attr('onclick', '').click(newclick);
		$("#compare").show("slow");
		updateTable("#t2");
		//comparelist
	}

	function changeMe(){
		obj = $(obj).parent().get(0);
		$(obj).parent().get(0).remove();
	}

	//DOM loaded
	$(document).ready(documentReady());

	function documentReady(){
		ajaxQuery();//init data
		$("#compare").hide();
		sortTable();
	}


	
	//table sorter
	function sortTable(){


		$("#t1").tablesorter({
			// pass the headers argument and assing a object
			headers: {
				1: {sorter: false},
				2: {sorter: false},
				3: {sorter: false},
				8: {sorter: false}				
			},
			widgets: ['zebra'],
			//textExtraction: myTextExtraction,
			// sort on the first column and third column, order asc 
	        sortList: [[7,0]] 
		});
		$("#t2").tablesorter({
			// pass the headers argument and assing a object
			headers: {
				1: {sorter: false},
				2: {sorter: false},
				3: {sorter: false},
				8: {sorter: false}					
			},
			widgets: ['zebra'],
			//textExtraction: myTextExtraction,
			// sort on the first column and third column, order asc 
	        sortList: [[7,0]] 
		});
	}

	//for ajax
	function updateTable(id){
		$(id).trigger("update"); 
		$(id).trigger("applyWidgets"); 
	}
	
	var myTextExtraction = function(node)  
	{  
	    // extract data from markup and return it  
	    return node.childNodes[0].childNodes[0].innerHTML; 
		//<td><strong><em>123 Main Street</em></strong></td>
	} 
	
</script>

</html>
    
    
    
    
    
    
    
    
    