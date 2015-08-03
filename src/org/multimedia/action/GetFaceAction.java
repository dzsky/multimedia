package org.multimedia.action;

import org.multimedia.dao.FaceDao;
import org.multimedia.dao.UserInfoDao;

import com.opensymphony.xwork2.ActionContext;

public class GetFaceAction {
	private String path;

	public String getPath() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
		
		String pathTmp = FaceDao.selectPath(UserInfoDao.selectUserId(email));
		if(pathTmp == null || pathTmp.equals("")) {
			setPath("s:/face/default.jpg");
		}
		else {
			setPath(pathTmp);
		}
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public String execute() throws Exception {
		return "success";
	}
}
