package top.xeonwang.tmxk.domain;

public class UserInfo {

	private String username;
	private String email;
	private String phone;
	private String birthday;
	private String gender;
	public UserInfo() {
		
	}
	public UserInfo(String username, String email, String phone, String birthday, String gender) {
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
	}
	public UserInfo(User user) {
		this.username=user.getUserName();
		this.email=user.getUserEmail();
		this.phone=user.getUserPhone();
		this.birthday=user.getUserBirthday();
		this.gender=user.getUserGender();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
