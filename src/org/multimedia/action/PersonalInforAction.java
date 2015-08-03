package org.multimedia.action;

import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;

public class PersonalInforAction {
	 private String userName;
	 private String userEmail;
	 private String userId;
	 
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	 
	 public String execute() throws Exception {
		 ActionContext ctx = ActionContext.getContext();
		 String email = (String) ctx.getSession().get("email");
		 setUserEmail(email);
		 setUserId(UserInfoDao.selectUserId(email));
		 setUserName(UserInfoDao.selectUserName(getUserId()));
		 return "success";
	 }
}
