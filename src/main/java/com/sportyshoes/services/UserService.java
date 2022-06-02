package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Boolean addUser(Integer User_ID,String USER_NAME,String PASSWORD ){
		
		User user= new User(User_ID,USER_NAME,PASSWORD);
		
		try {
			return userRepository.createUser(user) > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	
	public User getUser(Integer USER_ID) throws SQLException {
		
		return this.userRepository.findUserById(USER_ID) ;
	}
	
	public List<User> getAllUsers() throws SQLException {
		return this.userRepository.findAllUsers();
	}
	
	public Boolean updateUser(Integer User_ID,String USER_NAME) throws SQLException {
		User user = this.userRepository.findUserById(User_ID);
		user.setUSER_NAME(USER_NAME);
		
		Integer recordsUpdated = this.userRepository.updateUser(user);
		
		return recordsUpdated > 0;
	}
	
	public Boolean deleteUserById(Integer USER_ID) throws SQLException {
		Integer recordsDeleted = this.userRepository.deleteUserById(USER_ID);
		
		return recordsDeleted > 0;
	}
	

}
