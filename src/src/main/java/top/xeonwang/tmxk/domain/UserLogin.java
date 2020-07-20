package top.xeonwang.tmxk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogin {
	@JsonProperty("username")
	private String userName;
	@JsonProperty("password")
	private String userPwd;
	@JsonProperty("usertype")
	private String userType;
	
	public UserLogin() {
		
	}
	
	public UserLogin(String id,String pwd,String type) {
		this.userName=id;
		this.userPwd=pwd;
		this.userType=type;
	}

	public String getName() {
		return userName;
	}

	public void getName(String id) {
		this.userName = id;
	}

	public String getPwd() {
		return userPwd;
	}

	public void setPwd(String pwd) {
		this.userPwd = pwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
