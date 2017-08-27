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
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvPeer2Service;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3Service;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerService; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class SameAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";


	@Autowired
	private GuilvSameOldService guilvService; 
	
	@Autowired private MemberManager memberManager; 

	@RequestMapping(value = "same")
	public String query(
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") int qi,	String openId,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
		
		 
		PageView<GuilvSameOld> pageViewGuilv = new PageView<GuilvSameOld>();
		pageViewGuilv.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvSameOld> guilvs = pageViewGuilv.getRecords();
		
		
		
		request.setAttribute("sbr", guilvs);
	

		return BASE_PATH + "query_same";
	}
 


}
