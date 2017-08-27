/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv.cq;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 
import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvSingleDoubleUtils; 
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.CqGuilvSingleDoubleOld;  
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqGuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService; 

 

 
 


@Service("CqGuilvSingleDoubleScanner6") 
public class CqGuilvSingleDoubleScanner6 implements QueryComm{

	@Autowired
	private CqsscLotteryService lotteryService;
	
 
	@Autowired CqGuilvRemoveCountService guilvRemoveCountService;

	 
		
		@Autowired
		private CqGuilvSingleDoubleOldService goService;
		 
		@Autowired CqGuilvRemoveConditionService  conditionsService;
		public void job() {
		 
	 	 
		for(int buchang=19;buchang<=19;buchang++){
			      int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=1;addition<=1;addition++){
		 
					 
					 
						for(int type=0;type<=4;type++){
							
							 
							 s2(addition, b, type, 0, lotteryService, goService);
						}
							
					 
					
				 
				
			}
			 
		}
		
	 
		 
		 
	}
	
	

	
	private void s2(int addition,int buchang,int type,int fixation, CqsscLotteryService lotteryService, CqGuilvSingleDoubleOldService guilvService){
		 
	       
	    List<CqGuilvSingleDoubleOld> sbr = new ArrayList<CqGuilvSingleDoubleOld>();
	    int count=5;
       

		 if(addition==1&&buchang==5){
			 count=5; 
		 }else if(addition==2&&buchang==5){
			 count=8; 
		 }else if(addition==3&&buchang==5){
			 count=11; 
		 }else if(addition==4&&buchang==5){
			 count=15; 
		 }else if(addition==5&&buchang==5){
			 count=17; 
		 }else if(addition==1&&buchang==10){
			 count=5; 
		 }else if(addition==2&&buchang==10){
			 count=9; 
		 }else if(addition==3&&buchang==10){
			 count=13; 
		 }else if(addition==4&&buchang==10){
			 count=17; 
		 }else if(addition==5&&buchang==10){
			 count=19; 
		 }        
			 
	    CqLotteryGuilvSingleDoubleUtils.setQuery(addition, buchang, type, count, fixation, 1, 5, lotteryService, guilvService, sbr,true,guilvRemoveCountService,conditionsService);	
		 
		 
	}
}
