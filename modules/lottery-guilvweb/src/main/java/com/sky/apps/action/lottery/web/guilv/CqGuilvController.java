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
import com.sky.modules.lottery.entity.guilv.CqsscLottery;  
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.CqGuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.CqGuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvSameOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller

public class CqGuilvController extends LogController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	 
@Autowired  CqGuilvPeerOldService peerService;
	
	@Autowired CqGuilvPeer3OldService peer3Service;
	@Autowired CqGuilvSingleDoubleOldService gDoubleOLdService;
	@Autowired
	private CqsscLotteryService lotteryService;  
	@Autowired CqGuilvSameOldService sameOldService; 
	
	
	
	@RequestMapping(value = "/system/yexuan/cq/sum_error")
	public String sum_error(HttpServletRequest request,HttpServletResponse response) {
		 
	  String code = request.getParameter("code"); 
	  StringBuffer sb=new StringBuffer();
	  String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
  		   if(StringUtils.isNotEmpty(isvip)){
  			return isvip;
  		  }   
	      
  		 
 			PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
 			pageView.setOrderby("qi", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<CqsscLottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
 			  log(sb.toString(), request.getRequestURI(), "cq_sum_error");
	      
		return BASE_PATH + "cq_guilv_sum";
	}
	
	@RequestMapping(value = "/system/cq/sum_error")
	public String sum_error2(HttpServletRequest request,HttpServletResponse response) {
		 
	  String code = request.getParameter("code"); 
	  StringBuffer sb=new StringBuffer();
	/*  String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
  		   if(StringUtils.isNotEmpty(isvip)){
  			return isvip;
  		  } */  
	      
  		 
 			PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
 			pageView.setOrderby("qi", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<CqsscLottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
 			  log(sb.toString(), request.getRequestURI(), "cq_sum_error");
	      
		return BASE_PATH + "cq_guilv_sum";
	}
	

	@RequestMapping(value = "/admin/guilv/cq/sum_error")
	public String web_sum_error(HttpServletRequest request,HttpServletResponse response) {
		 
		request.setAttribute("cq_sum_error", "active");
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	    
 			PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
 			pageView.setOrderby("qi", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<CqsscLottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
		return BASE_PATH + "cq_guilv_sum";
	}
	
	
	@RequestMapping(value = "/system/yexuan/cq/sum_error2")
	public String web_sum_error2(HttpServletRequest request,HttpServletResponse response) {
		 
	 	String code = request.getParameter("code"); 
	 	StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
 		   if(StringUtils.isNotEmpty(isvip)){
 			return isvip;
 		  } 
	    
			PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<CqsscLottery> lotteries = pageView.getRecords();
			request.setAttribute("lotterys", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
			 log(sb.toString(), request.getRequestURI(), "cq_sum_error2");
		return BASE_PATH + "cq_guilv_sum2";
	}
	@RequestMapping(value = "/system/yexuan/cq/singleDouble")
	public String singleDouble(HttpServletRequest request,HttpServletResponse response) {
		 
	 String code = request.getParameter("code");
	 StringBuffer sb=new StringBuffer();
	
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
 		   if(StringUtils.isNotEmpty(isvip)){
 			return isvip;
 		  } 
	    
			PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
			pageView.setOrderby("qi", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<CqsscLottery> lotteries = pageView.getRecords();
			request.setAttribute("lotterys", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
			 log(sb.toString(), request.getRequestURI(), "cq_singleDouble");	 
		return BASE_PATH + "cq_singleDouble";
	}
	
}
