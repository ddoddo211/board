<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		margin: 0px;
		padding: 0px;
	}
	.bigCtn {
		margin: 0px;
		padding : 0px;
		background : #819FF7;
		width: 100%;
		height: 1080px;
		text-align: center;
	}
	
	.loginCtn{
		display: inline-block;
		padding-top: 300px;
		margin: 0 auto;
		height: 500px;
	}
	
	.loginBtn{
		vertical-align: middle;
		margin-top: 10px;
		background: white;
		width: 200px;
		height: 30px;
		border-radius: 30px;
	}
	
	.loginBtn:hover {
		box-shadow: 0px 0px 5px #000;
	}
	
	.loginInput {
		margin-bottom : 10px;
		width: 200px;
		height: 30px;
		border: 2px solid #A4A4A4;
		border-radius: 10px;
		text-align:center;
	}
	
</style>

</head>
<body>
<form action="/brd/loginServlet" method="post">
	<div class="bigCtn">
		<div class="loginCtn">
			<h2>로그인해라</h2> <br>
			ID<br> <input class="loginInput" type="text" name="userId" placeholder="  아이디를 입력하세요"/> <br>
			PW<br> <input class="loginInput" type="password" name="password" placeholder="  비밀번호를 입력하세요"/> <br>
			<button type="submit" class="loginBtn">접속</button>
		</div> 
	</div>
</form>
</body>
</html>