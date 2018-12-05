package com.petshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.petshop.pojo.User;
import com.petshop.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	
	
	@RequestMapping(value="/checklogin", method=RequestMethod.POST)
	public String login(@RequestParam("account")String account, 
						@RequestParam("password")String password,
						HttpServletRequest request,
						HttpServletResponse response, Model model) {
	
		User user = userservice.login(account, password);
		if (null == user) {
			model.addAttribute("mistake", "帐号或密码错误");
			return "redirect:/login";
		}
		HttpSession session = request.getSession();
		String sessionID = session.getId();

		session.setAttribute("user", user);
		session.setMaxInactiveInterval(3600);

		Cookie cookie = new Cookie("JSESSIONID", sessionID);
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "forward:/goods?category=all";
	}
	@RequestMapping("/login")
	public String loginPage(HttpSession session) {
		
		if (null != session.getAttribute("user")) {
			return "redirect:/index";
		}
		return "login";
	}
	
	
	//注销
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.setMaxInactiveInterval(10);
		return "redirect:/login";
	}

}
