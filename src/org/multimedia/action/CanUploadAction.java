package org.multimedia.action;

public class CanUploadAction {
	private String isSuccess;

	public String getIsSuccess() throws Exception{
		setIsSuccess("true");
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public String execute() throws Exception {
		return "success";
	}
}
