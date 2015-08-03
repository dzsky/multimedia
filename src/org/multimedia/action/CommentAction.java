package org.multimedia.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.multimedia.dao.CommentDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionContext;

public class CommentAction {
	private String comment;
	private String resourceId;
	private String isSuccess;
	
	public String getIsSuccess() {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		if(email == null || email == "")
			setIsSuccess("false");
		else 
			setIsSuccess("true");
		Timestamp date = new Timestamp(new java.util.Date().getTime());
		CommentDao.insert(getResourceId(), UserInfoDao.selectUserId(email), getComment(), date);
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		
		this.isSuccess = isSuccess;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	public String execute() throws Exception {
	
		return "success";
	}
}
