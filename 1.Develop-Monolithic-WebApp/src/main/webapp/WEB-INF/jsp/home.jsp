<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap"%>
<%@ page import= "java.util.Map"%>
<%@ page import="com.signify.internship.project.controller.UserServlet" %>
<%@ page import="com.signify.internship.project.dto.UserDTO" %>
<%@page import = "com.signify.internship.project.db.ResourceBundleManager" %>

<% Map<Integer,String> timezone_list=(HashMap<Integer,String>)request.getAttribute("timezone_list");%>


<%Map<Integer,String> language_list=(HashMap<Integer,String>)request.getAttribute("language_list");%>

<%ArrayList result=(ArrayList)request.getAttribute("result");%>


<%int languageId=(session.getAttribute("language_id")!=null)?Integer.valueOf((Integer)session.getAttribute("language_id")):1;%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Home Page</title>
		<link rel="icon" href="Signify_2.png" type="image/png">
		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
		
		<script>
	
		
		function pageLoad()
		{
			var result = <%=(ArrayList)request.getAttribute("result")%>;
			
			if(null!=result)
			{
				sampleDiv.style.display = 'block';
			   
			}	
			else
				{
				sampleDiv.style.display = 'none';
				}
}
		
					
		
		function getUserProfileDetail() {
		    // 1. Instantiate XHR - Start 

		    var xhr; 
		    if (window.XMLHttpRequest) 
		        xhr = new XMLHttpRequest(); 
		    else if (window.ActiveXObject) 
		        xhr = new ActiveXObject("Msxml2.XMLHTTP");
		    else 
		        throw new Error("Ajax is not supported by your browser");
		    // Instantiate XHR 
		    
		    // Handle Response from Server 

		    xhr.onreadystatechange = function () {     
		            if (xhr.readyState == 4 && xhr.status==200)
		            {
		            	var xmlDoc = xhr.responseXML; 
		            	var i;
		                if(null!=xmlDoc){
		                	sampleDiv.style.display='none';
		                	jsonFunc.style.display='none';
		    				document.getElementById("ajaxFunc").style.display = "block";

		    				var table="<tr><th>UserID</th><th>Mobileno</th><th>lastlogin</th><th>email</th><th>language_id</th></tr><br />";
		    				var x= xmlDoc.getElementsByTagName("User");
		    				for(i=0;i<x.length;i++){
		    					table+="<tr><td>"+x[i].getElementsByTagName("UserID")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("Mobileno")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("lastlogin")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("email")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("Language_Id")[0].childNodes[0].nodeValue+"</td></tr>";
		    					document.getElementById('ajaxFunc').innerHTML=table;
		    				}
		    				
			                
		                }
		    				
		    				
		           else{
		    				
		    				document.getElementById("ajaxFunc").style.display = "none";

		    			}

		              } 
		        }
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=myProfile");
		    
		}
		
		function getUserList() {
		    // 1. Instantiate XHR - Start 

		    var xhr; 
		    if (window.XMLHttpRequest) 
		        xhr = new XMLHttpRequest(); 
		    else if (window.ActiveXObject) 
		        xhr = new ActiveXObject("Msxml2.XMLHTTP");
		    else 
		        throw new Error("Ajax is not supported by your browser");
		    // Instantiate XHR 
		    
		    // Handle Response from Server 

		    xhr.onreadystatechange = function () {     
		            if (xhr.readyState == 4 && xhr.status==200)
		            {   
		            	
		            	var response = JSON.parse(xhr.responseText);
		            	
		            	if(null!=response)
		            	{
		            		signup_container.style.display='none';
		    				document.getElementById("jsonFunc").style.display = "block";
							
		            		var table="<tr><th>UserID</th><th>UserLinks</th></tr>"
		            		for(var i=0;i<response.length;i++){
		            		    
		            		    table+="<tr><td>"+response[i].Username+"</td><td>"+"<a href='#' onclick='updateUsersDetail(\""+response[i].Username+"\")'>edit</a>"+"</td></tr>";
		            		    document.getElementById("jsonFunc").innerHTML=table;

		            		}
		            }	
		            		
		            	   
		          
		    				
		    		else{
		    				
	    				document.getElementById("jsonFunc").style.display = "none";
		    			}

		             } 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=editUserProfile");
		    
		}
		
		function updateUsersDetail(username) {
			document.getElementById("jsonFunc").style.display = 'none';
			   var xhr,username; 
			   
			    if (window.XMLHttpRequest) 
			        xhr = new XMLHttpRequest(); 
			    else if (window.ActiveXObject) 
			        xhr = new ActiveXObject("Msxml2.XMLHTTP");
			    else 
			        throw new Error("Ajax is not supported by your browser");
			    // Instantiate XHR 
			    
			    // Handle Response from Server 

			    xhr.onreadystatechange = function () {     
			            if (xhr.readyState == 4 && xhr.status==200)
			            {   
			            	
			            	var response = JSON.parse(xhr.responseText);
			            	
			            	if(null!=response)
			            	{
			            		
			            		jsonFunc.style.display = 'none';
			            		signup_container.style.display='block';
	

			            		sampleDiv.style.display='none';
			            		
			            		
			            		/*var table="<tr><th>UserID</th><th>Email</th><th>Password</th><th>Mobileno</th></tr>";*/
			            		for(var i=0;i<response.length;i++){
			            			
			            		    document.getElementById("t1").value=response[i].Username;
			            		    document.getElementById("t2").value=response[i].Email;
			            		    document.getElementById("t3").value=response[i].Mobileno;
			            		   
			            		    document.getElementById("timezone_id").selectedIndex =response[i].Timezone_id ;
			            		    document.getElementById("language_id").selectedIndex =response[i].Language_id ;
			            		    alert(document.getElementById("language_id").selectedIndex);
	            		    

			            		   /* table+="<tr><td>"+response[i].Username+"</td><td>"+response[i].Email+"</td><td>"+response[i].Password+"</td><td>"+response[i].Mobileno+"</td></tr>";
			            		    document.getElementById("editUser").innerHTML=table;*/

			            		}
			            		
			            }	
			            		
			            	   
			          
			    				
			    		else{
		        			document.getElementById("signup_container").style.display = 'none';
		        			}


			            	
			            	
			             } 
			    }
			    
			        
			    xhr.open("POST", "loginRegister", true);
			    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhr.send("actionType=updateRecords&Username="+username+"");
			    
			   
			    /*xhr.open("POST", "loginRegister&actionType=updateRecords&Username="+username+"", true);
				xhr.send();*/
			    
			}
		
		function submission_form()
		{
			var t1=document.getElementById("t1").value;
			var t2=document.getElementById("t2").value;
			var t3=document.getElementById("t3").value;
			var t4=document.getElementById("timezone_id").value;
			var t5=document.getElementById("language_id").value
			var xhr; 
		    if (window.XMLHttpRequest) 
		        xhr = new XMLHttpRequest(); 
		    else if (window.ActiveXObject) 
		        xhr = new ActiveXObject("Msxml2.XMLHTTP");
		    else 
		        throw new Error("Ajax is not supported by your browser");
		    // Instantiate XHR 
		    
		    // Handle Response from Server 
	
		    xhr.onreadystatechange = function () {     
		            if (xhr.readyState == 4 && xhr.status==200)
		            {   
		   
		            
		            	signup_container.style.display = 'none';
		            	usersUpdate.style.display='block';
		            			      
		            		} 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=update&Username="+t1+"&Email="+t2+"&Mobileno="+t3+"&Timezone_id="+t4+"&Language_id="+t5+"");
		    
	}
	

			 
			
		
		



		/*var xhr; 
	    if (window.XMLHttpRequest) 
	        xhr = new XMLHttpRequest(); 
	    else if (window.ActiveXObject) 
	        xhr = new ActiveXObject("Msxml2.XMLHTTP");
	    else 
	        throw new Error("Ajax is not supported by your browser");
	    // Instantiate XHR 
	    
	    // Handle Response from Server 

	    xhr.onreadystatechange = function () {     
	            if (xhr.readyState == 4 && xhr.status==200)
	            {   
	            	
	            	var response = JSON.parse(xhr.responseText);
	            	
	            	if(null!=response)
	            	{
	            		alert("");
	            	}
	            	else{
	    				
	    				alert("");
	    			

	             } 
	    }
	        
	    }  
	   
	    xhr.open("POST", "loginRegister?actionType=updateRecords", true);
		xhr.send();*/
	    
	
	
</script>
		<style>
		
table {
    margin: 0 auto; /* or margin: 0 auto 0 auto */
  }

		html { 
			background: url(home_bg.bmp) no-repeat center fixed; 
			background-size: cover;
		}

		body {
			font: 17px Montserrat, sans-serif;
			line-height: 1;
			color: #f5f6f7;
			
		}
		ul li{
               padding:20px;
               border-bottom:2pxsolid grey;}

        ul li:hover{
               background:#bdc3c7;
               color:white;}
		
		/* Remove bullets */
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}
		
		.container-fluid {
			position: relative;
		}
		
		.side_nav {
			width: 18%;
			background-color:hsla(156, 100%, 50%, 0.5);
			height: 915px;
		}
		
		.side_nav_top {
		
		}
		
		.side_nav_bottom {
		
		}
		
		.page {
			width: 81%;
			position: absolute;
			right: 8px;
			top: 0px;
			height: 150px;
			
		}
		
		.page_header {
			position: absolute;
			width: 100%;
			height: 150px;
		}
		
		.page_body {
			position: absolute;
			width: 100%;
			right: 0px;
			top: 235px;
			background-color:hsla(156, 100%, 50%, 0.5);
			height: 680px;
		}
		 
		.nav_image_div {
			width: 100%;
			background-size: cover;
			height: 280px;
		}
		.navigation{
		font: 17px Montserrat, sans-serif;
		
		}
		#updateList{
		display:"none";
	     width: 100%;
         text-align: center;
         margin-top: 1px;
		
		}
		
		#sampleDiv{
		display: "none";
	     width: 100%;
         text-align: center;
         margin-top: 1px;
		
		}
		
		
		table#jsonFunc{
		margin-top: 50px;
		display:"none";
	    width: 50%;
        padding: 50px 0;
        margin: 0 auto;
		text-align: center;
  		border-collapse : collapse;}
  		
  		#usersUpdate{
		
		position: absolute;
		text-align: center;
		top: 50%;
		left: 50%;
		display:none;
		}
		
		
		
		#signup_container{
		
		position: absolute;
		text-align: center;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		display:none;
		}
		
		table#ajaxFunc{
		margin-top: 50px;
		display:"none";
	    width: 50%;
        padding: 50px 0;
        margin: 0 auto;
		text-align: center;
  		border-collapse : collapse;
		}
		table#editUser{
		margin-top: 20px;
		display:"none";
	    width: 50%;
        padding: 50px 0;
        margin: 0 auto;
		text-align: center;
  		border-collapse: collapse;
		}
		
		.text_input {
		width: 90%;
		height: 25px;
		font: 17px Montserrat, sans-serif;
		}

		.extra_text_input {
		width: 90%;
		}
		
		
		
		th,td {
		display:"none";
		border : 1px solid black;
		margin: 0 auto;
  		text-align: center;
  		border-collapse: collapse;
		padding: 5px;
		}
		

		img {	
			width: 100%;
			height: 230px;
		}
		
		.topright {
		  position: absolute;
		  top: 8px;
		  right: 16px;
		  font-size: 20px;
		}
		
		.topleft {
		  position: absolute;
		  top: 8px;
		  left: 16px;
		  font-size: 30px;
		}
		.table .thead-light th {
 
  color: #401500;
 
  background-color: #FFDDCC;
 
  border-color: #792700;
 
}
			
</style>
	</head>

	<body onload="pageLoad()">
	
		
		<div class="container-fluid"> <!-- Parent Container -->
			<div class=""> <!-- Parent Row container -->
				<div class="side_nav"> <!-- Column Div (Left Side Nav) -->
					<div class=""> <!-- Row within column div -->
						<div class="nav_image_div"> <!-- column within row div --> <!-- User Profile header on top of Nav menu links -->
							<div class="">								
								<img src="admin.jpg" alt="Profile Image" style="border-radius: 5%;">
								<h3><%=ResourceBundleManager.getString("MessageBundle","Hello",languageId)%> ${username}</h3>								
							</div>
						</div>
						<hr> <br>
						<div class="navigation"> <!-- column within row div --> <!-- Navigation Menu links -->
							<div class=""> <!-- Child Row div -->
								<ul class="">
									
									<li class="active"><a href="loginRegister?actionType=list_UserRecords" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","registeredUsers",languageId)%></a></li> 
									<li class="active"><a href="#section1" onclick="getUserProfileDetail()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","myProfile",languageId)%></a></li> 
									<li><a href="#section2" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","addNewUser",languageId)%></a></li> 
									<li class="active"><a href="#section3" onclick="getUserList()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","editUserProfile",languageId)%></a></li> 
									<li><a href="#section3" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","removeUser",languageId)%></a></li> 
									<li><a href="changepassword.jsp" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","changePassword",languageId)%></a></li>
									<li><a href="loginRegister?actionType=logout" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","logout",languageId)%></a></li>
								</ul> <br>
							</div>
						</div>		
					</div>	
				</div>
			
				<div class="page"> <!-- Column Div (Right Side Nav) --> 
					<div class="page_header"> <!-- Row within column div --> <!-- Right side top container -->
						<div class=""> <!-- column within row div -->
							<div class="nav_image_div">
								<img src="signify_header.jpg" alt="signify_header.png" class="">
								<div class="topleft"><%=ResourceBundleManager.getString("MessageBundle","welcome",languageId)%></div>
								<div class="topright"><%=ResourceBundleManager.getString("MessageBundle","lastLoginTime",languageId)%>:${value} </div>
							</div>
						</div>
					</div>
					
					<div class="page_body"> <!-- Row within column div --> <!-- Right side body container -->
						
						<div id="signup_container">
							Username:<input type="text" name="username" class="text_input extra_text_input" placeholder="Username" id="t1" /> <br /><br /> 
							Email:<input type="text" name="email" class="text_input extra_text_input" placeholder="Email" id="t2" /> <br /><br />
							Mobileno:<input type="text" name="mobileno" class="text_input extra_text_input" placeholder="Mobileno" id="t3" /><br /> <br /> 
							Timezone_id:
							<div style="height: 40px;">
								<select id="timezone_id" name="name" style="width:90%" >
								<option value="none">Select</option> 
								<%if(timezone_list!=null){
         							for(Map.Entry<Integer, String> entry:timezone_list.entrySet()) {
         							Integer timezone_id=entry.getKey();
          							String name=entry.getValue();%>
         								<option value="<%=timezone_id %>"><%=name%></option>
         								<%}%><%} %> </select></div>
         								
         								
 			
        					Language_id:
        						<div style="height: 5px;">
									<select id="language_id" name="language_id" style="width:90%" >
									<option value="none">Select</option> 
									<%if(language_list!=null){
         							for(Map.Entry<Integer, String> entry: language_list.entrySet()) {
         								Integer language_id=entry.getKey();
         								String language_name=entry.getValue();%>
        									<option value="<%=language_id %>"><%=language_name%></option>
         							<%}%> <%}%>  
         						</select></div> <br/> <br/><br/>
        
							<button onclick="submission_form()">Submit</button> &nbsp;| &nbsp;<input type="button" value="Cancel" onclick="getUserList()"> <br /> <br />
						</div>
						<div id="usersUpdate">
						<p>Users Detail updated</p>
						</div>
						
							<div id="sampleDiv" >
							
								<input id="username" name="username" type="hidden" value="${messages}">
								<table class="table table-striped" width="70%">
									<thead class="thead-light">
										<tr>
											<th>UserName</th><br />
											<th>Email</th><br />
											<th>MobileNo</th><br />
											<th>Timezone_id</th>
										</tr>
									</thead>
								<tbody>
					
									<tr>
									<%if(null!=result) {%>
									<%for(int count=0;count<result.size();count++){ %>
										<tr>
											<%UserDTO userDTO=(UserDTO)result.get(count); %>
											<td><%=userDTO.getUsername() %></td>
											<td><%=userDTO.getEmail() %></td>
											<td><%=userDTO.getMobileno() %></td>
											<td><%=userDTO.getTimezone_id() %></td>
											
										</tr>
									
								    <%}%> 
								    <%}%>
				    			</tbody>
				    		</table>
					</div>
					
					<table id="jsonFunc">
					
					</table>
					
					<table id="ajaxFunc">
							
					</table>
					
		
		
					</div>
				
				</div>
				
			</div>
		</div>
		

	</body>
</html>

