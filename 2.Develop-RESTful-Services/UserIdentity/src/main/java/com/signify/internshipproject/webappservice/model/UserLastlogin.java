package com.signify.internshipproject.webappservice.model;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement (name="person")
public class UserLastlogin {
	public String lastlogin;

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

}
