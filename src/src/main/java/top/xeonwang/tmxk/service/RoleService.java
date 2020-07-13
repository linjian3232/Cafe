package top.xeonwang.tmxk.service;

import org.springframework.stereotype.Service;

public interface RoleService
{
	//新建角色
	public void AddRole(String RoleId,String RoleName);
	//修改角色姓名
	public void UpdateName(String RoleId,String RoleName);
	//删除角色
	public void DropRole(String RoleId);
}
