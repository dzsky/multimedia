package org.multimedia.action;

import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeInforAction extends ActionSupport {
	private String nowpwd;
	private String newpwd;
	private String confirmpwd;
	private String isSuccess;
	
	public String getNowpwd() {
		return nowpwd;
	}
	public void setNowpwd(String nowpwd) {
		this.nowpwd = nowpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	
	private boolean check(String email) {
		if(0 == UserInfoDao.selectLogin(email, getNowpwd())) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public String execute() throws Exception {
		return "success";
	}
	public String getIsSuccess() {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		
		if(!check(email)) {
			setIsSuccess("false");
		}
		else if(!getNewpwd().equals(getConfirmpwd())){
			setIsSuccess("false");
		}
		else {
			UserInfoDao.updatePwd(email, getConfirmpwd());
			setIsSuccess("true");
		}
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
}


