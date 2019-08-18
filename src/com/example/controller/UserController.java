package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.User;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findUser")
	public String toSuccess() {
		return "success";
	}
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUserById(@PathVariable("id")Integer id) {
		User user = userService.getUserById(id);
		return user;
	}
	
	@RequestMapping("/insertBatch")
	public void insertBatch() {
		List<User> datas = new ArrayList<User>();
		for (int i = 0; i < 1000; i++) {
			User user = new User();
			user.setUsername("张三 - " + i);
			user.setAddress("江西省 - " + i);
			datas.add(user);
		}
		userService.insertBatch(datas);
	}
	
	@RequestMapping("/list")
	public String getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
		Model model) {
		
		PageHelper.startPage(page, 10);
		List<User> users = userService.getUserList();
		
		// 获取所有分页信息
		PageInfo<User> pageInfo = new PageInfo<>(users, 5);
		
//		System.out.println("当前页：" + pageInfo.getPageNum());
//		System.out.println("上一页：" + pageInfo.getPrePage());
//		System.out.println("下一页：" + pageInfo.getNextPage());
//		System.out.println("总页数：" + pageInfo.getPages());
//		System.out.println("当前页记录数：" + pageInfo.getPageSize());
//		System.out.println("总记录数：" + pageInfo.getTotal());
//		int[] navs = pageInfo.getNavigatepageNums();
//		for (int i : navs) {
//			System.out.println(i);
//		}
		
		model.addAttribute("users", users);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}
}
