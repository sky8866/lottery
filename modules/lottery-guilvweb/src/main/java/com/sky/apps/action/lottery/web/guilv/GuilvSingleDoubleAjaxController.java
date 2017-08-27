package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.sky.apps.action.lottery.web.utils.guilv.LotteryGuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils; 
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilvSingleDouble;
import com.sky.apps.action.lottery.web.vo.guilv.GuilvVo;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.GuilvOld; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDouble;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvOLdService;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService; 
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

@Controller
@RequestMapping(value = "/system/ajax/guilv/singleDouble")
public class GuilvSingleDoubleAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private LotteryService lotteryService;

	@Autowired
	private GuilvSingleDoubleService guilvService;
	@Autowired
	private GuilvSingleDoubleOLdService guilvOldService;
	
	@Autowired GuilvRemoveCountService guilvRemoveCountService;
	@Autowired private MemberManager memberManager;
	@Autowired GuilvRemoveConditionService  conditionsService;
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

 
	
	@RequestMapping(value = "detail")
	public String detail(Long id,
		        
			HttpServletRequest request) {
		
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<Lottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		
		GuilvSingleDoubleOld guilv=this.guilvOldService.findGuilv(id);
 
		
		
		String s=guilv.getValueNew().replaceAll("\\[","").replaceAll("\\]","");
	 
		String[] strs=s.split(",");
		int count = 0;
 
		List<GuilvVo> vos=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos2=new ArrayList<GuilvVo>();
		
		for(int i=0;i<strs.length;i=i+2){
			getVos(strs,i,ls,0, vos);
	        
			 getVos(strs,i,ls,guilv.getSum(), vos2);
			 count=Integer.valueOf(strs[i].trim());
		}
		
		count=count+guilv.getSum();
		 
		for(Lottery l: pageView.getRecords()){
			
			getValue( vos,l,1);
			getValue( vos2,l,2);
		}
		
	    
		 
		
		Lottery lottery=this.lotteryService.findReport("qi", guilv.getQi()-guilv.getSum());
		 
		List<Lottery> lsList = new ArrayList<Lottery>();
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList);
		
	
		request.setAttribute("lsVaule", guilv.getStartQueryValue()); 
        
		request.setAttribute("guilv", guilv); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "detail";
	}
	
	
	@RequestMapping(value = "detail2")
	public String detail2(Long id,
		        
			HttpServletRequest request) {
		
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<Lottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		
		GuilvSingleDouble guilv=this.guilvService.findGuilv(id);
 
		
		
		String s=guilv.getValueNew().replaceAll("\\[","").replaceAll("\\]","");
	 
		String[] strs=s.split(",");
		int count = 0;
 
		List<GuilvVo> vos=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos2=new ArrayList<GuilvVo>();
		
		for(int i=0;i<strs.length;i=i+2){
			getVos(strs,i,ls,0, vos);
	        
			 getVos(strs,i,ls,guilv.getSum(), vos2);
			 count=Integer.valueOf(strs[i].trim());
		}
		
		count=count+guilv.getSum();
		 
		for(Lottery l: pageView.getRecords()){
			
			getValue( vos,l,1);
			getValue( vos2,l,2);
		}
		
	    
		 
		
		Lottery lottery=this.lotteryService.findReport("qi", guilv.getQi()-guilv.getSum());
		 
		List<Lottery> lsList = new ArrayList<Lottery>();
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList);
		
	
		request.setAttribute("lsVaule", guilv.getStartQueryValue()); 
        
		request.setAttribute("guilv", guilv); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "detail";
	}

	private void getVos(String[]strs,int i,List<Lottery> ls,int sum,List<GuilvVo> vos){
		int s1 = Integer.valueOf(strs[i].trim())+sum;

		int v1 = Integer.valueOf(strs[i+1].trim()); 
		GuilvVo vo=new GuilvVo();
		vo.setQi(ls.get(s1-1).getQi());
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
	
	private void getValue(List<GuilvVo> vos,Lottery l,int key){
		for(GuilvVo g:vos){
			if(l.getQi()==g.getQi()){
				 
				  if(g.getValue()==0){
					  l.setV1(10);
					  
				  }else if(g.getValue()==1){
					  l.setV2(10);
					  
				  }else if(g.getValue()==2){
					  l.setV3(10);
					 
				  }else if(g.getValue()==3){
					  l.setV4(10);
					 
				  }else if(g.getValue()==4){
					  l.setV5(10);
					 
				  }else if(g.getValue()==5){
					  l.setV6(10);
					  
				  }else if(g.getValue()==6){
					  l.setV7(10);
				  }
				 
				 l.setKey(key);
			}
		}
	}
	

	@RequestMapping(value = "query")
	public String query(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "3") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "5") int number,
			String openId,
			HttpServletRequest request) {
		
		 
		

		List<GuilvSingleDouble> sbr = new ArrayList<GuilvSingleDouble>();
		
		User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
		
		Lottery l=this.lotteryService.findLottery();
		
	
		 
		PageView<GuilvSingleDouble> pageViewGuilv = new PageView<GuilvSingleDouble>(10,1);
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses
				.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses.add(new PropertyFilter("buchang", MatchType.EQ, buchang));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
		if(fixation==10){
			filtersnewses
			.add(new PropertyFilter("fixation", MatchType.GE, 0));	
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
			if(number==1){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 4));
			}else if(number==0){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 8));
			}else if(number==2){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 8));
			}else if(number==3){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 10));
			}else if(number==4){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 14));
			}else if(number==5){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 16));
			}else if(number==6){
				filtersnewses
				.add(new PropertyFilter("sum", MatchType.LT, 24));
			}
			
			
		}
		
		
		
		
		
		 
		filtersnewses.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, l.getQi()+1));
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, 7));
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<GuilvSingleDouble> guilvs = pageViewGuilv.getRecords();
		
		 try{
			 if(guilvs.isEmpty()&&StringUtils.isNotEmpty(this.memberManager.getLoninName())&&"13800000000".equals(this.memberManager.getLoninName())){
			  guilvs = new ArrayList<GuilvSingleDouble>();
				 LotteryGuilvSingleDoubleUtils.setQuery(addition, buchang, type, even, 0, matchType, 5, lotteryService, guilvService, guilvs,isvip,guilvOldService,guilvRemoveCountService,conditionsService);
		}
		 }catch (Exception e) {
				// TODO: handle exception
			}
		ComparatorGuilvSingleDouble guilv = new ComparatorGuilvSingleDouble();

		Collections.sort(guilvs, guilv);
		
		
		request.setAttribute("sbr", guilvs);
		request.setAttribute("sumVaule", LotteryGuilvSingleDoubleUtils.getVaule(guilvs, type));
		
		return BASE_PATH + "querySingleDouble";
	}
 
	 


}
