package org.multimedia.domain;

import java.util.Date;

public class CollectDomain {
	private String userId;
	private String resourceId;
	private Date collectTime;
	private String resourceName;
	
	public CollectDomain(String userId, String resourceId, Date collectTime, String resourceName) {
		this.userId = userId;
		this.resourceId = resourceId;
		this.collectTime = collectTime;
		this.resourceName = resourceName;
	}
	
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
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
