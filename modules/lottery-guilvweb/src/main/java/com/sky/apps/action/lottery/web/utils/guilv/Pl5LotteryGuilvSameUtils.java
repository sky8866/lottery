package com.sky.apps.action.lottery.web.utils.guilv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCondition;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
 

 

public class Pl5LotteryGuilvSameUtils {
	private static Pl5GuilvRemoveCountService guilvRemoveCountService;
	private	static Pl5GuilvSameOldService guilvSameOldService;
 
	private static  Pl5GuilvRemoveConditionService  conditionsService;
	public  static void setQuery(int addition,
			  int buchang,
			 int type,
			 int even,
			 int fixation,
			  int matchType,
			 int number,Pl5LotteryService lotteryService,Pl5GuilvSameOldService guilvService,boolean isvip, Pl5GuilvRemoveCountService countService,Pl5GuilvRemoveConditionService conditionService){
	  guilvRemoveCountService=countService;
	  guilvSameOldService=guilvService;
		conditionsService=conditionService;
		PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
       
		List<Pl5Lottery> lotteries = pageView.getRecords();
		int query = 0;

		if (type == 0) {
			query = lotteries.get(0).getNumber1();
		} else if (type == 1) {
			query = lotteries.get(0).getNumber2();
		} else if (type == 2) {
			query = lotteries.get(0).getNumber3();
		} else if (type == 3) {
			query = lotteries.get(0).getNumber4();
		}

		List<StringBuffer> sbs = getSb(addition);

		  
		List<String> sumVaule = new ArrayList<String>();
		long qi = lotteries.get(0).getQi() + 1;
		 
		PageView<Pl5GuilvSameOld> pageViewGuilv = new PageView<Pl5GuilvSameOld>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		if(fixation!=0){
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.GE, 1));	
		}else{
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.EQ, fixation));
		}
		
		if(isvip){
			if(matchType==0){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.EQ, even));	
			}else if(matchType==1){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.GE, even));	
			}else if(matchType==2){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, even));	
			} else if(matchType==3){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.GT, even));	
			}
		}else{
			if(number==1){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 4));
			}else if(number==0){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 8));
			}else if(number==2){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 8));
			}else if(number==3){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 10));
			}else if(number==4){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 14));
			}else if(number==5){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 16));
			}else if(number==6){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 24));
			}
			
			
		}
		
		
		
		
		
		 
		filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
	 
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<Pl5GuilvSameOld> guilvs = pageViewGuilv.getRecords();
		
		if (guilvs.isEmpty()) {
			 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(fixation, buchang, addition, number, 12);
			for (int a = 1; buchang > a; a++) {

				for (int a1 = 0; a1 < 5; a1++) {
					int temp = sum(lotteries, a, a1, sbs.get(0));

					if (addition == 1) {
						guilv(type, temp, query, lotteries, sbs,   sumVaule,
								even, fixation, matchType, number, addition, buchang, qi ,conditions);
					} else {
						for (int b = 1; buchang > b; b++) {
							for (int b1 = 0; b1 < 5; b1++) {
								int q1 = sum(lotteries, b, b1, sbs.get(1));
								int temp1 = temp + q1;

								if (addition == 2) {
									guilv(type, temp1, query, lotteries, sbs,
											  sumVaule, even, fixation,
											matchType, number,  addition, buchang,  qi,conditions );
								} else {
									for (int c = 1; buchang > c; c++) {
										for (int c1 = 0; c1 < 5; c1++) {
											int q2 = sum(lotteries, c, c1,
													sbs.get(2));
											int temp2 = temp1 + q2;

											if (addition == 3) {
												guilv(type, temp2, query,
														lotteries, sbs,  
														sumVaule, even,
														fixation, matchType,
														number,  addition,buchang,qi,conditions );
											} else {
												for (int d = 1; buchang > d; d++) {
													for (int d1 = 0; d1 < 5; d1++) {
														int q3 = sum(lotteries,
																d, d1,
																sbs.get(3));
														int temp3 = temp2 + q3;

														if (addition == 4) {
															guilv(type, temp3,
																	query,
																	lotteries,
																	sbs, 
																	sumVaule,
																	even,
																	fixation,
																	matchType,
																	number,addition, buchang, qi,conditions );
														} else {
															for (int e = 1; buchang > e; e++) {
																for (int e1 = 0; e1 < 5; e1++) {
																	int q4 = sum(
																			lotteries,
																			e,
																			e1,
																			sbs.get(4));
																	int temp4 = temp3
																			+ q4;

																	if (addition == 5) {
																		guilv(type,
																				temp4,
																				query,
																				lotteries,
																				sbs,
																				 
																				sumVaule,
																				even,
																				fixation,
																				matchType,
																				number, addition,buchang, qi,conditions );
																	} else {
																		for (int f = 1; buchang > f; f++) {
																			for (int f1 = 0; f1 < 5; f1++) {
																				int q5 = sum(
																						lotteries,
																						f,
																						f1,
																						sbs.get(5));
																				int temp5 = temp4
																						+ q5;

																				if (addition == 6) {
																					guilv(type,
																							temp5,
																							query,
																							lotteries,
																							sbs,
																							 
																							sumVaule,
																							even,
																							fixation,
																							matchType,
																							number, addition, buchang, qi,conditions );
																				} else {
																					for (int g = 1; buchang > g; g++) {
																						for (int g1 = 0; g1 < 5; g1++) {
																							int q6 = sum(
																									lotteries,
																									g,
																									g1,
																									sbs.get(6));
																							int temp6 = temp5
																									+ q6;

																							if (addition == 7) {
																								guilv(type,
																										temp6,
																										query,
																										lotteries,
																										sbs,
																										 
																										sumVaule,
																										even,
																										fixation,
																										matchType,
																										number, addition, buchang, qi ,conditions);
																							} else {

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
											}

										}
									}
								}

							}
						}
					}

				}
			}
			 
		} else {
			/*for (Guilv g : guilvs) {
				 
				sbr.add(g);
			}*/

		}

	/*	ComparatorGuilv guilv = new ComparatorGuilv();

		Collections.sort(sbr, guilv);*/

	}
	
	 

	public static  List<StringBuffer> getSb(int addition) {
		List<StringBuffer> sbs = new ArrayList<StringBuffer>();
		for (int i = 0; i < addition; i++) {
			StringBuffer sb1 = new StringBuffer();
			sbs.add(sb1);
		}

		return sbs;

	}

	private static void guilv(int type, int sum, int query, List<Pl5Lottery> lotteries,
			List<StringBuffer> sbs,   List<String> sumVaule,
			int even, int fixation, int matchType, int number,int addition,int buchang,long qi, Pl5GuilvRemoveCondition  conditions) {

		if (fixation == 0) {
			getFixation(type, sum, query, lotteries, sbs,  sumVaule, even,
					fixation, matchType, number, addition, buchang, qi ,conditions);
		} else {
			for (int e = 1; 10 > e; e++) {

				getFixation(type, sum, query, lotteries, sbs,  sumVaule,
						even, e, matchType, number, addition, buchang, qi,conditions );

			}
		}

	}

	/**
	 * 固定相加
	 */

	private static void getFixation(int type, int sum, int query,
			List<Pl5Lottery> lotteries, List<StringBuffer> sbs, 
			List<String> sumVaule, int even, int e, int matchType, int number,int addition,int buchang,long qi, Pl5GuilvRemoveCondition  conditions ) {
		int z = s(sum);
		int x = z + e;

		one(x, type, query, lotteries, sbs,   sumVaule, even, e, matchType,
				number, addition, buchang, qi,conditions );

	}

	/**
	 * 多结果
	 */
	private static Boolean more(int x, int query, int number) {
		 
		Integer[] nums = GuilvSameUtils.getQueryValue(x, number);
		 
		boolean flag = false;
		for (Integer i : nums) {
			if (query == i) {
				flag = true;
				 
				break;
			}
		}

		return flag;

	}
 
	/**
	 * 单结果
	 */
	private static void one(int x, int type, int query, List<Pl5Lottery> lotteries,
			List<StringBuffer> sbs,  List<String> sumVaule,
			int even, int e, int matchType, int number,int addition,int buchang,long qi, Pl5GuilvRemoveCondition  conditions) {
       int  t1=s(s(x)+query);
		if (more(t1, t1, number)) {
			  int startValue=0;
	            String startQu=""; 
	            
	             
			int count = 1;
			B: for (int j = 1; lotteries.size() > j; j++) {
				int temp2 = 0;
				   
		            String startQuTemp=""; 
				for (StringBuffer sb : sbs) {
					int s1 = Integer.valueOf(sb.toString().split(",")[0]);

					int v1 = Integer.valueOf(sb.toString().split(",")[1]);
					String ve = getQueryValue(lotteries,  s1 + j, v1);
					 
					startQuTemp = startQuTemp + ve;
					int qq1 = sum(lotteries, s1 + j, v1, null);
					 
					temp2 = temp2 + qq1;
					
				}

				temp2 = s(temp2) + e;
			 
				int qq = 0;
				if (type == 0) {
					qq = lotteries.get(j).getNumber1();
				} else if (type == 1) {
					qq = lotteries.get(j).getNumber2();
				} else if (type == 2) {
					qq = lotteries.get(j).getNumber3();
				} else if (type == 3) {
					qq = lotteries.get(j).getNumber4();
				}
			     
	
					if (more(t1, s(temp2+qq), number)) {
						 
						
						startValue=qq;
						startQu=startQuTemp+ getQueryValue(lotteries, j, type);;
						count++;
					}
					
				 else {

					break B;

				}

			}
		 
			String qu = "";

			boolean bsum = count == even;
			if (matchType == 1) {
				bsum = count >= even;
			} else if (matchType == 2) {
				bsum = count < even;
			} else if (matchType == 3) {
				bsum = count > even;
			}
			
			if (bsum) {
		 	  int countold = setold( e,type,sbs, lotteries,  number,count); 
				 
				int temp2 = 0;
				int s1 = 0;
				List<String> flags = new ArrayList<String>();
                     
				for (StringBuffer sb : sbs) {
					s1 = Integer.valueOf(sb.toString().split(",")[0]);

					int v1 = Integer.valueOf(sb.toString().split(",")[1]);
					String ve = getQueryValue(lotteries, s1 - 1, v1);

					flags.add(sb.toString());
					qu = qu + ve;
					int qq1 = sum(lotteries, s1 - 1, v1, null);
					temp2 = temp2 + qq1;

				}

				boolean flag = getValueFilter(flags, sumVaule);

				if (flag) {
					temp2 = s(temp2) + e;
					String stypeString = "";
					if (type == 0) {
						stypeString = "头";
					} else if (type == 1) {
						stypeString = "百";
					} else if (type == 2) {
						stypeString = "十";
					} else if (type == 3) {
						stypeString = "尾";
					}
					 
					
					String string="";
					String string1="";
					qu=qu.substring(0,qu.length()-1);
					if(startQu.length()>1){
						startQu=startQu.substring(0,startQu.length()-1); 
					}
					
					if(e==0){
						string ="判断条件为：" + qu+"";
						string1= startQu+"="+GuilvSameUtils.getSumValue(t1, number)+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvSameUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";;
					}else{
						string ="判断条件为：" + e + "+" + qu+"";
						string1= e+"+" +startQu+"="+GuilvSameUtils.getSumValue(t1, number)+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvSameUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";
								 
					}
				
				
					Pl5GuilvSameOld vo = new Pl5GuilvSameOld();
					vo.setAddition(addition);
					vo.setBuchang(buchang);
					vo.setEven(even);
					vo.setSum(count);
					vo.setMatchType(matchType);
					vo.setNumber(number);
					vo.setQi(qi);
					vo.setType(type);
					vo.setStartQueryValue(string1);
					vo.setStartValue(GuilvSameUtils.getSumValue(t1, number));
					vo.setValue(values(t1, number, s(temp2)));
					vo.setFixation(e);
					vo.setQueryValue(string);
                    vo.setValueOld(countold+"");
                    vo.setValueNew(sbs.toString());
                    
                    vo.setTypeVaule("本期的"+stypeString+"为:"+vo.getValue()+",已经连对："+count+"期");
                    vo.setGui(1);
                    
                       String infoString="历史上最高记录连续跑:"+vo.getValueOld()+"期，目前已跑："+vo.getSum()+"期，小心会断了！";
                       int fixation=10;
					    if(e==0){
					    	fixation=0;
					    }
                       Pl5NumCountUtils.getGuilvSame(addition, buchang, fixation, number, vo, vo.getSum(), infoString);
     
					 
					 if(StringUtils.isNotEmpty(vo.getInfo())){
						 
						 vo.setNum(getOldLottery(vo.getSum(),addition, buchang, even, e, qi, matchType));
						 guilvSameOldService.saveGuilv(vo);
						 guilvRemove(vo,conditions,guilvRemoveCountService,conditionsService);
					 }
					 
					 
					 
				}

			}
		}

	}
	
	public static  String values(int num,int number,int temp){
		Integer[] e=GuilvSameUtils.getQueryValue(num, number);
		String s="";
		for(Integer v:e){
			int n=s(v+10-temp);
			s=s+n;
		}
	   return s;	
	}
	
	private static int getOldLottery(int sum,int addition, int buchang, int even,int fixation,long qi, int matchType){
		PageView<Pl5GuilvSameOld> pageViewGuilv = new PageView<Pl5GuilvSameOld>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang)); 
		filtersnewses.add(new PropertyFilter("even", MatchType.EQ, even));
		if(fixation==0){
			filtersnewses.add(new PropertyFilter("fixation", MatchType.EQ, fixation));
		}
		
		filtersnewses.add(new PropertyFilter("matchType", MatchType.EQ, matchType));
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi-1));
		List<Pl5GuilvSameOld> gs=guilvSameOldService.findList(pageViewGuilv, filtersnewses).getResultlist();
		 
		int num=0;
		for(Pl5GuilvSameOld g:gs){
			if(sum>g.getNum()&&sum>num){
				num=sum;
			}else{
				num=g.getNum();
			}
		}
		if(num==0){
			num=sum;
		}
		return num;
	}
	public static void guilvRemove(Pl5GuilvSameOld g,Pl5GuilvRemoveCondition conditions,Pl5GuilvRemoveCountService cocuntService,Pl5GuilvRemoveConditionService conditionService){
		  
		boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
		  if(falg){
	    	   
	    	   removeCount(g,cocuntService, 0,conditions);
	    	   
	       }
		  falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
		  if(falg){
	    	   
	    	   removeCount(g,cocuntService, 1,conditions);
	    	   
	       }
	       condition(conditions, g,  conditionService);
	}
	
	
	private static void removeCount(Pl5GuilvSameOld g,Pl5GuilvRemoveCountService countService,int remove,Pl5GuilvRemoveCondition	conditions){
		Object[] objects=new Object[5];
		   objects[0]="qi";
		   objects[1]="value";
		   objects[2]="remove";
		   objects[3]="valueNew"; 
		   objects[4]="gui"; 
		   Object[]  var=new Object[5];
		   var[0]=g.getQi();
		   var[1]=g.getValue();
		   var[2]=remove;
		   var[3]=g.getValueNew(); 
		   var[4]=12; 
		
		  Pl5GuilvRemoveCount count=countService.findGuilvs(objects, var);
		 if(count==null){
			 count=new Pl5GuilvRemoveCount();
			 count.setInfo(g.getInfo());
	    	    count.setNum(g.getNum());
	    	    count.setQi(g.getQi());
	    	    count.setQueryValue("【全合规】"+g.getQueryValue());
	    	    count.setStartQueryValue(g.getStartQueryValue());
	    	    count.setSum(g.getSum());
	    	    count.setTypeVaule(g.getTypeVaule());;
	    	    count.setValueNew(g.getValueNew());
	    	    count.setValueQueryNew(g.getValueQueryNew());
	    	    count.setValue(g.getValue());
	    	    count.setStartValue(g.getStartValue());
	    	    count.setType(g.getType());
	    	    count.setGui(12);
		 	    count.setRemove(remove);
		 	   count.setNumber(g.getNumber());
		 	  count.setSumMin(conditions.getSumMin());
		 	  if(remove==0){
		 		  count.setSort(g.getSum()-conditions.getSum()+1);
		 	  }
		 	   countService.saveGuilv(count); 
		 }
 
	}
	
	public static void condition(Pl5GuilvRemoveCondition condition,Pl5GuilvSameOld g ,Pl5GuilvRemoveConditionService conditionService){
		if(g.getSum()>condition.getSum()){
			   
			   if(g.getSum()>condition.getSumMin()){
				  
				   condition.setSumMin(g.getSum());
			   }
			   
			   condition.setSumCount(condition.getSumCount()+1);  
			  
		   } 
		   if(g.getSum()>condition.getSumNew()){
			   condition.setSumNew(g.getSum());
		   }
		   
		    conditionService.updateGuilv(condition);
	}
	private static int   setold(int e,int type,List<StringBuffer> sbs,List<Pl5Lottery> lotteries, int number,int co){
		int count=0;
		int temp=co;
	      
		  for (int j = co; lotteries.size()-11 > j; j++) {
			  
			int temp2 = 0;
		 
			for (StringBuffer sb : sbs) {
				int s1 = Integer.valueOf(sb.toString().split(",")[0]);

				int v1 = Integer.valueOf(sb.toString().split(",")[1]);

				int qq1 = sum(lotteries, s1 + j, v1, null);
				temp2 = temp2 + qq1;
				 
			}

			temp2 = s(temp2) + e;
			
			
			int qq = 0;
			if (type == 0) {
				qq = lotteries.get(j).getNumber1();
			} else if (type == 1) {
				qq = lotteries.get(j).getNumber2();
			} else if (type == 2) {
				qq = lotteries.get(j).getNumber3();
			} else if (type == 3) {
				qq = lotteries.get(j).getNumber4();
			}
               
			if (more(s(temp2), qq, number)) {
				count++;
				
				 
			} else {
				count=0;
				 

			}

		}
			 if(count>=temp){
				 temp=count;
			 }
		
		return temp;
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

	private static String getQueryValue(List<Pl5Lottery> lotteries, int j, int type) {
		Integer[] l = { lotteries.get(j).getNumber1(),
				lotteries.get(j).getNumber2(), lotteries.get(j).getNumber3(),
				lotteries.get(j).getNumber4(), lotteries.get(j).getNumber5()  };
		int sum = l[type];
		String lString = "";
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
		} 
		String valueString = +lotteries.get(j).getQi() + "期的" + lString+"+" ;
		return valueString;
	}

	private static int sum(List<Pl5Lottery> lotteries, int j, int type, StringBuffer sb) {
		int sum = 0;

		Integer[] l = { lotteries.get(j).getNumber1(),
				lotteries.get(j).getNumber2(), lotteries.get(j).getNumber3(),
				lotteries.get(j).getNumber4(), lotteries.get(j).getNumber5()  };
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
