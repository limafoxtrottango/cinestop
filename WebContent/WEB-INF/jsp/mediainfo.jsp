<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<html lang="en">
<head>
<%@page pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Aguafina Script'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Laila'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Laila'
	rel='stylesheet'>
<link href="<c:url value="/resources/styles/main.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css"
	type="text/css" media="all" />

<script src="http://127.0.0.1/assets/js/commento.min.js"
	type="text/javascript"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"
	type="text/javascript"></script>
<script src="<c:url value="/resources/javascript/updown.js" />"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.3/jquery.jqgrid.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/javascript/utility.js" />"></script>
<script src="<c:url value="/resources/javascript/mediaInfo.js" />"></script>
<link href='http://fonts.googleapis.com/css?family=Berkshire+Swash' rel='stylesheet' type='text/css'>
</head>
<body>
	<div style='position: relative; top: 0%; left: 50%'>
		<div class="alert alert-success" id="upvote-alert"
			style='z-index: 1; position: absolute'>Up-vote recorded</div>
		<div class="alert alert-warning" id="downvote-alert"
			style='z-index: 2; position: absolute'>Down-vote recorded</div>
		<div class="alert alert-danger" id="authentication-alert"
			style='z-index: 3; position: absolute'>You need to be logged-in
			to up-vote or down-vote</div>
		<div class="alert alert-danger" id="unknown-error-alert"
			style='z-index: 4; position: absolute'>Some error occurred</div>
	</div>
	<div style="position: absolute">
		<p class="media-heading"
			style="font-family: 'Berkshire Swash'; font-size: 20px; color: yellow">${mediaInfo.tagline}</p>
	</div>
	<div class="d-flex align-items-center" id="upper-half"
		style="background-image: url('${mediaInfo.backdrop}')">
		<div class="tint"></div>
		<div class="container" id="abc">
			<!-- Left-aligned media object -->
			<div class="row">
				<div class="col-md-4">
					<img src="${mediaInfo.poster}" class="img-responsive" style="border-radius: 5px">
				</div>
				<div class="col-md-8">
					<p class="media-heading"
						style="font-family: 'Aguafina Script'; font-size: 40px; color: pink">${mediaInfo.title}</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">
						<c:forEach items="${mediaInfo.genres}" var="genre">
							${genre}, 
						</c:forEach>
						${mediaInfo.runtime} min
					</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">${mediaInfo.plot}</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">Release
						date: ${mediaInfo.release}</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">Language:
						${mediaInfo.language}</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">Budget:
						${mediaInfo.budget}</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">Reveue:
						${mediaInfo.revenue}</p>
					<div class="row">
						<div class="col-md-1">
							<img style="border-radius: 2px"
								src="https://i.imgur.com/qJgKouM.jpg">
						</div>
						<div class="col-md-4">
							<p
								style="font-family: 'Laila'; color: white; text-align: justify; margin-top: 5px !important">
								${mediaInfo.imdbRating}/10.0 based on ${mediaInfo.imdbVotes}
								votes</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-1">
							<img src="https://i.imgur.com/K7QJgaF.jpg">
						</div>
					</div>
					<p style="font-family: 'Laila'; color: white; text-align: justify">Homepage:
						${mediaInfo.homepage}</p>
					<br>
				</div>
			</div>
		</div>
	</div>
	<div class="tabbable boxed parentTabs" id="lower-half">
		<ul class="nav nav-pills">
			<li class="nav-item active"><a data-toggle="tab"
				class="nav-link active" href="#reviews">Reviews</a></li>
			<li class="nav-item"><a data-toggle="tab" class="nav-link"
				href="#credits">Credits</a></li>
			<li class="nav-item"><a data-toggle="tab" class="nav-link"
				href="#">Trivia</a></li>
			<li class="nav-item"><a data-toggle="tab" class="nav-link"
				href="#discussion">Discussion</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane fade active" id="reviews">
				<div class="tabbable">
					<ul class="nav nav-pills">
						<li class="active"><a href="#roger-ebert">Roger Ebert</a></li>
						<li><a href="#rotten Tomatoes">Rotten Tomatoes</a></li>
					</ul>
					<div class="tab-content clearfix">
						<div class="tab-pane active" id="1a">
							<div>
								<div
									style="background-image: url('https://i.imgur.com/PZaVhRS.gif'); background-position: right center; background-repeat: no-repeat;">
									<h2 style="font-family: 'Aguafina Script'">Reviewer:
										${roger.reviewer}</h2>
									<h3 style="font-family: 'Aguafina Script';">Score:
										${roger.rating}</h3>
								</div>
								<div class="review-row">
									<div class="review-col" id="review-col-left">
										<p style="text-align: justify">${mediaInfo.rogerEbert.review_col_1}</p>
									</div>
									<div class="review-col" id="review-col-right">
										<p style="text-align: justify">${mediaInfo.rogerEbert.review_col_2}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="credits">
				<div class="tabbable">
					<ul class="nav nav-pills">
						<li class="nav-item active"><a data-toggle="tab"
							class="nav-link" href="#cast">Cast</a></li>
						<li class="nav-item"><a data-toggle="tab" class="nav-link"
							href="#crew">Crew</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="cast">
							<div class="row">
								<c:forEach items="${mediaInfo.cast}" var="cast">
									<div class="col-md-1">
										<p
											style="font-family: 'Laila'; color: black; text-align: justify">${cast.name}</p>

										<c:choose>
											<c:when
												test="${cast.profile_path == 'https://image.tmdb.org/t/p/w138_and_h175_facenull'}">
												<img src="https://i.imgur.com/uEihXl9.jpg"
													style="border-radius: 5px">
											</c:when>
											<c:otherwise>
												<img src="${cast.profile_path}" style="border-radius: 5px">
											</c:otherwise>
										</c:choose>

										<p
											style="font-family: 'Laila'; color: black; text-align: justify">${cast.character_name}</p>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="tab-pane fade in" id="crew">
							<div class="row">
								<c:forEach items="${mediaInfo.crew}" var="crew">
									<div class="col-md-1">
										<c:choose>
											<c:when
												test="${crew.profile_path == 'https://image.tmdb.org/t/p/w138_and_h175_facenull'}">
												<img src="https://i.imgur.com/uEihXl9.jpg"
													style="border-radius: 5px">
											</c:when>
											<c:otherwise>
												<img src="${crew.profile_path}" style="border-radius: 5px">
											</c:otherwise>
										</c:choose>
										<p
											style="font-family: 'Laila'; color: black; text-align: justify">${crew.job}</p>
										<p
											style="font-family: 'Laila'; color: black; text-align: justify">${crew.name}</p>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade in" id="discussion">
				<div id="commento" style="background: black"></div>
			</div>
		</div>
	</div>
	<script>
		window.onload = function() {
			Commento.init({
				serverUrl : "http://127.0.0.1",
			});
		}
	</script>
</body>
</html>