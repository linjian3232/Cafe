package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.xeonwang.tmxk.dao.RoleMapper;
import top.xeonwang.tmxk.service.RoleService;
@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService
{
	@Resource
	private RoleMapper rolemapper;
	
	@Override
	public void AddRole(String RoleId, String RoleName)
	{
		// TODO Auto-generated method stub
		rolemapper.AddRole(RoleId, RoleName);
	}

	@Override
	public void UpdateName(String RoleId, String RoleName)
	{
		// TODO Auto-generated method stub
		rolemapper.UpdateName(RoleId, RoleName);
	}

	@Override
	public void DropRole(String RoleId)
	{
		// TODO Auto-generated method stub
		rolemapper.DropRole(RoleId);
	}

}
