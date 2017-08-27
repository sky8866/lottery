package com.sky.apps.action.lottery.web.guilv;

 
  
  
import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
  
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils;      
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSum;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSumService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller

public class Pl5GuilvController  extends LogController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	 
@Autowired  Pl5GuilvPeerOldService peerService;
	
	@Autowired Pl5GuilvPeer3OldService peer3Service;
	@Autowired Pl5GuilvSingleDoubleOldService gDoubleOLdService;
	@Autowired
	private Pl5LotteryService lotteryService;  
	@Autowired Pl5GuilvSameOldService sameOldService;
	 
 @Autowired Pl5GuilvSumService guilvSumService;
	
	
	
	@RequestMapping(value = "/system/yexuan/pl5/sum_error")
	public String sum_error(HttpServletRequest request,HttpServletResponse response) {
		 
		String code = request.getParameter("code"); 
		 StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
  		   if(StringUtils.isNotEmpty(isvip)){
  			return isvip;
  		  } 
	    
 			PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>(10,1);
 			pageView.setOrderby("id", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<Pl5Lottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
	
 			log(sb.toString(), request.getRequestURI(), "pl5_sum_error");
		return BASE_PATH + "pl5_guilv_sum";
	}

	@RequestMapping(value = "/admin/guilv/pl5/sum_error")
	public String web_sum_error(HttpServletRequest request,HttpServletResponse response) {
		 
		request.setAttribute("pl5_sum_error", "active");
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	    
 			PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>(10,1);
 			pageView.setOrderby("id", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<Pl5Lottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
		return BASE_PATH + "pl5_guilv_sum";
	}
	
	
	@RequestMapping(value = "/system/yexuan/pl5/sum_error2")
	public String web_sum_error2(HttpServletRequest request,HttpServletResponse response) {
		 
		String code = request.getParameter("code"); 
		 StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);;
 		   if(StringUtils.isNotEmpty(isvip)){
 			return isvip;
 		  }
	    
			PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Pl5Lottery> lotteries = pageView.getRecords();
			request.setAttribute("lotterys", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
			log(sb.toString(), request.getRequestURI(), "pl5_sum_error2");
		return BASE_PATH + "pl5_guilv_sum2";
	}
	
	
}
