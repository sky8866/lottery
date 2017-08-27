package com.sky.modules.lottery.utils.guilv;

 

import org.jsoup.nodes.Document; 
import org.jsoup.select.Elements;

import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.service.guilv.LotteryService;
 

public class HangqingUtils {
 
	public static void main(String[] args) {
		String url="http://cp.360.cn/qxc/?a=qgkj&r_a=fmyyAf";
		String content = ConnectionAndDocumentUtil.attachContent(url);

	 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
	 
		 Elements ele1 = doc.select(".mod-aside-t2");
		
		 String qi=ele1.get(0).getElementsByTag("b").text().trim();
		 Elements	el2= ele1.select(".ball-list");
		 String strings=el2.get(0).getElementsByTag("li").text().trim();
		 String[] strings2=strings.split(" "); 
	    int q1=Integer.valueOf(strings2[0]);
		 int q2=Integer.valueOf(strings2[1]);
		 int q3=Integer.valueOf(strings2[2]);
		 int q4=Integer.valueOf(strings2[3]);
		 int q5=Integer.valueOf(strings2[4]);
		 int q6=Integer.valueOf(strings2[5]);
		 int q7=Integer.valueOf(strings2[6]); 
		 
			 
	}
	
	public static int  getHangqing2(LotteryService service) {
		    int qi=0;
	      /*  try{
	   	 
			
			 
		 
			
					String url="http://baidu.lecai.com/lottery/draw/list/2/";
					String content = ConnectionAndDocumentUtil.attachContent(url);

				 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
				 
					 Elements ele1 = doc.select(".bgcolor1");
					 
					 Elements ele2 = ele1.get(0).select(".td2");
					 
					 String newQi=ele2.get(0).getElementsByTag("a").text().trim();
					 Lottery ly= service.findReport("sum", Integer.parseInt(newQi));
					 if(ly==null){
						 Lottery lottery2= service.findReport("sum", Integer.parseInt(newQi)-1);
						 Elements td3 = ele1.get(0).select(".ball_1");

						 int q1=Integer.valueOf(td3.get(0).getElementsByTag("span").text().trim());
						 int q2=Integer.valueOf(td3.get(1).getElementsByTag("span").text().trim());
						 int q3=Integer.valueOf(td3.get(2).getElementsByTag("span").text().trim());
						 int q4=Integer.valueOf(td3.get(3).getElementsByTag("span").text().trim());
						 int q5=Integer.valueOf(td3.get(4).getElementsByTag("span").text().trim());
						 int q6=Integer.valueOf(td3.get(5).getElementsByTag("span").text().trim());
						 int q7=Integer.valueOf(td3.get(6).getElementsByTag("span").text().trim());
						  
						  ly=new Lottery();
					       ly.setQi(lottery2.getQi()+1);
					       ly.setSum(Integer.parseInt(newQi));
					     ly.setZhi(q1+q2+q3+q4);
					     ly.setNumber1(q1);
					     ly.setNumber2(q2);
					     ly.setNumber3(q3);
					     ly.setNumber4(q4);
					     ly.setNumber5(q5);
					     ly.setNumber6(q6);
					     ly.setNumber7(q7);
						 
						 service.saveReport(ly);
						 
						 qi=ly.getQi();	 
	 
			 }	
					 
	        }catch (Exception e) {
	        	 getHangqing(service);
			}
*/

	        getHangqing(service);
		  return qi;
		 

		
	}
	
 
	public static void getHangqing(LotteryService service) {
		
		String url="http://cp.360.cn/qxc/?a=qgkj&r_a=fmyyAf";
		String content = ConnectionAndDocumentUtil.attachContent(url);

	 Document doc = ConnectionAndDocumentUtil.parseHtmlContent(content);
	 
		 Elements ele1 = doc.select(".mod-aside-t2");
		
		 String qi=ele1.get(0).getElementsByTag("b").text().trim();
		 
		 Lottery ly= service.findReport("sum", Integer.parseInt(qi));
		 if(ly==null){
			 try{
				 
				 Lottery lottery2= service.findReport("sum", Integer.parseInt(qi)-1);
				 Elements	el2= ele1.select(".ball-list");
				 String strings=el2.get(0).getElementsByTag("li").text().trim();
				 String[] strings2=strings.split(" "); 
				 System.out.println(strings2[0]);
			    int q1=Integer.valueOf(strings2[0]);
				 int q2=Integer.valueOf(strings2[1]);
				 int q3=Integer.valueOf(strings2[2]);
				 int q4=Integer.valueOf(strings2[3]);
				 int q5=Integer.valueOf(strings2[4]);
				 int q6=Integer.valueOf(strings2[5]);
				 int q7=Integer.valueOf(strings2[6]);
				 ly=new Lottery();
			       ly.setQi(lottery2.getQi()+1);
			       ly.setSum(Integer.parseInt(qi));
			     ly.setZhi(q1+q2+q3+q4);
			     ly.setNumber1(q1);
			     ly.setNumber2(q2);
			     ly.setNumber3(q3);
			     ly.setNumber4(q4);
			     ly.setNumber5(q5);
			     ly.setNumber6(q6);
			     ly.setNumber7(q7);
				 
				 service.saveReport(ly);
				 
			 }catch (Exception e) {
				 
			}
			
		 }
	 
	}

	 
}
