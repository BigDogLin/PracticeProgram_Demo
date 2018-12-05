<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>橘Plus宠物店</title>
	<style type="text/css">
	.main {
		margin:60px auto;
		text-align:center;
		background:white;
		width:450px;
		height:500px;
	}
	.header {
		font-size:45px;
		font-weight:500px;
		height:70px;
		color:orange;
	}
	.banner {
		font-size:20px;
		height:50px;
	}
	.content button {
		width:200px;
		height:35px;
		background:#0084ff;
		color:white;
	}
	.content form input {
		width:200px;
		height:25px;
	}
	</style>
</head>
<body>
	<div class="main">
		<div class="header">橘Plus宠物日用店</div>
		<div class="banner">登陆橘Plus，橘满您的心</div>
		<div class="content">
			<form name="user_login" action="checklogin" id="user_login" method="post">
				<input type="text" name="account" placeholder="用户帐号" maxlength="18" value="admin"><br><br>
				<input type="password" name="password" placeholder="用户密码" maxlength="18" value="admin"><br><br>
				<button class="infoBt" type="submit" form="user_login">登&emsp;&emsp;&emsp;陆</button>
			</form>
		</div>
	</div>
</body>
</html>