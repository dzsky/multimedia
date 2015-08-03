package org.multimedia.action;

import org.multimedia.dao.CollectDao;
import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;

public class DeleteCollectAction {
	private String resourceId;
	private String isResourceView;
	private String isSuccess;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	public String execute() throws Exception {
		return "success";
	}

	public String getIsResourceView() {
		return isResourceView;
	}

	public void setIsResourceView(String isResourceView) {
		this.isResourceView = isResourceView;
	}

	public String getIsSuccess() {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		if(email == null)
			setIsSuccess("false");
		else
			setIsSuccess("true");
		CollectDao.delete(getResourceId(), UserInfoDao.selectUserId(email));
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
