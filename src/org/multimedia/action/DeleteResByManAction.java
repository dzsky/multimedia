package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.CheckDao;
import org.multimedia.dao.CollectDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.domain.ResourceDomain;

public class DeleteResByManAction {
	private String resourceId;
	private List<ResourceDomain> list;
	
	public List<ResourceDomain> getList() {
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

	public String execute() throws Exception {
		//删除资源文件
		ResourceDao.deleteFile(getResourceId());
		//删除资源表中的内容
		ResourceDao.delete(getResourceId());
		//删除收藏内容
		CollectDao.deleteResource(getResourceId());
		//删除审核表里的信息
		CheckDao.delete(getResourceId());
		
		//ActionContext ctx = ActionContext.getContext();
		//String email = (String) ctx.getSession().get("email");
		setList(ResourceDao.select());
		//setList(ResourceDao.selectUpload(UserInfoDao.selectUserId(email)));
		return "success";
	}
}
