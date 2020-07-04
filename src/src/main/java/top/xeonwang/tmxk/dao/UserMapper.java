package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;

public interface UserMapper
{
//	新增用户
	public void AddUser(@Param("UserId") String UserId,@Param("UserName") String UserName,
			@Param("UserPwd") String UserPwd,@Param("UserPhone") String UserPhone,
			@Param("UserSex") String UserSex,@Param("UserEmail") String UserEmail);
//	修改用户
	public void UpdateName(@Param("UserId") String UserId,@Param("UserName") String UserName);
	public void UpdatePwd(@Param("UserId") String UserId,@Param("UserPwd") String UserPwd);
	public void UpdatePhone(@Param("UserId") String UserId,@Param("UserPhone") String UserPhone);
	public void UpdateSex(@Param("UserId") String UserId,@Param("UserSex") String UserSex);
	public void UpdateEmail(@Param("UserId") String UserId,@Param("UserEmail") String UserEmail);

//	根据姓名、电话查找用户id
	public String FindByName_Phone(@Param("UserName") String UserName,@Param("UserPhone") String UserPhone);
//	删除用户
	public void DropUser(@Param("UserId") String UserId);
	
}
