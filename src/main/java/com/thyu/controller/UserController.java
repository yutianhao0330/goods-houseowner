package com.thyu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thyu.bean.User;
import com.thyu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("login")
	public String toLogin(Model model){
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping("loginUser")
	public String login(@Validated @ModelAttribute("user")User user,BindingResult result,HttpSession session,Model model){
		if(result.hasFieldErrors()){
			return "login";
		}
		User successUser = userService.login(user);
		if(successUser==null){
			model.addAttribute("errorMessage", "用户名或密码错误!");
			return "login";
		}
		session.setAttribute("user", successUser);
		return "redirect:house/list";
	}
}
