package com.sky.apps.action.lottery.web.guilv;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.entity.guilv.Invest; 
import com.sky.modules.lottery.entity.guilv.InvestSum;
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
import com.sky.modules.lottery.utils.user.LogController;

 


@Controller
public class InvestController  {
	
	
	private final static String BASE_PATH = "guilv/"; 
	@Autowired private GuilvInvestService investService;
	@Autowired private GuilvInvestSumService investSumService;
	@Autowired private GuilvSumService guilvSumService;
	
	@RequestMapping(value = "/system/investSum")
	public String web_error3(HttpServletRequest request,HttpServletResponse response) {
 
		PageView<InvestSum> pageView = new PageView<InvestSum>();
			
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			filtersnewses
					.add(new PropertyFilter("type", MatchType.NE,2));
			
			filtersnewses
			.add(new PropertyFilter("visible", MatchType.EQ,1));
			pageView.setQueryResult(investSumService.findList(pageView, filtersnewses));
			List<InvestSum> lotteries = pageView.getRecords();
			  Double sum1=0d;
			  Double sum2=0d;
			  Double sum3=0d;
  			 for(InvestSum i:lotteries){
  				 sum1=sum1+i.getSumMoney();
  				 sum2=sum2+i.getMoney1();
  				 sum3=sum3+i.getMoney2();
  			 }
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("sum1", sum1);
 			request.setAttribute("sum2", sum2);
 			request.setAttribute("sum3", sum3);
		return BASE_PATH + "invest2";
	}
	
	
	@RequestMapping(value = "/system/invest2")
	public String web_error2(HttpServletRequest request,HttpServletResponse response) {
 
		  InvestSum sum=this.investSumService.findInvestSum("type", 2);
		  
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 2));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
  			 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	@RequestMapping(value = "/system/invest3")
	public String web3(HttpServletRequest request,HttpServletResponse response) {
 
		InvestSum sum=this.investSumService.findInvestSum("type", 3);
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 3));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
 
	
	@RequestMapping(value = "/system/invest5")
	public String web5(HttpServletRequest request,HttpServletResponse response) {
 
		InvestSum sum=this.investSumService.findInvestSum("type", 4);
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 4));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	@RequestMapping(value = "/system/invest6")
	public String web6(HttpServletRequest request,HttpServletResponse response) {
 
		InvestSum sum=this.investSumService.findInvestSum("type", 5);
	 
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 5));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/invest7")
	public String web7(HttpServletRequest request,HttpServletResponse response) {
 
		InvestSum sum=this.investSumService.findInvestSum("type", 6);
 
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 6));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/invest8")
	public String web8(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 7);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 7));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	@RequestMapping(value = "/system/invest9")
	public String web9(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 8);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 8));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/invest10")
	public String web10(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 9);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 9));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	
	@RequestMapping(value = "/system/Xinvest11")
	public String web11(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 12);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 12));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/Xinvest13")
	public String web13(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 13);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 13));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/Xinvest15")
	public String web15(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 14);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 14));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/Xinvest16")
	public String web16(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 15);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 15));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	@RequestMapping(value = "/system/Xinvest17")
	public String web17(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 16);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 16));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	
	@RequestMapping(value = "/system/Xinvest18")
	public String web18(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 17);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 17));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	

	@RequestMapping(value = "/system/x_invests")
	public String web19(HttpServletRequest request,HttpServletResponse response) {
 
	   	   InvestSum sum=this.investSumService.findInvestSum("type", 18);
         
	    
 			PageView<Invest> pageView = new PageView<Invest>(20,1);
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 18));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 		 
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	@RequestMapping(value = "/system/invest")
	public String web_error(HttpServletRequest request,HttpServletResponse response) {
/* PageView<GuilvSum> pageView1 = new PageView<GuilvSum>(1,1);
			pageView1.setOrderby("id", "desc");

			pageView1.setQueryResult(guilvSumService.findList(pageView1, null));
			List<GuilvSum> lotteries1 = pageView1.getRecords();
		     int c1=0;
		     int c2=0;
		     int c3=0;
			for(GuilvSum sum:lotteries1){
				Invest invest=new Invest();
			    invest.setInfo5(sum.getInfo5().replaceAll(":", "："));
			    invest.setInfo1(sum.getInfo1().replaceAll(":", "："));
			    invest.setVaule(sum.getVaule());
			    invest.setMoney(20000d);
			      
			    invest.setSumMoney(17944d);
			    
			    invest.setSum(1);
			    invest.setPrize1(0);
			    invest.setPrize2(0);
			    
			    invest.setMoney1(1800d);
			    invest.setMoney2(256d);
			  
			    invest.setQi(sum.getQi());
			    invest.setType(17);
			    this.investService.saveInvest(invest);
			}
			  InvestSum sum1=new InvestSum();
			  sum1.setMoney(20000d);
		      
			  sum1.setSumMoney(17944d);
			    
			  sum1.setSum(1);
			  sum1.setPrize1(0);
			  sum1.setPrize2(0);
			    
			  sum1.setMoney1(1800d);
			  sum1.setMoney2(256d);
			   
			  sum1.setType(17);
			  
		
	 this.investSumService.saveInvestSum(sum1);*/
	 
	 
 
		
 
		
		  InvestSum sum=this.investSumService.findInvestSum("type", 1);
		  
		
	    
	    
 			PageView<Invest> pageView = new PageView<Invest>();
 			pageView.setOrderby("id", "desc");
 			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
 			filtersnewses
 					.add(new PropertyFilter("type", MatchType.EQ, 1));
 			pageView.setQueryResult(investService.findList(pageView, filtersnewses));
 			List<Invest> lotteries = pageView.getRecords();
 /*		      for(Invest i:lotteries){
 		    	 PageView<Invest> pageView1 = new PageView<Invest>();
 		    	List<PropertyFilter> filtersnewses1 = new ArrayList<PropertyFilter>();
 	 			filtersnewses1
 	 					.add(new PropertyFilter("type", MatchType.EQ, 7));
 		    	filtersnewses1
					.add(new PropertyFilter("qi", MatchType.EQ, i.getQi()-1));
 		    	pageView1.setQueryResult(investService.findList(pageView1, filtersnewses1));
 	 			List<Invest> lotteries1 = pageView1.getRecords();
 	 			Invest invest=null;
 	 			System.out.println(lotteries1.size());
 	 			if(!lotteries1.isEmpty()){
 	 			  invest=lotteries1.get(0);
 	 			}
 	 			
 		    	if(invest!=null){
 		    		System.out.println(invest.getSumMoney());
 		    		double s=invest.getSumMoney()-i.getMoney1()-i.getMoney2();
 		    		System.out.println("weeewww:"+s);
 		    		  java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
 		    		 s=Double.valueOf(df.format(s));
 		    		 
 		    		 if(i.getP1()==1){
 		    		     double m1=i.getMoney1()/36;
 		    		     s=s+(m1*95);
 		    		     System.out.println("二定："+s);
 		    		 }
 		    		 
 		    		 if(i.getP2()==1){
 		    			 double m1=i.getMoney2()/256;
 		    		     s=s+(m1*9000);
 		    		 }
 		    		 
 		    		 i.setSumMoney(s);
 		    		 this.investService.updateInvest(i);
 		    		 
 		    	}
 		      }*/
 			request.setAttribute("invests", lotteries);
 			request.setAttribute("invest", sum);
		return BASE_PATH + "invest";
	}
	
	
	
	
	
	
	
 

}
