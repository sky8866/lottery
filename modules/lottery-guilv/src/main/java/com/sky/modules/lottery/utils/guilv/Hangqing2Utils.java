package com.sky.modules.lottery.utils.guilv;

 

import java.util.Date;

import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.TjsscLottery;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.TjsscLotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService;
 

public class Hangqing2Utils {
 
	public static void main(String[] args) {
		String url="http://kaijiang.aicai.com/cqssc/";
		String content = ConnectionAndDocumentUtil.attachContent(url);
System.out.println(UtilDate.getTaskNowTime());
/*	 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
	
		 
		 Elements ele1 = doc.select("#jq_body_kc_result");
		String qiString=ele1.get(0).getElementsByTag("td").get(0).text().replaceAll("-", "").replaceAll("期", "");
		int newqi=Integer.parseInt(qiString.substring(4, qiString.length()));
		System.out.println(newqi);
		 String newQi2=ele1.get(0).getElementsByTag("td").get(2).text();
		 System.out.println(newQi2.trim());
		 newQi2.substring(0, 1);
		 newQi2.substring(2, 3);
		 newQi2.substring(4, 5);
		 newQi2.substring(6, 7);
		
	 
	 for(int i=119;i>=0;i--){
		 try{
			 String qi=	ele1.get(0).getElementsByTag("td").get(i*3).getElementsByTag("td").text();
				
			 qi=qi.substring(4, 11);
			long count=Long.parseLong(qi);
				 
		 }catch (Exception e) {
			// TODO: handle exception
		}
	
	 }*/
		
		 
	}
	
	public static int  getHangqing2(CqsscLotteryService service) {
		  int count=0;
		try{
			String url="http://cp.360.cn/ssccq/?menu&r_a=QbyAJj";
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		 
			 Elements ele1 = doc.select(".mod-aside-xssckj");
			 
			  for(int j = 0; j < ele1.size(); j++){
				  Elements ele3 = ele1.get(j).select("#open_issue"); 
				  
				  
				  String newQi2=ele3.get(j).getElementsByTag("em").text().trim(); 
				   int newqi=Integer.parseInt(newQi2);
				   CqsscLottery ly= service.findReport("qi", newqi);
				   count=newqi;
				  if(ly==null){
				 Elements ele2 = ele1.get(j).select("#open_code_list"); 
		  
			     
			         
				 for(int e=0;e<ele2.size();e++){
					 String newQi=ele2.get(e).getElementsByTag("li").text().trim(); 
					 String[] st=newQi.split(" ");
					 try {
						 int q1=Integer.valueOf(st[0]);
						 int q2=Integer.valueOf(st[1]);
						 int q3=Integer.valueOf(st[2]);
						 int q4=Integer.valueOf(st[3]);
						 int q5=Integer.valueOf(st[4]);
						 ly=new CqsscLottery();
						       ly.setQi(newqi);
						       ly.setSum(newqi);
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
				
			 } 
		 
		 }
			
			
		
		 
			 
		}catch (Exception ww) {
			
			String url="http://kaijiang.aicai.com/cqssc/";
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		
			 
			 Elements ele1 = doc.select("#jq_body_kc_result");
			String qiString=ele1.get(0).getElementsByTag("td").get(0).text().replaceAll("-", "").replaceAll("期", "");
			int newqi=Integer.parseInt(qiString.substring(4, qiString.length()));
			CqsscLottery ly= service.findReport("qi", newqi); 
			if(ly==null){
				String newQi2=ele1.get(0).getElementsByTag("td").get(2).text();
				  
				 int q1=Integer.valueOf(newQi2.substring(0, 1));
				 int q2=Integer.valueOf(newQi2.substring(2, 3));
				 int q3=Integer.valueOf(newQi2.substring(4, 5));
				 int q4=Integer.valueOf(newQi2.substring(6, 7));
				 int q5=Integer.valueOf(newQi2.substring(8, 9));
				 ly=new CqsscLottery();
				       ly.setQi(newqi);
				       ly.setSum(newqi);
				     ly.setZhi(q1+q2+q3+q4+q5);
				     ly.setNumber1(q1);
				     ly.setNumber2(q2);
				     ly.setNumber3(q3);
				     ly.setNumber4(q4);
				     ly.setNumber5(q5); 
					 
					 service.saveReport(ly);
			}
			 
			 
		 
		}
		
	     
		 
		 getHangqing3( service); 
	
	 
		  return count;
		  
		 

		
	}
	
	
	
	
	public static int  getHangqing3(CqsscLotteryService service) {
		 int count=0;
	//	 String dateString=UtilDate.getDateFormatter(new Date(),"yyyy-MM-dd");
		 
			String url="http://m.500.com/info/kaijiang/ssc/";
			int time=UtilDate.getTaskNowTime(); 
			  if(14==time){
				  Date date=UtilDate.getOldDate(1, new Date());
					 String dateString=UtilDate.getDateFormatter(date,"yyyy-MM-dd");	
					   url="http://m.500.com/info/kaijiang/ssc/"+dateString+".shtml";  
			  }
				
			 
		
		try{
			
		
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		
			 
			 Elements ele1 = doc.select(".kaij-table");
			 
			 
		
		for(int i=119;i>=0;i--){
		      try{
		    	  String qi=	ele1.get(0).getElementsByTag("td").get(i*3).getElementsByTag("td").text();
					
					 qi=qi.substring(4, 11);;
					 count=Integer.parseInt(qi);
					   CqsscLottery ly= service.findReport("qi", count);
					    
					   if(ly==null){
							 String newQi2=ele1.get(0).getElementsByTag("td").get(i*3+2).getElementsByTag("td").text();
							  String[] st=newQi2.split(","); 
							  
							  try {
									 int q1=Integer.valueOf(st[0].trim());
									 int q2=Integer.valueOf(st[1].trim());
									 int q3=Integer.valueOf(st[2].trim());
									 int q4=Integer.valueOf(st[3].trim());
									 int q5=Integer.valueOf(st[4].trim());
									 ly=new CqsscLottery();
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
			 
			// System.out.println(ele1);
		
				for(int i=119;i>=0;i--){
				      try{
				    	  String qi=	ele1.get(0).getElementsByTag("td").get(i*3).getElementsByTag("td").text();
							
							 qi=qi.substring(4, 11);;
							 count=Integer.parseInt(qi);
							   CqsscLottery ly= service.findReport("qi", count);
							   
							   if(ly==null){
									 String newQi2=ele1.get(0).getElementsByTag("td").get(i*3+2).getElementsByTag("td").text();
									  String[] st=newQi2.split(","); 
									  
									  try {
											 int q1=Integer.valueOf(st[0].trim());
											 int q2=Integer.valueOf(st[1].trim());
											 int q3=Integer.valueOf(st[2].trim());
											 int q4=Integer.valueOf(st[3].trim());
											 int q5=Integer.valueOf(st[4].trim());
											 ly=new CqsscLottery();
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
				      }catch (Exception e1) {
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
