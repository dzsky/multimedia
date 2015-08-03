package org.multimedia.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadRecordAction extends ActionSupport {
	private String resourceId;
	private Date uploadTime;
	private String resourceName;
	private int page;
	private int pageTotal;
	private List<ResourceDomain> list;

	
	public List<ResourceDomain> getList() throws Exception {
		json();
		int begin = (getPage() - 1) * 5;
		list = list.subList(begin, begin + 5);
		return list;
	}

	public void setList(List<ResourceDomain> list) {
		this.list = list;
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
	
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		setList(ResourceDao.selectUpload(UserInfoDao.selectUserId(email)));
		return "success";
	}
	
	private void json()  throws Exception{
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		//email = "hhhhkkkkbb@163.com";
		setList(ResourceDao.selectUpload(UserInfoDao.selectUserId(email)));
		
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
