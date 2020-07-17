package top.xeonwang.tmxk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogin {
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	
	public UserLogin() {

	}
	public UserLogin(String username,String password) {
		this.username=username;
		this.password=password;
	}

	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
