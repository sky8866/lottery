package com.sky.apps.action.lottery.web.utils.guilv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 

import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.XjsscGuilv;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.service.guilv.XjsscGuilvService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService;
 

 

public class XjsscGuilvUtils {
	 
	public  static void setQuery(int addition,
			  int buchang,
			 int type,
			 int even,
			 int fixation,
			  int matchType,
			 int number,XjsscLotteryService lotteryService,XjsscGuilvService guilvService,List<XjsscGuilv> sbr,boolean isvip,List<XjsscLottery> lotteries){
	   
		
		
		int query = 0;

		if (type == 0) {
			query = lotteries.get(0).getNumber1();
		} else if (type == 1) {
			query = lotteries.get(0).getNumber2();
		} else if (type == 2) {
			query = lotteries.get(0).getNumber3();
		} else if (type == 3) {
			query = lotteries.get(0).getNumber4();
		}else if (type == 4) {
			query = lotteries.get(0).getNumber5();
		}

		List<StringBuffer> sbs = getSb(addition);

		  
		List<String> sumVaule = new ArrayList<String>();
		
		
		long qi = lotteries.get(0).getQi() + 1;
		 
		PageView<XjsscGuilv> pageViewGuilv = new PageView<XjsscGuilv>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		  
		 
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi)); 
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<XjsscGuilv> guilvs = pageViewGuilv.getRecords();
		
		if (guilvs.isEmpty()) {
			for (int a = 1; buchang > a; a++) {

				for (int a1 = 0; a1 < 5; a1++) {
					int temp = sum(lotteries, a, a1, sbs.get(0));

					if (addition == 1) {
						guilv(type, temp, query, lotteries, sbs, sbr, sumVaule,
								even, fixation, matchType, number, addition, buchang, qi,   guilvService);
					} else {
						for (int b = 1; buchang > b; b++) {
							for (int b1 = 0; b1 < 5; b1++) {
								int q1 = sum(lotteries, b, b1, sbs.get(1));
								int temp1 = temp + q1;

								if (addition == 2) {
									guilv(type, temp1, query, lotteries, sbs,
											sbr, sumVaule, even, fixation,
											matchType, number,  addition, buchang,  qi, guilvService);
								} else {
									for (int c = 1; buchang > c; c++) {
										for (int c1 = 0; c1 < 5; c1++) {
											int q2 = sum(lotteries, c, c1,
													sbs.get(2));
											int temp2 = temp1 + q2;

											if (addition == 3) {
												guilv(type, temp2, query,
														lotteries, sbs, sbr,
														sumVaule, even,
														fixation, matchType,
														number,  addition,buchang,qi,  guilvService);
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
																	sbs, sbr,
																	sumVaule,
																	even,
																	fixation,
																	matchType,
																	number,addition, buchang, qi,  guilvService);
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
																				sbr,
																				sumVaule,
																				even,
																				fixation,
																				matchType,
																				number, addition,buchang, qi,guilvService);
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
																							sbr,
																							sumVaule,
																							even,
																							fixation,
																							matchType,
																							number, addition, buchang, qi,  guilvService);
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
																										sbr,
																										sumVaule,
																										even,
																										fixation,
																										matchType,
																										number, addition, buchang, qi,  guilvService);
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
	
	 
	
	public static String getVaule(List<CqsscGuilv> sbr, int type) {
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
		String vsString = "";
		int n0 = 0;
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int n6 = 0;
		int n7 = 0;
		int n8 = 0;
		int n9 = 0;

		for (CqsscGuilv vo : sbr) {
			if (Integer.valueOf(vo.getValue()) == 0) {
				n0++;
			} else if (Integer.valueOf(vo.getValue()) == 1) {
				n1++;
			} else if (Integer.valueOf(vo.getValue()) == 2) {
				n2++;
			} else if (Integer.valueOf(vo.getValue()) == 3) {
				n3++;
			} else if (Integer.valueOf(vo.getValue()) == 4) {
				n4++;
			} else if (Integer.valueOf(vo.getValue()) == 5) {
				n5++;
			} else if (Integer.valueOf(vo.getValue()) == 6) {
				n6++;
			} else if (Integer.valueOf(vo.getValue()) == 7) {
				n7++;
			} else if (Integer.valueOf(vo.getValue()) == 8) {
				n8++;
			} else if (Integer.valueOf(vo.getValue()) == 9) {
				n9++;
			}
		}
		vsString = "9" + stypeString + "共有" + n9 + "条记录;" + "8" + stypeString
				+ "共有" + n8 + "条记录;" + "7" + stypeString + "共有" + n7 + "条记录;"
				+ "6" + stypeString + "共有" + n6 + "条记录;" + "5" + stypeString
				+ "共有" + n5 + "条记录;<br>" + "4" + stypeString + "共有" + n4
				+ "条记录; " + "3" + stypeString + "共有" + n3 + "条记录;" + "2"
				+ stypeString + "共有" + n2 + "条记录;" + "1" + stypeString + "共有"
				+ n1 + "条记录;" + "0" + stypeString + "共有" + n0 + "条记录;";
		return vsString;
	}

	public static  List<StringBuffer> getSb(int addition) {
		List<StringBuffer> sbs = new ArrayList<StringBuffer>();
		for (int i = 0; i < addition; i++) {
			StringBuffer sb1 = new StringBuffer();
			sbs.add(sb1);
		}

		return sbs;

	}

	private static void guilv(int type, int sum, int query, List<XjsscLottery> lotteries,
			List<StringBuffer> sbs, List<XjsscGuilv> sbr, List<String> sumVaule,
			int even, int fixation, int matchType, int number,int addition,int buchang,long qi, XjsscGuilvService guilvService) {

		if (fixation != 10) {
			getFixation(type, sum, query, lotteries, sbs, sbr, sumVaule, even,
					fixation, matchType, number, addition, buchang, qi,  guilvService);
		} else {
			for (int e = 1; 10 > e; e++) {

				getFixation(type, sum, query, lotteries, sbs, sbr, sumVaule,
						even, e, matchType, number, addition, buchang, qi,  guilvService);

			}
		}

	}

	/**
	 * 固定相加
	 */

	private static void getFixation(int type, int sum, int query,
			List<XjsscLottery> lotteries, List<StringBuffer> sbs, List<XjsscGuilv> sbr,
			List<String> sumVaule, int even, int e, int matchType, int number,int addition,int buchang,long qi, XjsscGuilvService guilvService) {
		int z = s(sum);
		int x = z + e;

		one(x, type, query, lotteries, sbs, sbr, sumVaule, even, e, matchType,
				number, addition, buchang, qi,  guilvService);

	}

	/**
	 * 多结果
	 */
	private static Boolean more(int x, int query, int number) {
		 
		Integer[] nums = GuilvUtils.getQueryValue(x, number);
		 
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
	private static void one(int x, int type, int query, List<XjsscLottery> lotteries,
			List<StringBuffer> sbs, List<XjsscGuilv> sbr, List<String> sumVaule,
			int even, int e, int matchType, int number,int addition,int buchang,long qi, XjsscGuilvService guilvService) {

	
			  int startValue=0;
	            String startQu=""; 
	            
	          //连对    
			int count = 0;
			//连续错
			int errorNum=0;
			
			//错次数
			int errorCou=0;
			
			int duiNum=0;
			
			int countMin=0;
			int countTemp=0;
			int errorTemp=0;
			int c=0;
			
			  for (int j = 1; 145 > j; j++) {
				   
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
			
				if (!more(s(temp2), qq, number)) {
					startValue=s(temp2);
					startQu=startQuTemp;
						countTemp++;	
						
						if(countTemp>countMin){
							countMin=countTemp;
						}
						
						
						count++;
						errorTemp=0;
				} else {
					
					if(countTemp>20){
						duiNum++;
					}
					
					countTemp=0;
					count=0;
					errorTemp++;
					if(errorTemp>errorNum){
						errorNum=errorTemp;
					}
					errorCou++;
					c++;
				
				}

			}
			 if(countMin>=14&&errorNum<3&&errorCou<8){ 
				 
				//	 System.out.println("总错："+c);
				  
				/* if(c<101){*/
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
					} else if (type == 4) {
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
						string1= startQu+"="+startValue+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";;
					}else{
						string ="判断条件为：" + e + "+" + qu+"";
						string1= e+"+" +startQu+"="+startValue+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvUtils.getSumValue(startValue, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";
								 
					}
				
				
					XjsscGuilv vo = new XjsscGuilv();
					vo.setAddition(addition);
					vo.setBuchang(buchang);
					vo.setEven(even);
					vo.setSum(count);
					vo.setMatchType(matchType);
					vo.setNumber(number);
					vo.setQi(qi);
					vo.setType(type);
					vo.setStartQueryValue(string1);
					vo.setStartValue(GuilvUtils.getSumValue(startValue, number));
					vo.setValue(GuilvUtils.getSumValue(num, number));
					vo.setFixation(e);
					vo.setQueryValue(string);
                    vo.setValueOld(countold+"");
                    vo.setValueNew(sbs.toString());
                    vo.setErrorCou(errorCou);
                    vo.setErrorNum(errorNum);
                    vo.setCountMin(countMin);
                    vo.setErrorSum(c);
                    vo.setDuiNum(duiNum);
                    
                    vo.setTypeVaule("本期的"+stypeString+"杀:"+vo.getValue()+",此位置已经连续 ："+count+"期杀这些数字！");
                    vo.setGui(1);
                    
                      
                     
                       
                       
         
					 guilvService.saveGuilvKill(vo); 
					 
					 
					 
					sbr.add(vo);
				}

			}
			 }

	}
	
	private static int   setold(int e,int type,List<StringBuffer> sbs,List<XjsscLottery> lotteries, int number,int co){
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
               
			if (!more(s(temp2), qq, number)) {
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

	private static String getQueryValue(List<XjsscLottery> lotteries, int j, int type) {
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
		String valueString = +lotteries.get(j).getQi() + "期的" + lString+"+" ;
		return valueString;
	}

	private static int sum(List<XjsscLottery> lotteries, int j, int type, StringBuffer sb) {
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
