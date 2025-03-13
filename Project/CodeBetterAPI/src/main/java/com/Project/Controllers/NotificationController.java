package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Notifications;
import com.Project.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService nService;
    
    @PostMapping("notifications")
    public ResponseEntity<String> addNotification(@RequestBody Notifications n) {
        if (n != null) {
            nService.addNotification(n);
            return ResponseEntity.status(HttpStatus.OK).body("Notification Added successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("notifications/user/{userId}")
    public ResponseEntity<List<Notifications>> getNotifications(@PathVariable String userId) {
        List<Notifications> notifications = nService.getNotifications(userId);
        if (!notifications.isEmpty()) {
            return ResponseEntity.ok(notifications);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("notifications/read/{read}")
    public ResponseEntity<List<Notifications>> getReadNotifications(@PathVariable boolean read) {
        List<Notifications> notifications = nService.getReadNotifications(read);
        if (!notifications.isEmpty()) {
            return ResponseEntity.ok(notifications);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
