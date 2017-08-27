/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import org.springframework.stereotype.Service;

import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryGuilvSameUtils; 
import com.sky.modules.lottery.entity.guilv.GuilvSame; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService; 
import com.sky.modules.lottery.service.guilv.GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.GuilvSameService; 
import com.sky.modules.lottery.service.guilv.LotteryService;  

 
 

@Service("GuilvSameScanner5")
public class GuilvSameScanner5 implements QueryComm  {

	@Autowired
	private LotteryService lotteryService;
	@Autowired GuilvRemoveCountService guilvRemoveCountService;
	@Autowired
	private GuilvSameService guilvService; 
	@Autowired
	private GuilvSameOldService guilvOldService; 
	@Autowired GuilvRemoveConditionService  conditionsService;
	public void job() {
	 
		System.out.println("same_2");
		
		 
  
		for(int buchang=10;buchang<=10;buchang++){
			int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=5;addition<=5;addition++){
				for(int fixation=0;fixation<=1;fixation++){
					int f=0;
					if(fixation==1){
						f=10;
					}
						for(int type=0;type<=3;type++){
							 for(int number=1;number<3;number++){
								 List<GuilvSame> sbr=new ArrayList<GuilvSame>();
								   
							        LotteryGuilvSameUtils.setQuery(addition, b, type,5, f, 1,number, lotteryService, guilvService, sbr, true,guilvOldService,guilvRemoveCountService,conditionsService);
									 	 
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
	
	
	
	private  Integer info1(String value,String info5){
		
		String s1=value.substring(0,1);
		String s2=value.substring(1,2);
		String s3=value.substring(2,3);
		String s4=value.substring(3,4);
		 
		
		
		int count=0;
	 
			String inString1=info5.split("头：")[1].trim();
			 
			 if(inString1.substring(0,4).contains(s1)){
				 count++;
			 }
		 
		
		
		 
			String inString2=info5.split("百：")[1].trim();
			 if(inString2.substring(0,4).contains(s2)){
				 count++;
			 }
			 
		 
			String inString3=info5.split("十：")[1].trim();
		 
			 if(inString3.substring(0,4).contains(s3)){
				 count++;
			 }
			 
		 
			String inString4=info5.split("尾：")[1].trim();
		 
			 if(inString4.substring(0,4).contains(s4)){
				 count++;
			 }
	 
		return count;
	}
	
	
}
