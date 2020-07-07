package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper
{
	//新建订单
	public void AddOrder(@Param("DataTime") String DataTime,@Param("OrderStatus") String OrderStatus);
	
	//更新订单状态
	public void UpdateStatus(@Param("OrderId") String OrderId,@Param("OrderStatus") String OrderStatus);
	
	//删除订单
	public void DropOrder(@Param("OrderId") String OrderId);
}
