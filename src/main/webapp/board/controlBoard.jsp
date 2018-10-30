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

<title>게시판관리메뉴</title>
<style type="text/css">
	.userClick{
	}
	.userClick:hover {
		background: skyblue !important;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		
	});
</script>

</head>


<body>


	<%-- 지시자 --%>
	<%@ include file="/common/header.jsp" %>

	<div class="container-fluid">
		<div class="row">

	<%-- 지시자 --%>
	<%@ include file="/common/left.jsp" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">${brd_brdt }</h2>
		<div class="table-responsive">
		<h2>게시판 정보 수정</h2>
			<table class="table table-striped">
				<tr>
						<th width="375px">게시판명	</th>
						<th width="110px">생성자</th>
						<th>생성일		</th>
						<th>사용가능여부		</th>
						<th>		</th>
				</tr>
			</table>	
			
					<c:forEach items="${boardTypeList }" var="brdt" >
				<form action="/brd/controlBoard" method="get">
					<input type="hidden" name="brdt_id" value="${brdt.brdt_id }"/>
					<input type="hidden" name="brdt_update" value="Y"/>
					<table class="table table-striped">
						<tr class="userClick">
							<td width="375px"><input class="form-control" type="text" name="brdt_name" value="${brdt.brdt_name }" /></td>
							<td>${brdt.brdt_user }</td>
						<td><fmt:formatDate value="${brdt.brdt_date }" pattern="yyyy-MM-dd" /></td>
							<c:choose >
								<c:when test="${brdt.brdt_useable==1 }">
									<td>
										<select name="brdt_useable">
											<option value="1" selected>사용가능</option>
											<option value="2">사용불가능</option>
										</select>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<select name="brdt_useable">
											<option value="1" >사용가능</option>
											<option value="2" selected>사용불가능</option>
										</select>
									</td>
								</c:otherwise>
							</c:choose>
									<td>
									<input type="submit" class="btn btn-default pull-right" value="수정"/>
									</td>
						</tr>	
					</table>	
				</form>
					</c:forEach>
		
			
			
		
		</div>

		<br><br>
		
		<div class="table-responsive">
		<h2>게시판 생성하기</h2>
		<form action="/brd/controlBoard" method="get">
		<input type="hidden" name="brdt_update" value="N"/>
		<input type="hidden" name="userId" value="${userVo.userId}"/>
			<table class="table table-striped">
				<tr>
						<th>게시판생성	</th>
						<th></th>
				</tr>
				
					
						<tr class="userClick">
							<td><input class="form-control" type="text" name="brdt_name" placeholder="생성할 게시판의 이름을 입력하세요""/></td>
							<td><input type="submit" class="btn btn-default pull-right" value="생성"/></td>
						</tr>	
					
			</table>
		</form>
			
		</div>
		
		

	</div>
</div>
				


			</div>
		</div>
	</div>
</body>
</html>
