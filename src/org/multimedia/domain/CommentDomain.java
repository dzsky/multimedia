package org.multimedia.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CommentDomain {
	
	private String resourceId;
	private String userId;
	private String comment;
	private Timestamp commentTime;
	
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
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}	
}
