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
 
import com.sky.apps.action.lottery.web.utils.guilv.GuilvRemoveConditionUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.SumCountUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.GuilvVo;
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.Guilv; 
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvOld; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.GuilvScopeOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDouble;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.GuilvSizeOld;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvOLdService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.GuilvPeer3Service;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService; 
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.GuilvSameOldService; 
import com.sky.modules.lottery.service.guilv.GuilvScopeOLdService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleService;
import com.sky.modules.lottery.service.guilv.GuilvSizeOLdService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

 

@Controller
@RequestMapping(value = "/system/ajax/guilv")
public class GuilvAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private LotteryService lotteryService;

	@Autowired
	private GuilvService guilvService;
	@Autowired
	private GuilvOLdService guilvOldService;
	 
	@Autowired
	private GuilvScopeOLdService guilvScopeOldService;
	
	@Autowired GuilvPeerOldService peerService;
	
	@Autowired GuilvPeer3OldService peer3Service;
	@Autowired GuilvPeer3Service gpeer3Service;
	@Autowired GuilvPeerService peerService1;
	
	@Autowired GuilvSingleDoubleService sDoubleService;
	@Autowired GuilvSingleDoubleOLdService gDoubleOLdService;
	
	@Autowired GuilvSizeOLdService sizeService;
	@Autowired private MemberManager memberManager;
	@Autowired GuilvRemoveCountService cocuntService;
	@Autowired GuilvAllRightService allRightService;
	@Autowired private GuilvRemoveConditionService conditionService; 
	@Autowired
	private GuilvLimitService guilvLimitService;
	
	@Autowired GuilvSameOldService sameOldService;
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

 
	
	@RequestMapping(value = "detail2")
	public String detail(Long id,int  type,String typeq,
		        
			HttpServletRequest request) {
		
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<Lottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		 
	 
		String valueNew="";
		
		String valuePeerNew="";
		int sum=0;
		int qi=0;
		int co=0;
		boolean flag=true;//全显示
		if(type==1){
			GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
			
		}else if(type==2){
			GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		}else if(type==3){
			GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		}else if(type==4){
			GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		}else if(type==5){
			GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			request.setAttribute("type", "此规为杀数！");
		}else if(type==6){
			GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		} 
		
 
		
		
		String s=valueNew.replaceAll("\\[","").replaceAll("\\]","");
		
		String[] strs=s.split(",");
		String[] peerValues=null;
		if(StringUtils.isNotEmpty(valuePeerNew)){
			String peerValue=valuePeerNew.replaceAll("\\[","").replaceAll("\\]","");
			 peerValues=peerValue.split(",");
		}
		
		int count = 0;
 
		List<GuilvVo> vos=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos2=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos3=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos4=new ArrayList<GuilvVo>();
		List<GuilvVo> vos5=new ArrayList<GuilvVo>();
		if(co==0){
			
			for(int i=0;i<strs.length;i=i+2){ 
					 getVos(strs,i,ls,0, vos,0); 
					 getVos(strs,i,ls,sum, vos2,0);
					 count=Integer.valueOf(strs[i].trim());	 
			}	
		}else{
			for(String ss:strs ){ 
				String[] st=ss.split(":");
				 getVos2(st,0,ls,0, vos); 
			}
		 
		}
		

		 if(peerValues!=null){
			 for(int i=0;i<peerValues.length;i=i+2){
				 getVos(peerValues,i,ls,0, vos3,4);
			 
				 getVos(peerValues,i,ls,sum, vos4,4);
				  
			} 
		 }
		if(co==0){
			count=count+sum;
		}else{
			count=co;
		}
        
		if(flag){
			for(int i=0;i<=count;i++){
				for(GuilvVo vo:vos){
				   GuilvVo v=new GuilvVo();
				   v.setQi(vo.getQi()-i);
				   v.setValue(vo.getValue());
				   v.setKey(5);
					 
					vos5.add(v);
				}
			}	
		}

 
	 
		
		for(int i=0;i<=count;i++){
			Lottery l=pageView.getRecords().get(i);
			
			if(co==0){
				getValue( vos,l,1);
				getValue2( vos2,l,2);
				if(flag){
					getValue( vos5,l,1);
				}
			}else{
				getValue3( vos5,l,5);
			}
			
			if(StringUtils.isNotEmpty(valuePeerNew)){
				getValue3( vos3,l,3);
				getValue4( vos4,l,4);
			}
			
		}
		
	  
		Lottery lottery=this.lotteryService.findReport("qi", qi-sum);
		 
		List<Lottery> lsList = new ArrayList<Lottery>();
	 
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "detail";
	}
	
	
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

 
	
	@RequestMapping(value = "detail")
	public String detail2(Long id,int  type,String typeq,
		        
			HttpServletRequest request) {
		
		PageView<Lottery> pageView = new PageView<Lottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<Lottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		 
	 
		String valueNew="";
		
		String valuePeerNew="";
		int sum=0;
		int qi=0;
		int co=0;
		boolean flag=true;//全显示
		if(type==1){
			GuilvOld g=this.guilvOldService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
			
		}else if(type==2){
			GuilvScopeOld g=this.guilvScopeOldService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		}else if(type==3){
			GuilvSingleDoubleOld g=this.gDoubleOLdService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		}else if(type==4){
			GuilvPeerOld g=this.peerService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "此规为杀数！");
			}
		}else if(type==5){
			GuilvPeer3Old g=this.peer3Service.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			request.setAttribute("type", "此规为杀数！");
		}else if(type==6){
			GuilvAllRight g=this.allRightService.findGuilv(id);
			request.setAttribute("lsVaule", g.getQueryValue()); 
			int  c=g.getSum()+1;
			request.setAttribute("type", "全程："+c+"期无错！");
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=0;
			qi=g.getQi(); 
			co=50;
		}else if(type==7){
			GuilvLimit g=this.guilvLimitService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue());  
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi(); 
			flag=false; 
			 
		}else if(type==8){
			Guilv g=this.guilvService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
		}else if(type==9){
			GuilvSingleDouble g=this.sDoubleService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
		}else if(type==10){
			GuilvPeer g=this.peerService1.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
		}else if(type==11){
			GuilvPeer3 g=this.gpeer3Service.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
		}else if(type==12){
			GuilvSizeOld g=this.sizeService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
		}
		
		
 
		
		
		String s=valueNew.replaceAll("\\[","").replaceAll("\\]","");
		
		String[] strs=s.split(",");
		String[] peerValues=null;
		if(StringUtils.isNotEmpty(valuePeerNew)){
			String peerValue=valuePeerNew.replaceAll("\\[","").replaceAll("\\]","");
			 peerValues=peerValue.split(",");
		}
		
		int count = 0;
 
		List<GuilvVo> vos=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos2=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos3=new ArrayList<GuilvVo>();
		
		List<GuilvVo> vos4=new ArrayList<GuilvVo>();
		List<GuilvVo> vos5=new ArrayList<GuilvVo>();
		if(co==0){
			
			for(int i=0;i<strs.length;i=i+2){ 
					 getVos(strs,i,ls,0, vos,0); 
					 getVos(strs,i,ls,sum, vos2,0);
					 count=Integer.valueOf(strs[i].trim());	 
			}	
		}else{
			for(String ss:strs ){ 
				String[] st=ss.split(":");
				 getVos2(st,0,ls,0, vos); 
			}
		 
		}
		

		 if(peerValues!=null){
			 for(int i=0;i<peerValues.length;i=i+2){
				 getVos(peerValues,i,ls,0, vos3,4);
			 
				 getVos(peerValues,i,ls,sum, vos4,4);
				  
			} 
		 }
		if(co==0){
			count=count+sum;
		}else{
			count=co;
		}
        
		if(flag){
			for(int i=0;i<=count;i++){
				for(GuilvVo vo:vos){
				   GuilvVo v=new GuilvVo();
				   v.setQi(vo.getQi()-i);
				   v.setValue(vo.getValue());
				   v.setKey(5);
					 
					vos5.add(v);
				}
			}	
		}

 
	 
		
		for(int i=0;i<=count;i++){
			Lottery l=pageView.getRecords().get(i);
			
			if(co==0){
				getValue( vos,l,1);
				getValue2( vos2,l,2);
				if(flag){
					getValue( vos5,l,1);
				}
			}else{
				getValue3( vos5,l,5);
			}
			
			if(StringUtils.isNotEmpty(valuePeerNew)){
				getValue3( vos3,l,3);
				getValue4( vos4,l,4);
			}
			
		}
		
	  
		Lottery lottery=this.lotteryService.findReport("qi", qi-sum);
		 
		List<Lottery> lsList = new ArrayList<Lottery>();
	 
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "detail";
	}
	

	@RequestMapping(value = "query")
	public String query(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "3") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "1") int number,
			String openId,
			HttpServletRequest request) {
/*		PageView<GuilvScopeOld> o= new PageView<GuilvScopeOld>();
 List<GuilvScopeOld> oLds=this.guilvScopeOldService.findList(o, null).getResultlist();
		 for(GuilvScopeOld s:oLds){
			 if(s.getNum()==null){
				 s.setNum(s.getSum());
				 guilvScopeOldService.updateGuilv(s);
			 }
		 }*/
		
		User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			request.setAttribute("isVip", 2);
		}
	   Lottery lottery=	this.lotteryService.findLottery();
	   
		
		 
		PageView<Guilv> pageViewGuilv = new PageView<Guilv>(10,1);
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
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, lottery.getQi()+1));
 
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				filtersnewses));
		List<Guilv> guilvs = pageViewGuilv.getRecords();
		
		 try{
			 if(guilvs.isEmpty()&&StringUtils.isNotEmpty(this.memberManager.getLoninName())&&"13800000000".equals(this.memberManager.getLoninName())){
	 
			  guilvs = new ArrayList<Guilv>();
			LotteryUtils.setQuery(addition, buchang, type, even, fixation, matchType, number, lotteryService, guilvService, guilvs,isvip,guilvOldService,cocuntService,conditionService);	
		 
			 }
			 }catch (Exception e) {
					// TODO: handle exception
				}
	 
		 
		ComparatorGuilv guilv = new ComparatorGuilv();

		Collections.sort(guilvs, guilv);
		
		request.setAttribute("sbr", guilvs);
		request.setAttribute("sumVaule", LotteryUtils.getVaule(guilvs, type));
		
		return BASE_PATH + "query";
	}

	@RequestMapping(value = "error")
	public String error(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") int qi,
			HttpServletRequest request) {
	 	 PageView<GuilvRemoveCount> pageViewGuilvRemoveCount = new PageView<GuilvRemoveCount>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses.add(new PropertyFilter("remove", MatchType.EQ, 0));
		pageViewGuilvRemoveCount.setQueryResult(cocuntService.findList(pageViewGuilvRemoveCount, filtersnewses));
  
		 
 	 

		User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			
			request.setAttribute("isVip", 2);
		}
		
		if(isvip){
			 request.setAttribute("peerList", pageViewGuilvRemoveCount.getRecords());  
		}
		
		request.setAttribute("queryqi", qi);
	
	request.setAttribute("weixinopenId", openId);
	
		return BASE_PATH +"sum_error";
	}
	
	
	@RequestMapping(value = "error2")
	public String error2(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") int qi,
			HttpServletRequest request) {
	 	/*PageView<GuilvRemoveCount> pageViewGuilvRemoveCount = new PageView<GuilvRemoveCount>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
		
		pageViewGuilvRemoveCount.setQueryResult(cocuntService.findList(pageViewGuilvRemoveCount, filtersnewses));
  
		 System.out.println(pageViewGuilvRemoveCount.getRecords());*/
		 PageView<GuilvRemoveCount> pageViewGuilvRemoveCount = new PageView<GuilvRemoveCount>();
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
			
			pageViewGuilvRemoveCount.setQueryResult(cocuntService.findList(pageViewGuilvRemoveCount, filtersnewses)); 
		

		User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			
			request.setAttribute("isVip", 2);
		}
		
		if(isvip){
			 request.setAttribute("peerList", pageViewGuilvRemoveCount.getRecords()); 
			 
		}
		
	 
	
	request.setAttribute("queryqi", qi);
	
		return BASE_PATH +"sum_error2";
	}
	
	
	
	
	@RequestMapping(value = "error_query")
	public String error_query(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") int qi,
			HttpServletRequest request) {
		
		PageView<GuilvOld> pageViewGuilv = new PageView<GuilvOld>();
		pageViewGuilv.setOrderby("sum", "desc");
		
	
		pageViewGuilv.setQueryResult(guilvOldService.findList(pageViewGuilv,
				getList(qi,type,1)));
		
		PageView<GuilvPeerOld> pageViewGuilvPeer = new PageView<GuilvPeerOld>();
		pageViewGuilvPeer.setOrderby("sum", "desc");
		pageViewGuilvPeer.setQueryResult(peerService.findList(pageViewGuilvPeer,
				getList(qi,type,3)));
		
		PageView<GuilvPeer3Old> pageViewGuilvPeer3 = new PageView<GuilvPeer3Old>();
		pageViewGuilvPeer3.setOrderby("sum", "desc");
		pageViewGuilvPeer3.setQueryResult(peer3Service.findList(pageViewGuilvPeer3,
				getList(qi,type,3)));
		
		
		
		PageView<GuilvSingleDoubleOld> pageViewGuilvSingleDoubleOld = new PageView<GuilvSingleDoubleOld>();
		pageViewGuilvSingleDoubleOld.setOrderby("sum", "desc");
		pageViewGuilvSingleDoubleOld.setQueryResult(gDoubleOLdService.findList(pageViewGuilvSingleDoubleOld,
				getList(qi,type,7)));
		List<GuilvOld> guilvs = pageViewGuilv.getRecords();
		List<GuilvOld> sbr = new ArrayList<GuilvOld>();
		List<GuilvOld> sbr1 = new ArrayList<GuilvOld>();
		List<GuilvOld> sbr2 = new ArrayList<GuilvOld>(); 
		List<GuilvOld> sbr3 = new ArrayList<GuilvOld>(); 
		List<GuilvOld> sbr4 = new ArrayList<GuilvOld>(); 
		List<GuilvOld> sbr5 = new ArrayList<GuilvOld>(); 
		
		List<GuilvPeerOld> peers=pageViewGuilvPeer.getRecords();
		
		
		
		List<GuilvPeerOld> peerList = new ArrayList<GuilvPeerOld>();
		List<GuilvPeerOld> peerList1 = new ArrayList<GuilvPeerOld>();
		List<GuilvPeerOld> peerList2 = new ArrayList<GuilvPeerOld>();
		
		
     List<GuilvPeer3Old> peers3=pageViewGuilvPeer3.getRecords();
		
		
		
		List<GuilvPeer3Old> peer3List = new ArrayList<GuilvPeer3Old>();
		List<GuilvPeer3Old> peer3List1 = new ArrayList<GuilvPeer3Old>();
		List<GuilvPeer3Old> peer3List2 = new ArrayList<GuilvPeer3Old>();
		
		
		List<GuilvSingleDoubleOld> sdGuilvPeerOlds=pageViewGuilvSingleDoubleOld.getRecords();
		List<GuilvSingleDoubleOld> singleDoubleList = new ArrayList<GuilvSingleDoubleOld>(); 
		List<GuilvSingleDoubleOld> singleDoubleList1 = new ArrayList<GuilvSingleDoubleOld>(); 
		
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
			GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=8){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
			GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=8){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
			GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=6){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
			GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=6){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
			GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=8){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
			GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=8){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
			GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 &&g.getSum()>=10){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
			GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 &&g.getSum()>=10){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 &&g.getSum()>=7){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 &&g.getSum()>=7){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 &&g.getSum()>=9){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 &&g.getSum()>=9){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=12){
		    	 peerList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=12){
		    	 peer3List.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getSum()>=12){
					sbr.add(g);
					 it.remove();
				}
		}

		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==1&&g.getSum()>=4){
					sbr.add(g);
					 it.remove();
				}
		}
		 
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=4){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=5){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=5){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=7){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=7){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=7){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=7){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=8){
					sbr.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==1 && g.getFixation()!=0&&g.getSum()>=6){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=6){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=9){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=9){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=10){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=10){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		
		
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==1 && g.getFixation()!=0&&g.getSum()>=6){
					sbr.add(g);
					 it.remove();
				}
		}
		
		
		
		
		
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=8){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=10){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=10){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		 
		 
		
	
	 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==1 && g.getFixation()!=0&&g.getSum()>=7){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=9){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=11){
					sbr.add(g);
					 it.remove();
				}
		}
 
		
		 
		
		//95%
	 
		  

		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=7){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=7){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=5){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=5){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 &&g.getSum()>=6){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 &&g.getSum()>=6){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=7){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=7){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 &&g.getSum()>=8){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 &&g.getSum()>=8){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 &&g.getSum()>=9){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 &&g.getSum()>=9){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=11){
		    	 peerList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==3 &&g.getSum()>=11){
		    	 peer3List1.add(g);
					 it.remove();
				}
		}
		 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=6){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=6){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=7){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		
		
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==1 && g.getFixation()!=0&&g.getSum()>=5){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=5){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=9){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=9){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=10){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=10){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=11){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=11){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=7){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=9){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=9){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=10){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=10){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=11){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=11){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		 

	 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==1 && g.getFixation()!=0&&g.getSum()>=6){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=8){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=10){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=10){
					sbr1.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=11){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==6&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=34){
					sbr1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==3&&g.getBuchang()==5&&g.getAddition()==1 && g.getFixation()==0&&g.getSum()>=6){
					sbr1.add(g);
					 it.remove();
				}
		}
		

		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==3&&g.getSum()>=16){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==1&&g.getSum()>=9){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==2&&g.getSum()>=12){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==4&&g.getSum()>=20){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==5&&g.getSum()>=23){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==2&&g.getSum()>=13){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==3&&g.getSum()>=20){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==4&&g.getSum()>=24){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==5&&g.getSum()>=27){
					singleDoubleList.add(g);
					 it.remove();
				}
		}
	 
		
		//90%
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=4){
		    	 peerList2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = peers3.iterator(); it.hasNext();) {
		     GuilvPeer3Old g = (GuilvPeer3Old)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 &&g.getSum()>=4){
		    	 peer3List2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=6){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=6){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==6&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=18){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==6&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=19){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getBuchang()==5&&g.getSum()>=31){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getSum()>=34){
					sbr2.add(g);
					 it.remove();
				}
		}
		 
 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=5){
					sbr2.add(g);
					 it.remove();
				}
		}
		 
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=6){
					sbr2.add(g);
					 it.remove();
				}
		}
		

		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=7){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=7){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=8){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=8){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=9){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=9){
					sbr2.add(g);
					 it.remove();
				}
		}
		
	 
	 
		  
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=8){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=8){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=9){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=9){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=10){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=10){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=11){
					sbr2.add(g);
					 it.remove();
				}
		}
		
	 
	 
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=9){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=10){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=10){
					sbr2.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=10){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=11){
					sbr2.add(g);
					 it.remove();
				}
		}
		
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==2&&g.getSum()>=11){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==3&&g.getSum()>=15){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==1&&g.getSum()>=8){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
 
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==4&&g.getSum()>=19){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==5&&g.getAddition()==5&&g.getSum()>=22){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==2&&g.getSum()>=12){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==3&&g.getSum()>=18){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==4&&g.getSum()>=22){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = sdGuilvPeerOlds.iterator(); it.hasNext();) {
		     GuilvSingleDoubleOld g = (GuilvSingleDoubleOld)it.next();
		     if(g.getBuchang()==10&&g.getAddition()==5&&g.getSum()>=25){
					singleDoubleList1.add(g);
					 it.remove();
				}
		}
	 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();

		     boolean falg=SumCountUtils.getGuilv3(g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
		       if(falg){
		    	   sbr2.add(g);
		    	   it.remove();
		       }
		}
		
		
	//85%
		for (Iterator it = peers.iterator(); it.hasNext();) {
		     GuilvPeerOld g = (GuilvPeerOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 &&g.getSum()>=5){
		    	 peerList2.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==2 && g.getFixation()!=0&&g.getSum()>=6){
					sbr3.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()==0&&g.getSum()>=6){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=7){
					sbr3.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=7){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=7){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=7){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=8){
					sbr3.add(g);
					 it.remove();
				}
		}
	 
		 
		
	  
		 
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=9){
					sbr3.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=9){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=9){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==2 && g.getFixation()==0&&g.getSum()>=17){
					sbr3.add(g);
					 it.remove();
				}
		}
		
	 
	
		 
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=10){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=11){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=11){
					sbr3.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=11){
					sbr3.add(g);
					 it.remove();
				}
		}
		 
	//80%
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=10){
					sbr4.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=10){
					sbr4.add(g);
					 it.remove();
				}
		}  
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=6){
					sbr4.add(g);
					 it.remove();
				}
		}
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=6){
					sbr4.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()!=0&&g.getSum()>=7){
					sbr4.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()==0&&g.getSum()>=7){
					sbr4.add(g);
					 it.remove();
				}
		}
		
		for (Iterator it = guilvs.iterator(); it.hasNext();) {
		     GuilvOld g = (GuilvOld)it.next();
		     if(g.getNumber()==1&&g.getBuchang()==10&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=8){
					sbr4.add(g);
					 it.remove();
				}
		}
	 
		 
			
			for (Iterator it = guilvs.iterator(); it.hasNext();) {
			     GuilvOld g = (GuilvOld)it.next();
			     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==5&&g.getAddition()==5 && g.getFixation()!=0&&g.getSum()>=8){
						sbr4.add(g);
						 it.remove();
					}
			}
			
		 
		  
			 
			
		
			 
			 
			for (Iterator it = guilvs.iterator(); it.hasNext();) {
			     GuilvOld g = (GuilvOld)it.next();
			     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==3 && g.getFixation()!=0&&g.getSum()>=9){
						sbr4.add(g);
						 it.remove();
					}
			}
			
			for (Iterator it = guilvs.iterator(); it.hasNext();) {
			     GuilvOld g = (GuilvOld)it.next();
			     if((g.getNumber()==0||g.getNumber()==2)&&g.getBuchang()==10&&g.getAddition()==4 && g.getFixation()==0&&g.getSum()>=9){
						sbr4.add(g);
						 it.remove();
					}
			}
			
			
		 
 
			for (Iterator it = guilvs.iterator(); it.hasNext();) {
				 GuilvOld g = (GuilvOld)it.next();
				 if(g.getNumber()<3){
						sbr5.add(g);
						 it.remove();	 
				 }
					
					 
			}
		
			User user=this.memberManager.findUser("openId", openId);
			 
			boolean isvip=false;
			if(user!=null&&user.getIsVip()==1){
				
				isvip=true;
			}else{
				
				request.setAttribute("isVip", 2);
			}
			
			
			if(isvip){
				request.setAttribute("peerList", peerList);
				request.setAttribute("peerList1", peerList1);
				request.setAttribute("peerList2", peerList2);
				request.setAttribute("singleDoubleList", singleDoubleList);
				request.setAttribute("singleDoubleList1", singleDoubleList1);
				request.setAttribute("sbr", sbr);
				request.setAttribute("sbr1", sbr1);
				request.setAttribute("sbr2", sbr2);
				request.setAttribute("sbr3", sbr3);	
			}
			
		
		request.setAttribute("sbr4", sbr4);
		request.setAttribute("sbr5", sbr5);
		
		request.setAttribute("queryqi", qi);
		return BASE_PATH + "query_error";
	}
	
	

	@RequestMapping(value = "del")
	public String del(Long id,String openId,
		        
			HttpServletRequest request) {
		if("oCc4GwW2U-Cmcuqktm_wXLqPaIPs".equals(openId)){
			this.cocuntService.delGuilv(id);
		}
		return "true";
	}
	
	
	private List<PropertyFilter>   getList(int qi,int type,int gui){
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
	 
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, gui));
		filtersnewses.add(new PropertyFilter("info", MatchType.NNULL, null));
		
		return filtersnewses;
	}

	
	private void getVos2(String[]strs,int i,List<Lottery> ls,int sum,List<GuilvVo> vos){
		int s1 = Integer.valueOf(strs[i].trim())+sum;
       
		int v1 = Integer.valueOf(strs[i+1].trim()); 
		GuilvVo vo=new GuilvVo();
		 
			vo.setQi(ls.get(s1).getQi());
		 
		
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
 
	


	private void getVos(String[]strs,int i,List<Lottery> ls,int sum,List<GuilvVo> vos,int q){
		int s1 = Integer.valueOf(strs[i].trim())+sum+q;
        
		int v1 = Integer.valueOf(strs[i+1].trim()); 
		GuilvVo vo=new GuilvVo();
		if(s1!=0){
			vo.setQi(ls.get(s1-1).getQi());
		}else{
			vo.setQi(ls.get(0).getQi()+1);
		}
		
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
	
	
 
	
	private void getValue(List<GuilvVo> vos,Lottery l,int key){
	          String qi=l.getQi()+"";
			for(GuilvVo g:vos){
				    
				if(qi.equals(g.getQi()+"")){
					 
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
	
	
	private void getValue2(List<GuilvVo> vos,Lottery l,int key){
		  String qi=l.getQi()+"";
			for(GuilvVo g:vos){
				    
				if(qi.equals(g.getQi()+"")){
				 
				  if(g.getValue()==0){
					  l.setVv1(10);
					  
				  }else if(g.getValue()==1){
					  l.setVv2(10);
					  
				  }else if(g.getValue()==2){
					  l.setVv3(10);
					 
				  }else if(g.getValue()==3){
					  l.setVv4(10);
					 
				  }else if(g.getValue()==4){
					  l.setVv5(10);
					 
				  }else if(g.getValue()==5){
					  l.setVv6(10);
					  
				  }else if(g.getValue()==6){
					  l.setVv7(10);
				  }
				 
				 l.setKey(key);
			}
		}
	}
	
	
	
	
	private void getValue3(List<GuilvVo> vos,Lottery l,int key){
		  String qi=l.getQi()+"";
			for(GuilvVo g:vos){
				    
				if(qi.equals(g.getQi()+"")){
				 
				  if(g.getValue()==0){
					  l.setP1(10);
					  
				  }else if(g.getValue()==1){
					  l.setP2(10);
					  
				  }else if(g.getValue()==2){
					  l.setP3(10);
					 
				  }else if(g.getValue()==3){
					  l.setP4(10);
					 
				  }else if(g.getValue()==4){
					  l.setP5(10);
					 
				  }else if(g.getValue()==5){
					  l.setP6(10);
					  
				  }else if(g.getValue()==6){
					  l.setP7(10);
				  }
				 
				 l.setKey(key);
			}
		}
	}
	
	
	private void getValue4(List<GuilvVo> vos,Lottery l,int key){
		  String qi=l.getQi()+"";
			for(GuilvVo g:vos){
				    
				if(qi.equals(g.getQi()+"")){
				 
				  if(g.getValue()==0){
					  l.setPp1(10);
					  
				  }else if(g.getValue()==1){
					  l.setPp2(10);
					  
				  }else if(g.getValue()==2){
					  l.setPp3(10);
					 
				  }else if(g.getValue()==3){
					  l.setPp4(10);
					 
				  }else if(g.getValue()==4){
					  l.setPp5(10);
					 
				  }else if(g.getValue()==5){
					  l.setPp6(10);
					  
				  }else if(g.getValue()==6){
					  l.setPp7(10);
				  }
				 
				 l.setKey(key);
			}
		}
	}
	
 

}
