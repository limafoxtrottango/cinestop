$(document).ready(function() {
	var url = "/cinestop/checkUsername";
	checkUsernameAvailability(document.getElementById("username"), 1000, url);
	$("#password2").keyup(checkPasswordMatch);
	$('#signup-button').click(function() {
		sendAJAXCall("/cinestop/addNewUser", getFormDataJSON(), formSubmitSuccess, formSubmitFailure);
	});
	$('#username').click(function() {
		$('#username').css("border", "");
		$("#username").popover("hide");
		
	});
});

function checkPasswordMatch() {
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	if(password1 === password2) {
		$("#password2").popover("hide");
	} else {
		$("#password2").popover({
			content: "Passwords do not match",
		});
		$("#password2").popover("show");
	}
}

function formSubmitSuccess() {
	
}

function formSubmitFailure() {
	
}

function getFormDataJSON() {
	jsonObj = [];
	item = {}
	item["userName"] = $("#username").val();
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
    textField.onkeydown = function() {
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
	item["userName"] = $("#username").val();
	item["password"] = $("#password1").val();
	item["email"] = $("#email").val();
	jsonObj.push(item);
	return jsonObj;
}

function userNameAvailableSuccess() {
	$('#username').css("border", "");
	$('#username').css("border-radius", "");
	$("#username").popover("hide");
}

function userNameAvailableFailure() {
	$('#username').css("border", "1px solid #FE0000");
	$('#username').css("border-radius", "2px");
	$("#username").popover({
		content: "Username not available",
	});
	$("#username").popover("show");
}