package top.xeonwang.tmxk.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.xeonwang.tmxk.dao.OAMapper;
import top.xeonwang.tmxk.dao.OFUMapper;
import top.xeonwang.tmxk.domain.Food_Id_Name_Number;
import top.xeonwang.tmxk.domain.HistoryOrder;
import top.xeonwang.tmxk.service.OAService;
import top.xeonwang.tmxk.service.OFUService;
import top.xeonwang.tmxk.service.OrderService;

@Controller
public class historyController
{
	@Resource
	private OAService oaservice;
	@Resource
	private OFUService ofuservice;
	@Resource
	private OrderService orderservice;
	
	//根据用户id获取用户的所有历史订单id
	@RequestMapping("/history")
	public ArrayList<String> UserHistory(HttpServletRequest request)
	{
		return oaservice.GetUser_Order(request.getParameter("userid"));
	}
	
	//根据订单id获取订单详细内容
	@RequestMapping("/history_order")
	public HistoryOrder GetOrderInfo(HttpServletRequest request)
	{
		HistoryOrder h = new HistoryOrder(ofuservice.GetAll_OrderInf(request.getParameter("orderid")), orderservice.Get_all_info(request.getParameter("orderid")).getOrderTime(), orderservice.Get_all_info(request.getParameter("orderid")).getOrderStatus());
		return h;
	}
	
	//获取历史记录中各食物销量
	@RequestMapping("/popular")
	public ArrayList<Food_Id_Name_Number> Get_popular()
	{
		return ofuservice.Sum_FoodNumber();
	}
}
