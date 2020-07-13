package top.xeonwang.tmxk.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.xeonwang.tmxk.dao.OFUMapper;
import top.xeonwang.tmxk.domain.Food_Id_Name_Number;
import top.xeonwang.tmxk.service.OFUService;
@Service("OFUService")
@Transactional
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

	@Override
	public ArrayList<Food_Id_Name_Number> GetAll_OrderInf(String OrderId)
	{
		// TODO Auto-generated method stub
		return ofumapper.GetAll_OrderInf(OrderId);
	}

	@Override
	public ArrayList<Food_Id_Name_Number> Sum_FoodNumber()
	{
		// TODO Auto-generated method stub
		return ofumapper.Sum_FoodNumber();
	}
	
	
}
