package org.multimedia.action;

import java.sql.Date;

import org.multimedia.dao.CollectDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;

public class CollectAction {
	private String resourceId;
	private String isCollected;
	private String isSuccess;
	
	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	private String getLogin() {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		if(email == null || email == "")
			return null;
		return email;
	}
	
	public String execute() throws Exception {
		return "success";
	}

	public String getIsCollected() {
		return isCollected;
	}

	public void setIsCollected(String isCollected) {
		this.isCollected = isCollected;
	}

	public String getIsSuccess() {
		int count = CollectDao.insert(UserInfoDao.selectUserId(getLogin()), resourceId, new Date(System.currentTimeMillis()), 
				ResourceDao.selectView(resourceId).getResourceName());
		if(getLogin() == null)
			setIsSuccess("false");
		else if(count < 0)
			setIsSuccess("false");
		else
			setIsSuccess("true");
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
}
