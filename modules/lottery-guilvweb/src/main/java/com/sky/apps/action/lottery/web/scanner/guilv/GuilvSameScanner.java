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
import com.sky.apps.action.lottery.web.utils.guilv.LotteryGuilvSameUtils; 
import com.sky.modules.lottery.entity.guilv.GuilvSame;  
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.GuilvSameService; 
import com.sky.modules.lottery.service.guilv.LotteryService;  

 
 

@Service("GuilvSameScanner")
public class GuilvSameScanner  implements QueryComm  {

	@Autowired
	private LotteryService lotteryService;
	@Autowired GuilvRemoveCountService guilvRemoveCountService;
	@Autowired
	private GuilvSameService guilvService; 
	@Autowired
	private GuilvSameOldService guilvOldService; 
	@Autowired GuilvRemoveConditionService  conditionsService;
	public void job() {
	 
		 System.out.println("same");
		
		 
  
		for(int buchang=9;buchang<10;buchang++){
			int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=1;addition<=3;addition++){
				for(int fixation=0;fixation<=1;fixation++){
					int f=0;
					if(fixation==1){
						f=10;
					}
					 
						for(int type=0;type<=3;type++){
							 for(int number=3;number<5;number++){
								 if(number==4){
									 number=6;
								 }
								 List<GuilvSame> sbr=new ArrayList<GuilvSame>();
								   
						        LotteryGuilvSameUtils.setQuery(addition, b, type,5, f, 1, number, lotteryService, guilvService, sbr, true,guilvOldService,guilvRemoveCountService,conditionsService);
								 
				                  
		 
 
							
							 } 
							
						}
							
					 
					
				}
				
			}
			
		}
		
	 
		
		 
	}
	
	 
	
}
