<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>로그인폼</title>
<script type="text/javascript" src = "/mwp/js/jquery-3.3.1.min.js"></script>
<style>
#memberLoginBtn, #memberJoinBtn{
	display: inline-block;
	margin : 20px;
	height:25px;
	width:70px;
	border:1px solid white;
	cursor:pointer;
	}
	
	.loginArea{
		
		margin-right:650px;
		
	}
</style>
<script>
function login(){
	$("#loginForm").submit();
}

function join(){
	location.href = "MemberJoin.jsp"; 
}


</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class = "loginArea" align = "center">
		<br>
		<br>
		<br>
<h2>MONO</h2>
		<br>
			<form id = "loginForm" action = "/mono/memberLogin.do" method = "post">
				<table class = "login">
					<tr>
						<td align = "center">아이디</td>
						<td><input type = "text" name ="memberId"/><br></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type = "password" name = "memberPwd" id = "memberPwd"/>
					</tr>
										
					<tr>
						<td colspan = "2" name = "btn">
							<div id = "memberLoginBtn" onclick = "login();">로그인</div>
							<div id = "memberJoinBtn" onclick = "join();">회원가입</div>
						</td>
					</tr>
				</table>
			</form>

		</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>