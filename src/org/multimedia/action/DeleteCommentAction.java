package org.multimedia.action;

import org.multimedia.dao.CommentDao;
import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;

public class DeleteCommentAction {
	private String resourceId;
	private String userId;
	private String comment;
	private String isSuccess;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String execute() throws Exception {
		
		return "success";
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		setUserId(UserInfoDao.selectUserId(email));
		int count = CommentDao.delete(getResourceId(), getUserId(), getComment());
		if(count > 0) 
			setIsSuccess("true");
		else
			setIsSuccess("false");
		this.isSuccess = isSuccess;
	}
}
