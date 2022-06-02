package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.UserDao;
import com.sportyshoes.models.User;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class UserRepository implements UserDao{
	
	@Autowired
	private DatabaseConnection connection;
	

	@Override
	public Integer createUser(User user) throws SQLException {
		String insertUserFormat = ("INSERT INTO users (USER_ID , USER_NAME , PASSWORD) VALUES(?,?,?)");


		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertUserFormat);) {
			preparedStatement.setInt(1, user.getUSER_ID());
			preparedStatement.setString(2, user.getUSER_NAME());
			preparedStatement.setString(3, user.getPASSWORD());
			
			return preparedStatement.executeUpdate();
		} 
		
	}

	@Override
	public User findUserById(Integer USER_ID) throws SQLException {
		String getUserFormat = ("SELECT * FROM users WHERE USER_ID =? ");
//				"""
//				SELECT *
//				FROM
//				    Worker
//				WHERE
//				    WORKER_ID = ?""";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
			preparedStatement.setInt(1,USER_ID);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			User user = new User();
			while (rs.next()) {
				user.setUSER_ID(rs.getInt("USER_ID"));
				user.setUSER_NAME(rs.getString(" USER_NAME"));
				
			}
			return user;
		}
	}

	@Override
	public List<User> findAllUsers() throws SQLException {
		String getUserFormat = ("SELECT * FROM users");
//				"""
//				SELECT *
//				FROM
//				    Worker""";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<User> users = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return users;
			}

			while (rs.next()) {
				User user = new User();
				user.setUSER_ID(rs.getInt("USER_ID"));
				user.setUSER_NAME(rs.getString("USER_NAME"));
				

				users.add(user);
			}

			return users;
		}
	
	}

	@Override
	public Integer updateUser(User user) throws SQLException {

		String updateUserFormat = ("UPDATE users SET USER_ID=?,USER_NAME=?");
//				"""
//				UPDATE Worker
//				SET
//				    WORKER_ID = ?,
//				    FIRST_NAME = ?,
//				    LAST_NAME = ?,
//				    SALARY = ?,
//				    JOINING_DATE = ?,
//				    DEPARTMENT = ?  
//				WHERE
//				    WORKER_ID = ?""";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateUserFormat);) {
			preparedStatement.setInt(1, user.getUSER_ID());
			preparedStatement.setString(2, user.getPASSWORD());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer deleteUserById(Integer id) throws SQLException {
		 String deleteUserFormat = ("DELETE FROM users WHERE USER_ID=?");
//				 """
//	                DELETE FROM Worker
//	                WHERE
//	                    WORKER_ID = ?""";

			try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteUserFormat);) {
				preparedStatement.setInt(1, 10);
				return preparedStatement.executeUpdate();
			}


	}
	
	
	
}
