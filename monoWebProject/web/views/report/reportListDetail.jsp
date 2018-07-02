<%@page import="ein.mono.common.PageInfo"%>
<%@page import="ein.mono.report.model.vo.ReportVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ReportVo report = (ReportVo)request.getAttribute("report");
    	PageInfo pi = (PageInfo)request.getAttribute("pi");
    %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>신고리스트자세히보기</title>
<script type="text/javascript" src = "/mwp/js/jquery-3.3.1.min.js"></script>
<script>
	function reportCheck(){
	var check = confirm("정지기간을 확인하고 확인을 눌러주세요");
	if(check == true){
	$("#reportCheck").submit();
	}
	}
	
	function returnPage(){		
		location.href = "/mono/reportList.do?currentPage=<%=request.getAttribute("currentPage")%>";
	}
</script>
<style>
	.outer{
		border:1px solid red;
		width:800px;
		height:500px;
		margin-left:auto;
		margin-right:auto;
		margin-top:100px;
	}
	
	.inner{
	border:1px solid blue;
	width:740px;
	height:400px;
	margin-left:auto;
	margin-right:auto;
	margin-top:-20px;
	
	}
	.inner p{
		margin-left:20px;
		margin-right:20px;
	}

	
	.btn{
	display:inline-block;
	margin:8px;
	}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class = "outer">
<form id = "reportCheck" method = "post" action = "/mono/reportUpdate.do" >
	<h2 align = "center">신고내용</h2>
	<div class = "inner">
	<br>
	<br>
		<p><%=report.getReportReason() %></p>
		<br>
		<br>
		<br>
		<br>
		<div align = "center"> 
		정지기간
		<select name = "stopDate">
			<option value = "1">정지하지않음</option>
			<option value = "2">3일</option>
			<option value = "3">7일</option>
			<option value = "4">30일</option>
			<option value = "5">영구정지</option>
		</select>
		<br>
		<div class = "btn" onclick = "reportCheck();">확인</div>
		<div class = "btn" onclick = "returnPage();">돌아가기</div>
		</div>
	</div>
	</form>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>