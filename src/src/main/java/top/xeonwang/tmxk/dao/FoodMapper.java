package top.xeonwang.tmxk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import top.xeonwang.tmxk.domain.Food;

public interface FoodMapper
{
	//增加菜单
	public void AddFood(@Param("FoodId") String FoodId,@Param("FoodName") String FoodName,@Param("FoodType") String FoodType,
			@Param("FoodStore") long FoodStore,@Param("FoodUnit") String FoodUnit,
			@Param("FoodImg") String FoodImg,@Param("FoodPrice") double FoodPrice);
	//修改菜单
	public void UpdateName(@Param("FoodId") String FoodId,@Param("FoodName") String FoodName);
	public void UpdateType(@Param("FoodId") String FoodId,@Param("FoodType") String FoodType);
	public void UpdateStore(@Param("FoodId") String FoodId,@Param("FoodStore") long FoodStore);
	public void UpdateUnit(@Param("FoodId") String FoodId,@Param("FoodUnit") String FoodUnit);
	public void UpdateImg(@Param("FoodId") String FoodId,@Param("FoodImg") String FoodImg);
	public void UpdatePrice(@Param("FoodId") String FoodId,@Param("FoodPrice") double foodPrice);
	//根据名字查找id
	public String FindByName(@Param("FoodName") String FoodName);
	//删除菜单
	public void DropFood(@Param("FoodId") String FoodId);
	//获取全部菜品
	public ArrayList<Food> GetAll();
}
