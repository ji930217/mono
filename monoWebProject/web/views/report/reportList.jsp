<%@page import="ein.mono.common.PageInfo"%>
<%@page import="ein.mono.report.model.vo.ReportVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
  		ArrayList<ReportVo> list = (ArrayList<ReportVo>)request.getAttribute("list");  
    	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
		int listCount = pi.getTotalCount();
		int currentPage = pi.getCurrentPage();
		int maxPage = pi.getMaxPage();
		int startPage = pi.getStartPage();
		int endPage = pi.getEndPage();
    %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>신고리스트조회</title>
<script type="text/javascript" src = "/mwp/js/jquery-3.3.1.min.js"></script>
<style>
	.outer{
		width:800px;
		height:500px;
		border:1px solid red;
		margin-left:auto;
		margin-right:auto;
	}
	
	.inner{
		width:740px;
		height:350px;
		border:1px solid blue;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<script>
	
	
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<br>
<br>
<br>
<br>
<div class = "outer" align = "center">
	<h2>신고리스트</h2>
	<div class = "inner" align = "center">
		<table align = "center">
			<tr>
				<th width = "100">신고번호</th>
				<th width = "100">신고당한사람아이디</th>
				<th width = "100">사유</th>
				<th width = "100">확인여부</th>
				<th width = "100">신고날짜</th>
			</tr>
			<%if(list.size() ==0){ %>
				<tr>
					<td colspan = "5">조회된 신고글이 없습니다</td>
				</tr>
			<%}else{ %>
				<%for(ReportVo n:list){ %>
				<tr>
					<td><%=n.getReportCode()%></td>
					<td><%=n.getMemberId() %></td>
					<td><%=n.getReportReason() %></td>
					<td><%=n.getAdminCheck()%></td>
					<td><%=n.getReportDate() %></td>			
				</tr>
				<%}; %>
			<%}; %>
		</table>
	</div>
	
	<div class = "pageArea" align = "center"><!-- 페이징처리 부분 -->
		<button onclick = "movePage(1);"><<</button>		
		<%for(int i = startPage;i<=endPage;i++){ %>	
	<%if(currentPage == i){%>
			<button onclick = "movePage(<%=i%>);"  disabled><%=i %></button>
			<%}else{ %>
			<button onclick = "movePage(<%=i%>);"  ><%=i %></button>
		<%}; %>		
			<%}; %>	
		<button onclick = "movePage(<%=maxPage%>);">>></button>
		
	</div>  
	
</div>

<script>
$(function(){
	$(".inner td").mouseenter(function(){		
		
		$(this).parent().css("cursor", "pointer");
	
	}).click(function(){
		var reportNo = $(this).parent().children().eq(0).text();
		location.href = "/mono/reportListDetail.do?reportNo=" + reportNo+"&currentPage="+<%=currentPage%>;
	});
});

function movePage(pageNum){
	location.href = "/mono/reportList.do?currentPage="+pageNum;
}
</script>

<%@ include file="../common/footer.jsp" %>
</body>
</html>