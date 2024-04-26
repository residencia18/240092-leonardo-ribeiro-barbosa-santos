package com.leo.mockito.domain.users;

public enum UsersRole {
	
	ADMIN("admin"),
	
	USER("user");
	
	private String role;
	
	UsersRole(String role) {
		this.role = role;
	}
	
	
	public String getRole() {
		return role;
	}

}
