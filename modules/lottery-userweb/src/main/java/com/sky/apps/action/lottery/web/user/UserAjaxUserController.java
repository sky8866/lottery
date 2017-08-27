package com.sky.apps.action.lottery.web.user;

 

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.Maxresult;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.user.User; 
import com.sky.modules.lottery.entity.user.UserVip;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.service.user.UserVipService;   


@Controller
@RequestMapping(value = "/system/ajax/user")
public class UserAjaxUserController {
	  
	private final static String BASE_PATH = "user/"; 
	@Autowired private MemberManager memberManager;
	
	@Autowired private UserVipService vipService;
	@RequestMapping(value = "list")
	
	public String word(String qrscene,String query,@RequestParam(value = "vip", defaultValue = "3") int  vip ,String starttime,String endtime,@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
	 
			
			PageView<User> pageView = new PageView<User>(Maxresult.MAX10,page);
			List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
			filters.add(new PropertyFilter("eventKey", MatchType.EQ, qrscene));
			if(vip!=3){
				filters.add(new PropertyFilter("isVip", MatchType.EQ, vip)); 
			}
			if(StringUtils.isNotEmpty(query)){
				filters.add(new PropertyFilter("name", MatchType.LIKE, query));
			}
			
			pageView.setQueryResult(this.memberManager.findPageUser(pageView, filters));
			for(User u:pageView.getRecords()){
				if(u.getIsVip()==1){
					UserVip uvip=this.vipService.findUserVip("openId", u.getOpenId());
					u.setEndDate("【"+uvip.getEndtime()+"】到期");
				}
			}
			request.setAttribute("pageView", pageView); 
	 
	
		 
		return BASE_PATH+"qrsceneList";
	}
	
	  
	 
}
