package top.xeonwang.tmxk.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.xeonwang.tmxk.domain.Food;
import top.xeonwang.tmxk.service.FoodService;


@Controller
public class menuController {
	@Resource
	private FoodService foodservice;
	
	//获取菜单
	@RequestMapping("/getMenuList")
	@ResponseBody
	public ArrayList<Food> getMenu() {
		ArrayList<Food> lf=new ArrayList<Food>();
		lf = foodservice.GetAll();
		System.out.println("no id ont ");
		return lf;
	}
	
	//新增菜单
	@RequestMapping("/addMenuList")
	@ResponseBody
	public String addMenu(HttpServletRequest request)
	{
		String FoodName = request.getParameter("goods_name");
		String FoodType = request.getParameter("goods_type");
		long FoodStock = Integer.valueOf(request.getParameter("goods_stock"));
		String FoodUnit = request.getParameter("goods_unit");
		String FoodImg = request.getParameter("goods_image");
		double FoodPrice = Double.parseDouble(request.getParameter("goods_price"));
		String FoodId = null;
		
		foodservice.AddFood(FoodId,FoodName, FoodType, FoodStock, FoodUnit, FoodImg, FoodPrice);
		
		return "OK";
	}
	
	
	
	
	
}
