package com.signify.internshipproject.notificationservice.api;

import com.signify.internshipproject.notificationservice.model.Email;
import com.signify.internshipproject.notificationservice.model.Response;

public interface NotificationService {
	public Response sendEmail(Email info);
	
		
}

	

