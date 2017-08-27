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
 
import com.sky.apps.action.lottery.web.utils.guilv.CqsscGuilvKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqsscGuilvKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqsscLimitUtils;
import com.sky.apps.action.lottery.web.utils.guilv.XjsscLimitUtils;
import com.sky.apps.action.lottery.web.utils.guilv.XjsscLimitUtils;
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
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvKill;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvLimit;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvLimit;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvOld; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDouble;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.guilv.XjsscPlan;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.CqsscGuilvKillService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.XjsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.XjsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvOLdService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService; 
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleService;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.XjsscPlanService;
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
import com.sky.modules.lottery.service.user.MemberManager;

 

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class XjsscPlanAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired private XjsscGuilvLimitService limit3Service;
 
	@Autowired private MemberManager memberManager;
	@Autowired
	private XjsscLotteryService lotteryService;
  
     @Autowired private XjsscPlanService planService;
	 
	 
	@RequestMapping(value = "kill32")
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
	
		
		 
		 
		 
		
		
	/*	PageView<Plan> pageView = new PageView<Plan>();
		   pageView.setOrderby("id", "desc");
			List<PropertyFilter> filter = new ArrayList<PropertyFilter>();
			filter.add(new PropertyFilter("qi", MatchType.NE, 113035));
			pageView.setQueryResult(planService.findList(pageView,
					filter));
			List<Plan> guilvsQ = pageView.getRecords();
		System.out.println("efdfd:"+guilvsQ);
			for(Plan plan:guilvsQ){
				this.planService.delPlan(plan.getId());
			}*/
		
		
		
	   if(type==0){
		   
		  
				
				PageView<XjsscPlan> pageViewGuilv3 = new PageView<XjsscPlan>(10,1);
				   pageViewGuilv3.setOrderby("id", "desc");
					List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
					filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, 6));
					pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
							filtersnewses3));
					List<XjsscPlan> guilvs3 = pageViewGuilv3.getRecords();
				   
				   
					request.setAttribute("sbr3", guilvs3);
					
					if(!guilvs3.isEmpty()){
						request.setAttribute("plan3", guilvs3.get(0));	
					}
					
					PageView<XjsscPlan> pageViewGuilv7 = new PageView<XjsscPlan>(10,1);
					   pageViewGuilv7.setOrderby("id", "desc");
						List<PropertyFilter> filtersnewses7 = new ArrayList<PropertyFilter>();
						filtersnewses7.add(new PropertyFilter("type", MatchType.EQ, 7));
						filtersnewses7.add(new PropertyFilter("type3", MatchType.EQ, 0));
						pageViewGuilv7.setQueryResult(planService.findList(pageViewGuilv7,
								filtersnewses7));
						List<XjsscPlan> guilvs7 = pageViewGuilv7.getRecords();
					   
					   
						request.setAttribute("sbr7", guilvs7);
						
						if(!guilvs7.isEmpty()){
							request.setAttribute("plan7", guilvs7.get(0));	
						}
						
						
						PageView<XjsscPlan> pageViewGuilv8 = new PageView<XjsscPlan>(10,1);
						   pageViewGuilv8.setOrderby("id", "desc");
							List<PropertyFilter> filtersnewses8 = new ArrayList<PropertyFilter>();
							filtersnewses8.add(new PropertyFilter("type", MatchType.EQ, 8));
							filtersnewses8.add(new PropertyFilter("type3", MatchType.EQ, 0));
							pageViewGuilv8.setQueryResult(planService.findList(pageViewGuilv8,
									filtersnewses8));
							List<XjsscPlan> guilvs8 = pageViewGuilv8.getRecords();
						   
						   
							request.setAttribute("sbr8", guilvs8);
							
							if(!guilvs8.isEmpty()){
								request.setAttribute("plan8", guilvs8.get(0));	
							}
							
							PageView<XjsscPlan> pageViewGuilv9 = new PageView<XjsscPlan>(10,1);
							   pageViewGuilv9.setOrderby("id", "desc");
								List<PropertyFilter> filtersnewses9 = new ArrayList<PropertyFilter>();
								filtersnewses9.add(new PropertyFilter("type", MatchType.EQ, 9));
								filtersnewses9.add(new PropertyFilter("type3", MatchType.EQ, 0));
								pageViewGuilv9.setQueryResult(planService.findList(pageViewGuilv9,
										filtersnewses9));
								List<XjsscPlan> guilvs9 = pageViewGuilv9.getRecords();
							   
							   
								request.setAttribute("sbr9", guilvs9);
								
								if(!guilvs9.isEmpty()){
									request.setAttribute("plan9", guilvs9.get(0));	
								}
						
					
					
		   return BASE_PATH + "query_plan16";
	   }else if (type==1) {
			
		 
						
						PageView<XjsscPlan> pageViewGuilv10 = new PageView<XjsscPlan>(10,1);
						   pageViewGuilv10.setOrderby("id", "desc");
							List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
							filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 10));
							filtersnewses10.add(new PropertyFilter("type3", MatchType.EQ, 0));
							pageViewGuilv10.setQueryResult(planService.findList(pageViewGuilv10,
									filtersnewses10));
							List<XjsscPlan> guilvs10 = pageViewGuilv10.getRecords();
						   
						   
							request.setAttribute("sbr10", guilvs10);
							
							if(!guilvs10.isEmpty()){
								request.setAttribute("plan10", guilvs10.get(0));	
							}
					
							PageView<XjsscPlan> pageViewGuilv11 = new PageView<XjsscPlan>(10,1);
							   pageViewGuilv11.setOrderby("id", "desc");
								List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
								filtersnewses11.add(new PropertyFilter("type", MatchType.EQ, 11));
								filtersnewses11.add(new PropertyFilter("type3", MatchType.EQ, 0));
								pageViewGuilv11.setQueryResult(planService.findList(pageViewGuilv11,
										filtersnewses11));
								List<XjsscPlan> guilvs11 = pageViewGuilv11.getRecords();
							   
							   
								request.setAttribute("sbr11", guilvs11);
								
								if(!guilvs11.isEmpty()){
									request.setAttribute("plan11", guilvs11.get(0));	
								}
							
				
				
	   return BASE_PATH + "query_plan17";
	}else if (type==2) {
		
		 
		
		 

return BASE_PATH + "query_plan8";
}else if (type==3) {
	List<XjsscGuilvLimit> guilvs = getLimits(0, 80);
	request.setAttribute("limits", guilvs);
	List<XjsscGuilvLimit> guilvs2 = getLimits(80, 100);
	request.setAttribute("limits2", guilvs2);
	List<XjsscGuilvLimit> guilvs3 = getLimits(100, 115);
	request.setAttribute("limits3", guilvs3);
	List<XjsscGuilvLimit> guilvs4 = getLimits(115, 165);
	request.setAttribute("limits4", guilvs4);
	List<XjsscGuilvLimit> guilvs5 = getLimits(165, 190);
	request.setAttribute("limits5", guilvs5);
return BASE_PATH + "query_plan9";
}else{
		   PageView<XjsscPlan> pageViewGuilv = new PageView<XjsscPlan>(10,1);
		   pageViewGuilv.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			filtersnewses.add(new PropertyFilter("type", MatchType.EQ, 1));
			filtersnewses.add(new PropertyFilter("type3", MatchType.EQ, 0));
			pageViewGuilv.setQueryResult(planService.findList(pageViewGuilv,
					filtersnewses));
			List<XjsscPlan> guilvs = pageViewGuilv.getRecords();
		   
		   
			request.setAttribute("sbr", guilvs);
			if(!guilvs.isEmpty()){
				request.setAttribute("plan", guilvs.get(0));
			}
		
			
			PageView<XjsscPlan> pageViewGuilv2 = new PageView<XjsscPlan>(10,1);
			   pageViewGuilv2.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses2 = new ArrayList<PropertyFilter>();
				filtersnewses2.add(new PropertyFilter("type", MatchType.EQ, 15));
				filtersnewses2.add(new PropertyFilter("type3", MatchType.EQ, 0));
				pageViewGuilv2.setQueryResult(planService.findList(pageViewGuilv2,
						filtersnewses2));
				List<XjsscPlan> guilvs2 = pageViewGuilv2.getRecords();
			   
			   
				request.setAttribute("sbr2", guilvs2);
				if(!guilvs2.isEmpty()){
					request.setAttribute("plan2", guilvs2.get(0));
				}
				
				
				PageView<XjsscPlan> pageViewGuilv3 = new PageView<XjsscPlan>(10,1);
				   pageViewGuilv3.setOrderby("id", "desc");
					List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
					filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, 5));
					filtersnewses3.add(new PropertyFilter("type3", MatchType.EQ, 0));
					pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
							filtersnewses3));
					List<XjsscPlan> guilvs3 = pageViewGuilv3.getRecords();
				   
				   
					request.setAttribute("sbr3", guilvs3);
					
					if(!guilvs3.isEmpty()){
						request.setAttribute("plan3", guilvs3.get(0));	
					}
		   return BASE_PATH + "query_plan10";
	   }
		
		 

		
		
	}

	 
	
	
	@RequestMapping(value = "kill36")
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
	
		
		PageView<XjsscPlan> pageViewGuilv10 = new PageView<XjsscPlan>(200,1);
		   pageViewGuilv10.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses10 = new ArrayList<PropertyFilter>();
			filtersnewses10.add(new PropertyFilter("type", MatchType.EQ, 12));
			pageViewGuilv10.setQueryResult(planService.findList(pageViewGuilv10,
					filtersnewses10));
			List<XjsscPlan> guilvs12 = pageViewGuilv10.getRecords();
		   
		   
			request.setAttribute("sbr12", guilvs12);
			
			if(!guilvs12.isEmpty()){
				request.setAttribute("plan12", guilvs12.get(0));	
			}
	
			PageView<XjsscPlan> pageViewGuilv11 = new PageView<XjsscPlan>(200,1);
			   pageViewGuilv11.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
				filtersnewses11.add(new PropertyFilter("type", MatchType.EQ, 13));
				pageViewGuilv11.setQueryResult(planService.findList(pageViewGuilv11,
						filtersnewses11));
				List<XjsscPlan> guilvs11 = pageViewGuilv11.getRecords();
			   
			   
				request.setAttribute("sbr13", guilvs11);
				
				if(!guilvs11.isEmpty()){
					request.setAttribute("plan13", guilvs11.get(0));	
				}

return BASE_PATH + "query_plan8";
		
		 

		
		
	}
	
	
	
	private List<XjsscGuilvLimit> getLimits(int t1,int t2){
		PageView<XjsscLottery> pageView = new PageView<XjsscLottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
	   
		List<XjsscLottery> lotteries = pageView.getRecords();
		for(int t=t1;t<t2;t++){
			int e1=0;
				 int temp=0;
				int e2=0;int e3=0;int e4=0;
			for(XjsscLottery lotterie:lotteries){
			
				boolean flag= XjsscLimitUtils.getQuery( lotterie, t);	
				
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
			
			XjsscGuilvLimit limit3=this.limit3Service.findGuilv("type", t);
			if(limit3==null){
				limit3=new XjsscGuilvLimit();
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
		
		 PageView<XjsscGuilvLimit> pageViewGuilv = new PageView<XjsscGuilvLimit>();
		   pageViewGuilv.setOrderby("num", "desc");
			List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
			filtersnewses11.add(new PropertyFilter("num", MatchType.GE, 7));
			filtersnewses11.add(new PropertyFilter("type", MatchType.GE, t1));
			filtersnewses11.add(new PropertyFilter("type", MatchType.LT, t2));
			pageViewGuilv.setQueryResult(this.limit3Service.findList(pageViewGuilv,
					filtersnewses11));
			List<XjsscGuilvLimit> guilvs = pageViewGuilv.getRecords();
			return guilvs;
	}
}
