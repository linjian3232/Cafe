package top.xeonwang.tmxk.domain;

public class Food_Id_Name_Number
{
	String FoodId;
	String FoodName;
	int FoodNumber;
	
	public Food_Id_Name_Number(String id,String name,Integer num)
	{
		// TODO Auto-generated constructor stub
		this.FoodId = id;
		this.FoodName = name;
		this.FoodNumber = num;
	}
	
	public String getFoodId()
	{
		return this.FoodId;
	}

	public void setFoodId(String id)
	{
		this.FoodId = id;
	}
	
	public String getFoodName()
	{
		return this.FoodName;
	}

	public void setFoodName(String name)
	{
		this.FoodName = name;
	}
	
	public Integer FoodNumber() {
		return this.FoodNumber;
	}
	public void setFoodNumber(Integer number) {
		this.FoodNumber = number;
	}
}
