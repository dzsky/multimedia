package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.ResourceDao;
import org.multimedia.domain.ResourceDomain;

public class IndexGetVideoAction {
	private String type;
	private List<ResourceDomain> list;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ResourceDomain> getList() {
		json();
		return list;
	}
	public void setList(List<ResourceDomain> list) {
		this.list = list;
	}
	
	private void json() {
		if(getType().equals("hot"))
			setList(ResourceDao.selectDownloadClassify(1));
		else 
			setList(ResourceDao.selectNewClassify(1));
	}
	
	public String execute() throws Exception {
		return "success";
	}
}
