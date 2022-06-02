package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import com.sportyshoes.models.User;

public interface UserDao {
	
	// Create Operation
		Integer createUser(User user) throws SQLException ;
		
		// Read/Retrieve Operations
		User findUserById(Integer USER_ID) throws SQLException ;
		
		List<User> findAllUsers() throws SQLException ;
		
		// Update Operations
		Integer updateUser(User user) throws SQLException ;
		
		
		
		// Delete Operations
		Integer deleteUserById(Integer id) throws SQLException;	

}
