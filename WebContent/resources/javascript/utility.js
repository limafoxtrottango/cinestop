$(document).ready(function() {
	
});

function sendAJAXCall(url, parameters, successCallback, errorCallBack){
	$.ajax({
		type: 'POST',
		url: url,
		data: JSON.stringify(parameters),
		contentType: 'json',
		success: successCallback,
		error: errorCallBack
	});
}
