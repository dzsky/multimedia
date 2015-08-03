package org.multimedia.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.multimedia.dao.UserInfoDao;

public class EmailIsExistAction {
	private String email;
	private String rgsEmail;
	private InputStream inputStream;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRgsEmail() {
		return rgsEmail;
	}
	public void setRgsEmail(String rgsEmail) {
		this.rgsEmail = rgsEmail;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public InputStream getResult() {
		return inputStream;
	}
	public String execute() throws Exception {
		String result = "";
		if(getEmail() == null || getEmail() == "")
			result = isExist(getEmail());
		else
			result = isExist(getRgsEmail());
		inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		System.out.println("收到信息！hhhhkkkkbb@163.com");
		return "success";
	}
	
	private String isExist(String email) {
		int count = UserInfoDao.selectEmail(email);
		if(count == 0)
			return "false";
		else
			return "true";
	}
	
	
}
