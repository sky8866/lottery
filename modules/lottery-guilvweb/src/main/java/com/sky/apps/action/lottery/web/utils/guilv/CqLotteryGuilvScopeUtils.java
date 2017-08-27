package com.sky.apps.action.lottery.web.utils.guilv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

  
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils;   
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCondition;
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.CqGuilvScopeOld;
import com.sky.modules.lottery.entity.guilv.CqsscLottery; 
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqGuilvScopeOldService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
 

 

public class CqLotteryGuilvScopeUtils {
	private	static CqGuilvRemoveCountService guilvRemoveCountService;
	private	static CqGuilvScopeOldService oScopeOLdService;
 
	private	static  CqGuilvRemoveConditionService  conditionsService;
	public  static void setQuery(int addition,
			  int buchang,
			 int type,
			 int even,
			 int fixation,
			  int matchType,
			 int number,CqsscLotteryService lotteryService,CqGuilvScopeOldService guilvService,boolean isvip,CqGuilvRemoveCountService countService,CqGuilvRemoveConditionService conditionService){
		 even=even-2;
		guilvRemoveCountService=countService;
		  oScopeOLdService=guilvService;
		  conditionsService=conditionService;
		PageView<CqsscLottery> pageView = new PageView<CqsscLottery>(600,1);
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
       
		List<CqsscLottery> lotteries = pageView.getRecords();
		int query = 0;

		if (type == 0) {
			query = lotteries.get(0).getNumber1();
		} else if (type == 1) {
			query = lotteries.get(0).getNumber2();
		} else if (type == 2) {
			query = lotteries.get(0).getNumber3();
		} else if (type == 3) {
			query = lotteries.get(0).getNumber4();
		} else if (type == 4) {
			query = lotteries.get(0).getNumber5();
		}

		List<StringBuffer> sbs = getSb(addition);

		  
		List<String> sumVaule = new ArrayList<String>();
		long qi = lotteries.get(0).getQi() + 1;
		 
		PageView<CqGuilvScopeOld> pageViewGuilv = new PageView<CqGuilvScopeOld>();
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
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, 1));
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<CqGuilvScopeOld> guilvs = pageViewGuilv.getRecords();
		
		if (guilvs.isEmpty()) {
			 CqGuilvRemoveCondition  conditions=conditionService.findGuilv(fixation, buchang, addition, number, 2);
			for (int a = 1; buchang > a; a++) {

				for (int a1 = 0; a1 < 5; a1++) {
					int temp = sum(lotteries, a, a1, sbs.get(0));

					if (addition == 1) {
						guilv(type, temp, query, lotteries, sbs,  sumVaule,
								even, fixation, matchType, number, addition, buchang, qi,conditions);
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
																	number,addition, buchang, qi ,conditions);
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
																							number, addition, buchang, qi ,conditions);
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
																										number, addition, buchang, qi,conditions );
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

	private static void guilv(int type, int sum, int query, List<CqsscLottery> lotteries,
			List<StringBuffer> sbs, List<String> sumVaule,
			int even, int fixation, int matchType, int number,int addition,int buchang,long qi, CqGuilvRemoveCondition  conditions) {

		if (fixation == 0) {
			getFixation(type, sum, query, lotteries, sbs,  sumVaule, even,
					fixation, matchType, number, addition, buchang, qi,conditions );
		} else {
			for (int e = 1; 10 > e; e++) {

				getFixation(type, sum, query, lotteries, sbs,   sumVaule,
						even, e, matchType, number, addition, buchang, qi,conditions );

			}
		}

	}

	/**
	 * 固定相加
	 */

	private static void getFixation(int type, int sum, int query,
			List<CqsscLottery> lotteries, List<StringBuffer> sbs,  
			List<String> sumVaule, int even, int e, int matchType, int number,int addition,int buchang,long qi, CqGuilvRemoveCondition  conditions) {
		int z = s(sum);
		int x = z + e;

		one(x, type, query, lotteries, sbs,   sumVaule, even, e, matchType,
				number, addition, buchang, qi ,conditions  );

	}

	/**
	 * 多结果
	 */
	private static Boolean more(int x, int query, int number) {
		 
		Integer[] nums = GuilvScUtils.getQueryValue(x, number);
		 
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
	private static void one(int x, int type, int query, List<CqsscLottery> lotteries,
			List<StringBuffer> sbs,   List<String> sumVaule,
			int even, int e, int matchType, int number,int addition,int buchang,long qi, CqGuilvRemoveCondition  conditions) {

		if (more(s(x), query, number)) {
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
				} else if (type == 4) {
					qq = lotteries.get(j).getNumber5();
				}
			
				if (more(s(temp2), qq, number)) {
					startValue=s(temp2);
					startQu=startQuTemp;
				 
				
					count++;
				} else {

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
					int num = s(temp2);
					String string="";
					String string1="";
					qu=qu.substring(0,qu.length()-1);
					if(startQu.length()>1){
						startQu=startQu.substring(0,startQu.length()-1); 
					}
					
					if(e==0){
						string ="判断条件为：" + qu+"";
						string1= startQu+"="+startValue+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvScUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";;
					}else{
						string ="判断条件为：" + e + "+" + qu+"";
						string1= e+"+" +startQu+"="+startValue+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvScUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";
								 
					}
				
				
					CqGuilvScopeOld vo = new CqGuilvScopeOld();
					vo.setAddition(addition);
					vo.setBuchang(buchang);
					vo.setEven(even);
					vo.setSum(count);
					vo.setMatchType(matchType);
					vo.setNumber(number);
					vo.setQi(qi);
					vo.setType(type);
					vo.setStartQueryValue(string1);
					vo.setStartValue(GuilvScUtils.getSumValue(startValue, number));
					vo.setValue(GuilvScUtils.getSumValue(num, number));
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
                       CqNumCountUtils.getGuilvScope(addition, buchang, fixation, number, vo, vo.getSum(), infoString);
     
					 
					 if(StringUtils.isNotEmpty(vo.getInfo())){
						 
						 vo.setNum(getOldLottery(vo.getSum(),addition, buchang, even, e, qi, matchType));
						 oScopeOLdService.saveGuilv(vo);
						 guilvRemove(vo,conditions,guilvRemoveCountService,conditionsService);
					 }
					 
					 
					 
				}

			}
		}

	}
	
	private static int getOldLottery(int sum,int addition, int buchang, int even,int fixation,long qi, int matchType){
		PageView<CqGuilvScopeOld> pageViewGuilv = new PageView<CqGuilvScopeOld>();
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
		List<CqGuilvScopeOld> gs=oScopeOLdService.findList(pageViewGuilv, filtersnewses).getResultlist();
		 
		int num=0;
		for(CqGuilvScopeOld g:gs){
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
	
 
	
	
	public static void guilvRemove(CqGuilvScopeOld g,CqGuilvRemoveCondition	conditions,CqGuilvRemoveCountService cocuntService,CqGuilvRemoveConditionService conditionService){
		
		boolean falg=CqGuilvRemoveConditionUtils.removeGuilv(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   removeCount(g,cocuntService, 0,conditions);
	    	   
	       }
	       
	        
	       falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   removeCount(g,cocuntService, 1,conditions);
	    	   
	       }
	     
	       condition(conditionService,conditions, g);
	}
	
	private static void removeCount(CqGuilvScopeOld g,CqGuilvRemoveCountService countService,int remove,CqGuilvRemoveCondition	conditions){
		
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
		   var[4]=2; 
		
		 CqGuilvRemoveCount count=countService.findGuilvs(objects, var);
		 if(count==null){
		  count=new CqGuilvRemoveCount();
 	    count.setInfo(g.getInfo());
 	    count.setNum(g.getNum());
 	    count.setQi(g.getQi());
 	    count.setQueryValue("【范围规】"+g.getQueryValue());
 	    count.setStartQueryValue(g.getStartQueryValue());
 	    count.setSum(g.getSum());
 	    count.setTypeVaule(g.getTypeVaule());;
 	    count.setValueNew(g.getValueNew());
 	    count.setValueQueryNew(g.getValueQueryNew());
 	    count.setValue(g.getValue());
 	    count.setStartValue(g.getStartValue());
         count.setType(g.getType());
         count.setGui(2);
 	    count.setRemove(remove);
 	   count.setNumber(g.getNumber());
 	  count.setSumMin(conditions.getSumMin());
 	   if(remove==0){
	 		  count.setSort(g.getSum()-conditions.getSum()+1);
	 	  }
 	  countService.saveGuilv(count);
		 }
 	  
 	   
	}
	
	public static void condition(CqGuilvRemoveConditionService conditionService,CqGuilvRemoveCondition condition,CqGuilvScopeOld g ){
	   if(condition!=null&&g!=null){
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

	}
	private static int   setold(int e,int type,List<StringBuffer> sbs,List<CqsscLottery> lotteries, int number,int co){
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
			} else if (type == 4) {
				qq = lotteries.get(j).getNumber5();
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

	private static String getQueryValue(List<CqsscLottery> lotteries, int j, int type) {
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

	private static int sum(List<CqsscLottery> lotteries, int j, int type, StringBuffer sb) {
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
