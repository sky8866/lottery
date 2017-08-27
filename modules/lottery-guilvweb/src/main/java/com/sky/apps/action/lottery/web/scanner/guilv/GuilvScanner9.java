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
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils;
import com.sky.apps.action.lottery.web.utils.guilv.NumCountUtils; 
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.service.guilv.GuilvOLdService; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.LotteryService;  

 

 
 
@Service("GuilvScanner9")
public class GuilvScanner9  implements QueryComm {

	@Autowired
	private LotteryService lotteryService;
	
  
	@Autowired
	private GuilvOLdService guilvOldService;
	@Autowired GuilvRemoveCountService cocuntService;
	@Autowired private GuilvRemoveConditionService conditionService; 
		@Autowired
		private GuilvService guilvService;
		 
		public void job() {
	 
		System.out.println("guilv_3");
		
		 
       
		 
	 	 //HangqingUtils.getHangqing("http://www.woying.com/kaijiang/qxc/"+sum+".html", lotteryService,lottery);
		for(int buchang=10;buchang<=10;buchang++){
			int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=5;addition<=5;addition++){
				for(int fixation=0;fixation<1;fixation++){
					int f=0;
					if(fixation==1){
						f=10;
					}
					 
						for(int type=0;type<=3;type++){
							
							 
							s2(addition, b, type, f, lotteryService, guilvService);
						}
							
					 
					
				}
				
			}
			
		}
		
	 
		
		 
	}
	
	

	
	private void s2(int addition,int buchang,int type,int fixation, LotteryService lotteryService, GuilvService guilvService){
		 for(int number=0;number<=6;number++){
			  
	       
	    List<Guilv> sbr = new ArrayList<Guilv>();
	      
			 
	    LotteryUtils.setQuery(addition, buchang, type, NumCountUtils.getCount(addition, buchang, fixation, number), fixation, 1, number, lotteryService, guilvService, sbr,true,guilvOldService,cocuntService,conditionService);	
		 
		} 
	}
}
