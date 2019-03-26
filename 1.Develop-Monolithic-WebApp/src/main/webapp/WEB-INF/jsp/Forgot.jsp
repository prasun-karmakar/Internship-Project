<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>Forgot Password Page</title>
<link rel="icon" href="Signify_2.png" type="png">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<script>
function validate()
{ 
 var username = document.form.username.value; 
 var email = document.form.email.value;
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(email==null || email=="")
 { 
 alert("email cannot be blank"); 
 return false; 
 } 
 document.forms["form"].submit();

}
function handleEnter(e) {
	  if(e.keyCode === 13){
	      compare()
	  }


</script>
<style>


html { 
	background: url(login_bg.jpg) no-repeat center fixed; 
	background-size: cover;
}


body {
    font: 17px Montserrat, sans-serif;
    line-height: 1;
    color: #f5f6f7;
}

.text_input {
	width: 63%;
	height: 25px;
	font: 17px Montserrat, sans-serif;
}

.extra_text_input {
	width: 70%;
}

.checkbox_input {
	width: 5%;
	height: 15px;
	
}

.font_style_form {
	font: 20px Montserrat, sans-serif;
}


.rounded_corner {
	border-radius: 6px;
}


.login_container {
	background-color:hsla(156, 100%, 50%, 0.5);
	position: absolute;
	top: 50%;
	left: 50%;
	text-align:center;
	transform:translate(-50%, -50%);
	width: 20%;
	display: block;

}

.font_style_form {
	font: 20px Montserrat, sans-serif;
}


.rounded_corner {
	border-radius: 6px;
}

.error_div_container {
	width: 100%;
	font: 20px Montserrat, sans-serif;
	text-align: center;
	color: Crimson;
	display: block;
}


.forgot_password_container {
	display: block;
}


</style>
</head>
<body>

<form name="form" action="loginRegister?actionType=forgot" method="post">

<div class="error_div_container">
	<h3 style="color:red;">${message}</h3>
    <h3 style="color:yellow;">${successMessage}</h3></div>
            <div class="login_container" id="login_div_id" display="none">
			<img src="Signify_3.png" alt="Signify_logo" style="width: 100%; height: 145px; padding-bottom: 10px;"/> <br/>
			<h3> Forgot Password :</h3>
			<input type="text" name="username" class="text_input" placeholder=" UserName "/> <br/> <br/>
			<input type="text" name="email" class="text_input" placeholder=" Email "/><br/> <br/>	
<input type="button" class="font_style_form rounded_corner" value="Submit" onclick="return validate()" onkeydown="handleEnter(event)"> &nbsp; | &nbsp;<input type="button" class="font_style_form rounded_corner"  value="Cancel" onclick="window.location.href='login.jsp';"><br /><br />
</div>
</form>
</body>
</html>


