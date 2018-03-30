$(document).ready(function() {
	$("#upvote-alert").hide();
	$("#downvote-alert").hide();
	$("#authentication-alert").hide();
	$("#unknown-error-alert").hide();
	
	
	$('#cinestop-upvote-img').click(function() {
		$.ajax({
			type : "POST",
			url : "/cinestop/voting",
			data : {
				mediaName : document.getElementById("mediaName").value,
				action : "upvote"
			},
			success : function() {
				$("#upvote-alert").fadeTo(2000, 500).slideUp(500, function() {
					$("#upvote-alert").slideUp(500);
				});
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if(textStatus == 'unauthorized') {
					$("#authentication-alert").fadeTo(2000, 500).slideUp(500, function() {
						$("#authentication-alert").slideUp(500);
					});
				} else {
					$("#unknown-error-alert").fadeTo(2000, 500).slideUp(500, function() {
						$("#unknown-error-alert").slideUp(500);
					});
				}
			}
		});
	});

});
