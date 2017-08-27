package com.sky.apps.action.lottery.web.engine.guilv;

import java.util.List;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvService;

public class ZongheUtils {

	public void  additionSum(List<Lottery> lotteries,List<StringBuffer> numbers,int query,int type,int buchang,int addition,int even,int fixation,int matchType,int  count,int qi ,int num) {
		 
		for (int a = 1; buchang > a; a++) {

			for (int a1 = 0; a1 < num; a1++) {
				int temp = AdditionUtils.num(lotteries, a, a1, numbers.get(0));

				if (addition == 1) {
					guilv(type, temp, query, lotteries, numbers, even, fixation, matchType, count, addition, buchang, qi);
					
					 
				} else {
					for (int b = 1; buchang > b; b++) {
						for (int b1 = 0; b1 < num; b1++) {
							int q1 = AdditionUtils.num(lotteries, b, b1, numbers.get(1));
							int temp1 = temp + q1;

							if (addition == 2) {
								guilv(type, temp1, query, lotteries, numbers, even, fixation, matchType, count, addition, buchang, qi);
							} else {
								for (int c = 1; buchang > c; c++) {
									for (int c1 = 0; c1 < num; c1++) {
										int q2 = AdditionUtils.num(lotteries, c, c1,
												numbers.get(2));
										int temp2 = temp1 + q2;

										if (addition == 3) {
											guilv(type, temp2, query, lotteries, numbers, even, fixation, matchType, count, addition, buchang, qi);
										} else {
											for (int d = 1; buchang > d; d++) {
												for (int d1 = 0; d1 <num; d1++) {
													int q3 = AdditionUtils.num(lotteries, d,
															d1, numbers.get(3));
													int temp3 = temp2 + q3;

													if (addition == 4) {
														guilv(type, temp3, query, lotteries, numbers, even, fixation, matchType, count, addition, buchang, qi);  
													} else {
														for (int e = 1; buchang > e; e++) {
															for (int e1 = 0; e1 < num; e1++) {
																int q4 = AdditionUtils.num(
																		lotteries,
																		e,
																		e1,
																		numbers.get(4));
																int temp4 = temp3
																		+ q4;

																if (addition == 5) { 
																	guilv(type, temp4, query, lotteries, numbers, even, fixation, matchType, count, addition, buchang, qi); 
																} else {
																	for (int f = 1; buchang > f; f++) {
																		for (int f1 = 0; f1 < num; f1++) {
																			int q5 = AdditionUtils.num(
																					lotteries,
																					f,
																					f1,
																					numbers.get(5));
																			int temp5 = temp4 + q5;

																			if (addition == 6) {
																				guilv(type, temp5, query, lotteries, numbers, even, fixation, matchType, count, addition, buchang, qi);
																			}else{
																		 
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
	
	
	private static void guilv(int type, int sum, int query, List<Lottery> lotteries,
			List<StringBuffer> sbs,
			int even, int fixation, int matchType, int number,int addition,int buchang,int qi) {

		if (fixation != 10) { 
		} else {
			for (int e = 0; 10 > e; e++) {

			 

			}
		}

	}

}
