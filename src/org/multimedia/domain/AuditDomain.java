package org.multimedia.domain;

import java.util.Date;

public class AuditDomain {
	private String resourceId;
	private Date uploadTime;
	private String userId;
	private String resourceName;
	private int resourceClassify;
	
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
	public int getResourceClassify() {
		return resourceClassify;
	}
	public void setResourceClassify(int resourceClassify) {
		this.resourceClassify = resourceClassify;
	}
}
