package top.xeonwang.tmxk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.xeonwang.tmxk.service.UserService;

@Controller
public class UserController
{
	@Resource
	private UserService uservice;
	
	//管理员删除用户
	@RequestMapping("/deleteuser")
	public String DropUser(HttpServletRequest request)
	{
		uservice.DropUser(request.getParameter("ids"));
		
		return "OK";
	}
	
	
}
