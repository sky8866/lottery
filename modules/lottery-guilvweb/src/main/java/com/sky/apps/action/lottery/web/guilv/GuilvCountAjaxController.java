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
 
 
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter;   
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount; 
import com.sky.modules.lottery.entity.guilv.GuilvPeerCount;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvPeerCountService; 
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class GuilvCountAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private LotteryService lotteryService;

	@Autowired
	private GuilvRemoveCountService guilvCountService;
	

	@Autowired
	private GuilvPeerCountService guilvPeerCountService; 
	@Autowired private MemberManager memberManager;
	 

	@RequestMapping(value = "count")
	public String query(
			@RequestParam(value = "guilv_type", defaultValue = "0") int guilv_type,
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type, String openId,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
	 
		if(user!=null&&user.getIsVip()==1){
			
			 
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			
			if(buchang!=0){
				  filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));

			}
			if(addition!=0){
			  	filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));		
			}
			Lottery lottery=this.lotteryService.findLottery();
			filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, lottery.getQi()+1)); 
	      
			filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
			
			 if(guilv_type==0){
	     		PageView<GuilvRemoveCount> pageViewGuilv = new PageView<GuilvRemoveCount>();
				   	pageViewGuilv.setOrderby("sum", "desc"); 
					pageViewGuilv.setQueryResult(guilvCountService.findList(pageViewGuilv, filtersnewses));
					 request.setAttribute("sbr", pageViewGuilv.getRecords());
					
	      }else{
	    	  PageView<GuilvPeerCount> pageViewGuilv = new PageView<GuilvPeerCount>();
			   	pageViewGuilv.setOrderby("sum", "desc");
			   	
				
				pageViewGuilv.setQueryResult(guilvPeerCountService.findList(pageViewGuilv, filtersnewses));
				 request.setAttribute("sbr", pageViewGuilv.getRecords());  
	      }
			
		} 
	
		
        

		return BASE_PATH + "query_count";
	}

	 

}
