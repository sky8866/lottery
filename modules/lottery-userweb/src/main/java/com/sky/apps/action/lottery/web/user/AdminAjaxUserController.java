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
@RequestMapping(value = "/admin/ajax/user")
public class AdminAjaxUserController {
	  
	private final static String BASE_PATH = "user/"; 
	@Autowired private MemberManager memberManager;
	
	@Autowired private UserVipService vipService;
	@RequestMapping(value = "list")
	
	public String word(String query,@RequestParam(value = "vip", defaultValue = "3") int  vip ,String starttime,String endtime,@RequestParam(value = "page", defaultValue = "1") int  page,HttpServletRequest request) {
		if("13800000000".equals(this.memberManager.getUser().getLoginName())){
			
			PageView<User> pageView = new PageView<User>(Maxresult.MAX10,page);
			List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
			 
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
		}
	
		 
		return BASE_PATH+"userList";
	}
	
	  
	    @RequestMapping(value = "inputForm",method =RequestMethod.POST)
	    @ResponseBody
	    public String save(Long id,String starttime,String endtime,
	    		HttpServletRequest request,HttpServletResponse response) {
	    	if("13800000000".equals(this.memberManager.getUser().getLoginName())){
	    		try{
		    		User user=this.memberManager.findUser(id);
		    		UserVip vip=this.vipService.findUserVip("openId", user.getOpenId());
		    		if(vip==null){
		    			vip =new UserVip();
		    			vip.setEndtime(endtime);
		    			vip.setStarttime(starttime);
		    			vip.setOpenId(user.getOpenId());
		    			this.vipService.saveUserVip(vip);
		    		}else{
		    			vip.setEndtime(endtime);
		    			 
		    			this.vipService.updateUserVip(vip);	
		    		}
		    		
		    		user.setIsVip(1);
		    		this.memberManager.updateUser(user);
		    		
		    		return  "true";
		    	}catch (Exception e) {
					return "false";
				}
	    	}
	    	
	    	return "";
	  
	  }
 
}
