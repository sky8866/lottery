package com.sky.apps.action.lottery.web.utils.guilv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

  
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvLimit;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvAllRight;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorLottery;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService; 
import com.sky.modules.lottery.service.guilv.LotteryService;
 


public class GuilvAllRightUtils {
	 
	
	public  static void setQuery(
			int even,
			int qi,
			 int type, 
			 LotteryService lotteryService,GuilvAllRightService guilvService,List<GuilvAllRight> sbr,boolean isvip){
 
		 
		PageView<Lottery> pageView = new PageView<Lottery>(qi-1,1);
		pageView.setOrderby("id", "asc");

		pageView.setQueryResult(lotteryService.findList(pageView, null));
        
		List<Lottery> lotteries = pageView.getRecords();
		ComparatorLottery l = new ComparatorLottery();

		Collections.sort(lotteries, l);
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

 
     
		  
	 
		 
		 
		PageView<GuilvAllRight> pageViewGuilv = new PageView<GuilvAllRight>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("even", MatchType.EQ, even));  
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type)); 
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi)); 
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvAllRight> guilvs = pageViewGuilv.getRecords();
		
		if (guilvs.isEmpty()) {
			
			
		    
		    List<StringBuffer> sbs=null;
		   
		    		if(type==0){
		    			sbs	=GuilvLimit2Utils.getSumValue1();
		    		}else if(type==1){
		    			sbs	=GuilvLimit2Utils.getSumValue2();
		    		}else if(type==2){
		    			sbs	=GuilvLimit2Utils.getSumValue3();
		    		}else if(type==3){
		    			sbs	=GuilvLimit2Utils.getSumValue4();
		    		}
		    		
		     
		    	
		    		
		    		
		      for(StringBuffer sb:sbs){
                
                
		    	sb.deleteCharAt(sb.length()-1);
				 String[] s=sb.toString().split(",");
					List<String> values=getValues(lotteries, s);	
					for(String v:values){
						 boolean flag=false;
						 
						 int count=0;
				  
						 
				 	 C: for (int j = 1; lotteries.size()-12 > j; j++) {
				 		count++;	
				 		 flag=false;
				 		          if(type==0){
				 		        	  query= lotteries.get(j-1).getNumber1();
				 		        	  
				 		          }else if(type==1){
				 		        	 query= lotteries.get(j-1).getNumber2();
				 		          }else if(type==2){
					 		        	 query= lotteries.get(j-1).getNumber3();
					 		          }else if(type==3){
						 		        	 query= lotteries.get(j-1).getNumber4();
					 		          }
				 		      
				 		          
				 		          if(v.contains(query+"")){
				 		        	 flag=true;
				 		        	 continue ;
				 		          }
				 		      
				 		    
								 for(String sg:s){
									 String[] n=sg.split(":");
										int num= getNum(lotteries, Integer.valueOf(n[0])+j, Integer.valueOf(n[1]));  
									
										 if(v.contains(num+"")){
						 		        	 flag=true;
						 		          }
									 
									
										
								 }
								 
									if(!flag){
										break C;
									}
								 
									

							} 
						 boolean f=false;
						 if(even==0){
							 f=flag;
						 }else if(even==500){
							 if(count>=500){
								 f=true;
							 }
						 }else if(even==1000){
							 if(count>=1000){
								 f=true;
							 }
						 }else if(even==1500){
							 if(count>=1500){
								 f=true;
							 }
						 }


						 	if(f){
										String queryString="";
										for(String sg:s){
											 String[] n=sg.split(":");
											 queryString=queryString+getQueryValue(lotteries, Integer.valueOf(n[0]), Integer.valueOf(n[1]));
										}
										
										String valueString=v;
										String typeValue="";
										 
										if(type==0){
											if(flag==true){
												typeValue="线上有数，全程没错过，本期的头为：";
											}else{
												typeValue="线上有数，全程已经跑了"+count+"次，本期的头为：";	
											}
											
										}else if(type==1){
											
											if(flag==true){
												typeValue="线上有数，全程没错过，本期的百位为：";
											}else{
												typeValue="线上有数，全程已经跑了"+count+"次，本期的百位为：";	
											}
											
										}else if(type==2){
											
											if(flag==true){
												typeValue="线上有数，全程没错过，本期的十位为：";
											}else{
												typeValue="线上有数，全程已经跑了"+count+"次，本期的十位为：";	
											}
											
										}
										else if(type==3){

											if(flag==true){
												typeValue="线上有数，全程没错过，本期的尾为：";
											}else{
												typeValue="线上有数，全程已经跑了"+count+"次， 本期的尾为：";	
											}
											
										}
										GuilvAllRight vo = new GuilvAllRight();
										 
										vo.setQi(qi);
										vo.setType(type);
										 vo.setSum(count+12);
										vo.setQueryValue(queryString.substring(0, queryString.length()-1));
									    vo.setValue(valueString);
									     vo.setValueNew(sb.toString());
									     vo.setTypeVaule(typeValue);
					                    vo.setGui(5);
					                    vo.setEven(even);
									  
										 guilvService.saveGuilv(vo); 
										sbr.add(vo);		
									}
				 
						
					}
				 

				 
		    }
			
			
		} else {
			for (GuilvAllRight g : guilvs) {
				 
				sbr.add(g);
			}

		}

		ComparatorGuilvAllRight guilv = new ComparatorGuilvAllRight();

		Collections.sort(sbr, guilv);

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
	
	
	private static List<String> getValues(List<Lottery> lotteries,String[] s){
		 List<Integer> sum=new ArrayList<Integer>();
		 sum.add(0); sum.add(1); sum.add(2); sum.add(3); sum.add(4); sum.add(5); sum.add(6); sum.add(7);
		 sum.add(8); sum.add(9); 
		 List<Integer> sum1=new ArrayList<Integer>();
		 for(String sg:s){
			 String[] n=sg.split(":");
			int num= getNum(lotteries, Integer.valueOf(n[0]), Integer.valueOf(n[1])); 
			sum1.add(num);
		 }
		 
		 
	      int count=10;
				 for(Integer j:sum1){
					 for(int i=0;i<count;i++){
						 if(sum.get(i)==j){
							 sum.remove(i);
							 count--;
						 }
					 }
		    	 }
				 
			List<String> values=new ArrayList<String>();
			// values.add("012567"); 
 			  
			   
			  
			
			  
			 
			      boolean flag=true;
		 
				 for(Integer j:sum1){
					  
					 if("012567".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("012567"); 
				 }
				 for(Integer j:sum1){
					  
					 if("123678".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("123678");
				 }
			 
				 for(Integer j:sum1){
					  
					 if("234789".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					  values.add("234789");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("345890".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("345890");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("456901".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("456901");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("147692".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					  values.add("147692");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("025873".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("025873"); 
				 }
				 
				 for(Integer j:sum1){
					  
					 if("369814".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("369814");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("01234".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("01234");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("56789".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("56789"); 
				 }
				 
				 for(Integer j:sum1){
					  
					 if("12345".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					  values.add("12345");
				 }
				 for(Integer j:sum1){
					  
					 if("23456".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("23456"); 
				 }
				 
				 for(Integer j:sum1){
					  
					 if("34567".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("34567");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("45678".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("45678");  
				 }
				 
				 for(Integer j:sum1){
					  
					 if("012345".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("012345");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("567890".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("567890"); 
				 }
				 
				 
				 for(Integer j:sum1){
					  
					 if("123456".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("123456");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("234567".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("234567"); 
				 }
				 
				 for(Integer j:sum1){
					  
					 if("345678".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("345678");
				 }
				 
				 for(Integer j:sum1){
					  
					 if("456789".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("456789"); 
				 }
				 
				 for(Integer j:sum1){
					  
					 if("13579".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("13579"); 
				 }
				 for(Integer j:sum1){
					  
					 if("02468".contains(j+"")){
						 flag=false;
						 break;
					 } 
				 }
				 if(flag){
					 values.add("02468"); 
				 }
			  String value="";
			  for(Integer i:sum){
				 value=value+i; 
			  }
			  if(StringUtils.isNotEmpty(value)){
			 
				  values.add(value);
			  }
	    
		return values;
	}
	
	
	private static int getNum(List<Lottery> lotteries, int j, int type) {
	 

		Integer[] l = { lotteries.get(j).getNumber1(),
				lotteries.get(j).getNumber2(), lotteries.get(j).getNumber3(),
				lotteries.get(j).getNumber4(), lotteries.get(j).getNumber5(),
				lotteries.get(j).getNumber6(), lotteries.get(j).getNumber7() };
	 int num = l[type];
		 
			 
		 

		return num;
	} 
 
	
	 
 

}
