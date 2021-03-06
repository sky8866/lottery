/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv.p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import org.springframework.stereotype.Service;

import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils;
import com.sky.apps.action.lottery.web.utils.guilv.NumCountUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5GuilvKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5GuilvUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5NumCountUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqsscGuilv;  
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorPl5Guilv;
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.Pl5Guilv;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvKill;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvKill; 
import com.sky.modules.lottery.entity.guilv.Pl5Guilv; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Invest;
import com.sky.modules.lottery.entity.guilv.InvestSum;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.guilv.XjsscPlan;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvKillService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvKillService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvKillService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvKillService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.XjsscPlanService;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
import com.sky.modules.lottery.utils.guilv.Hangqing2Utils;
import com.sky.modules.lottery.utils.guilv.Hangqing3Utils;
import com.sky.modules.lottery.utils.guilv.Hangqing5Utils;
import com.sky.modules.lottery.utils.guilv.HangqingUtils;

 
 

@Service("Pl5GuilvScanner3") 
public class Pl5GuilvScanner3 implements QueryComm{

	@Autowired
	private Pl5LotteryService lotteryService;
	 
	@Autowired
	private Pl5GuilvService guilvService;
	@Autowired Pl5GuilvRemoveCountService cocuntService;
	@Autowired private Pl5GuilvRemoveConditionService conditionService; 
	public void job() {

		 System.out.println("p5_guilv3");
		
 
         
 
        
	
		for(int buchang=9;buchang<10;buchang++){
			   int b=10;
			    if(buchang==9){
			    	b =5;
			    }
			for(int addition=5;addition<=5;addition++){
				for(int fixation=0;fixation<=1;fixation++){
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
	
	

	
	private void s2(int addition,int buchang,int type,int fixation, Pl5LotteryService lotteryService, Pl5GuilvService guilvService){
		 for(int number=0;number<7;number++){ 
	    List<Pl5Guilv> sbr = new ArrayList<Pl5Guilv>();
	      
			 
	    Pl5LotteryUtils.setQuery(addition, buchang, type, Pl5NumCountUtils.getCount(addition, buchang, fixation, number), fixation, 1, number, lotteryService, guilvService, sbr,true,cocuntService,conditionService);	
		 
		} 
	}
	
}
