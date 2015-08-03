package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.ResourceDao;
import org.multimedia.domain.ResourceDomain;

public class GetVoiceAction {
	private int page;
	private int pageTotal;
	private List<ResourceDomain> list;
	private String type;
	
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
	public List<ResourceDomain> getList() throws Exception{
		setType("new");
		setList(ResourceDao.select(2, getType()));
		
		int count = list.size() / 12;
		if(list.size() % 12 != 0)
			count = count + 1;
		setPageTotal(count);
		int begin = (getPage() - 1) * 6;
		list = list.subList(begin, begin + 6);
		return list;
	}
	public void setList(List<ResourceDomain> list) {
		this.list = list;
	}
	
	public String execute() throws Exception {
		
		return "success";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
