package com.sky.apps.action.lottery.web.guilv;

 
  
  
import java.util.List;

import javax.servlet.http.HttpServletRequest;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils;   
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.service.guilv.CqsscGuilvKillService; 
import com.sky.modules.lottery.service.guilv.GuilvLimit6Service;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService; 
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller

public class CqsscPlanController extends LogController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	@Autowired
	private CqsscLotteryService lotteryService;
	 
 
	@RequestMapping(value = "/system/guilv/kill2")
	public String home(HttpServletRequest request){ 
		
		 
		/* try{
				String code = request.getParameter("code");
				 
				String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,0);
				   if(StringUtils.isNotEmpty(isvip)){
					return isvip;
				  } 
		 }catch (Exception e) {
			 return "error/info2";
		}*/
	
		   
		 /*  PageView<Lottery2> pageView = new PageView<Lottery2>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Lottery2> lotteries = pageView.getRecords();
			request.setAttribute("lottery2s", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);*/
		log(null, request.getRequestURI(), "share_plan");
			return BASE_PATH + "kill2";
		 
		
	}
	
	@RequestMapping(value = "/system/yexuan/ssc/plan")
	public String home2(HttpServletRequest request){
	/*	PageView<GuilvLimit6> pageView = new PageView<GuilvLimit6>();
		
		List<GuilvLimit6> limit6s=this.limit3Service.findList(pageView, null).getResultlist();
		int count=0;
		for(GuilvLimit6 limit6:limit6s){
			
			limit6.setNum(0);
			limit6.setMinSum(0);
			limit6.setType(count++);
			this.limit3Service.updateGuilv(limit6);
		}*/
		
		/* PageView<GuilvKill2> pageView = new PageView<GuilvKill2>();
			pageView.setOrderby("id", "desc");
			List<PropertyFilter> filter = new ArrayList<PropertyFilter>();
			filter.add(new PropertyFilter("addition", MatchType.EQ, 2));
			filter.add(new PropertyFilter("number", MatchType.EQ, 3));
			filter.add(new PropertyFilter("sum", MatchType.GE, 7));
			pageView.setQueryResult(this.guilv2Service.findList(pageView, filter));
			List<GuilvKill2> kill2s = pageView.getRecords();
			int count=0;
			for(GuilvKill2 k:kill2s){ 
				if(k.getSum()>7){
					System.out.println(k.getSum());
					count++;;
				}
			}
			System.out.println("总："+kill2s.size());
			System.out.println("大于："+count);  */
		
		 
		  String code = request.getParameter("code"); 
		  StringBuffer sb=new StringBuffer();
			 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  }
	  		 log(sb.toString(), request.getRequestURI(), "cq_plan");
			return BASE_PATH + "kill2";
		 
		
	}
	
	@RequestMapping(value = "/system/yexuan/sscPlan")
	public String home3(HttpServletRequest request){
	 
		/*
		String code = request.getParameter("code");
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,0);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }*/
		log(null, request.getRequestURI(), "share_plan");
			return BASE_PATH + "kill2";
		 
		
	}
	
	@RequestMapping(value = "/system/guilv/kill26")
	public String home6(HttpServletRequest request){ 
		 
		 
			return BASE_PATH + "kill6";
		 
		
	}
	
	
	@RequestMapping(value = "/admin/guilv/kill2")
	public String web_home(HttpServletRequest request){ 
		  
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		request.setAttribute("peer_active", "active"); 
		
		 PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<CqsscLottery> lotteries = pageView.getRecords();
			request.setAttribute("lottery2s", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
			return BASE_PATH + "kill2";
		 
		
	}
	
	
	 
}
