package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.sky.apps.action.lottery.web.utils.guilv.CqsscGuilvUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqsscGuilvKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqsscLimitUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.SumCountUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqsscGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqsscGuilvKill;
import com.sky.apps.action.lottery.web.vo.guilv.GuilvVo;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.CqPlan;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvKill;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvOld; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDouble;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.CqPlanService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvKillService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvOLdService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService; 
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
import com.sky.modules.lottery.service.user.MemberManager;

 

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class CqsscPlanAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired private CqsscGuilvLimitService limit3Service;
 
	@Autowired private MemberManager memberManager;
	@Autowired
	private CqsscLotteryService lotteryService;
  
     @Autowired private CqsscPlanService planService;
	 
     @Autowired private CqPlanService cqPlanService;
	 
	@RequestMapping(value = "kill2")
	public String query(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "3") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "1") int number,
			@RequestParam(value = "qi", defaultValue = "0") int qi,
			String openId,
			HttpServletRequest request) {
	
		
		 
 
		
		
	   if(type==0){
		   
			PageView<CqPlan> pageViewGuilv1 = new PageView<CqPlan>(10,1);
			   pageViewGuilv1.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses1 = new ArrayList<PropertyFilter>();
				filtersnewses1.add(new PropertyFilter("type", MatchType.EQ, 1));
		 
				pageViewGuilv1.setQueryResult(cqPlanService.findList(pageViewGuilv1, filtersnewses1));
				List<CqPlan> guilvs1 = pageViewGuilv1.getRecords();
			 
				request.setAttribute("sbr1", guilvs1);	
			 
				PageView<CqPlan> pageViewGuilv2 = new PageView<CqPlan>(10,1);
				   pageViewGuilv2.setOrderby("id", "desc");
					List<PropertyFilter> filtersnewses2 = new ArrayList<PropertyFilter>();
					filtersnewses2.add(new PropertyFilter("type", MatchType.EQ,2));
			 
					pageViewGuilv2.setQueryResult(cqPlanService.findList(pageViewGuilv2, filtersnewses2));
					List<CqPlan> guilvs2 = pageViewGuilv2.getRecords();
				 
					request.setAttribute("sbr2", guilvs2);	
					
					PageView<CqPlan> pageViewGuilv3 = new PageView<CqPlan>(10,1);
					   pageViewGuilv3.setOrderby("id", "desc");
						List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
						filtersnewses3.add(new PropertyFilter("type", MatchType.EQ,3));
				 
						pageViewGuilv3.setQueryResult(cqPlanService.findList(pageViewGuilv3, filtersnewses3));
						List<CqPlan> guilvs3 = pageViewGuilv3.getRecords();
					 
						request.setAttribute("sbr3", guilvs3); 
					
					
		   return BASE_PATH + "query_plan6";
	   }else if (type==1) {
			
			PageView<CqPlan> pageViewGuilv1 = new PageView<CqPlan>(10,1);
			   pageViewGuilv1.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses1 = new ArrayList<PropertyFilter>();
				filtersnewses1.add(new PropertyFilter("type", MatchType.EQ,9));
		 
				pageViewGuilv1.setQueryResult(cqPlanService.findList(pageViewGuilv1, filtersnewses1));
				List<CqPlan> guilvs1 = pageViewGuilv1.getRecords();
			 
				request.setAttribute("sbr10", guilvs1);
				
				PageView<CqPlan> pageViewGuilv2 = new PageView<CqPlan>(10,1);
				   pageViewGuilv2.setOrderby("id", "desc");
					List<PropertyFilter> filtersnewses2 = new ArrayList<PropertyFilter>();
					filtersnewses2.add(new PropertyFilter("type", MatchType.EQ,10));
			 
					pageViewGuilv2.setQueryResult(cqPlanService.findList(pageViewGuilv2, filtersnewses2));
					List<CqPlan> guilvs2 = pageViewGuilv2.getRecords();
				 
					request.setAttribute("sbr11", guilvs2);
				
				
	   return BASE_PATH + "query_plan7";
	}else if (type==2) {
		
		 
		
		PageView<CqsscPlan> pageViewGuilv10 = new PageView<CqsscPlan>(200,1);
		   pageViewGuilv10.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
			filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 12));
			filtersnewses10.add(new PropertyFilter("type3", MatchType.EQ, 0));
			pageViewGuilv10.setQueryResult(planService.findList(pageViewGuilv10,
					filtersnewses10));
			List<CqsscPlan> guilvs12 = pageViewGuilv10.getRecords();
		   
		   
			request.setAttribute("sbr12", guilvs12);
			
			if(!guilvs12.isEmpty()){
				request.setAttribute("plan12", guilvs12.get(0));	
			}
	
			PageView<CqsscPlan> pageViewGuilv11 = new PageView<CqsscPlan>(200,1);
			   pageViewGuilv11.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
				filtersnewses11.add(new PropertyFilter("type", MatchType.EQ, 13));
				filtersnewses11.add(new PropertyFilter("type3", MatchType.EQ, 0));
				pageViewGuilv11.setQueryResult(planService.findList(pageViewGuilv11,
						filtersnewses11));
				List<CqsscPlan> guilvs11 = pageViewGuilv11.getRecords();
			   
			   
				request.setAttribute("sbr13", guilvs11);
				
				if(!guilvs11.isEmpty()){
					request.setAttribute("plan13", guilvs11.get(0));	
				}

return BASE_PATH + "query_plan8";
}else if (type==3) {
	 
		List<CqsscGuilvLimit> guilvs = getLimits(0, 80);
		request.setAttribute("limits", guilvs);
		List<CqsscGuilvLimit> guilvs2 = getLimits(80, 100);
		request.setAttribute("limits2", guilvs2);
		List<CqsscGuilvLimit> guilvs3 = getLimits(100, 115);
		request.setAttribute("limits3", guilvs3);
		List<CqsscGuilvLimit> guilvs4 = getLimits(115, 165);
		request.setAttribute("limits4", guilvs4);
		List<CqsscGuilvLimit> guilvs5 = getLimits(165, 190);
		request.setAttribute("limits5", guilvs5);
return BASE_PATH + "query_plan9";
}else if (type==8) {
	
	 
	
	PageView<CqsscPlan> pageViewGuilv10 = new PageView<CqsscPlan>(10,1);
	   pageViewGuilv10.setOrderby("id", "desc");
		List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
		filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 16));
	/*	filtersnewses10.add(new PropertyFilter("type3", MatchType.EQ, 0));*/
		pageViewGuilv10.setQueryResult(planService.findList(pageViewGuilv10,
				filtersnewses10));
		List<CqsscPlan> guilvs10 = pageViewGuilv10.getRecords();
	   
	   
		request.setAttribute("sbr10", guilvs10);
		
		if(!guilvs10.isEmpty()){
			request.setAttribute("plan10", guilvs10.get(0));	
		}

		PageView<CqsscPlan> pageViewGuilv11 = new PageView<CqsscPlan>(10,1);
		   pageViewGuilv11.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
			filtersnewses11.add(new PropertyFilter("type", MatchType.EQ, 17)); 
			pageViewGuilv11.setQueryResult(planService.findList(pageViewGuilv11,
					filtersnewses11));
			List<CqsscPlan> guilvs11 = pageViewGuilv11.getRecords();
		   
		   
			request.setAttribute("sbr11", guilvs11);
			
			if(!guilvs11.isEmpty()){
				request.setAttribute("plan11", guilvs11.get(0));	
			}
		


return BASE_PATH + "query_plan20";
}else if (type==6) {
	
	 
 
		PageView<CqPlan> pageViewGuilv10 = new PageView<CqPlan>(10,1);
		   pageViewGuilv10.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
			filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 11));
	 
			pageViewGuilv10.setQueryResult(cqPlanService.findList(pageViewGuilv10, filtersnewses10));
			List<CqPlan> guilvs10 = pageViewGuilv10.getRecords();
		 
			request.setAttribute("sbr11", guilvs10);	
 

		
		
		


return BASE_PATH + "query_plan21";
}else{
	PageView<CqPlan> pageViewGuilv10 = new PageView<CqPlan>(10,1);
	   pageViewGuilv10.setOrderby("id", "desc");
		List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
		filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 11));

		pageViewGuilv10.setQueryResult(cqPlanService.findList(pageViewGuilv10, filtersnewses10));
		List<CqPlan> guilvs10 = pageViewGuilv10.getRecords();
	 
		request.setAttribute("sbr2", guilvs10);
		   return BASE_PATH + "query_plan";
	   }
		
		 

		
		
	}

	 
	
	
	@RequestMapping(value = "kill6")
	public String query6(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "3") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "1") int number,
			@RequestParam(value = "qi", defaultValue = "0") int qi,
			String openId,
			HttpServletRequest request) {
	
		
		PageView<CqsscPlan> pageViewGuilv10 = new PageView<CqsscPlan>(200,1);
		   pageViewGuilv10.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
			filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 12));
			pageViewGuilv10.setQueryResult(planService.findList(pageViewGuilv10,
					filtersnewses10));
			List<CqsscPlan> guilvs12 = pageViewGuilv10.getRecords();
		   
		   
			request.setAttribute("sbr12", guilvs12);
			
			if(!guilvs12.isEmpty()){
				request.setAttribute("plan12", guilvs12.get(0));	
			}
	
			PageView<CqsscPlan> pageViewGuilv11 = new PageView<CqsscPlan>(200,1);
			   pageViewGuilv11.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
				filtersnewses11.add(new PropertyFilter("type", MatchType.EQ, 13));
				pageViewGuilv11.setQueryResult(planService.findList(pageViewGuilv11,
						filtersnewses11));
				List<CqsscPlan> guilvs11 = pageViewGuilv11.getRecords();
			   
			   
				request.setAttribute("sbr13", guilvs11);
				
				if(!guilvs11.isEmpty()){
					request.setAttribute("plan13", guilvs11.get(0));	
				}

return BASE_PATH + "query_plan8";
		
		 

		
		
	}
	
	
	private List<CqsscGuilvLimit> getLimits(int t1,int t2){
		PageView<CqsscLottery> pageView = new PageView<CqsscLottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
	   
		List<CqsscLottery> lotteries = pageView.getRecords();
		for(int t=t1;t<t2;t++){
			int e1=0;
				 int temp=0;
				int e2=0;int e3=0;int e4=0;
			for(CqsscLottery lotterie:lotteries){
			
				boolean flag= CqsscLimitUtils.getQuery( lotterie, t);	
				
				if(flag){
					
					if(e4==0){
						e3=e2;
						e4=1;
					}
					if(temp<e1){
						temp=e1;
					}
					e1=0;
				}else{
					e1++;
					e2++;
					
				}
			}
			
			CqsscGuilvLimit limit3=this.limit3Service.findGuilv("type", t);
			if(limit3==null){
				limit3=new CqsscGuilvLimit();
				limit3.setMinSum(temp);
				limit3.setNum(e3);
				limit3.setType(t);
				this.limit3Service.saveGuilv(limit3);
				
			}else{
				limit3.setMinSum(temp);
				limit3.setNum(e3);
				limit3.setType(t);
				this.limit3Service.updateGuilv(limit3);
			}
		}
		
		 PageView<CqsscGuilvLimit> pageViewGuilv = new PageView<CqsscGuilvLimit>();
		   pageViewGuilv.setOrderby("num", "desc");
			List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
			filtersnewses11.add(new PropertyFilter("num", MatchType.GE, 7));
			filtersnewses11.add(new PropertyFilter("type", MatchType.GE, t1));
			filtersnewses11.add(new PropertyFilter("type", MatchType.LT, t2));
			
			pageViewGuilv.setQueryResult(this.limit3Service.findList(pageViewGuilv,
					filtersnewses11));
			List<CqsscGuilvLimit> guilvs = pageViewGuilv.getRecords();
			return guilvs;
	}
}
