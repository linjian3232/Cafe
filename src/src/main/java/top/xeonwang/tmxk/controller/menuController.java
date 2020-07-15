package top.xeonwang.tmxk.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.xeonwang.tmxk.domain.Food;
import top.xeonwang.tmxk.service.FoodService;
import top.xeonwang.tmxk.service.UserService;
import top.xeonwang.tmxk.util.GetRandomId;

@Controller
public class menuController {
	@Resource
	private FoodService foodservice;
	@Resource
	private UserService userService;
	//获取菜单
	@RequestMapping("/getMenuList")
	@ResponseBody
	public ArrayList<Food> getMenu() {
		System.out.println("getMenu");
		if(foodservice.GetAll().size()==0) {
			System.out.println("false");
			return null;
		}
		return foodservice.GetAll();
	}
	
	//新增菜单
	@RequestMapping("/addMenuList")
	public String addMenu(HttpServletRequest request)
	{
		String FoodName = request.getParameter("goods_name");
		String FoodType = request.getParameter("goods_type");
		long FoodStock = Integer.valueOf(request.getParameter("goods_stock"));
		String FoodUnit = request.getParameter("goods_unit");
		String FoodImg = request.getParameter("goods_image");
		double FoodPrice = Double.parseDouble(request.getParameter("goods_price"));
		String FoodId = GetRandomId.GetRandomString(10);
		
		foodservice.AddFood(FoodId,FoodName, FoodType, FoodStock, FoodUnit, FoodImg, FoodPrice);
		
		return "OK";
	}
}
