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
 
import com.sky.apps.action.lottery.web.utils.guilv.GuilvAllRightUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryLimitUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils; 
import com.sky.apps.action.lottery.web.vo.guilv.GuilvVo;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.Aes;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSum;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvSumService;
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller 
public class Pl5GuilvPushAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

 
 
	@Autowired private MemberManager memberManager;
	 
	@Autowired private Pl5GuilvSumService guilvSumService;
 
	@RequestMapping(value = "/admin/ajax/guilv/pl5/push")
	public String query(
			String openId,
			HttpServletRequest request) {
		User user=this.memberManager.findUser("openId", openId);
	 
		if(user!=null&&user.getIsVip()==1){
			PageView<Pl5GuilvSum> pageView = new PageView<Pl5GuilvSum>(5,1);
			pageView.setOrderby("id", "desc");
			List<Pl5GuilvSum> guilvSums=this.guilvSumService.findList(pageView, null).getResultlist();
			 request.setAttribute("sbr", guilvSums);  
		}else{
			request.setAttribute("isVip", 2);
		}
		

	 
		  
	 

		return BASE_PATH + "pl5_query_push";
	}

	 

}
