package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.CheckDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.AuditDomain;

public class DeleteAuditAction {

	private String resourceId;
	private List<AuditDomain> list;
	
	public List<AuditDomain> getList() {
		return list;
	}
	public void setList(List<AuditDomain> list) {
		this.list = list;
	}	
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String execute() throws Exception {
		//ResourceDao.deleteFile(getResourceId());
		//CollectDao.deleteResource(getResourceId());
		CheckDao.delete(getResourceId());
		
		//ActionContext ctx = ActionContext.getContext();
		//String email = (String) ctx.getSession().get("email");
		setList(CheckDao.selectUpload());
		//setList(ResourceDao.selectUpload(UserInfoDao.selectUserId(email)));
		return "success";
	}
}
