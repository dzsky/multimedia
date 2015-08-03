package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.CollectDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionContext;

public class DeleteResourceAction {
	private String resourceId;
	private List<ResourceDomain> list;
	private String isSuccess;
	
	
	
	public List<ResourceDomain> getList() {
		return list;
	}

	public void setList(List<ResourceDomain> list) {
		this.list = list;
	}
	
	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


	public String execute() throws Exception {
		return "success";
	}
	
	public String getIsSuccess() {
		ResourceDao.deleteFile(getResourceId());
		CollectDao.deleteResource(getResourceId());
		ResourceDao.delete(getResourceId());
		
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		setList(ResourceDao.selectUpload(UserInfoDao.selectUserId(email)));
		setIsSuccess("true");
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
}




