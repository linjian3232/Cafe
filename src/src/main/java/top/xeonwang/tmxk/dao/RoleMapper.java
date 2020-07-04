package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper
{
	//新建角色
	public void AddRole(@Param("RoleId") String RoleId,@Param("RoleName") String RoleName);
	//修改角色姓名
	public void UpdateName(@Param("RoleId") String RoleId,@Param("RoleName") String RoleName);
	//删除角色
	public void DropRole(@Param("RoleId") String RoleId);
	
}
