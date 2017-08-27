package com.sky.apps.action.lottery.web.guilv;

 
  
 
import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
 
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.entity.guilv.Lottery; 
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService;
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller

public class Pl5PlanController extends LogController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
 
	@RequestMapping(value = "/system/yexuan/pl5/plan")
	public String home(HttpServletRequest request){ 
		 
		 
		  String code = request.getParameter("code"); 
		  StringBuffer sb=new StringBuffer();
			 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,0,sb);;
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  }
	  		 log(sb.toString(), request.getRequestURI(), "pl5_plan");	 
	 
			return BASE_PATH + "pl5_plan";
		 
		
	}

	
 
	
	
	 
}
