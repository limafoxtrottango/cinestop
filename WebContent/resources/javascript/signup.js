$(document).ready(function() {
	var url = "/cinestop/checkUsername";
	checkUsernameAvailability(document.getElementById("username"), 1000, url);
	$("#password2").keyup(checkPasswordMatch);
	$('#signup-button').click(function() {
		sendAJAXCall("/signupUser", getFormDataJSON(), formSubmitSuccess, formSubmitFailure);
	});
	
});

function checkPasswordMatch() {
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	if(password1 === password2) {
		
	}
}

function formSubmitSuccess() {
	
}

function formSubmitFailure() {
	
}

function getFormDataJSON() {
	jsonObj = [];
	item = {}
	item["username"] = $("#username").val();
	item["password"] = $("#password1").val();
	item["email"] = $("#email").val();
	jsonObj.push(item);
	return jsonObj;
}

function checkUsernameAvailability(textField, delay, url) {
    var timer = null;
    textField.onkeypress = function() {
        if (timer) {
            window.clearTimeout(timer);
        }
        timer = window.setTimeout( function() {
            timer = null;
            sendAJAXCall(url, getUsernameAsJSON(), userNameAvailableSuccess, userNameAvailableFailure);
        }, delay );
    };
    textField = null;
}

function getUsernameAsJSON() {
	jsonObj = [];
	item = {}
	item["username"] = $("#username").val();
	jsonObj.push(item);
	return jsonObj;
}

function userNameAvailableSuccess() {	
	$("#username").addClass("form-control is-valid");
}

function userNameAvailableFailure() {
	$("username").addClass("bordered-red");
}