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
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller

public class XjsscPlanController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	@Autowired
	private CqsscLotteryService lotteryService;
	@RequestMapping(value = "/system/guilv/kill33")
	public String home(HttpServletRequest request){ 
		 
		String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,0,sb);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }
		   
		 /*  PageView<Lottery2> pageView = new PageView<Lottery2>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Lottery2> lotteries = pageView.getRecords();
			request.setAttribute("lottery2s", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);*/
			return BASE_PATH + "kill3";
		 
		
	}
	
	@RequestMapping(value = "/system/guilv/xjPlan")
	public String home2(HttpServletRequest request){ 
		 
	/*	String code = request.getParameter("code");
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,0);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }*/
		   
		 /*  PageView<Lottery2> pageView = new PageView<Lottery2>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Lottery2> lotteries = pageView.getRecords();
			request.setAttribute("lottery2s", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);*/
			return BASE_PATH + "kill3";
		 
		
	}
	

	
	@RequestMapping(value = "/admin/guilv/kill32")
	public String web_home(HttpServletRequest request){ 
		  
		request.setAttribute("peer_active", "active"); 
			return BASE_PATH + "kill3";
		 
		
	}
	
 
	
	
	 
}
