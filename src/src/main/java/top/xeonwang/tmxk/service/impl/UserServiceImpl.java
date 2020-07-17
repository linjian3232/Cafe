package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.xeonwang.tmxk.dao.UserMapper;
import top.xeonwang.tmxk.service.UserService;
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Resource
	private UserMapper usermapper;
	
	public void AddUser(String UserId,String UserName,String UserPwd,String UserPhone,String UserSex,String UserEmail)
	{
		usermapper.AddUser(UserId, UserName, UserPwd, UserPhone, UserSex, UserEmail);
	}

	public String FindByName_Phone(String UserName, String UserPhone)
	{
		return usermapper.FindByName_Phone(UserName, UserPhone);		
	}

	public void DropUser(String UserId)
	{
		usermapper.DropUser(UserId);
	}

	public void UpdateName(String UserId, String UserName)
	{
		usermapper.UpdateName(UserId,UserName);
	}

	public void UpdatePwd(String UserId, String UserPwd)
	{
		usermapper.UpdatePwd(UserId, UserPwd);
	}

	public void UpdatePhone(String UserId, String UserPhone)
	{
		usermapper.UpdatePhone(UserId, UserPhone);
	}

	public void UpdateSex(String UserId, String UserSex)
	{
		usermapper.UpdateSex(UserId, UserSex);
	}

	public void UpdateEmail(String UserId, String UserEmail)
	{
		usermapper.UpdateEmail(UserId, UserEmail);
	}

	public String ValidateUser(String UserName, String UserPwd) 
	{
		String userid=usermapper.ValidateUser(UserName, UserPwd);
		
		if(userid!="") {
			return userid;
		}
		else {
			return "";
		}
	}
}
