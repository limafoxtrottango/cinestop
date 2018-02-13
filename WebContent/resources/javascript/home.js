$(document).ready(function() {
	var url = "/cinestop/getMatchingList";
	
	$("home_searchMediaInputText").autocomplete({
	   
	});
	  
	prefetchMediaList(document.getElementById("home_searchMediaInputText"), 1000, url);
});



function prefetchMediaList(textField, delay, url) {
    var timer = null;
    textField.onkeypress = function() {
        if (timer) {
            window.clearTimeout(timer);
        }
        timer = window.setTimeout( function() {
            timer = null;
            sendAJAXCall(url, getPayloadAsJSON(), mediaPrefetchSuccess, mediaPretechFailure);
        }, delay );
    };
    textField.onkeydown = function() {
        if (timer) {
            window.clearTimeout(timer);
        }
        timer = window.setTimeout( function() {
            timer = null;
            sendAJAXCall(url, getPayloadAsJSON(), mediaPrefetchSuccess, mediaPretechFailure);
        }, delay );
    };
    textField = null;
}

function getPayloadAsJSON() {
	jsonObj = [];
	item = {}
	item["searchedMediaName"] = $("#home_searchMediaInputText").val();
	item["type"] = "movie";
	jsonObj.push(item);
	return jsonObj;
}

function mediaPrefetchSuccess() {
	
}

function mediaPretechFailure() {
	
}