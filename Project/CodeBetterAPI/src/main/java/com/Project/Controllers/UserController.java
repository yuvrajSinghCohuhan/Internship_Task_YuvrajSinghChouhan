package com.Project.Controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.User;
import com.Project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
    private UserService userService;
	
	// Login API
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User u) {
        Boolean b = userService.loginUser(u);
        if (b) {
            return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
        }
    }

    // Registration API
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User u) {
        if (u != null) {
            userService.addUser(u);
            return ResponseEntity.status(HttpStatus.OK).body("User registered successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        if(users.size()!=0) {
        	return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 3.2 POST /api/users - Create a new user (Admin only)
    @PostMapping("/{email}")
    public ResponseEntity<User> createUser(@PathVariable String email,@RequestBody User user) {
    	if(email!=null) {
        User createdUser = userService.createUser(email,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    	}
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 3.3 GET /api/users/{user_id} - Get user by ID
    @GetMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String user_id) {
        Optional<User> user = userService.getUserById(user_id);
        if (user.isPresent()) {
        	User u = user.get();
        	return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status" , "Success" , "message" , "Get User successfully" ,"User" , u));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "Users not found"));
    }

    // 3.4 PUT /api/users/{user_id} - Update user details
    @PutMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable String user_id, @RequestBody User updatedUser) {
        User updated = userService.updateUser(user_id, updatedUser);
        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "message", "User updated successfully", "user", updated));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "User not found"));
    }

    // 3.5 DELETE /api/users/{user_id} - Delete user
    @DeleteMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable String user_id) {
        if (userService.deleteUser(user_id)) {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "message", "User Deleted successfully", "user", null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "User not found"));
    }

}
