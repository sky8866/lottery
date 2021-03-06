/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv.cq;
 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 
import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvSameUtils; 
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqGuilvSameOldService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;

 
 

@Service("CqGuilvSameScanner20")
public class CqGuilvSameScanner20  implements QueryComm{

	@Autowired
	private CqsscLotteryService lotteryService;
	@Autowired CqGuilvRemoveCountService guilvRemoveCountService;
 
	@Autowired
	private CqGuilvSameOldService guilvOldService; 
	@Autowired CqGuilvRemoveConditionService  conditionsService;
	public void job() {
	  
			int b=10;
			for(int addition=5;addition<=5;addition++){
				for(int fixation=1;fixation<=1;fixation++){
					int f=0;
					if(fixation==1){
						f=10;
					}
					 
						for(int type=0;type<=4;type++){
							 for(int number=2;number<3;number++){
								  
								 
								   
						        CqLotteryGuilvSameUtils.setQuery(addition, b, type,4, f, 1, number, lotteryService, guilvOldService,  true,guilvRemoveCountService,conditionsService);
								 
				                  
		 
 
							
							 } 
							
						}
							
					 
					
				}
				
			
			
		}
		
	 
		
		 
	}
	
	 
	
}
