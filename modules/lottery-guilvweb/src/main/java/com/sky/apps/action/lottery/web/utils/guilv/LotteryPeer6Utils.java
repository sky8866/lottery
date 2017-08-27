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
import com.sky.modules.lottery.entity.guilv.GuilvPeer6;
import com.sky.modules.lottery.entity.guilv.GuilvPeer6Old;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCondition;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.Lottery; 
import com.sky.modules.lottery.service.guilv.GuilvPeer6OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.GuilvPeer6Service; 
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.LotteryService;

 
 

 

public class LotteryPeer6Utils {
	private	 static GuilvPeer6OldService peerOldService;
	private	 static  GuilvRemoveCountService guilvRemoveCountService;
	private	 static  GuilvRemoveConditionService  conditionsService;
 
	public  static void setQuery(int addition,
			  int buchang,
			 int type,
			 int even,
			 int fixation,
			  int matchType,
			 int number,LotteryService lotteryService,GuilvPeer6Service guilvService,List<GuilvPeer6> sbr,boolean isvip,GuilvPeer6OldService guilvOldService,  GuilvRemoveCountService countService,GuilvRemoveConditionService conditionService){
		peerOldService=guilvOldService;
		 guilvRemoveCountService=countService;
		 conditionsService=conditionService;
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
       
		List<Lottery> lotteries = pageView.getRecords();
	

		 

		List<StringBuffer> sbs = getSb(1);
		List<StringBuffer> sbs2 = getSb(addition);
		
		
		  
		List<String> sumVaule = new ArrayList<String>();
		if(lotteries.isEmpty()){
			pageView.setQueryResult(lotteryService.findList(pageView, null));
		       
			 lotteries = pageView.getRecords();
			 
		}
		int qi = lotteries.get(0).getQi() + 1;
		 
		PageView<GuilvPeer6> pageViewGuilv = new PageView<GuilvPeer6>();
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
		even=even-2;
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
				.add(new PropertyFilter("sum", MatchType.LT, 5));
			 
			
			
		}
		
		
		
		
		
		 
		filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, 10));
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvPeer6> guilvs = pageViewGuilv.getRecords();
		
		int query = sum(lotteries, 0, type, sbs2.get(0)); 
	 
		if (guilvs.isEmpty()) {
			GuilvRemoveCondition  conditions=conditionService.findGuilv(fixation, buchang, addition, number, 10);
				
				if (addition == 2) {
					for (int a = 1; buchang > a; a++) {
					for (int aq1 = 0; aq1 < 7; aq1++) {
						int query1 = query+sum(lotteries, a, aq1, sbs2.get(1));	
						for(int b1=1;buchang>b1;b1++){
							for (int bb1 = 0; bb1 < 7; bb1++) {
								int temp = sum(lotteries, b1, bb1, sbs.get(0));
								
										guilv(type, temp, query1, lotteries, sbs, sbr, sumVaule,
												even, fixation, matchType, number, addition, buchang, qi,   guilvService,sbs2,conditions);
									 
								 
							}	
						}
						
					}
					}
				}else if(addition==3){
					for (int a = 1; buchang > a; a++) {
					for (int aq1 = 0; aq1 < 7; aq1++) {
						int query1 = query+sum(lotteries, a, aq1, sbs2.get(1));
						for(int a1=1;buchang>a1;a1++){
							for(int aq2=0;aq2<7;aq2++){
								int query2 = query1+sum(lotteries, a1, aq2, sbs2.get(2));
								 
								for(int b1=1;buchang>b1;b1++){
									for (int bb1 = 0; bb1 < 7; bb1++) {
										int temp = sum(lotteries, b1, bb1, sbs.get(0));
									 
										  
														guilv(type, temp, query2, lotteries, sbs, sbr, sumVaule,
																even, fixation, matchType, number, addition, buchang, qi,   guilvService,sbs2,conditions);
														
											 
									}	
								}
								 
							}
						}
					 
						
					}
				}
 
			}else if(addition==4){
				for (int a = 1; buchang > a; a++) {
				for (int aq = 0; aq < 7; aq++) {
					int query1 = query+sum(lotteries, a, aq, sbs2.get(1));
					for(int a1=1;buchang>a1;a1++){
						for(int aq1=0;aq1<7;aq1++){
							int query2 = query1+sum(lotteries, a1, aq1, sbs2.get(2));
							for(int a2=1;buchang>a2;a2++){
								for(int aq2=0;aq2<7;aq2++){
									int query3 = query2+sum(lotteries, a2, aq2, sbs2.get(3));
									for(int b1=1;buchang>b1;b1++){
										for (int bb1 = 0; bb1 < 7; bb1++) {
											int temp = sum(lotteries, b1, bb1, sbs.get(0));
											  
																	guilv(type, temp, query3, lotteries, sbs, sbr, sumVaule,
																			even, fixation, matchType, number, addition, buchang, qi,   guilvService,sbs2,conditions);
													
										}	
									}
								}
							}
							 
							
							 
						}
					}
				 
					
				}
			}

		}else if(addition==5){
			for (int a = 1; buchang > a; a++) {
			for (int aq = 0; aq < 7; aq++) {
				int query1 = query+sum(lotteries, a, aq, sbs2.get(1));
				for(int a1=1;buchang>a1;a1++){
					for(int aq1=0;aq1<7;aq1++){
						int query2 = query1+sum(lotteries, a1, aq1, sbs2.get(2));
						for(int a2=1;buchang>a2;a2++){
							for(int aq2=0;aq2<7;aq2++){
								int query3 = query2+sum(lotteries, a2, aq2, sbs2.get(3));
								for(int a3=1;buchang>a3;a3++){
									for(int aq3=0;aq3<7;aq3++){
										int query4 = query3+sum(lotteries, a3, aq3, sbs2.get(4));
										for(int b1=1;buchang>b1;b1++){
											for (int bb1 = 0; bb1 < 7; bb1++) {
												int temp = sum(lotteries, b1, bb1, sbs.get(0));
												
																				guilv(type, temp, query4, lotteries, sbs, sbr, sumVaule,
																						even, fixation, matchType, number, addition, buchang, qi,   guilvService,sbs2,conditions);
																		
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
		/*	for (GuilvPeer g : guilvs) {
				 
				sbr.add(g);
			}*/

		}

		/*ComparatorGuilvPeer guilv = new ComparatorGuilvPeer();

		Collections.sort(sbr, guilv);*/

	}
	
	 

	private static void guilv(int type, int sum, int query, List<Lottery> lotteries,
			List<StringBuffer> sbs, List<GuilvPeer6> sbr, List<String> sumVaule,
			int even, int fixation, int matchType, int number,int addition,int buchang,int qi, GuilvPeer6Service guilvService,List<StringBuffer> sbs2,GuilvRemoveCondition  conditions) {
       
         
  
		if (fixation != 10) {
			getFixation(type, sum, query, lotteries, sbs, sbr, sumVaule, even,
					fixation, matchType, number, addition, buchang, qi,  guilvService,sbs2,conditions);
		} else {
			for (int e = 1; 10 > e; e++) {

				getFixation(type, sum, query, lotteries, sbs, sbr, sumVaule,
						even, e, matchType, number, addition, buchang, qi,  guilvService,sbs2,conditions);

			}
		}

	}
	
	
	
	/**
	 * 固定相加
	 */

	private static void getFixation(int type, int sum, int query,
			List<Lottery> lotteries, List<StringBuffer> sbs, List<GuilvPeer6> sbr,
			List<String> sumVaule, int even, int fixation, int matchType, int number,int addition,int buchang,int qi, GuilvPeer6Service guilvService,List<StringBuffer> sbs2,GuilvRemoveCondition  conditions) {
		int z = s(sum);
		int x = z + fixation;

		one(x, type, query, lotteries, sbs, sbr, sumVaule, even, fixation, matchType,
				number, addition, buchang, qi,  guilvService,sbs2,conditions);

	}
	
	
	
	/**
	 * 单结果
	 */
	private static void one(int x, int type, int query, List<Lottery> lotteries,
			List<StringBuffer> sbs, List<GuilvPeer6> sbr, List<String> sumVaule,
			int even, int fixation, int matchType, int number,int addition,int buchang,int qi, GuilvPeer6Service guilvService,List<StringBuffer> sbs2,GuilvRemoveCondition  conditions) {

		if (more(s(x), query, number)) {
			 
	            String startQu=""; 
	         
	             
			int count = 1;
			B: for (int j = 1; lotteries.size() > j; j++) {
				int temp2 = 0;
				int tempquery2 = 0; 
		            String startQuTemp=""; 
		            String startQuTemp1=""; 
		          
				for (StringBuffer sb : sbs) {
					int s1 = Integer.valueOf(sb.toString().split(",")[0]);

					int v1 = Integer.valueOf(sb.toString().split(",")[1]);
					String ve = getQueryValue(lotteries,  s1 + j, v1);
					 
					startQuTemp = startQuTemp + ve;
					int qq1 = sum(lotteries, s1 + j, v1, null);
					 
					temp2 = temp2 + qq1;
					 
				}

				temp2 = s(temp2) + fixation;
			 
				int sn=0;
				for (StringBuffer sb : sbs2) {
					int s1 = Integer.valueOf(sb.toString().split(",")[0]);

					int v1 = Integer.valueOf(sb.toString().split(",")[1]);
					String ve = getQueryValue(lotteries,  s1+j, v1);
					 
					startQuTemp1 = startQuTemp1 + ve;
					int qq1 = sum(lotteries, s1 + j, v1, null);
					 
					
					tempquery2 = tempquery2 + qq1;
					
				}
				
				 

				if (more(s(temp2), tempquery2, number)) {
 
					startQu=startQuTemp.substring(0,startQuTemp.length()-1)+"="+startQuTemp1.substring(0,startQuTemp1.length()-1);
					 
					count++;
				} else {

					break B;

				}

			}
		 
			String qu = "";
            String qu2="";
			boolean bsum = count == even;
			if (matchType == 1) {
				bsum = count >= even;
			} else if (matchType == 2) {
				bsum = count < even;
			} else if (matchType == 3) {
				bsum = count > even;
			}
			
			if (bsum) {
				
				
				 
		 	  int countold = setold( fixation,type,sbs, lotteries,  number,count,sbs2); 
				 
				int temp2 = 0;
				int s1 = 0;
				List<String> flags = new ArrayList<String>();
				List<String> flags2 = new ArrayList<String>();
                     
				for (StringBuffer sb : sbs) {
					s1 = Integer.valueOf(sb.toString().split(",")[0]);

					int v1 = Integer.valueOf(sb.toString().split(",")[1]);
					String ve = getQueryValue(lotteries, s1 - 1, v1);

					flags.add(sb.toString());

					qu = qu + ve;
					int qq1 = sum(lotteries, s1 - 1, v1, null);
					temp2 = temp2 + qq1;
					
				}
				
				
				
				
				int tempQu=0;
				
				 for (int i=1;i<sbs2.size();i++) {
					s1 = Integer.valueOf(sbs2.get(i).toString().split(",")[0]);

					int v1 = Integer.valueOf(sbs2.get(i).toString().split(",")[1]);
					String ve = getQueryValue(lotteries, s1 - 1, v1);
				
					flags2.add(sbs2.get(i).toString());

					qu2 = qu2 + ve;
					int qq2 = sum(lotteries, s1 - 1, v1, null);
					tempQu=tempQu+qq2;
				

				} 
				
             
				boolean flag = getValueFilter(flags, sumVaule);
              
				if (flag) {
					
					 
					temp2 = (s(s(temp2) + s(fixation))+10)-s(tempQu);
					
					String stypeString = "";
					   int startNum=0;  
					if (type == 0) {
						stypeString = "头";
						startNum=lotteries.get(count-1).getNumber1();
					} else if (type == 1) {
						stypeString = "百";
						startNum=lotteries.get(count-1).getNumber2();
					} else if (type == 2) {
						stypeString = "十";
						startNum=lotteries.get(count-1).getNumber3();
					} else if (type == 3) {
						stypeString = "尾";
						startNum=lotteries.get(count-1).getNumber4();
					}
					int num = s(temp2);
					if(num<0){
						 BigInteger b = new BigInteger(num+"");
			                b = b.abs();
			                num=Integer.valueOf(b.toString());
					}
					
					String string="";
					String string1="";
					qu=qu.substring(0,qu.length()-1);
					
				 
						string ="判断条件为：" + qu+"="+qu2+qi+"期的"+stypeString+":"+GuilvPeerUtils.getSumValue(num, number);
						string1= startQu+"，即"+lotteries.get(count-1).getQi()+"期为："+GuilvPeerUtils.getSumValue(startNum, number)+stypeString+",此规从"+lotteries.get(count-1).getQi()+"期开始，已经连续跑了"+count+"期。";;
					 
			 
				
						GuilvPeer6 vo = new GuilvPeer6();
					vo.setAddition(addition);
					vo.setBuchang(buchang);
					vo.setEven(even);
					vo.setSum(count);
					vo.setMatchType(matchType);
					vo.setNumber(number);
					vo.setQi(qi);
					vo.setType(type);
					vo.setStartQueryValue(string1);
					vo.setStartValue(GuilvPeerUtils.getSumValue(startNum, number));
					vo.setValue(GuilvPeerUtils.getSumValue(num, number));
					vo.setFixation(fixation);
					vo.setQueryValue(string);
                    vo.setValueOld(countold+"");
                    vo.setValueNew(sbs.toString());
                    vo.setValueQueryNew(sbs2.toString());
                    vo.setTypeVaule("本期的"+stypeString+"为:"+vo.getValue()+",已经连对："+count+"期");
                    vo.setGui(10);
                   
                       String infoString="历史上最高记录连续跑:"+vo.getValueOld()+"期，目前已跑："+vo.getSum()+"期，小心会断了！";
					
					if(number==1&&buchang<=5&&addition<=5&&vo.getSum()>=2+addition){
						vo.setInfo(infoString);
					} else if(number==1&& buchang>5&&vo.getSum()>=3+addition){
						vo.setInfo(infoString);
					} else if(number==0&&buchang<=5&&addition<=5&&vo.getSum()>3+addition){
						vo.setInfo(infoString);
					}else if(number==0&&buchang>5&&vo.getSum()>4+addition){
						vo.setInfo(infoString);
					} 
					 guilvService.saveGuilv(vo); 
					 if(StringUtils.isNotEmpty(vo.getInfo())){
						 
						 GuilvPeer6Old old=new GuilvPeer6Old(vo);
						 old.setNum(getOldLottery(vo.getSum(),addition, buchang, even, fixation, qi, matchType));
						guilvService.saveGuilvPeer6Old(old);
						guilvRemove(old,conditions,guilvRemoveCountService,conditionsService);
					 }
					sbr.add(vo);
				}

			}
		}

	}	
	public static void guilvRemove(GuilvPeer6Old g,GuilvRemoveCondition conditions,GuilvRemoveCountService cocuntService,GuilvRemoveConditionService conditionService){
		boolean falg=GuilvRemoveConditionUtils.removeGuilv(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
		 if(falg){
	    	   removeCount(g,cocuntService, 0,conditions);
	    	    
	       }
	       
	       falg=GuilvRemoveConditionUtils.removeGuilv2(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   removeCount(g,cocuntService, 1,conditions);
	    	    
	       }
	       falg=GuilvRemoveConditionUtils.removeGuilv3(conditions, g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   removeCount(g,cocuntService, 2,conditions);
	    	    
	       }
	       condition(conditions, g);
	}
	
	private static void removeCount(GuilvPeer6Old g,GuilvRemoveCountService countService,int remove,GuilvRemoveCondition	conditions){
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
		   var[4]=10; 
		
		  GuilvRemoveCount count=countService.findGuilvs(objects, var);
		 if(count==null){
			 count=new GuilvRemoveCount();
			 count.setInfo(g.getInfo());
	    	    count.setNum(g.getNum());
	    	    count.setQi(g.getQi());
	    	    count.setQueryValue("【对等规】"+g.getQueryValue());
	    	    count.setStartQueryValue(g.getStartQueryValue());
	    	    count.setSum(g.getSum());
	    	    count.setTypeVaule(g.getTypeVaule());;
	    	    count.setValueNew(g.getValueNew());
	    	    count.setValueQueryNew(g.getValueQueryNew());
	    	    count.setValue(g.getValue());
	    	    count.setStartValue(g.getStartValue());
	    	    count.setType(g.getType());
	    	    count.setGui(10);
		 	    count.setRemove(remove);
		 	   count.setNumber(g.getNumber());
		 	  count.setSumMin(conditions.getSumMin());
		 	  if(remove==0){
		 		  count.setSort(g.getSum()-conditions.getSum()+1);
		 	  }
		 	   countService.saveGuilv(count); 
		 }
 
	}
	
	private static void condition(GuilvRemoveCondition condition,GuilvPeer6Old g ){
		if(g.getSum()>condition.getSum()){
			   
			   if(g.getSum()>condition.getSumMin()){
				  
				   condition.setSumMin(g.getSum());
			   }
			   
			   condition.setSumCount(condition.getSumCount()+1);  
			  
		   } 
		   if(g.getSum()>condition.getSumNew()){
			   condition.setSumNew(g.getSum());
		   }
		   
		   conditionsService.updateGuilv(condition);
	}
	
	private static int getOldLottery(int sum, int addition, int buchang, int even,int fixation,int qi, int matchType ){
		PageView<GuilvPeer6Old> pageViewGuilv = new PageView<GuilvPeer6Old>();
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
		List<GuilvPeer6Old> gs=peerOldService.findList(pageViewGuilv, filtersnewses).getResultlist();
		 
		int num=0;
		for(GuilvPeer6Old g:gs){
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
	
	/**
	 * 多结果
	 */
	private static Boolean more(int x, int query, int number) {
		 
		Integer[] nums = GuilvPeerUtils.getQueryValue(x, number);
	
		boolean flag = false;
		for (Integer i : nums) {
			if (s(query) == i) {
			
				flag = true;
				 
				break;
			}
		}

		return flag;

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


	
 
	
	
	private static int   setold(int e,int type,List<StringBuffer> sbs,List<Lottery> lotteries, int number,int co,List<StringBuffer> sbs2){
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
			
			int tempquery2 = 0; 
            String startQuTemp="";  
			for (StringBuffer sb : sbs2) {
				int s1 = Integer.valueOf(sb.toString().split(",")[0]);

				int v1 = Integer.valueOf(sb.toString().split(",")[1]);
				String ve = getQueryValue(lotteries,  s1 + j, v1);
				 
				startQuTemp = startQuTemp + ve;
				int qq1 = sum(lotteries, s1 + j, v1, null);
				 
				tempquery2 = tempquery2 + qq1;
				
			}
               
			if (more(s(temp2), tempquery2, number)) {
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
