<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.signify.internship.project.controller.UserServlet" %>
<%@ page import="com.signify.internship.project.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>Reset Password Page</title>
<link rel="icon" href="Signify_2.png" type="png">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<script>
function validate()
{ 

 var password1 = document.form.password1.value; 
 var password2 = document.form.password2.value;
 if (password1==null || password1=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 }
 else if(password2==null || password2=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
 document.forms["form"].submit();
}

function handleEnter(e) {
	  if(e.keyCode === 13){
	      compare()
	  }
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

.error_div_container {
	width: 100%;
	font: 20px Montserrat, sans-serif;
	text-align: center;
	color: Crimson;
	display: block;
	


}

.login_container {
	background-color:hsla(156, 100%, 50%, 0.5);
	position: absolute;
	top: 50%;
	left: 50%;
	text-align:center;
	transform: translate(-50%, -50%);
	width: 20%;
	display: block;

}



.forgot_password_container {
	display: block;
}


</style>
</head>
<body>

<form name="form" action="loginRegister" method="post" onsubmit="return validate()">
<input type="hidden" name="actionType" id="actionType_id" value="resetpassword">

<div class="error_div_container">
<h3 style="color:red;">${message}</h3>
    <h3 style="color:yellow;">${successMessage}</h3>
	</div>
		<div class="login_container" id="login_div_id" display="none">
			<img src="Signify_3.png" alt="Signify_logo" style="width: 100%; height: 145px; padding-bottom: 10px;"/> <br/>
			<h3> Reset Password Page :</h3>
		<input id="username" name="username" type="hidden" value="${messages}">
			<input type="password" name="password1" class="text_input" placeholder=" password "/> <br/> <br/>
			<input type="password" name="confirmPassword" class="text_input" placeholder="Confirm Password "/><br/> <br/>
<button name="submit" class="font_style_form rounded_corner" onkeydown="handleEnter(event)">Submit</button> &nbsp;| &nbsp;<input type="button" value ="Cancel" class="font_style_form rounded_corner" onclick="window.location.href='login.jsp'"> <br/> <br/>
		</div>
</form>
</body>
</html>

