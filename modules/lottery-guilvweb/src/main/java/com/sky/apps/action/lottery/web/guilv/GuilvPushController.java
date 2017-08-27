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
import com.sky.modules.lottery.entity.guilv.NewPlan;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSum;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.entity.guilv.QxcPlan;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.LotteryService;
import com.sky.modules.lottery.service.guilv.NewPlanService;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;
import com.sky.modules.lottery.service.guilv.QxcPlanService;
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils; 
 

@Controller
 
public class GuilvPushController   extends LogController {
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	@Autowired private GuilvInvestSumService investSumService;
	@Autowired private GuilvSumService guilvSumService;
	@Autowired private GuilvInvestService investService;
	@Autowired
	private LotteryService lotteryService;
	 @Autowired private QxcPlanService planService;
	 @Autowired private NewPlanService newPlanService;
	@RequestMapping(value = "/system/guilv/push")
	public String list(HttpServletRequest request) {
	/*	List<InvestSum> sums=this.investSumService.findInvestSum();
		  double s1=0;
		  double s2=0;
		  double s3=0;
		for(InvestSum sum:sums){
			s1=s1+sum.getSumMoney();
			s2=s2+sum.getMoney1();
			s3=s3+sum.getMoney2();
		}
		
		System.out.println("总数："+s1);
		System.out.println("二定："+s2);
		System.out.println("四定："+s3);*/
		
		String code = request.getParameter("code");
		 StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }
		   
		   try{
			   String openid = (String) request.getAttribute("openid");  ;
				 
			   User user=this.memberManager.findUser("openId", openid);
			   PageView<Lottery> pageView = new PageView<Lottery>(1,1);
				pageView.setOrderby("id", "desc");
		       
			 
				
				Lottery lottery=this.lotteryService.findList(pageView, null).getResultlist().get(0);
				
				
				
				GuilvSum push=this.guilvSumService.findGuilvSum("qi", lottery.getQi()+1);
				if(push==null){
					push=this.guilvSumService.findGuilvSum("qi", lottery.getQi());
				}else{
					if(user.getType()==1){
						push=null;
					}
				}
				request.setAttribute("user", user);
				request.setAttribute("push", push);
				
				log(sb.toString(), request.getRequestURI(), "qxc_push");  	
		   }catch (Exception e) {
			 
		}
		 

		   
	 
		
		
		  return BASE_PATH + "push"; 
	
	}
	
	@RequestMapping(value = "/admin/guilv/push")
	public String web_limit2(HttpServletRequest request) {
		request.setAttribute("push_active", "active");  
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	 
		
		
		
		return BASE_PATH + "admin_push";
	}
 
	
	@RequestMapping(value = "/system/guilv/newplan/save", method = RequestMethod.GET)
	public String newplan(HttpServletRequest request) {
		Lottery lottery=this.lotteryService.findLottery();
		long qi=lottery.getQi()+1;
		NewPlan plan=this.newPlanService.findPlan(qi, 0);
		request.setAttribute("push_active", "active"); 
		 
		request.setAttribute("plan", plan); 
		return BASE_PATH + "newplanFrom";
	}
	
	@RequestMapping(value = "/system/guilv/newplan/save", method = RequestMethod.POST)
    public String newplansave(@Valid NewPlan  plan ,
   		 HttpServletRequest request) {
		NewPlan 	plan2=this.newPlanService.findPlan(plan.getQi(), plan.getType());
		if(plan2==null){
			this.newPlanService.savePlan(plan);
		}else{
			plan.setId(plan2.getId());
			this.newPlanService.updatePlan(plan);
		}
		
		
		request.setAttribute("plan", plan); 
		 return   BASE_PATH +"newplanFrom";
	}
	
	
	@RequestMapping(value = "/admin/guilv/push/save", method = RequestMethod.GET)
	public String saveUI(HttpServletRequest request) {
		 
		request.setAttribute("push_active", "active"); 
		
		return BASE_PATH + "pushFrom";
	}
	
	@RequestMapping(value = "/admin/guilv/push/save", method = RequestMethod.POST)
     public String save(@Valid GuilvSum guilv, 
    		 String infos1, String infos2, String infos3, String infos4, String infos5,
    		 String infos6, String infos7, String infos8, String infos9, String infos10,
    		 String infos11, String infos12, String infos13, String infos14, String infos15,
    		 String infos16, String infos17, String infos18, String infos19, String infos20,
    		 String infos21,String infos22,String infos23,String infos24,String infos25,
    		 String infos26,String infos27,String infos28,
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
	    guilv.setInfo7(info1);
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
	    guilv.setInfo1(info2);
	    
	    
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
	    guilv.setInfo2(info5);
	    
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
	    
	    String info6="";
		  
	    if(StringUtils.isNotEmpty(infos21)){
	    	info6=info6+" 头："+infos21;
	    }
		 
	    if(StringUtils.isNotEmpty(infos22)){
	    	info6=info6+" 百："+infos22;
	    } 
	    if(StringUtils.isNotEmpty(infos23)){
	    	info6=info6+" 十："+infos23;
	    } 
	    if(StringUtils.isNotEmpty(infos24)){
	    	info6=info6+" 尾："+infos24;
	    }
	    guilv.setInfo5(info6);
	    
	    String info7="";
		  
	    if(StringUtils.isNotEmpty(infos25)){
	    	info7=info7+" 头："+infos25;
	    }
		 
	    if(StringUtils.isNotEmpty(infos26)){
	    	info7=info7+" 百："+infos26;
	    } 
	    if(StringUtils.isNotEmpty(infos27)){
	    	info7=info7+" 十："+infos27;
	    } 
	    if(StringUtils.isNotEmpty(infos28)){
	    	info7=info7+" 尾："+infos28;
	    }
	    guilv.setInfo6(info7);
		
		
		 this.guilvSumService.saveGuilvSum(guilv);
		 plan(guilv);
		 List<InvestSum> sums=this.investSumService.findInvestSum();
		 
		 saveInvest(guilv,sums);
		 return  "redirect:/admin/guilv/push";
	}
	
	
	private void plan(GuilvSum  guilv){
		for(int i=0;i<7;i++){
			 QxcPlan plan=new QxcPlan();
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
			 }else if(i==5){
				 p=guilv.getInfo6();
			 }else if(i==6){
				 p=guilv.getInfo7();
			 }
			 plan.setPlan(p);
			 plan.setQi(guilv.getQi());
			 this.planService.savePlan(plan);
		}
		
	}
	
	
	private void saveInvest(GuilvSum guilv, List<InvestSum> sums){
		
		
		
		String qi=guilv.getQi()+"期:";
		
		
		for(InvestSum sum:sums){
			Invest invest=new Invest();
			if(sum.getMoney1()>0){
				invest.setInfo5(qi+guilv.getInfo5().replaceAll(":", "："));
			}
			if(sum.getMoney2()>0){
				invest.setInfo1(qi+guilv.getInfo7().replaceAll(":", "："));
			}
		    
		    invest.setVaule(guilv.getVaule());
		    
		    invest.setMoney1(sum.getMoney1());
		    invest.setMoney2(sum.getMoney2());
		    invest.setPutInto(sum.getPutInto());
		    
		    invest.setMoney(sum.getMoney()); 
					  java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
					double p1=sum.getSumMoney()-sum.getMoney1()-sum.getMoney2();    
		           invest.setSumMoney(Double.valueOf(df.format(p1))); 
		    invest.setSum(sum.getSum()+1);
		    invest.setPrize1(sum.getPrize1());
		    invest.setPrize2(sum.getPrize2());
		 
		    invest.setQi(guilv.getQi());
		    invest.setType(sum.getType());
		    this.investService.saveInvest(invest);
		    
		    sum.setSumMoney(p1);
		    sum.setSum(sum.getSum()+1);
		    this.investSumService.updateInvestSum(sum);
		}
	
	}
	
	
	 
}
