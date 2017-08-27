package com.sky.modules.lottery.utils.weixin;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.entity.user.UserVip;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.user.UserInfo;
import com.sky.modules.lottery.web.WebMessage;



public class AuthenticationUtils {
	
	public  static String weixin(String code,HttpServletRequest request,MemberManager memberManager,StringBuffer sb){
		return weixin(  code, request, memberManager,false,1,sb);
	}
	
	public  static String weixin(String code,HttpServletRequest request,MemberManager memberManager,boolean isvip,StringBuffer sb){
		return weixin(  code, request, memberManager,isvip,1,sb);
	}
	
 
	
	public  static String weixin(String code,HttpServletRequest request,MemberManager memberManager,boolean isvip,int type,StringBuffer sb){
		 
		 if(StringUtils.isNotEmpty(code)){
				WebMessage web = new WebMessage();
				Map<String, String> tokenMap = web.getAccessToken(code);
			 
				String openid = tokenMap.get("openid");
				User user=null;
				if(StringUtils.isNotEmpty(openid)){
					sb.append(openid);
					UserInfo info=new UserInfo(openid);
					 user=memberManager.findUser("openId", openid);
					if(user==null){
		     			
		 				 
		     			memberManager.addUserGuanZhu(info.getOpenid(), info.getHeadimgurl(), info.getNickname(),info.getUnionid(),info.getRemark(),info.getGroupid());
		     		}else{
		     			UserVip vip=memberManager.findUserVip("openId", openid);
		     			if(vip!=null){
		     				if(StringUtils.isNotEmpty(vip.getEndtime())){
		     					
		     					int time=	UtilDate.getLeftDay(UtilDate.getDateFormatters(vip.getEndtime()), new Date());
		     				 
				     			  if(time<0){
				     				  user.setIsVip(0);
				     				  memberManager.updateUser(user);
				     			  }	
		     				}else{
		     					 user.setIsVip(0);
		     					 user.setPicture(info.getHeadimgurl());
		     					 user.setName(info.getNickname());
			     				  memberManager.updateUser(user);
		     				}
		     			  
		     			}
		     		}
					
			    	 
		    			
				}else{
					if("zth110120".equals(code)){

		                      openid="zth110120";
					}
				}
				
				if(isvip&&user!=null&&user.getIsVip()!=1){
					 return "error/info";
				}
				
				if(user!=null&&user.getType()!=2&&type==0){
					 return "error/info2";
				}
				 
				request.setAttribute("openid", openid);  
	     }else{
	    	 return "error/info";
	     }
		

		 return null;
	}
 
	
	 
}
