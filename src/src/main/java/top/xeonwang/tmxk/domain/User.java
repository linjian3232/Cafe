package top.xeonwang.tmxk.domain;

public class User {

	private String UserId;
	private String UserName;
	private String UserPwd;
	private String UserPhone;
	private String UserSex;
	private String UserEmail;
	
	public String getUserId() {
		return this.UserId;
	}
	public void setUserId(String id) {
		this.UserId = id;
	}
	public String getUserName() {
		return this.UserName;
	}
	public void setUserName(String name) {
		this.UserName = name;
	}
	public String getUserPwd() {
		return this.UserPwd;
	}
	public void setUserPwd(String pwd) {
		this.UserPwd = pwd;
	}
	public String getUserPhone() {
		return this.UserPhone;
	}
	public void setUserPhone(String phone) {
		this.UserPhone = phone;
	}
	public String getUserSex() {
		return this.UserSex;
	}
	public void setUserSex(String sex) {
		this.UserSex = sex;
	}
	public String getUserEmail() {
		return this.UserEmail;
	}
	public void setUserEmail(String email) {
		this.UserEmail = email;
	}
	
}
