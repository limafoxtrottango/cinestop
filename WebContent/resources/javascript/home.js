$(document).ready(function() {
	$("#searchbutton").click(function() {
		document.getElementById("movie-fetch-waiting").style.visibility = "visible";
		document.getElementById("matching-movies-list").innerHTML = "";
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
		var li = document.createElement("li");
		var poster = document.createElement('img');
		poster.src = data.poster;																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											
		//poster.wrap("<a href='http://localhost:8080/cinestop/searchMoviea?cinestopId=" + data.cinestopId + "'</a>");
		
		var a = document.createElement("a");
		a.setAttribute('href', "http://localhost:8080/cinestop/searchMoviea?cinestopId=" + data.cinestopId);
		li.appendChild(a);
		li.appendChild(poster);
		li.appendChild(document.createTextNode(data.title));
		li.appendChild(document.createTextNode(data.release));
		li.style.border = "thick solid black";
		ul.appendChild(li);
	}//for( var j = 0; j < data.length; j++ ) { 
	//	var o = data[j];
	//	var li = document.createElement("li");
	//	alert(o.title);
	//	li.appendChild(document.createTextNode(o.title));
	//	ul.appendChild(li);
	//}
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