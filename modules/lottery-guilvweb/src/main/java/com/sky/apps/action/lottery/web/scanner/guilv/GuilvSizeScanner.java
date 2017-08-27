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
import com.sky.apps.action.lottery.web.utils.guilv.LotteryGuilvSizeUtils; 
import com.sky.modules.core.bean.PageView;  
import com.sky.modules.lottery.entity.guilv.GuilvSizeOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvLimit2OldService;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.GuilvLimitOldService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService; 
import com.sky.modules.lottery.service.guilv.GuilvSizeOLdService; 
import com.sky.modules.lottery.service.guilv.LotteryService;  

 

 
 


@Service("GuilvSizeScanner")
public class GuilvSizeScanner  implements QueryComm   {

	@Autowired
	private LotteryService lotteryService;
	
 
	@Autowired GuilvRemoveCountService guilvRemoveCountService;

		@Autowired
		private GuilvSizeOLdService guilvService;
		
		@Autowired
		private GuilvSizeOLdService goService;
		
		@Autowired GuilvAllRightService gl2Service;
		@Autowired GuilvLimit2OldService gl2oService;
		@Autowired GuilvLimitService glService;
		@Autowired GuilvLimitOldService gloService;
		@Autowired GuilvRemoveConditionService  conditionsService;
		public void job() {
	 
		System.out.println("Size");
		
		PageView<Lottery> pageView = new PageView<Lottery>(1,1);
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		Lottery lottery=pageView.getRecords().get(0);
         int sum=lottery.getSum()+1;
      /*   for(int i=1;i<250;i++){
        	 PageView<Guilv>  pg=new PageView<Guilv>(1000,i);
        	 List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
     		filtersnewses
     				.add(new PropertyFilter("qi", MatchType.EQ, 1877)); 
     		List<Guilv> gvsGuilvs=guilvService.findList(pg, filtersnewses).getResultlist();
     		 for(Guilv g:gvsGuilvs){
               	 
                 System.out.println("wddddwwsssww");
              	  this.guilvService.delGuilv(g.getId());
                }
        	 
         }
         
         for(int i=1;i<250;i++){
        	 PageView<GuilvPeer>  pg=new PageView<GuilvPeer>(1000,i);
        	 List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
     		filtersnewses
     				.add(new PropertyFilter("qi", MatchType.EQ, 1877)); 
     		List<GuilvPeer> gvsGuilvs=guilvPeerService.findList(pg, filtersnewses).getResultlist();
     		 for(GuilvPeer g:gvsGuilvs){
               	 System.out.println("wweeewwwwwwwddsds");
                 
              	  this.guilvPeerService.delGuilv(g.getId());
                }
        	 
         }
        
         
         
 
 
     */
     
	 	 
		for(int buchang=9;buchang<10;buchang++){
			      int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=1;addition<=3;addition++){
		 
					 
					 
						for(int type=0;type<=3;type++){
							
							 
							 s2(addition, b, type, 0, lotteryService, guilvService);
						}
							
					 
					
				 
				
			}
			 
		}
		
	 
		
		 
	}
	
	

	
	private void s2(int addition,int buchang,int type,int fixation, LotteryService lotteryService, GuilvSizeOLdService guilvService){
		 
	       
	    List<GuilvSizeOld> sbr = new ArrayList<GuilvSizeOld>();
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
			 
	    LotteryGuilvSizeUtils.setQuery(addition, buchang, type, count, fixation, 1, 5, lotteryService, guilvService, sbr,true,goService,guilvRemoveCountService,conditionsService);	
		 
		 
	}
}
