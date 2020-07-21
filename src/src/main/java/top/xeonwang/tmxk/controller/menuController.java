package top.xeonwang.tmxk.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	@ResponseBody
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
	
	@RequestMapping("/uploadPic")
	@ResponseBody
	public String uploadPic(HttpServletRequest request)
	{

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = multipartRequest.getFiles("uploadImage");
        for (MultipartFile item : fileList) {
            String fileName = "";        //当前上传文件全名称
            String fileType = "";        //当前上传文件类型
            String saveFileName = "";    //保存到服务器目录的文件名称
            String reportAddr = "";      //保存到服务器目录的文件全路径
            try {
                fileName = item.getOriginalFilename();
                fileType = item.getContentType();
            }catch (Exception e) {

			}
            System.out.println(fileName+" "+fileType);
            System.out.println(request.getSession().getServletContext().getRealPath("/"));
            
            File savedFile = new File("", saveFileName);
            try {
				item.transferTo(savedFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
       
		System.out.println("success");
		System.out.println(request.getContentType());

		return "{}";
	}
	
	
	
}
