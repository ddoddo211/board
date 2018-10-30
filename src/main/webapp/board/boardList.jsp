<%@page import="kr.or.ddit.board.model.BrdVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>${brd_brdt }</title>
<style type="text/css">
	.userClick{
		cursor: pointer;
	}
	.userClick:hover {
		background: skyblue !important;
	}
</style>

</head>


<body>


	<%-- 지시자 --%>
	<%@ include file="/common/header.jsp" %>
	
	
	
<script type="text/javascript">
	$(document).ready(function(){
		console.log("document.ready");
		
		//tr 에 select(class="userClick")
		
		$(".userClick").on("click", function(){
			//숨겨져있는 td 태그 안에있는 id값을 가져온다
			var brd_id = $(this).children()[3].innerText;
			console.log(brd_id);
			
			$("#brd_id").val(brd_id);
			$("#dtl").submit();
		});
		
	});
</script>
<form action="/brd/brdDetail" method="get" id="dtl">
	<input type="hidden" name="brd_id" id="brd_id"/>
	<input type="hidden" name="pageNum" id="pageNum" value="${brdVo.brd_page }"/>
</form>


	<div class="container-fluid">
		<div class="row">

	<%-- 지시자 --%>
	<%@ include file="/common/left.jsp" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header"></h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
						<th width="100px">번호		</th>
						<th width="500px">글제목		</th>
						<th width="100px">작성자	</th>
						<th style="display: none"> </th>
				</tr>
				
					
					<c:forEach items="${boardList }" var="bl" >
					<c:choose>
						<c:when test="${bl.brd_del==1 }">
							<tr class="userClick">
								<td>${bl.rnum}</td>
								<td>${bl.brd_rp}</td>
								<td>${bl.brd_user}</td>
								<td style="display: none">${bl.brd_id }</td>
							</tr>	
						</c:when>
						<c:otherwise>
							<tr>
								<td>${bl.rnum}</td>
								<td>${bl.brd_rp}</td>
								<td>${bl.brd_user}</td>
								<td style="display: none">${bl.brd_id }</td>
							</tr>	
						</c:otherwise>
					</c:choose>
					</c:forEach>
					
			</table>
		</div>
		<%
			String brd_brdt =request.getParameter("brdt_id");
		%>
		<a class="btn btn-default pull-right" href="/brd/board/boardUpdate.jsp?brd_brdt=<%=brd_brdt%>">글쓰기</a>
		
		
		<%
		int totalCnt = (Integer)request.getAttribute("totalCnt");
		BrdVo brdVo = (BrdVo)request.getAttribute("brdVo");
		// 불러온 페이지 번호가 1보다 작거나, 최대치보다 클때 = 1보다작으면 1로설정, 최대보다 크면 최대로 설정
		if(brdVo.getBrd_page()<1){
			brdVo.setBrd_page(1);
		} else if (brdVo.getBrd_page()>totalCnt/brdVo.getBrd_pageSize()) {
			brdVo.setBrd_page(totalCnt/brdVo.getBrd_pageSize()+1);
		}
		
		int startIndex = brdVo.getBrd_page();
		if(startIndex<11){
			startIndex = 1;
		} else if(startIndex%10==0) { //여기서부터하기
			startIndex -= 9;
		} else {
			startIndex = startIndex-(startIndex%10)+1;
		}
		int endIndex = startIndex +10;
		int moveFoward = startIndex-10;
		if(moveFoward<1){
			moveFoward = 1;
		}
		if(endIndex > totalCnt/brdVo.getBrd_pageSize()){
			endIndex = totalCnt/brdVo.getBrd_pageSize()+2;
		}
		
		
		
		%>

		<div class="text-center">
			<ul class="pagination">
			<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=1">start</a></li>
			<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=moveFoward%>"><<</a></li>
			<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=brdVo.getBrd_page()-1%>"><</a></li>
			<%
			for(int pg = startIndex;pg < endIndex;pg++){
				if(pg==brdVo.getBrd_page()){
					%><li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=pg%>" style="background:#428bca; color:white;"><%=pg%></a></li><%
				} else{
				%>
				<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=pg%>"><%=pg%></a></li>
				<%
				}
			}
			%>
			
			
			<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=brdVo.getBrd_page()+1%>">></a></li>
			<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=endIndex%>">>></a></li>
			<li><a href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=<%=totalCnt/brdVo.getBrd_pageSize()+1%>">end</a></li>
			</ul>
		</div>
	</div>
</div>
				


			</div>
		</div>
	</div>
</body>
</html>
