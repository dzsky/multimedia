package org.multimedia.action;

import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;

public class ChangeUsernameAction {
	private String username;
	private String isSuccess;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute() throws Exception {
		
		return "success";
	}

	public String getIsSuccess() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		int count = UserInfoDao.updateName(email, getUsername());
		if(count > 0)
			setIsSuccess("true");
		else
			setIsSuccess("false");
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
}
