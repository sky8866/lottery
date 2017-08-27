package com.sky.apps.action.lottery.web.guilv;
 

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.LotteryService;
import com.sky.modules.lottery.service.user.MemberManager;
 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 

@Controller
 
public class GuilvAllRightController extends LogController{
	  
	private final static String BASE_PATH = "guilv/"; 

	@Autowired
	private LotteryService lotteryService;
	@Autowired private MemberManager memberManager;
	@RequestMapping(value = "/system/yexuan/limit2")
	public String word(HttpServletRequest request) {
		 
		 
			String code = request.getParameter("code");
			 StringBuffer sb=new StringBuffer();
			 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  }
	  			PageView<Lottery> pageView = new PageView<Lottery>(5,1);
	  			pageView.setOrderby("id", "desc");

	  			pageView.setQueryResult(lotteryService.findList(pageView, null));
	  			List<Lottery> lotteries = pageView.getRecords();
	  			request.setAttribute("lotterys", lotteries);
	  			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
	  			
	  		   log(sb.toString(), request.getRequestURI(), "qxc_allRight");	
		return BASE_PATH + "limit_2";
	}
	
	@RequestMapping(value = "/admin/guilv/limit2")
	public String web_limit2(HttpServletRequest request) {
		request.setAttribute("limit2_active", "active"); 
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		PageView<Lottery> pageView = new PageView<Lottery>(5,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Lottery> lotteries = pageView.getRecords();
			request.setAttribute("lotterys", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
		return BASE_PATH + "limit_2";
	}
}
