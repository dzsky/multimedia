package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.CollectDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.CollectDomain;

import com.opensymphony.xwork2.ActionContext;

public class CollectRecordAction {
	private List<CollectDomain> list;
	private int page;
	private int pageTotal;
	
	public List<CollectDomain> getList() throws Exception{
		json();
		int begin = (getPage() - 1) * 5;
		list.subList(begin, begin + 5);
		return list;
	}

	public void setList(List<CollectDomain> list) {
		this.list = list;
	}
	
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		setList(CollectDao.select(UserInfoDao.selectUserId(email)));
		
		int count = list.size() / 5;
		if(list.size() % 5 != 0)
			count = count + 1;
		setPageTotal(count);
		return "success";
	}
	private void json()  throws Exception{
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		//email = "hhhhkkkkbb@163.com";
		setList(CollectDao.select(UserInfoDao.selectUserId(email)));
		
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

