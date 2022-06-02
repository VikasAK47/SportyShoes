package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="Details about the User")
public class User {
	
	@ApiModelProperty(notes = "Unique Costomer ID")
	Integer USER_ID;
	@ApiModelProperty(notes = "The User Name")
	String USER_NAME;
	@ApiModelProperty(notes = "The User Passsword")
	String PASSWORD;
	
	public User() {
		
		super();
		
	}

	public User(Integer uSER_ID, String uSER_NAME, String pASSWORD) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		PASSWORD = pASSWORD;
	}

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", PASSWORD=" + PASSWORD + "]";
	}


	
	
	
	
}
