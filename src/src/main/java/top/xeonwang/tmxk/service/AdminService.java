package top.xeonwang.tmxk.service;

public interface AdminService
{
public void AddAdmin(String AdminId,String AdminName,String AdminPos);
	
	//修改管理员信息
	public void UpdateName(String AdminId,String AdminName);
	public void UpdatePos(String AdminId,String AdminPos);
	
	//根据名字查找id
	public void FindByName(String AdminName);
	
	//删除管理员
	public void DropAdmin(String AdminId);
	
	//验证管理员
	public Integer ValidateAdmin(String adminName, String adminPwd);
}
