$(document).ready(function() {
	$("#searchbutton").click(function() {
		document.getElementById("movie-fetch-waiting").style.visibility = "visible";
		document.getElementById("matching-movie-list-div").innerHTML = "";
		$.ajax({
			type: "POST",
			url: "/cinestop/searchMovie",
			data: JSON.stringify(getQuery()),
			contentType: "application/json",
			dataType: "json",
			success: matchingMoviesFetchSuccess,
			failure: matchingMoviesFetchFailure
		});
	});
});

function getQuery() {
	var obj = {}
	obj["title"] = $("#home_searchMediaInputText").val();
	return obj;
}

function matchingMoviesFetchSuccess(response) {
	document.getElementById("movie-fetch-waiting").style.visibility = "hidden";
	var ul = document.getElementById("matching-movies-list");
	for( var i = 0; i < response.length; i++ ) {
		var data = response[i];
		var poster = document.createElement("img");
		poster.setAttribute("src", data.poster);
	    poster.setAttribute("alt", "Poster");
	    
	    var a = document.createElement("a");
	    a.setAttribute("href", "#");
	    a.appendChild(poster);
	    
	    var media = document.createElement('div');
	    media.className = "media";
	    
	    var media_left_media_middle = document.createElement('div');
	    media_left_media_middle.className = "media_left media_middle";
	    media_left_media_middle.append(a);
	    
	    media.append(media_left_media_middle);
	    
	    var title = document.createElement("h4");
	    title.className = "media-heading";
	    title.style.fontFamily = "Aguafina Script";
	    
	    var t = document.createTextNode(data.title);
	    title.append(t);
	    
	    var media_body = document.createElement('div');
	    media_body.className = "media-body";
	    
	    media_body.append(title);
	    
	    media.append(media_body);
	    
	    document.getElementById("matching-movie-list-div").append(media); 
	    document.getElementById("matching-movie-list-div").append(document.createElement('br'));
	}
}

function matchingMoviesFetchFailure(response) {
	
}

function mediaPrefetchSuccess(response) {
	$("#home_searchMediaInputText").autocomplete({
		source: response,
		maxShowItems: 5,
		messages: {
	        noResults: '',
	        results: function() {}
	    	}
		});
	$( "#home_searchMediaInputText" ).autocomplete("widget").addClass("fixedHeight");
}

function mediaPretechFailure() {
	
}