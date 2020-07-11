package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface OFUMapper
{
	//新建 订单-食物-用户
	public void AddOFU(@Param("OrderId") String OrderId,@Param("FoodId") String FoodId,@Param("FoodNumber") Integer FoodNumber);
	//删除 订单-食物-用户
	public void DropOFU(@Param("OrderId") String OrderId,@Param("FoodId") String FoodId,@Param("FoodNumber") Integer FoodNumber);
}
