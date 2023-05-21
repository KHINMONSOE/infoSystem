package com.info.controller;

import com.info.entity.User;
import com.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //注入userServics
    @Autowired
    UserService userService;

	
	  @RequestMapping("/") 
	  public String show() {
	  
	  return "login";
	  
	  }
	 

	/* @RequestMapping(value = "/loginIn", method = RequestMethod.POST) */
    @RequestMapping("/loginIn")
    public String loginIn(String userid, String password, Model model) {
      
      User userAdmin = userService.loginIn(userid, password);
        if (userAdmin != null) {
            // 登录验证成功，返回成功页面
            return "success";
        } else {
            // 登录验证失败，设置错误信息并返回登录页面
            if (userService.findByUserId(userid) == null) {
                model.addAttribute("erroruserid", "管理者IDが間違っています。"); // 设置用户ID错误信息
            } else {
                model.addAttribute("errorpassword", "パスワードが間違っています。"); // 设置密码错误信息
            }
            return "login";
        }
     }
    }

   



