package com.sky.apps.action.lottery.web.guilv;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.service.user.MemberManager;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;



@Controller

public class PeerController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	@RequestMapping(value = "/system/guilv/peer")
	public String word(HttpServletRequest request) {
		 
			String code = request.getParameter("code");
			 StringBuffer sb=new StringBuffer();
			String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  } 
		
		return BASE_PATH + "peer";
	}
	
	@RequestMapping(value = "/admin/guilv/peer")
	public String web_peer(HttpServletRequest request) {
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		request.setAttribute("peer_active", "active"); 
		return BASE_PATH + "peer";
	}
	
	@RequestMapping(value = "/system/guilv/peer3")
	public String word3(HttpServletRequest request) {
		 
			String code = request.getParameter("code");
			 StringBuffer sb=new StringBuffer();
			String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  } 
		
		return BASE_PATH + "peer3";
	}
	
	@RequestMapping(value = "/admin/guilv/peer3")
	public String web_peer3(HttpServletRequest request) {
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		request.setAttribute("peer_active", "active"); 
		return BASE_PATH + "peer3";
	}
	
	
	@RequestMapping(value = "/system/guilv/peer2")
	public String word2(HttpServletRequest request) {
		 
			String code = request.getParameter("code");
			 StringBuffer sb=new StringBuffer();
			String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
	  		   if(StringUtils.isNotEmpty(isvip)){
	  			return isvip;
	  		  } 
		
		return BASE_PATH + "peer2";
	}
	
	@RequestMapping(value = "/admin/guilv/peer2")
	public String web_peer2(HttpServletRequest request) {
		
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		request.setAttribute("peer_active", "active"); 
		return BASE_PATH + "peer2";
	}
}
