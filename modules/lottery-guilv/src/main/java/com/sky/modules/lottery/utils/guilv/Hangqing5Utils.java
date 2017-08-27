package com.sky.modules.lottery.utils.guilv;

 

import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.guilv.LotteryService;
 

public class Hangqing5Utils {
 
	public static void main(String[] args) {
	 
		
 
		String url="http://m.500.com/info/kaijiang/qxc/";
		String content = ConnectionAndDocumentUtil.attachContent(url);

	 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
	
		 Elements ele1 = doc.select(".kaij-list1-tit"); 
		 
		 System.out.println(ele1.get(1).text().substring(2, 7));
	
		 
	}
	
	public static Long  getHangqing2(Pl5LotteryService service) {
		 
		 Long count=0l;
		try{
			String url="http://cp.360.cn/p5/?sb_spm=b53a5729f3ee8289db01b05d610846c6";
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		
		 Elements ele1 = doc.select(".mod-aside-t2");
		 String qi=	ele1.get(0).getElementsByTag("h3").get(0).getElementsByTag("b").text();
				 
				 count=Long.parseLong(qi);
				   Pl5Lottery ly= service.findReport("qi", count);
				 
				 
				 if(ly==null){
				 
					 String newQi2=ele1.get(0).getElementsByTag("li").text();
					 
					  
					  try {
							 int q1=Integer.valueOf(newQi2.substring(0, 1).trim());
							 int q2=Integer.valueOf(newQi2.substring(2, 3).trim());
							 int q3=Integer.valueOf(newQi2.substring(4, 5).trim());
							 int q4=Integer.valueOf(newQi2.substring(6, 7).trim());
							 int q5=Integer.valueOf(newQi2.substring(8, 9).trim());
							 ly=new Pl5Lottery();
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

	     
		 
		 
	
	 
		  return count;
		  
		 

		
	}
	
	
	
	public static void  getHangqing3(Pl5LotteryService service) {
		 Long count=0l;
		try{
			String url="http://baidu.lecai.com/lottery/draw/list/4";
			String content = ConnectionAndDocumentUtil.attachContent(url);

		 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
		
			 
			 Elements ele1 = doc.select("#draw_list");
			 
			 System.out.println(ele1);
			
		 for(int i=83;i>=0;i--){
			 String qi=	ele1.get(0).select(".td2").get(i).getElementsByTag("td").text();

			 count=Long.parseLong("20"+qi);
			   Pl5Lottery ly= service.findReport("qi", count);
			 
			 
			 if(ly==null){
			 
				 String newQi2=ele1.get(0).select(".td3").get(i).getElementsByTag("td").text();
				 String[] st=newQi2.split(" "); 
				 
				  
				  try {
					      int q1=Integer.valueOf(st[0].trim());
						 int q2=Integer.valueOf(st[1].trim());
						 int q3=Integer.valueOf(st[2].trim());
						 int q4=Integer.valueOf(st[3].trim());
						 int q5=Integer.valueOf(st[4].trim());
						 ly=new Pl5Lottery();
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
			 
			 
			 
				 
			 
			
		 }
		}catch (Exception e) {
			// TODO: handle exception
		}
			
		 
		 
		 
		
		 
		
			 
			
		 
	      
		  
		 

		
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
