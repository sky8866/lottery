/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv;

  
 
  
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;  

import com.sky.apps.action.lottery.web.utils.guilv.Pl5GuilvRemoveConditionUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvSameUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvScopeUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryPeer3Utils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.GuilvPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.GuilvScUtils;
import com.sky.apps.action.lottery.web.utils.guilv.GuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.GuilvUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorPl5GuilvRemoveCount;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorPl5GuilvRemoveCount2;
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.NewPlan;
import com.sky.modules.lottery.entity.guilv.Pl5Guilv;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCondition; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvScopeOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
import com.sky.modules.lottery.service.guilv.NewPlanService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvScopeOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;  



 

 
 
 
@Component
public class Pl5PlanGuilvScanner   {

	@Autowired
	private Pl5LotteryService lotteryService;

	@Autowired
	private Pl5GuilvService guilvService;
	 
	 
	@Autowired
	private Pl5GuilvScopeOldService guilvScopeOldService;
	
	@Autowired Pl5GuilvPeerOldService peerService;
	
	@Autowired Pl5GuilvPeer3OldService peer3Service; 
	@Autowired Pl5GuilvSameOldService sameService;
 
	@Autowired Pl5GuilvSingleDoubleOldService gDoubleOLdService; 
	@Autowired Pl5GuilvRemoveCountService cocuntService; 
	@Autowired private Pl5GuilvRemoveConditionService conditionService; 
	
	@Autowired private Pl5PlanService planService;

	@Autowired private NewPlanService newPlanService;
	List<Pl5Guilv> guilvs=new ArrayList<Pl5Guilv>();
	List<Pl5GuilvPeerOld> peerOlds=new ArrayList<Pl5GuilvPeerOld>();
	List<Pl5GuilvPeer3Old> peer3Olds=new ArrayList<Pl5GuilvPeer3Old>();
	List<Pl5GuilvSingleDoubleOld> singleDoubleOlds=new ArrayList<Pl5GuilvSingleDoubleOld>();
	List<Pl5GuilvScopeOld> scopes=new ArrayList<Pl5GuilvScopeOld>();
	List<Pl5GuilvSameOld> sames=new ArrayList<Pl5GuilvSameOld>();
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
	 * 
	 */
	private void execute(String by) {
   
	 
		
		try{
			List<Pl5Lottery> lotteries =oldValue();
			Pl5Lottery lottery=lotteries.get(0);
			long qi=lottery.getQi();
          // System.out.println("开始："+UtilDate.getDateFormatter());
			guilv(lotteries, qi, lottery);
			//   System.out.println("结束："+UtilDate.getDateFormatter());
			qi=qi+1;
			
			List<Pl5GuilvRemoveCount> removes=this.cocuntService.findList("qi", qi);
			 
			
			
			List<Pl5GuilvRemoveCount> counts=new ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> counts2=new ArrayList<Pl5GuilvRemoveCount>();
			if(removes!=null){
				for(Pl5GuilvRemoveCount g:removes){
					if(g.getGui()!=6){
						if(g.getRemove()==0){
							counts.add(g);
						}else{
							counts2.add(g);
						}	
					}

				}
				ComparatorPl5GuilvRemoveCount2 guilv = new ComparatorPl5GuilvRemoveCount2();

				Collections.sort(counts, guilv);
				
				ComparatorPl5GuilvRemoveCount guilv2 = new ComparatorPl5GuilvRemoveCount();

				Collections.sort(counts2, guilv2); 	
			}
			
			
		
		     	 StringBuffer sBuffer1=new StringBuffer();  
				StringBuffer sBuffer2=new StringBuffer(); 
				StringBuffer sBuffer3=new StringBuffer();   
				StringBuffer sBuffer4=new StringBuffer();  
				StringBuffer sBuffer5=new StringBuffer();  
				
				for(int type=0;type<4;type++){
					  
					if(type==0){  
						setStringBuffer( type, sBuffer1, counts, counts2, lotteries); 
					}else if(type==1){  
						setStringBuffer( type, sBuffer2, counts, counts2, lotteries); 
						 
					}else if(type==2){  
						setStringBuffer(type, sBuffer3, counts, counts2, lotteries); 
					}else if(type==3){ 
						setStringBuffer( type, sBuffer4, counts, counts2, lotteries); 
					}else if(type==4){ 
						setStringBuffer( type, sBuffer5, counts, counts2, lotteries); 
						} 
				}
				newPlan(qi, sBuffer1, sBuffer2, sBuffer3, sBuffer4);
				//  System.out.println("开始2："+UtilDate.getDateFormatter());
				 
				setplan1(qi, sBuffer1, sBuffer4);
				setplan2(qi, sBuffer1, sBuffer4);
				setplan3(qi, sBuffer1, sBuffer2, sBuffer3, sBuffer4);
				setplan4(qi, sBuffer1, sBuffer2, sBuffer3, sBuffer4); 
				
				 // System.out.println("结束2："+UtilDate.getDateFormatter());
			
		  
			
		}catch (Exception e) {
		   e.printStackTrace(); 
		}
		
		 
	}
 
	
 
	
	
	
 
	private void     newPlan(long qi, StringBuffer sBuffer1,StringBuffer sBuffer2,StringBuffer sBuffer3,StringBuffer sBuffer4){
		 NewPlan newPlan=this.newPlanService.findPlan(qi, 1); 
		 if(newPlan!=null){
			 if(StringUtils.isNotEmpty(newPlan.getNumber1())){
				 newPlanBuffer(newPlan.getNumber1(),sBuffer1);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber2())){
				 newPlanBuffer(newPlan.getNumber2(),sBuffer2);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber3())){
				 newPlanBuffer(newPlan.getNumber3(),sBuffer3);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber4())){
				  newPlanBuffer(newPlan.getNumber4(),sBuffer4);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber5())){
				 delnewPlanBuffer(newPlan.getNumber5(),sBuffer1);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber6())){
				 delnewPlanBuffer(newPlan.getNumber6(),sBuffer2);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber7())){
				 delnewPlanBuffer(newPlan.getNumber7(),sBuffer3);
			 }
			 if(StringUtils.isNotEmpty(newPlan.getNumber8())){
				 delnewPlanBuffer(newPlan.getNumber8(),sBuffer4);
			 }
			 
			 
		 }
	 }
		
	 
	 
	 private void delnewPlanBuffer(String vlaue,StringBuffer sBuffer){
		 StringBuffer sb=new StringBuffer();
		 sb.append(vlaue);
		 for(int i=0;i<sBuffer.length();i++){
			 if(!sb.toString().contains(sBuffer.subSequence(i, i+1).toString())){
				 
				sb.append(sBuffer.subSequence(i, i+1).toString());
			 }
		 }
		   
		 sBuffer.delete(0, sBuffer.length());
		 sBuffer.append(sb.toString());
		 
	 }
	 
	 
	 private void newPlanBuffer(String vlaue,StringBuffer sBuffer){
		 StringBuffer sb=new StringBuffer();
		 for(int i=0;i<sBuffer.length();i++){
			 if(!vlaue.contains(sBuffer.subSequence(i, i+1).toString())){
				 
				sb.append(sBuffer.subSequence(i, i+1).toString());
			 }
		 }
		 sBuffer.delete(0, sBuffer.length());
		 sBuffer.append(sb.toString());

		 
	 }
 
	
	
 
 
 
 
	
	
 
	
	
	
	
	 private void setplan4(long qi,StringBuffer sBuffer1, StringBuffer sBuffer2,StringBuffer sBuffer3,StringBuffer sBuffer4){
		 try{
			 if(sBuffer1.length()>=4&&sBuffer2.length()>=4&&sBuffer3.length()>=4&&sBuffer4.length()>=4){
				 
				 Pl5Plan plan=this.planService.findPlan(qi, 4);
						if(plan==null){
							plan=new Pl5Plan(); 	
				plan.setNumber1(values(sBuffer1.subSequence(0,4).toString()));
				plan.setNumber2(values(sBuffer2.subSequence(0,4).toString()));
				plan.setNumber3(values(sBuffer3.subSequence(0,4).toString()));
				plan.setNumber4(values(sBuffer4.subSequence(0,4).toString()));
				plan.setQi(qi);
				plan.setType(4);
				this.planService.savePlan(plan);
						}
			 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	
	 private void setplan3(long qi,StringBuffer sBuffer1, StringBuffer sBuffer2,StringBuffer sBuffer3,StringBuffer sBuffer4){
		 try{
			 if(sBuffer1.length()>=3&&sBuffer2.length()>=3&&sBuffer3.length()>=3&&sBuffer4.length()>=3){
				 
				 Pl5Plan plan=this.planService.findPlan(qi, 3);
						if(plan==null){
							plan=new Pl5Plan(); 	
				plan.setNumber1(values(sBuffer1.subSequence(0,3).toString()));
				plan.setNumber2(values(sBuffer2.subSequence(0,3).toString()));
				plan.setNumber3(values(sBuffer3.subSequence(0,3).toString()));
				plan.setNumber4(values(sBuffer4.subSequence(0,3).toString()));
				plan.setQi(qi);
				plan.setType(3);
				this.planService.savePlan(plan);
						}
			 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	 private void setplan2(long qi,StringBuffer sBuffer1, StringBuffer sBuffer4){
		 try{
			 if(sBuffer1.length()>=4&&sBuffer4.length()>=4){
				 
				 Pl5Plan plan=this.planService.findPlan(qi, 2);
						if(plan==null){
							plan=new Pl5Plan(); 	
				 
				plan.setNumber1(values(sBuffer1.subSequence(0,4).toString()));
				plan.setNumber4(values(sBuffer4.subSequence(0,4).toString()));
				plan.setQi(qi);
				plan.setType(2);
				this.planService.savePlan(plan);
						}
			 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
	 }
	
	
	 private void setplan1(long qi,StringBuffer sBuffer1, StringBuffer sBuffer4){
		 try{
			 
			 
			 if(sBuffer1.length()>=3&&sBuffer4.length()>=3){
				 
				 Pl5Plan plan=this.planService.findPlan(qi, 1);
						if(plan==null){
							plan=new Pl5Plan(); 	
				plan.setNumber1(values(sBuffer1.subSequence(0,3).toString()));
				plan.setNumber4(values(sBuffer4.subSequence(0,3).toString()));
				plan.setQi(qi);
				plan.setType(1);
				this.planService.savePlan(plan);
						}
			 } 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	 private String values(String value){
	 
		 StringBuffer sb=new StringBuffer();
		 
		 for(int i=0;i<10;i++){
			 if(!value.contains(i+"")){
				 sb.append(i+"");
			 }
			 
		 }
		 
		 return sb.toString();
	 }
	
	
	private void setStringBuffer(int type,StringBuffer sBuffer,List<Pl5GuilvRemoveCount> counts,List<Pl5GuilvRemoveCount> counts2,List<Pl5Lottery> lotteries){
		try{
			 
			List<Pl5GuilvRemoveCount> n1=new  ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> n2=new  ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> n3=new  ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> n4=new  ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> n5=new  ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> n6=new  ArrayList<Pl5GuilvRemoveCount>();
			List<Pl5GuilvRemoveCount> n0=new  ArrayList<Pl5GuilvRemoveCount>();
			for(Pl5GuilvRemoveCount g:counts){
				if(g.getNumber()==1){
					n1.add(g);
				}else if(g.getNumber()==0){
					n0.add(g);
				}else if(g.getNumber()==2){
					n2.add(g);
				}else if(g.getNumber()==3){
					n3.add(g);
				}else if(g.getNumber()==4){
					n4.add(g);
				}else if(g.getNumber()==5){
					n5.add(g);
				}else if(g.getNumber()==6){
					n6.add(g);
				}
			}
			 
			
			for(Pl5GuilvRemoveCount g:n1){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(Pl5GuilvRemoveCount g:n0){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(Pl5GuilvRemoveCount g:n2){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(Pl5GuilvRemoveCount g:n3){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(Pl5GuilvRemoveCount g:n4){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(Pl5GuilvRemoveCount g:n5){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(Pl5GuilvRemoveCount g:n6){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try{
			if(sBuffer.length()<6){
				List<Pl5GuilvRemoveCount> n1=new  ArrayList<Pl5GuilvRemoveCount>();
				List<Pl5GuilvRemoveCount> n2=new  ArrayList<Pl5GuilvRemoveCount>();
				List<Pl5GuilvRemoveCount> n3=new  ArrayList<Pl5GuilvRemoveCount>();
				List<Pl5GuilvRemoveCount> n4=new  ArrayList<Pl5GuilvRemoveCount>();
				List<Pl5GuilvRemoveCount> n5=new  ArrayList<Pl5GuilvRemoveCount>();
				List<Pl5GuilvRemoveCount> n6=new  ArrayList<Pl5GuilvRemoveCount>();
				List<Pl5GuilvRemoveCount> n0=new  ArrayList<Pl5GuilvRemoveCount>();
				for(Pl5GuilvRemoveCount g:counts2){
					if(g.getNumber()==1){
						n1.add(g);
					}else if(g.getNumber()==0){
						n0.add(g);
					}else if(g.getNumber()==2){
						n2.add(g);
					}else if(g.getNumber()==3){
						n3.add(g);
					}else if(g.getNumber()==4){
						n4.add(g);
					}else if(g.getNumber()==5){
						n5.add(g);
					}else if(g.getNumber()==6){
						n6.add(g);
					}
				}
				 
				
				for(Pl5GuilvRemoveCount g:n1){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(Pl5GuilvRemoveCount g:n0){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(Pl5GuilvRemoveCount g:n2){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(Pl5GuilvRemoveCount g:n3){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(Pl5GuilvRemoveCount g:n4){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(Pl5GuilvRemoveCount g:n5){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(Pl5GuilvRemoveCount g:n6){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try{
			if(sBuffer.length()<6){ 
				for(Pl5Guilv g:guilvs){ 
					if(g.getType()==type){
						 String value="";
						 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
						 String[] s=string.split(",");
						 int sum=0;
						for(int i=0;i<s.length;i=i+2){
							sum=sum+sum(lotteries, Integer.parseInt(s[i].trim())-1, Integer.parseInt(s[i+1].trim()), null);
						}
						value=GuilvUtils.getSumValue(s(sum), g.getNumber());
						  
						setValue(sBuffer, value);
					}
				} 
				for(Pl5GuilvPeerOld g:peerOlds){ 
					if(g.getType()==type){
						 String value="";
						 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
						 String[] s=string.split(",");
						 int sum=0;
						for(int i=0;i<s.length;i=i+2){
							sum=sum+sum(lotteries, Integer.parseInt(s[i].trim())-1, Integer.parseInt(s[i+1].trim()), null);
						}
						value=GuilvUtils.getSumValue(s(sum), g.getNumber());
						  
						setValue(sBuffer, value);
					}
				}
				
				for(Pl5GuilvPeer3Old g:peer3Olds){ 
					if(g.getType()==type){
						 String value="";
						 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
						 String[] s=string.split(",");
						 int sum=0;
						for(int i=0;i<s.length;i=i+2){
							sum=sum+sum(lotteries, Integer.parseInt(s[i].trim())-1, Integer.parseInt(s[i+1].trim()), null);
						}
						value=GuilvUtils.getSumValue(s(sum), g.getNumber());
						  
						setValue(sBuffer, value);
					}
				} 
				for(Pl5GuilvSameOld g:sames){ 
					if(g.getType()==type){
						 String value="";
						 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
						 String[] s=string.split(",");
						 int sum=0;
						for(int i=0;i<s.length;i=i+2){
							sum=sum+sum(lotteries, Integer.parseInt(s[i].trim())-1, Integer.parseInt(s[i+1].trim()), null);
						}
						value=GuilvUtils.getSumValue(s(sum), g.getNumber());
						  
						setValue(sBuffer, value);
					}
				}
			}
				
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		
		
	
	}
	
	
	private  void  setValue(StringBuffer sBuffer,String value){
		
	 
		 for(int i=0;i<value.length();i++){
			String v=(String) value.subSequence(i, i+1);
			 if(sBuffer.indexOf(v)==-1){
					sBuffer.append(v);
					
				}
		 }
		  
	}
	
 
	
	private void guilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		Pl5Guilv(lotteries, qi, lottery);
		peerGuilv(lotteries, qi, lottery);
		sameGuilv(lotteries, qi, lottery);
		//peer3Guilv(lotteries, qi, lottery);
		singleDoubleGuilv(lotteries, qi, lottery);
		scopeGuilv(lotteries, qi, lottery);
		
		
	}
	
	
	private void sameGuilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		try{
			sames=new ArrayList<Pl5GuilvSameOld>();
			for(int type=0;type<4;type++){
				PageView<Pl5GuilvSameOld> pageViewGuilv = new PageView<Pl5GuilvSameOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(sameService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(Pl5GuilvSameOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					Pl5GuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 12);
						 int num=10;
					     if(type==0){
	                         num=lottery.getNumber1();
						 }else if(type==1){
							 num=lottery.getNumber2(); 
						 }else if(type==2){
							 num=lottery.getNumber3(); 
						 }else if(type==3){
							 num=lottery.getNumber4(); 
						 }else if(type==4){
							 num=lottery.getNumber5(); 
						 }
						 
						 if(g.getValue().contains(num+"")){
							 boolean cr=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
							 if(cr){
								 
								 flag=true; 
							 }
							 
						 }else{
							 if(g.getNumber()<=2){
								 sames.add(g);
							 }
						 }
						 
						 if(flag){
							 String value="";
							 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
							 String[] s=string.split(",");
							 int sum=0;
							 String qu = "";
						        
								for(int i=0;i<s.length;i=i+2){
									try{
										int s1 = Integer.parseInt(s[i].trim())-1;

										int v1 = Integer.parseInt(s[i+1].trim());
										String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


										qu = qu + ve;
									
										sum=sum+sum(lotteries, s1, v1, null);	
									}catch (Exception e) {
										 flag=false;
									}
									
									
								}
								
								qu=qu.substring(0,qu.length()-1);
								if(g.getFixation()==0){
									string ="判断条件为：" + qu+"";
								 
								}else{
									string ="判断条件为：" + g.getFixation() + "+" + qu+"";
									 
											 
								}
								g.setQueryValue(string); 
							 
							g.setValue(Pl5LotteryGuilvSameUtils.values(Integer.parseInt(g.getNumber_type()), g.getNumber(), s(sum+g.getFixation())));
							g.setQi(g.getQi()+1);
							g.setSum(g.getSum()+1);
							g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
							
							
							
							if(flag){
								Pl5LotteryGuilvSameUtils.guilvRemove(g, conditions,cocuntService,conditionService);	
							}
							
						 }
						  
					 }
				}
				
				  //System.out.println("eeeedddd55");	
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	
	
	
	private void scopeGuilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		try{
			for(int type=0;type<4;type++){
				PageView<Pl5GuilvScopeOld> pageViewGuilv = new PageView<Pl5GuilvScopeOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(guilvScopeOldService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(Pl5GuilvScopeOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					Pl5GuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 2);
						 int num=10;
					     if(type==0){
	                         num=lottery.getNumber1();
						 }else if(type==1){
							 num=lottery.getNumber2(); 
						 }else if(type==2){
							 num=lottery.getNumber3(); 
						 }else if(type==3){
							 num=lottery.getNumber4(); 
						 }else if(type==4){
							 num=lottery.getNumber5(); 
						 }
						 
						 if(g.getValue().contains(num+"")){
							 boolean cr=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
							 if(cr){
								 
								 flag=true; 
							 }
							 
						 }
						 
						 if(flag){
							 String value="";
							 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
							 String[] s=string.split(",");
							 int sum=0;
							 String qu = "";
						        
								for(int i=0;i<s.length;i=i+2){
									try{
										int s1 = Integer.parseInt(s[i].trim())-1;

										int v1 = Integer.parseInt(s[i+1].trim());
										String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


										qu = qu + ve;
									
										sum=sum+sum(lotteries, s1, v1, null);
									}catch (Exception e) {
										flag=false;
									}
								
									
								}
								
								qu=qu.substring(0,qu.length()-1);
								if(g.getFixation()==0){
									string ="判断条件为：" + qu+"";
								 
								}else{
									string ="判断条件为：" + g.getFixation() + "+" + qu+"";
									 
											 
								}
								g.setQueryValue(string);
							value=GuilvScUtils.getSumValue(s(sum+g.getFixation()), g.getNumber());
							 
							g.setValue(value);
							g.setQi(g.getQi()+1);
							g.setSum(g.getSum()+1);
							g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
							if(flag){
								Pl5LotteryGuilvScopeUtils.guilvRemove(g, conditions,cocuntService,conditionService);
							}
							
						 }
						  
					 }
				}
				
				 // System.out.println("eeeedddd44");	
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	
	
	private void singleDoubleGuilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		try{
			for(int type=0;type<4;type++){
				PageView<Pl5GuilvSingleDoubleOld> pageViewGuilv = new PageView<Pl5GuilvSingleDoubleOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(gDoubleOLdService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(Pl5GuilvSingleDoubleOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					Pl5GuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3);
						 int num=10;
					     if(type==0){
	                         num=lottery.getNumber1();
						 }else if(type==1){
							 num=lottery.getNumber2(); 
						 }else if(type==2){
							 num=lottery.getNumber3(); 
						 }else if(type==3){
							 num=lottery.getNumber4(); 
						 }else if(type==4){
							 num=lottery.getNumber5(); 
						 }
						 
						 if(g.getValue().contains(num+"")){
							 boolean cr=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
							 if(cr){
								 
								 flag=true; 
							 }
							 
						 }
						 
						 if(flag){
							 String value="";
							 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
							 String[] s=string.split(",");
							 int sum=0;
							 String qu = "";
					        
							for(int i=0;i<s.length;i=i+2){
								try{
									int s1 = Integer.parseInt(s[i].trim())-1;

									int v1 = Integer.parseInt(s[i+1].trim());
									String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


									qu = qu + ve;
								
									sum=sum+sum(lotteries, s1, v1, null);	
								}catch (Exception e) {
									flag=false;
								}
								
								
							}
							
							qu=qu.substring(0,qu.length()-1);
							if(g.getFixation()==0){
								string ="判断条件为：" + qu+"";
							 
							}else{
								string ="判断条件为：" + g.getFixation() + "+" + qu+"";
								 
										 
							}
							g.setQueryValue(string);
							value=GuilvSingleDoubleUtils.getSumValue(s(sum+g.getFixation()), g.getNumber());
							 
							g.setValue(value);
							g.setQi(g.getQi()+1);
							g.setSum(g.getSum()+1);
							
							g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
							if(flag){
								Pl5LotteryGuilvSingleDoubleUtils.guilvRemove(g, conditions,cocuntService,conditionService);	
							}
							
						 }
						  
					 }
				}
				
				 // System.out.println("eeeedddd33");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	
/*	private void peer3Guilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		peer3Olds=new ArrayList<Pl5GuilvPeer3Old>();
		for(int type=0;type<=4;type++){
			PageView<Pl5GuilvPeer3Old> pageViewGuilv = new PageView<Pl5GuilvPeer3Old>();
			pageViewGuilv.setOrderby("sum", "desc");
			pageViewGuilv.setQueryResult(peer3Service.findList(pageViewGuilv,getList(qi,type)));	
			 
			for(Pl5GuilvPeer3Old g:pageViewGuilv.getRecords()){
				boolean flag=false;
				 if(g.getQi()==qi){
				Pl5GuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1);
					 int num=10;
				     if(type==0){
                         num=lottery.getNumber1();
					 }else if(type==1){
						 num=lottery.getNumber2(); 
					 }else if(type==2){
						 num=lottery.getNumber3(); 
					 }else if(type==3){
						 num=lottery.getNumber4(); 
					 }else if(type==4){
						 num=lottery.getNumber5(); 
					 }
					 
					 if(g.getValue().contains(num+"")){
						 boolean cr=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
						 if(cr){
							 
							 flag=true; 
						 }
						 
					 }else{
						 if(g.getNumber()<=2){
							 peer3Olds.add(g);
						 }
					 }
					 
					 if(flag){
						 String value="";
						 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
						 String[] s=string.split(",");
						 int sum=0;
						 String qu = "";
				            String qu2="";
						for(int i=0;i<s.length;i=i+2){
							int s1 = Integer.parseInt(s[i].trim())-1;

							int v1 = Integer.parseInt(s[i+1].trim());
							String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


							qu = qu + ve;
						
							sum=sum+sum(lotteries, s1, v1, null);
						}
						
						
						
						value=GuilvUtils.getSumValue(s(sum), g.getNumber());
						 
						g.setValue(value);
						g.setQi(g.getQi()+1);
						g.setSum(g.getSum()+1);
						 g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
						Pl5LotteryPeer3Utils.guilvRemove(g, conditions,cocuntService,conditionService);
					 }
					  
				 }
			}
			
			
		}	
	}*/
	
	private String stypeString(int type){
		String stypeString = "";
		   
		if (type == 0) {
			stypeString = "头";
			 
		} else if (type == 1) {
			stypeString = "百"; 
		} else if (type == 2) {
			stypeString = "十"; 
		} else if (type == 3) {
			stypeString = "尾"; 
		}else if (type == 4) {
			stypeString = "个"; 
		}
	   return stypeString;
	}
 
	private void peerGuilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		try{
			peerOlds=new ArrayList<Pl5GuilvPeerOld>();
			for(int type=0;type<4;type++){
				PageView<Pl5GuilvPeerOld> pageViewGuilv = new PageView<Pl5GuilvPeerOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(peerService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(Pl5GuilvPeerOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					Pl5GuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 4);
						 int num=10;
					     if(type==0){
	                         num=lottery.getNumber1();
						 }else if(type==1){
							 num=lottery.getNumber2(); 
						 }else if(type==2){
							 num=lottery.getNumber3(); 
						 }else if(type==3){
							 num=lottery.getNumber4(); 
						 }else if(type==4){
							 num=lottery.getNumber5(); 
						 }
						 
						 if(g.getValue().contains(num+"")){
							 boolean cr=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
							 if(cr){
								 
								 flag=true; 
							 }
							 
						 }else{
							 if(g.getNumber()<=2){
								 peerOlds.add(g);
							 }
						 }
						 
						 if(flag){
							 String value="";
							 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
							 String[] s=string.split(",");
							 int sum=0;
							 String qu = "";
					            String qu2="";
					            
							for(int i=0;i<s.length;i=i+2){
								try{
									int s1 = Integer.parseInt(s[i].trim())-1;

									int v1 = Integer.parseInt(s[i+1].trim());
									String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


									qu = qu + ve;
								
									sum=sum+sum(lotteries, s1, v1, null);
								}catch (Exception e) {
									flag=false;
								}
							
								
							}
							 String string2=g.getValueQueryNew().replaceAll("\\[", "").replaceAll("\\]", "");
							 String[] s2=string2.split(",");
							 int tempQu=0;
							for(int i=0;i<s2.length;i=i+2){
								try{
									int s1 = Integer.parseInt(s2[i].trim())-1;

									int v1 = Integer.parseInt(s2[i+1].trim());
									String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


									qu2 = qu2 + ve;
								
									tempQu=tempQu+sum(lotteries, s1, v1, null);	
								} catch (Exception e) {
									 
								}
								
								
							}
							
						   int 	temp2 = s(s(sum)+10)-s(tempQu);
						   int tnum = s(temp2);
							if(tnum<0){
								 BigInteger b = new BigInteger(tnum+"");
					                b = b.abs();
					                tnum=Integer.valueOf(b.toString());
							}
							qu=qu.substring(0,qu.length()-1);
							long newqi=g.getQi()+1;
							 String stypeString=stypeString(g.getType());
							String queryValue ="判断条件为：" + qu+"="+qu2+newqi+"期的"+stypeString+":"+GuilvPeerUtils.getSumValue(tnum, g.getNumber());
							
							value=GuilvPeerUtils.getSumValue(tnum, g.getNumber());
							 
							g.setValue(value);
							g.setQi(newqi);
							g.setSum(g.getSum()+1);
							g.setQueryValue(queryValue);
							g.setTypeVaule("本期的"+stypeString+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
							if(flag){
								Pl5LotteryPeerUtils.guilvRemove(g, conditions,cocuntService,conditionService);
							}
							
						 }
						  
					 }
				}
				
			   
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	

	
	
	
	private void Pl5Guilv(List<Pl5Lottery> lotteries,long qi,Pl5Lottery lottery){
		try{
			guilvs=new ArrayList<Pl5Guilv>();
			for(int type=0;type<4;type++){
				PageView<Pl5Guilv> pageViewGuilv = new PageView<Pl5Guilv>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(Pl5Guilv g:pageViewGuilv.getRecords()){
					
					boolean flag=false;
					 if(g.getQi()==qi){
					Pl5GuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1);
						 int num=10;
					     if(type==0){
	                         num=lottery.getNumber1();
						 }else if(type==1){
							 num=lottery.getNumber2(); 
						 }else if(type==2){
							 num=lottery.getNumber3(); 
						 }else if(type==3){
							 num=lottery.getNumber4(); 
						 }else if(type==4){
							 num=lottery.getNumber5(); 
						 }
						 
						 if(g.getValue().contains(num+"")){
							 boolean cr=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
							 if(cr){
								 
								 flag=true; 
							 }
							 
						 }else{
							 
							 if(g.getNumber()<=2){
								 guilvs.add(g); 
							 }
						 }
						 
						 if(flag){
							 String value="";
							 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
							 String[] s=string.split(",");
							 int sum=0;
							 String qu = "";
					            String qu2="";
					            
							for(int i=0;i<s.length;i=i+2){
								try{
									int s1 = Integer.parseInt(s[i].trim())-1;

									int v1 = Integer.parseInt(s[i+1].trim());
									String ve = Pl5LotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


									qu = qu + ve;
								
									sum=sum+sum(lotteries, s1, v1, null);	
								}catch (Exception e) {
									flag=false;
								}
							
								
							}
							
							qu=qu.substring(0,qu.length()-1);
							if(g.getFixation()==0){
								string ="判断条件为：" + qu+"";
							 
							}else{
								string ="判断条件为：" + g.getFixation() + "+" + qu+"";
								 
										 
							}
							
							value=GuilvUtils.getSumValue(s(sum+g.getFixation()), g.getNumber());
							 
							g.setValue(value);
							g.setQi(g.getQi()+1);
							g.setSum(g.getSum()+1);
							g.setQueryValue(string);
							g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
						if(flag){
							Pl5LotteryUtils.guilvRemove(g, conditions,cocuntService,conditionService);
						}
							
						 }
						  
					 }
					 
				}
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	
	
	
	private List<Pl5Lottery>  oldValue(){
		
		PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>(20,1);
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
	 
		List<Pl5Lottery> lotteries = pageView.getRecords();
	 
		return lotteries;
	}

 
	
	
	
	

	
	
	
	
	
	private List<PropertyFilter>   getList(long qi,int type){
	 
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
	 
		filtersnewses.add(new PropertyFilter("info", MatchType.NNULL, null));
		
		return filtersnewses;
	}
	
	
	private static int sum(List<Pl5Lottery> lotteries, int j, int type, StringBuffer sb) {
		int sum = 0;

		Integer[] l = { lotteries.get(j).getNumber1(),
				lotteries.get(j).getNumber2(), lotteries.get(j).getNumber3(),
				lotteries.get(j).getNumber4(), lotteries.get(j).getNumber5(),
				lotteries.get(j).getNumber6(), lotteries.get(j).getNumber7() };
		sum = l[type];
		if (sb != null) {
			if (sb.length() > 1) {
				sb.delete(0, sb.length());

			}
			sb.append(j).append(",").append(type);
		}

		return sum;
	}

	
	private static int s(int sum) {
        if(sum<0){
			sum=-sum;
		   }
		
		if (sum >= 10) {

			do {
				sum = sum - 10;
			} while (sum >= 10);

		}
		
		

		return sum;

	}
	
}
