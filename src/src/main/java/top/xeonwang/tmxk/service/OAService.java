package top.xeonwang.tmxk.service;

import java.util.ArrayList;

public interface OAService
{
	//新建 订单-管理员-用户
	public void AddOA(String OrderId,String AdminId,String UserId);
	//删除 订单-管理员-用户
	public void DropOa(String OrderId,String AdminId,String UserId);
	//根据用户号查找订单号
	public ArrayList<String> GetUser_Order(String parameter);
}
