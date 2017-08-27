package com.sky.modules.lottery.utils.user;

 

import org.springframework.beans.factory.annotation.Autowired;

import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.entity.user.UserLog;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.service.user.UserLogService; 
 

public class LogController {
	
	@Autowired
	private UserLogService logService;
	@Autowired private MemberManager memberManager;
	public void log(String openid,String url,String modules){
		User user =this.memberManager.findUser("openId", openid);
		UserLog log=new UserLog();
		String name="";
		 if(user!=null){
			 name=user.getName();
			 log.setUserId(user.getId());
		 }
		
		log.setModules(modules);
		log.setName(name);
		log.setUrl(url);
		
		this.logService.saveUserLog(log);
	}

}
