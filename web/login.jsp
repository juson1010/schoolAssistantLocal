<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta charset="utf-8">
	<title>Flat UI - Free Bootstrap Framework and Theme</title>
	<meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

	<meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="flat-ui/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="flat-ui/css/flat-ui.css" rel="stylesheet">


	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
		
		
</head>

<body>

<div class="login">
	<div class="login-screen">
		<!--<div class="login-icon">-->
			<!--<img src="img/login/icon.png" alt="Welcome to Mail App" />-->
			<!--<h4>Welcome to <small>Mail App</small></h4>-->
		<!--</div>-->


		<form action="login.action" method="post">
			<div class="login-form">
				<div class="form-group">
					<input name="username" type="text" class="form-control login-field" value="" placeholder="Enter your name" id="login-name" />
					<label class="login-field-icon fui-user" for="login-name"></label>
				</div>

				<div class="form-group"
				>
					<input name="password" type="password" class="form-control login-field" value="" placeholder="Password" id="login-pass" />
					<label class="login-field-icon fui-lock" for="login-pass"></label>
				</div>
				<input type="submit" value="Log in" class="btn btn-primary btn-lg btn-block">

				<a class="login-link" href="#">Lost your password2?</a>
			</div>
		</form>
	</div>
</div>
	<!-- start: JavaScript-->

		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="js/jquery.ui.touch-punch.js"></script>
	
		<script src="js/modernizr.js"></script>
	
		<script src="js/bootstrap.min.js"></script>
	
		<script src="js/jquery.cookie.js"></script>
	

	<!-- end: JavaScript-->
	
</body>
</html>
