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

import com.opensymphony.xwork2.ActionContext;

public class PersonalCommentAction {
	private List<CommentDomain> list;
	private List<CommentDomainStr> listStr;
	private int page;
	private int pageTotal;
	
	public class CommentDomainStr {
		private String resourceId;
		private String userId;
		private String comment;
		private String commentTime;
		
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
		public String getCommentTime() {
			return commentTime;
		}
		public void setCommentTime(String commentTime) {
			this.commentTime = commentTime;
		}
	}
	
	public List<CommentDomainStr> getListStr() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		System.out.println(email);
		setList(CommentDao.selectMy(UserInfoDao.selectUserId(email))); 
		setListStr(listTolistStr());
		
		int count = list.size() / 5;
		if(list.size() % 5 != 0)
			count = count + 1;
		setPageTotal(count);
		
		return listStr;
	}
	public void setListStr(List<CommentDomainStr> listStr) {
		this.listStr = listStr;
	}
	public List<CommentDomain> getList() {
		return list;
	}
	public void setList(List<CommentDomain> list) {
		this.list = list;
	}
	
	private  List<CommentDomainStr> listTolistStr() {
		List<CommentDomainStr> listStr = new ArrayList<>();
		for(CommentDomain comment : list) {
			CommentDomainStr commentStr = new CommentDomainStr();
			java.util.Date date = new java.util.Date(comment.getCommentTime().getTime());
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			commentStr.setCommentTime(sdt.format(date));
			
			commentStr.setComment(comment.getComment());
			commentStr.setResourceId(comment.getResourceId());
			commentStr.setUserId(comment.getUserId());
			
			listStr.add(commentStr);
		}
		return listStr;
	}
	
	public String execute() throws Exception {
		return "success";
	}
	private void json() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		setList(CommentDao.selectMy(UserInfoDao.selectUserId(email)));
		listTolistStr();
		
		
		int count = list.size() / 5;
		if(list.size() % 5 != 0)
			count = count + 1;
		setPageTotal(count);
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
}
