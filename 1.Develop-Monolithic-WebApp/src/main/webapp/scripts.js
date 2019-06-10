function getRegisteredUserList() {
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
		            		editUserList.style.display='none';
		            		document.getElementById("deleteUser").style.display = 'none';
		            		signup_container.style.display='none';
		            		profileDetail.style.display='none';
		            		usersList.style.display ='block';
		            		userProfileDetail.style.display='none';
		            		resetPassword.style.display='none';
		            		getUserListForUpdate.style.dispaly='none';
		            		document.getElementById("resetUserPassword").style.display = "none";
		            		document.getElementById("usersUpdate").style.display = "none";
		            		registeredUsers.style.display='block';
		            		document.getElementById("registeredUsers").style.display = "block";
							var table="<tr><th>UserName</th><th>Email</th><th>Mobileno</th><th>Timezone</th><th>Language</th></tr>"
		            		for(var i=0;i<response.length;i++){
		            		table+="<tr><td>"+response[i].Username+"</td><td>"+response[i].Email+"</td><td>"+response[i].Mobileno+"</td><td>"+response[i].Timezone_id+"</td><td>"+response[i].Language_name+"</td></tr>";
		            		document.getElementById("usersList").innerHTML=table;

		            		}
		            }	
		            		
		            	else{
		    				document.getElementById("usersList").style.display = "none";
		    			}

		             } 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=list_UserRecords");
		    
		}



function getUserProfileDetail() {
    // 1. Instantiate XHR - Start 
	
	usersUpdate.style.display='none';
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
                	
                	usersList.style.display='none';
                	editUserList.style.display='none';
                	signup_container.style.display = 'none';
                	registeredUsers.style.display='none';
                	resetPassword.style.display='none';
                	getUserListForUpdate.style.dispaly='none';
                	userProfileDetail.style.display='block';
                	document.getElementById("usersUpdate").style.display = 'none';
                	document.getElementById("getUserListForUpdate").style.display = 'none';
                	document.getElementById("deleteUser").style.display = 'none';
                	document.getElementById("resetUserPassword").style.display = "none";
    				document.getElementById("profileDetail").style.display = "block";

    				var table="<tr><th>UserID</th><th>Mobileno</th><th>lastlogin</th><th>email</th><th>language_id</th><th>Timezone</th></tr><br />";
    				var x= xmlDoc.getElementsByTagName("User");
    				for(i=0;i<x.length;i++){
    					table+="<tr><td>"+x[i].getElementsByTagName("UserID")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("Mobileno")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("lastlogin")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("email")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("Language_Id")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue+"</td></tr>";
    					document.getElementById("profileDetail").innerHTML=table;
    				}
    				
	                
                }
    				
    				
           else{
    				
    				document.getElementById("profileDetail").style.display = "none";

    			}

              } 
        }
    
   
    xhr.open("POST", "loginRegister", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("actionType=myProfile");
    
}

function addNewUser(){
	usersList.style.display='none';
	signup_container.style.display='none';
	profileDetail.style.display='none';
	userProfileDetail.style.display='none';
	document.getElementById("getUserListForUpdate").style.display = "none";
	document.getElementById("resetUserPassword").style.display = "none";
	document.getElementById("resetPassword").style.display = "none";
	document.getElementById("registeredUsers").style.display = "none";
	document.getElementById("userProfileDetail").style.display = "none";
	document.getElementById( "deleteUser").style.display = "none";	
	document.getElementById("usersUpdate").style.display = "none";
	document.getElementById("changePassword").style.display = "none";
	document.getElementById("resetUserPassword").style.display = "none";
	
}
		
			
function changePassword() {
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
		            		usersList.style.display='none';
		            		signup_container.style.display='none';
		            		profileDetail.style.display='none';
		            		userProfileDetail.style.display='none';
		            		document.getElementById("getUserListForUpdate").style.display = "none";
		            		document.getElementById("resetUserPassword").style.display = "none";
		            		document.getElementById("resetPassword").style.display = "none";
		            		document.getElementById("registeredUsers").style.display = "none";
		            		document.getElementById("userProfileDetail").style.display = "none";
		            		document.getElementById("usersUpdate").style.display = "none";
		            		document.getElementById( "deleteUser").style.display = "none";	
		    				document.getElementById("changePassword").style.display = "block";
		    				document.getElementById("resetUserPassword").style.display = "block";
		    				
							
		            		var table="<tr><th>UserID</th><th>Links</th></tr>"
		            		for(var i=0;i<response.length;i++){
		            		    
		            		    table+="<tr><td>"+response[i].Username+"</td><td>"+"<a href='#' onclick='changeUserPassword(\""+response[i].Username+"\")'>reset</a>"+"</td></tr>";
		            		    document.getElementById("changePassword").innerHTML=table;

		            		}
		            }	
		            		
		            	   
		          
		    				
		    		else{
		    				
	    				document.getElementById("changePassword").style.display = "none";
		    			}

		             } 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=editUserProfile");
		    
		}




function changeUserPassword(username) {
	var username;
	document.getElementById("resetUserPassword").style.display = 'none';
	document.getElementById("resetPassword").style.display = 'block';
	document.getElementById("t5").value=username;
		    
	}

function submitchangepasswordform()
{
	document.getElementById("resetUserPassword").style.display = "none";
	var t5 =document.getElementById("t5").value;
	var t6=document.getElementById("t6").value;
	var t7=document.getElementById("t7").value;
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
            	resetPassword.style.display='none';
            	signup_container.style.display = 'none';
            	registeredUsers.style.display='none';
            	userProfileDetail.style.display='none';
            	usersUpdate.style.display='none';
            	document.getElementById("usersUpdate").style.display = "none";
            	getUserListForUpdate.style.dispaly='none';
            	alert("Password reset is successfull");
            	
            
            			      
         } 
    }
        
    
   
    xhr.open("POST", "loginRegister", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("actionType=updatePassword&Username="+t5+"&Newpassword="+t6+"&Confirmpassword="+t7+"");
    
}



function removeUser() {
		    // 1. Instantiate XHR - Start
	document.getElementById("deleteUser").style.display = "block";
	document.getElementById("removeUser").style.display = "block";
	usersUpdate.style.display='none';
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
		            		usersList.style.display='none';
		            		signup_container.style.display='none';
		            		profileDetail.style.display='none';
		            		registeredUsers.style.display='none';
		            		resetPassword.style.display='none';
		            		userProfileDetail.style.display='none';
		            		getUserListForUpdate.style.dispaly='none';
		            		document.getElementById("usersUpdate").style.display = "none";
		            		document.getElementById("resetUserPassword").style.display = "none";
		            		document.getElementById("getUserListForUpdate").style.display = "none";
		    				document.getElementById("removeUser").style.display = "block";
							
		            		var table="<tr><th>UserID</th><th>Links</th></tr>"
		            		for(var i=0;i<response.length;i++){
		            		    
		            		    table+="<tr><td>"+response[i].Username+"</td><td>"+"<a href='#' onclick='deleteUsersDetail(\""+response[i].Username+"\")'>delete</a>"+"</td></tr>";
		            		    document.getElementById("removeUser").innerHTML=table;

		            		}
		            }	
		            		
		            	   
		          
		    				
		    		else{
		    				
	    				document.getElementById("removeUser").style.display = "none";
		    			}

		             } 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=editUserProfile");
		    
		}



function deleteUsersDetail(username) {
	document.getElementById("deleteUser").style.display = 'none';
	usersUpdate.style.display='none';
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
	            	profileDetail.style.display='none';
	            	editUserList.style.display = 'none';
	            		signup_container.style.display='none';
	            		registeredUsers.style.display='none';
	            		document.getElementById("usersUpdate").style.display = "none";
	            		userProfileDetail.style.display='none';
	            		resetPassword.style.display='none';
	            		usersList.style.display='none';
	            		document.getElementById("resetUserPassword").style.display = "none";
	            		getUserListForUpdate.style.dispaly='none';
	            	    alert("User Record Deleted Successfully");
	            		
	            		
	            		/*var table="<tr><th>UserID</th><th>Email</th><th>Password</th><th>Mobileno</th></tr>";*/
	            		
	            		
	            }	
	            		
	            	   
 }
	    
	        
	    xhr.open("POST", "loginRegister", true);
	    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("actionType=deleteRecords&Username="+username+"");
	    
	}




function getUserList() {
		    // 1. Instantiate XHR - Start 
	editUserList.style.display='block';
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
		            		usersList.style.display='none';
		            		signup_container.style.display='none';
		            		profileDetail.style.display='none';
		            		userProfileDetail.style.display='none';
		            		resetPassword.style.display='none';
		            		registeredUsers.style.display='none';
		            		getUserListForUpdate.style.display='block';
		            		deleteUser.style.display = 'none';
		            		document.getElementById("usersUpdate").style.display = 'none';
		            		document.getElementById("resetUserPassword").style.display = "none";
		            		editUserList.style.display='block';
		            		
		    				
							
		            		var table="<tr><th>UserID</th><th>UserLinks</th></tr>"
		            		for(var i=0;i<response.length;i++){
		            		    
		            		    table+="<tr><td>"+response[i].Username+"</td><td>"+"<a href='#' onclick='updateUsersDetail(\""+response[i].Username+"\")'>edit</a>"+"</td></tr>";
		            		    document.getElementById("editUserList").innerHTML=table;

		            		}
		            }	
		            		
		            	   
		          
		    				
		    		else{
		    				
	    				document.getElementById("editUserList").style.display = "none";
		    			}

		             } 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=editUserProfile");
		    
		}
		
		function updateUsersDetail(username) {
			document.getElementById("getUserListForUpdate").style.display = 'none';
			
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
			            		profileDetail.style.display='none';
			            		editUserList.style.display = 'none';
			            		registeredUsers.style.display='none';
			            		userProfileDetail.style.display='none';
			            		getUserListForUpdate.style.dispaly='none';
			            		document.getElementById("resetUserPassword").style.display = "none";
			            		document.getElementById("usersUpdate").style.display = "none";
			            		signup_container.style.display='block';
			            		usersList.style.display='none';
			            		
			            		
			            		/*var table="<tr><th>UserID</th><th>Email</th><th>Password</th><th>Mobileno</th></tr>";*/
			            		for(var i=0;i<response.length;i++){
			            			
			            		    document.getElementById("t1").value=response[i].Username;
			            		    document.getElementById("t2").value=response[i].Email;
			            		    document.getElementById("t3").value=response[i].Mobileno;
			            		    document.getElementById("timezone_id").selectedIndex =response[i].Timezone_id ;
			            		    document.getElementById("language_id").selectedIndex =response[i].Language_id ;
			            		   
	            		    


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
		            	registeredUsers.style.display='none';
		            	userProfileDetail.style.display='none';
		            	getUserListForUpdate.style.dispaly='none';
		            	document.getElementById("resetUserPassword").style.display = "none";
		            	usersUpdate.style.display='block';
		            			      
		            		} 
		    }
		        
		    
		   
		    xhr.open("POST", "loginRegister", true);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("actionType=update&Username="+t1+"&Email="+t2+"&Mobileno="+t3+"&Timezone_id="+t4+"&Language_id="+t5+"");
		    
	}
	
	
