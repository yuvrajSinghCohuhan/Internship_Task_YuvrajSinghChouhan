package com.Project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.User;

public interface UserDao extends JpaRepository<User, String>{

	public List<User> findByEmailAndPassword(String email, String password);

}
