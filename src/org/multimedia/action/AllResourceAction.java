package org.multimedia.action;

import java.sql.Date;
import java.util.List;

import org.multimedia.dao.CheckDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.domain.AuditDomain;
import org.multimedia.domain.ResourceDomain;

public class AllResourceAction {
	private String resourceId;
	private String userId;
	private String resourceList;
	private Integer resourceView;
	private String 	messageRetrieval;
	private Integer resourceClassify;
	private Date resourceUploadTime;
	private Integer resourceDownloadNumber;
	private String resourceName;
	private List<ResourceDomain> list;
	
	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResourceList() {
		return resourceList;
	}

	public void setResourceList(String resourceList) {
		this.resourceList = resourceList;
	}

	public Integer getResourceView() {
		return resourceView;
	}

	public void setResourceView(Integer resourceView) {
		this.resourceView = resourceView;
	}

	public String getMessageRetrieval() {
		return messageRetrieval;
	}

	public void setMessageRetrieval(String messageRetrieval) {
		this.messageRetrieval = messageRetrieval;
	}

	public Integer getResourceClassify() {
		return resourceClassify;
	}

	public void setResourceClassify(Integer resourceClassify) {
		this.resourceClassify = resourceClassify;
	}

	public Date getResourceUploadTime() {
		return resourceUploadTime;
	}

	public void setResourceUploadTime(Date resourceUploadTime) {
		this.resourceUploadTime = resourceUploadTime;
	}

	public Integer getResourceDownloadNumber() {
		return resourceDownloadNumber;
	}

	public void setResourceDownloadNumber(Integer resourceDownloadNumber) {
		this.resourceDownloadNumber = resourceDownloadNumber;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public List<ResourceDomain> getList() {
		return list;
	}

	public void setList(List<ResourceDomain> list) {
		this.list = list;
	}
	public String execute() throws Exception {
		//ActionContext ctx = ActionContext.getContext();
		//String email = (String) ctx.getSession().get("email");
		
		setList(ResourceDao.select());
		return "success";
	}
}
