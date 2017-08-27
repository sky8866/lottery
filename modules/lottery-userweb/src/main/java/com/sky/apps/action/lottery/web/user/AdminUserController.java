package com.sky.apps.action.lottery.web.user;

 

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam; 
import com.sky.modules.core.bean.Maxresult;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.lottery.entity.user.User; 
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.service.user.UserVipService;  


@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController {
	  
	private final static String BASE_PATH = "user/"; 
	@Autowired private MemberManager memberManager;
	
	@Autowired private UserVipService vipService;
	@RequestMapping(value = "")
	
	public String word(HttpServletRequest request) {
		 request.setAttribute("user_active", "active");
		return BASE_PATH+"home";
	}
 
}
