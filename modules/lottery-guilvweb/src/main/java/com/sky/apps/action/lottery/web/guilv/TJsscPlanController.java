package com.sky.apps.action.lottery.web.guilv;

 
   

import javax.servlet.http.HttpServletRequest;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.sky.modules.core.utils.StringUtils;  
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller
public class TJsscPlanController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
 
 
	@RequestMapping(value = "/system/guilv/tjPlan")
	public String home5(HttpServletRequest request){ 
		 
		 String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,0,sb);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  } 

			return BASE_PATH + "kill7";
		 
		
	}
	

	
	@RequestMapping(value = "/admin/guilv/tjPlan2")
	public String web_home6(HttpServletRequest request){ 
		  
		request.setAttribute("peer_active", "active"); 
			return BASE_PATH + "kill7";
		 
		
	}
	
 
	
	
	 
}
