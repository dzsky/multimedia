package org.multimedia.action;

import java.sql.Connection;
import java.util.Date;

import org.multimedia.dao.BaseDao;
import org.multimedia.dao.DBManager;
import org.multimedia.dao.LastIdDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.UserInfoDomain;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private String rgsEmail;
	private String username;
	private String rgsPassword;
	private String passwordConfirm;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRgsEmail() {
		return rgsEmail;
	}
	public void setRgsEmail(String rgsEmail) {
		this.rgsEmail = rgsEmail;
	}
	public String getRgsPassword() {
		return rgsPassword;
	}
	public void setRgsPassword(String rgsPassword) {
		this.rgsPassword = rgsPassword;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	private String getUserId() {
		int id = LastIdDao.getSingle(1).getNum();
		id ++;
		LastIdDao.update(1, id);
		return "" + id;
	}
	
	public String execute() throws Exception {
		UserInfoDomain userInfoDomain = new UserInfoDomain(
				getUserId(), rgsPassword, username, rgsEmail, new Integer(1));
		if(UserInfoDao.insert(userInfoDomain) != 0) {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("email", rgsEmail);
			ctx.getSession().put("userId", getUserId());
			return "success";
		}
		return "fail";
	}
}
