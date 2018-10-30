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

<title>게시글</title>
<style type="text/css">
	.brd{
		margin-top: 50px;
		margin-left: 50px;
	}

	#title{
		font-size: 30px;
		width: 60%;
		height: 20%;
		float: left;
	}
	
	#user{
		font-size: 15px;
		height: 20%;
	}
	
	#text{
		width: 60%;
		height: 50%;
	}
</style>
</head>


<body>


	<%-- 지시자 --%>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- 지시자 --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
					<!-- 여기에 게시글 세부내용 표시 -->
					<div id="title" class="brd">${brdVo.getBrd_title() }</div>
					<div id="user" class="brd">작성자 : ${brdVo.getBrd_user() }</div>
					<hr/>
					<div id="text" class="brd">${brdVo.getBrd_text() }</div>
					<hr/>
					<div id="text" class="brd">
					<c:forEach items="${rplList }" var="rv">
					<strong>${rv.rpl_user } 님의 댓글</strong>&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:formatDate value="${rv.rpl_date}" pattern="yyyy-MM-dd" />
					<c:if test="${(userVo.userId).equals(rv.rpl_user) }"> 	
					<a href="/brd/brdDetail?brd_id=${brdVo.brd_id }&pageNum=${pageNum }&rpl_id=${rv.rpl_id}">
						<img src="x.png" alt="댓글삭제" width="13"/>
					</a>
					</c:if>
					<br><br>

					${rv.rpl_text }<br>
					<hr/>
					</c:forEach>
					
					<c:if test="${fileList!=null }">
						<c:forEach items="#{fileList }" var="fl">
							<c:set var="cc" >C:\A_TeachingMaterial\6.JspSrpgin\workspace\board\src\main\webapp\</c:set>
							첨부파일 : <a href="/brd/dl?file_name=${fl.file_path }" >${fl.file_path }</a> <br>
						</c:forEach>
					</c:if>
					
					
					<%-- 댓글 작성부분 --%>
					<form action="/brd/brdDetail" method="get">
						<b>${userVo.userId} </b> <input type="text" name="rpl_text" class="form-control" />
						
						
						<input type="submit" value="댓글작성" class="btn btn-default pull-right"/>
						<input type="hidden" name="brd_id" value="${brdVo.brd_id }" />
						<input type="hidden" name="pageNum" value="${pageNum }" />
						<input type="hidden" name="rpl_user" value="${userVo.userId}" />
					</form>
					</div>
					<hr/>
					<a class="btn btn-default pull-right" href="/brd/brdServlet?brdt_id=${brdVo.brd_brdt }&pageNum=${pageNum}">목록</a>
					<c:choose>
						<c:when test="${userVo.userId==brdVo.getBrd_user() }">
						<a class="btn btn-default pull-right" href="/brd/brdUpdate?stat=update&brd_id=${brdVo.brd_id }&pageNum=${pageNum}">글수정</a>
						<a class="btn btn-default pull-right" href="/brd/brdUpdate?stat=delete&brd_id=${brdVo.brd_id }&pageNum=${pageNum}">글삭제</a>
						</c:when>
						<c:otherwise>
						<a class="btn btn-default pull-right" href="/brd/brdUpdate?stat=update&brd_id=${brdVo.brd_id }&pageNum=${pageNum}&re=ply&brd_brdt=${brdVo.brd_brdt }">답글작성</a>
						</c:otherwise>
					</c:choose>
					</div>
					
					
				</div>



			</div>
		</div>
	</div>
</body>
</html>
