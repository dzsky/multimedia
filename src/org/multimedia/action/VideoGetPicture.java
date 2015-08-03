package org.multimedia.action;

import org.multimedia.dao.ResourceDao;

public class VideoGetPicture {
	private String path;
	private String resourceId;

	public String getPath() throws Exception{
		String filePath = ResourceDao.selectResourcePath(getResourceId());
		filePath = filePath.substring(0, filePath.indexOf("." + 1));
		setPath(filePath + ".jpg");
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}


