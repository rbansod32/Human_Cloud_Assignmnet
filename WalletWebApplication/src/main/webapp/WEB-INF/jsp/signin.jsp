<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wallet-SignIn</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	background-color: lightblue;
}

.login-form {
    width: 500px;
    margin: 225px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
</head>
<body>
	
	<div class="login-form">
	    
	    <form>
	        
	        <h2 class="text-center">Welcome Login</h2>
	        <div class="form-group">
	            <input type="text" class="form-control" id="username" placeholder="Username" required="required">
	        </div>
	        <div class="form-group">
	            <input type="password" class="form-control" id="password" placeholder="Password" required="required">
	        </div>
	        <div class="form-group">
	            <button type="submit" class="btn btn-primary btn-block" id="userSignIn">Log in</button>
	        </div>
	    
	    	<p class="text-center">Don't have a account ? <a href="signup.html">Sign Up</a></p>
	    	
	    </form>
	    
	</div>
	
</body>

<script>

$(document).ready(function() {
	
	$("#userSignIn").click(function() {
		
		var username = $("#username").val();
		var password = $("#password").val();
		
		var link = "http://localhost:8081/userSignIn";
		
		$.ajax({
            
			url: link,
            type: "POST",
            dataType: "json",
            data: {
            	username: username,
            	password: password
            },
            success: function(response) {

            	if(response.responseMessage == "SUCCESS"){
            		window.location.href = 'http://localhost:8080/dashboard.html?username='+username+'&userInfo='+response.responseData;
            	}else{
            		alert(response.responseMessage);
            	}
            	
            }
            
        });
		
	});
	
});

</script>

</html>



