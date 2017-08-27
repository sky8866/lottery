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

public class QxcPlanController  extends LogController  {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
 
	@RequestMapping(value = "/system/yexuan/qxc/plan")
	public String home(HttpServletRequest request){ 
		 
		String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	 
 		   if(StringUtils.isNotEmpty(isvip)){
 			return isvip;
 		  } 
 		  log(sb.toString(), request.getRequestURI(), "qxc_plan");
	 
			return BASE_PATH + "qxc_plan";
		 
		
	}

	@RequestMapping(value = "/admin/qxc/plan")
	public String web_limit2(HttpServletRequest request) {
		request.setAttribute("push_active", "active");  
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	 
		
		
		
		return BASE_PATH + "qxc_plan";
	}
 
	
	
	 
}
