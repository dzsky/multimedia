package org.multimedia.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;

import org.multimedia.dao.FaceDao;
import org.multimedia.dao.LastIdDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.dao.UserInfoDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionContext;

public class UploadFaceAction {
	private String selection;
	private String title;
	private File upload;
	private String uploadFileName;
	private String savePath;
	
	
	
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	
	private String getResourceId() {
		int id = LastIdDao.getSingle(2).getNum();
		id ++;
		LastIdDao.update(2, id);
		return "" + id;
	}
	
	private void insertIntoTable() {
		
		
	}
	
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String email = (String) ctx.getSession().get("email");
	
		String suffix = getUploadFileName().substring(getUploadFileName().indexOf(".") + 1);
		String filename = UserInfoDao.selectUserId(email) + suffix;
		
		String path = getSavePath() + "face";
		FileOutputStream fos = new FileOutputStream(path + "//" + filename);
		
		File file = new File(path + "//" + filename);
		if(file.exists())
			file.delete();
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buffer)) > 0)
			fos.write(buffer, 0, len);
		fis.close();
		fos.close();
		
		FaceDao.setFace(UserInfoDao.selectUserId(email), path + "//" + filename);

		return "success";
	}
}


