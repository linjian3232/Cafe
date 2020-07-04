package top.xeonwang.tmxk.service;

public interface FoodService
{
	//增加菜单
	public void AddFood(String FoodName,String FoodType,Integer FoodStore,String FoodUnit,String FoodImg);
	//修改菜单
	public void UpdateName(String FoodId,String FoodName);
	public void UpdateType(String FoodId,String FoodType);
	public void UpdateStore(String FoodId,Integer FoodStore);
	public void UpdateUnit(String FoodId,String FoodUnit);
	public void UpdateImg(String FoodId,String FoodImg);
	//根据名字查找id
	public String FindByName(String FoodName);
	//删除菜单
	public void DropFood(String FoodId);
	
}
