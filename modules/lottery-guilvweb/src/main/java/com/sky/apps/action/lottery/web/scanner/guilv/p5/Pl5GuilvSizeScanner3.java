/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv.p5;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import org.springframework.stereotype.Service;
 
import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvSizeUtils; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSizeOld;  
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSizeOldService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService; 

 

 
 


@Service("Pl5GuilvSizeScanner3") 
public class Pl5GuilvSizeScanner3 implements QueryComm{

	@Autowired
	private Pl5LotteryService lotteryService;
	
 
	@Autowired Pl5GuilvRemoveCountService guilvRemoveCountService;

	 
		
		@Autowired
		private Pl5GuilvSizeOldService goService;
		 
		@Autowired Pl5GuilvRemoveConditionService  conditionsService;
		public void job() {
		 System.out.println("p5_simgleDouble2");
	 
    
	 	 
		for(int buchang=9;buchang<=10;buchang++){
			      int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=5;addition<=5;addition++){
		 
					 
					 
						for(int type=0;type<=3;type++){
							
							 
							 s2(addition, b, type, 0, lotteryService, goService);
						}
							
					 
					
				 
				
			}
			 
		}
		
	 
		
		 
	}
	
	

	
	private void s2(int addition,int buchang,int type,int fixation, Pl5LotteryService lotteryService, Pl5GuilvSizeOldService guilvService){
		 
	       
	    List<Pl5GuilvSizeOld> sbr = new ArrayList<Pl5GuilvSizeOld>();
	    int count=5;
       

		 if(addition==1&&buchang==5){
			 count=5; 
		 }else if(addition==2&&buchang==5){
			 count=8; 
		 }else if(addition==3&&buchang==5){
			 count=11; 
		 }else if(addition==4&&buchang==5){
			 count=14; 
		 }else if(addition==5&&buchang==5){
			 count=16; 
		 }else if(addition==1&&buchang==10){
			 count=4; 
		 }else if(addition==2&&buchang==10){
			 count=8; 
		 }else if(addition==3&&buchang==10){
			 count=12; 
		 }else if(addition==4&&buchang==10){
			 count=15; 
		 }else if(addition==5&&buchang==10){
			 count=17; 
		 }        
			 
	    Pl5LotteryGuilvSizeUtils.setQuery(addition, buchang, type, count, fixation, 1, 5, lotteryService, guilvService, sbr,true,guilvRemoveCountService,conditionsService);	
		 
		 
	}
}
