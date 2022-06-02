package com.sportyshoes.controllers.users;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.User;
import com.sportyshoes.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signUp")
	public Map<String, String> signUp(@RequestBody MultiValueMap<String, String> newUserDetails) {
		Map<String, String> signUpResponse = new HashMap<>();
		
	Boolean userRegistered = userService.addUser( Integer.parseInt(newUserDetails.get("USER_ID").get(0)), newUserDetails.get("User_name").get(0), newUserDetails.get("PASSWORD").get(0));
		
		if(userRegistered) {
			signUpResponse.put("status", "true");
			signUpResponse.put("message", "Registration success");	
		}else {
			
			signUpResponse.put("status", "false");
			signUpResponse.put("message", "Registration not success");	
		}
		return signUpResponse;
	}
	
	
	@PostMapping("/userDetails")
	public String get(Integer USER_ID) {
		try {
			User user = this.userService.getUser(USER_ID);
			return user == null ? "Empty set!" : user.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching the record of user #" + USER_ID + "!\n" + ex);
		}
		
		return null;
	}

	@PostMapping("/userAllDetails")
public String getAll() {
	try {
		List<User> users = this.userService.getAllUsers();
		
		return users.isEmpty() ? "Empty set!" : users.toString();
	} catch (SQLException ex) {
		System.out.println("Exception occurred while fetching all user records!\n" + ex);
	}
	
	return null;
}
	@PostMapping("/userUpdate")
public String update(Integer User_ID,String USER_NAME) {
	try {
		if (Boolean.TRUE.equals(this.userService.updateUser(User_ID, USER_NAME))) {
			return String.format("Record of worker #%d updated successfully", User_ID);
		} 
	} catch (SQLException ex) {
		System.out.println("Exception occurred while updating the record of User #" + User_ID + "!\n" + ex);
	}
	
	return String.format("Failure in updating the record of user #%d!", User_ID);
}
	
	@PostMapping("/userDeleted")
public String delete(Integer User_ID) {
	try {
		if (Boolean.TRUE.equals(this.userService.deleteUserById(User_ID))) {
			return String.format("Record of worker #%d deleted successfully", User_ID);
		} 
	} catch (SQLException ex) {
		System.out.println("Exception occurred while deleting the record of user #" + User_ID + "!\n" + ex);
	}
	
	return String.format("Failure in deleting the record of user #%d!", User_ID);
}
}


