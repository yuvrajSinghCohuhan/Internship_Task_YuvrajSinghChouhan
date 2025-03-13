package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.UserDao;
import com.Project.Entities.User;

@Component
public class UserService {
	@Autowired
	private UserDao dao;

	public User addUser(User u) {
		if(u!=null) {
		 User u1= dao.save(u);
		 return u1;
		}
		return null;
	}

	public boolean loginUser(User u) {
		boolean b = false;
		if(u!=null) {
			List<User> ls= dao.findByEmailAndPassword(u.getEmail(), u.getPassword());
			if(ls.size()!=0) {
			b = true;
			}
	}
		return b;
	}

	public List<User> getAllUsers() {
		List<User> ls = dao.findAll();
		return ls;
	}

	public Optional<User> getUserById(String user_id) {
		 Optional<User>op= dao.findById(user_id);
		return op;
	}

	public User updateUser(String user_id, User updatedUser) {
		Optional<User> op = dao.findById(user_id);
		if(op.isPresent()) {
			User u = op.get();
			updatedUser.setId(u.getId());
			User u1 = dao.save(updatedUser);
			return u1;
		}
		return null;
	}

	public boolean deleteUser(String user_id) {
		 if(user_id == null) {
			 dao.deleteById(user_id);
			return true;
		 }
		return false;
	}

	public User createUser(String email,User user) {
		User u = dao.findByEmail(email);
		System.out.println(u);
		
		if(u!=null && u.getRole().equalsIgnoreCase("admin")) {
			
				User u1= dao.save(user);
				return u1;
			}
			
			return null;
	}
	
}
