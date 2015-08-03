package org.multimedia.domain;

public class LoginDomain {
	private String userEmail;
	private String userPwd;
	
	public LoginDomain(String userEmail, String userPwd) {
		this.userEmail = userEmail;
		this.userPwd = userPwd;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}
