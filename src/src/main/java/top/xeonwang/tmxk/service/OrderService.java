package top.xeonwang.tmxk.service;

import top.xeonwang.tmxk.domain.OrderInf;

public interface OrderService
{
	//增加订单
	public void AddOrder(String DataTime,String OrderStatus);
	
	//更新订单状态
	public void UpdateStatus(String OrderId,String OrderStatus);
	
	//删除订单
	public void DropOrder(String OrderId);
	
	public OrderInf Get_all_info(String OrderId);
}
