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
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeer6Utils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryPeerUtils; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer6;
import com.sky.modules.lottery.service.guilv.GuilvPeer6OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeer6Service;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerService; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.LotteryService;  

 
 


@Service("GuilvPeer6Scanner2")
public class GuilvPeer6Scanner2  implements QueryComm  {

	@Autowired
	private LotteryService lotteryService;
	@Autowired GuilvRemoveCountService guilvRemoveCountService;
	
	@Autowired
	private GuilvPeer6Service peerService;
	@Autowired
	private GuilvPeer6OldService peerOldService;
	@Autowired GuilvRemoveConditionService  conditionsService;
	public void job()  {
		 System.out.println("peer_6");
		 
		//HangqingUtils.getHangqing("http://www.woying.com/kaijiang/qxc/"+sum+".html", lotteryService,lottery);
		for(int buchang=10;buchang<=10;buchang++){
			int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=4;addition<=5;addition++){
				 
					 
					 
						for(int type=0;type<=3;type++){
							 for(int number=0;number<=1;number++){
				                   int count=0;
								 
								 if(addition==2&&b==5&&number==1){
									 count=3; 
								 }else if(addition==2&&b==5&&number==0){
									 count=6; 
								 }else if(addition==3&&b==5&&number==1){
									 count=5; 
								 }else if(addition==3&&b==5&&number==0){
									 count=9; 
								 }else if(addition==4&&b==5&&number==1){
									 count=6; 
								 }else if(addition==4&&b==5&&number==0){
									 count=9; 
								 }else if(addition==5&&b==5&&number==1){
									 count=7; 
								 }else if(addition==5&&b==5&&number==0){
									 count=11; 
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
									 count=8; 
								 }else if(addition==5&&b==10&&number==0){
									 count=11; 
								 }
								 
						           
						           List<GuilvPeer6> sbr=new ArrayList<GuilvPeer6>();
						           
						            LotteryPeer6Utils.setQuery(addition, b, type, count, 0, 1, number, lotteryService, peerService, sbr, true,peerOldService,    guilvRemoveCountService,conditionsService);
						 
					                
										
										 
					                }
							
							 } 
							
					 
					 
					
				}
				
			}
			
		}
		
	 
		
		 
	}

