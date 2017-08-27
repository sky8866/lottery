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

public class GuilvKillController   extends LogController{
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	@Autowired
	private CqsscLotteryService lotteryService;
	@RequestMapping(value = "/system/yexuan/kill")
	public String home(HttpServletRequest request){ 
		 
		String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }
		   log(sb.toString(), request.getRequestURI(), "qxc_kill");  
		 /*  PageView<Lottery2> pageView = new PageView<Lottery2>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Lottery2> lotteries = pageView.getRecords();
			request.setAttribute("lottery2s", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);*/
			return BASE_PATH + "kill";
		 
		
	}
	
	@RequestMapping(value = "/system/yexuan/kill12")
	public String home2(HttpServletRequest request){ 
		String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }
		   log(sb.toString(), request.getRequestURI(), "qxc_kill2");  
			return BASE_PATH + "kill";
		 
		
	}
	
	
	@RequestMapping(value = "/admin/guilv/kill")
	public String web_home(HttpServletRequest request){ 
		  
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		request.setAttribute("kill_active", "active");
		
		 PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<CqsscLottery> lotteries = pageView.getRecords();
			request.setAttribute("lottery2s", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
			return BASE_PATH + "kill";
		 
		
	}
	
	
	 
}
