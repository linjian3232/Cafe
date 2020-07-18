package top.xeonwang.tmxk.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import top.xeonwang.tmxk.domain.UserLogin;
import top.xeonwang.tmxk.service.AdminService;
import top.xeonwang.tmxk.service.UserService;
import top.xeonwang.tmxk.util.Token;

@Controller
public class userController {
	@Resource
	UserService userService;
	@Resource
	AdminService adminService;
	
	@ResponseBody
	@RequestMapping("/login")
	String login(HttpServletRequest request) throws IOException {
		//jackson工具
		ObjectMapper om = new ObjectMapper();
		//返回值
		Map<String, Object> re = new HashMap<String, Object>();
		//Token
		String token=null;
		//读取data
			//JDK8 兼容修改
		byte[] temp = new byte[1000];
		
		request.getInputStream().read(temp);
		String text=new String(temp);
		
		//登录用户信息存储
		UserLogin ul=om.readValue(text,UserLogin.class);
		
		//获取登录信息
		String userid=userService.ValidateUser(ul.getUserName(), ul.getPassword());
		System.out.println(userid);
		if(userid!=null) {
			token=Token.sign( ul.getUserName(),userid );
		}
		else {
			token="";
		}
		re.put("token", token);
		
		return om.writeValueAsString(re);
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request) {
		
		request.getCookies();
		//jackson工具
		ObjectMapper om = new ObjectMapper();
		//返回值
		Map<String, Object> re = new HashMap<String, Object>();
		
		
		return "";
	}
}
