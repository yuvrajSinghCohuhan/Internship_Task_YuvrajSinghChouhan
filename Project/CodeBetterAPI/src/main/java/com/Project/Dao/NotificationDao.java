package com.Project.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Project.Entities.Notifications;
import com.Project.Entities.User;

public interface NotificationDao extends JpaRepository<Notifications, String> {

    List<Notifications> findByUser(User user); // ✅ Corrected method name

    List<Notifications> findByRead(boolean read); // ✅ No issues here
}
