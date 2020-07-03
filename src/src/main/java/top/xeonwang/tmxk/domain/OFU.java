package top.xeonwang.tmxk.domain;

public class OFU
{
	private String OrderId;
	private String FoodId;
	private Integer FoodNumber;
	
	public String getOrderId() {
		return this.OrderId;
	}
	public void setOrderId(String id) {
		this.OrderId = id;
	}
	public String getFoodId() {
		return this.FoodId;
	}
	public void setFoodId(String id) {
		this.FoodId = id;
	}
	public Integer FoodNumber() {
		return this.FoodNumber;
	}
	public void setFoodNumber(Integer number) {
		this.FoodNumber = number;
	}
}
