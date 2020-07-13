package top.xeonwang.tmxk.domain;

import java.util.ArrayList;

public class HistoryOrder
{
	enum Status {分配中,进行中,已完成,取消};
	
	ArrayList<Food_Id_Name_Number> history;
	String time;
	Status status;
	
	public HistoryOrder(ArrayList<Food_Id_Name_Number> h,String t,String n)
	{
		// TODO Auto-generated constructor stub
		this.history = h;
		this.time = t;
		switch(n)
		{
		case "0":
			this.status = Status.分配中;
			break;
		case "1":
			this.status = Status.进行中;
			break;
		case "2":
			this.status = Status.已完成;
			break;
		case "3":
			this.status = Status.取消;
			break;
		}

	}
	
}
