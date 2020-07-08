package top.xeonwang.tmxk.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.xeonwang.tmxk.domain.Food;
import top.xeonwang.tmxk.service.FoodService;


@Controller
public class menuController {
	@Resource
	private FoodService foodservice;
	
	
	@RequestMapping("/getMenuList")
	public ArrayList<Food> getMenu() {
		ArrayList<Food> lf=new ArrayList<Food>();
//		System.out.println("getMenu");
		lf = foodservice.GetAll();
		return lf;
	}
}
