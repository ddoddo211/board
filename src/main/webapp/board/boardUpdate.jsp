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

<title>게시글 수정</title>
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
		margin-left: 20px;
	}
	
	#text{
		width: 80%;
		height: 50%;
	}
	
	textarea{
		text-align: left;
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


<%--스마트 에디터 관련 js --%>
<script src="/brd/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/brd/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
	var check = 0;
	$(".plus").click(function(){
		if(check <4){
		$("#fileplus").append("<input type=\"file\" name=\"file_path"+(check+1)+"\" class=\"path\"> <br> ");
			check++;
		} 
		if(check==4){
			$(this).remove();
		}
		
	});
	
	
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>

<%
String brdt_id = request.getParameter("brd_brdt");
System.out.println("updatejsp brdt_id : "+brdt_id);
%>



			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
					<!-- 여기에 게시글 세부내용 표시 -->
				<form action="/brd/brdDetail" method="post" id="frm" enctype="multipart/form-data">
					<c:choose>
						<c:when test="${brdVo.getBrd_title()!=null}">
							<div id="title" class="brd"><input class="form-control" type="text" name="brd_title" value="${brdVo.getBrd_title()}" /></div>
							<div id="user" class="brd">　　작성자 : ${userVo.userId }</div>
							<hr/>
							<div id="text" class="brd">
									<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${brdVo.getBrd_text() }</textarea>
									<input type="hidden" name="brd_id" value="${brdVo.brd_id }"/> 
									<input type="hidden" name="pageNum" value="${pageNum}"/> 
								
							</div>
						
						</c:when>
						<c:otherwise>
							<div id="title" class="brd"><input class="form-control" type="text" name="brd_title" value="" /></div>
							<div id="user" class="brd">　　작성자 : ${userVo.userId }</div>
							<hr/>
							<div id="text" class="brd">
									<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea>
									<input type="hidden" name="brd_id" value="none"/> 
									<input type="hidden" name="brd_brdt" value="<%=brdt_id%>"/> 
									<input type="hidden" name="brd_user" value="${userVo.userId }"/> 
									<input type="hidden" name="pageNum" value="1"/> 
									<c:if test="${brd_pid!=null }">
									<input type="hidden" name="brd_pid" value="${brd_pid}"/>
									<input type="hidden" name="re" value="ply"/>
									</c:if>
									<div id="fileplus">
									<input type="file" name="file_path" class="path" />  <br>
									</div>
									<div class="plus">+</div>
							</div>
						
						</c:otherwise>
					</c:choose>
				</form>
					<hr/>
					<c:choose>
						<c:when test="${brdVo.getBrd_title()!=null}">
						<input type="button" class="btn btn-default pull-right" id="savebutton" value="수정" />
						
						</c:when>
						<c:otherwise>
						<input type="button" class="btn btn-default pull-right" id="savebutton" value="작성" />
						
						</c:otherwise>
					</c:choose>
						<a class="btn btn-default pull-right" href="javascript:history.back()">취소</a>
					</div>
					
					
				</div>



			</div>
		</div>
	</div>
</body>
</html>
