package com.sky.apps.action.lottery.web.guilv;

 
  
  
import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.sky.apps.action.lottery.web.utils.guilv.LotteryGuilvSameUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryGuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeer3Utils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils;  
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCondition;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.Lottery;   
import com.sky.modules.lottery.service.guilv.GuilvOLdService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.GuilvSameService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
import com.sky.modules.lottery.service.guilv.LotteryService;
import com.sky.modules.lottery.service.user.MemberManager; 
import com.sky.modules.lottery.utils.user.LogController;
import com.sky.modules.lottery.utils.weixin.AuthenticationUtils;
 
 
 


@Controller

public class GuilvController extends LogController{
	  
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private MemberManager memberManager;
	 
     @Autowired GuilvPeerOldService peerService;
	
	@Autowired GuilvPeer3OldService peer3Service;
	@Autowired GuilvSingleDoubleOLdService gDoubleOLdService;
	@Autowired
	private LotteryService lotteryService; 
	@Autowired GuilvSameService sameService;
	@Autowired GuilvSameOldService sameOldService;
	@Autowired GuilvOLdService oLdService;
	@Autowired GuilvRemoveConditionService conditionService;
	@Autowired GuilvRemoveCountService guilvRemoveCountService;
	@Autowired GuilvService guilvService;
	@RequestMapping(value = "/system/index")
	public String home(HttpServletRequest request){ 
		 
		List<Guilv> olds=this.guilvService.findList("qi", 2013);
		
		for(Guilv g:olds){
			  if(g.getBuchang()==10&&g.getBuchang()==4&&g.getFixation()==0&&g.getNumber()==1&&g.getSum()==2){
				  System.out.println("type:"+g.getType()+",value:"+g.getValue());
			  }
		}
		
		String code = request.getParameter("code");
		StringBuffer sb=new StringBuffer();
		String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);;
		   if(StringUtils.isNotEmpty(isvip)){
			return isvip;
		  }
		   log(sb.toString(), request.getRequestURI(), "qxc_index");
			return BASE_PATH + "home";
		 
		
	}
	
 
	@RequestMapping(value = "/admin/guilv/index")
	public String web_home(HttpServletRequest request){ 
		  
		request.setAttribute("openid", this.memberManager.getOpenId()); 
		request.setAttribute("index_active", "active");
/* 	
		for(int buchang=9;buchang<=10;buchang++){
			   int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=1;addition<=5;addition++){
				for(int fixation=0;fixation<=1;fixation++){
					 
					for(int number=5;number<=6;number++){
						
						for(int sum=3;sum<45;sum++){
						 boolean flag=  SumCountUtils.getGuilv(addition, b, fixation, number, sum);
						 if(flag){
							 Object[] objects=new Object[5];
							   objects[0]="fixation";
							   objects[1]="buchang";
							   objects[2]="addition";
							   objects[3]="number"; 
							   objects[4]="gui"; 
							   Object[]  var=new Object[5];
							   var[0]=fixation;
							   var[1]=b;
							   var[2]=addition;
							   var[3]=number; 
							   var[4]=12; 
							   GuilvRemoveCondition condition=this.conditionService.findGuilvs(objects, var);
							   if(condition==null){
								   condition =new GuilvRemoveCondition();
								   condition.setFixation(fixation);
								   condition.setBuchang(b);
								   condition.setAddition(addition);
								   condition.setNumber(number);
								   condition.setGui(12);
								   condition.setSum(sum);
								   condition.setSumCount(0);
								   condition.setSumMin(sum);
								   condition.setSumNew(sum);
								   this.conditionService.saveGuilv(condition); 
							   }
						 }
						}
						
					}
					 
						
							
					 
					
				}
				
			}
			
		}*/ 
		
/*		
		List<GuilvSame> sameOlds=this.sameService.findList();
		for(GuilvSame g:sameOlds){
          
		   
		   Object[] objects=new Object[5];
		   objects[0]="fixation";
		   objects[1]="buchang";
		   objects[2]="addition";
		   objects[3]="number"; 
		   objects[4]="gui"; 
		   Object[]  var=new Object[5];
		   var[0]=g.getFixation();
		   var[1]=g.getBuchang();
		   var[2]=g.getAddition();
		   var[3]=g.getNumber(); 
		   var[4]=12; 
		   GuilvRemoveCondition condition=this.conditionService.findGuilvs(objects, var);
		   if(condition==null){
			   condition =new GuilvRemoveCondition();
			   condition.setFixation(g.getFixation());
			   condition.setBuchang(g.getBuchang());
			   condition.setAddition(g.getAddition());
			   condition.setNumber(g.getNumber());
			   condition.setGui(12);
			   condition.setSum(g.getSum());
			   condition.setSumCount(0);
			   condition.setSumMin(g.getSum());
			   condition.setSumNew(g.getSum());
			   this.conditionService.saveGuilv(condition);
		   }else{
			   if(g.getSum()>condition.getSum()){
				   condition.setSumCount(condition.getSumCount()+1);
				   condition.setSumMin(g.getSum());  
				   condition.setSum(g.getSum());
			   } 
			   condition.setSumNew(g.getSum());
			   this.conditionService.saveGuilv(condition);
		   }
		}
		*/
 	
  
	 
		
		
			return BASE_PATH + "home";
		 
		
	}
	

	
	@RequestMapping(value = "/system/yexuan/error")
	public String word(HttpServletRequest request,HttpServletResponse response) {
		 
		String code = request.getParameter("code"); 
		StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
  		   if(StringUtils.isNotEmpty(isvip)){
  			return isvip;
  		  }
	    
 			PageView<Lottery> pageView = new PageView<Lottery>(10,1);
 			pageView.setOrderby("id", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<Lottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
	
 			log(sb.toString(), request.getRequestURI(), "qxc_error");
		return BASE_PATH + "guilv_error";
	}

	@RequestMapping(value = "/admin/guilv/error")
	public String web_error(HttpServletRequest request,HttpServletResponse response) {
		 
		request.setAttribute("error_active", "active");
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	    
 			PageView<Lottery> pageView = new PageView<Lottery>(10,1);
 			pageView.setOrderby("id", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<Lottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
		return BASE_PATH + "guilv_error";
	}
	
	
	
	@RequestMapping(value = "/system/yexuan/sum_error")
	public String sum_error(HttpServletRequest request,HttpServletResponse response) {
		 
		String code = request.getParameter("code"); 
		StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
  		   if(StringUtils.isNotEmpty(isvip)){
  			return isvip;
  		  }
	    
 			PageView<Lottery> pageView = new PageView<Lottery>(10,1);
 			pageView.setOrderby("id", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<Lottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
	
 			log(sb.toString(), request.getRequestURI(), "qxc_sum_error");
		return BASE_PATH + "guilv_sum";
	}

	@RequestMapping(value = "/admin/guilv/sum_error")
	public String web_sum_error(HttpServletRequest request,HttpServletResponse response) {
		 
		request.setAttribute("sum_error", "active");
		request.setAttribute("openid", this.memberManager.getOpenId()); 
	    
 			PageView<Lottery> pageView = new PageView<Lottery>(10,1);
 			pageView.setOrderby("id", "desc");

 			pageView.setQueryResult(lotteryService.findList(pageView, null));
 			List<Lottery> lotteries = pageView.getRecords();
 			request.setAttribute("lotterys", lotteries);
 			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
		return BASE_PATH + "guilv_sum";
	}
	
	
	@RequestMapping(value = "/system/yexuan/sum_error2")
	public String web_sum_error2(HttpServletRequest request,HttpServletResponse response) {
		 
		String code = request.getParameter("code"); 
		StringBuffer sb=new StringBuffer();
		 String	isvip= AuthenticationUtils.weixin(code, request, memberManager,true,sb);
 		   if(StringUtils.isNotEmpty(isvip)){
 			return isvip;
 		  }
 		 
			PageView<Lottery> pageView = new PageView<Lottery>(10,1);
			pageView.setOrderby("id", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
			List<Lottery> lotteries = pageView.getRecords();
			request.setAttribute("lotterys", lotteries);
			request.setAttribute("newqi", lotteries.get(0).getQi()+1);
			 log(sb.toString(), request.getRequestURI(), "qxc_sum_error2");
		return BASE_PATH + "guilv_sum2";
	}
 
}
