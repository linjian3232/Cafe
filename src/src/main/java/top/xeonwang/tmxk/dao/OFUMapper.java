package top.xeonwang.tmxk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.xeonwang.tmxk.domain.Food_Id_Name_Number;
import top.xeonwang.tmxk.domain.HistoryOrder;
@Repository
public interface OFUMapper
{
	//新建 订单-食物-用户
	public void AddOFU(@Param("OrderId") String OrderId,@Param("FoodId") String FoodId,@Param("FoodNumber") Integer FoodNumber);
	//删除 订单-食物-用户
	public void DropOFU(@Param("OrderId") String OrderId,@Param("FoodId") String FoodId,@Param("FoodNumber") Integer FoodNumber);
	//获取订单内的所有食物信息
	public ArrayList<Food_Id_Name_Number> GetAll_OrderInf(@Param("OrderId") String OrderId);
	//获取订单历史每种食物的数量
	public ArrayList<Food_Id_Name_Number> Sum_FoodNumber();
	
}
