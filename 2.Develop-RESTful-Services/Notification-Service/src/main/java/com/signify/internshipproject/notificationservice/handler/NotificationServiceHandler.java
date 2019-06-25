package com.signify.internshipproject.notificationservice.handler;

import com.signify.internshipproject.notificationservice.model.Email;

public interface NotificationServiceHandler {
	public boolean sendEmail(Email info);

}
