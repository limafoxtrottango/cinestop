<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron d-flex align-items-left">
		<div class="container">
			<c:if test="${not empty mediaList}">
				<c:forEach var="mediaInfo" items="${mediaList}">
					<!-- Left-aligned media object -->
					<div class="media">
						<div class="media-left">
							<img src="${mediaInfo.poster}" class="class="img-responsive">
						</div>
						<div class="media-body">
							<h2 class="media-heading">${mediaInfo.name}</h2><br>
							<h4 class="media-heading">IMDb: ${mediaInfo.imdb_rating}</h4>
							<h4 class="media-heading">IMDb votes: ${mediaInfo.imdb_votes}</h4>
							<h4 class="media-heading">Tomatometer: ${mediaInfo.tomatometer}</h4>
							<h4 class="media-heading">Metacritic: ${mediaInfo.metacritic}</h4>
							<h4 class="media-heading">Director: ${mediaInfo.director}</h4>
							<h4 class="media-heading">Actors: ${mediaInfo.actors}</h4>
							<h4 class="media-heading">Plot: ${mediaInfo.story}</h4>
							<h4 class="media-heading">Released: ${mediaInfo.released}</h4>
							<h4 class="media-heading">Available on Netflix: ${mediaInfo.netflix}</h4>
							<h4 class="media-heading">Available on Prime: ${mediaInfo.prime}</h4>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>
