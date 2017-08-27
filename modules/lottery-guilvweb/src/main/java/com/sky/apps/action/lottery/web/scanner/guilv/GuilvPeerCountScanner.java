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

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeerCount;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvPeerCountService;
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.utils.guilv.HangqingUtils;

 
 

/**
 * 被Spring各种Scheduler反射调用的Service POJO.
 * 
 * @author Calvin
 */
@Component
public class GuilvPeerCountScanner {

	@Autowired
	private LotteryService lotteryService;
 
	@Autowired
	private GuilvPeerService peerService;
	
	@Autowired private GuilvPeerCountService countService;
	
	 

	public void executeByJdk() {
		execute("jdk timer job");
	}

	public void executeBySpringCronByJava() {
		execute("spring cron job by java");
	}

	// 被Spring的Quartz MethodInvokingJobDetailFactoryBean反射执行
	public void executeByQuartzLocalJob() {
		execute("quartz local job");
	}

	// 被Spring的Scheduler namespace 反射构造成ScheduledMethodRunnable
	public void executeBySpringCronByXml() {
		execute("spring cron job by xml");
	}

	// 被Spring的Scheduler namespace 反射构造成ScheduledMethodRunnable
	public void executeBySpringTimerByXml() {
		execute("spring timer job by xml");
	}

	/**
	 * 定时打印当前用户数到日志.
	 */
	private void execute(String by) {
	 
		System.out.println("启动了！g4");
		
		PageView<Lottery> pageView = new PageView<Lottery>(1,1);
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		Lottery lottery=pageView.getRecords().get(0);
         int sum=lottery.getQi()+1;
		 
		//HangqingUtils.getHangqing("http://www.woying.com/kaijiang/qxc/"+sum+".html", lotteryService,lottery);
		for(int buchang=9;buchang<=10;buchang++){
			    if(buchang==9){
			    	buchang =5;
			    }
			for(int addition=2;addition<=5;addition++){
				for(int fixation=0;fixation<1;fixation++){
					 
					 
						for(int type=0;type<=3;type++){
							 for(int number=0;number<=1;number++){
				 
						        
								 
						   	PageView<GuilvPeer> pageViewGuilv = new PageView<GuilvPeer>(1,1);
						   	pageViewGuilv.setOrderby("sum", "desc");
							List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
							filtersnewses.add(new PropertyFilter("addition", MatchType.EQ, addition));
							filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
							filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type)); 
							filtersnewses.add(new PropertyFilter("info", MatchType.NNULL,null));
							filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
							filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, sum));
							filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, 3)); 
						    filtersnewses.add(new PropertyFilter("fixation", MatchType.EQ, 0)); 
							pageViewGuilv.setQueryResult(peerService.findList(pageViewGuilv,
									filtersnewses));
							List<GuilvPeer> guilvs = pageViewGuilv.getRecords();
							
					                for(GuilvPeer g:guilvs){
					                	System.out.println(g.getSum());
					                	Object[] p=new Object[5];
					                	p[0]="addition";
					                	 
					                	p[1]="buchang";
					                	p[2]="type";
					                	 
					                	p[3]="qi";
					                	p[4]="number";
					              
					                	Object[] v=new Object[5];
					                	v[0]=g.getAddition();
					                	 
					                	v[1]=g.getBuchang();
					                	v[2]=g.getType();
					                	v[3]=g.getQi();
					                	v[4]=g.getNumber();
 
					                	GuilvPeerCount vo = this.countService.findGuilvs(p, v);
					                	if(vo==null){
					                		vo=new GuilvPeerCount();
					                		vo.setAddition(g.getAddition());
											vo.setBuchang(g.getBuchang());
											vo.setEven(g.getEven());
											vo.setSum(g.getSum());
											vo.setMatchType(g.getMatchType());
											vo.setNumber(g.getNumber());
											vo.setQi(g.getQi());
											vo.setType(g.getType());
											vo.setStartQueryValue(g.getStartQueryValue());
											vo.setStartValue(g.getStartValue());
											vo.setValue(g.getValue());
											vo.setFixation(g.getFixation());
											vo.setQueryValue(g.getQueryValue());
						                    vo.setValueOld(g.getValueOld());
						                    vo.setValueNew(g.getValueNew());
						                    
						                    vo.setTypeVaule(g.getTypeVaule());
						                    vo.setGui(g.getGui());
						                    
						                        
											 
												vo.setInfo(g.getInfo());
												this.countService.saveGuilv(vo);	
					                	}
										
										 
					                }
							
							 } 
							
						}
							
					 
					
				}
				
			}
			
		}
		
	 
		
		 
	}
}
