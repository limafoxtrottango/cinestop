<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<html lang="en">
<head>
<meta charset="utf-8">
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
	<div class="d-flex align-items-center" id="upper-half"
		style="background-image: url('${mediaInfo.backdrop}')">
		<div class="tint"></div>
		<div class="container" id="abc">
			<!-- Left-aligned media object -->
			<div class="media">
				<input type="hidden" id="mediaName" value="${mediaInfo.title}">
				<div class="media-left" style="position: relative"">
					<img
						src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAHjSURBVGhD7dhNSFRRHEDx6QOJKFoJIkItbBUFIVKItNAgEBeCtHARLVq0DIJWgqi0iCBx4SIiCBSCQAkERRCRVgWBQdSqTVBQRESQIlJ+nBPzYBYxzOh7zhv6H/ghc9F372XmvsdYiKIoiqIo+j87WPxZ1x3BIq7/fVWnNWAW2/iDq6i7DuEZ3MRq8ecGelE3HcATuPgfOIfR4ut1dCP3uYkJuOifuICkMTi+hg4H8tx9JIu95EBJbvIRkk22IZcNwUV6Fq448I88O1Pw977hLHLVbbi43+hzoExuZgb+/he0IhfdxBa8xQ44UEHemufhZj7hJGraNWzCjdxwoIqOYhlu5gOaUZP64bvgQm45sIuO4xW8xjs0Yl/rgYfaBQw6sIdO4A281krx9b7UBW+vTnzXgRTynXgPr/kSx5BpF/ELTjjuQIq1wLPitZfgGcqk8/BB5kSP4QMu7U7Bu5hzzMG7W6qdgQ8wJ3gKnwVZdRpf4VzTSG0uH1if4YWf4zCyzif+dzjnJPb85czP7Ud4wQWk/laXqR3JR/khdv1RbkJy+F4gs8NXpk4kd8gHDlSbt8O38AKeDR9+l2vkHlyHRlBxPpBeI/njvLmDihqG/zDIs9IvbFEURVEURVEURTWsUNgBmtCzxB/KaMAAAAAASUVORK5CYII=">

					<div>
						<div>
							<img
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAGrSURBVGhD7dY/KAZxHMfxE1EWCTFY/BlEiYlNLLKRjWwyiplMokxiJZsyKZtYlEHZTEqkmAz+hEH+vj/DlYTnuXt+d7+Hvu96LT/u7ve75/4FlmVZlmVZlmX9h+pQn+cqkLFxvOexSzQiq6YQbviAU4/OEc7lCs2I1Cy08SN6NOChAqxC87hFG2K1CO3kHp0aSLklODm+zsgKwjPSjrSaQ3hFdGsg1wqxDu1U12gLkm4aOt4T+jTgqiJsQjuP9NSI0QR0nBcMasB1xdiGDqInSS1cN4o3vGJEA0lVij1oMSeogauGoF9BCxnTQNKV4QBazBEqkWsD0CK0z0kNpFU5tAgd+BBaXNx6oZta+5rRQNpV4RiawD502UWtC3q8ah8LGvCVbnh9RmgiuyhBtnXgDtp2WQO+09foBTShLejplqlW3EDbrEEv3ryoCXpZamIb0Ev0p6L8r5d0lq/x21luQNRfz0u67vVNpol+ve51P51Bf9tBlPvJS989iVw84bz0+d0wD1fvHC/14xlagLj6CvBS+P2k77JqDfzlhpHEl7JlWZZlWZaVSkHwAfYqs8zHViqMAAAAAElFTkSuQmCC">
						</div>
						<div>
							<img id="cinestop-upvote-img"
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAFSSURBVGhD7ZUxTgMxEEUX0dFTUK2NaHMAWg4BN4iUk1CjYAdqUtFxi9yBkgMQbAkJCcl4oikQmWKzO/au0H/S75L5f6MkrwEAAAAAAAC0Dx+Xxof5lEKbeF53Lu7CqfHx1fqYphDaQpt43mGY+882fxJv0uGaoQ20hWf1wy7jzLi4lQpqZNe9jDOeM4xzH6+MC19SUclQJ3XzDB3MKl5bF76lwiLJXdTJ9bpYHxZiaZGEBdeWIX9nb+VivVAH1xUkpaP8L/IkDdAI3aYObivMczq2Lr5IQwYl36Tb3FKHs8d0kss3e2P6Z0M3+XxdtOw/yNpatKt3M8T+9F66wefGpa/9Va2txaH2L2JtLfInfNPJ/mTt/Fp+2zTpZv/C1taCzCw/wO53UcHaWpD9XVjvP0RY17O2Fn/tP4a1tfhl//GsrQUZe3RrAwAAAAAA8I9omh+JpnWVeC/6OAAAAABJRU5ErkJggg==">
						</div>
					</div>
				</div>
				<div class="media-left">
					<img src="${mediaInfo.poster}" class="class="
						img-responsive" style="background-blend-mode: lighten;">
				</div>
				<div class="media-body">
					<h5></h5>
					<p class="media-heading"
						style="font-family: 'Aguafina Script'; font-size: 40px; color: white">${mediaInfo.title}</p>
					<p class="media-heading"
						style="font-family: 'Aguafina Script'; font-size: 20px; color: yellow">${mediaInfo.tagline}</p>
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
						${mediaInfo.budget}M USD</p>
					<p style="font-family: 'Laila'; color: white; text-align: justify">Reveue:
						${mediaInfo.revenue}M USD</p>
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
						<li data-toggle="tab" class="active"><a href="#cast">Cast</a></li>
						<li data-toggle="tab" class="crew"><a href="#crew">Crew</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active">
							<div class="row">
								<c:forEach items="${mediaInfo.cast}" var="cast">
									<div class="col-md-1">
										<p
											style="font-family: 'Laila'; color: black; text-align: justify">${cast.name}</p>

										<c:choose>
											<c:when test="${cast.profile_path == 'https://image.tmdb.org/t/p/w138_and_h175_facenull'}">
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
						<div class="tab-pane fade in">
							<div class="row">
								<c:forEach items="${mediaInfo.crew}" var="crew">
									<div class="col-md-2">
										<img src="${crew.profile_path}">
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