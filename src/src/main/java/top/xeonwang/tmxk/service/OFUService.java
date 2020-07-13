package top.xeonwang.tmxk.service;

import java.util.ArrayList;

import top.xeonwang.tmxk.domain.Food_Id_Name_Number;

public interface OFUService
{
	//新建 订单-食物-用户
	public void AddOFU(String OrderId,String FoodId,Integer FoodNumber);
	//删除 订单-食物-用户
	public void DropOFU(String OrderId,String FoodId,Integer FoodNumber);
	//获取订单内的所有foodid
	public ArrayList<Food_Id_Name_Number> GetAll_OrderInf(String OrderId);
	//获取订单历史每种食物的数量
	public ArrayList<Food_Id_Name_Number> Sum_FoodNumber();
	
}
