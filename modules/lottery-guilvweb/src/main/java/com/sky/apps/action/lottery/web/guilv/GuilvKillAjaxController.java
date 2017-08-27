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
import com.sky.apps.action.lottery.web.utils.guilv.LotteryKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.SumCountUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqsscGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.GuilvVo;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
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
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
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
public class GuilvKillAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private CqsscLotteryService lotteryService;

	@Autowired
	private CqsscGuilvService guilvService;
 
	@Autowired private MemberManager memberManager;
 
  
     @Autowired private CqsscPlanService planService;
	 
	 
	@RequestMapping(value = "kill")
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
	
		
		User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
	  
	   if(type!=5){
		   
		   PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(1,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<CqsscLottery> lotteries = pageView.getRecords();
		   
		   
			PageView<CqsscGuilv> pageViewGuilv = new PageView<CqsscGuilv>();
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			
			filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
		 
		 
		
			
			filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, lotteries.get(0).getQi()+1));
	 
			pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
					filtersnewses));
			List<CqsscGuilv> guilvs = pageViewGuilv.getRecords();
		 
			 try{
				 if(guilvs.isEmpty()&&StringUtils.isNotEmpty(this.memberManager.getLoninName())&&"13800000000".equals(this.memberManager.getLoninName())){

				  guilvs = new ArrayList<CqsscGuilv>();
				  
				  PageView<CqsscLottery> pageView1 = new PageView<CqsscLottery>();
					pageView1.setOrderby("id", "desc");

					pageView1.setQueryResult(lotteryService.findList(pageView1, null));
				 
					List<CqsscLottery> lotteries1 = pageView1.getRecords();
				  
				  
				CqsscGuilvUtils.setQuery(addition, buchang, type, even, fixation, matchType, number, lotteryService, guilvService, guilvs,isvip,lotteries1);	
			 
				 }
				 }catch (Exception e) {
						// TODO: handle exception
					}
		 
			 
			ComparatorCqsscGuilv guilv = new ComparatorCqsscGuilv();

			Collections.sort(guilvs, guilv);
			
			request.setAttribute("sbr", guilvs);
			request.setAttribute("sumVaule", LotteryKillUtils.getVaule(guilvs, type)); 
			
			return BASE_PATH + "query_kill";
	   }else{
		   PageView<CqsscPlan> pageViewGuilv = new PageView<CqsscPlan>(10,1);
		   pageViewGuilv.setOrderby("id", "desc");
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			filtersnewses.add(new PropertyFilter("type", MatchType.EQ, 1));
			pageViewGuilv.setQueryResult(planService.findList(pageViewGuilv,
					filtersnewses));
			List<CqsscPlan> guilvs = pageViewGuilv.getRecords();
		   
		   
			request.setAttribute("sbr", guilvs);
			
			 
			if(!guilvs.isEmpty()){
				request.setAttribute("plan", guilvs.get(0));	
			}
			PageView<CqsscPlan> pageViewGuilv2 = new PageView<CqsscPlan>(10,1);
			   pageViewGuilv2.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses2 = new ArrayList<PropertyFilter>();
				filtersnewses2.add(new PropertyFilter("type", MatchType.EQ, 2));
				pageViewGuilv2.setQueryResult(planService.findList(pageViewGuilv2,
						filtersnewses2));
				List<CqsscPlan> guilvs2 = pageViewGuilv2.getRecords();
			   
			   
				request.setAttribute("sbr2", guilvs2);
				if(!guilvs2.isEmpty()){
					request.setAttribute("plan2", guilvs2.get(0));	
				}
				 
				
				PageView<CqsscPlan> pageViewGuilv3 = new PageView<CqsscPlan>(10,1);
				   pageViewGuilv3.setOrderby("id", "desc");
					List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
					filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, 5));
					pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
							filtersnewses3));
					List<CqsscPlan> guilvs3 = pageViewGuilv3.getRecords();
				   
				   
					request.setAttribute("sbr3", guilvs3);
					if(!guilvs3.isEmpty()){
						request.setAttribute("plan3", guilvs3.get(0));	
					}
					
				
		   return BASE_PATH + "query_plan";
	   }
		
		 

		
		
	}

	 
}
