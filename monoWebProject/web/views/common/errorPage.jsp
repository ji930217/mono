<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
		String msg = (String)request.getAttribute("msg");
	%>
<html>
<head>
<meta  charset="UTF-8">
<title>에러페이지</title>
<script>
function returnMainPage(){
	location.href = "/mono/index.jsp";
}
</script>
</head>
<body>
	<h2>에러페이지</h2>
	<h3><%=msg %></h3>
	<div id = "returnMain" onclick = "returnMainPage();">돌아가기</div>
</body>
</html>