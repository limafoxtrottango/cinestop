var fromPage = 0;
var toPage = 10;

$(document).ready(function() {
	 $('[data-toggle="tooltip"]').tooltip();
	$("#searchbutton").click(function() {
		fromPage = 0;
		toPage = 10;
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
		fromPage = fromPage + 10;
		toPage = toPage + 10;
	});
});

window.onscroll = function (e) {  
	if(isElementVisible(document.getElementById('pagination-div'))) {
			$.ajax({
				type: "POST",
				url: "/cinestop/searchMovie",
				data: JSON.stringify(getQuery()),
				contentType: "application/json",
				dataType: "json",
				success: matchingMoviesFetchSuccess,
				failure: matchingMoviesFetchFailure
			});
			fromPage = fromPage + 10;
			toPage = toPage + 10;
	}
} 

function isElementVisible(el) {
    var rect     = el.getBoundingClientRect(),
        vWidth   = window.innerWidth || doc.documentElement.clientWidth,
        vHeight  = window.innerHeight || doc.documentElement.clientHeight,
        efp      = function (x, y) { return document.elementFromPoint(x, y) };     

    // Return false if it's not in the viewport
    if (rect.right < 0 || rect.bottom < 0 
            || rect.left > vWidth || rect.top > vHeight)
        return false;

    // Return true if any of its four corners are visible
    return (
          el.contains(efp(rect.left,  rect.top))
      ||  el.contains(efp(rect.right, rect.top))
      ||  el.contains(efp(rect.right, rect.bottom))
      ||  el.contains(efp(rect.left,  rect.bottom))
    );
}


function getQuery() {
	var obj = {}
	obj["title"] = $("#home_searchMediaInputText").val();
	obj["fromPage"] = fromPage;
	obj["toPage"] = toPage;
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
	    
	    var title = document.createElement("h3");
	    title.className = "media-heading";
	    title.style.fontFamily = "Aguafina Script";
	    title.style.marginLeft = "10px";
	    
	    var t = document.createTextNode(data.title);
	    title.append(t);
	    
	    var media_body = document.createElement('div');
	    media_body.className = "media-body";
	    
	    media_body.append(title);
	    
	    //<p style="font-family: 'Laila'; color: white; text-align: justify">${mediaInfo.plot}</p>
	    
	    var runtime = document.createElement("p");
	    runtime.style.fontFamily = "Laila";
	    runtime.style.marginLeft = "10px";
	    
	    var runtimeText = document.createTextNode(data.runtime + " min");
	    
	    runtime.append(runtimeText);
	    
	    media_body.append(runtime);
	    
	    var plot = document.createElement("p");
	    plot.style.fontFamily = "Laila";
	    plot.style.marginLeft = "10px";
	    
	    var plotText = document.createTextNode(data.plot);
	    
	    plot.append(plotText);
	    
	    media_body.append(plot);
	    
	    var director = document.createElement("p");
	    director.style.fontFamily = "Laila";
	    director.style.marginLeft = "10px";
	    
	    var directorText = document.createTextNode(data.director);
	    
	    director.append(directorText);
	    
	    media_body.append(director);
	    
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