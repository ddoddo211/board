<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	$(document).ready(function(){
		
		$(".active").on("click",function(){
			
			
		});
		
	});
</script>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
			<c:forEach items="${boardTypeList}" var="brdt">
				<c:if test="${brdt.brdt_useable==1}">
					<li class="active"><a href="/brd/brdServlet?brdt_id=${brdt.brdt_id }">${brdt.brdt_name } </a></li>
					<input type="hidden" id="boardId" name="brdt_id"/>
				</c:if>
			</c:forEach>
		
		<li class="active"><a href="/brd/controlBoard">게시판관리</a></li>
	</ul>
</div>
