package top.xeonwang.tmxk.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import top.xeonwang.tmxk.domain.User;
import top.xeonwang.tmxk.domain.UserInfo;
import top.xeonwang.tmxk.domain.UserLogin;
import top.xeonwang.tmxk.domain.UserToken;
import top.xeonwang.tmxk.service.AdminService;
import top.xeonwang.tmxk.service.UserService;
import top.xeonwang.tmxk.util.Token;
import top.xeonwang.tmxk.util.myUtil;

@Controller
public class userController {
	@Resource
	UserService userService;
	@Resource
	AdminService adminService;
	
	@RequestMapping("/login")
	@ResponseBody
	String login(HttpServletRequest request) throws IOException {
		//jackson工具
		ObjectMapper om = new ObjectMapper();
		//返回值
		Map<String, Object> re = new HashMap<String, Object>();
		//Token
		String token=null;
		//读取data
			//JDK8 兼容修改
		String text=myUtil.readData(request);
		
		//登录用户信息存储
		UserLogin ul=om.readValue(text,UserLogin.class);
		Integer userid;
		//获取登录信息——用户
		if(ul.getUserType().equals("admin")) {
			userid=adminService.ValidateAdmin(ul.getName(), ul.getPwd());
		}
		else {
			userid=userService.ValidateUser(ul.getName(), ul.getPwd());
		}
		
		if(userid!=null)
			token=Token.sign(userid,ul.getUserType());
		else {
			token="";
		}
		
		//获取登录信息——管理员
		re.put("token", token);
		re.put("userType", ul.getUserType());
		
		return om.writeValueAsString(re);
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request) throws JsonProcessingException, ParseException {
		//读数据
		String text=myUtil.readData(request);
		//jackson工具
		ObjectMapper om = new ObjectMapper();
		//返回值
		Map<String, Object> re = new HashMap<String, Object>();
		System.out.println(text);
		
		User user=om.readValue(text, User.class);
		System.out.println(user.getUserBirthday());
		userService.AddUser(user.getUserName(),user.getUserPwd(),user.getUserPhone(),user.getUserGender(),user.getUserEmail(),user.getUserBirthday());
		
		if(userService.CheckUserName(user.getUserName())!=null) {
			re.put("ok", "true");
		}
		else {
			re.put("ok", "false");
		}
		return om.writeValueAsString(re);
		//User user=om.readValue(text, User.class);
	}
	@RequestMapping("/checkUserName")
	@ResponseBody
	public String checkUserName(HttpServletRequest request) throws JsonProcessingException {
		String text=myUtil.readData(request);
		ObjectMapper om = new ObjectMapper();
		UserLogin ul=om.readValue(text,UserLogin.class);
		Map<String, Object> map = om.readValue(text,Map.class);
		String username = (String) map.get("username");
		Map<String, Object> re = new HashMap<String, Object>();
		if(userService.CheckUserName(username)!=null) {
			re.put("ok", "false");
		}
		else {
			re.put("ok", "true");
		}
		return om.writeValueAsString(re);
	}
	
	@RequestMapping("/getPersonInfo")
	@ResponseBody
	public String getPersonInfo(HttpServletRequest request) throws JsonProcessingException {
		String text=myUtil.readData(request);
		ObjectMapper om = new ObjectMapper();
		Cookie[] cookie=request.getCookies();
		Map<String, Object> re = new HashMap<String, Object>();
		if(cookie==null) {
			re.put("ok","false");
			return om.writeValueAsString(re);
		}
		UserToken ut=Token.verify(cookie[0].getValue());

		UserInfo user=new UserInfo(userService.getAllData(ut.getUserId()));
		System.out.println(user.getUsername());
		return om.writeValueAsString(user);
	}
}
