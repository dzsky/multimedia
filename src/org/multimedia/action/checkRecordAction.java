package org.multimedia.action;

import java.util.Date;

import org.multimedia.dao.CheckDao;
import org.multimedia.dao.ResourceDao;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import org.multimedia.domain.AuditDomain;

public class checkRecordAction extends ActionSupport{
	private String resourceId;
	private Date uploadTime;
	private String userId;
	private String resourceName;
	private String resourceClassify;
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
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceClassify() {
		return resourceClassify;
	}
	public void setResourceClassify(String resourceClassify) {
		this.resourceClassify = resourceClassify;
	}
	
	public String execute() throws Exception {
		//ActionContext ctx = ActionContext.getContext();
		//String email = (String) ctx.getSession().get("email");
		setList(CheckDao.selectCheck());
		return "success";
	}
}
