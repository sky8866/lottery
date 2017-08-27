/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv;
 
import java.util.List; 
 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.sky.apps.action.lottery.web.job.guilv.QueryComm; 
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.entity.guilv.CqPlan;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.GuilvPlan;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Invest;
import com.sky.modules.lottery.entity.guilv.InvestSum;
import com.sky.modules.lottery.entity.guilv.Lottery; 
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.entity.guilv.QxcPlan;
import com.sky.modules.lottery.service.guilv.GuilvPlanService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;  
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;
import com.sky.modules.lottery.service.guilv.QxcPlanService;
import com.sky.modules.lottery.utils.guilv.Hangqing5Utils;
import com.sky.modules.lottery.utils.guilv.HangqingUtils;

 
 

@Service("TotterysScanner")
public class TotterysScanner  implements QueryComm   {

	@Autowired
	private LotteryService lotteryService;
 
	@Autowired private GuilvInvestSumService investSumService;
	@Autowired private GuilvInvestService investService;
	@Autowired private GuilvSumService guilvSumService;
	@Autowired GuilvRemoveCountService cocuntService;
	 @Autowired private QxcPlanService planSerice;
	  @Autowired private Pl5LotteryService service;
	  @Autowired private Pl5PlanService pl5PlanSerice;
	  @Autowired private GuilvPlanService guilvPlanService;
	
		public void job() {
		System.out.println("tottery");
		Long pl5qi=2017119l;
		 try{
			 pl5qi=Hangqing5Utils.getHangqing2(service);	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
	 
 	
		 int qi=0;
		 try{
			qi= HangqingUtils.getHangqing2( lotteryService); 	 
		 }catch (Exception e) {
			// TODO: handle exception
		}
    	  
 	 	 Pl5Lottery ply=this.service.findLottery5();
 	 	Lottery ly=this.lotteryService.findLottery();
 	 	
 	 	plan(ly); 
 	 	qxuPlan(ly);
 	 	pl5Plan(ply);
 		
 		try{
 	 	 	 if(ly!=null){
 	 	 	 	
 	 	 		 
 	 	 		 GuilvSum guilvSum=this.guilvSumService.findGuilvSum("qi", ly.getQi());
 	 	 		 if(guilvSum!=null&&guilvSum.getVaule()==null){
 	 	 			 StringBuffer sBuffer=new StringBuffer();
 	 	 			 sBuffer.append(ly.getNumber1()).append(ly.getNumber2()).append(ly.getNumber3()).append(ly.getNumber4());
 	 	 			 guilvSum.setVaule(sBuffer.toString());
 	 	 			 this.guilvSumService.updateGuilvSum(guilvSum);
 	 	 			 
 	 	 			List<Invest> invests=this.investService.findIntegers("qi", guilvSum.getQi());
 	 	 			if(invests!=null){
 	 	 	 			for(Invest invest:invests){
 	 	 	 				 
 	 	 	 				InvestSum sInvestSum=this.investSumService.findInvestSum("type", invest.getType());
 	 	 	 				
 	 	 	 				
 	 	 	 				if(invest.getVaule()==null){
 	 	 	 					 invest.setVaule(guilvSum.getVaule());
 	 	 	 					 if(StringUtils.isNotEmpty(invest.getInfo5())){
 	 	 	 						 int  count1= info5(invest.getVaule(),invest.getInfo5());
 	 	 	 	 				    
 	 	 	 	 				    if(count1==2){
 	 	 	 	 				    	invest.setPrize1(sInvestSum.getPrize1()+1);
 	 	 	 	 				    	
 	 	 	 	 				    	  	
 	 	 	 	 				    	  invest.setP1(1);
 	 	 	 	 				    	  int s=sInvestSum.getP1();
 	 	 	 	 				    
 	 	 	 	 				     
 	 	 	 	 				      java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
 	 	 							     
 	 	 		 			           invest.setSumMoney(Double.valueOf(df.format(invest.getSumMoney()+s)));
 	 	 	 	 				    } 
 	 	 	 					 }
 	 	 				         if(StringUtils.isNotEmpty(invest.getInfo1())){
 	 	 				        	  int  count2= info1(invest.getVaule(),invest.getInfo1());
 	 	 		 	 				    if(count2==4){
 	 	 		 	 				    	  
 	 	 		 	 				    	 invest.setPrize2(sInvestSum.getPrize2()+1);
 	 	 		 	 				    	invest.setP2(1);
 	 	 		 	 				    	  int s=sInvestSum.getP2();
 	 	 		 	 	 				    	 
 	 	 		 	 	 				    	 
 	 	 		 	 	 				     java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
 	 	 		 						     
 	 	 		 	 			           invest.setSumMoney(Double.valueOf(df.format(invest.getSumMoney()+s)));
 	 	 		 	 				    	 
 	 	 		 	 				    } 
 	 	 				         }
 	 	 	 				  
 	 	 	 				   
 	 	 	 				 
 	 	 	 				  
 	 	 	 				    this.investService.updateInvest(invest);
 	 	 	 				    
 	 	 	 				    sInvestSum.setSumMoney(invest.getSumMoney());
 	 	 	 				 sInvestSum.setPrize1(invest.getPrize1());
 	 	 	 				  sInvestSum.setPrize2(invest.getPrize2());
 	 	 	 				 
 	 	 	 				  this.investSumService.updateInvestSum(sInvestSum);
 	 	 	 				  
 	 	 	 				}
 	 	 	 			  
 	 	 	 			}	
 	 	 			}

 				    
 	 	 		 }
 	 	 	 }	
 		}catch (Exception e) {
			e.printStackTrace();
		}

  
		
	 
		
		 
	}
		
 private void pl5Plan(Pl5Lottery lottery2){
	 try{
		 if(lottery2!=null){
				
				List<Pl5Plan> plans=this.pl5PlanSerice.findIntegers("qi", lottery2.getQi());
		          if(plans!=null){
						for(Pl5Plan plan:plans){
							
							int co=0;
							int num=0;
							if(StringUtils.isNotEmpty(plan.getNumber1())){
								if(plan.getNumber1().contains(lottery2.getNumber1()+"")){
									co++;
								}	
								num++;
							}
							
							if(StringUtils.isNotEmpty(plan.getNumber2())){
								if(plan.getNumber2().contains(lottery2.getNumber2()+"")){
									co++;
								}
								num++;
							}
							if(StringUtils.isNotEmpty(plan.getNumber3())){
								if(plan.getNumber3().contains(lottery2.getNumber3()+"")){
									co++;
								}
								num++;
							}
							
							if(StringUtils.isNotEmpty(plan.getNumber4())){
								if(plan.getNumber4().contains(lottery2.getNumber4()+"")){
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
							sBuffera.append(lottery2.getNumber3());sBuffera.append(lottery2.getNumber4());
							plan.setValue("["+sBuffera.toString()+"]");
							this.pl5PlanSerice.updatePlan(plan);
						} 
		          }

				
				} 
	 }catch (Exception e) {
		e.printStackTrace();
	}

		} 
		
 
 
 private void plan(Lottery lottery2){
	 try{
			if(lottery2!=null){
				List<GuilvPlan> plans=this.guilvPlanService.findIntegers("qi", lottery2.getQi());
				if(plans!=null){
					for(GuilvPlan plan:plans){
						
						int co=0;
						int num=0;
						if(StringUtils.isNotEmpty(plan.getNumber1())){
							if(plan.getNumber1().contains(lottery2.getNumber1()+"")){
								co++;
							}	
							num++;
						}
						
						if(StringUtils.isNotEmpty(plan.getNumber2())){
							if(plan.getNumber2().contains(lottery2.getNumber2()+"")){
								co++;
							}
							num++;
						}
						if(StringUtils.isNotEmpty(plan.getNumber3())){
							if(plan.getNumber3().contains(lottery2.getNumber3()+"")){
								co++;
							}
							num++;
						}
						
						if(StringUtils.isNotEmpty(plan.getNumber4())){
							if(plan.getNumber4().contains(lottery2.getNumber4()+"")){
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
						sBuffera.append(lottery2.getNumber3());sBuffera.append(lottery2.getNumber4());
						plan.setValue("["+sBuffera.toString()+"]");
						this.guilvPlanService.updatePlan(plan);
					}	
				}

				
				} 
	 }catch (Exception e) {
		e.printStackTrace();
	}

	} 
 
	
		private void qxuPlan(Lottery ly){
			try{
				 if(ly!=null){
						List<QxcPlan> plans=this.planSerice.findIntegers("qi", ly.getQi());
						if(plans!=null){
							StringBuffer sb=new StringBuffer();
							sb.append(ly.getNumber1()).append(ly.getNumber2()).append(ly.getNumber3()).append(ly.getNumber4());
							 for(QxcPlan p:plans){
								 p.setVlaue(sb.toString());
								 int count= planValue(sb.toString(), p.getPlan()); 
								 p.setPrize(2);
								 if(p.getType()==0||p.getType()==1||p.getType()==6){
									
									if(count>=4){
										p.setPrize(1);
									}
								 }else if(p.getType()==2){
										
										if(count>=3){
											p.setPrize(1);
										}
								 }else if(p.getType()==3||p.getType()==4||p.getType()==5){
										
										if(count>=2){
											p.setPrize(1);
										}
								 }
								 this.planSerice.updatePlan(p);
							 } 	
						}

				 }	
			}catch (Exception e) {
				e.printStackTrace();
			}


		}
		
		public static void main(String[] args) {
			StringBuffer sb=new StringBuffer();
			sb.append(9).append(8).append(4).append(0);
			String info="头：490856 百：179364";
			System.out.println(planValue(sb.toString(), info));
		}
		
		
		private static  Integer planValue(String value,String info5){
			
			String s1=value.substring(0,1);
			String s2=value.substring(1,2);
			String s3=value.substring(2,3);
			String s4=value.substring(3,4);
		
			
			int count=0;
			if(info5.contains("头")){
				String inString1=info5.split("头：")[1];
				String inStirng2=inString1.split("：")[0];
				
				if(inStirng2.contains(s1)){
					count++;
				}
			}
			
			if(info5.contains("百")){
				String inString1=info5.split("百：")[1];
				String inStirng2=inString1.split("：")[0]; 
				if(inStirng2.contains(s2)){
					count++;
				}
			}
			if(info5.contains("十")){
				String inString1=info5.split("十：")[1];
				String inStirng2=inString1.split("：")[0]; 
				if(inStirng2.contains(s3)){
					count++;
				}
			}
			
			if(info5.contains("尾")){
				String inString1=info5.split("尾：")[1];
				String inStirng2=inString1.split("：")[0]; 
				if(inStirng2.contains(s4)){
					count++;
				}
			}
			return count;
		}
	
	private static  Integer info5(String value,String info5){
		
		String s1=value.substring(0,1);
		String s2=value.substring(1,2);
		String s3=value.substring(2,3);
		String s4=value.substring(3,4);
	
		
		int count=0;
		if(info5.contains("头")){
			 
			String inString1=info5.split("头：")[1];
			String inStirng2=inString1.split("：")[0];
			String inStirng3=inString1.split("：")[1];
			if(inStirng2.contains(s1)){
				count++;
			}
			if(inStirng2.contains("百")){
				if(inStirng3.contains(s2)){
					count++;
				}
			}
			
			if(inStirng2.contains("十")){
				if(inStirng3.contains(s3)){
					count++;
				}
			}
			
			if(inStirng2.contains("尾")){
				if(inStirng3.contains(s4)){
					count++;
				}
			}
			 
		}else if(info5.contains("百")){
			String inString1=info5.split("百：")[1];
			String inStirng2=inString1.split("：")[0];
			String inStirng3=inString1.split("：")[1];
			if(inStirng2.contains(s2)){
				count++;
			}
		 
			
			if(inStirng2.contains("十")){
				if(inStirng3.contains(s3)){
					count++;
				}
			}
			
			if(inStirng2.contains("尾")){
				if(inStirng3.contains(s4)){
					count++;
				}
			}
			 
		}else if(info5.contains("十")){
			String inString1=info5.split("十：")[1];
		 
			String inStirng2=inString1.split("：")[0];
			String inStirng3=inString1.split("：")[1];
			if(inStirng2.contains(s3)){
				count++;
			}
		 
			
			
			if(inStirng2.contains("尾")){
				if(inStirng3.contains(s4)){
					count++;
				}
			}
			 
		}
		return count;
	}
	
	
	
	private    Integer info1(String value,String info5){
		
		String s1=value.substring(0,1);
		String s2=value.substring(1,2);
		String s3=value.substring(2,3);
		String s4=value.substring(3,4);
		 
		
		
		int count=0;
	 
			String inString1=info5.split("头：")[1].trim();
			
			 if(inString1.substring(0, 8).contains(s1)){
				  
				 count++;
			 }
		 
		
		
		 
			String inString2=info5.split("百：")[1].trim();
			 
			 if(inString2.substring(0, 8).contains(s2)){
				 count++;
			 }
			 
		 
			String inString3=info5.split("十：")[1].trim();
		 
			 if(inString3.substring(0, 8).contains(s3)){
				 count++;
			 }
			 
		 
			String inString4=info5.split("尾：")[1].trim();
		 
			 if(inString4.substring(0, 8).contains(s4)){
				 count++;
			 }
	 
		return count;
	}
	
	
	 
	
}
