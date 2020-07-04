package top.xeonwang.tmxk.domain;

public class OrderInf
{
	private String OrderId;
	private String OrderTime;
	private String OrderStatus;
	
	public String getOrderId()
	{
		return this.OrderId;
	}
	public void setOrderId(String id)
	{
		this.OrderId = id;
	}
	public String getOrderTime()
	{
		return this.OrderTime;
	}
	public void setOrderTime(String time)
	{
		this.OrderId = time;
	}
	public String getOrderStatus()
	{
		return this.OrderStatus;
	}
	public void setOrderStatus(String status)
	{
		this.OrderStatus = status;
	}
	
}
