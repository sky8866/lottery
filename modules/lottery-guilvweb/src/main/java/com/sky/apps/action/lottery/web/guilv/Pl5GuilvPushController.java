package com.sky.apps.action.lottery.web.guilv;
 
import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Invest;
import com.sky.modules.lottery.entity.guilv.InvestSum;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSum;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.LotteryService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSumService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils; 
 

@Controller
 
public class Pl5GuilvPushController extends LogController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	 @Autowired Pl5GuilvSumService guilvSumService;
	 @Autowired
		private Pl5LotteryService lotteryService;  
	 @Autowired private Pl5PlanService planService;
	@RequestMapping(value = "/system/guilv/pl5/push")
	public String list(HttpServletRequest request) {
 
		
		String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);;
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }
		   
		   try{
			   String openid = (String) request.getAttribute("openid");  ;
				 
			   User user=this.memberManager.findUser("openId", openid);
			   PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>(1,1);
				pageView.setOrderby("id", "desc");
		       
			 
				
				Pl5Lottery lottery=this.lotteryService.findList(pageView, null).getResultlist().get(0);
				
				
				
				Pl5GuilvSum push=this.guilvSumService.findPl5GuilvSum("qi", lottery.getQi()+1);
				if(push==null){
					push=this.guilvSumService.findPl5GuilvSum("qi", lottery.getQi());
				}else{
					if(user.getType()==1){
						push=null;
					}
				}
				request.setAttribute("user", user);
				request.setAttribute("push", push);
				
				
		   }catch (Exception e) {
			 
		}
		 

		   
	 
		   log(sb.toString(), request.getRequestURI(), "pl5_push");	
		
		  return BASE_PATH + "pl5_push"; 
	
	}
	
	 
	
	@RequestMapping(value = "/admin/guilv/pl5/push/save", method = RequestMethod.GET)
	public String saveUI(HttpServletRequest request) {
		 
		request.setAttribute("push_active", "active"); 
		
		return BASE_PATH + "pl5pushFrom";
	}
	
	@RequestMapping(value = "/admin/guilv/pl5/push/save", method = RequestMethod.POST)
     public String save(@Valid Pl5GuilvSum guilv,
    		 String infos1, String infos2, String infos3, String infos4, String infos5,
    		 String infos6, String infos7, String infos8, String infos9, String infos10,
    		 String infos11, String infos12, String infos13, String infos14, String infos15,
    		 String infos16, String infos17, String infos18, String infos19, String infos20,
    		 HttpServletRequest request) {
		request.setAttribute("push_active", "active"); 
		String info1="";
	    
	    if(StringUtils.isNotEmpty(infos1)){
	    	info1=info1+"头："+infos1;
	    }
	  
	    if(StringUtils.isNotEmpty(infos2)){
	    	info1=info1+" 百："+infos2;
	    }
	  
	    if(StringUtils.isNotEmpty(infos3)){
	    	info1=info1+" 十："+infos3;
	    }
	  
	    if(StringUtils.isNotEmpty(infos4)){
	    	info1=info1+" 尾："+infos4;
	    }
	    guilv.setInfo1(info1);
	    String info="";
	  
	    if(StringUtils.isNotEmpty(infos5)){
	    	info=info+" 头："+infos5;
	    }
		
 
	    if(StringUtils.isNotEmpty(infos6)){
	    	info=info+" 百："+infos6;
	    }
	  
	    if(StringUtils.isNotEmpty(infos7)){
	    	info=info+" 十："+infos7;
	    }
	 
	    if(StringUtils.isNotEmpty(infos8)){
	    	info=info+" 尾："+infos8;
	    }
	    guilv.setInfo(info);
	    
	    String info2="";
	   
	    if(StringUtils.isNotEmpty(infos9)){
	    	info2=info2+" 头："+infos9;
	    }
		
	   
	    if(StringUtils.isNotEmpty(infos10)){
	    	info2=info2+" 百："+infos10;
	    }
	   
	    if(StringUtils.isNotEmpty(infos11)){
	    	info2=info2+" 十："+infos11;
	    }
	     
	    if(StringUtils.isNotEmpty(infos12)){
	    	info2=info2+" 尾："+infos12;
	    }
	    guilv.setInfo2(info2);
	    
	    
	    String info5="";
	   
	    if(StringUtils.isNotEmpty(infos13)){
	    	info5=info5+" 头："+infos13;
	    }
		
	    
	    if(StringUtils.isNotEmpty(infos14)){
	    	info5=info5+" 百："+infos14;
	    }
 
	    if(StringUtils.isNotEmpty(infos15)){
	    	info5=info5+" 十："+infos15;
	    }
	     
	    if(StringUtils.isNotEmpty(infos16)){
	    	info5=info5+" 尾："+infos16;
	    }
	    guilv.setInfo5(info5);
	    
	    String info3="";
	  
	    if(StringUtils.isNotEmpty(infos17)){
	    	info3=info3+" 头："+infos17;
	    }
		 
	    if(StringUtils.isNotEmpty(infos18)){
	    	info3=info3+" 百："+infos18;
	    } 
	    if(StringUtils.isNotEmpty(infos19)){
	    	info3=info3+" 十："+infos19;
	    } 
	    if(StringUtils.isNotEmpty(infos20)){
	    	info3=info3+" 尾："+infos20;
	    }
	    guilv.setInfo3(info3);
	    
	    
	    
		 this.guilvSumService.savePl5GuilvSum(guilv);
		 plan(guilv);
		 
		  
		 return  "redirect:/admin/guilv/pl5/push";
	}
 
	@RequestMapping(value = "/admin/guilv/pl5/push")
	public String web_limit2(HttpServletRequest request) {
		request.setAttribute("push_active", "active");  
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	 
		
		
		
		return BASE_PATH + "pl5_admin_push";
	}
	
	
	private void plan(Pl5GuilvSum  guilv){
		for(int i=0;i<5;i++){
			 Pl5Plan plan=new Pl5Plan();
			 plan.setType(i);
			 String p=guilv.getInfo();
			 if(i==1){
				p=guilv.getInfo1(); 
			 }else if(i==2){
				 p=guilv.getInfo2();
			 }else if(i==3){
				 p=guilv.getInfo3();
			 }else if(i==4){
				 p=guilv.getInfo5();
			 }
			 //plan.setPlan(p);
			 plan.setQi(guilv.getQi());
			 this.planService.savePlan(plan);
		}
		
	}
	 
}
