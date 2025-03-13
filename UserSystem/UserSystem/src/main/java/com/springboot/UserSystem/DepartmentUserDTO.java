package com.springboot.UserSystem;

public class DepartmentUserDTO {
	
	private int userId;
	private String userName;
	private String userEmail;
	
	private String dptName;
	private String location;
	public DepartmentUserDTO(int userId, String userName, String userEmail, String dptName, String location) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.dptName = dptName;
		this.location = location;
	}
	public DepartmentUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "DepartmentUserDTO [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", dptName=" + dptName + ", location=" + location + "]";
	}
	
	
	

}
