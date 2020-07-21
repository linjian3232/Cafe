package top.xeonwang.tmxk.domain;

public class UserToken {
	private String userType;
	private int userId;
	public UserToken() {
		this.userType = null;
		this.userId = 0;
	}
	public UserToken(String userType, int userId) {
		this.userType = userType;
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
