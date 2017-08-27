/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv.p5;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import org.springframework.stereotype.Service;
 
import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvSameUtils; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;

 
 

@Service("Pl5GuilvSameScanner")
public class Pl5GuilvSameScanner  implements QueryComm{

	@Autowired
	private Pl5LotteryService lotteryService;
	@Autowired Pl5GuilvRemoveCountService guilvRemoveCountService;
 
	@Autowired
	private Pl5GuilvSameOldService guilvOldService; 
	@Autowired Pl5GuilvRemoveConditionService  conditionsService;
	public void job() {
	 
		  System.out.println("p5_same");
		
		 
  
		for(int buchang=9;buchang<=10;buchang++){
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
								 
								   
						        Pl5LotteryGuilvSameUtils.setQuery(addition, b, type,5, f, 1, number, lotteryService, guilvOldService,  true,guilvRemoveCountService,conditionsService);
								 
				                  
		 
 
							
							 } 
							
						}
							
					 
					
				}
				
			}
			
		}
		
	 
		
		 
	}
	
	 
	
}
