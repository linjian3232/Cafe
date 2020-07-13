package top.xeonwang.tmxk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.xeonwang.tmxk.domain.HistoryOrder;
import top.xeonwang.tmxk.domain.OrderInf;
@Repository
public interface OrderMapper
{
	//新建订单
	public void AddOrder(@Param("DataTime") String DataTime,@Param("OrderStatus") String OrderStatus);
	
	//更新订单状态
	public void UpdateStatus(@Param("OrderId") String OrderId,@Param("OrderStatus") String OrderStatus);
	
	//删除订单
	public void DropOrder(@Param("OrderId") String OrderId);
	
	//获取所有订单id
	public ArrayList<String> GetAllOrderId();
	
	//根据id获取订单信息
	public OrderInf Get_all_info(@Param("OrderId") String OrderId);
}
