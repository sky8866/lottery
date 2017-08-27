package com.sky.apps.action.lottery.web.guilv;
 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.service.user.MemberManager;
 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 

@Controller

public class LimitController    extends LogController{
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	@RequestMapping(value = "/system/yexuan/limit")
	public String word(HttpServletRequest request) {
		 
		 
			String code = request.getParameter("code");
			 StringBuffer sb=new StringBuffer();
			String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  }
	  			log(sb.toString(), request.getRequestURI(), "qxc_limit");
		return BASE_PATH + "limit";
	}
	
	@RequestMapping(value = "/admin/guilv/limit")
	public String web_limit(HttpServletRequest request) {
		request.setAttribute("limit_active", "active");  
		request.setAttribute("openid", this.memberManager.getOpenId());  
		 
		return BASE_PATH + "limit";
	}
}
