package top.xeonwang.tmxk.service;

public interface OAService
{
	//新建 订单-管理员-用户
	public void AddOA(String OrderId,String AdminId,String UserId);
	//删除 订单-管理员-用户
	public void DropOa(String OrderId,String AdminId,String UserId);
}
