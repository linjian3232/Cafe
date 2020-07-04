package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import top.xeonwang.tmxk.dao.OFUMapper;
import top.xeonwang.tmxk.service.OFUService;

public class OFUServiceImpl implements OFUService
{
	@Resource
	private OFUMapper ofumapper;

	@Override
	public void AddOFU(String OrderId, String FoodId, Integer FoodNumber)
	{
		// TODO Auto-generated method stub
		ofumapper.AddOFU(OrderId, FoodId, FoodNumber);
	}

	@Override
	public void DropOFU(String OrderId, String FoodId, Integer FoodNumber)
	{
		// TODO Auto-generated method stub
		ofumapper.DropOFU(OrderId, FoodId, FoodNumber);
	}
	
	
}
