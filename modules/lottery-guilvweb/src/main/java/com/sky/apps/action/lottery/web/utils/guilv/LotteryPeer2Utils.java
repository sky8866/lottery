package com.sky.apps.action.lottery.web.utils.guilv;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

  
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeer2;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvPeer2Service;
import com.sky.modules.lottery.service.guilv.GuilvPeer3Service; 
import com.sky.modules.lottery.service.guilv.LotteryService;
 

 

 
 

 

public class LotteryPeer2Utils {
	 
	public  static void setQuery(int addition,
			  int buchang,
			 int type,
			 int even,
			 int fixation,
			  int matchType,
			 int number,LotteryService lotteryService,GuilvPeer2Service guilvService,List<GuilvPeer2> sbr,boolean isvip){
	  
		
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
       
		List<Lottery> lotteries = pageView.getRecords();
	

		 

		List<StringBuffer> sbs = getSb(3);
		List<StringBuffer> sbs2 = getSb(addition);
		
		
		  
		List<String> sumVaule = new ArrayList<String>();
		int qi = lotteries.get(0).getQi() + 1;
		 
		PageView<GuilvPeer2> pageViewGuilv = new PageView<GuilvPeer2>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		 
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		  
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
 
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvPeer2> guilvs =  pageViewGuilv.getRecords();;
		
 
	 
		if (guilvs.isEmpty()) {
	
			
			 
				for(int a=0;a<=3;a++){
					 sbs = getSb(3);
					int sum=sum(lotteries, 0, a, sbs.get(0)); 
					
				
					for(int i=4;i<=20;i++){
					
							int sum1=sum(lotteries, i, a, sbs.get(1));
				 			boolean falg=false;
							if(sum==sum1){
								falg=true;
							}else if((sum==1||sum==7)&&sum1==4){
								//falg=true;
							}else if((sum==2||sum==8)&&sum1==5){
								//falg=true;
							}else if((sum==3||sum==9)&&sum1==6){
								//falg=true;
							}
							
							if(falg){
						        
								 int sum2=sum(lotteries, i*2, a, sbs.get(2));
								 
								 
								 boolean flag1=false;
								 if(sum2==sum1&&sum1==sum){
									 flag1=true;
									}else if(sum==1&&sum1==4&&sum2==7){
										//flag1=true;
									}else if(sum==7&&sum1==4&&sum2==1){
										//flag1=true;
									}else if(sum==3&&sum1==6&&sum2==9){
										//flag1=true;
									}else if(sum==9&&sum1==6&&sum2==3){
										 
										//flag1=true;
									}else if(sum==2&&sum1==5&&sum2==8){
										//flag1=true;
									}else if(sum==8&&sum1==5&&sum2==2){
										//flag1=true;
									}
								 
								 if(flag1){
									 
									
									 
							   int 		 query = sum(lotteries, i*2-1, type, sbs2.get(0)); 
							   
							     boolean flag2=false;
							     String v1="";
							 	String c1="";
							 	 String valueString="";
							 	 
										if (addition == 2) {
											for (int s=i*2; i*2+4 > s; s++) {
											for (int aq1 = 0; aq1 < 7; aq1++) {
												int query2=query+sum(lotteries, s, aq1, sbs2.get(1)); 
												if(s(query2)==sum2){
													int q1=sum(lotteries, i-1, type, sbs2.get(0)); 
													q1=q1+sum(lotteries, s-i, aq1, sbs2.get(1)); 
													if(s(q1)==sum1){
													   	int q2=sum(lotteries, s, aq1, sbs2.get(1));
													   	String stypeString="";
													   	if (type == 0) {
															stypeString = "头";
															  
														} else if (type == 1) {
															stypeString = "百";
															 
														} else if (type == 2) {
															stypeString = "十";
													 
														} else if (type == 3) {
															stypeString = "尾";
														
														 
														}
													   	
													    c1="坐标："+getQueryValue(lotteries, 0, a)+
													   			getQueryValue(lotteries, i, a)
													   			+getQueryValue(lotteries, i*2, a);
													  c1= 	c1.substring(0,c1.length()-1);
													  int va=s(sum+10-q2);
													  int  newqi=lotteries.get(0).getQi()+1;
													   v1="判断条件："+getQueryValue(lotteries, s, aq1)+newqi+"期的"+stypeString+"为："+va;
													 flag2=true;
													 valueString="本期的"+stypeString+"为："+va; 
													}
												}
											}
											}
									 
								 } else if(addition == 3) {
										for (int s=i*2; i*2+4 > s; s++) {
										for (int aq1 = 0; aq1 < 7; aq1++) {
										   int 	query2=query+sum(lotteries, s, aq1, sbs2.get(1)); 
										 	
										 	
											
											for (int s2=i*2; i*2+4 > s2; s2++) {
												for (int aq2 = 0; aq2 < 7; aq2++) {
												 int 	query3=query2+sum(lotteries, s2, aq2, sbs2.get(2)); 
												/*   System.out
														.println(s(query3)); */
													if(s(query3)==sum2){
														
														int qq1=sum(lotteries, i-1, type, sbs2.get(0));
													  
														int qq2=qq1+sum(lotteries, s-i, aq1, sbs2.get(1)); 
														 int  qq3=qq2+sum(lotteries, s2-i, aq2, sbs2.get(2)); 
														
														
													
														if(s(qq3)==sum1){

															 
														   	String stypeString="";
														   	if (type == 0) {
																stypeString = "头";
																  
															} else if (type == 1) {
																stypeString = "百";
																 
															} else if (type == 2) {
																stypeString = "十";
														 
															} else if (type == 3) {
																stypeString = "尾";
															
															 
															}
														   	
														     c1="坐标："+getQueryValue(lotteries, 0, a)+
														   			getQueryValue(lotteries, i, a)
														   			+getQueryValue(lotteries, i*2, a);
														  c1= 	c1.substring(0,c1.length()-1);
														   
															int q2=sum(lotteries, s-i*2, aq1, null);
															int qqq2=sum(lotteries, s2-i*2, aq2, null);
															
														  int va=s((sum+10)-s((q2+qqq2)));
														 int  newqi=lotteries.get(0).getQi()+1;
														  v1="判断条件："+getQueryValue(lotteries, s-i*2, aq1)+getQueryValue(lotteries, s2-i*2, aq2)+newqi+"期的"+stypeString+"为："+va;
                                                        valueString="本期的"+stypeString+"为："+va;
                                                      
                                                        GuilvPeer2 vo = new GuilvPeer2();
            											vo.setAddition(addition);
            											vo.setBuchang(buchang);
            											vo.setEven(even);
            											 vo.setGui(11);
            											vo.setMatchType(matchType);
            											vo.setNumber(number);
            											vo.setQi(qi);
            											vo.setType(type); 
            											vo.setValue(v1);
            											vo.setFixation(fixation);
            											vo.setQueryValue(c1); 
            						                    vo.setTypeVaule(valueString);
            						                    
            						                    guilvService.saveGuilv(vo);
            						                    sbr.add(vo);
            						                 
														}
													}
													
													
													
												}
											}
											
											
										
										}
										}
								 
							 }else if(addition == 4) {
									for (int s=i*2; i*2+4 > s; s++) {
									for (int aq1 = 0; aq1 < 7; aq1++) {
									   int 	query2=query+sum(lotteries, s, aq1, sbs2.get(1)); 
									 	
									 	
										
										for (int s2=i*2; i*2+4 > s2; s2++) {
											for (int aq2 = 0; aq2 < 7; aq2++) {
											 int 	query3=query2+sum(lotteries, s2, aq2, sbs2.get(2)); 
											 for (int s3=i*2; i*2+4 > s3; s3++) {
													for (int aq3 = 0; aq3 < 7; aq3++) {
													 int 	query4=query3+sum(lotteries, s3, aq3, sbs2.get(3)); 
												if(s(query4)==sum2){
													
													int qq1=sum(lotteries, i-1, type, sbs2.get(0));
												  
													int qq2=qq1+sum(lotteries, s-i, aq1, sbs2.get(1)); 
													 int  qq3=qq2+sum(lotteries, s2-i, aq2, sbs2.get(2)); 
													 int  qq4=qq3+sum(lotteries, s3-i, aq3, sbs2.get(3)); 
													
												
													if(s(qq4)==sum1){

														 
													   	String stypeString="";
													   	if (type == 0) {
															stypeString = "头";
															  
														} else if (type == 1) {
															stypeString = "百";
															 
														} else if (type == 2) {
															stypeString = "十";
													 
														} else if (type == 3) {
															stypeString = "尾";
														
														 
														}
													   	
													     c1="坐标："+getQueryValue(lotteries, 0, a)+
													   			getQueryValue(lotteries, i, a)
													   			+getQueryValue(lotteries, i*2, a);
													  c1= 	c1.substring(0,c1.length()-1);
													   
														int q2=sum(lotteries, s-i*2, aq1, null);
														int qqq2=sum(lotteries, s2-i*2, aq2, null);
														int qqq3=sum(lotteries, s3-i*2, aq3, null);
													  int va=s((sum+10)-s((q2+qqq2+qqq3)));
													 int  newqi=lotteries.get(0).getQi()+1;
													  v1="判断条件："+getQueryValue(lotteries, s-i*2, aq1)+getQueryValue(lotteries, s2-i*2, aq2)+getQueryValue(lotteries, s3-i*2, aq3)+newqi+"期的"+stypeString+"为："+va;
                                                 valueString="本期的"+stypeString+"为："+va;
                                               
                                                 GuilvPeer2 vo = new GuilvPeer2();
     											vo.setAddition(addition);
     											vo.setBuchang(buchang);
     											vo.setEven(even);
     											 vo.setGui(11);
     											vo.setMatchType(matchType);
     											vo.setNumber(number);
     											vo.setQi(qi);
     											vo.setType(type); 
     											vo.setValue(v1);
     											vo.setFixation(fixation);
     											vo.setQueryValue(c1); 
     						                    vo.setTypeVaule(valueString);
     						                    
     						                    guilvService.saveGuilv(vo);
     						                    sbr.add(vo);
     						                 
													}
												}
												
													}
											 }
												
											}
										}
										
										
									
									}
									}
							 
						 }
									 	if(flag2){
											GuilvPeer2 vo = new GuilvPeer2();
											vo.setAddition(addition);
											vo.setBuchang(buchang);
											vo.setEven(even);
											 
											vo.setMatchType(matchType);
											vo.setNumber(number);
											vo.setQi(qi);
											vo.setType(type); 
											vo.setValue(v1);
											vo.setFixation(fixation);
											vo.setQueryValue(c1); 
						                    vo.setTypeVaule(valueString);
						                    
						                    guilvService.saveGuilv(vo);
						                    sbr.add(vo);
										} 
										
					                    
							}
						 
					}
				}
			
			
			
				}
				
	 
				
				
		} else {
		/*	for (GuilvPeer3 g : guilvs) {
				 
				sbr.add(g);
			}*/

		}

		/*ComparatorGuilvPeer3 guilv = new ComparatorGuilvPeer3();

		Collections.sort(sbr, guilv);*/

	}
	
	 
 
	
 


	private static int s(int sum) {
		if (sum >= 10) {

			do {
				sum = sum - 10;
			} while (sum >= 10);

		}

		return sum;

	}
	
	
	
	 
	public static  List<StringBuffer> getSb(int addition) {
		List<StringBuffer> sbs = new ArrayList<StringBuffer>();
		for (int i = 0; i < addition; i++) {
			StringBuffer sb1 = new StringBuffer();
			sbs.add(sb1);
		}

		return sbs;

	}


	
 
 

	/**
	 * 过滤重复的数据！
	 */

	private static Boolean getValueFilter(List<String> flags, List<String> sumVaule) {
		boolean flag = true;
		String string = "";
		Collections.sort(flags);
		for (String f : flags) {
			string = string + f;
		}

		for (String s : sumVaule) {

			if (s.equals(string)) {
				flag = false;
				break;
			}
		}

		sumVaule.add(string);

		return flag;
	}

	private static String getQueryValue(List<Lottery> lotteries, int j, int type) {
		String lString = "";
		try{
			Integer[] l = { lotteries.get(j).getNumber1(),
					lotteries.get(j).getNumber2(), lotteries.get(j).getNumber3(),
					lotteries.get(j).getNumber4(), lotteries.get(j).getNumber5(),
					lotteries.get(j).getNumber6(), lotteries.get(j).getNumber7() };
			int sum = l[type];
			
			if (type == 0) {
				lString = "A[" + sum + "]";
			} else if (type == 1) {
				lString = "B[" + sum + "]";
			} else if (type == 2) {
				lString = "C[" + sum + "]";
			} else if (type == 3) {
				lString = "D[" + sum + "]";
			} else if (type == 4) {
				lString = "E[" + sum + "]";
			} else if (type == 5) {
				lString = "F[" + sum + "]";
			} else if (type == 6) {
				lString = "G[" + sum + "]";
			}
			String valueString = +lotteries.get(j).getQi() + "期的" + lString+"+" ;
			return valueString;	
		}catch (Exception e) {
			// TODO: handle exception
		}
		 
		return "";
		
	}
	
	
	public static List<StringBuffer> coordinate(List<Lottery> lotteries){
	          List  ss=new ArrayList();
		
			  
				for(int a=0;a<=3;a++){
					List<StringBuffer> sbs = getSb(3);
					int sum=sum(lotteries, 0, a, sbs.get(0)); 
					for(int i=4;i<=20;i++){
					 
							int sum1=sum(lotteries, i, a, sbs.get(1));
							boolean falg=false;
							if(sum==sum1){
								falg=true;
							}else if((sum==1||sum==7)&&sum1==4){
								falg=true;
							}else if((sum==2||sum==8)&&sum1==5){
								falg=true;
							}else if((sum==3||sum==9)&&sum1==6){
								falg=true;
							}
							
							if(falg){
								 int sum2=sum(lotteries, i*2, a, sbs.get(2));
								 boolean flag1=false;
								 if(sum2==sum1){
									 flag1=true;
									}else if(sum==1&&sum1==4&&sum2==7){
										flag1=true;
									}else if(sum==7&&sum1==4&&sum2==1){
										flag1=true;
									}else if(sum==3&&sum1==6&&sum2==9){
										flag1=true;
									}else if(sum==9&&sum1==6&&sum2==3){
										flag1=true;
									}else if(sum==2&&sum1==5&&sum2==8){
										flag1=true;
									}else if(sum==8&&sum1==5&&sum2==2){
										flag1=true;
									}
								 
								 if(flag1){
									 ss.add(sbs);
								 }
							}
						 
					}
				}
		 
			  
		return null;
	}

	private static int sum(List<Lottery> lotteries, int j, int type, StringBuffer sb) {

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
 

}
