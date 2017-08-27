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
 

 

 
 

 

public class LotteryPeer5Utils {
	 
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
	
			   int a=type;
			      
					 sbs = getSb(3);
					 
					 for(int sum=1;10>sum;sum++){
							
							
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
								        
										 int sum2=sum(lotteries, i*2+1, a, sbs.get(2));
										 
										 
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
											 
											
											 String stypeString = "";
											 String stypeString2 = "";
												if (type == 0) {
													stypeString = "头";
													stypeString2 = "A";
												} else if (type == 1) {
													stypeString = "百";
													stypeString2 = "B";
												} else if (type == 2) {
													stypeString = "十";
													stypeString2 = "C";
												} else if (type == 3) {
													stypeString = "尾";
													stypeString2 = "D";
												}	 
								      
									 	String c1=""; 
									 	 c1="坐标："+qi+"期的"+stypeString2+"["+sum+"]+"+
										   			getQueryValue(lotteries, i, a)
										   			+getQueryValue(lotteries, i*2+1, a);
										  c1= 	c1.substring(0,c1.length()-1);
										String   valueString="本期的"+stypeString+"为："+sum;
										  GuilvPeer2 vo = new GuilvPeer2();
											vo.setAddition(addition);
											vo.setBuchang(buchang);
											vo.setEven(even);
											 
											vo.setMatchType(matchType);
											vo.setNumber(number);
											vo.setQi(qi);
											vo.setType(type); 
											 vo.setGui(10);
											vo.setFixation(fixation);
											vo.setQueryValue(c1); 
						                    vo.setTypeVaule(valueString);
						                    
						                    guilvService.saveGuilv(vo);
						                    sbr.add(vo);
											System.out.println(); 
										
												
							                    
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
