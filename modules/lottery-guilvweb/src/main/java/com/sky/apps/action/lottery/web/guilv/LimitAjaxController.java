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
 
import com.sky.apps.action.lottery.web.utils.guilv.CqsscLimitUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryLimit6Utils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryLimitUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils; 
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvLimit;
import com.sky.apps.action.lottery.web.vo.guilv.GuilvVo;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.Aes;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvLimit6;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.CqsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvLimit6Service;
import com.sky.modules.lottery.service.guilv.GuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class LimitAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private LotteryService lotteryService;
	@Autowired private GuilvLimit6Service limit3Service;
	@Autowired
	private GuilvLimitService guilvService;
	@Autowired private MemberManager memberManager;
	 

	@RequestMapping(value = "limit")
	public String query(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "3") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "1") int number,	String openId,
			@RequestParam(value = "defaults", defaultValue = "1") int defaults,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
		if(type!=5){
			List<GuilvLimit> sbr = new ArrayList<GuilvLimit>();
			if(addition==0&&buchang==0&&even==0){
				 
				 LotteryLimitUtils.setQuery(1, 5, type, 8, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
				 LotteryLimitUtils.setQuery(1, 10, type, 9, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
				 LotteryLimitUtils.setQuery(2, 10, type, 11, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
				 LotteryLimitUtils.setQuery(2, 5, type, 10, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
				 LotteryLimitUtils.setQuery(3, 5, type, 14, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
				 LotteryLimitUtils.setQuery(3, 10, type, 15, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
			}else{
				 LotteryLimitUtils.setQuery(addition, buchang, type, even, fixation, matchType, number, lotteryService, guilvService, sbr,isvip);
				  	
			}
			
			
			request.setAttribute("sbr", sbr);	
		}else{
			List<GuilvLimit6> guilvs = getLimits(0, 48);
			request.setAttribute("limits", guilvs);
			List<GuilvLimit6> guilvs2 = getLimits(48, 64);
			request.setAttribute("limits2", guilvs2);
			List<GuilvLimit6> guilvs3 = getLimits(64, 76);
			request.setAttribute("limits3", guilvs3);
			List<GuilvLimit6> guilvs4 = getLimits(76, 116);
			request.setAttribute("limits4", guilvs4);
			List<GuilvLimit6> guilvs5 = getLimits(116, 136);
			request.setAttribute("limits5", guilvs5);
			List<GuilvLimit6> guilvs6 = getLimits(136, 167);
			request.setAttribute("limits6", guilvs6);
	return BASE_PATH + "query_plan9";
		}


	 

		return BASE_PATH + "query_limit";
	}

	private List<GuilvLimit6> getLimits(int t1,int t2){
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
	   
		List<Lottery> lotteries = pageView.getRecords();
		for(int t=t1;t<t2;t++){
			int e1=0;
				 int temp=0;
				int e2=0;int e3=0;int e4=0;
			for(Lottery lotterie:lotteries){
			
				boolean flag= LotteryLimit6Utils.getQuery( lotterie, t);	
				
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
			
			GuilvLimit6 limit3=this.limit3Service.findGuilv("type", t);
			if(limit3==null){
				limit3=new GuilvLimit6();
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
		
		 PageView<GuilvLimit6> pageViewGuilv = new PageView<GuilvLimit6>();
		   pageViewGuilv.setOrderby("num", "desc");
			List<PropertyFilter> filtersnewses11 = new ArrayList<PropertyFilter>();
			filtersnewses11.add(new PropertyFilter("num", MatchType.GE, 7));
			filtersnewses11.add(new PropertyFilter("type", MatchType.GE, t1));
			filtersnewses11.add(new PropertyFilter("type", MatchType.LT, t2));
			
			pageViewGuilv.setQueryResult(this.limit3Service.findList(pageViewGuilv,
					filtersnewses11));
			List<GuilvLimit6> guilvs = pageViewGuilv.getRecords();
			return guilvs;
	}

}
