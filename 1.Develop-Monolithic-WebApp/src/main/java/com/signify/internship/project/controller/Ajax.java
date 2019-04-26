package com.signify.internship.project.controller;
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Ajax {
		private String username;  
		private String email;  
		private String mobileno; 
		private String lastlogin;
		public Ajax() {}  
		public Ajax(String username, String email, String mobileno,String lastlogin) {  
		    super();  
		    this.username = username;  
		    this.email = email;  
		    this.mobileno = mobileno; 
		    this.lastlogin=lastlogin;
		}  
		@XmlAttribute 
		public String getUsername() {  
		    return username;  
		}  
		public void setUsername(String username) {  
		    this.username= username;  
		}  
		@XmlElement
		public String getEmail() {  
		    return email;  
		}  
		public void setEmail(String email) {  
		    this.email = email;  
		} 
		@XmlElement
		public String getMobileno() {  
		    return mobileno;  
		}  
		public void setMobileno(String mobileno) {  
		    this.mobileno = mobileno;  
		}
		@XmlElement
		public String getLastlogin() {
			return lastlogin;
		}
		public void setLastlogin(String lastlogin) {
			this.lastlogin = lastlogin;
		}  
		  
}  




