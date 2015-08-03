package org.multimedia.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ToHomePageAction extends ActionSupport {
	public String execute()	throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		if(email != null && !email.equals("")) //此处必须加上email != null在前，否则如果为空，执行equals方法会报错 
			return "success";
		return "fail";
	}
}

