package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import top.xeonwang.tmxk.dao.OAMapper;
import top.xeonwang.tmxk.service.OAService;

public class OAServiceImpl implements OAService
{
	@Resource
	private OAMapper oamapper;

	@Override
	public void AddOA(String OrderId, String AdminId, String UserId)
	{
		// TODO Auto-generated method stub
		oamapper.AddOA(OrderId, AdminId, UserId);
	}

	@Override
	public void DropOa(String OrderId, String AdminId, String UserId)
	{
		// TODO Auto-generated method stub
		oamapper.DropOa(OrderId, AdminId, UserId);
	}
	
	
}
