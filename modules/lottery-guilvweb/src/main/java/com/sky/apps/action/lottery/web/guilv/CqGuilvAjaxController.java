package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.sky.apps.action.lottery.web.utils.guilv.CqGuilvRemoveConditionUtils; 
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvSameUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvScopeUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryGuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryPeer3Utils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.CqLotteryUtils;
import com.sky.apps.action.lottery.web.vo.guilv.CqGuilvVo; 
 
import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView; 
import com.sky.modules.core.bean.PropertyFilter; 
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.entity.guilv.CqGuilv;
import com.sky.modules.lottery.entity.guilv.CqGuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.CqGuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCondition;
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.CqGuilvSameOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvScopeOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.CqGuilvSizeOld;
import com.sky.modules.lottery.entity.guilv.CqsscLottery; 
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.service.guilv.CqGuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.CqGuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.CqGuilvSameOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvScopeOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvService;
import com.sky.modules.lottery.service.guilv.CqGuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.CqGuilvSizeOldService;
import com.sky.modules.lottery.service.guilv.CqsscLotteryService; 
import com.sky.modules.lottery.service.user.MemberManager;

 

 

@Controller
@RequestMapping(value = "/system/ajax/guilv/cq")
public class CqGuilvAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private CqsscLotteryService lotteryService;

	@Autowired
	private CqGuilvService guilvService;
	 
	 
	@Autowired
	private CqGuilvScopeOldService guilvScopeOldService;
	
	@Autowired CqGuilvPeerOldService peerService;
	
	@Autowired CqGuilvPeer3OldService peer3Service; 
	
 
	@Autowired CqGuilvSingleDoubleOldService gDoubleOLdService;
	@Autowired CqGuilvSizeOldService sizeOLdService;
	
	@Autowired private MemberManager memberManager;
	@Autowired CqGuilvRemoveCountService cocuntService; 
	@Autowired private CqGuilvRemoveConditionService conditionService; 
 
	
	@Autowired CqGuilvSameOldService sameOldService;
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

 
	
	@RequestMapping(value = "detail2")
	public String detail(Long id,int  type,String typeq,
		        
			HttpServletRequest request) {
		
		PageView<CqsscLottery> pageView = new PageView<CqsscLottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<CqsscLottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		 
	 
		String valueNew="";
		
		String valuePeerNew="";
		int sum=0;
		long qi=0;
		int co=0;
		boolean flag=true;//全显示
		if(type==1){
			CqGuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
			
		}else if(type==2){
			CqGuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
		}else if(type==3){
			CqGuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
		}else if(type==4){
			CqGuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
		}else if(type==5){
			CqGuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			request.setAttribute("type", "");
		}else if(type==6){
			CqGuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
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
 
		List<CqGuilvVo> vos=new ArrayList<CqGuilvVo>();
		
		List<CqGuilvVo> vos2=new ArrayList<CqGuilvVo>();
		
		List<CqGuilvVo> vos3=new ArrayList<CqGuilvVo>();
		
		List<CqGuilvVo> vos4=new ArrayList<CqGuilvVo>();
		List<CqGuilvVo> vos5=new ArrayList<CqGuilvVo>();
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
				for(CqGuilvVo vo:vos){
					CqGuilvVo v=new CqGuilvVo();
				   v.setQi(vo.getQi()-i);
				   v.setValue(vo.getValue());
				   v.setKey(5);
					 
					vos5.add(v);
				}
			}	
		}

 
	 
		
		for(int i=0;i<=count;i++){
			CqsscLottery l=pageView.getRecords().get(i);
			
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
		
	  
		CqsscLottery lottery=this.lotteryService.findReport("qi", qi-sum);
		 
		List<CqsscLottery> lsList = new ArrayList<CqsscLottery>();
	 
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "cq_detail";
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
		
		PageView<CqsscLottery> pageView = new PageView<CqsscLottery>();
		pageView.setOrderby("id", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<CqsscLottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		 
	 
		String valueNew="";
		
		String valuePeerNew="";
		int sum=0;
		long qi=0;
		int co=0;
		boolean flag=true;//全显示
		if(type==1){
			CqGuilv g=this.guilvService.findGuilvKill(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
			
		}else if(type==2){
			CqGuilvScopeOld g=this.guilvScopeOldService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
		}else if(type==3){
			CqGuilvSingleDoubleOld g=this.gDoubleOLdService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
		}else if(type==4){
			CqGuilvPeerOld g=this.peerService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
			}
		}else if(type==5){
			CqGuilvPeer3Old g=this.peer3Service.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			request.setAttribute("type", "");
		}else if(type==6){
			CqGuilvSizeOld g=this.sizeOLdService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			flag=false;
			if(!StringUtils.isNotEmpty(typeq)){
				request.setAttribute("type", "");
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
 
		List<CqGuilvVo> vos=new ArrayList<CqGuilvVo>();
		
		List<CqGuilvVo> vos2=new ArrayList<CqGuilvVo>();
		
		List<CqGuilvVo> vos3=new ArrayList<CqGuilvVo>();
		
		List<CqGuilvVo> vos4=new ArrayList<CqGuilvVo>();
		List<CqGuilvVo> vos5=new ArrayList<CqGuilvVo>();
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
				for(CqGuilvVo vo:vos){
					CqGuilvVo v=new CqGuilvVo();
				   v.setQi(vo.getQi()-i);
				   v.setValue(vo.getValue());
				   v.setKey(5);
					 
					vos5.add(v);
				}
			}	
		}

 
	 
		
		for(int i=0;i<=count;i++){
			CqsscLottery l=pageView.getRecords().get(i);
			
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
		
	  
		CqsscLottery lottery=this.lotteryService.findReport("qi", qi-sum);
		 
		List<CqsscLottery> lsList = new ArrayList<CqsscLottery>();
	 
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "cq_detail";
	}
	

	@RequestMapping(value = "singleDouble")
	public String singleDouble(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") long qi,
			HttpServletRequest request) {
		 
	 	 PageView<CqGuilvSingleDoubleOld> pageViewGuilvRemoveCount = new PageView<CqGuilvSingleDoubleOld>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		 
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type)); 
		pageViewGuilvRemoveCount.setQueryResult(gDoubleOLdService.findList(pageViewGuilvRemoveCount, filtersnewses));
  
		 List<CqGuilvSingleDoubleOld> ps=new ArrayList<CqGuilvSingleDoubleOld>();
		 for(CqGuilvSingleDoubleOld g:pageViewGuilvRemoveCount.getRecords()){
			 boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			 
				if(falg){
					ps.add(g);
				}
		 }
 	 

		User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=false;
		if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			
			request.setAttribute("isVip", 2);
		}
	 
		
		 request.setAttribute("singleDoubleList",ps);  
	
	   request.setAttribute("queryqi", qi);
	
		return BASE_PATH +"cq_sum_singleDouble";
	}
	
	
 

	@RequestMapping(value = "error")
	public String error(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") long qi,
			HttpServletRequest request) {
		
		/*List<CqGuilv> gs=this.guilvService.findList(new PageView<CqGuilv>(), null).getResultlist();
		for(CqGuilv g:gs){
			CqGuilvRemoveCondition condition=this.conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1);
			CqLotteryUtils.condition(conditionService, condition, g);
		}*/
	/*	List<CqGuilvPeerOld> ps=this.peerService.findList(new PageView<CqGuilvPeerOld>(), null).getResultlist();
		for(CqGuilvPeerOld g:ps){
			CqGuilvRemoveCondition condition=this.conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 4);
			 
			if(condition!=null&&g!=null){
				CqLotteryPeerUtils.condition(conditionService, condition, g);
			}
			
		}*/
		
	/*	List<CqGuilvPeer3Old> p3s=this.peer3Service.findList(new PageView<CqGuilvPeer3Old>(), null).getResultlist();
		for(CqGuilvPeer3Old g:p3s){
			CqGuilvRemoveCondition condition=this.conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 5);
			CqLotteryPeer3Utils.condition(conditionService, condition, g);
		}
		List<CqGuilvSameOld> ss=this.sameOldService.findList();
		for(CqGuilvSameOld g:ss){
			CqGuilvRemoveCondition condition=this.conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 12);
			CqLotteryGuilvSameUtils.condition(conditionService, condition, g);
		}
		List<CqGuilvScopeOld> css=this.guilvScopeOldService.findList(new PageView<CqGuilvScopeOld>(), null).getResultlist();
		for(CqGuilvScopeOld g:css){
			CqGuilvRemoveCondition condition=this.conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 2);
			CqLotteryGuilvScopeUtils.condition(conditionService, condition, g);
		}
		
		List<CqGuilvSingleDoubleOld> sds=this.gDoubleOLdService.findList(new PageView<CqGuilvSingleDoubleOld>(), null).getResultlist();
		for(CqGuilvSingleDoubleOld g:sds){
			CqGuilvRemoveCondition condition=this.conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3);
			CqLotteryGuilvSingleDoubleUtils.condition(conditionService, condition, g);
			System.out.println("eee");
		}*/
		
		
		 
	 	 PageView<CqGuilvRemoveCount> pageViewGuilvRemoveCount = new PageView<CqGuilvRemoveCount>();
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses.add(new PropertyFilter("remove", MatchType.EQ, 0));
		pageViewGuilvRemoveCount.setQueryResult(cocuntService.findList(pageViewGuilvRemoveCount, filtersnewses));
  
		 
 	 

		//User user=this.memberManager.findUser("openId", openId);
		 
		boolean isvip=true;
	/*	if(user!=null&&user.getIsVip()==1){
			
			isvip=true;
		}else{
			
			request.setAttribute("isVip", 2);
		}*/
		
		if(isvip){
			 request.setAttribute("peerList", pageViewGuilvRemoveCount.getRecords());  
		}
		
	 
	
	request.setAttribute("queryqi", qi);
	
		return BASE_PATH +"cq_sum_error";
	}
	
	
	
	
	
	@RequestMapping(value = "error2")
	public String error2(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") long qi,
			HttpServletRequest request) {
		
		 PageView<CqGuilvRemoveCount> pageViewGuilvRemoveCount = new PageView<CqGuilvRemoveCount>();
			List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
			filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses.add(new PropertyFilter("remove", MatchType.EQ, 1));
			pageViewGuilvRemoveCount.setQueryResult(cocuntService.findList(pageViewGuilvRemoveCount, filtersnewses));
		
	  
 	PageView<CqGuilv> pageViewGuilv = new PageView<CqGuilv>();
		pageViewGuilv.setOrderby("sum", "desc");
		
	
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				getList(qi,type,1)));
		
		PageView<CqGuilvScopeOld> pageViewGuilvScopeOld = new PageView<CqGuilvScopeOld>();
		pageViewGuilv.setOrderby("sum", "desc");
		
	
		pageViewGuilvScopeOld.setQueryResult(guilvScopeOldService.findList(pageViewGuilvScopeOld,
				getList(qi,type,1)));
		
		
		
		PageView<CqGuilvPeerOld> pageViewGuilvPeer = new PageView<CqGuilvPeerOld>();
		pageViewGuilvPeer.setOrderby("sum", "desc");
		pageViewGuilvPeer.setQueryResult(peerService.findList(pageViewGuilvPeer,
				getList(qi,type,3)));
		
		PageView<CqGuilvPeer3Old> pageViewGuilvPeer3 = new PageView<CqGuilvPeer3Old>();
		pageViewGuilvPeer3.setOrderby("sum", "desc");
		pageViewGuilvPeer3.setQueryResult(peer3Service.findList(pageViewGuilvPeer3,
				getList(qi,type,3)));
		
		
		
		PageView<CqGuilvSingleDoubleOld> pageViewGuilvSingleDoubleOld = new PageView<CqGuilvSingleDoubleOld>();
		pageViewGuilvSingleDoubleOld.setOrderby("sum", "desc");
		pageViewGuilvSingleDoubleOld.setQueryResult(gDoubleOLdService.findList(pageViewGuilvSingleDoubleOld,
				getList(qi,type,7)));
		
		PageView<CqGuilvSameOld> pageViewGuilvSameOld = new PageView<CqGuilvSameOld>();
		pageViewGuilvSameOld.setOrderby("sum", "desc");
		pageViewGuilvSameOld.setQueryResult(sameOldService.findList(pageViewGuilvSameOld,
				getList(qi,type,1)));
		
		List<CqGuilv> guilvs = pageViewGuilv.getRecords();
		List<CqGuilv> sbr = new ArrayList<CqGuilv>(); 
		for(CqGuilv g:guilvs){
			
			boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   sbr.add(g);
	       }
		}
		
		List<CqGuilvScopeOld> scopeList = new ArrayList<CqGuilvScopeOld>(); 
		for(CqGuilvScopeOld g:pageViewGuilvScopeOld.getRecords()){
			boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 2), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   scopeList.add(g);
	       }
		}
		
		
		List<CqGuilvPeerOld> peers=pageViewGuilvPeer.getRecords();
		
		
		
		List<CqGuilvPeerOld> peerList = new ArrayList<CqGuilvPeerOld>(); 
		for(CqGuilvPeerOld g: peers){
			boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 4), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			if(falg){
				peerList.add(g);	
			}
		}
		
		
	List<CqGuilvPeer3Old> peers3=pageViewGuilvPeer3.getRecords();
		
		
		
		List<CqGuilvPeer3Old> peer3List = new ArrayList<CqGuilvPeer3Old>(); 
		for(CqGuilvPeer3Old g: peers3){
			boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 5), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			if(falg){
				peer3List.add(g);	
			}
		}
		
		List<CqGuilvSingleDoubleOld> sdGuilvPeerOlds=pageViewGuilvSingleDoubleOld.getRecords();
		List<CqGuilvSingleDoubleOld> singleDoubleList = new ArrayList<CqGuilvSingleDoubleOld>(); 
		for(CqGuilvSingleDoubleOld g:sdGuilvPeerOlds){
			boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			 
			if(falg){
				singleDoubleList.add(g);
			}
		}  
		
		List<CqGuilvSameOld> sameOlds=pageViewGuilvSameOld.getRecords();
		List<CqGuilvSameOld> sameOldsList = new ArrayList<CqGuilvSameOld>(); 
		for(CqGuilvSameOld g:sameOlds){
			boolean falg=CqGuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			 
			if(falg){
				sameOldsList.add(g);
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
			 request.setAttribute("removeCounts",pageViewGuilvRemoveCount.getRecords()); 
			
			 request.setAttribute("peerList", peerList); 
			  request.setAttribute("peer3List", peer3List); 
			  request.setAttribute("singleDoubleList", singleDoubleList);
			  request.setAttribute("scopeList", scopeList);
			   request.setAttribute("sbr",sbr); 
			   request.setAttribute("sames",sameOldsList); 
		}
		
	 
	
	request.setAttribute("queryqi", qi);
	
		return BASE_PATH +"cq_sum_error2";
	}
	
	
	
 
	
	private List<PropertyFilter>   getList(long qi,int type,int gui){
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
	 
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, gui));
		filtersnewses.add(new PropertyFilter("info", MatchType.NNULL, null));
		
		return filtersnewses;
	}

	
	private void getVos2(String[]strs,int i,List<CqsscLottery> ls,int sum,List<CqGuilvVo> vos){
		int s1 = Integer.valueOf(strs[i].trim())+sum;
       
		int v1 = Integer.valueOf(strs[i+1].trim()); 
		CqGuilvVo vo=new CqGuilvVo();
		 
			vo.setQi(ls.get(s1).getQi());
		 
		
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
 
	


	private void getVos(String[]strs,int i,List<CqsscLottery> ls,int sum,List<CqGuilvVo> vos,int q){
		int s1 = Integer.valueOf(strs[i].trim())+sum+q;
        
		int v1 = Integer.valueOf(strs[i+1].trim()); 
		CqGuilvVo vo=new CqGuilvVo();
		if(s1!=0){
			vo.setQi(ls.get(s1-1).getQi());
		}else{
			vo.setQi(ls.get(0).getQi()+1);
		}
		
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
	
	
 
	
	private void getValue(List<CqGuilvVo> vos,CqsscLottery l,int key){
	          String qi=l.getQi()+"";
			for(CqGuilvVo g:vos){
				    
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
	
	
	private void getValue2(List<CqGuilvVo> vos,CqsscLottery l,int key){
		  String qi=l.getQi()+"";
			for(CqGuilvVo g:vos){
				    
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
	
	
	
	
	private void getValue3(List<CqGuilvVo> vos,CqsscLottery l,int key){
		  String qi=l.getQi()+"";
			for(CqGuilvVo g:vos){
				    
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
	
	
	private void getValue4(List<CqGuilvVo> vos,CqsscLottery l,int key){
		  String qi=l.getQi()+"";
			for(CqGuilvVo g:vos){
				    
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
