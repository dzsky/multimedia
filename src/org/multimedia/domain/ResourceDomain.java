package org.multimedia.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class ResourceDomain {
	private String resourceId;
	private String userId;
	private String resourceList;
	private Integer resourceView;
	private String 	messageRetrieval;
	private Integer resourceClassify;
	private Timestamp resourceUploadTime;
	private Integer resourceDownloadNumber;
	private String resourceName;
	
	public ResourceDomain() {
		resourceId = "";
		userId = "";
		resourceList = "";
		resourceView = 0;
		messageRetrieval = "";
		resourceClassify = 0;
		resourceUploadTime = null;
		resourceDownloadNumber = 0;
		resourceName = "";
	}
	
	public String getUploadTimeStr() {
		return resourceUploadTime.toString();
	}
	
	public ResourceDomain(String resourceId, String userId, String resourceName, String resourceList,
			Integer resourceView, String messageRetrieval, Integer resourceClassify, Timestamp resourceUploadTime,
			Integer resourceDownloadNumber) {
		this.resourceId = resourceId;
		this.userId = userId;
		this.resourceName = resourceName;
		this.resourceList = resourceList;
		this.resourceView = resourceView;
		this.messageRetrieval = messageRetrieval;
		this.resourceClassify = resourceClassify;
		this.resourceUploadTime = resourceUploadTime;
		this.resourceDownloadNumber = resourceDownloadNumber;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
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
	public Timestamp getResourceUploadTime() {
		return resourceUploadTime;
	}
	public void setResourceUploadTime(Timestamp resourceUploadTime) {
		this.resourceUploadTime = resourceUploadTime;
	}
	public Integer getResourceDownloadNumber() {
		return resourceDownloadNumber;
	}
	public void setResourceDownloadNumber(Integer resourceDownloadNumber) {
		this.resourceDownloadNumber = resourceDownloadNumber;
	}
}


