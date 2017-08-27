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

import com.sky.apps.action.lottery.web.utils.guilv.CqGuilvRemoveConditionUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvSameUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvScopeUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryPeer3Utils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.GuilvPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.GuilvScUtils;
import com.sky.apps.action.lottery.web.utils.guilv.GuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.GuilvUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqGuilvRemoveCount;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqGuilvRemoveCount2; 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.lottery.entity.guilv.CqGuilv;
import com.sky.modules.lottery.entity.guilv.CqGuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.CqGuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCondition; 
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.CqGuilvSameOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvScopeOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.CqPlan;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv; 
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.service.guilv.CqGuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.CqGuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqGuilvSameOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvScopeOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvService;
import com.sky.modules.lottery.service.guilv.CqGuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.CqPlanService; 
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;    



 

 
 
 
@Component
public class CqPlanGuilvScanner   {

	@Autowired
	private CqsscLotteryService lotteryService;

	@Autowired
	private CqGuilvService guilvService;
	 
	 
	@Autowired
	private CqGuilvScopeOldService guilvScopeOldService;
	
	@Autowired CqGuilvPeerOldService peerService;
	
	@Autowired CqGuilvPeer3OldService peer3Service; 
	@Autowired CqGuilvSameOldService sameService;
 
	@Autowired CqGuilvSingleDoubleOldService gDoubleOLdService; 
	@Autowired CqGuilvRemoveCountService cocuntService; 
	@Autowired private CqGuilvRemoveConditionService conditionService; 
	
	@Autowired private CqPlanService planService;
	@Autowired
	private CqsscGuilvService sscguilvService;
	
	List<CqGuilv> guilvs=new ArrayList<CqGuilv>();
	List<CqGuilvPeerOld> peerOlds=new ArrayList<CqGuilvPeerOld>();
	List<CqGuilvPeer3Old> peer3Olds=new ArrayList<CqGuilvPeer3Old>();
	List<CqGuilvSingleDoubleOld> singleDoubleOlds=new ArrayList<CqGuilvSingleDoubleOld>();
	List<CqGuilvScopeOld> scopes=new ArrayList<CqGuilvScopeOld>();
	List<CqGuilvSameOld> sames=new ArrayList<CqGuilvSameOld>();
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
			List<CqsscLottery> lotteries =oldValue();
			CqsscLottery lottery=lotteries.get(0);
			long qi=lottery.getQi();
          // System.out.println("开始："+UtilDate.getDateFormatter());
			guilv(lotteries, qi, lottery);
			//   System.out.println("结束："+UtilDate.getDateFormatter());
			qi=qi+1;
			
			List<CqGuilvRemoveCount> removes=this.cocuntService.findList("qi", qi);
			 
			
			
			List<CqGuilvRemoveCount> counts=new ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> counts2=new ArrayList<CqGuilvRemoveCount>();
			if(removes!=null){
				for(CqGuilvRemoveCount g:removes){
					if(g.getRemove()==0){
						counts.add(g);
					}else{
						counts2.add(g);
					}
				}
				ComparatorCqGuilvRemoveCount2 guilv = new ComparatorCqGuilvRemoveCount2();

				Collections.sort(counts, guilv);
				
				ComparatorCqGuilvRemoveCount guilv2 = new ComparatorCqGuilvRemoveCount();

				Collections.sort(counts2, guilv2); 	
			}
			
			
		
		     	 StringBuffer sBuffer1=new StringBuffer();  
				StringBuffer sBuffer2=new StringBuffer(); 
				StringBuffer sBuffer3=new StringBuffer();   
				StringBuffer sBuffer4=new StringBuffer();  
				StringBuffer sBuffer5=new StringBuffer();  
				for(int type=0;type<=4;type++){
					  
					if(type==0){  
						setStringBuffer(lottery.getQi(), type, sBuffer1, counts, counts2, lotteries); 
					}else if(type==1){  
						setStringBuffer(lottery.getQi(), type, sBuffer2, counts, counts2, lotteries); 
						 
					}else if(type==2){  
						setStringBuffer(lottery.getQi(), type, sBuffer3, counts, counts2, lotteries); 
					}else if(type==3){ 
						setStringBuffer(lottery.getQi(), type, sBuffer4, counts, counts2, lotteries); 
					}else if(type==4){ 
						setStringBuffer(lottery.getQi(), type, sBuffer5, counts, counts2, lotteries); 
						} 
				}
				
				//  System.out.println("开始2："+UtilDate.getDateFormatter());
				setplan11(qi, sBuffer1, sBuffer2, sBuffer3, sBuffer4, sBuffer5);
				setplan1(qi, sBuffer1, sBuffer2);
				setplan2(qi, sBuffer4, sBuffer5);
				setplan3(qi, sBuffer1, sBuffer5);
				setplan4(qi, sBuffer1);
				setplan5(qi, sBuffer2);
				setplan6(qi, sBuffer3);
				setplan7(qi, sBuffer4);
				setplan8(qi, sBuffer5);
				setplan9(qi, sBuffer1, sBuffer2, sBuffer3);
				setplan10(qi, sBuffer3, sBuffer4, sBuffer5);
				
				 // System.out.println("结束2："+UtilDate.getDateFormatter());
			
		  
			
		}catch (Exception e) {
		   e.printStackTrace(); 
		}
		
		 
	}
	
	public static void main(String[] args) {
		List<CqGuilvRemoveCount> guilvs=new ArrayList<CqGuilvRemoveCount>();
		CqGuilvRemoveCount g=new CqGuilvRemoveCount();
		g.setValue("123789");
		g.setSum(35);
		g.setSort(3);
		guilvs.add(g);
		g=new CqGuilvRemoveCount();
		g.setValue("345");
		g.setSum(15);
		g.setSort(1);
		guilvs.add(g);
		g=new CqGuilvRemoveCount();
		g.setValue("3");
		g.setSum(5);
		g.setSort(1);
		guilvs.add(g);
		g=new CqGuilvRemoveCount();
		g.setValue("83");
		g.setSum(8);
		g.setSort(2);
		guilvs.add(g);
		g=new CqGuilvRemoveCount();
		g.setValue("49");
		g.setSort(3);
		g.setSum(7);
		guilvs.add(g);
	 
		ComparatorCqGuilvRemoveCount2 guilv = new ComparatorCqGuilvRemoveCount2();

		Collections.sort(guilvs, guilv);
		
		for(CqGuilvRemoveCount c:guilvs){
			System.out.println("后："+c.getValue());
		}
		
	}
	
	
	
 private void setplan11(long qi,StringBuffer sBuffer1,StringBuffer sBuffer2,StringBuffer sBuffer3,StringBuffer sBuffer4,StringBuffer sBuffer5){
		 try{
			 CqPlan plan=this.planService.findPlan(qi,11);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer1.length()>=1&&sBuffer2.length()>=1&&sBuffer3.length()>=1&&sBuffer4.length()>=1&&sBuffer5.length()>=1){
						 plan.setNumber1(sBuffer1.subSequence(0,1).toString());   
						 plan.setNumber2(sBuffer2.subSequence(0,1).toString()); 
						plan.setNumber3(sBuffer3.subSequence(0,1).toString()); 
						plan.setNumber4(sBuffer4.subSequence(0,1).toString()); 
						plan.setNumber5(sBuffer5.subSequence(0,1).toString()); 
						plan.setQi(qi);
						plan.setType(11);
						this.planService.savePlan(plan);	
				}

		 } 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	
 private void setplan10(long qi,StringBuffer sBuffer3,StringBuffer sBuffer4,StringBuffer sBuffer5){
		 try{
			 CqPlan plan=this.planService.findPlan(qi, 10);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer3.length()>=3&&sBuffer4.length()>=3&&sBuffer5.length()>=3){
						  
						
						plan.setNumber3(sBuffer3.subSequence(0,2).toString()); 
						plan.setNumber4(sBuffer4.subSequence(0,2).toString()); 
						plan.setNumber5(sBuffer5.subSequence(0,2).toString()); 
						plan.setQi(qi);
						plan.setType(10);
						this.planService.savePlan(plan);	
				}

		 }
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
 private void setplan9(long qi,StringBuffer sBuffer1,StringBuffer sBuffer2,StringBuffer sBuffer3){
		 try{
			 CqPlan plan=this.planService.findPlan(qi, 9);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer1.length()>=3&&sBuffer2.length()>=3&&sBuffer3.length()>=3){
						  
						
						plan.setNumber1(sBuffer1.subSequence(0,2).toString()); 
						plan.setNumber2(sBuffer2.subSequence(0,2).toString()); 
						plan.setNumber3(sBuffer3.subSequence(0,2).toString()); 
						plan.setQi(qi);
						plan.setType(9);
						this.planService.savePlan(plan);	
				}

		 } 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	
 private void setplan8(long qi,StringBuffer sBuffer5){
		 try{
			 CqPlan plan=this.planService.findPlan(qi, 8);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer5.length()>=5){
						 String value=sBuffer5.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						
						plan.setNumber5(sb.toString()); 
						plan.setQi(qi);
						plan.setType(8);
						this.planService.savePlan(plan);	
				}

		 } 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
 private void setplan7(long qi,StringBuffer sBuffer4){
	 try{
		 CqPlan plan=this.planService.findPlan(qi, 7);
			if(plan==null){
				plan= new CqPlan(); 	
				 if(sBuffer4.length()>=5){
					 String value=sBuffer4.subSequence(0,5).toString();
					 StringBuffer sb=new StringBuffer();
					 for(int i=0;i<10;i++){
						 if(!value.contains(i+"")){
							 sb.append(i+"");
						 }
					 }
					
					plan.setNumber4(sb.toString()); 
					plan.setQi(qi);
					plan.setType(7);
					this.planService.savePlan(plan);	
			}

	 } 
	 }catch (Exception e) {
		// TODO: handle exception
	}

 }
 
 
 private void setplan6(long qi,StringBuffer sBuffer3){
		 try{
			 CqPlan plan=this.planService.findPlan(qi, 6);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer3.length()>=5){
						 String value=sBuffer3.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						
						plan.setNumber3(sb.toString()); 
						plan.setQi(qi);
						plan.setType(6);
						this.planService.savePlan(plan);	
				}

		 } 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
 private void setplan5(long qi,StringBuffer sBuffer2){
		 try{
			 CqPlan plan=this.planService.findPlan(qi, 5);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer2.length()>=5){
						 String value=sBuffer2.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						
						plan.setNumber2(sb.toString()); 
						plan.setQi(qi);
						plan.setType(5);
						this.planService.savePlan(plan);	
				}

		 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	
	
	 private void setplan4(long qi,StringBuffer sBuffer1){
		 try{
			 CqPlan plan=this.planService.findPlan(qi, 4);
				if(plan==null){
					plan= new CqPlan(); 	
					 if(sBuffer1.length()>=5){
						 String value=sBuffer1.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						
						plan.setNumber1(sb.toString()); 
						plan.setQi(qi);
						plan.setType(4);
						this.planService.savePlan(plan);	
				}

		 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	
	 private void setplan3(long qi,StringBuffer sBuffer1, StringBuffer sBuffer5){
		 try{
			 if(sBuffer1.length()>=3&&sBuffer5.length()>=3){
				 
				 CqPlan plan=this.planService.findPlan(qi, 3);
						if(plan==null){
							plan=new CqPlan(); 	
				plan.setNumber1(sBuffer1.subSequence(0,3).toString());
				plan.setNumber5(sBuffer5.subSequence(0,3).toString());
				plan.setQi(qi);
				plan.setType(3);
				this.planService.savePlan(plan);
						}
			 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	 private void setplan2(long qi,StringBuffer sBuffer4, StringBuffer sBuffer5){
		 try{
			 if(sBuffer4.length()>=3&&sBuffer5.length()>=3){
				 
				 CqPlan plan=this.planService.findPlan(qi, 2);
						if(plan==null){
							plan=new CqPlan(); 	
				 
				plan.setNumber4(sBuffer4.subSequence(0,3).toString());
				plan.setNumber5(sBuffer5.subSequence(0,3).toString());
				plan.setQi(qi);
				plan.setType(2);
				this.planService.savePlan(plan);
						}
			 }	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
	 }
	
	
	 private void setplan1(long qi,StringBuffer sBuffer1, StringBuffer sBuffer2){
		 try{
			 if(sBuffer1.length()>=3&&sBuffer2.length()>=3){
				 
				 CqPlan plan=this.planService.findPlan(qi, 1);
						if(plan==null){
							plan=new CqPlan(); 	
				plan.setNumber1(sBuffer1.subSequence(0,3).toString());
				plan.setNumber2(sBuffer2.subSequence(0,3).toString());
				plan.setQi(qi);
				plan.setType(1);
				this.planService.savePlan(plan);
						}
			 } 
		 }catch (Exception e) {
			// TODO: handle exception
		}

	 }
	
	
	
	private void setStringBuffer(int qi,int type,StringBuffer sBuffer,List<CqGuilvRemoveCount> counts,List<CqGuilvRemoveCount> counts2,List<CqsscLottery> lotteries){
		try{
			 
			List<CqGuilvRemoveCount> n1=new  ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> n2=new  ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> n3=new  ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> n4=new  ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> n5=new  ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> n6=new  ArrayList<CqGuilvRemoveCount>();
			List<CqGuilvRemoveCount> n0=new  ArrayList<CqGuilvRemoveCount>();
			for(CqGuilvRemoveCount g:counts){
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
			 
			
			for(CqGuilvRemoveCount g:n1){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(CqGuilvRemoveCount g:n0){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(CqGuilvRemoveCount g:n2){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(CqGuilvRemoveCount g:n3){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(CqGuilvRemoveCount g:n4){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(CqGuilvRemoveCount g:n5){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
			for(CqGuilvRemoveCount g:n6){
				if(g.getType()==type){
					setValue(sBuffer, g.getValue());
				}
			}
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try{
			if(sBuffer.length()<6){
				List<CqGuilvRemoveCount> n1=new  ArrayList<CqGuilvRemoveCount>();
				List<CqGuilvRemoveCount> n2=new  ArrayList<CqGuilvRemoveCount>();
				List<CqGuilvRemoveCount> n3=new  ArrayList<CqGuilvRemoveCount>();
				List<CqGuilvRemoveCount> n4=new  ArrayList<CqGuilvRemoveCount>();
				List<CqGuilvRemoveCount> n5=new  ArrayList<CqGuilvRemoveCount>();
				List<CqGuilvRemoveCount> n6=new  ArrayList<CqGuilvRemoveCount>();
				List<CqGuilvRemoveCount> n0=new  ArrayList<CqGuilvRemoveCount>();
				for(CqGuilvRemoveCount g:counts2){
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
				 
				
				for(CqGuilvRemoveCount g:n1){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(CqGuilvRemoveCount g:n0){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(CqGuilvRemoveCount g:n2){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(CqGuilvRemoveCount g:n3){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(CqGuilvRemoveCount g:n4){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(CqGuilvRemoveCount g:n5){
					if(g.getType()==type){
						setValue(sBuffer, g.getValue());
					}
				}
				for(CqGuilvRemoveCount g:n6){
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
				for(CqGuilv g:guilvs){ 
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
				for(CqGuilvPeerOld g:peerOlds){ 
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
				
				for(CqGuilvPeer3Old g:peer3Olds){ 
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
				for(CqGuilvSameOld g:sames){ 
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
	
		try{
			if(sBuffer.length()<6){
				 getValue(sBuffer,qi, type, sscguilvService, lotteries);	
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
	
 
	
	private void guilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		cqGuilv(lotteries, qi, lottery);
		peerGuilv(lotteries, qi, lottery);
		sameGuilv(lotteries, qi, lottery);
		//peer3Guilv(lotteries, qi, lottery);
		singleDoubleGuilv(lotteries, qi, lottery);
		scopeGuilv(lotteries, qi, lottery);
		
		
	}
	
	
	private void sameGuilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		try{
			sames=new ArrayList<CqGuilvSameOld>();
			for(int type=0;type<=4;type++){
				PageView<CqGuilvSameOld> pageViewGuilv = new PageView<CqGuilvSameOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(sameService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(CqGuilvSameOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					CqGuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 12);
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
							 boolean cr=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
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
										String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


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
							 
							g.setValue(CqLotteryGuilvSameUtils.values(Integer.parseInt(g.getNumber_type()), g.getNumber(), s(sum+g.getFixation())));
							g.setQi(g.getQi()+1);
							g.setSum(g.getSum()+1);
							g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
							
							
							
							if(flag){
								CqLotteryGuilvSameUtils.guilvRemove(g, conditions,cocuntService,conditionService);	
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
	
	
	
	
	
	private void scopeGuilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		try{
			for(int type=0;type<=4;type++){
				PageView<CqGuilvScopeOld> pageViewGuilv = new PageView<CqGuilvScopeOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(guilvScopeOldService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(CqGuilvScopeOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					CqGuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 2);
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
							 boolean cr=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
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
										String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


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
								CqLotteryGuilvScopeUtils.guilvRemove(g, conditions,cocuntService,conditionService);
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
	
	
	
	
	private void singleDoubleGuilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		try{
			for(int type=0;type<=4;type++){
				PageView<CqGuilvSingleDoubleOld> pageViewGuilv = new PageView<CqGuilvSingleDoubleOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(gDoubleOLdService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(CqGuilvSingleDoubleOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					CqGuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3);
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
							 boolean cr=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
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
									String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


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
								CqLotteryGuilvSingleDoubleUtils.guilvRemove(g, conditions,cocuntService,conditionService);	
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
	
	
	
/*	private void peer3Guilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		peer3Olds=new ArrayList<CqGuilvPeer3Old>();
		for(int type=0;type<=4;type++){
			PageView<CqGuilvPeer3Old> pageViewGuilv = new PageView<CqGuilvPeer3Old>();
			pageViewGuilv.setOrderby("sum", "desc");
			pageViewGuilv.setQueryResult(peer3Service.findList(pageViewGuilv,getList(qi,type)));	
			 
			for(CqGuilvPeer3Old g:pageViewGuilv.getRecords()){
				boolean flag=false;
				 if(g.getQi()==qi){
				CqGuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1);
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
						 boolean cr=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
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
							String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


							qu = qu + ve;
						
							sum=sum+sum(lotteries, s1, v1, null);
						}
						
						
						
						value=GuilvUtils.getSumValue(s(sum), g.getNumber());
						 
						g.setValue(value);
						g.setQi(g.getQi()+1);
						g.setSum(g.getSum()+1);
						 g.setTypeVaule("本期的"+stypeString(g.getType())+"为:"+g.getValue()+",已经连对："+g.getSum()+"期");
						CqLotteryPeer3Utils.guilvRemove(g, conditions,cocuntService,conditionService);
					 }
					  
				 }
			}
			
			
		}	
	}*/
	
	private String stypeString(int type){
		String stypeString = "";
		   
		if (type == 0) {
			stypeString = "万";
			 
		} else if (type == 1) {
			stypeString = "千"; 
		} else if (type == 2) {
			stypeString = "百"; 
		} else if (type == 3) {
			stypeString = "十"; 
		}else if (type == 4) {
			stypeString = "个"; 
		}
	   return stypeString;
	}
 
	private void peerGuilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		try{
			peerOlds=new ArrayList<CqGuilvPeerOld>();
			for(int type=0;type<=4;type++){
				PageView<CqGuilvPeerOld> pageViewGuilv = new PageView<CqGuilvPeerOld>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(peerService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(CqGuilvPeerOld g:pageViewGuilv.getRecords()){
					boolean flag=false;
					 if(g.getQi()==qi){
					CqGuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 4);
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
							 boolean cr=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
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
									String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


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
									String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


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
								CqLotteryPeerUtils.guilvRemove(g, conditions,cocuntService,conditionService);
							}
							
						 }
						  
					 }
				}
				
			   
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	

	
	
	
	private void cqGuilv(List<CqsscLottery> lotteries,long qi,CqsscLottery lottery){
		try{
			guilvs=new ArrayList<CqGuilv>();
			for(int type=0;type<=4;type++){
				PageView<CqGuilv> pageViewGuilv = new PageView<CqGuilv>();
				pageViewGuilv.setOrderby("sum", "desc");
				pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,getList(qi,type)));	
				 
				for(CqGuilv g:pageViewGuilv.getRecords()){
					
					boolean flag=false;
					 if(g.getQi()==qi){
					CqGuilvRemoveCondition conditions=	 conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1);
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
							 boolean cr=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum()+1);
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
					            
							for(int i=0;i<s.length;i=i+2){
								try{
									int s1 = Integer.parseInt(s[i].trim())-1;

									int v1 = Integer.parseInt(s[i+1].trim());
									String ve = CqLotteryPeer3Utils.getQueryValue(lotteries, s1, v1);


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
							CqLotteryUtils.guilvRemove(g, conditions,cocuntService,conditionService);
						}
							
						 }
						  
					 }
					 
				}
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	
	
	
	private List<CqsscLottery>  oldValue(){
		
		PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(20,1);
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
	 
		List<CqsscLottery> lotteries = pageView.getRecords();
	 
		return lotteries;
	}

 
	
	
	
	
	private static void getValue(StringBuffer sBuffer,int qi,int type,
			CqsscGuilvService guilvService,List<CqsscLottery> lotteries){
		
		String typeLottery="ssc";
		 
		int num=0;
		if(type==0){
			num=lotteries.get(0).getNumber1();
		}else if(type==1){
			num=lotteries.get(0).getNumber2();
		}else if(type==2){
			num=lotteries.get(0).getNumber3();
		}else if(type==3){
			num=lotteries.get(0).getNumber4();
		}else if(type==4){
			num=lotteries.get(0).getNumber5();
		}
		
		
		if(sBuffer.length()<6){
		
			List<CqsscGuilv> kills=guilvService.findLists(qi, num,type,typeLottery);
			for(CqsscGuilv g:kills){
				 String value="";
				 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
				 String[] s=string.split(",");
				 
						 
				if(g.getAddition()==3){
					
					   value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null)+sum(lotteries, Integer.parseInt(s[4].trim())-1, Integer.parseInt(s[5].trim()), null))+""; 	
					   
				}else{
					 value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null))+""; 	
				}
				
				if(sBuffer.indexOf(value)==-1){
					sBuffer.append(value);
					 
				} 
					
				 
			} 
		}
		  
		 
		if(sBuffer.length()<6){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, type,1,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<6){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, type,2,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		if(sBuffer.length()<6){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, type,3,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
 
		
	/*	if(sBuffer.length()<6){
		
			List<CqsscGuilv> kills=guilvService.findLists(qi-1, num,type,typeLottery);
			for(CqsscGuilv g:kills){
				 String value="";
				 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
				 String[] s=string.split(",");
				 
						 
				if(g.getAddition()==3){
					
					   value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null)+sum(lotteries, Integer.parseInt(s[4].trim())-1, Integer.parseInt(s[5].trim()), null))+""; 	
					   
				}else{
					 value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null))+""; 	
				}
				
				if(sBuffer.indexOf(value)==-1){
					sBuffer.append(value);
					 
				} 
					
				 
			} 
		}*/
  
/*		if(sBuffer.length()<6){
			
			List<CqsscGuilv> kills=guilvService.findLists(qi-2, num,type,typeLottery);
			for(CqsscGuilv g:kills){
				 String value="";
				 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
				 String[] s=string.split(",");
				 
						 
				if(g.getAddition()==3){
					
					   value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null)+sum(lotteries, Integer.parseInt(s[4].trim())-1, Integer.parseInt(s[5].trim()), null))+""; 	
					   
				}else{
					 value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null))+""; 	
				}
				
				if(sBuffer.indexOf(value)==-1){
					sBuffer.append(value);
					 
				} 
					
				 
			} 
		}
		*/
		
/*		if(sBuffer.length()<6){
			List<CqsscGuilv> kills=guilvService.findLists5(type, 5);
			for(CqsscGuilv g:kills){
				 String value="";
				 String string=g.getValueNew().replaceAll("\\[", "").replaceAll("\\]", "");
				 String[] s=string.split(",");
						 
				if(g.getAddition()==3){
					
					   value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null)+sum(lotteries, Integer.parseInt(s[4].trim())-1, Integer.parseInt(s[5].trim()), null))+""; 	
				}else{
					 value=	s(sum(lotteries, Integer.parseInt(s[0].trim())-1, Integer.parseInt(s[1].trim()), null)+sum(lotteries, Integer.parseInt(s[2].trim())-1, Integer.parseInt(s[3].trim()), null))+""; 	
				}
				
				if(sBuffer.indexOf(value)==-1){
					sBuffer.append(value);
					 
				} 
					
				 
			} 
		}*/
		
	 
		
	}
	
	
	
	
	
	private List<PropertyFilter>   getList(long qi,int type){
	 
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
	 
		filtersnewses.add(new PropertyFilter("info", MatchType.NNULL, null));
		
		return filtersnewses;
	}
	
	
	private static int sum(List<CqsscLottery> lotteries, int j, int type, StringBuffer sb) {
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
