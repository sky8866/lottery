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
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryPeerUtils; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeerOld; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;

 
 


@Service("Pl5GuilvPeerScanner")
public class Pl5GuilvPeerScanner implements QueryComm {

	@Autowired
	private Pl5LotteryService lotteryService;
	@Autowired Pl5GuilvRemoveCountService guilvRemoveCountService;
	 
	@Autowired
	private Pl5GuilvPeerOldService peerService;
	@Autowired Pl5GuilvRemoveConditionService  conditionsService;
	public void job() {
      System.out.println("p5_peer");
		for(int buchang=9;buchang<=10;buchang++){
			int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=2;addition<=3;addition++){
				 
					 
					 
						for(int type=0;type<=3;type++){
							 for(int number=0;number<=1;number++){
				                   int count=0;
								 
								 if(addition==2&&b==5&&number==1){
									 count=3; 
								 }else if(addition==2&&b==5&&number==0){
									 count=4; 
								 }else if(addition==3&&b==5&&number==1){
									 count=5; 
								 }else if(addition==3&&b==5&&number==0){
									 count=7; 
								 }else if(addition==4&&b==5&&number==1){
									 count=4; 
								 }else if(addition==4&&b==5&&number==0){
									 count=7; 
								 }else if(addition==5&&b==5&&number==1){
									 count=5; 
								 }else if(addition==5&&b==5&&number==0){
									 count=9; 
								 }else if(addition==2&&b==10&&number==1){
									 count=4; 
								 }else if(addition==2&&b==10&&number==0){
									 count=6; 
								 }else if(addition==3&&b==10&&number==1){
									 count=5; 
								 }else if(addition==3&&b==10&&number==0){
									 count=9; 
								 }else if(addition==4&&b==10&&number==1){
									 count=7; 
								 }else if(addition==4&&b==10&&number==0){
									 count=9; 
								 }else if(addition==5&&b==10&&number==1){
									 count=7; 
								 }else if(addition==5&&b==10&&number==0){
									 count=11; 
								 }
								 
						           
						           List<Pl5GuilvPeerOld> sbr=new ArrayList<Pl5GuilvPeerOld>();
						           
						            Pl5LotteryPeerUtils.setQuery(addition, b, type, count, 0, 1, number, lotteryService, peerService, sbr, true,    guilvRemoveCountService,conditionsService);
						 
					                
										
										 
					                }
							
							 } 
							
					 
					 
					
				}
				
			}
			
		}
		
	 
		
		 
	}

