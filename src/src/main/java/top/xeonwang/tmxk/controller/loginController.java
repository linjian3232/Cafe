package top.xeonwang.tmxk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.xeonwang.tmxk.service.UserService;

@Controller
public class loginController {
	@Resource
	private UserService userservice;
	
	@RequestMapping("/login")
	public String Login(HttpServletRequest request)
	{
		if(userservice.GetPwd(request.getParameter("username")) == request.getParameter("password"))
			return "OK";
		return "Error";
	}

}
