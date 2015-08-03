package org.multimedia.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ToHomePageAction extends ActionSupport {
	public String execute()	throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		if(email != null && !email.equals("")) //�˴��������email != null��ǰ���������Ϊ�գ�ִ��equals�����ᱨ�� 
			return "success";
		return "fail";
	}
}

