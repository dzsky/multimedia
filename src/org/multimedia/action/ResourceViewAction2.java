package org.multimedia.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.multimedia.dao.CollectDao;
import org.multimedia.dao.CommentDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.CommentDomain;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionContext;

public class ResourceViewAction2 {
	private String resourceId;
	private ResourceDomain resourceDomain;
	private String userName;
	private String isCollected;
	private List<CommentDomain> list;
	private List<CommentDomainStr> list2;
	
	public List<CommentDomainStr> getList2() throws Exception {
		setResourceDomain(ResourceDao.selectView(getResourceId()));
		setUserName(UserInfoDao.selectUserName(resourceDomain.getUserId()));
		setList(CommentDao.select(getResourceId()));
		listTolist2();
		
		ActionContext ctx = ActionContext.getContext();
		String email = (String)ctx.getSession().get("email");
		int count = CollectDao.select(getResourceId(), UserInfoDao.selectUserId(email));
		if(count > 0)
			setIsCollected("true");
		else
			setIsCollected("false");
		ctx.getSession().put("isCollected", getIsCollected());
		return list2;
	}
	
	public List<CommentDomain> getList() {
		return list;
	}
	public void setList(List<CommentDomain> list) {
		this.list = list;
	}
	
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
	
	private void listTolist2() {
		list2 = new ArrayList<>();
		for(CommentDomain comment : list) {
			CommentDomainStr commentStr = new CommentDomainStr();
			commentStr.setComment(comment.getComment());
			commentStr.setResourceId(comment.getResourceId());
			commentStr.setUserName(UserInfoDao.selectUserName(comment.getUserId()));
			
			java.util.Date date= new java.util.Date(comment.getCommentTime().getTime());
			commentStr.setCommentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			
			list2.add(commentStr);
		}
	}
	
	public String execute() throws Exception {
		
		return "success";
	}
	
	public class CommentDomainStr {
		private String resourceId;
		private String userName;
		private String commentTime;
		private String comment;
		
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
		public String getCommentTime() {
			return commentTime;
		}
		public void setCommentTime(String commentTime) {
			this.commentTime = commentTime;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
	}

	public String getIsCollected() {
		return isCollected;
	}

	public void setIsCollected(String isCollected) {
		this.isCollected = isCollected;
	}
}



