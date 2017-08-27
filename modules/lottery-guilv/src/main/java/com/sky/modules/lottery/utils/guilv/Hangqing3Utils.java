package com.sky.modules.lottery.utils.guilv;

 

import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.TjsscLottery;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService;
 

public class Hangqing3Utils {
 
	public static void main(String[] args) {
 
		String url="http://m.500.com/info/kaijiang/tjssc/2017-02-07.shtml";
		String content = ConnectionAndDocumentUtil.attachContent(url);

	 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
	
		 
		 Elements ele1 = doc.select(".kaij-table");
		 
		 System.out.println(ele1);
	
	 for(int i=83;i>=0;i--){
		 String qi=	ele1.get(0).getElementsByTag("td").get(i*3).getElementsByTag("td").text();
			
		 qi=qi.substring(0, 8)+qi.substring(9, 11);
		long count=Long.parseLong(qi);
		 
		
		
			 String newQi2=ele1.get(0).getElementsByTag("td").get(i*3+2).getElementsByTag("td").text();
			  String[] st=newQi2.split(","); 
			  System.out.println("qi:"+qi);
			  System.out.println("newQi2:"+newQi2);
			  System.out.println("--------------------------");
	 }
			
		 
	 
		 
	}
	
	public static Long  getHangqing2(XjsscLotteryService service) {
		 Long count=0l;
		try{
			String url="http://www.xjflcp.com/";
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		 
		 Elements ele1 = doc.select(".part2");
		 //System.out.println(ele1);
		 String qi=ele1.get(0).getElementsByTag("span").text().substring(1, 11); 
		 
		 
		 
		 count=Long.parseLong(qi);
		   XjsscLottery ly= service.findReport("qi", count);
		 
		 
		 if(ly==null){
			 Elements ele2 = doc.select(".ballWrap");
			 String newQi2=ele2.get(0).getElementsByTag("span").text(); 
			  String[] st=newQi2.split(" "); 
			  
			  try {
					 int q1=Integer.valueOf(st[0].trim());
					 int q2=Integer.valueOf(st[1].trim());
					 int q3=Integer.valueOf(st[2].trim());
					 int q4=Integer.valueOf(st[3].trim());
					 int q5=Integer.valueOf(st[4].trim());
					 ly=new XjsscLottery();
					       ly.setQi(count);
					       ly.setSum(count);
					     ly.setZhi(q1+q2+q3+q4+q5);
					     ly.setNumber1(q1);
					     ly.setNumber2(q2);
					     ly.setNumber3(q3);
					     ly.setNumber4(q4);
					     ly.setNumber5(q5); 
						 
						 service.saveReport(ly);
						
				} catch (Exception e2) {
					// TODO: handle exception
				}
		 }
		 
		
			 
		 getHangqing3(service);	
		}catch (Exception e) {
			// TODO: handle exception
		}

	     
		 
		 
	
	 
		  return count;
		  
		 

		
	}
	
	
	public static Long  getHangqing3(XjsscLotteryService service) {
		 Long count=0l;
			String url="http://m.500.com/info/kaijiang/xjssc";
		try{
			
			 
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		
			 
			 Elements ele1 = doc.select(".kaij-table");
			 
				for(int i=96;i>=0;i--){
				      try{
				    	  String qi=	ele1.get(0).getElementsByTag("td").get(i*3).getElementsByTag("td").text();
							
							 qi=qi.substring(0, 8)+qi.substring(9, 11);
							
							 count=Long.parseLong(qi);
							   XjsscLottery ly= service.findReport("qi", count);
							 
							   if(ly==null){
									 String newQi2=ele1.get(0).getElementsByTag("td").get(i*3+2).getElementsByTag("td").text();
									  String[] st=newQi2.split(","); 
									  
									  try {
											 int q1=Integer.valueOf(st[0].trim());
											 int q2=Integer.valueOf(st[1].trim());
											 int q3=Integer.valueOf(st[2].trim());
											 int q4=Integer.valueOf(st[3].trim());
											 int q5=Integer.valueOf(st[4].trim());
											 ly=new XjsscLottery();
											       ly.setQi(count);
											       ly.setSum(count);
											     ly.setZhi(q1+q2+q3+q4+q5);
											     ly.setNumber1(q1);
											     ly.setNumber2(q2);
											     ly.setNumber3(q3);
											     ly.setNumber4(q4);
											     ly.setNumber5(q5); 
												 
												 service.saveReport(ly);
												
										} catch (Exception e2) {
											// TODO: handle exception
										}
								 }
				      }catch (Exception e) {
						// TODO: handle exception
					}
					
				  }
		 
		
			 
			
		}catch (Exception e) {
			 
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		
			 
			 Elements ele1 = doc.select(".kaij-table");
			 
				for(int i=96;i>=0;i--){
				      try{
				    	  String qi=ele1.get(0).getElementsByTag("td").get(i*3).getElementsByTag("td").text();
							
							 qi=qi.substring(0, 8)+qi.substring(9, 11);
							 count=Long.parseLong(qi);
							   XjsscLottery ly= service.findReport("qi", count);
							 
							   if(ly==null){
									 String newQi2=ele1.get(0).getElementsByTag("td").get(i*3+2).getElementsByTag("td").text();
									  String[] st=newQi2.split(","); 
									  
									  try {
											 int q1=Integer.valueOf(st[0].trim());
											 int q2=Integer.valueOf(st[1].trim());
											 int q3=Integer.valueOf(st[2].trim());
											 int q4=Integer.valueOf(st[3].trim());
											 int q5=Integer.valueOf(st[4].trim());
											 ly=new XjsscLottery();
											       ly.setQi(count);
											       ly.setSum(count);
											     ly.setZhi(q1+q2+q3+q4+q5);
											     ly.setNumber1(q1);
											     ly.setNumber2(q2);
											     ly.setNumber3(q3);
											     ly.setNumber4(q4);
											     ly.setNumber5(q5); 
												 
												 service.saveReport(ly);
												
										} catch (Exception e2) {
											// TODO: handle exception
										}
								 }
				      }catch (Exception e2) {
						// TODO: handle exception
					}
					
				  }
			
			
			
			
		 
		 
		 
		}

	     
		 
		 
	
	 
		  return count;
		  
		 

		
	}
	
 
	public static void getHangqing(String url,LotteryService service,Lottery lottery) {
		
		String content = ConnectionAndDocumentUtil.attachContent(url);

		Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);

		parseList(doc,service,lottery);
	}

	public static void parseList(Document doc,LotteryService service,Lottery lottery) {
		Elements ele1 = doc.select("div.conleft");
		 int sum=lottery.getSum()+1;
		 int qi=lottery.getQi()+1;
		 Lottery ly= service.findReport("sum", sum);
	 
		 if(ly==null){
			  
			  for(int i = 0; i < ele1.size(); i++){
				  
					 
					 
					Elements ele3 = ele1.get(i).select("ul li");
					for(int j = 0; j < ele3.size(); j++){
						if(StringUtils.isNotEmpty(ele3.get(j).getElementsByTag("b").text().trim())){
							System.out.println(ele3.get(j).getElementsByTag("b").text().trim());
							String s=ele3.get(j).getElementsByTag("b").text().trim();
							 
							String[] st=s.split(" ");
							 
								 int q1=Integer.valueOf(st[0]);
								 int q2=Integer.valueOf(st[1]);
								 int q3=Integer.valueOf(st[2]);
								 int q4=Integer.valueOf(st[3]);
								 int q5=Integer.valueOf(st[4]);
								 int q6=Integer.valueOf(st[5]);
								 int q7=Integer.valueOf(st[6]);
								 
								  
								  ly=new Lottery();
							       ly.setQi(qi);
							       ly.setSum(sum);
							     ly.setZhi(q1+q2+q3+q4);
							     ly.setNumber1(q1);
							     ly.setNumber2(q2);
							     ly.setNumber3(q3);
							     ly.setNumber4(q4);
							     ly.setNumber5(q5);
							     ly.setNumber6(q6);
							     ly.setNumber7(q7);
								 
								 service.saveReport(ly);
							
							
							//ly.setZhi(zhi);
						}
						
						 
					}
					
					
					 
				  } 
		 }

		 
	}

}
