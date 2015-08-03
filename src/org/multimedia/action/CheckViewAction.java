package org.multimedia.action;

import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.ResourceDomain;

public class CheckViewAction {

	private String resourceId;
	private ResourceDomain resourceDomain;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public ResourceDomain getResourceDomain() {
		return resourceDomain;
	}
	public void setResourceDomain(ResourceDomain resourceDomain) {
		this.resourceDomain = resourceDomain;
	}
	
	public String execute() throws Exception {
		setResourceDomain(ResourceDao.selectView(getResourceId()));
		//setUserName(UserInfoDao.selectUserName(resourceDomain.getUserId()));
		return "success";
	}
}
