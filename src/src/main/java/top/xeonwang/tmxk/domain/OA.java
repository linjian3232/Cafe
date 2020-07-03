package top.xeonwang.tmxk.domain;

public class OA
{
	private String OrderId;
	private String UserId;
	private String AdminId;
	
	public String getUserId() {
		return this.UserId;
	}
	public void setUserId(String id) {
		this.UserId = id;
	}
	public String getOrderId() {
		return this.OrderId;
	}
	public void setOrderId(String id) {
		this.OrderId = id;
	}
	public String getAdminId() {
		return this.AdminId;
	}
	public void setAdminId(String id) {
		this.AdminId = id;
	}
}
