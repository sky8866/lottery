/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv;

import java.util.ArrayList;
import java.util.List; 
 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils;
import com.sky.apps.action.lottery.web.utils.guilv.NumCountUtils; 
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Invest;
import com.sky.modules.lottery.entity.guilv.InvestSum;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
import com.sky.modules.lottery.service.guilv.GuilvOLdService; 
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.utils.guilv.HangqingUtils;

 
 

@Service("GuilvScanner2")
public class GuilvScanner2  implements QueryComm   {

	@Autowired
	private LotteryService lotteryService;

	@Autowired
	private GuilvService guilvService;
	@Autowired
	private GuilvOLdService guilvOldService;
	@Autowired private GuilvInvestSumService investSumService;
	@Autowired private GuilvInvestService investService;
	@Autowired private GuilvSumService guilvSumService;
	@Autowired GuilvRemoveCountService cocuntService;
	
	@Autowired private GuilvRemoveConditionService conditionService;  
	  
	
		public void job() {
		System.out.println("guilv_2");
		
		 
		
/*		for(int i=1;i<10000;i++){
			PageView<GuilvSameOld> pageView = new PageView<GuilvSameOld>(1000*i,1);
			List<GuilvSameOld> sameOlds=this.sameOldService.findList(pageView, null).getResultlist();
			for(GuilvSameOld g:sameOlds){
	             int fixation=0;
			   if(g.getFixation()!=0){
				   fixation=1;
			   }
		     System.out.println("g1");
			   GuilvRemoveCondition condition=this.conditionService.findGuilv(fixation, g.getBuchang(), g.getAddition(), g.getNumber(), 12);
			   if(condition==null){
				   condition =new GuilvRemoveCondition();
				   condition.setFixation(fixation);
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
					   
					   if(g.getSum()>condition.getSumMin()){
						  
						   condition.setSumMin(g.getSum());
					   }
					   
					   condition.setSumCount(condition.getSumCount()+1);  
					  
				   } 
				   if(g.getSum()>condition.getSumNew()){
					   condition.setSumNew(g.getSum());
				   }
				   
				   this.conditionService.updateGuilv(condition);
			   }
			}
		}*/
		
 	
/* 	PageView<Lottery> pageView = new PageView<Lottery>(1,1);
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		Lottery lottery=pageView.getRecords().get(0);*/
        
    	  //HangqingUtils.getHangqing2( lotteryService);
 /*	 	 Lottery ly= lotteryService.findReport("qi", lottery.getQi()+1);
 	 	 if(ly!=null){
 	 		 GuilvSum guilvSum=this.guilvSumService.findGuilvSum("qi", ly.getQi());
 	 		 if(guilvSum!=null&&guilvSum.getVaule()==null){
 	 			 StringBuffer sBuffer=new StringBuffer();
 	 			 sBuffer.append(ly.getNumber1()).append(ly.getNumber2()).append(ly.getNumber3()).append(ly.getNumber4());
 	 			 guilvSum.setVaule(sBuffer.toString());
 	 			 this.guilvSumService.updateGuilvSum(guilvSum);
 	 			 
 	 			List<Invest> invests=this.investService.findIntegers("qi", guilvSum.getQi());
 	 			for(Invest invest:invests){
 	 				InvestSum sInvestSum=this.investSumService.findInvestSum("type", invest.getType());
 	 				
 	 				
 	 				if(invest.getVaule()==null){
 	 					 invest.setVaule(guilvSum.getVaule());
 	 					 if(StringUtils.isNotEmpty(invest.getInfo5())){
 	 						 int  count1= info5(invest.getVaule(),invest.getInfo5());
 	 	 				    
 	 	 				    if(count1==2){
 	 	 				    	invest.setPrize1(sInvestSum.getPrize1()+1);
 	 	 				    	
 	 	 				    	  	
 	 	 				    	  invest.setP1(1);
 	 	 				    	  int s=sInvestSum.getP1();
 	 	 				    
 	 	 				     
 	 	 				      java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
 							     
 		 			           invest.setSumMoney(Double.valueOf(df.format(invest.getSumMoney()+s)));
 	 	 				    } 
 	 					 }
 				         if(StringUtils.isNotEmpty(invest.getInfo1())){
 				        	  int  count2= info1(invest.getVaule(),invest.getInfo1());
 		 	 				    if(count2==4){
 		 	 				    	  
 		 	 				    	 invest.setPrize2(sInvestSum.getPrize2()+1);
 		 	 				    	invest.setP2(1);
 		 	 				    	  int s=sInvestSum.getP2();
 		 	 	 				    	 
 		 	 	 				    	 
 		 	 	 				     java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
 		 						     
 		 	 			           invest.setSumMoney(Double.valueOf(df.format(invest.getSumMoney()+s)));
 		 	 				    	 
 		 	 				    } 
 				         }
 	 				  
 	 				   
 	 				 
 	 				  
 	 				    this.investService.updateInvest(invest);
 	 				    
 	 				    sInvestSum.setSumMoney(invest.getSumMoney());
 	 				 sInvestSum.setPrize1(invest.getPrize1());
 	 				  sInvestSum.setPrize2(invest.getPrize2());
 	 				 
 	 				  this.investSumService.updateInvestSum(sInvestSum);
 	 				  
 	 				}
 	 			  
 	 			}
			    
 	 		 }
 	 	 }*/
		for(int buchang=10;buchang<=10;buchang++){
			int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=1;addition<=3;addition++){
				for(int fixation=0;fixation<1;fixation++){
					int f=0;
					if(fixation==1){
						f=10;
					}
					 
						for(int type=0;type<=3;type++){
							 for(int number=0;number<=6;number++){
								 List<Guilv> sbr=new ArrayList<Guilv>();
								  
								 
							 
								 
						        LotteryUtils.setQuery(addition, b, type,NumCountUtils.getCount(addition, b, f, number), fixation, 1, number, lotteryService, guilvService, sbr, true,guilvOldService,cocuntService,conditionService);
								 
				                  
		 
 
							
							 } 
							
						}
							
					 
					
				}
				
			}
			
		}  
		
	 
		
		 
	}
	
	
	private  Integer info5(String value,String info5){
		
		String s1=value.substring(0,1);
		String s2=value.substring(1,2);
		String s3=value.substring(2,3);
		String s4=value.substring(3,4);
		 
		
		
		int count=0;
		if(info5.contains("头")){
			String inString1=info5.split("头：")[1];
			String inStirng2=inString1.split("：")[0];
			String inStirng3=inString1.split("：")[1];
			if(inStirng2.contains(s1)){
				count++;
			}
			if(inStirng2.contains("百")){
				if(inStirng3.contains(s2)){
					count++;
				}
			}
			
			if(inStirng2.contains("十")){
				if(inStirng3.contains(s3)){
					count++;
				}
			}
			
			if(inStirng2.contains("尾")){
				if(inStirng3.contains(s4)){
					count++;
				}
			}
			 
		}else if(info5.contains("百")){
			String inString1=info5.split("百：")[1];
			String inStirng2=inString1.split("：")[0];
			String inStirng3=inString1.split("：")[1];
			if(inStirng2.contains(s2)){
				count++;
			}
		 
			
			if(inStirng2.contains("十")){
				if(inStirng3.contains(s3)){
					count++;
				}
			}
			
			if(inStirng2.contains("尾")){
				if(inStirng3.contains(s4)){
					count++;
				}
			}
			 
		}else if(info5.contains("十")){
			String inString1=info5.split("十：")[1];
		 
			String inStirng2=inString1.split("：")[0];
			String inStirng3=inString1.split("：")[1];
			if(inStirng2.contains(s3)){
				count++;
			}
		 
			
			
			if(inStirng2.contains("尾")){
				if(inStirng3.contains(s4)){
					count++;
				}
			}
			 
		}
		return count;
	}
	
	
	
	private    Integer info1(String value,String info5){
		
		String s1=value.substring(0,1);
		String s2=value.substring(1,2);
		String s3=value.substring(2,3);
		String s4=value.substring(3,4);
		 
		
		
		int count=0;
	 
			String inString1=info5.split("头：")[1].trim();
			
			 if(inString1.substring(0, 8).contains(s1)){
				  
				 count++;
			 }
		 
		
		
		 
			String inString2=info5.split("百：")[1].trim();
			 
			 if(inString2.substring(0, 8).contains(s2)){
				 count++;
			 }
			 
		 
			String inString3=info5.split("十：")[1].trim();
		 
			 if(inString3.substring(0, 8).contains(s3)){
				 count++;
			 }
			 
		 
			String inString4=info5.split("尾：")[1].trim();
		 
			 if(inString4.substring(0, 8).contains(s4)){
				 count++;
			 }
	 
		return count;
	}
	
	
	 
	
}
