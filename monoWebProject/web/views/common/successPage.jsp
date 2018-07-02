<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
		String msg = (String)request.getAttribute("msg");
	%>
<html>
<head>
<meta  charset="UTF-8">
<title>완료페이지</title>
<script>
	function returnMainPage(){
		location.href = "/mono/index.jsp";
	}
</script>
</head>
<body>
	<h3><%=msg %></h3>
	
	<div id = "returnMain" onclick = "returnMainPage();">메인으로</div>

</body>
</html>