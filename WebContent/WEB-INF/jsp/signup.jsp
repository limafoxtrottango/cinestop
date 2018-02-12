<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/javascript/utility.js" />"></script>
<script src="<c:url value="/resources/javascript/signup.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="panel panel-default col-md-6 col-md-offset-3">
			<div class="row">
				<div class="Absolute-Center is-Responsive">
					<div id="logo-container"></div>
					<div class="col-sm-12 col-md-10 col-md-offset-1">
						<form action="addNewUser" id="signupForm" method="post"
							modelAttribute="user">
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input
									class="form-control" type="text" name='username' id='username'
									placeholder="Username" /> <span
									class="form-control-feedback glyphicon glyphicon-ok" id="form-control-feedback"></span>
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input
									class="form-control" type="password" name='password'
									id='password1' placeholder="Password" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input
									class="form-control" type="password" name='password'
									id='password2' placeholder="Type password again" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input
									class="form-control" type="email" name='email' id='email'
									placeholder="E-mail id for password recovery" />
							</div>
							<div class="form-group">
								<button id="signup-button" type="button" class="btn btn-def btn-block">Sign
									Up</button>
							</div>
							<div class="form-group text-center">
								<a href="#">Forgot Password</a>&nbsp;|&nbsp;<a href="#">Support</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>