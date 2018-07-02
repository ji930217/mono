<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>신고하기</title>
<style>
	.outer{
	width:200px;
	heigth:20px;
		margin-left:auto;
		margin-right:auto;
		border:1px solid black;
	}
</style>
<script>
	function startReport(){
		
		location.href="reportWrite.jsp";
	}
	
	function reportList(){
		location.href="/mono/reportList.do";
	}
	function reportListDetail(){
		location.href="reportListDetail.jsp";
	}

</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class = "outer" align = "center">
<button id = "report" onclick = "startReport();">신고하기</button>
<button id = "reportList" onclick = "reportList();">신고리스트</button>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>