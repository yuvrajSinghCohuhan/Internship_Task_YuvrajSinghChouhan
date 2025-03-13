package com.Project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Appointments;
import com.Project.Entities.User;

public interface AppointmentDao extends JpaRepository<Appointments, String> {

//    List<Appointments> findByUid_UserId(String userId); // Fetch appointments by user_id
	List<Appointments> findByUser(User user);

}
