package com.signify.internshipproject.notificationservice.handler;

import com.signify.internshipproject.notificationservice.model.Email;
import com.signify.internshipproject.notificationservice.service.EmailService;

public class NotificationServiceHandlerImpl implements NotificationServiceHandler {


	
	@Override
	public boolean sendEmail(Email info) {
		// TODO Auto-generated method stub
		try {
			EmailService email=new EmailService();
			email.sendEmail(info);
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}

	
	
}


/*try {
	UserDAO userDAO = new UserDAOImpl();
    userDAO.insertUserRegistrationDetails(userDTO);
    return "valid";
 
}
	catch(Exception e) {
		System.out.println(e);
	}
	return "invalid";
}*/

