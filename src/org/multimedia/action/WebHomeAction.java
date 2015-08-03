package org.multimedia.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionSupport;

public class WebHomeAction extends ActionSupport {
	private List<ResourceDomain> list;
	private List<ResourceDomain> listDownload;
	private List<ResourceDomain> listDownloadVideo;
	private List<ResourceDomain> listDownloadVoice;
	private List<ResourceDomain> listDownloadPicture;
	private List<ResourceDomain> listDownloadDocument;
	private List<ResourceDomainStr> listStr;
	private List<ResourceDomainStr> listDownloadStr;
	private List<ResourceDomainStr> listDownloadVideoStr;
	private List<ResourceDomainStr> listDownloadVoiceStr;
	private List<ResourceDomainStr> listDownloadPictureStr;
	private List<ResourceDomainStr> listDownloadDocumentStr;
	
	public List<ResourceDomain> getListDownloadVideo() {
		return listDownloadVideo;
	}
	public void setListDownloadVideo(List<ResourceDomain> listDownloadVideo) {
		this.listDownloadVideo = listDownloadVideo;
	}
	public List<ResourceDomain> getListDownloadVoice() {
		return listDownloadVoice;
	}
	public void setListDownloadVoice(List<ResourceDomain> listDownloadVoice) {
		this.listDownloadVoice = listDownloadVoice;
	}
	public List<ResourceDomain> getListDownloadPicture() {
		return listDownloadPicture;
	}
	public void setListDownloadPicture(List<ResourceDomain> listDownloadPicture) {
		this.listDownloadPicture = listDownloadPicture;
	}
	public List<ResourceDomain> getListDownloadDocument() {
		return listDownloadDocument;
	}
	public void setListDownloadDocument(List<ResourceDomain> listDownloadDocument) {
		this.listDownloadDocument = listDownloadDocument;
	}
	
	public List<ResourceDomain> getListDownload() {
		return listDownload;
	}
	public void setListDownload(List<ResourceDomain> listDownload) {
		this.listDownload = listDownload;
	}
	public List<ResourceDomain> getList() {
		return list;
	}
	public void setList(List<ResourceDomain> list) {
		this.list = list;
	}
	
	private void listTolistStr(List<ResourceDomain> list, List<ResourceDomainStr> listStr) {
		for(ResourceDomain resource : list) {
			ResourceDomainStr resourceStr = new ResourceDomainStr();
			java.util.Date date = new java.util.Date(resource.getResourceUploadTime().getTime());
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			resourceStr.setResourceUploadTime(sdt.format(date));
			resourceStr.setUserName(UserInfoDao.selectUserName(resource.getUserId()));
			
			resourceStr.setMessageRetrieval(resource.getMessageRetrieval());
			resourceStr.setResourceClassify(resource.getResourceClassify());
			resourceStr.setResourceDownloadNumber(resource.getResourceDownloadNumber());
			resourceStr.setResourceId(resource.getResourceId());
			resourceStr.setResourceList(resource.getResourceList());
			resourceStr.setResourceName(resource.getResourceName());
			resourceStr.setResourceView(resource.getResourceView());
			
			listStr.add(resourceStr);
		}
	}
	
	public String execute() throws Exception {
		setList(ResourceDao.selectLimit());
		setListDownload(ResourceDao.selectDownload());
		setListDownloadVideo(ResourceDao.selectDownloadClassify(1));
		setListDownloadVoice(ResourceDao.selectDownloadClassify(2));
		setListDownloadPicture(ResourceDao.selectDownloadClassify(3));
		setListDownloadDocument(ResourceDao.selectDownloadClassify(4));
		
		listStr = new ArrayList<>();
		listDownloadStr = new ArrayList<>();
		listDownloadVideoStr = new ArrayList<>();
		listDownloadVoiceStr = new ArrayList<>();
		listDownloadPictureStr = new ArrayList<>();
		listDownloadDocumentStr = new ArrayList<>();
		
		listTolistStr(list, listStr);
		listTolistStr(listDownload, listDownloadStr);
		listTolistStr(listDownloadVideo, listDownloadVideoStr);
		listTolistStr(listDownloadVoice, listDownloadVoiceStr);
		listTolistStr(listDownloadPicture, listDownloadPictureStr);
		listTolistStr(listDownloadDocument, listDownloadDocumentStr);
		return "success";
	}
	
	public class ResourceDomainStr {
		private String resourceId;
		private String userName;
		private String resourceList;
		private Integer resourceView;
		private String 	messageRetrieval;
		private Integer resourceClassify;
		private String resourceUploadTime;
		private Integer resourceDownloadNumber;
		private String resourceName;
		
		public String getResourceId() {
			return resourceId;
		}
		public void setResourceId(String resourceId) {
			this.resourceId = resourceId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
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
		public String getResourceUploadTime() {
			return resourceUploadTime;
		}
		public void setResourceUploadTime(String resourceUploadTime) {
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
	}

	public List<ResourceDomainStr> getListStr() {
		return listStr;
	}
	public void setListStr(List<ResourceDomainStr> listStr) {
		this.listStr = listStr;
	}
	public List<ResourceDomainStr> getListDownloadStr() {
		listDownloadStr = listDownloadStr.subList(0, 4);
		return listDownloadStr;
	}
	public void setListDownloadStr(List<ResourceDomainStr> listDownloadStr) {
		this.listDownloadStr = listDownloadStr;
	}
	public List<ResourceDomainStr> getListDownloadVideoStr() {
		listDownloadVideoStr = listDownloadVideoStr.subList(0, 4);
		return listDownloadVideoStr;
	}
	public void setListDownloadVideoStr(List<ResourceDomainStr> listDownloadVideoStr) {
		this.listDownloadVideoStr = listDownloadVideoStr;
	}
	public List<ResourceDomainStr> getListDownloadVoiceStr() {
		listDownloadVoiceStr = listDownloadVoiceStr.subList(0, 4);
		return listDownloadVoiceStr;
	}
	public void setListDownloadVoiceStr(List<ResourceDomainStr> listDownloadVoiceStr) {
		this.listDownloadVoiceStr = listDownloadVoiceStr;
	}
	public List<ResourceDomainStr> getListDownloadPictureStr() {
		listDownloadPictureStr = listDownloadPictureStr.subList(0, 4);
		return listDownloadPictureStr;
	}
	public void setListDownloadPictureStr(List<ResourceDomainStr> listDownloadPictureStr) {
		this.listDownloadPictureStr = listDownloadPictureStr;
	}
	public List<ResourceDomainStr> getListDownloadDocumentStr() {
		listDownloadDocumentStr = listDownloadDocumentStr.subList(0, 4);
		return listDownloadDocumentStr;
	}
	public void setListDownloadDocumentStr(List<ResourceDomainStr> listDownloadDocumentStr) {
		this.listDownloadDocumentStr = listDownloadDocumentStr;
	}
}



