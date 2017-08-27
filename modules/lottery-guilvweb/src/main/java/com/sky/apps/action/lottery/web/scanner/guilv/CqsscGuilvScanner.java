/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.apps.action.lottery.web.scanner.guilv;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;  
 
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
 
import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.CqsscGuilvKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqsscGuilvUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorCqsscGuilv;
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvKill;  
import com.sky.modules.lottery.entity.guilv.CqsscLottery;  
import com.sky.modules.lottery.entity.guilv.CqsscPlan; 
import com.sky.modules.lottery.service.guilv.CqsscGuilvKillService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService; 
import com.sky.modules.lottery.service.guilv.CqsscLotteryService; 
import com.sky.modules.lottery.service.guilv.CqsscPlanService;  



 

 
 
 
@Service("CqsscGuilvScanner")
public class CqsscGuilvScanner implements QueryComm  {

	@Autowired
	private CqsscLotteryService lotteryService;
	
	@Autowired
	private CqsscGuilvService guilvService;
	@Autowired
	private CqsscGuilvKillService guilv2Service; 
	
	@Autowired private CqsscPlanService planService;
	 
 
	public void job() {
	 
	  
		
		try{
		 
		 
  PageView<CqsscLottery> pageView = new PageView<CqsscLottery>();
	pageView.setOrderby("qi", "desc");

	pageView.setQueryResult(lotteryService.findList(pageView, null));
 
	List<CqsscLottery> lotteries = pageView.getRecords();
	int qi=lotteries.get(0).getQi(); 		 
			   int b=3;
					     
			   
			 	for(int addition=2;addition<=3;addition++){
					 
						  int f=0;
					 
	                    for(int type=0;type<=4;type++){
								
								 
								 s2(addition, b, type, f, lotteryService, guilvService,lotteries);
							} 	
				 
					
				}  
			 	  
			   
			   
 
 	 
 	 
	 //	setPlanF(qi);
 	// System.out.println("结束："+UtilDate.getDateFormatter());
	// setPlan(qi, lotteries); 
 	//setPlan3(qi, lotteries);  
			 
		 
		 	     
	  
	  //setPlan5(qi, lotteries);   		
	 // setPlan6(qi, lotteries);	
	  
	  //setPlan16(qi, lotteries);	
	 
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
					
				
			 

				
				

	 
		
		 
	}
	
 
	
	private void setPlan(int qi,List<CqsscLottery> lotteries){
	    
			//	Plan plan3=this.planService.findPlan( qi,2);
		
		
		// Lottery2 lottery2=this.lotteryService.findReport("qi", qi);
		 
		 
			 
			//Plan plan=this.planService.findPlan(6); 
		  
		 
			
		StringBuffer cc1=new StringBuffer();StringBuffer cc2=new StringBuffer();;StringBuffer cc3=new StringBuffer();;
		StringBuffer dd1=new StringBuffer();;StringBuffer dd2=new StringBuffer();;StringBuffer dd3=new StringBuffer();;
		StringBuffer ee1=new StringBuffer();;StringBuffer ee2=new StringBuffer();;StringBuffer ee3=new StringBuffer();;
		StringBuffer ff1=new StringBuffer();;StringBuffer ff2=new StringBuffer();;StringBuffer ff3=new StringBuffer();;
		StringBuffer gg1=new StringBuffer();;StringBuffer gg2=new StringBuffer();;StringBuffer gg3=new StringBuffer();;
		 
		
             StringBuffer sBuffer1=new StringBuffer(); 
			
			StringBuffer sBuffer2=new StringBuffer(); 
			StringBuffer sBuffer3=new StringBuffer();   
			StringBuffer sBuffer4=new StringBuffer();  
			StringBuffer sBuffer5=new StringBuffer(); 
		    String typeLottery="ssc";
		    
		    
		    
			try{
			for(int type=0;type<=4;type++){
				 
			 
				if(type==0){ 
					  
					 getValue(sBuffer1, qi, type, guilv2Service, guilvService, lotteries,cc1,cc2,cc3,typeLottery);
				 
					
				}else if(type==1){
					 
					 
					getValue(sBuffer2, qi, type, guilv2Service, guilvService, lotteries,dd1,dd2,dd3,typeLottery);
						
						 
					
					 
				}else if(type==2){ 
					
					getValue(sBuffer3, qi, type, guilv2Service, guilvService, lotteries,ee1,ee2,ee3,typeLottery);
						 
						
					 
				}else if(type==3){
				 
					getValue(sBuffer4, qi, type, guilv2Service, guilvService, lotteries,ff1,ff2,ff3,typeLottery);
						
						 
						
				}else if(type==4){
					
				  
					getValue(sBuffer5, qi, type, guilv2Service, guilvService, lotteries,gg1,gg2,gg3,typeLottery);
						 
				  
					
					
				
					}
				
			
			}
			
			}catch (Exception e) {
				
			}
			 
			
     		int c1=Integer.parseInt(cc1.toString());int c2=Integer.parseInt(cc2.toString());int c3=Integer.parseInt(cc3.toString());
			int d1=Integer.parseInt(dd1.toString());int d2=Integer.parseInt(dd2.toString());int d3=Integer.parseInt(dd3.toString());  
			int e1=Integer.parseInt(ee1.toString());int e2=Integer.parseInt(ee2.toString());int e3=Integer.parseInt(ee3.toString()); 
			int f1=Integer.parseInt(ff1.toString());int f2=Integer.parseInt(ff2.toString());int f3=Integer.parseInt(ff3.toString());
			int g1=Integer.parseInt(gg1.toString());int g2=Integer.parseInt(gg2.toString());int g3=Integer.parseInt(gg3.toString());
			
		
			try{
				CqsscPlan	plan2=this.planService.findPlan(qi+1, 6);
				int s=qi+1;
			/*	String string="经电脑概率分析，"+s+"期，万位杀数为："+sBuffer1.toString()+",其中第一条件杀数"+c1+"个，第二条件杀数"+c2+"个，第三条件杀数"+c3+"个。千位杀数为："	
						+sBuffer2.toString()+",其中第一条件杀数"+d1+"个，第二条件杀数"+d2+"个，第三条件杀数"+d3+"个。百位杀数为："
				         +sBuffer3.toString()+",其中第一条件杀数"+e1+"个，第二条件杀数"+e2+"个，第三条件杀数"+e3+"个。十位杀数为："
				         +sBuffer4.toString()+",其中第一条件杀数"+f1+"个，第二条件杀数"+f2+"个，第三条件杀数"+f3+"个。个位杀数为："
				         +sBuffer5.toString()+",其中第一条件杀数"+g1+"个，第二条件杀数"+g2+"个，第三条件杀数"+g3+"个。";*/
				
			
				
				
				
				String string="";
				if(plan2==null){
				 
						
					plan2=new CqsscPlan();	
				
			        
			 
				plan2.setQi(qi+1);
				plan2.setType(6);
				 
		
				
				
				plan2.setNumber7(string);
		  this.planService.savePlan(plan2);
		  
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			try{
				
			

	  CqsscPlan	plan77=this.planService.findPlan(qi+1, 7);
	  if(plan77==null){
		   
		  
		  
			 plan77= new CqsscPlan();
	           
	        		plan77.setQi(qi+1);
	     			plan77.setType(7); 
	     			int c7=0;
	     			if(sBuffer1.length()>=3){
	     				c7++;
	     				String string="";
	     				if(c1>=2){
	     					string="*";
	     				}
	     				 plan77.setNumber1(sBuffer1.subSequence(0,3).toString()+string);
	     			 }
	     			if(sBuffer2.length()>=3){
	     				c7++;
	     				String string="";
	     				if(d1>=2){
	     					string="*";
	     				}
	     				 plan77.setNumber2(sBuffer2.subSequence(0,3).toString()+string);
	     			 }
	     			    if(c7>=2){
	     			    	  
	     			    	this.planService.savePlan(plan77);
	     			    }
	     			 
	           
	
	  }
			}catch (Exception e) {
				// TODO: handle exception
			}
			 
		
			try{
		CqsscPlan   plan88=this.planService.findPlan(qi+1, 8);
		if(plan88==null){
			 
				plan88=new CqsscPlan(); 
			 
					plan88.setQi(qi+1);
					plan88.setType(8);
					  
					
					int c8=0;
					if(sBuffer4.length()>=3){
						c8++;
						String string="";
						if(f1>=2){
							string="*";
						}
						 plan88.setNumber4(sBuffer4.subSequence(0,3).toString()+string);
					 } 
					if(sBuffer5.length()>=3){
						c8++;
						String string="";
						if(g1>=2){
							string="*";
						}
						 plan88.setNumber5(sBuffer5.subSequence(0,3).toString()+string);
					 } 
					   if(c8>=2){
						   
						   this.planService.savePlan(plan88);
					   }
				}
				
				 
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try{
				
			 
			  CqsscPlan	plan99=this.planService.findPlan(qi+1, 9);
			  if(plan99==null){
				   
					plan99=  new CqsscPlan();
				 
						plan99.setQi(qi+1);
						plan99.setType(9);
						  
						 
						int c9=0;
						if(sBuffer1.length()>=3){
							c9++;
							String string="";
							if(c1>=2){
								string="*";
							}
							 plan99.setNumber1(sBuffer1.subSequence(0,3).toString()+string);
						 }
						if(sBuffer5.length()>=3){
							c9++;
							String string="";
							if(g1>=2){
								string="*";
							}
							 plan99.setNumber5(sBuffer5.subSequence(0,3).toString()+string);
						 }
						
						if(c9>=2){
							 this.planService.savePlan(plan99);
						}
					}
				
			 
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
		  try{
			  CqsscPlan	plan109=this.planService.findPlan(qi+1, 10);
			  if(plan109==null){
			 
				  plan109=  new CqsscPlan();
				 
					  plan109.setQi(qi+1);
					  plan109.setType(10);
					 
					 
					 
					int c10=0;
					if(sBuffer1.length()>=2){
						c10++;
						String string="";
						if(c1>=2){
							string="*";
						}
						plan109.setNumber1(sBuffer1.subSequence(0,2).toString()+string);
					 }
					if(sBuffer2.length()>=2){
						c10++;
						String string="";
						if(d1>=2){
							string="*";
						}
						plan109.setNumber2(sBuffer2.subSequence(0,2).toString()+string);
					 }
					
					if(sBuffer3.length()>=2){
						c10++;
						String string="";
						if(e1>=2){
							string="*";
						}
						plan109.setNumber3(sBuffer3.subSequence(0,2).toString()+string);
					 }
					 
					  if(c10>=3){
						  this.planService.savePlan(plan109); 
						  
					  }
				  }
				 
			  
		  }catch (Exception e) {
			 
		}
			
			
				try{
					  
					  CqsscPlan	plan110=this.planService.findPlan(qi+1, 11);
					 
					  if(plan110==null){
						  
						  plan110=  new CqsscPlan();
					 
							  plan110.setQi(qi+1);
								plan110.setType(11);
								  
								 
								
								int c11=0;
								if(sBuffer3.length()>=2){
									c11++;
									String string="";
									if(e1>=2){
										string="*";
									}
									 plan110.setNumber3(sBuffer3.subSequence(0,2).toString()+string);
								 }
								if(sBuffer4.length()>=2){
									c11++;
									String string="";
									if(f1>=2){
										string="*";
									}
									 plan110.setNumber4(sBuffer4.subSequence(0,2).toString()+string);
								 }
								
								if(sBuffer5.length()>=2){
									c11++;
									String string="";
									if(g1>=2){
										string="*";
									}
									 plan110.setNumber5(sBuffer5.subSequence(0,2).toString()+string);
								 }
							
					             if(c11>=3){
					            	 this.planService.savePlan(plan110);
					            	 
					             } 
						  }
						
					  
				}catch (Exception e) {
					// TODO: handle exception
				}  
			
			
				
				
				try{
					if(sBuffer1.length()>=5){
						CqsscPlan	plan160=this.planService.findPlan(qi+1, 16);
						 String value=sBuffer1.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						  if(plan160==null){
							  
							  plan160=  new CqsscPlan();
							  plan160.setType(16);
							  plan160.setNumber1(sb.toString());
							  plan160.setQi(qi+1);
							  this.planService.savePlan(plan160);
						  }	
					}
					  
					  
				}catch (Exception e) {
					// TODO: handle exception
				} 
				
				try{
					if(sBuffer2.length()>=5){
						CqsscPlan	plan170=this.planService.findPlan(qi+1, 17);
						 String value=sBuffer2.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						  if(plan170==null){
							  
							  plan170=  new CqsscPlan();
							  plan170.setType(17);
							  plan170.setNumber2(sb.toString());
							  plan170.setQi(qi+1);
							  this.planService.savePlan(plan170);
						  }	
					}
					  
					  
				}catch (Exception e) {
					// TODO: handle exception
				}
			
				
				try{
					if(sBuffer3.length()>=5){
						CqsscPlan	plan170=this.planService.findPlan(qi+1, 18);
						 String value=sBuffer3.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						  if(plan170==null){
							  
							  plan170=  new CqsscPlan();
							  plan170.setType(18);
							  plan170.setNumber3(sb.toString());
							  plan170.setQi(qi+1);
							  this.planService.savePlan(plan170);
						  }	
					}
					  
					  
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				try{
					if(sBuffer4.length()>=5){
						CqsscPlan	plan170=this.planService.findPlan(qi+1, 19);
						 String value=sBuffer4.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						  if(plan170==null){
							  
							  plan170=  new CqsscPlan();
							  plan170.setType(19);
							  plan170.setNumber4(sb.toString());
							  plan170.setQi(qi+1);
							  this.planService.savePlan(plan170);
						  }	
					}
					  
					  
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				try{
					if(sBuffer5.length()>=5){
						CqsscPlan	plan170=this.planService.findPlan(qi+1, 20);
						 String value=sBuffer5.subSequence(0,5).toString();
						 StringBuffer sb=new StringBuffer();
						 for(int i=0;i<10;i++){
							 if(!value.contains(i+"")){
								 sb.append(i+"");
							 }
						 }
						  if(plan170==null){
							  
							  plan170=  new CqsscPlan();
							  plan170.setType(20);
							  plan170.setNumber5(sb.toString());
							  plan170.setQi(qi+1);
							  this.planService.savePlan(plan170);
						  }	
					}
					  
					  
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
				try{
						  CqsscPlan	plan120=this.planService.findPlan(qi+1, 15);
						   
						  if(plan120==null){
							  
							  plan120= new CqsscPlan();
						   
								  plan120.setQi(qi+1);
									plan120.setType(15);
									  
									
									int c12=0;
									if(sBuffer1.length()>=1){
										c12++;
										String string="";
										if(c1>=1){
											string="*";
										}
										 plan120.setNumber1(sBuffer1.subSequence(0,1).toString()+string);
									 } 
									if(sBuffer2.length()>=1){
										c12++;
										String string="";
										if(d1>=1){
											string="*";
										}
										 plan120.setNumber2(sBuffer2.subSequence(0,1).toString()+string);
									 }
									if(sBuffer3.length()>=1){
										c12++;
										String string="";
										if(e1>=1){
											string="*";
										}
										 plan120.setNumber3(sBuffer3.subSequence(0,1).toString()+string);
									 }
									
									if(sBuffer4.length()>=1){
										c12++;
										String string="";
										if(f1>=1){
											string="*";
										}
										 plan120.setNumber4(sBuffer4.subSequence(0,1).toString()+string);
									 }
									
									if(sBuffer5.length()>=1){
										c12++;
										String string="";
										if(g1>=1){
											string="*";
										}
										 plan120.setNumber5(sBuffer5.subSequence(0,1).toString()+string);
									 }
								
						             if(c12>=5){
						            	 this.planService.savePlan(plan120);
						            	 
						             }  
							   
							
}  
				}catch (Exception e) {
					// TODO: handle exception
				}
			
	}
	
	
 
 
	private StringBuffer getStringBuffer(List<String> list){ 
		StringBuffer sBuffer=new StringBuffer();
		for(String s:list){
			if(sBuffer.indexOf(s)==-1){
				sBuffer.append(s);
			}
			
		}
		return sBuffer;
	}
	
 
	private void setPlan3(int qi,List<CqsscLottery> lotteries){
	    
			CqsscPlan plan5=this.planService.findPlan(qi+1,5);
			 
			 
			  if(plan5==null){  
			
			CqsscPlan plan=this.planService.findPlan(5);
			
		 
		
			 CqsscLottery lottery2=this.lotteryService.findReport("qi", qi);
		  
			
			 
		 
			

		
			
			CqsscPlan	plan2=new CqsscPlan();
			 
				 
				 
				for(int type=0;type<=4;type++){
					 
					if(type==0){
						
						
						CqsscGuilv k=this.guilvService.findGuilvKill(qi+1, type,"ssc") ;
						if(k!=null){
							 plan2.setNumber1(k.getValue()) ;
						 }else{
							 
							 CqsscGuilvKill  kill2=this.guilv2Service.findGuilvKill2(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber1(kill2.getValue());
								}else{
									 
									 CqsscGuilvKill  kill3=this.guilv2Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber1(kill3.getValue().substring(0,1));
									}else{
										 CqsscGuilvKill  kill4=this.guilv2Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber1(kill4.getValue().substring(0,1));
										 }else{
											 CqsscGuilvKill  kill5=this.guilv2Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber1(kill5.getValue().substring(0,1)); 
											 }else{
												 CqsscGuilvKill  kill6=this.guilv2Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber1(kill6.getValue().substring(0,1));  
												 }else{
													 CqsscGuilvKill  kill7=this.guilv2Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber1(kill7.getValue().substring(0,1)); 
													 }else{
														 CqsscGuilvKill  kill8=this.guilv2Service.findGuilvKill(qi+1, type,0,5,2);  
														 if(kill8!=null){
															 plan2.setNumber1(kill8.getValue().substring(0,1)); 
														 } else{
															 if(lottery2.getNumber1()!=s(sum(lotteries, 1, 1, null)+sum(lotteries,2, 1, null)+sum(lotteries, 2, 1, null))){
																 plan2.setNumber1(s(sum(lotteries, 0, 1, null)+sum(lotteries, 1, 1, null)+sum(lotteries, 1, 1, null))+"");
															 }else{
																 if(lottery2.getNumber1()!=s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 0, null)+sum(lotteries, 1, 2, null))){
																	 plan2.setNumber1(s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 0, null)+sum(lotteries, 0, 2, null))+""); 
																 }else{
																	 if(lottery2.getNumber1()!=s(sum(lotteries, 2, 1, null)+sum(lotteries, 2, 1, null)+sum(lotteries, 2, 2, null))){
																			String value=	s(sum(lotteries, 1, 1, null)+sum(lotteries, 1, 1, null)+sum(lotteries, 1, 2, null))+"";
																			 plan2.setNumber1(value); 
																		} else {
																			String value=	s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 0, null)+sum(lotteries, 1, 2, null))+"";
																			 plan2.setNumber1(value); 
																		}
																 }
															 }
															 
															
															 
															 
															 
															 
																
																 
																 
																
																 
															
															 
															 
															 
															 
														 }
													 }
												 }
											 }
											 
											 
										 }
										 
									}
									
												 
								
													  
												 
										
											
									  
								}
							 
							 
							
						 }
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					 
						
					}else if(type==1){
						
						
						CqsscGuilv k=this.guilvService.findGuilvKill(qi+1, type,"ssc") ;
						if(k!=null){
							 plan2.setNumber2(k.getValue()) ;
						 }else{
							 
							 CqsscGuilvKill  kill2=this.guilv2Service.findGuilvKill2(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber2(kill2.getValue());
								}else{
									 
									 CqsscGuilvKill  kill3=this.guilv2Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber2(kill3.getValue().substring(0,1));
									}else{
										 CqsscGuilvKill  kill4=this.guilv2Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber2(kill4.getValue().substring(0,1));
										 }else{
											 CqsscGuilvKill  kill5=this.guilv2Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber2(kill5.getValue().substring(0,1)); 
											 }else{
												 CqsscGuilvKill  kill6=this.guilv2Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber2(kill6.getValue().substring(0,1));  
												 }else{
													 CqsscGuilvKill  kill7=this.guilv2Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber2(kill7.getValue().substring(0,1)); 
													 }else{
														 CqsscGuilvKill  kill8=this.guilv2Service.findGuilvKill(qi+1, type,0,5,2);  
														 if(kill8!=null){
															 plan2.setNumber2(kill8.getValue().substring(0,1)); 
														 } else{
															 
															 
															 
															 
																    if(lottery2.getNumber2()!=s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 0, null)+sum(lotteries, 2, 3, null))){
																    	 
																    	 plan2.setNumber2(s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 0, null)+sum(lotteries, 1, 3, null))+"");	   
																    }else{
																    	 if(lottery2.getNumber2()!=s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 0, null)+sum(lotteries, 2, 0, null))){
																		    	String value=	s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 0, null)+sum(lotteries, 1, 0, null))+"";
																		    	 plan2.setNumber2(value);	      
																		    }else{
																		    	String value=	s(sum(lotteries,0, 4, null)+sum(lotteries, 0, 4, null)+sum(lotteries, 1, 4, null))+"";
																		    	 plan2.setNumber2(value);	   
																		    }
																    	
																    }
																
																   
																	
																 
															

															 
																   
																
																   
																	
																 
															 
															
															 
														  
												 
														 
															 
															 
															 
															
														
														 
														 
														 
														 
														 }
													 }
												 }
											 }
											 
											 
										 }
										 
									}
									
												 
								
													  
												 
										
											
									  
								}
							 
							 
							
						 }
						
						
						 
						
						
						
						
						
						
						
						
						
						
						
						 
						 
	                
						
						 
					}else if(type==2){
						
						
						CqsscGuilv k=this.guilvService.findGuilvKill(qi+1, type,"ssc") ;
						if(k!=null){
							 plan2.setNumber3(k.getValue()) ;
						 }else{
							 
							 CqsscGuilvKill  kill2=this.guilv2Service.findGuilvKill2(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber3(kill2.getValue());
								}else{
									 
									 CqsscGuilvKill  kill3=this.guilv2Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber3(kill3.getValue().substring(0,1));
									}else{
										 CqsscGuilvKill  kill4=this.guilv2Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber3(kill4.getValue().substring(0,1));
										 }else{
											 CqsscGuilvKill  kill5=this.guilv2Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber3(kill5.getValue().substring(0,1)); 
											 }else{
												 CqsscGuilvKill  kill6=this.guilv2Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber3(kill6.getValue().substring(0,1));  
												 }else{
													 CqsscGuilvKill  kill7=this.guilv2Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber3(kill7.getValue().substring(0,1)); 
													 }else{
														 CqsscGuilvKill  kill8=this.guilv2Service.findGuilvKill(qi+1, type,0,5,2);  
														 if(kill8!=null){
															 plan2.setNumber3(kill8.getValue().substring(0,1)); 
														 } else{
															 
															 
															 
																    if(lottery2.getNumber3()!=s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 3, null)+sum(lotteries, 1, 3, null))){
																    	 String value=	s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 3, null)+sum(lotteries, 0, 3, null))+"";
																    	 plan2.setNumber3(value);   
																    }else{
																    	if(lottery2.getNumber3()!=s(sum(lotteries,1, 1, null)+sum(lotteries, 1, 1, null)+sum(lotteries, 2, 4, null))){
																			   String value=	s(sum(lotteries,0, 1, null)+sum(lotteries, 0, 1, null)+sum(lotteries, 1, 4, null))+"";
																			   plan2.setNumber3(value);   
																				}else{
																					  String value=	s(sum(lotteries,1, 3, null)+sum(lotteries, 1, 3, null)+sum(lotteries, 1, 4, null))+"";
																					  plan2.setNumber3(value);   
																				}
																    }
																
																  
																 
															
														 
														  
														   
															

															 
															 
															 
															 
															 
														 }
													 }
												 }
											 }
											 
											 
										 }
										 
									}
									
												 
								
													  
												 
										
											
									  
								}
							 
							 
							
						 }
						
						
						
						
						
						
						
						
						
						
						
						  
							 
							
						 
					}else if(type==3){
						
						CqsscGuilv k=this.guilvService.findGuilvKill(qi+1, type,"ssc") ;
						if(k!=null){
							 plan2.setNumber4(k.getValue()) ;
						 }else{
							 
							 CqsscGuilvKill  kill2=this.guilv2Service.findGuilvKill2(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber4(kill2.getValue());
								}else{
									 
									 CqsscGuilvKill  kill3=this.guilv2Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber4(kill3.getValue().substring(0,1));
									}else{
										 CqsscGuilvKill  kill4=this.guilv2Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber4(kill4.getValue().substring(0,1));
										 }else{
											 CqsscGuilvKill  kill5=this.guilv2Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber4(kill5.getValue().substring(0,1)); 
											 }else{
												 CqsscGuilvKill  kill6=this.guilv2Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber4(kill6.getValue().substring(0,1));  
												 }else{
													 CqsscGuilvKill  kill7=this.guilv2Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber4(kill7.getValue().substring(0,1)); 
													 }else{
														 CqsscGuilvKill  kill8=this.guilv2Service.findGuilvKill(qi+1, type,0,5,2);  
														 if(kill8!=null){
															 plan2.setNumber4(kill8.getValue().substring(0,1)); 
														 } else{
															 
															 
																	if(lottery2.getNumber4()!=s(sum(lotteries, 1, 4, null)+sum(lotteries, 1, 4, null)+sum(lotteries, 2, 3, null))){
																		 String value=	s(sum(lotteries, 0, 4, null)+sum(lotteries, 0, 4, null)+sum(lotteries, 1, 3, null))+"";
																		 plan2.setNumber4(value);
																	}else{
																		if(lottery2.getNumber4()!=s(sum(lotteries,1, 2, null)+sum(lotteries, 2, 1, null)+sum(lotteries, 2, 1, null))){
																			 String value=	s(sum(lotteries,0, 2, null)+sum(lotteries, 1, 1, null)+sum(lotteries, 1, 1, null))+"";
																			 plan2.setNumber4(value); 
																		}else{
																			String value=	s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 0, null)+sum(lotteries, 1, 2, null))+"";
																			 plan2.setNumber4(value); 
																		}
																	}
																	  
																		
																	 
																
																
															  
																	
																  
																 
																
																 
																
															 
															 
															 
														 }
													 }
												 }
											 }
											 
											 
										 }
										 
									}
									
												 
								
													  
												 
										
											
									  
								}
							 
							 
							
						 }
						
						
						
						
						
						
						
						
						
						
						
						
					
					}else if(type==4){
						
						CqsscGuilv k=this.guilvService.findGuilvKill(qi+1, type,"ssc") ;
						if(k!=null){
							 plan2.setNumber5(k.getValue()) ;
						 }else{
							 
							 CqsscGuilvKill  kill2=this.guilv2Service.findGuilvKill2(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber5(kill2.getValue());
								}else{
									 
									 CqsscGuilvKill  kill3=this.guilv2Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber5(kill3.getValue().substring(0,1));
									}else{
										 CqsscGuilvKill  kill4=this.guilv2Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber5(kill4.getValue().substring(0,1));
										 }else{
											 CqsscGuilvKill  kill5=this.guilv2Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber5(kill5.getValue().substring(0,1)); 
											 }else{
												 CqsscGuilvKill  kill6=this.guilv2Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber5(kill6.getValue().substring(0,1));  
												 }else{
													 CqsscGuilvKill  kill7=this.guilv2Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber5(kill7.getValue().substring(0,1)); 
													 }else{
														 CqsscGuilvKill  kill8=this.guilv2Service.findGuilvKill(qi+1, type,0,5,2);  
														 if(kill8!=null){
															 plan2.setNumber5(kill8.getValue().substring(0,1)); 
														 } else{
															
														
															  
																	if(lottery2.getNumber5()!=s(sum(lotteries, 1, 2, null)+sum(lotteries, 2, 3, null)+sum(lotteries, 2, 3, null))){
																		 String value=s(sum(lotteries, 0, 2, null)+sum(lotteries, 1, 3, null)+sum(lotteries, 1, 3, null))+"";
																		 plan2.setNumber5(value);   
																	}else{
																		if(lottery2.getNumber5()!=s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 1, null)+sum(lotteries, 1, 1, null))){
																			 String value=s(sum(lotteries, 0, 0, null)+sum(lotteries, 0, 1, null)+sum(lotteries,0, 1, null))+"";
																			 plan2.setNumber5(value);   
																		}else{
																			 String value=s(sum(lotteries, 1, 0, null)+sum(lotteries, 1, 0, null))+"";
																			 plan2.setNumber5(value);
																		}
																	}
																	  
																		
																	 
																
																 
 
																
														 
														 }
													 }
												 }
											 }
											 
											 
										 }
										 
									}
									
												 
								
													  
												 
										
											
									  
								}
							 
							 
							
						 }
						
						
						
						
						
						
						
						
						
						
						
					

						}
					
				
				}
			if(plan!=null){
				if(plan.getErrorNum()!=0){
					plan2.setType3(1);
				}
					plan2.setQi(qi+1);
					plan2.setType(5);
					 
						plan2.setErrorMin(plan.getErrorMin());
						plan2.setCountNum(plan.getCountNum());
						plan2.setCountMin(plan.getCountMin());
					    plan2.setErrorNum(plan.getErrorNum());	
					    plan2.setPrize1(plan.getPrize1());
					   
	                   this.planService.savePlan(plan2);	
				 
			
			}else{
				plan2.setQi(qi+1);
				plan2.setType(5);
				 
				 
				   
                   this.planService.savePlan(plan2);
			}
				
				
				 
				
			 }
  }  
			
	 
	

	
	
	private void setPlan5(int qi,List<CqsscLottery> lotteries){
	    
		CqsscPlan plan5=this.planService.findPlan( qi+1,12);
		 
		 
		  if(plan5==null){  
		
		CqsscPlan plan=this.planService.findPlan( qi,12);
		 CqsscLottery lottery2=this.lotteryService.findReport("qi", qi);
		int co=0;
		int num=0;
		
		 
		
		if(plan!=null&&lottery2!=null){
			if(lottery2.getNumber1()==Integer.parseInt(plan.getNumber1())){
				co++;
				
			}
			
			if(lottery2.getNumber2()==Integer.parseInt(plan.getNumber2())){
				co++;
			}
			if(lottery2.getNumber3()==Integer.parseInt(plan.getNumber3())){
				co++;
			}
			
			if(lottery2.getNumber4()==Integer.parseInt(plan.getNumber4())){
				co++;
			}
			
			if(lottery2.getNumber5()==Integer.parseInt(plan.getNumber5())){
				co++;
			}
			 
			if(co>=1){
				plan.setPrize1(plan.getPrize1()+1);
				plan.setCountNum(plan.getCountNum()+1);
				
				if(plan.getCountNum()>plan.getCountMin()){
					plan.setCountMin(plan.getCountNum());
				}
				
				plan.setErrorNum(0);
			}else{
				plan.setErrorNum(plan.getErrorNum()+1);
				if(plan.getErrorNum()>plan.getErrorMin()){
					plan.setErrorMin(plan.getErrorNum());
				}
				plan.setCountNum(0);
				
			}
			StringBuffer sBuffera=new StringBuffer("");
			sBuffera.append(lottery2.getNumber1()+"");sBuffera.append(lottery2.getNumber2());
			sBuffera.append(lottery2.getNumber3());sBuffera.append(lottery2.getNumber4());sBuffera.append(lottery2.getNumber5());
			plan.setNumber6("["+sBuffera.toString()+"]");
			this.planService.updatePlan(plan);
			num=plan.getSum();
		}
		

	
		
		CqsscPlan	plan2=new CqsscPlan();
			String qString=qi+"";
			 
			if(qString.substring(3, 6).equals("120")){
				num=0;
			}
			 
			 
			for(int type=0;type<=4;type++){
				 
				if(type==0){
					
					
					String value=	s(sum(lotteries, 0, 0, null)*sum(lotteries, 0, 1, null)*sum(lotteries, 0, 2, null)-sum(lotteries, 0, 4, null))+"";
					 plan2.setNumber1(value); 
					
				 
					
				}else if(type==1){
					
					
					String value=	s(sum(lotteries, 0, 0, null)*sum(lotteries, 0, 1, null)*sum(lotteries, 0, 2, null)-sum(lotteries, 0, 4, null))+"";
					 plan2.setNumber2(value); 
					
					
					 
					 
                
					
					 
				}else if(type==2){
					
					String value=	s(sum(lotteries, 0, 0, null)*sum(lotteries, 0, 1, null)*sum(lotteries, 0, 2, null)-sum(lotteries, 0, 4, null))+"";
					 plan2.setNumber3(value); 
					
					
					
					  
						 
						
					 
				}else if(type==3){
					
					String value=	s(sum(lotteries, 0, 0, null)*sum(lotteries, 0, 1, null)*sum(lotteries, 0, 2, null)-sum(lotteries, 0, 4, null))+"";
					 plan2.setNumber4(value); 
				
				}else if(type==4){
					
					String value=	s(sum(lotteries, 0, 0, null)*sum(lotteries, 0, 1, null)*sum(lotteries, 0, 2, null)-sum(lotteries, 0, 4, null))+"";
					 plan2.setNumber5(value); 
					
					
					
					
					
				

					}
				
			
			}
		
			
			
			plan2.setSum(num+1);
			plan2.setQi(qi+1);
			plan2.setType(12);
			if(num!=0){
				plan2.setErrorMin(plan.getErrorMin());
				plan2.setCountNum(plan.getCountNum());
				plan2.setCountMin(plan.getCountMin());
			    plan2.setErrorNum(plan.getErrorNum());	
			    plan2.setPrize1(plan.getPrize1());
			}else{
				plan2.setErrorMin(0);
				plan2.setCountNum(0);
				plan2.setCountMin(0);
			    plan2.setErrorNum(0);
			    plan2.setPrize1(0);
			    	
			}  
		  this.planService.savePlan(plan2);
}  
		
	}
	
	
	private void setPlan6(int qi,List<CqsscLottery> lotteries){
	    
		CqsscPlan plan5=this.planService.findPlan( qi+1,13);
		 
		 
		  if(plan5==null){  
		
		CqsscPlan plan=this.planService.findPlan( qi,13);
		 CqsscLottery lottery2=this.lotteryService.findReport("qi", qi);
		int co=0;
		int num=0;
		
		 
		
		if(plan!=null&&lottery2!=null){
			if(lottery2.getNumber1()==Integer.parseInt(plan.getNumber1())){
				co++;
				
			}
			
			if(lottery2.getNumber2()==Integer.parseInt(plan.getNumber2())){
				co++;
			}
			if(lottery2.getNumber3()==Integer.parseInt(plan.getNumber3())){
				co++;
			}
			
			if(lottery2.getNumber4()==Integer.parseInt(plan.getNumber4())){
				co++;
			}
			
			if(lottery2.getNumber5()==Integer.parseInt(plan.getNumber5())){
				co++;
			}
			 
			if(co>=1){
				plan.setPrize1(plan.getPrize1()+1);
				plan.setCountNum(plan.getCountNum()+1);
				
				if(plan.getCountNum()>plan.getCountMin()){
					plan.setCountMin(plan.getCountNum());
				}
				
				plan.setErrorNum(0);
			}else{
				plan.setErrorNum(plan.getErrorNum()+1);
				if(plan.getErrorNum()>plan.getErrorMin()){
					plan.setErrorMin(plan.getErrorNum());
				}
				plan.setCountNum(0);
				
			}
			StringBuffer sBuffera=new StringBuffer("");
			sBuffera.append(lottery2.getNumber1()+"");sBuffera.append(lottery2.getNumber2());
			sBuffera.append(lottery2.getNumber3());sBuffera.append(lottery2.getNumber4());sBuffera.append(lottery2.getNumber5());
			plan.setNumber6("["+sBuffera.toString()+"]");
			this.planService.updatePlan(plan);
			num=plan.getSum();
		}
		

	
		
		CqsscPlan	plan2=new CqsscPlan();
			String qString=qi+"";
			 
			if(qString.substring(3, 6).equals("120")){
				num=0;
			}
			 
			 
			for(int type=0;type<=4;type++){
				 
				if(type==0){
					
					
					String value=	s(sum(lotteries, 1, 3, null)*sum(lotteries, 1, 4, null)*sum(lotteries, 0, 4, null)-sum(lotteries, 0, 0, null))+"";
					 plan2.setNumber1(value); 
					
				 
					
				}else if(type==1){
					
					
					String value=	s(sum(lotteries, 1, 3, null)*sum(lotteries, 1, 4, null)*sum(lotteries, 0, 4, null)-sum(lotteries, 0, 0, null))+"";
					 plan2.setNumber2(value); 
					
					
					 
					 
                
					
					 
				}else if(type==2){
					
					String value=	s(sum(lotteries, 1, 3, null)*sum(lotteries, 1, 4, null)*sum(lotteries, 0, 4, null)-sum(lotteries, 0, 0, null))+"";
					 plan2.setNumber3(value); 
					
					
					
					  
						 
						
					 
				}else if(type==3){
					
					String value=	s(sum(lotteries, 1, 3, null)*sum(lotteries, 1, 4, null)*sum(lotteries, 0, 4, null)-sum(lotteries, 0, 0, null))+"";
					 plan2.setNumber4(value);  
				
				}else if(type==4){
					
					String value=	s(sum(lotteries, 1, 3, null)*sum(lotteries, 1, 4, null)*sum(lotteries, 0, 4, null)-sum(lotteries, 0, 0, null))+"";
					 plan2.setNumber5(value); 
					
					
					
					
					
				

					}
				
			
			}
		
			
			
			plan2.setSum(num+1);
			plan2.setQi(qi+1);
			plan2.setType(13);
			if(num!=0){
				plan2.setErrorMin(plan.getErrorMin());
				plan2.setCountNum(plan.getCountNum());
				plan2.setCountMin(plan.getCountMin());
			    plan2.setErrorNum(plan.getErrorNum());	
			    plan2.setPrize1(plan.getPrize1());
			}else{
				plan2.setErrorMin(0);
				plan2.setCountNum(0);
				plan2.setCountMin(0);
			    plan2.setErrorNum(0);
			    plan2.setPrize1(0);
			    	
			}  
		  this.planService.savePlan(plan2);
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
	
	
	private void setPlan16(int qi,List<CqsscLottery> lotteries){
	    
		
		
		

        StringBuffer sBuffer1=new StringBuffer(); 
		
		StringBuffer sBuffer2=new StringBuffer();  
	    String typeLottery="ssctwo";
		try{
		for(int type=0;type<=1;type++){
			 
		    
			if(type==0){ 
				  
				 getValue2(sBuffer1, qi, 0, guilvService, lotteries,typeLottery);
			 
				
			}else if(type==1){
				 
				 
				getValue2(sBuffer2, qi, 3, guilvService, lotteries,typeLottery);
					
					 
				
				 
			}
			
		
		}
		
		}catch (Exception e) {
			
		}
		CqsscPlan plan16=this.planService.findPlan(qi+1,16);
		  if(plan16==null){  

		try{
			 
			if(sBuffer1.length()>=2){
				CqsscPlan	plan2=new CqsscPlan();	 
				CqsscPlan plan=this.planService.findPlan(16); 	
				plan2.setNumber1(sBuffer1.subSequence(0,2).toString());
				if(plan!=null){
					if(plan.getErrorNum()!=0){
						plan2.setType3(1);
					}
						plan2.setQi(qi+1);
						plan2.setType(16);
						 
							plan2.setErrorMin(plan.getErrorMin());
							plan2.setCountNum(plan.getCountNum());
							plan2.setCountMin(plan.getCountMin());
						    plan2.setErrorNum(plan.getErrorNum());	
						    plan2.setPrize1(plan.getPrize1());
						   
		                   this.planService.savePlan(plan2);	
					 
				
				}else{
					plan2.setQi(qi+1);
					plan2.setType(16); 
		               this.planService.savePlan(plan2);
				} 
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
		  
			
		 }
		  
			CqsscPlan plan17=this.planService.findPlan(qi+1,17);
			  if(plan17==null){  

			try{
				 
				if(sBuffer2.length()>=2){
					CqsscPlan	plan2=new CqsscPlan();	 
					CqsscPlan plan=this.planService.findPlan(16); 	
					plan2.setNumber3(sBuffer2.subSequence(0,2).toString());
					if(plan!=null){
						if(plan.getErrorNum()!=0){
							plan2.setType3(1);
						}
							plan2.setQi(qi+1);
							plan2.setType(17);
							 
								plan2.setErrorMin(plan.getErrorMin());
								plan2.setCountNum(plan.getCountNum());
								plan2.setCountMin(plan.getCountMin());
							    plan2.setErrorNum(plan.getErrorNum());	
							    plan2.setPrize1(plan.getPrize1());
							   
			                   this.planService.savePlan(plan2);	
						 
					
					}else{
						plan2.setQi(qi+1);
						plan2.setType(17); 
			               this.planService.savePlan(plan2);
					} 
				}	
			}catch (Exception e) {
				// TODO: handle exception
			}
			  
				
			 }
		  
}  
	
	
	
	private static void getValue2(StringBuffer sBuffer,int qi,int type,
			CqsscGuilvService guilvService,List<CqsscLottery> lotteries
			,String typeLottery){
		
		
		 
		int ta=type;
		if(sBuffer.length()<3){
			int num=0;
			for(int i=0;i<=4;i++){
				if(i==0){
					num=lotteries.get(0).getNumber1();
				}else if(i==1){
					num=lotteries.get(0).getNumber2();
				}else if(i==2){
					num=lotteries.get(0).getNumber3();
				}else if(i==3){
					num=lotteries.get(0).getNumber4();
				}else if(i==4){
					num=lotteries.get(0).getNumber5();
				}
				List<CqsscGuilv> kills=guilvService.findLists(qi, num,ta,typeLottery);
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
			
			 
		}
	  
	   
			
			
			
		 
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,1,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,2,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,3,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi, ta,1,typeLottery);
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
		
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi, ta,2,typeLottery);
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
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi, ta,3,typeLottery);
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
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,4,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,5,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi-1, ta,1,typeLottery);
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
		
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi-1, ta,2,typeLottery);
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
 
	  
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,7,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
	 
       
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,8,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,9,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
		
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, ta,10,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
	 
		if(sBuffer.length()<3){
			List<CqsscGuilv> kills=guilvService.findLists4(qi+1, type,10,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					 
				}
				 
					
				 
			} 
		}
		
	  
		
	}
	
	
	private static void getValue(StringBuffer sBuffer,int qi,int type,CqsscGuilvKillService guilv4Service,
			CqsscGuilvService guilvService,List<CqsscLottery> lotteries,StringBuffer cc1,StringBuffer cc2,StringBuffer cc3
			,String typeLottery){
		
		
		int c1=0;int c2=0;int c3=0; 
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
					c1++;
				} 
					
				 
			} 
		}
		
		
	 
		if(sBuffer.length()<6){
			List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					4, type, 1, 2);

			for (CqsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		 
		 
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						10, type, 2, 4);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
		if(sBuffer.length()<6){
			List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					7, type, 0, 2);

			for (CqsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		if(sBuffer.length()<6){
			List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					7, type, 2, 2);

			for (CqsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		if(sBuffer.length()<6){
			List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					14, type, 3, 4);

			for (CqsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		
		if(sBuffer.length()<6){
			List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					12, type, 3, 3);

			for (CqsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		if(sBuffer.length()<6){
			List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					10, type, 3, 2);

			for (CqsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		 if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						5, type, 1, 3);

				for (CqsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					
					 
					 
				}	
			}
		
		
		 

		 

			
			
		 
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						10, type, 0, 5);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			
			
			
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						9, type, 0, 4);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			


			
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						8, type, 2, 3);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						7, type, 0, 3);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						6, type, 1, 4);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						7, type, 1, 5);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
		 
			
			 
			
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						14, type, 3, 5);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			
			
			
	
			
			
			
		 
		if(sBuffer.length()<6){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, type,1,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c2++;
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<6){
			List<CqsscGuilv> kills=guilvService.findLists3(qi+1, type,2,typeLottery);
			for(CqsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c2++;
				}
				 
					
				 
			} 
		}
		
 
		
		if(sBuffer.length()<6){
		
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
					c2++;
				} 
					
				 
			} 
		}
		
		
 
		
	 
		
		
		
		
		
		 if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						6, type, 1, 5);

				for (CqsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					
					 
					 
				}	
			}
		 
		 
		 if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						5, type, 1, 4);

				for (CqsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					
					 
					 
				}	
			}
		 if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						9, type, 0, 5);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					 
					
				}
			}
			if(sBuffer.length()<6){
				List<CqsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						9, type, 2, 5);

				for (CqsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					 
					
				}
			}
		
		
		
		if(sBuffer.length()<6){
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
					c3++;
				} 
					
				 
			} 
		}
		
	
		 
		
		
		
		
		


	 
	 
	
 cc1.append(c1+"");
 cc2.append(c2+"");
 cc3.append(c3+"");
		
	}
	
	
	private void setPlanF(int qi){

		CqsscPlan plan2=this.planService.findPlan(qi+1,1);
		
		
		if(plan2==null){
		
		CqsscPlan plan=this.planService.findPlan( 1);
		
		 CqsscLottery lottery2=this.lotteryService.findReport("qi", qi);
		 
		 
	 
		

	
		
			plan2=new CqsscPlan();
			 
			for(int type=0;type<=4;type++){
				PageView<CqsscGuilv> pageViewGuilv = new PageView<CqsscGuilv>();
				List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
				
				filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
				filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, lottery2.getQi()+1));
				filtersnewses.add(new PropertyFilter("typeLottery", MatchType.EQ, "ssc"));
				pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
						filtersnewses));
				List<CqsscGuilv> guilvs = pageViewGuilv.getRecords();
			  
			 
				 
				ComparatorCqsscGuilv guilv = new ComparatorCqsscGuilv();

				Collections.sort(guilvs, guilv);
				
				
				if(!guilvs.isEmpty()){
					if(type==0){
						plan2.setNumber1(guilvs.get(0).getValue());
					}
					
					if(type==1){
						plan2.setNumber2(guilvs.get(0).getValue());
					}
					
					if(type==2){
						plan2.setNumber3(guilvs.get(0).getValue());
					}
					
					if(type==3){
						plan2.setNumber4(guilvs.get(0).getValue());
					}
					
					if(type==4){
						plan2.setNumber5(guilvs.get(0).getValue());
					}
					
				}

				
			}
			
			if(plan!=null){
				if(plan.getErrorNum()!=0){
					plan2.setType3(1);
				}
					
					
					 
					plan2.setQi(qi+1);
					plan2.setType(1);
					 
						plan2.setErrorMin(plan.getErrorMin());
						plan2.setCountNum(plan.getCountNum());
						plan2.setCountMin(plan.getCountMin());
					    plan2.setErrorNum(plan.getErrorNum());	
					    plan2.setPrize1(plan.getPrize1());
					 
					this.planService.savePlan(plan2);
					 	
			}else{
				plan2.setQi(qi+1);
				plan2.setType(1); 
				this.planService.savePlan(plan2);
			}
		
		}
		
	}

	private void s2(int addition,int b,int type,int fixation, CqsscLotteryService lotteryService, CqsscGuilvService guilvService,List<CqsscLottery> lotteries){
		  
	       
	    List<CqsscGuilv> sbr = new ArrayList<CqsscGuilv>();
 
            int count=1;
			  
	    CqsscGuilvUtils.setQuery(addition, b, type, count, fixation, 1, 1, lotteryService, guilvService, sbr,true,lotteries);	
		 
	}
 
	
	private void s3(int addition,int b,int type,int fixation, CqsscLotteryService lotteryService, CqsscGuilvKillService guilvService,List<CqsscLottery> lotteries){
		  
	       for(int n=0;n<4;n++){
	    	   
	    	   List<CqsscGuilvKill> sbr = new ArrayList<CqsscGuilvKill>();
	    	   int count=4;
	           if(n==0&&addition==2){
	        	   count=4;
	           }else if(n==0&&addition==3){
	        	   count=7; 
	           }else if(n==1&&addition==2){
	        	   count=3; 
	           }else if(n==1&&addition==3){
	        	   count=4; 
	           }else if(n==2&&addition==2){
	        	   count=4; 
	           }else if(n==2&&addition==3){
	        	   count=7; 
	           }else if(n==3&&addition==2){
	        	   count=7; 
	           }else if(n==3&&addition==3){
	        	   count=9; 
	           }else if(n==3&&addition==4){
	        	   count=12; 
	           }else if(n==3&&addition==5){
	        	   count=12; 
	           }else if(n==2&&addition==5){
	        	   count=9; 
	           }else if(n==0&&addition==5){
	        	   count=9; 
	           }else if(n==0&&addition==4){
	        	   count=8; 
	           }else if(n==2&&addition==4){
	        	   count=8; 
	           }else if(n==1&&addition==4){
	        	   count=5; 
	           }else if(n==1&&addition==5){
	        	   count=6; 
	           }
	             
				  
		   CqsscGuilvKillUtils.setQuery(addition, b, type, count, fixation, 1, n, lotteryService, guilvService, sbr,true,lotteries);   
	       }
	   	
		 
		 
	}

 
}
