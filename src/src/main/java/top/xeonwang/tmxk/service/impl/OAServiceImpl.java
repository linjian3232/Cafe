package top.xeonwang.tmxk.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.xeonwang.tmxk.dao.OAMapper;
import top.xeonwang.tmxk.service.OAService;
@Service("OAService")
@Transactional
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

	@Override
	public ArrayList<String> GetUser_Order(String UserId)
	{
		// TODO Auto-generated method stub
		return oamapper.GetUser_Order(UserId);
	}
	
	
}
