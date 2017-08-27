package com.sky.apps.action.lottery.web.user;
 
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.user.UserInfo;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
import com.sky.modules.lottery.web.WebMessage;
 
 


/**
 * 修改个人资料
 * sky
 */
@Controller
@RequestMapping(value = "/admin")
public class SystemIndexController { 
	@Autowired private MemberManager memberManager;
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request){ 
		 
		request.setAttribute("openid", this.memberManager.getOpenId());
		request.setAttribute("index_active", "active");
			return "home";
		 
		
	}
	
	 
 
}
