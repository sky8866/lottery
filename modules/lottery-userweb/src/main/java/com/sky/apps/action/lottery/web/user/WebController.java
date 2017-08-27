package com.sky.apps.action.lottery.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 修改个人资料
 * sky
 */
@Controller
@RequestMapping(value = "/paodanci/ajax")
public class WebController {

	@RequestMapping(value = "login")
	public String login(){ 
		return "login";
	}
	
	@RequestMapping(value = "reg")
	public String reg(){
		 
		return "reg";
	}
	@RequestMapping(value = "lossPassword")
	public String lossPassword(){
		return "lossPassword";
	}
	@RequestMapping(value = "resetPassword")
	public String resetPassword(){
		return "resetPassword";
	}
}
