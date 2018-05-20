<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="<c:url value="/resources/styles/main.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-migrate-3.0.0.min.js "></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Laila'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Aguafina Script'
	rel='stylesheet'>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/javascript/utility.js" />"></script>
<script src="<c:url value="/resources/javascript/home.js" />"></script>
</head>
<body>

	<div class="container-fluid" id="top-row-container">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<div class="container">
					<div class="row">
						<div class="input-group">
							<input class="form-control bs-autocomplete"
								id="home_searchMediaInputText" value=""
								placeholder="Enter movie or T.V series name" type="text"
								autocomplete="off">
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
							<button class="btn btn-info" type="submit" id="searchbutton">Search</button>
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
							<button id="login-home" class="btn btn-success" type="submit">Log
								in</button>
							<button id="signup-home" class="btn btn-success" type="submit">Sign
								Up</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div id="netflix-toggle"
				style="width: 60px; margin-left: 10px; margin-right: 10px">
				<input type="checkbox" checked data-toggle="toggle"> <label
					style="font-family: 'Laila'">Netflix </label>
			</div>
			<div id="Prime-toggle"
				style="width: 60px; margin-left: 10px; margin-right: 10px">
				<input type="checkbox" checked data-toggle="toggle"> <label
					style="font-family: 'Laila'">Prime </label>
			</div>
			<div id="Instant-toggle"
				style="width: 60px; margin-left: 10px; margin-right: 10px">
				<input type="checkbox" checked data-toggle="toggle"> <label
					style="font-family: 'Laila'">Instant </label>
			</div>
			<div id="hulu-toggle"
				style="width: 60px; margin-left: 10px; margin-right: 10px">
				<input type="checkbox" checked data-toggle="toggle"> <label
					style="font-family: 'Laila'">Hulu </label>
			</div>
			<div id="genre-dropdown"
				style="width: 80px; margin-left: 10px; margin-right: 10px">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						All <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Adventure</a></li>
						<li><a href="#">Animation</a></li>
						<li><a href="#">Biography</a></li>
						<li><a href="#">Comedy</a></li>
						<li><a href="#">Crime</a></li>
						<li><a href="#">Documentary</a></li>
						<li><a href="#">Drama</a></li>
						<li><a href="#">Family</a></li>
						<li><a href="#">Fantasy</a></li>
						<li><a href="#">History</a></li>
						<li><a href="#">Horror</a></li>
						<li><a href="#">Music</a></li>
						<li><a href="#">Musical</a></li>
						<li><a href="#">Mystery</a></li>
						<li><a href="#">Romance</a></li>
						<li><a href="#">Sci-Fi</a></li>
						<li><a href="#">Animation</a></li>
						<li><a href="#">Short</a></li>
						<li><a href="#">Sport</a></li>
						<li><a href="#">Thriller</a></li>
						<li><a href="#">War</a></li>
						<li><a href="#">Western</a></li>
					</ul>
					<label style="font-family: 'Laila'">Genre </label>
				</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div id="movie-fetch-waiting">
				<label style="font-family: 'Laila'">Fetching movies</label> <i
					class="fa fa-circle-o-notch fa-spin row" style="font-size: 12px"></i>
			</div>
			<div id="matching-movie-list-div">
			</div>
		</div>
	</div>
</body>
</html>