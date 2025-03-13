package com.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.NotificationDao;
import com.Project.Entities.Notifications;
import com.Project.Entities.User;

@Component
public class NotificationService {
	@Autowired
	private NotificationDao ndao;

	public void addNotification(Notifications n) {
        ndao.save(n);
    }

	public List<Notifications> getNotifications(String userId) {
	    User user = new User();
	    user.setId(userId);
	    return ndao.findByUser(user);
	}

	public List<Notifications> getReadNotifications(boolean read) {
	    return ndao.findByRead(read);
	}

	
	

}
