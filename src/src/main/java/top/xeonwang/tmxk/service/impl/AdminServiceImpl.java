package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import top.xeonwang.tmxk.dao.AdminMapper;
import top.xeonwang.tmxk.service.AdminService;

public class AdminServiceImpl implements AdminService
{
	@Resource
	private AdminMapper adminmapper;

	@Override
	public void AddAdmin(String AdminId, String AdminName, String AdminPos)
	{
		// TODO Auto-generated method stub
		adminmapper.AddAdmin(AdminId, AdminName, AdminPos);
	}

	@Override
	public void UpdateName(String AdminId, String AdminName)
	{
		// TODO Auto-generated method stub
		adminmapper.UpdateName(AdminId, AdminName);
	}

	@Override
	public void UpdatePos(String AdminId, String AdminPos)
	{
		// TODO Auto-generated method stub
		adminmapper.UpdatePos(AdminId, AdminPos);
	}

	@Override
	public void FindByName(String AdminName)
	{
		// TODO Auto-generated method stub
		adminmapper.FindByName(AdminName);
	}

	@Override
	public void DropAdmin(String AdminId)
	{
		// TODO Auto-generated method stub
		adminmapper.DropAdmin(AdminId);
	}
	
	
	
}
