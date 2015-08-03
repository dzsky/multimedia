package org.multimedia.action;

import java.util.List;

import org.multimedia.dao.ResourceDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionSupport;

public class RetrievalAction extends ActionSupport{

	private String retrieval;
	private String selection;
	private List<ResourceDomain> list;

	public String getRetrieval() {
		return retrieval;
	}

	public void setRetrieval(String retrieval) {
		this.retrieval = retrieval;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public List<ResourceDomain> getList() throws Exception {
		if(getSelection().equals("0"))
		{
			setList(ResourceDao.retrievalResource(getRetrieval(),0));
		}
		else if(getSelection().equals("1"))
		{
			setList(ResourceDao.retrievalResource(getRetrieval(),1));
		}
		else if(getSelection().equals("2"))
		{
			setList(ResourceDao.retrievalResource(getRetrieval(),2));
		}
		else if(getSelection().equals("3"))
		{
			setList(ResourceDao.retrievalResource(getRetrieval(),3));
		}
		else
		{
			setList(ResourceDao.retrievalResource(getRetrieval(),4));
		}
		return list;
	}

	public void setList(List<ResourceDomain> list) {
		this.list = list;
	}
	public String execute() throws Exception {
		return "success";
	}
}
