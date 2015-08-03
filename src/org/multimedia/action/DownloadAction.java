package org.multimedia.action;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.multimedia.dao.ResourceDao;

import com.opensymphony.xwork2.Action;

public class DownloadAction implements Action {   
	
	private String fileName;// 初始的通过param指定的文件名属性  
	
	private String inputPath;// 指定要被下载的文件路径
	private String resourceId;
	
    public InputStream getInputStream() throws Exception {  
    	setInputPath(ResourceDao.selectResourcePath(resourceId));
    	File file = new File(inputPath);
    	InputStream is = new FileInputStream(file);
    	return is;
    }   

    public String execute() throws Exception {   
        return SUCCESS;   
    }   
  
    public void setFileName(String fileName) {   
    	  
        this.fileName = fileName;   
  
    }   
  
    public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}  
  
	private void addDownloadNumber() {
		ResourceDao.addDownloadNumber(getInputPath());
	}
	
    public String getDownloadFileName() {  
    	setInputPath(ResourceDao.selectResourcePath(resourceId));
        String downFileName = inputPath.substring(inputPath.lastIndexOf("/") + 1);   
        try {   
            downFileName = new String(downFileName.getBytes(), "ISO8859-1");   
        } 
        catch (UnsupportedEncodingException e) {   
            e.printStackTrace();   
        }   
        
        addDownloadNumber();
        return downFileName;   
    }

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}   
}   

