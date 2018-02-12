<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="<c:url value="/resources/styles/main.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid" id="top-row-container">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<div class="container">
					<div class="row">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for a movie, a T.V series or both"
								data-placement="left">
							<div class="input-group-append" style="margin-right: 5px">
								<button class="btn btn-outline-secondary dropdown-toggle"
									type="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Movie</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="#">Movie</a> <a
										class="dropdown-item" href="#">T.V Series</a> <a
										class="dropdown-item" href="#">All</a>
								</div>
							</div>
							<button class="btn btn-info" type="submit">Search</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
			<div class="col-sm-4">
				<div class="container">
					<div class="row">
						<div class="input-group">
							<input class="form-control" type="text" name='username'
								id="username-home" placeholder="Username" data-toggle="popover"
								data-placement="left"> <input class="form-control"
								type="password" name='password' id="password-home"
								placeholder="Password" data-toggle="popover"
								data-placement="left">
							<button class="btn btn-success" type="submit">Log in</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>