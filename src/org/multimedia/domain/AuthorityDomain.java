package org.multimedia.domain;

public class AuthorityDomain {

	private String managerId;
	private boolean authorityCheck;
	private boolean authorityPublish;
	private boolean authorityDelete;
	private boolean authorityLogout;
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public boolean isAuthorityCheck() {
		return authorityCheck;
	}
	public void setAuthorityCheck(boolean authorityCheck) {
		this.authorityCheck = authorityCheck;
	}
	public boolean isAuthorityPublish() {
		return authorityPublish;
	}
	public void setAuthorityPublish(boolean authorityPublish) {
		this.authorityPublish = authorityPublish;
	}
	public boolean isAuthorityDelete() {
		return authorityDelete;
	}
	public void setAuthorityDelete(boolean authorityDelete) {
		this.authorityDelete = authorityDelete;
	}
	public boolean isAuthorityLogout() {
		return authorityLogout;
	}
	public void setAuthorityLogout(boolean authorityLogout) {
		this.authorityLogout = authorityLogout;
	}
	
	
}
