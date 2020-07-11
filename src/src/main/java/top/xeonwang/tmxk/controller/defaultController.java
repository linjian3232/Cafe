package top.xeonwang.tmxk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class defaultController {
	
	@RequestMapping("/a")
	void get() {
		System.out.println("a");
	}
	
	
}
