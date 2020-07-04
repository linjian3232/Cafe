package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import top.xeonwang.tmxk.dao.FoodMapper;
import top.xeonwang.tmxk.service.FoodService;

public class FoodServiceImpl implements FoodService
{
	@Resource
	private FoodMapper foodmapper;
	
	@Override
	public void AddFood(String FoodName, String FoodType, Integer FoodStore, String FoodUnit, String FoodImg)
	{
		// TODO Auto-generated method stub
		foodmapper.AddFood(FoodName, FoodType, FoodStore, FoodUnit, FoodImg);
	}

	@Override
	public void UpdateName(String FoodId, String FoodName)
	{
		// TODO Auto-generated method stub
		foodmapper.UpdateName(FoodId, FoodName);
	}

	@Override
	public void UpdateType(String FoodId, String FoodType)
	{
		// TODO Auto-generated method stub
		foodmapper.UpdateType(FoodId, FoodType);
	}

	@Override
	public void UpdateStore(String FoodId, Integer FoodStore)
	{
		// TODO Auto-generated method stub
		foodmapper.UpdateStore(FoodId, FoodStore);
	}

	@Override
	public void UpdateUnit(String FoodId, String FoodUnit)
	{
		// TODO Auto-generated method stub
		foodmapper.UpdateUnit(FoodId, FoodUnit);
	}

	@Override
	public void UpdateImg(String FoodId, String FoodImg)
	{
		// TODO Auto-generated method stub
		foodmapper.UpdateImg(FoodId, FoodImg);
	}

	@Override
	public String FindByName(String FoodName)
	{
		// TODO Auto-generated method stub
		return foodmapper.FindByName(FoodName);
	}

	@Override
	public void DropFood(String FoodId)
	{
		// TODO Auto-generated method stub
		foodmapper.DropFood(FoodId);
	}

}
