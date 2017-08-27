package com.sky.apps.action.lottery.web.utils.guilv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 

import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvLimit;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.LotteryService;
 

public class LotteryLimitUtils {
	 
	
	public  static void setQuery(int addition,
			  int buchang,
			 int type,
			 int even,
			 int fixation,
			  int matchType,
			  int  number,LotteryService lotteryService,GuilvLimitService guilvService,List<GuilvLimit> sbr,boolean isvip){
 
		
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
       
		List<Lottery> lotteries = pageView.getRecords();
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
		int qi = lotteries.get(0).getQi() + 1;
		 
		PageView<GuilvLimit> pageViewGuilv = new PageView<GuilvLimit>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		if(fixation==10){
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
			filtersnewses
			.add(new PropertyFilter("sum",MatchType.LT, 8));
		}
		
		
		 
		//filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, 2));
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvLimit> guilvs = pageViewGuilv.getRecords();
		
		if (guilvs.isEmpty()) {
			for (int a = 1; buchang > a; a++) {

				for (int a1 = 0; a1 < 7; a1++) {
					int temp = sum(lotteries, a, a1, sbs.get(0));

					if (addition == 1) {
						guilv(type, temp, query, lotteries, sbs, sbr, sumVaule,
								even, fixation, matchType ,  addition,  buchang,  qi, guilvService);
					} else {
						for (int b = 1; buchang > b; b++) {
							for (int b1 = 0; b1 < 7; b1++) {
								int q1 = sum(lotteries, b, b1, sbs.get(1));
								int temp1 = temp + q1;

								if (addition == 2) {
									guilv(type, temp1, query, lotteries, sbs,
											sbr, sumVaule, even, fixation,
											matchType , addition,  buchang, qi,  guilvService);
								} else {
									for (int c = 1; buchang > c; c++) {
										for (int c1 = 0; c1 < 7; c1++) {
											int q2 = sum(lotteries, c, c1,
													sbs.get(2));
											int temp2 = temp1 + q2;

											if (addition == 3) {
												guilv(type, temp2, query,
														lotteries, sbs, sbr,
														sumVaule, even,
														fixation, matchType ,  addition,  buchang,  qi,  guilvService );
											} else {
												for (int d = 1; buchang > d; d++) {
													for (int d1 = 0; d1 < 7; d1++) {
														int q3 = sum(lotteries,
																d, d1,
																sbs.get(3));
														int temp3 = temp2 + q3;

														if (addition == 4) {
															guilv(type, temp3,
																	query,
																	lotteries,
																	sbs, sbr,
																	sumVaule,
																	even,
																	fixation,
																	matchType, addition,  buchang, qi,  guilvService );
														} else {
															for (int e = 1; buchang > e; e++) {
																for (int e1 = 0; e1 < 7; e1++) {
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
																				sbr,
																				sumVaule,
																				even,
																				fixation,
																				matchType ,  addition,  buchang,  qi,   guilvService);
																	} else {
																		for (int f = 1; buchang > f; f++) {
																			for (int f1 = 0; f1 < 7; f1++) {
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
																							sbr,
																							sumVaule,
																							even,
																							fixation,
																							matchType ,  addition,  buchang,  qi,  guilvService);
																				} else {
																					for (int g = 1; buchang > g; g++) {
																						for (int g1 = 0; g1 < 7; g1++) {
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
																										sbr,
																										sumVaule,
																										even,
																										fixation,
																										matchType, addition,  buchang,  qi,   guilvService );
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
			 for (GuilvLimit g : guilvs) {
				 
				sbr.add(g);
			} 

		}
 
		ComparatorGuilvLimit guilv = new ComparatorGuilvLimit();

		Collections.sort(sbr, guilv); 

	}
	
	 
	
	 
	public static  List<StringBuffer> getSb(int addition) {
		List<StringBuffer> sbs = new ArrayList<StringBuffer>();
		for (int i = 0; i < addition; i++) {
			StringBuffer sb1 = new StringBuffer();
			sbs.add(sb1);
		}

		return sbs;

	}

	private static void guilv(int type, int sum, int query, List<Lottery> lotteries,
			List<StringBuffer> sbs, List<GuilvLimit> sbr, List<String> sumVaule,
			int even, int fixation, int matchType,int addition,int buchang,int qi, GuilvLimitService guilvService) {
         
		if (fixation != 10) {
			getFixation(type, sum, query, lotteries, sbs, sbr, sumVaule, even,
					fixation, matchType,  addition,  buchang,  qi, guilvService );
		} else {
			for (int e = 1; 10 > e; e++) {

				getFixation(type, sum, query, lotteries, sbs, sbr, sumVaule,
						even, e, matchType ,  addition,  buchang,  qi,  guilvService );

			}
		}

	}

	/**
	 * 固定相加
	 */

	private static void getFixation(int type, int sum, int query,
			List<Lottery> lotteries, List<StringBuffer> sbs, List<GuilvLimit> sbr,
			List<String> sumVaule, int even, int e, int matchType,int addition,int buchang,int qi, GuilvLimitService guilvService) {
		int z = s(sum);
		int x = z + e;
        for(int number=0;number<=1;number++){
        	one(x, type, query, lotteries, sbs, sbr, sumVaule, even, e, matchType,number, addition, buchang, qi,  guilvService);
        }
	

	}

	/**
	 * 多结果
	 */
	private static Boolean more(int x, int query,int number) {
		 
		Integer[] nums = GuilvLimitUtils.getQueryValue( x,number);
	 
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
	private static void one(int x, int type, int query, List<Lottery> lotteries,
			List<StringBuffer> sbs, List<GuilvLimit> sbr, List<String> sumVaule,
			int even, int e, int matchType,int number,int addition,int buchang,int qi, GuilvLimitService guilvService) {
		
		if (!more(s(x), query,number)) {
			 int startValue=0;
	            String startQu=""; 
	            
	            int oldQi=0;
			int count = 1;
			B: for (int j = 1; lotteries.size() > j; j++) {
				int temp2 = 0;
				 String startQuTemp=""; 
				for (StringBuffer sb : sbs) {
					int s1 = Integer.valueOf(sb.toString().split(",")[0]);

					int v1 = Integer.valueOf(sb.toString().split(",")[1]);
					String ve = getQueryValue(lotteries,  s1 + j, v1);
					oldQi=lotteries.get(s1 + j).getQi();
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

				if (!more(s(temp2), qq,number)) {
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
		 	  int countold = setold( e,type,sbs, lotteries, count,number); 
				 
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
					int num = s(temp2);
					 
					String string="";
					String string1="";
					qu=qu.substring(0,qu.length()-1);
					startQu=startQu.substring(0,startQu.length()-1); 
					if(e==0){
						string ="判断条件为：" + qu+"";
						string1= startQu+"="+startValue+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvLimitUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续错了"+count+"期。";;
					}else{
						string ="判断条件为：" + e + "+" + qu+"";
						string1= e+"+" +startQu+"="+startValue+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvLimitUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续错了"+count+"期。";
								 
					}
					
					
					
					GuilvLimit vo = new GuilvLimit();
					vo.setAddition(addition);
					vo.setBuchang(buchang);
					vo.setEven(even);
					vo.setSum(count);
					vo.setMatchType(matchType);
					vo.setNumber(number);
					vo.setQi(qi);
					vo.setType(type);
					vo.setStartQueryValue(string1);
					vo.setStartValue(GuilvLimitUtils.getSumValue(startValue, number));
					vo.setValue(GuilvLimitUtils.getSumValue( num,number));
					vo.setFixation(e);
					vo.setQueryValue(string);
                    vo.setValueOld(countold+"");
                    vo.setValueNew(sbs.toString());
                    vo.setTypeVaule("本期的"+stypeString+"为:"+vo.getValue()+",已经连错："+count+"期");
                    vo.setGui(2);
                	String infoString="历史上最高记录连续错:"+vo.getValueOld()+"期，目前已错："+vo.getSum()+"期，可以参考了！";
					
					if(number==1&&buchang<=5&&addition<=5&&vo.getSum()>=2+addition){
						vo.setInfo(infoString);
					} else if(number==1&& buchang>5&&vo.getSum()>=3+addition){
						vo.setInfo(infoString);
					} else if(number==0&&buchang<=5&&addition<=5&&vo.getSum()>3+addition){
						vo.setInfo(infoString);
					}else if(number==0&&buchang>5&&vo.getSum()>4+addition){
						vo.setInfo(infoString);
					}else if(number==2&&buchang<=5&&addition<=5&&vo.getSum()>3+addition){
						vo.setInfo(infoString);
					}else if(number==2&&buchang>5&&vo.getSum()>4+addition){
						vo.setInfo(infoString);
					}else if(number==2&&buchang<=5&&addition<=2&&vo.getSum()>6){
						vo.setInfo(infoString);
					}else if(number==3&&buchang<=5&&addition<=5&&vo.getSum()>7+addition){
						vo.setInfo(infoString);
					}else if(number==3&&buchang>5&&vo.getSum()>8+addition){
						vo.setInfo(infoString);
					}else if(number==4&&buchang<=5&&addition<=5&&vo.getSum()>9+addition){
						vo.setInfo(infoString);
					}else if(number==4&&buchang>5&&vo.getSum()>10+addition){
						vo.setInfo(infoString);
					}else if(number==5&&buchang<=5&&addition<=5&&vo.getSum()>13+addition){
						vo.setInfo(infoString);
					}else if(number==5&&buchang>5&&vo.getSum()>14+addition){
						vo.setInfo(infoString);
					} else if(number==6&&buchang<=5&&addition<=5&&vo.getSum()>18+addition){
						vo.setInfo(infoString);
					}else if(number==6&&buchang>5&&vo.getSum()>19+addition){
						vo.setInfo(infoString);
					}  
					 guilvService.saveGuilv(vo); 
					sbr.add(vo);
				}

			}
		}

	}
	
	private static int   setold(int e,int type,List<StringBuffer> sbs,List<Lottery> lotteries, int co,int number){
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
               
			if (!more(s(temp2), qq,number)) {
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

	private static String getQueryValue(List<Lottery> lotteries, int j, int type) {
		Integer[] l = { lotteries.get(j).getNumber1(),
				lotteries.get(j).getNumber2(), lotteries.get(j).getNumber3(),
				lotteries.get(j).getNumber4(), lotteries.get(j).getNumber5(),
				lotteries.get(j).getNumber6(), lotteries.get(j).getNumber7() };
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
		} else if (type == 5) {
			lString = "F[" + sum + "]";
		} else if (type == 6) {
			lString = "G[" + sum + "]";
		}
		String valueString = lotteries.get(j).getQi() + "期的" + lString+"+";
		return valueString;
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

	private static int s(int sum) {
		if (sum >= 10) {

			do {
				sum = sum - 10;
			} while (sum >= 10);

		}

		return sum;

	}

}
