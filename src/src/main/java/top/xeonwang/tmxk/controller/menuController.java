package top.xeonwang.tmxk.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.xeonwang.tmxk.domain.Food;

@Controller
public class menuController {
	@RequestMapping("/getMenuList")
	public void getMenu() {
		ArrayList<Food> lf=new ArrayList<Food>();
		System.out.println("getMenu");
	}
}
