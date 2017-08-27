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
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryPeer3Utils; 
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.CqGuilvPeer3Old;  
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.service.guilv.CqGuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
 

 
 

@Service("CqGuilvPeer3Scanner")
public class CqGuilvPeer3Scanner implements QueryComm   {

	@Autowired
	private CqsscLotteryService lotteryService;
	@Autowired CqGuilvRemoveCountService guilvRemoveCountService;
 
	@Autowired
	private CqGuilvPeer3OldService peerOldService;
	@Autowired CqGuilvRemoveConditionService  conditionsService;
	public void job() {
		 
		for(int buchang=9;buchang<=9;buchang++){
			int b=10;
			     if(buchang==9){
			    	b =5;
			    } 
			for(int addition=1;addition<=1;addition++){
				 
					 
					 
						for(int type=0;type<=4;type++){
							 for(int number=1;number<=1;number++){
				                   int count=3;
								 
								 if(addition==2&&b==5&&number==1){
									 count=4; 
								 }else if(addition==2&&b==5&&number==0){
									 count=6; 
								 }else if(addition==3&&b==5&&number==1){
									 count=5; 
								 }else if(addition==3&&b==5&&number==0){
									 count=9; 
								 }else if(addition==4&&b==5&&number==1){
									 count=7; 
								 }else if(addition==4&&b==5&&number==0){
									 count=10; 
								 }else if(addition==5&&b==5&&number==1){
									 count=8; 
								 }else if(addition==5&&b==5&&number==0){
									 count=13; 
								 }else if(addition==2&&b==10&&number==1){
									 count=5; 
								 }else if(addition==2&&b==10&&number==0){
									 count=7; 
								 }else if(addition==3&&b==10&&number==1){
									 count=6; 
								 }else if(addition==3&&b==10&&number==0){
									 count=10; 
								 }else if(addition==4&&b==10&&number==1){
									 count=8; 
								 }else if(addition==4&&b==10&&number==0){
									 count=11; 
								 }else if(addition==5&&b==10&&number==1){
									 count=9; 
								 }else if(addition==5&&b==10&&number==0){
									 count=15; 
								 }
								 
						           
						           List<CqGuilvPeer3Old> sbr=new ArrayList<CqGuilvPeer3Old>();
						           
						         
						 
						            CqLotteryPeer3Utils.setQuery(addition, b, type, count, 0, 1, number, lotteryService, peerOldService, sbr, true, guilvRemoveCountService, conditionsService); 
										
										 
					                }
							
							 } 
							
					 
					 
					
				}
				
			}
		 
		}
		
	 
		
		 
	}

