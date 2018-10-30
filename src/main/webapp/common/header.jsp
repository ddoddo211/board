<%@page import="kr.or.ddit.board.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 라이브러리 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script> <!-- js cookie : https://github.com/js-cookie/js-cookie -->
<script src="/js/bootstrap.js"></script>

<%-- 스타일 --%>
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/brd/main.jsp">게시판관리</a>
			
		</div>
		<% UserVo userVo = (UserVo)session.getAttribute("userVo"); 
		%>
		<%-- javaScript 이용해서 로그인정보없을때 로그인 화면으로 쫒아내기 --%>
		<script>
			var userVo = <%=userVo%>;
			if(userVo==null){
				window.location.replace("/brd/login.jsp");
			}
		</script>
		
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${userVo.userId!=null}">
						<li><a href="#">${userVo.userId} 님 안녕하세요</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">로그인정보가 없습니다</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/brd/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
			<!-- 검색창 있던자리 -->
			</form>
		</div>
	</div>
</nav> 