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
import org.springframework.stereotype.Component;   
import org.springframework.stereotype.Service;

import com.sky.apps.action.lottery.web.job.guilv.QueryComm;
import com.sky.apps.action.lottery.web.utils.guilv.TJsscGuilvKillUtils;
import com.sky.apps.action.lottery.web.utils.guilv.TjsscGuilvUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorTjsscGuilv;
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;  
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.TJsscGuilvKill;
import com.sky.modules.lottery.entity.guilv.TjsscGuilv; 
import com.sky.modules.lottery.entity.guilv.TjsscLottery;   
import com.sky.modules.lottery.entity.guilv.TjsscPlan;
import com.sky.modules.lottery.service.guilv.TjsscGuilvService;
import com.sky.modules.lottery.service.guilv.TJsscGuilvKillService;   
import com.sky.modules.lottery.service.guilv.TjsscLotteryService;  
import com.sky.modules.lottery.service.guilv.TjsscPlanService;

 
 

@Service("TjsscGuilvScanner") 
public class TjsscGuilvScanner implements QueryComm{

	@Autowired
	private TjsscLotteryService lotteryService;
	
	@Autowired
	private TjsscGuilvService guilvService;
	
	@Autowired
	private TJsscGuilvKillService guilv4Service;
	@Autowired private TjsscPlanService planService;
	public void job() {
	 
		 
		PageView<TjsscLottery> pageView = new PageView<TjsscLottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
       
		List<TjsscLottery> lotteries = pageView.getRecords(); 
		Long qi=lotteries.get(0).getQi();
		   int b=3;  
	 	for(int addition=2;addition<=3;addition++){ 
				  int f=0; 
                for(int type=0;type<=4;type++){  
						 s2(addition, b, type, f, lotteryService, guilvService,lotteries);
					} 	 
		}	
		 
	 	 setPlan(qi);
	 	b=3; 
		 
	 	 for(int addition=2;addition<=5;addition++){
			 
			 
	 		for(int type=0;type<=4;type++){
				
				 for(int f=0;9>=f;f++){
					 s3(addition, b, type, f, lotteryService, guilv4Service, lotteries); 
				 }
				
			}
	}	 	
	 	  setPlan3(qi, lotteries);  
          setPlan8(qi, lotteries); 
		 
	}
	
	
	
	private void setPlan(long qi){

		TjsscPlan plan2=planService.findPlan(qi+1,1);
		
		 
		if(plan2==null){
		
		TjsscPlan plan=planService.findPlan(1);
		
		 TjsscLottery lottery2=lotteryService.findReport("qi", qi);
		 
		 
		
		 
		 
		

	
		
			plan2=new TjsscPlan();
			 
			for(int type=0;type<=4;type++){
				PageView<TjsscGuilv> pageViewGuilv = new PageView<TjsscGuilv>();
				List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
				
				filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
				filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, lottery2.getQi()+1));
		 
				pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
						filtersnewses));
				List<TjsscGuilv> guilvs = pageViewGuilv.getRecords();
			  
			 
				 
				ComparatorTjsscGuilv guilv = new ComparatorTjsscGuilv();

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
					 
					planService.savePlan(plan2);
					 	
			}else{
				 
				plan2.setQi(qi+1);
				plan2.setType(1);
				 
				 
				 
				planService.savePlan(plan2);
			}
			
		}
		
	}
	
 
	
	
	private void setPlan8(long qi,List<TjsscLottery> lotteries){
		  
 
			//	Plan plan3=planService.findPlan( qi,2);
		
		
		 
		 
		 
		 
		
		
		 
	 
		//Plan2 plan=planService.findPlan(qi,6);
		 
		 
		
		 
		 
		TjsscPlan plan7=planService.findPlan(7);
	 
		 
	  
		TjsscPlan plan8=planService.findPlan(8);
	 
		 
		 
		 
		TjsscPlan plan9=planService.findPlan(9);
		 
		
	 
	 
		TjsscPlan plan10=planService.findPlan(10);
		 
		
		 
			 
		TjsscPlan plan11=planService.findPlan(11);
	 
		 
		 
		TjsscPlan plan12=planService.findPlan(15);
		 
		
		
		
		  
		
		
		 
			
		
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
			for(int type=0;type<=4;type++){
				 
			 
				if(type==0){ 
					 getValue(sBuffer1, qi, type, guilv4Service, guilvService, lotteries, cc1, cc2, cc3);
							 
						 
					 
					 
				 
					
				}else if(type==1){
					 
					 getValue(sBuffer2, qi, type, guilv4Service, guilvService, lotteries, dd1, dd2, dd3);
					
					  
						 
					
					 
				}else if(type==2){ 
					 getValue(sBuffer3, qi, type, guilv4Service, guilvService, lotteries, ee1, ee2,ee3);
					 
				}else if(type==3){
				 
					 getValue(sBuffer4, qi, type, guilv4Service, guilvService, lotteries, ff1, ff2, ff3);
						 
						
				}else if(type==4){
					
					 getValue(sBuffer5, qi, type, guilv4Service, guilvService, lotteries, gg1, gg2, gg3);
				}
				
			
			}
			
			  
			int c1=Integer.parseInt(cc1.toString());int c2=Integer.parseInt(cc2.toString());int c3=Integer.parseInt(cc3.toString());
			int d1=Integer.parseInt(dd1.toString());int d2=Integer.parseInt(dd2.toString());int d3=Integer.parseInt(dd3.toString());  
			int e1=Integer.parseInt(ee1.toString());int e2=Integer.parseInt(ee2.toString());int e3=Integer.parseInt(ee3.toString()); 
			int f1=Integer.parseInt(ff1.toString());int f2=Integer.parseInt(ff2.toString());int f3=Integer.parseInt(ff3.toString());
			int g1=Integer.parseInt(gg1.toString());int g2=Integer.parseInt(gg2.toString());int g3=Integer.parseInt(gg3.toString());
			
			 
		 
			 
		   /*  List<String> tempList=new ArrayList<String>();
			if(c1>0){
				tempList.add("c1");
			}
			if(d1>0){
				tempList.add("d1");
			}
			
			if(e1>0){
				tempList.add("e1");
			}
			if(f1>0){
				tempList.add("f1");
			}
			
			if(g1>0){
				tempList.add("g1");
			}
			
			if(tempList.size()>1){
				if(tempList.size()==2){
					String tString=tempList.get(0);
					if("c1".equals(tString)){
						 Plan4.setNumber1(sBuffer1.toString());
					}
					if("d1".equals(tString)){
						 Plan4.setNumber2(sBuffer2.toString());
					}
					if("e1".equals(tString)){
						 Plan4.setNumber3(sBuffer3.toString());
					}
					if("f1".equals(tString)){
						 Plan4.setNumber4(sBuffer4.toString());
					}
					if("g1".equals(tString)){
						 Plan4.setNumber5(sBuffer5.toString());
					}
					tString=tempList.get(1);
					if("c1".equals(tString)){
						 Plan4.setNumber1(sBuffer1.toString());
					}
					if("d1".equals(tString)){
						 Plan4.setNumber2(sBuffer2.toString());
					}
					if("e1".equals(tString)){
						 Plan4.setNumber3(sBuffer3.toString());
					}
					if("f1".equals(tString)){
						 Plan4.setNumber4(sBuffer4.toString());
					}
					if("g1".equals(tString)){
						 Plan4.setNumber5(sBuffer5.toString());
					}
					
					
				}else{
					HashMap<String,Integer> map = new HashMap<String,Integer>();  
					 MapValueComparator bvc =  new MapValueComparator(map);  
				        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);  
				        for(int i=0;i<tempList.size();i++){
				        	if("c1".equals(tempList.get(i))){
				        		map.put("c1",c1);  
							}
							if("d1".equals(tempList.get(i))){
								map.put("d1",d1); 
							}
							if("e1".equals(tempList.get(i))){
								map.put("e1",e1); 
							}
							if("f1".equals(tempList.get(i))){
								map.put("f1",f1); 
							}
							if("g1".equals(tempList.get(i))){
								map.put("g1",g1); 
							}
				        }
				        
				        sorted_map.putAll(map);
				        
				        Iterator iter = map.keySet().iterator();
				        int k=0;
				      while(iter.hasNext()){
				    	  String key = (String) iter.next();
				    	   
							if("c1".equals(key)){
								 Plan4.setNumber1(sBuffer1.toString());
							}
							if("d1".equals(key)){
								 Plan4.setNumber2(sBuffer2.toString());
							}
							if("e1".equals(key)){
								 Plan4.setNumber3(sBuffer3.toString());
							}
							if("f1".equals(key)){
								 Plan4.setNumber4(sBuffer4.toString());
							}
							if("g1".equals(key)){
								 Plan4.setNumber5(sBuffer5.toString());
							} 
							 
				    	  k++;
				    	  if(k>=2){
				    		  break;
				    	  }
				      }
				        
				        
				}
			}else if(tempList.size()==1){
				String tString=tempList.get(0);
				if("c1".equals(tString)){
					 Plan4.setNumber1(sBuffer1.toString());
				}
				if("d1".equals(tString)){
					 Plan4.setNumber2(sBuffer2.toString());
				}
				if("e1".equals(tString)){
					 Plan4.setNumber3(sBuffer3.toString());
				}
				if("f1".equals(tString)){
					 Plan4.setNumber4(sBuffer4.toString());
				}
				if("g1".equals(tString)){
					 Plan4.setNumber5(sBuffer5.toString());
				}
				
				 List<String> tempList2=new ArrayList<String>();
					if(c2>0&&plan2.getNumber1()==null){
						tempList2.add("c2");
					}
					if(d2>0&&plan2.getNumber2()==null){
						tempList2.add("d2");
					}
					
					if(e2>0&&plan2.getNumber3()==null){
						tempList2.add("e2");
					}
					if(f2>0&&plan2.getNumber4()==null){
						tempList2.add("f2");
					}
					
					if(g2>0&&plan2.getNumber5()==null){
						tempList2.add("g2");
					}
					
					if(tempList2.size()>=1){
						HashMap<String,Integer> map = new HashMap<String,Integer>();  
						 MapValueComparator bvc =  new MapValueComparator(map);  
					        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);  
					        for(int i=0;i<tempList.size();i++){
					        	if("c2".equals(tempList.get(i))){
					        		map.put("c2",c2);  
								}
								if("d2".equals(tempList.get(i))){
									map.put("d2",d2); 
								}
								if("e2".equals(tempList.get(i))){
									map.put("e2",e2); 
								}
								if("f2".equals(tempList.get(i))){
									map.put("f2",f2); 
								}
								if("g2".equals(tempList.get(i))){
									map.put("g2",g2); 
								}
					        }
					        
					        sorted_map.putAll(map);
					        
					        Iterator iter = map.keySet().iterator();
					        int k=0;
					      while(iter.hasNext()){
					    	  String key = (String) iter.next();
					    	   
								if("c2".equals(key)){
									 plan2.setNumber1(sBuffer1.toString());
								}
								if("d2".equals(key)){
									 plan2.setNumber2(sBuffer2.toString());
								}
								if("e2".equals(key)){
									 plan2.setNumber3(sBuffer3.toString());
								}
								if("f2".equals(key)){
									 plan2.setNumber4(sBuffer4.toString());
								}
								if("g2".equals(key)){
									 plan2.setNumber5(sBuffer5.toString());
								} 
								 
					    	  k++;
					    	  if(k>=1){
					    		  break;
					    	  }
					      }
					}else{
						if(plan2.getNumber1()==null){
							 plan2.setNumber1(sBuffer1.toString());
						}else{
							if(plan2.getNumber2()==null){
								 plan2.setNumber2(sBuffer2.toString());
							}else{
								if(plan2.getNumber3()==null){
									 plan2.setNumber3(sBuffer3.toString());
								}else{
									if(plan2.getNumber4()==null){
										plan2.setNumber4(sBuffer4.toString());
									}else{
										plan2.setNumber5(sBuffer5.toString());
									}
								}
							}
						}
					}
					
			}else{
			     List<String> tempList3=new ArrayList<String>();
					if(c2>0){
						tempList.add("c2");
					}
					if(d2>0){
						tempList.add("d2");
					}
					
					if(e2>0){
						tempList.add("e2");
					}
					if(f2>0){
						tempList.add("f2");
					}
					
					if(g2>0){
						tempList.add("g2");
					}
					if(tempList3.size()>1){
						if(tempList.size()==2){
							String tString=tempList.get(0);
							if("c2".equals(tString)){
								 plan2.setNumber1(sBuffer1.toString());
							}
							if("d2".equals(tString)){
								 plan2.setNumber2(sBuffer2.toString());
							}
							if("e2".equals(tString)){
								 plan2.setNumber3(sBuffer3.toString());
							}
							if("f2".equals(tString)){
								 plan2.setNumber4(sBuffer4.toString());
							}
							if("g2".equals(tString)){
								 plan2.setNumber5(sBuffer5.toString());
							}
							tString=tempList.get(1);
							if("c2".equals(tString)){
								 plan2.setNumber1(sBuffer1.toString());
							}
							if("d2".equals(tString)){
								 plan2.setNumber2(sBuffer2.toString());
							}
							if("e2".equals(tString)){
								 plan2.setNumber3(sBuffer3.toString());
							}
							if("f2".equals(tString)){
								 plan2.setNumber4(sBuffer4.toString());
							}
							if("g2".equals(tString)){
								 plan2.setNumber5(sBuffer5.toString());
							}
							
							
						}else{
							HashMap<String,Integer> map = new HashMap<String,Integer>();  
							 MapValueComparator bvc =  new MapValueComparator(map);  
						        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);  
						        for(int i=0;i<tempList.size();i++){
						        	if("c2".equals(tempList.get(i))){
						        		map.put("c2",c2);  
									}
									if("d2".equals(tempList.get(i))){
										map.put("d2",d2); 
									}
									if("e2".equals(tempList.get(i))){
										map.put("e2",e2); 
									}
									if("f2".equals(tempList.get(i))){
										map.put("f2",f2); 
									}
									if("g2".equals(tempList.get(i))){
										map.put("g2",g2); 
									}
						        }
						        
						        sorted_map.putAll(map);
						        
						        Iterator iter = map.keySet().iterator();
						        int k=0;
						      while(iter.hasNext()){
						    	  String key = (String) iter.next();
						    	   
									if("c2".equals(key)){
										 plan2.setNumber1(sBuffer1.toString());
									}
									if("d2".equals(key)){
										 plan2.setNumber2(sBuffer2.toString());
									}
									if("e2".equals(key)){
										 plan2.setNumber3(sBuffer3.toString());
									}
									if("f2".equals(key)){
										 plan2.setNumber4(sBuffer4.toString());
									}
									if("g2".equals(key)){
										 plan2.setNumber5(sBuffer5.toString());
									} 
									 
						    	  k++;
						    	  if(k>=2){
						    		  break;
						    	  }
						      }
						        
						        
						}
					}else if(tempList3.size()==1){
						String tString=tempList3.get(0);
						if("c2".equals(tString)){
							 plan2.setNumber1(sBuffer1.toString());
						}
						if("d2".equals(tString)){
							 plan2.setNumber2(sBuffer2.toString());
						}
						if("e2".equals(tString)){
							 plan2.setNumber3(sBuffer3.toString());
						}
						if("f2".equals(tString)){
							 plan2.setNumber4(sBuffer4.toString());
						}
						if("g2".equals(tString)){
							 plan2.setNumber5(sBuffer5.toString());
						}
						
						if(plan2.getNumber1()==null){
							 plan2.setNumber1(sBuffer1.toString());
						}else{
							if(plan2.getNumber2()==null){
								 plan2.setNumber2(sBuffer2.toString());
							}else{
								if(plan2.getNumber3()==null){
									 plan2.setNumber3(sBuffer3.toString());
								}else{
									if(plan2.getNumber4()==null){
										plan2.setNumber4(sBuffer4.toString());
									}else{
										plan2.setNumber5(sBuffer5.toString());
									}
								}
							}
						}
						
					}else{
						 plan2.setNumber1(sBuffer1.toString());
						 plan2.setNumber2(sBuffer2.toString());
					}
			}
			*/
			long s=qi+1;
			String string="经电脑概率分析，"+s+"期，万位杀数为："+sBuffer1.toString()+",其中第一条件杀数"+c1+"个，第二条件杀数"+c2+"个，第三条件杀数"+c3+"个。千位杀数为："	
					+sBuffer2.toString()+",其中第一条件杀数"+d1+"个，第二条件杀数"+d2+"个，第三条件杀数"+d3+"个。百位杀数为："
			         +sBuffer3.toString()+",其中第一条件杀数"+e1+"个，第二条件杀数"+e2+"个，第三条件杀数"+e3+"个。十位杀数为："
			         +sBuffer4.toString()+",其中第一条件杀数"+f1+"个，第二条件杀数"+f2+"个，第三条件杀数"+f3+"个。个位杀数为："
			         +sBuffer5.toString()+",其中第一条件杀数"+g1+"个，第二条件杀数"+g2+"个，第三条件杀数"+g3+"个。";
			 
			try{
				
			
			TjsscPlan	plan2=planService.findPlan(qi+1, 6);
			if(plan2==null){
				
			
				plan2=	new TjsscPlan();	     
		        
			//plan2.setSum(num+1);
			plan2.setQi(qi+1);
			plan2.setType(6);
		/*	if(num!=0){
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
			    	
			}*/  
			
			
			/*if(plan2.getNumber1()!=null&&sBuffer1.length()>3){
				 plan2.setNumber1(sBuffer1.subSequence(0,3).toString());
			 }
			if(plan2.getNumber2()!=null&&sBuffer2.length()>3){
				 plan2.setNumber2(sBuffer2.subSequence(0,3).toString());
			 }
			if(plan2.getNumber3()!=null&&sBuffer3.length()>3){
				 plan2.setNumber3(sBuffer3.subSequence(0,3).toString());
			 }
			if(plan2.getNumber4()!=null&&sBuffer4.length()>3){
				 plan2.setNumber4(sBuffer4.subSequence(0,3).toString());
			 }
			if(plan2.getNumber5()!=null&&sBuffer5.length()>3){
				 plan2.setNumber5(sBuffer5.subSequence(0,3).toString());
			 }*/
	
			plan2.setNumber7(string);
	  planService.savePlan(plan2);
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try{
			
	  TjsscPlan	plan77=planService.findPlan(qi+1, 7);
	  if(plan77==null){
			  
			 plan77= new TjsscPlan();
			    if(plan7!=null){
			    	
			    	  String ss="";
		        	  int count=0;
	   				if(c1>=2){
	   					ss="*";
	   					count++;
	   				}
	   			    String ss2="";
	   				if(d1>=2){
	 					ss2="*";
	 					count++;
	 				}
	   			  
					 if(plan7.getErrorNum()!=0){
						 if(count<2){
							  plan77.setType3(1);    
						  } 
					 }
						    
							plan77.setQi(qi+1);
							plan77.setType(7);
							 
								
								plan77.setErrorMin(plan7.getErrorMin());
								plan77.setCountNum(plan7.getCountNum());
								plan77.setCountMin(plan7.getCountMin());
							    plan77.setErrorNum(plan7.getErrorNum());	
							    plan77.setPrize1(plan7.getPrize1());
							 
							int c7=0;
							if(sBuffer1.length()>=3){
								c7++;
								 
								 plan77.setNumber1(sBuffer1.subSequence(0,3).toString()+ss);
							 } 
							if(sBuffer2.length()>=3){
								c7++;
								 
								 plan77.setNumber2(sBuffer2.subSequence(0,3).toString()+ss2);
							 } 
							    if(c7>=2){
							    	planService.savePlan(plan77);
							    }
						   
			    }else{
					 
						    
							plan77.setQi(qi+1);
							plan77.setType(7);
							 
							 
							 
							int c7=0;
							if(sBuffer1.length()>=3){
								c7++;
								String ss="";
								if(c1>=2){
									ss="*";
								}
								 plan77.setNumber1(sBuffer1.subSequence(0,3).toString()+ss);
							 } 
							if(sBuffer2.length()>=3){
								c7++;
								String ss="";
								if(d1>=2){
									ss="*";
								}
								 plan77.setNumber2(sBuffer2.subSequence(0,3).toString()+ss);
							 } 
							    if(c7>=2){
							    	planService.savePlan(plan77);
							    }
						  
			    }
	
	  }
		  
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try{
	  TjsscPlan  plan88=planService.findPlan(qi+1, 8);
	  if(plan88==null){
		  
	  
			  
			  
			  plan88=new TjsscPlan();
			  if(plan8!=null){
			     int count=0;
   				String ss4="";
   				if(f1>=2){
 					ss4="*";
 					count++;
 				}
   				String ss5="";
   				if(g1>=2){
 					ss5="*";
 					count++;
 				}
				  
				  if(plan8.getErrorNum()!=0){
					  if(count<2){
						  plan88.setType3(1);    
					  }  
				  }
					   
						plan88.setQi(qi+1);
						plan88.setType(8);
						 
							plan88.setErrorMin(plan8.getErrorMin());
							plan88.setCountNum(plan8.getCountNum());
							plan88.setCountMin(plan8.getCountMin());
						    plan88.setErrorNum(plan8.getErrorNum());	
						    plan88.setPrize1(plan8.getPrize1());
						 
						
						int c8=0;
						if(sBuffer4.length()>=3){
							c8++;
						 
							 plan88.setNumber4(sBuffer4.subSequence(0,3).toString()+ss4);
						 } 
						if(sBuffer5.length()>=3){
							c8++;
							 
							 plan88.setNumber5(sBuffer5.subSequence(0,3).toString()+ss5);
						 } 
						   if(c8>=2){
							   planService.savePlan(plan88);
						   }
				  
			  }else{
				  
					    
						plan88.setQi(qi+1);
						plan88.setType(8);
						 
						 
						
						int c8=0;
						if(sBuffer4.length()>=3){
							c8++;
							String ss="";
							if(f1>=2){
								ss="*";
							}
							 plan88.setNumber4(sBuffer4.subSequence(0,3).toString()+ss);
						 } 
						if(sBuffer5.length()>=3){
							c8++;
							String ss="";
							if(g1>=2){
								ss="*";
							}
							 plan88.setNumber5(sBuffer5.subSequence(0,3).toString()+ss);
						 } 
						   if(c8>=2){
							   planService.savePlan(plan88);
						   }
				  
			  }

	  }
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		
			try{
				 
			  
			  TjsscPlan	plan99=planService.findPlan(qi+1, 9);
			  if(plan99==null){
					  plan99=new TjsscPlan();
			  //  plan99.setSum(num9+1);
					  if(plan9!=null){
						  String ss="";
			        	  int count=0;
		   				if(c1>=2){
		   					ss="*";
		   					count++;
		   				}
		   			    
		   				String ss5="";
		   				if(g1>=2){
		 					ss5="*";
		 					count++;
		 				}
							if(plan9.getErrorNum()!=0){
								 if(count<2){
									  plan99.setType3(1);    
								  } 
							}
								plan99.setQi(qi+1);
								plan99.setType(9);
								 
									plan99.setErrorMin(plan9.getErrorMin());
									plan99.setCountNum(plan9.getCountNum());
									plan99.setCountMin(plan9.getCountMin());
								    plan99.setErrorNum(plan9.getErrorNum());	
								    plan99.setPrize1(plan9.getPrize1());
								 
								int c9=0;
								if(sBuffer1.length()>=3){
									c9++;
									 
									 plan99.setNumber1(sBuffer1.subSequence(0,3).toString()+ss);
								 } 
								if(sBuffer5.length()>=3){
									c9++;
									 
									 plan99.setNumber5(sBuffer5.subSequence(0,3).toString()+ss5);
								 } 
								
								if(c9>=2){
									 planService.savePlan(plan99);
								}
						    
					  }else{
							 
								plan99.setQi(qi+1);
								plan99.setType(9);
								 
								 
								int c9=0;
								if(sBuffer1.length()>=3){
									c9++;
									String ss="";
									if(c1>=2){
										ss="*";
									}
									 plan99.setNumber1(sBuffer1.subSequence(0,3).toString()+ss);
								 } 
								if(sBuffer5.length()>=3){
									c9++;
									String ss="";
									if(g1>=2){
										ss="*";
									}
									 plan99.setNumber5(sBuffer5.subSequence(0,3).toString()+ss);
								 } 
								
								if(c9>=2){
									 planService.savePlan(plan99);
								}
						   
					  }
	
			  }	 
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		
			try{
				  
				  TjsscPlan	plan100=planService.findPlan(qi+1, 10);
				  if(plan100==null){
						  
					  
				  
					  plan100= new TjsscPlan();
				   // plan100.setSum(num10+1);
					  if(plan10!=null){
						  String ss="";
			        	  int count=0;
		   				if(c1>=2){
		   					ss="*";
		   					count++;
		   				}
		   			    String ss2="";
		   				if(d1>=2){
		 					ss2="*";
		 					count++;
		 				}
		   			 String ss3="";
		   				if(e1>=2){
		 					ss3="*";
		 					count++;
		 				}
		   				 
						  
							if(plan10.getErrorNum()!=0){
								 if(count<2){
									  plan100.setType3(1);    
								  } 
							}
								plan100.setQi(qi+1);
								plan100.setType(10);
								 
									plan100.setErrorMin(plan10.getErrorMin());
									plan100.setCountNum(plan10.getCountNum());
									plan100.setCountMin(plan10.getCountMin());
								    plan100.setErrorNum(plan10.getErrorNum());	
								    plan100.setPrize1(plan10.getPrize1());
								 
								int c10=0;
								if(sBuffer1.length()>=2){
									c10++;
									 
									 plan100.setNumber1(sBuffer1.subSequence(0,2).toString()+ss);
								 } 
								if(sBuffer2.length()>=2){
									c10++;
									 
									 plan100.setNumber2(sBuffer2.subSequence(0,2).toString()+ss2);
								 } 
								
								if(sBuffer3.length()>=2){
									c10++;
									 
									 plan100.setNumber3(sBuffer3.subSequence(0,2).toString()+ss3);
								 } 
								  if(c10>=3){
									  planService.savePlan(plan100); 
								  }
								  
							   
					  }else{
							 
								plan100.setQi(qi+1);
								plan100.setType(10);
								 
							 
								 
								int c10=0;
								if(sBuffer1.length()>=2){
									c10++;
									String ss="";
									if(c1>=2){
										ss="*";
									}
									 plan100.setNumber1(sBuffer1.subSequence(0,2).toString()+ss);
								 } 
								if(sBuffer2.length()>=2){
									c10++;
									String ss="";
									if(d1>=2){
										ss="*";
									}
									 plan100.setNumber2(sBuffer2.subSequence(0,2).toString()+ss);
								 } 
								
								if(sBuffer3.length()>=2){
									c10++;
									String ss="";
									if(e1>=2){
										ss="*";
									}
									 plan100.setNumber3(sBuffer3.subSequence(0,2).toString()+ss);
								 } 
								  if(c10>=3){
									  planService.savePlan(plan100); 
								  }
								  
							  
					  }
						}}catch (Exception e) {
						// TODO: handle exception
					}
			
			try{
					  
					  TjsscPlan	plan110=planService.findPlan(qi+1, 11);
					  if(plan110==null){
							  plan110=new TjsscPlan();
					   // plan110.setSum(num11+1);
							  if(plan11!=null){
								 
					        	  int count=0;
				   				 
				   			 String ss3="";
				   				if(e1>=2){
				 					ss3="*";
				 					count++;
				 				}
				   				String ss4="";
				   				if(f1>=2){
				 					ss4="*";
				 					count++;
				 				}
				   				String ss5="";
				   				if(g1>=2){
				 					ss5="*";
				 					count++;
				 				}
								  
								  if(plan11.getErrorNum()!=0){
									  if(count<2){
										  plan110.setType3(1);    
									  } 
								  }
									  
										plan110.setQi(qi+1);
										plan110.setType(11);
										 
											plan110.setErrorMin(plan11.getErrorMin());
											plan110.setCountNum(plan11.getCountNum());
											plan110.setCountMin(plan11.getCountMin());
										    plan110.setErrorNum(plan11.getErrorNum());	
										    plan110.setPrize1(plan11.getPrize1());
										 
										int c11=0;
										if(sBuffer3.length()>=2){
											c11++;
											 
											 plan110.setNumber3(sBuffer3.subSequence(0,2).toString()+ss3);
										 } 
										if(sBuffer4.length()>=2){
											c11++;
											 
											 plan110.setNumber4(sBuffer4.subSequence(0,2).toString()+ss4);
										 } 
										if(sBuffer5.length()>=2){
											c11++;
										 
											 plan110.setNumber5(sBuffer5.subSequence(0,2).toString()+ss5);
										 } 
									
							             if(c11>=3){
							            	 planService.savePlan(plan110);
							             }
										 
									 
							  }else{
								  
										plan110.setQi(qi+1);
										plan110.setType(11);
										 
										 
										 
										int c11=0;
										if(sBuffer3.length()>=2){
											c11++;
											String ss="";
											if(e1>=2){
												ss="*";
											}
											 plan110.setNumber3(sBuffer3.subSequence(0,2).toString()+ss);
										 } 
										if(sBuffer4.length()>=2){
											c11++;
											String ss="";
											if(f1>=2){
												ss="*";
											}
											 plan110.setNumber4(sBuffer4.subSequence(0,2).toString()+ss);
										 } 
										if(sBuffer5.length()>=2){
											c11++;
											String ss="";
											if(g1>=2){
												ss="*";
											}
											 plan110.setNumber5(sBuffer5.subSequence(0,2).toString()+ss);
										 } 
									
							             if(c11>=3){
							            	 planService.savePlan(plan110);
							             }
										 
									   
							  }
					}}catch (Exception e) {
							// TODO: handle exception
						}
			
			
			try{
						  TjsscPlan	plan120=planService.findPlan(qi+1, 15);
						  if(plan120==null){
							  plan120= new TjsscPlan();
						 //   plan120.setSum(num12+1);
							  if(plan12!=null){
								  
								  String ss="";
					        	  int count=0;
				   				if(c1>=1){
				   					ss="*";
				   					count++;
				   				}
				   			    String ss2="";
				   				if(d1>=1){
				 					ss2="*";
				 					count++;
				 				}
				   			 String ss3="";
				   				if(e1>=1){
				 					ss3="*";
				 					count++;
				 				}
				   				String ss4="";
				   				if(f1>=1){
				 					ss4="*";
				 					count++;
				 				}
				   				String ss5="";
				   				if(g1>=1){
				 					ss5="*";
				 					count++;
				 				}
								  if(plan12.getErrorNum()!=0){
									  if(count<3){
										  plan120.setType3(1);    
									  } 
										 
									   
									 
								  }
										plan120.setQi(qi+1);
										plan120.setType(15);
										 
											plan120.setErrorMin(plan12.getErrorMin());
											plan120.setCountNum(plan12.getCountNum());
											plan120.setCountMin(plan12.getCountMin());
										    plan120.setErrorNum(plan12.getErrorNum());	
										    plan120.setPrize1(plan12.getPrize1());
										 
										
										int c12=0;
										if(sBuffer1.length()>=1){
											c12++;
											 
											 plan120.setNumber1(sBuffer1.subSequence(0,1).toString()+ss);
										 } 
										if(sBuffer2.length()>=1){
											c12++;
											 
											 plan120.setNumber2(sBuffer2.subSequence(0,1).toString()+ss2);
										 }
										if(sBuffer3.length()>=1){
											c12++;
											 
											 plan120.setNumber3(sBuffer3.subSequence(0,1).toString()+ss3);
										 }
										
										if(sBuffer4.length()>=1){
											c12++;
											 
											 plan120.setNumber4(sBuffer4.subSequence(0,1).toString()+ss4);
										 }
										
										if(sBuffer5.length()>=1){
											c12++;
											 
											 plan120.setNumber5(sBuffer5.subSequence(0,1).toString()+ss5);
										 }
									
							             if(c12>=5){
							            	 planService.savePlan(plan120);
							             }
									  
							  }else{
								 
										plan120.setQi(qi+1);
										plan120.setType(15);
										  
										
										int c12=0;
										if(sBuffer1.length()>=1){
											c12++;
											String ss="";
											if(c1>=1){
												ss="*";
											}
											 plan120.setNumber1(sBuffer1.subSequence(0,1).toString()+ss);
										 } 
										if(sBuffer2.length()>=1){
											c12++;
											String ss="";
											if(d1>=1){
												ss="*";
											}
											 plan120.setNumber2(sBuffer2.subSequence(0,1).toString()+ss);
										 }
										if(sBuffer3.length()>=1){
											c12++;
											String ss="";
											if(e1>=1){
												ss="*";
											}
											 plan120.setNumber3(sBuffer3.subSequence(0,1).toString()+ss);
										 }
										
										if(sBuffer4.length()>=1){
											c12++;
											String ss="";
											if(f1>=1){
												ss="*";
											}
											 plan120.setNumber4(sBuffer4.subSequence(0,1).toString()+ss);
										 }
										
										if(sBuffer5.length()>=1){
											c12++;
											String ss="";
											if(g1>=1){
												ss="*";
											}
											 plan120.setNumber5(sBuffer5.subSequence(0,1).toString()+ss);
										 }
									
							             if(c12>=5){
							            	 planService.savePlan(plan120);
							             }
									  
										
							  }
   
			} }catch (Exception e) {
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
	
	private void setPlan3(long qi,List<TjsscLottery> lotteries){
	    
			TjsscPlan plan5=planService.findPlan(qi+1,5);
			 
			 
			  if(plan5==null){  
			
			TjsscPlan plan=planService.findPlan(5);
		
			 TjsscLottery lottery2=lotteryService.findReport("qi", qi);
		 
			 
			
			 
		 
			

		
			
			TjsscPlan	plan2=new TjsscPlan();
			 
				 
				 
				for(int type=0;type<=4;type++){
					 
					if(type==0){
						
						
						TjsscGuilv k=guilvService.findGuilvKill7(qi+1, type) ;
						if(k!=null){
							 plan2.setNumber1(k.getValue()) ;
						 }else{
							 
							 TJsscGuilvKill  kill2=guilv4Service.findGuilvKill8(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber1(kill2.getValue());
								}else{
									 
									 TJsscGuilvKill  kill3=guilv4Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber1(kill3.getValue().substring(0,1));
									}else{
										 TJsscGuilvKill  kill4=guilv4Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber1(kill4.getValue().substring(0,1));
										 }else{
											 TJsscGuilvKill  kill5=guilv4Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber1(kill5.getValue().substring(0,1)); 
											 }else{
												 TJsscGuilvKill  kill6=guilv4Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber1(kill6.getValue().substring(0,1));  
												 }else{
													 TJsscGuilvKill  kill7=guilv4Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber1(kill7.getValue().substring(0,1)); 
													 }else{
														 TJsscGuilvKill  kill8=guilv4Service.findGuilvKill(qi+1, type,0,5,2);  
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
						
						
						TjsscGuilv k=guilvService.findGuilvKill7(qi+1, type) ;
						if(k!=null){
							 plan2.setNumber2(k.getValue()) ;
						 }else{
							 
							 TJsscGuilvKill  kill2=guilv4Service.findGuilvKill8(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber2(kill2.getValue());
								}else{
									 
									 TJsscGuilvKill  kill3=guilv4Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber2(kill3.getValue().substring(0,1));
									}else{
										 TJsscGuilvKill  kill4=guilv4Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber2(kill4.getValue().substring(0,1));
										 }else{
											 TJsscGuilvKill  kill5=guilv4Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber2(kill5.getValue().substring(0,1)); 
											 }else{
												 TJsscGuilvKill  kill6=guilv4Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber2(kill6.getValue().substring(0,1));  
												 }else{
													 TJsscGuilvKill  kill7=guilv4Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber2(kill7.getValue().substring(0,1)); 
													 }else{
														 TJsscGuilvKill  kill8=guilv4Service.findGuilvKill(qi+1, type,0,5,2);  
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
						
						
						TjsscGuilv k=guilvService.findGuilvKill7(qi+1, type) ;
						if(k!=null){
							 plan2.setNumber3(k.getValue()) ;
						 }else{
							 
							 TJsscGuilvKill  kill2=guilv4Service.findGuilvKill8(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber3(kill2.getValue());
								}else{
									 
									 TJsscGuilvKill  kill3=guilv4Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber3(kill3.getValue().substring(0,1));
									}else{
										 TJsscGuilvKill  kill4=guilv4Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber3(kill4.getValue().substring(0,1));
										 }else{
											 TJsscGuilvKill  kill5=guilv4Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber3(kill5.getValue().substring(0,1)); 
											 }else{
												 TJsscGuilvKill  kill6=guilv4Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber3(kill6.getValue().substring(0,1));  
												 }else{
													 TJsscGuilvKill  kill7=guilv4Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber3(kill7.getValue().substring(0,1)); 
													 }else{
														 TJsscGuilvKill  kill8=guilv4Service.findGuilvKill(qi+1, type,0,5,2);  
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
						
						TjsscGuilv k=guilvService.findGuilvKill7(qi+1, type) ;
						if(k!=null){
							 plan2.setNumber4(k.getValue()) ;
						 }else{
							 
							 TJsscGuilvKill  kill2=guilv4Service.findGuilvKill8(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber4(kill2.getValue());
								}else{
									 
									 TJsscGuilvKill  kill3=guilv4Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber4(kill3.getValue().substring(0,1));
									}else{
										 TJsscGuilvKill  kill4=guilv4Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber4(kill4.getValue().substring(0,1));
										 }else{
											 TJsscGuilvKill  kill5=guilv4Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber4(kill5.getValue().substring(0,1)); 
											 }else{
												 TJsscGuilvKill  kill6=guilv4Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber4(kill6.getValue().substring(0,1));  
												 }else{
													 TJsscGuilvKill  kill7=guilv4Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber4(kill7.getValue().substring(0,1)); 
													 }else{
														 TJsscGuilvKill  kill8=guilv4Service.findGuilvKill(qi+1, type,0,5,2);  
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
						
						TjsscGuilv k=guilvService.findGuilvKill7(qi+1, type) ;
						if(k!=null){
							 plan2.setNumber5(k.getValue()) ;
						 }else{
							 
							 TJsscGuilvKill  kill2=guilv4Service.findGuilvKill8(qi+1, type);
							 
							 
								if(kill2!=null){
									plan2.setNumber5(kill2.getValue());
								}else{
									 
									 TJsscGuilvKill  kill3=guilv4Service.findGuilvKill(qi+1, type,0,6,2);
									
									if(kill3!=null){
										plan2.setNumber5(kill3.getValue().substring(0,1));
									}else{
										 TJsscGuilvKill  kill4=guilv4Service.findGuilvKill(qi+1, type,2,6,2);
										 if(kill4!=null){
											 plan2.setNumber5(kill4.getValue().substring(0,1));
										 }else{
											 TJsscGuilvKill  kill5=guilv4Service.findGuilvKill(qi+1, type,3,7,3); 
											 if(kill5!=null){
												 plan2.setNumber5(kill5.getValue().substring(0,1)); 
											 }else{
												 TJsscGuilvKill  kill6=guilv4Service.findGuilvKill(qi+1, type,3,6,2);
												 if(kill6!=null){
													 plan2.setNumber5(kill6.getValue().substring(0,1));  
												 }else{
													 TJsscGuilvKill  kill7=guilv4Service.findGuilvKill(qi+1, type,2,5,2); 
													 if(kill7!=null){
														 plan2.setNumber5(kill7.getValue().substring(0,1)); 
													 }else{
														 TJsscGuilvKill  kill8=guilv4Service.findGuilvKill(qi+1, type,0,5,2);  
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
					  
					  planService.savePlan(plan2);	
			   
				
				
				}else{
					plan2.setQi(qi+1);
					plan2.setType(5);
					 
				  
				  planService.savePlan(plan2);
				}
  }  
			
		}
	

	
	
	private void setPlan5(long qi,List<TjsscLottery> lotteries){
	    
		TjsscPlan plan5=planService.findPlan( qi+1,12);
		 
		 
		  if(plan5==null){  
		
		TjsscPlan plan=planService.findPlan( qi,12);
		 TjsscLottery lottery2=lotteryService.findReport("qi", qi);
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
			planService.updatePlan(plan);
			num=plan.getSum();
		}
		

	
		
		TjsscPlan	plan2=new TjsscPlan();
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
		  planService.savePlan(plan2);
}  
		
	}
	
	
	private void setPlan6(long qi,List<TjsscLottery> lotteries){
	    
		TjsscPlan plan5=planService.findPlan( qi+1,13);
		 
		 
		  if(plan5==null){  
		
		TjsscPlan plan=planService.findPlan( qi,13);
		 TjsscLottery lottery2=lotteryService.findReport("qi", qi);
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
			planService.updatePlan(plan);
			num=plan.getSum();
		}
		

	
		
		TjsscPlan	plan2=new TjsscPlan();
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
		  planService.savePlan(plan2);
}  
		
	}
	
	
	private static void getValue(StringBuffer sBuffer,long qi,int type,TJsscGuilvKillService guilv4Service,
			TjsscGuilvService guilvService,List<TjsscLottery> lotteries,StringBuffer cc1,StringBuffer cc2,StringBuffer cc3
			){
		
		
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
		
		
		if(sBuffer.length()<3){
		
			List<TjsscGuilv> kills=guilvService.findLists(qi, num,type);
			for(TjsscGuilv g:kills){
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
		
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					10, type, 2, 5);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					4, type, 1, 2);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		 if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						7, type, 1, 5);

				for (TJsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					
					 
					 
				}	
			}
		 if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						6, type, 1, 4);

				for (TJsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					
					 
					 
				}	
			}
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						10, type, 2, 4);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					7, type, 0, 2);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					8, type, 2, 2);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					14, type, 3, 4);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					12, type, 3, 3);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		if(sBuffer.length()<3){
			List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
					10, type, 3, 2);

			for (TJsscGuilvKill g : kill2) {
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c1++;
				}
				 
				
			}
		}
		
		 if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						5, type, 1, 3);

				for (TJsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					
					 
					 
				}	
			}
		
		
		 

		 

			
			
		 
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						10, type, 0, 5);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			
			
			
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						9, type, 0, 4);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			


			
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						8, type, 2, 3);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						8, type, 0, 3);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						6, type, 1,4);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						7, type, 1, 5);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
		 
		 
			
			
			
			
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						15, type, 3, 5);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c1++;
					}
					 
					
				}
			}
			
			
			
			
		

			
			
			
			
		 
			
			
			
		 
		if(sBuffer.length()<3){
			List<TjsscGuilv> kills=guilvService.findLists3(qi+1, type,1);
			for(TjsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c2++;
				}
				 
					
				 
			} 
		}
		
		if(sBuffer.length()<3){
			List<TjsscGuilv> kills=guilvService.findLists3(qi+1, type,2);
			for(TjsscGuilv g:kills){
				if(sBuffer.indexOf(g.getValue())==-1){
					sBuffer.append(g.getValue());
					c2++;
				}
				 
					
				 
			} 
		}
	 
		
		if(sBuffer.length()<3){
			
			List<TjsscGuilv> kills=guilvService.findLists(qi-1, num,type);
			for(TjsscGuilv g:kills){
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
		
		
		
		if(sBuffer.length()<3){
			
			List<TjsscGuilv> kills=guilvService.findLists(qi-2, num,type);
			for(TjsscGuilv g:kills){
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
		
		
		
		
		
		 if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						6, type, 1, 5);

				for (TJsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					
					 
					 
				}	
			}
		 
		 
		 if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill3 = guilv4Service.findLists(qi+1,
						5, type, 1, 4);

				for (TJsscGuilvKill g : kill3) {
					  
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					
					 
					 
				}	
			}
		 if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						9, type, 0, 5);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					 
					
				}
			}
			if(sBuffer.length()<3){
				List<TJsscGuilvKill> kill2 = guilv4Service.findLists(qi+1,
						9, type, 2, 5);

				for (TJsscGuilvKill g : kill2) {
					if(sBuffer.indexOf(g.getValue())==-1){
						sBuffer.append(g.getValue());
						c3++;
					}
					 
					
				}
			}
		
		
		
		if(sBuffer.length()<3){
			List<TjsscGuilv> kills=guilvService.findLists5(type, 5);
			
		 
			for(TjsscGuilv g:kills){
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
	
	
	
	private static int sum(List<TjsscLottery> lotteries, int j, int type, StringBuffer sb) {
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
	
	
	
	private void s2(int addition,int b,int type,int fixation, TjsscLotteryService lotteryService, TjsscGuilvService guilvService,List<TjsscLottery> lotteries){
		  
	       
	    List<TjsscGuilv> sbr = new ArrayList<TjsscGuilv>();
 
            int count=1;
			  
	    TjsscGuilvUtils.setQuery(addition, b, type, count, fixation, 1, 1, lotteryService, guilvService, sbr,true,lotteries);	
		 
	}
 
	
	private void s3(int addition,int b,int type,int fixation, TjsscLotteryService lotteryService, TJsscGuilvKillService guilv4Service,List<TjsscLottery> lotteries){
		  
	       for(int n=0;n<4;n++){
	    	   
	    	   List<TJsscGuilvKill> sbr = new ArrayList<TJsscGuilvKill>();
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
	        	   count=5; 
	           }else if(n==3&&addition==3){
	        	   count=9; 
	           }else if(n==3&&addition==4){
	        	   count=12; 
	           }else if(n==3&&addition==5){
	        	   count=12; 
	           }else if(n==2&&addition==5){
	        	   count=10; 
	           }else if(n==0&&addition==5){
	        	   count=10; 
	           }else if(n==0&&addition==4){
	        	   count=9; 
	           }else if(n==2&&addition==4){
	        	   count=9; 
	           }else if(n==1&&addition==4){
	        	   count=5; 
	           }else if(n==1&&addition==5){
	        	   count=6; 
	           }
	             
				  
		   TJsscGuilvKillUtils.setQuery(addition, b, type, count, fixation, 1, n, lotteryService, guilv4Service, sbr,true,lotteries);   
	       }
	   	
		 
		 
	}
}
