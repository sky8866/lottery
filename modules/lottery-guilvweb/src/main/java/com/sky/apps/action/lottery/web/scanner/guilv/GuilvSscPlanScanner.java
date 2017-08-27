/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.entity.guilv.CqPlan;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.TjsscLottery;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.guilv.XjsscPlan;
import com.sky.modules.lottery.entity.guilv.TjsscPlan;  
import com.sky.modules.lottery.service.guilv.CqPlanService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
import com.sky.modules.lottery.service.guilv.TjsscLotteryService; 
import com.sky.modules.lottery.service.guilv.XjsscPlanService;
import com.sky.modules.lottery.service.guilv.TjsscPlanService;
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
import com.sky.modules.lottery.utils.guilv.Hangqing2Utils;
import com.sky.modules.lottery.utils.guilv.Hangqing3Utils;
import com.sky.modules.lottery.utils.guilv.Hangqing6Utils; 

 
 
@Component
public class GuilvSscPlanScanner {

	@Autowired
	private CqsscLotteryService lotteryService;
	
	@Autowired
	private XjsscLotteryService lottery3Service;
	@Autowired
	private TjsscLotteryService lottery6Service; 
	@Autowired private CqsscPlanService planService;
	@Autowired private XjsscPlanService plan2Service;
	@Autowired private TjsscPlanService plan4Service;
	
	@Autowired private CqPlanService cqPlanService;
	
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
	 
		 
		
		try{
			 
			  int qi=Hangqing2Utils.getHangqing2(lotteryService);
			
			
			  Long qi2=0l;
				try{
					 qi2=Hangqing3Utils.getHangqing2(lottery3Service); 	
				}catch (Exception e) {
					// TODO: handle exception
				}
				 try{
						if(qi2==0){
							Hangqing3Utils.getHangqing3(lottery3Service); 	
						} 
				 }catch (Exception e) {
					// TODO: handle exception
				}
		 
		 	
		 	 Long qi6=0l;	
				 
		 	 try{
		 		qi6=Hangqing6Utils.getHangqing3(lottery6Service); 
			 }catch (Exception e) {
				 try{
				 		qi6=Hangqing6Utils.getHangqing3(lottery6Service); 
					 }catch (Exception e2) {
						// TODO: handle exception
					}
			}
			  
			  
			PageView<CqsscLottery> pageView = new PageView<CqsscLottery>();
			pageView.setOrderby("qi", "desc");

			pageView.setQueryResult(lotteryService.findList(pageView, null));
	       
			List<CqsscLottery> lotteries = pageView.getRecords();
			setPlan2(qi,lotteries);
		 
			setPlanIGKbet();
		 	 
			 
			 
			   int b=3;
			    
			  
			    
		
		 	  
		 	
		 	
		 	
	
				
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
	}
	

	
	
	
	private void setPlanIGKbet(){
		
		List<CqPlan> cqplan=this.cqPlanService.findIntegers();
		for(CqPlan plan:cqplan){
			int qi=Integer.parseInt(plan.getQi()+"");
			CqsscLottery lottery2 =this.lotteryService.findReport("qi", qi);
			if(lottery2!=null){
				int co=0;
				int num=0;
				if(StringUtils.isNotEmpty(plan.getNumber1())){
					if(!plan.getNumber1().contains(lottery2.getNumber1()+"")){
						co++;
					}	
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber2())){
					if(!plan.getNumber2().contains(lottery2.getNumber2()+"")){
						co++;
					}
					num++;
				}
				if(StringUtils.isNotEmpty(plan.getNumber3())){
					if(!plan.getNumber3().contains(lottery2.getNumber3()+"")){
						co++;
					}
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber4())){
					if(!plan.getNumber4().contains(lottery2.getNumber4()+"")){
						co++;
					}
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber5())){
					if(!plan.getNumber5().contains(lottery2.getNumber5()+"")){
						co++;
					}	
					num++;
				}
				if(co==num){
					 
					plan.setPrize(1); 
				}else{
					 
					plan.setPrize(2);
				}
				StringBuffer sBuffera=new StringBuffer("");
				sBuffera.append(lottery2.getNumber1()+"");sBuffera.append(lottery2.getNumber2());
				sBuffera.append(lottery2.getNumber3());sBuffera.append(lottery2.getNumber4());sBuffera.append(lottery2.getNumber5());
				plan.setValue("["+sBuffera.toString()+"]");
				this.cqPlanService.updatePlan(plan);
			}
		
		}
	
		 
			 
			List<CqsscPlan> plans=this.planService.findIntegers();
			for(CqsscPlan plan:plans){
				
				CqsscLottery lottery2 =this.lotteryService.findReport("qi", plan.getQi());
				
				if(lottery2!=null){
					int co=0;
					int num=0;
					if(plan.getType()!=16||plan.getType()!=17){
						
						if(StringUtils.isNotEmpty(plan.getNumber1())){
							if(!plan.getNumber1().contains(lottery2.getNumber1()+"")){
								co++;
							}	
							num++;
						}
						
						if(StringUtils.isNotEmpty(plan.getNumber2())){
							if(!plan.getNumber2().contains(lottery2.getNumber2()+"")){
								co++;
							}
							num++;
						}
						if(StringUtils.isNotEmpty(plan.getNumber3())){
							if(!plan.getNumber3().contains(lottery2.getNumber3()+"")){
								co++;
							}
							num++;
						}
						
						if(StringUtils.isNotEmpty(plan.getNumber4())){
							if(!plan.getNumber4().contains(lottery2.getNumber4()+"")){
								co++;
							}
							num++;
						}
						
						if(StringUtils.isNotEmpty(plan.getNumber5())){
							if(!plan.getNumber5().contains(lottery2.getNumber5()+"")){
								co++;
							}	
							num++;
						}
					
					}else{
						if(lottery2.getNumber1()!=lottery2.getNumber2()&&StringUtils.isNotEmpty(plan.getNumber1())){
							if(!plan.getNumber1().contains(lottery2.getNumber1()+"")){
								co++;
							}
							if(!plan.getNumber1().contains(lottery2.getNumber2()+"")){
								co++;
							}
						 
						}
						
						if(lottery2.getNumber4()!=lottery2.getNumber5()&&StringUtils.isNotEmpty(plan.getNumber3())){
							if(!plan.getNumber3().contains(lottery2.getNumber4()+"")){
								co++;
							}
							if(!plan.getNumber3().contains(lottery2.getNumber5()+"")){
								co++;
							}
							
						}
						num=2;
					}
						
					
					 
					if(co==num){
						plan.setPrize1(plan.getPrize1()+1);
						plan.setCountNum(plan.getCountNum()+1);
						
						if(plan.getCountNum()>plan.getCountMin()){
							plan.setCountMin(plan.getCountNum());
						}
						plan.setPrize(1);
						plan.setErrorNum(0);
					}else{
						plan.setErrorNum(plan.getErrorNum()+1);
						if(plan.getErrorNum()>plan.getErrorMin()){
							plan.setErrorMin(plan.getErrorNum());
						}
						plan.setCountNum(0);
						plan.setPrize(2);
					}
				 
					StringBuffer sBuffera=new StringBuffer("");
					sBuffera.append(lottery2.getNumber1()+"");sBuffera.append(lottery2.getNumber2());
					sBuffera.append(lottery2.getNumber3());sBuffera.append(lottery2.getNumber4());sBuffera.append(lottery2.getNumber5());
					plan.setNumber6("["+sBuffera.toString()+"]");
					plan.setType2(1);
					this.planService.updatePlan(plan);	 
				 
			}
		}
	
		 
			List<XjsscPlan> plans2=this.plan2Service.findIntegers();
			for(XjsscPlan plan:plans2){
				XjsscLottery l3 =this.lottery3Service.findReport("qi", plan.getQi());
				if(l3!=null){
				int co=0;
				int num=0;
				if(StringUtils.isNotEmpty(plan.getNumber1())){
					if(!plan.getNumber1().contains(l3.getNumber1()+"")){
						co++;
					}	
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber2())){
					if(!plan.getNumber2().contains(l3.getNumber2()+"")){
						co++;
					}
					num++;
				}
				if(StringUtils.isNotEmpty(plan.getNumber3())){
					if(!plan.getNumber3().contains(l3.getNumber3()+"")){
						co++;
					}
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber4())){
					if(!plan.getNumber4().contains(l3.getNumber4()+"")){
						co++;
					}
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber5())){
					if(!plan.getNumber5().contains(l3.getNumber5()+"")){
						co++;
					}	
					num++;
				}
				if(co==num){
					plan.setPrize1(plan.getPrize1()+1);
					plan.setCountNum(plan.getCountNum()+1);
					
					if(plan.getCountNum()>plan.getCountMin()){
						plan.setCountMin(plan.getCountNum());
					}
					//plan.setType3(0);
					plan.setErrorNum(0);
				}else{
					plan.setErrorNum(plan.getErrorNum()+1);
					if(plan.getErrorNum()>plan.getErrorMin()){
						plan.setErrorMin(plan.getErrorNum());
					}
					plan.setCountNum(0);
					
				}
			 
				StringBuffer sBuffera=new StringBuffer("");
				sBuffera.append(l3.getNumber1()+"");sBuffera.append(l3.getNumber2());
				sBuffera.append(l3.getNumber3());sBuffera.append(l3.getNumber4());sBuffera.append(l3.getNumber5());
				plan.setNumber6("["+sBuffera.toString()+"]");
				plan.setType2(1);
				this.plan2Service.updatePlan(plan);
				 
			}
		}

	 
			List<TjsscPlan> plans4=this.plan4Service.findIntegers();
			for(TjsscPlan plan:plans4){
				TjsscLottery l6 =this.lottery6Service.findReport("qi", plan.getQi());
				if(l6!=null){
				int co=0;
				int num=0;
				if(StringUtils.isNotEmpty(plan.getNumber1())){
					if(!plan.getNumber1().contains(l6.getNumber1()+"")){
						co++;
					}	
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber2())){
					if(!plan.getNumber2().contains(l6.getNumber2()+"")){
						co++;
					}
					num++;
				}
				if(StringUtils.isNotEmpty(plan.getNumber3())){
					if(!plan.getNumber3().contains(l6.getNumber3()+"")){
						co++;
					}
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber4())){
					if(!plan.getNumber4().contains(l6.getNumber4()+"")){
						co++;
					}
					num++;
				}
				
				if(StringUtils.isNotEmpty(plan.getNumber5())){
					if(!plan.getNumber5().contains(l6.getNumber5()+"")){
						co++;
					}	
					num++;
				}
				if(co==num){
					plan.setPrize1(plan.getPrize1()+1);
					plan.setCountNum(plan.getCountNum()+1);
					
					if(plan.getCountNum()>plan.getCountMin()){
						plan.setCountMin(plan.getCountNum());
					}
					//plan.setType3(0);
					plan.setErrorNum(0);
				}else{
					plan.setErrorNum(plan.getErrorNum()+1);
					if(plan.getErrorNum()>plan.getErrorMin()){
						plan.setErrorMin(plan.getErrorNum());
					}
					plan.setCountNum(0);
					
				}
			 
				StringBuffer sBuffera=new StringBuffer("");
				sBuffera.append(l6.getNumber1()+"");sBuffera.append(l6.getNumber2());
				sBuffera.append(l6.getNumber3());sBuffera.append(l6.getNumber4());sBuffera.append(l6.getNumber5());
				plan.setNumber6("["+sBuffera.toString()+"]");
				plan.setType2(1);
				this.plan4Service.updatePlan(plan);
				 
			}	
		}
		

		
		
		
	}
	 
	
 
	
	private void setPlan2(int qi,List<CqsscLottery> lotteries){

		CqsscPlan plan2=this.planService.findPlan(qi+1,2);
		
		
		if(plan2==null){
		
		CqsscPlan plan=this.planService.findPlan(2);
		 
		 
		
		 
	 
		

	
		
		  plan2=new CqsscPlan();
			 
			 
			
			
			
			
			for(int type=0;type<=4;type++){
				
				if(type==0){
					 
					
					plan2.setNumber1(s(sum(lotteries, 0, 1, null)+sum(lotteries, 1, 1, null)+sum(lotteries, 1, 1, null))+"");
				}else if(type==1){
					
				 
					
					plan2.setNumber2(s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 0, null)+sum(lotteries, 1, 3, null))+"");
				}else if(type==2){
					
				 
					
					plan2.setNumber3(s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 3, null)+sum(lotteries, 0, 3, null))+"");
				}else if(type==3){
					 
					plan2.setNumber4(s(sum(lotteries, 0, 4, null)+sum(lotteries, 0, 4, null)+sum(lotteries, 1, 3, null))+"");
				}else if(type==4){ 
					plan2.setNumber5(s(sum(lotteries, 0, 2, null)+sum(lotteries, 1, 3, null)+sum(lotteries, 1, 3, null))+"");
				}
				
				
			
			}
			
			if(plan!=null){
				if(plan.getErrorNum()!=0){
					plan2.setType3(1);
				}
					 
					plan2.setQi(qi+1);
					plan2.setType(2);
					
						plan2.setErrorMin(plan.getErrorMin());
						plan2.setCountNum(plan.getCountNum());
						plan2.setCountMin(plan.getCountMin());
					    plan2.setErrorNum(plan.getErrorNum());	
					    plan2.setPrize1(plan.getPrize1());
					
					this.planService.savePlan(plan2);
					 	
			}else{
				plan2.setQi(qi+1);
				plan2.setType(2);
				  
				this.planService.savePlan(plan2);
			}
			
			
		}
		
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
		if (sum >= 10) {

			do {
				sum = sum - 10;
			} while (sum >= 10);

		}

		return sum;

	}
	


	
	

	
	
	
	
	 
	
}
