<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>신고작성</title>
<script type="text/javascript" src = "/mwp/js/jquery-3.3.1.min.js"></script>
<script>
	function okBtn(){
		$("#reportForm").submit();
	}
	
	function returnPage(){
		alert("이전페이지로가기");
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
	#textarea{
	resize:none;
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
<form id = "reportForm" method = "post" action = "/mono/reportInsert.do" >
	<h2 align = "center">신고하기</h2>
	<div class = "inner" align = "center">
	<br>
	신고사유
		<select name="reportReason1" >
  			<option value="(광고)">광고</option>
  			<option value="(욕설)">욕설</option>
  			<option value="(저작권침해)">저작권침해</option>
  			<option value="(게시판에목적에맞지않음)" >게시판의 목적에 맞지않음</option>
</select>
  		<p>신고내용</p>
  		<textarea id = "textarea" name = "reportReason2" rows="18" cols="50" ></textarea><br>
  		
  		<div class = "btn" onclick = "okBtn();">확인</div>
  		<div class = "btn" onclick = "returnPage();">취소</div>
  		
	</div>
</div>
 <%@ include file="../common/footer.jsp" %>
</body>
</html>