$(document).ready(function() {
	
});

function sendAJAXCall(url, parameters, successCallback, errorCallBack){
	$.ajax({
		type: 'POST',
		url: url,
		data: { cinestopId: "npM1Zb"},
		success: successCallback,
		error: errorCallBack
	});
}
