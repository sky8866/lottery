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
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class GuilvAllRightAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private LotteryService lotteryService;

	@Autowired
	private GuilvAllRightService guilvService;
	@Autowired private MemberManager memberManager;
	 

	@RequestMapping(value = "limit2")
	public String query(
			 
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "0") int even,
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
		

		List<GuilvAllRight> sbr = new ArrayList<GuilvAllRight>();
		GuilvAllRightUtils.setQuery(even,qi,type, lotteryService, guilvService, sbr, isvip);
		 
		 
		
		request.setAttribute("sbr", sbr);
	 

		return BASE_PATH + "query_limit2";
	}

	 

}
