/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv.cq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import org.springframework.stereotype.Service;

import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils;
import com.sky.apps.action.lottery.web.utils.guilv.NumCountUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.CqGuilvUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.CqNumCountUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqsscGuilv;   
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqGuilv; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Invest;
import com.sky.modules.lottery.entity.guilv.InvestSum;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.guilv.XjsscPlan; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqGuilvService; 
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService; 
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.XjsscPlanService; 
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
import com.sky.modules.lottery.utils.guilv.Hangqing2Utils;
import com.sky.modules.lottery.utils.guilv.Hangqing3Utils;
import com.sky.modules.lottery.utils.guilv.Hangqing5Utils;
import com.sky.modules.lottery.utils.guilv.HangqingUtils;

 
 

@Service("CqGuilvScanner2") 
public class CqGuilvScanner2 implements QueryComm{

	@Autowired
	private CqsscLotteryService lotteryService;
	 
	@Autowired
	private CqGuilvService guilvService;
	@Autowired CqGuilvRemoveCountService cocuntService;
	@Autowired private CqGuilvRemoveConditionService conditionService; 
	public void job() {

		 
        
	
		for(int buchang=5;buchang<=5;buchang++){
			   
			
			 
					 
						for(int type=0;type<=4;type++){ 
							 for(int number=1;number<=1;number++){
								  
								   
								 for(int addition=2;addition<=2;addition++){
								 
								 
								 
								    
							       
								    List<CqGuilv> sbr = new ArrayList<CqGuilv>();
								      
										 
								    CqLotteryUtils.setQuery(addition, buchang, type, CqNumCountUtils.getCount(addition, buchang, 0, number), 0, 1, number, lotteryService, guilvService, sbr,true,cocuntService,conditionService);	
									 
									} 
						}
							
					 
					
				 
				
			}
			
		}
		
		 
		
		 
	}
	
	

 
	
}
