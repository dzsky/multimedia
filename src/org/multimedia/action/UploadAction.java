package org.multimedia.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.multimedia.dao.LastIdDao;
import org.multimedia.dao.ResourceDao;
import org.multimedia.domain.ResourceDomain;

import com.opensymphony.xwork2.ActionContext;

public class UploadAction {
	private String selection;
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String isSuccess;
	private String back;
		
	
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
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
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
	
	private String getPath() {
		if(getSelection().equals("1"))
			return getSavePath() + "video";
		else if(getSelection().equals("2"))
			return getSavePath() + "voice";
		else if(getSelection().equals("3"))
			return getSavePath() + "picture";
		else
			return getSavePath() + "document";
	}
	
	private String getResourceId() {
		int id = LastIdDao.getSingle(2).getNum();
		id ++;
		LastIdDao.update(2, id);
		return "" + id;
	}
	
	private void insertIntoTable() {
		if(getTitle() == null || getTitle().equals("")) {
			setTitle(getUploadFileName());
		}
		Timestamp date = new Timestamp(new java.util.Date().getTime());
		ActionContext ctx = ActionContext.getContext();
		ResourceDomain resourceDomain = new ResourceDomain(getResourceId(), (String)ctx.getSession().get("userId"),
				getTitle(), getPath() + "/" + getUploadFileName(), 0, null, Integer.valueOf(getSelection()), date, 0);
		ResourceDao.insert(resourceDomain);
	}
	
	public String execute() throws Exception {
		
		String path = getPath();
		FileOutputStream fos = new FileOutputStream(path + "//" + getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buffer)) > 0)
			fos.write(buffer, 0, len);
		fis.close();
		fos.close();
		
		insertIntoTable();
		if(getSelection().equals("1"))
			getPicture(path + "/" + getUploadFileName(), "c:/ffmpeg.exe");
		return "success";
	}
	
	private void getPicture(String veido_path, String ffmpeg_path) {
		 File file = new File(veido_path);  
		  if (!file.exists()) {  
			  System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");  
		    		return; 
		  }  
		  
		  List<String> commands = new java.util.ArrayList<String>();  
		    commands.add(ffmpeg_path);  
		    commands.add("-i");  
		    commands.add(veido_path);  
		    commands.add("-y");  
		    commands.add("-f");  
		    commands.add("image2");  
		    commands.add("-ss");  
		    commands.add("30");//这个参数是设置截取视频多少秒时的画面  
		    //commands.add("-t");  
		    //commands.add("0.001");  
		    commands.add("-s");  
		    commands.add("700x525");  
		    commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");  
		    
		    try {  
		    	ProcessBuilder builder = new ProcessBuilder();  
		    	builder.command(commands);  
		    	builder.start();  
		    	System.out.println("截取成功");  
		    	return ;
		    } catch (Exception e) {  
		    	e.printStackTrace();  
		    	return ;  
		    }  
		
	}
	public String getIsSuccess() throws Exception{
		String path = getPath();
		FileOutputStream fos = new FileOutputStream(path + "//" + getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buffer)) > 0)
			fos.write(buffer, 0, len);
		fis.close();
		fos.close();
		
		insertIntoTable();
		setIsSuccess("true");
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getBack() throws Exception{
		String path = getPath();
		FileOutputStream fos = new FileOutputStream(path + "//" + getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while((len = fis.read(buffer)) > 0)
			fos.write(buffer, 0, len);
		fis.close();
		fos.close();
		
		insertIntoTable();
		if(getSelection().equals("1"))
			getPicture(path + "/" + getUploadFileName(), "c:/ffmpeg.exe");
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}
}
