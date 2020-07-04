package top.xeonwang.tmxk.service;

public interface OFUService
{
	//新建 订单-食物-用户
	public void AddOFU(String OrderId,String FoodId,Integer FoodNumber);
	//删除 订单-食物-用户
	public void DropOFU(String OrderId,String FoodId,Integer FoodNumber);
}
