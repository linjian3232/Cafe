package top.xeonwang.tmxk.service;

public interface UserService
{
//	增加用户
	public void AddUser(String UserId,String UserName,String UserPwd,String UserPhone,String UserSex,String UserEmail);
//	修改用户
	public void UpdateName(String UserId,String UserName);
	public void UpdatePwd(String UserId,String UserPwd);
	public void UpdatePhone(String UserId,String UserPhone);
	public void UpdateSex(String UserId,String UserSex);
	public void UpdateEmail(String UserId,String UserEmail);	
//	根据姓名、电话查找用户id
	public String FindByName(String UserName);
	//获取用户密码
	public String GetPwd(String UserName);
//	删除用户
	public void DropUser(String UserId);
	
	
	
}
