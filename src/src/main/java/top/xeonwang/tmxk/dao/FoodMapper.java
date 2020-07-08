package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;

public interface FoodMapper
{
	//增加菜单
	public void AddFood(@Param("FoodName") String FoodName,@Param("FoodType") String FoodType,
			@Param("FoodStore") Integer FoodStore,@Param("FoodUnit") String FoodUnit,
			@Param("FoodImg") String FoodImg);
	//修改菜单
	public void UpdateName(@Param("FoodId") String FoodId,@Param("FoodName") String FoodName);
	public void UpdateType(@Param("FoodId") String FoodId,@Param("FoodType") String FoodType);
	public void UpdateStore(@Param("FoodId") String FoodId,@Param("FoodStore") Integer FoodStore);
	public void UpdateUnit(@Param("FoodId") String FoodId,@Param("FoodUnit") String FoodUnit);
	public void UpdateImg(@Param("FoodId") String FoodId,@Param("FoodImg") String FoodImg);
	//根据名字查找id
	public String FindByName(@Param("FoodName") String FoodName);
	//删除菜单
	public void DropFood(@Param("FoodId") String FoodId);
	//获取全部菜品
	
}
