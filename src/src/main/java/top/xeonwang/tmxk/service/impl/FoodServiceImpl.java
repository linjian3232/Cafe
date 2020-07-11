package top.xeonwang.tmxk.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.xeonwang.tmxk.dao.FoodMapper;
import top.xeonwang.tmxk.domain.Food;
import top.xeonwang.tmxk.service.FoodService;

@Service("FoodService")
@Transactional
public class FoodServiceImpl implements FoodService
{
	@Resource
	private FoodMapper foodmapper;
	
	@Override
	public void AddFood(String FoodId,String FoodName, String FoodType, long FoodStore, String FoodUnit, String FoodImg,double FoodPrice)
	{
		// TODO Auto-generated method stub
		foodmapper.AddFood(FoodId,FoodName, FoodType, FoodStore, FoodUnit, FoodImg,FoodPrice);
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
	public void UpdateStore(String FoodId, long FoodStore)
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

	@Override
	public void UpdatePrice(String FoodId, double FoodPrice)
	{
		// TODO Auto-generated method stub
		foodmapper.UpdatePrice(FoodId, FoodPrice);
	}

	@Override
	public ArrayList<Food> GetAll()
	{
		// TODO Auto-generated method stub
		return foodmapper.GetAll();
	}

}
