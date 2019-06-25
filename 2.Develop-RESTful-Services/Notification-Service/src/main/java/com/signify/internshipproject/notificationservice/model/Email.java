package com.signify.internshipproject.notificationservice.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="email")
public class Email {
	public String emailid;
	public String msg;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

