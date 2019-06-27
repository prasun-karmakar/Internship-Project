package com.signify.internshipproject.webappservice.rest.client;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="email")
public class Email {
	public String emailid;
	public String msg;
	public Email() {
		 
    }
 
    public Email(String emailid, String msg) {
        this.emailid = emailid;
        this.msg = msg;
       
    }
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

	@Override
	public String toString(){
		return emailid+"::"+msg;
	}
	
}

