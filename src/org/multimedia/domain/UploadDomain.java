package org.multimedia.domain;

import java.util.Date;

public class UploadDomain {
	private String userId;
	private String resourceId;
	private Date uploadTime;
	private String resourceName;
	private Integer resourceClassify;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Integer getResourceClassify() {
		return resourceClassify;
	}
	public void setResourceClassify(Integer resourceClassify) {
		this.resourceClassify = resourceClassify;
	}
}
