package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList;
import java.util.Collections; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
  
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeer2Utils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeer3Utils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeer5Utils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeerUtils; 
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvPeer; 
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvPeer3;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter;
 
import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer2;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvPeer2Service;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3Service;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerService; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class PeerAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private LotteryService lotteryService;

	@Autowired
	private GuilvPeerService guilvService;
	
	@Autowired
	private GuilvPeer3Service guilvService3;
	@Autowired
	private GuilvPeerOldService guilvOldService;
	
	@Autowired
	private GuilvPeer3OldService guilvOldService3;
	@Autowired
	private GuilvPeer2Service guilvService2;
	
	@Autowired private MemberManager memberManager;
	@Autowired GuilvRemoveCountService guilvRemoveCountService;
	@Autowired GuilvRemoveConditionService  conditionsService;
	@RequestMapping(value = "peer")
	public String query(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "5") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "2") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "0") int number,	String openId,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
		

		List<GuilvPeer> sbr = new ArrayList<GuilvPeer>();
		// LotteryPeer2Utils.setQuery(3, 5, 5, 0, 0, 1, lotteryService, guilvService, sbr,isvip);
	 	//
		 
		PageView<GuilvPeer> pageViewGuilv = new PageView<GuilvPeer>(10,1);
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		if(fixation==10){
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.GE, 1));	
		}else{
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.EQ, fixation));
		}
		
		if(isvip){
			if(matchType==0){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.EQ, even));	
			}else if(matchType==1){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.GE, even));	
			}else if(matchType==2){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, even));	
			} else if(matchType==3){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.GT, even));	
			}
		}else{
			 
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 5));
			 
			
			
		}
		
		
		
		
		
		 
		filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
		Lottery l=this.lotteryService.findLottery(); 
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, l.getQi()+1));
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, 3));
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvPeer> guilvs = pageViewGuilv.getRecords();
		 try{
			 if(guilvs.isEmpty()&&StringUtils.isNotEmpty(this.memberManager.getLoninName())&&"13800000000".equals(this.memberManager.getLoninName())){
					if(guilvs.isEmpty()){
						  guilvs = new ArrayList<GuilvPeer>();
						  LotteryPeerUtils.setQuery(addition, buchang, type, even, fixation, matchType, number, lotteryService, guilvService, guilvs, isvip,guilvOldService,    guilvRemoveCountService,conditionsService);  
					}	
				}	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
		
		ComparatorGuilvPeer guilv = new ComparatorGuilvPeer();

		Collections.sort(guilvs, guilv);
		request.setAttribute("sbr", guilvs);
	

		return BASE_PATH + "query_peer";
	}

	@RequestMapping(value = "peer2")
	public String query2(
			@RequestParam(value = "addition", defaultValue = "3") int addition,
			@RequestParam(value = "buchang", defaultValue = "5") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "2") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "0") int number,	String openId,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
		
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
		
		List<GuilvPeer2> guilvs=new ArrayList<GuilvPeer2>();
		
		 
		
		List<GuilvPeer2> sbr = new ArrayList<GuilvPeer2>();
		// LotteryPeer2Utils.setQuery(3, 5, 5, 0, 0, 1, lotteryService, guilvService, sbr,isvip);
	 	//
		 
		PageView<GuilvPeer2> pageViewGuilv = new PageView<GuilvPeer2>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, 4)); 
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		 
		 
		

		 
		 
		Lottery l=this.lotteryService.findLottery(); 
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, l.getQi()+1));
		
		pageViewGuilv.setQueryResult(guilvService2.findList(pageViewGuilv,
				filtersnewses));
		  guilvs = pageViewGuilv.getRecords();
		
		 try{
			 if(guilvs.isEmpty()&&StringUtils.isNotEmpty(this.memberManager.getLoninName())&&"13800000000".equals(this.memberManager.getLoninName())){
					if(guilvs.isEmpty()){
						  guilvs = new ArrayList<GuilvPeer2>();
						  LotteryPeer2Utils.setQuery(4, buchang, type, even, fixation, matchType, number, lotteryService, guilvService2, guilvs, isvip);  
					}	
				}	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
		 
		request.setAttribute("sbr", guilvs);
	

		return BASE_PATH + "query_peer2";
	}

	
	
	 
	
	@RequestMapping(value = "peer3")
	public String query3(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "5") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "2") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "0") int number,	String openId,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
		
		List<GuilvPeer3> guilvs=new ArrayList<GuilvPeer3>();
		
		 
		
		List<GuilvPeer> sbr = new ArrayList<GuilvPeer>();
		// LotteryPeer2Utils.setQuery(3, 5, 5, 0, 0, 1, lotteryService, guilvService, sbr,isvip);
	 	//
		 
		PageView<GuilvPeer3> pageViewGuilv = new PageView<GuilvPeer3>(10,1);
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		if(fixation==10){
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.GE, 1));	
		}else{
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.EQ, fixation));
		}
		
		if(isvip){
			if(matchType==0){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.EQ, even));	
			}else if(matchType==1){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.GE, even));	
			}else if(matchType==2){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, even));	
			} else if(matchType==3){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.GT, even));	
			}
		}else{
			 
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 5));
			 
			
			
		}
		
		
		 
		filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
		Lottery l=this.lotteryService.findLottery(); 
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, l.getQi()+1));
		
		pageViewGuilv.setQueryResult(guilvService3.findList(pageViewGuilv,
				filtersnewses));
		  guilvs = pageViewGuilv.getRecords();
		
		 try{
			 if(guilvs.isEmpty()&&StringUtils.isNotEmpty(this.memberManager.getLoninName())&&"13800000000".equals(this.memberManager.getLoninName())){
					if(guilvs.isEmpty()){
						  guilvs = new ArrayList<GuilvPeer3>();
						  LotteryPeer3Utils.setQuery(addition, buchang, type, even, fixation, matchType, number, lotteryService, guilvService3, guilvs, isvip,guilvOldService3,  guilvRemoveCountService,conditionsService);  
					}	
				}	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
		
		ComparatorGuilvPeer3 guilv = new ComparatorGuilvPeer3();

		Collections.sort(guilvs, guilv);
		request.setAttribute("sbr", guilvs);
	

		return BASE_PATH + "query_peer3";
	}


}
