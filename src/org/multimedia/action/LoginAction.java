package org.multimedia.action;

import org.apache.struts2.ServletActionContext;
import org.multimedia.dao.LoginDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.LoginDomain;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String email;
	private String password;
	private String username;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception {
		int count = UserInfoDao.selectLogin(getEmail(), getPassword());
		if(count == 0)
			return "fail";
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("email", getEmail());
		ctx.getSession().put("userId", UserInfoDao.selectUserId(email));
		setUsername(UserInfoDao.selectUserName(UserInfoDao.selectUserId(email)));
		ctx.getSession().put("myname", username);
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
