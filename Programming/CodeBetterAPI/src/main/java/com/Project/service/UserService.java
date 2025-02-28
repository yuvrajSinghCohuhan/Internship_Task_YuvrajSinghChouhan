package com.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.CategoryDao;
import com.Project.Dao.UserDao;
import com.Project.Entities.Category;
import com.Project.Entities.User;

@Component
public class UserService {
	@Autowired
	private UserDao dao;

	public void addUser(User u) {
		if(u!=null) {
		dao.save(u);
		}
		
	}

	public boolean getUser(User u) {
		boolean b = false;
		if(u!=null) {
			List<User> ls= dao.findByEmailAndPassword(u.getEmail(), u.getPassword());
			if(ls.size()!=0) {
			b = true;
			}
	}
		return b;
	}
	
}
