package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.sky.apps.action.lottery.web.utils.guilv.GuilvRemoveConditionUtils;
import com.sky.apps.action.lottery.web.utils.guilv.LotteryUtils;  
import com.sky.apps.action.lottery.web.utils.guilv.Pl5GuilvRemoveConditionUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvSameUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvScopeUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryGuilvSingleDoubleUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryPeer3Utils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryPeerUtils;
import com.sky.apps.action.lottery.web.utils.guilv.Pl5LotteryUtils;
import com.sky.apps.action.lottery.web.vo.guilv.ComparatorGuilv;
import com.sky.apps.action.lottery.web.vo.guilv.Pl5GuilvVo;
 
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
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.Pl5Guilv;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeer3Old;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeerOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCondition;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSameOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvScopeOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSizeOld;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
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
import com.sky.modules.lottery.service.guilv.GuilvSameService;
import com.sky.modules.lottery.service.guilv.GuilvScopeOLdService;
import com.sky.modules.lottery.service.guilv.GuilvService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleService;
import com.sky.modules.lottery.service.guilv.LotteryService; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeer3OldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvPeerOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveConditionService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSameOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvScopeOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSingleDoubleOldService;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSizeOldService;
import com.sky.modules.lottery.service.guilv.Pl5LotteryService;
import com.sky.modules.lottery.service.user.MemberManager;

 

 

@Controller
@RequestMapping(value = "/system/ajax/guilv/pl5")
public class Pl5GuilvAjaxController {

	
	
	private final static String BASE_PATH = "guilv/";

	@Autowired
	private Pl5LotteryService lotteryService;

	@Autowired
	private Pl5GuilvService guilvService;
	 
	 
	@Autowired
	private Pl5GuilvScopeOldService guilvScopeOldService;
	
	@Autowired Pl5GuilvPeerOldService peerService;
	
	@Autowired Pl5GuilvPeer3OldService peer3Service; 
	
 
	@Autowired Pl5GuilvSingleDoubleOldService gDoubleOLdService;
	
	@Autowired Pl5GuilvSizeOldService sizeService;
	@Autowired private MemberManager memberManager;
	@Autowired Pl5GuilvRemoveCountService cocuntService; 
	@Autowired private Pl5GuilvRemoveConditionService conditionService; 
 
	
	@Autowired Pl5GuilvSameOldService sameOldService;
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

 
	
	@RequestMapping(value = "detail2")
	public String detail(Long id,int  type,String typeq,
		        
			HttpServletRequest request) {
		
		PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<Pl5Lottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		 
	 
		String valueNew="";
		
		String valuePeerNew="";
		int sum=0;
		long qi=0;
		int co=0;
		boolean flag=true;//全显示
		if(type==1){
			Pl5GuilvRemoveCount g=this.cocuntService.findGuilv(id);
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
			Pl5GuilvRemoveCount g=this.cocuntService.findGuilv(id);
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
			Pl5GuilvRemoveCount g=this.cocuntService.findGuilv(id);
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
			Pl5GuilvRemoveCount g=this.cocuntService.findGuilv(id);
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
			Pl5GuilvRemoveCount g=this.cocuntService.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			request.setAttribute("type", "此规为杀数！");
		}else if(type==6){
			Pl5GuilvRemoveCount g=this.cocuntService.findGuilv(id);
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
 
		List<Pl5GuilvVo> vos=new ArrayList<Pl5GuilvVo>();
		
		List<Pl5GuilvVo> vos2=new ArrayList<Pl5GuilvVo>();
		
		List<Pl5GuilvVo> vos3=new ArrayList<Pl5GuilvVo>();
		
		List<Pl5GuilvVo> vos4=new ArrayList<Pl5GuilvVo>();
		List<Pl5GuilvVo> vos5=new ArrayList<Pl5GuilvVo>();
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
				for(Pl5GuilvVo vo:vos){
				   Pl5GuilvVo v=new Pl5GuilvVo();
				   v.setQi(vo.getQi()-i);
				   v.setValue(vo.getValue());
				   v.setKey(5);
					 
					vos5.add(v);
				}
			}	
		}

 
	 
		
		for(int i=0;i<=count;i++){
			Pl5Lottery l=pageView.getRecords().get(i);
			
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
		
	  
		Pl5Lottery lottery=this.lotteryService.findReport("qi", qi-sum);
		 
		List<Pl5Lottery> lsList = new ArrayList<Pl5Lottery>();
	 
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "pl5_detail";
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
		
		PageView<Pl5Lottery> pageView = new PageView<Pl5Lottery>();
		pageView.setOrderby("qi", "desc");

		pageView.setQueryResult(this.lotteryService.findList(pageView, null));
		
         List<Pl5Lottery> ls=pageView.getRecords();
		request.setAttribute("newQi",ls.get(0).getQi()+1);
		 
	 
		String valueNew="";
		
		String valuePeerNew="";
		int sum=0;
		long qi=0;
		int co=0;
		boolean flag=true;//全显示
		if(type==1){
			Pl5Guilv g=this.guilvService.findGuilvKill(id);
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
			Pl5GuilvScopeOld g=this.guilvScopeOldService.findGuilv(id);
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
			Pl5GuilvSingleDoubleOld g=this.gDoubleOLdService.findGuilv(id);
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
			Pl5GuilvPeerOld g=this.peerService.findGuilv(id);
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
			Pl5GuilvPeer3Old g=this.peer3Service.findGuilv(id);
			request.setAttribute("lsVaule", g.getStartQueryValue()); 
			request.setAttribute("guilv", g); 
			valueNew=g.getValueNew();
			sum=g.getSum();
			qi=g.getQi();
			valuePeerNew=g.getValueQueryNew();
			flag=false;
			request.setAttribute("type", "此规为杀数！");
		}else if(type==6){
			Pl5GuilvSizeOld g=this.sizeService.findGuilv(id);
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
 
		List<Pl5GuilvVo> vos=new ArrayList<Pl5GuilvVo>();
		
		List<Pl5GuilvVo> vos2=new ArrayList<Pl5GuilvVo>();
		
		List<Pl5GuilvVo> vos3=new ArrayList<Pl5GuilvVo>();
		
		List<Pl5GuilvVo> vos4=new ArrayList<Pl5GuilvVo>();
		List<Pl5GuilvVo> vos5=new ArrayList<Pl5GuilvVo>();
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
				for(Pl5GuilvVo vo:vos){
				   Pl5GuilvVo v=new Pl5GuilvVo();
				   v.setQi(vo.getQi()-i);
				   v.setValue(vo.getValue());
				   v.setKey(5);
					 
					vos5.add(v);
				}
			}	
		}

 
	 
		
		for(int i=0;i<=count;i++){
			Pl5Lottery l=pageView.getRecords().get(i);
			
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
		
	  
		Pl5Lottery lottery=this.lotteryService.findReport("qi", qi-sum);
		 
		List<Pl5Lottery> lsList = new ArrayList<Pl5Lottery>();
	 
		for (int i = count; count+1 > i; i--) {
			if (0 > i) {
				break;
			}
			lsList.add(pageView.getRecords().get(i));
     
		}
		request.setAttribute("lsList", lsList); 
		request.setAttribute("lottery", lottery); 

		return BASE_PATH + "pl5_detail";
	}
	

 

	@RequestMapping(value = "error")
	public String error(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") long qi,
			HttpServletRequest request) {
		  
	 	 PageView<Pl5GuilvRemoveCount> pageViewGuilvRemoveCount = new PageView<Pl5GuilvRemoveCount>();
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
	
		return BASE_PATH +"pl5_sum_error";
	}
	
	
	@RequestMapping(value = "error2")
	public String error2(String openId,
			
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "qi", defaultValue = "0") long qi,
			HttpServletRequest request) {
	  
 	PageView<Pl5Guilv> pageViewGuilv = new PageView<Pl5Guilv>();
		pageViewGuilv.setOrderby("qi", "desc");
		
	
		pageViewGuilv.setQueryResult(guilvService.findList(pageViewGuilv,
				getList(qi,type,1)));
		
		PageView<Pl5GuilvScopeOld> pageViewGuilvScopeOld = new PageView<Pl5GuilvScopeOld>();
		pageViewGuilv.setOrderby("qi", "desc");
		
	
		pageViewGuilvScopeOld.setQueryResult(guilvScopeOldService.findList(pageViewGuilvScopeOld,
				getList(qi,type,1)));
		
		 /*for(Pl5GuilvScopeOld p:pageViewGuilvScopeOld.getRecords()){
			 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(p.getFixation(), p.getBuchang(), p.getAddition(), p.getNumber(), 2);
			 Pl5LotteryGuilvScopeUtils.condition(conditions, p,conditionService);
		 }*/
		
		PageView<Pl5GuilvPeerOld> pageViewGuilvPeer = new PageView<Pl5GuilvPeerOld>();
		pageViewGuilvPeer.setOrderby("qi", "desc");
		pageViewGuilvPeer.setQueryResult(peerService.findList(pageViewGuilvPeer,
				getList(qi,type,3)));
		
		PageView<Pl5GuilvPeer3Old> pageViewGuilvPeer3 = new PageView<Pl5GuilvPeer3Old>();
		pageViewGuilvPeer3.setOrderby("qi", "desc");
		pageViewGuilvPeer3.setQueryResult(peer3Service.findList(pageViewGuilvPeer3,
				getList(qi,type,3)));
		
		
		
		PageView<Pl5GuilvSingleDoubleOld> pageViewGuilvSingleDoubleOld = new PageView<Pl5GuilvSingleDoubleOld>();
		pageViewGuilvSingleDoubleOld.setOrderby("qi", "desc");
		pageViewGuilvSingleDoubleOld.setQueryResult(gDoubleOLdService.findList(pageViewGuilvSingleDoubleOld,
				getList(qi,type,7)));
		
		PageView<Pl5GuilvSameOld> pageViewGuilvSameOld = new PageView<Pl5GuilvSameOld>();
		pageViewGuilvSameOld.setOrderby("qi", "desc");
		pageViewGuilvSameOld.setQueryResult(sameOldService.findList(pageViewGuilvSameOld,
				getList(qi,type,1)));
		
		List<Pl5Guilv> guilvs = pageViewGuilv.getRecords();
	/*	  for(Pl5Guilv p:guilvs){
			  System.out.println("kklklklklklklk");
				 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(p.getFixation(), p.getBuchang(), p.getAddition(), p.getNumber(), 1);
				 Pl5LotteryUtils.condition(conditions, p,conditionService);
			 }*/
		
		List<Pl5Guilv> sbr = new ArrayList<Pl5Guilv>(); 
		for(Pl5Guilv g:guilvs){
			
			boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 1), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   sbr.add(g);
	       }
		}
		
		List<Pl5GuilvScopeOld> scopeList = new ArrayList<Pl5GuilvScopeOld>(); 
		
		
		
		for(Pl5GuilvScopeOld g:pageViewGuilvScopeOld.getRecords()){
			boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 2), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
	       if(falg){
	    	   scopeList.add(g);
	       }
		}
		
		
		List<Pl5GuilvPeerOld> peers=pageViewGuilvPeer.getRecords();
	/*	 for(Pl5GuilvPeerOld p:peers){
				System.out.println("1111111111111111");
			 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(p.getFixation(), p.getBuchang(), p.getAddition(), p.getNumber(), 4);
			 Pl5LotteryPeerUtils.condition(conditions, p,conditionService);
		 }
		*/
		
		List<Pl5GuilvPeerOld> peerList = new ArrayList<Pl5GuilvPeerOld>(); 
		for(Pl5GuilvPeerOld g: peers){
			boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 4), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			if(falg){
				peerList.add(g);	
			}
		}
		
		
	List<Pl5GuilvPeer3Old> peers3=pageViewGuilvPeer3.getRecords();
/*		
	 for(Pl5GuilvPeer3Old p:peers3){
		 System.out.println("xcxvcvcxcxcvx");
		 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(p.getFixation(), p.getBuchang(), p.getAddition(), p.getNumber(), 5);
		 Pl5LotteryPeer3Utils.condition(conditions, p,conditionService);
	 } 
		*/
		List<Pl5GuilvPeer3Old> peer3List = new ArrayList<Pl5GuilvPeer3Old>(); 
		for(Pl5GuilvPeer3Old g: peers3){
			boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 5), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			if(falg){
				peer3List.add(g);	
			}
		}
		
		List<Pl5GuilvSingleDoubleOld> sdGuilvPeerOlds=pageViewGuilvSingleDoubleOld.getRecords();
	/*	for(Pl5GuilvSingleDoubleOld p:sdGuilvPeerOlds){
			System.out.println("dfdfgdfgdfdgfdfg");
			 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(p.getFixation(), p.getBuchang(), p.getAddition(), p.getNumber(), 3);
			 Pl5LotteryGuilvSingleDoubleUtils.condition(conditions, p,conditionService);
		 }
		*/
		
		
		List<Pl5GuilvSingleDoubleOld> singleDoubleList = new ArrayList<Pl5GuilvSingleDoubleOld>(); 
		for(Pl5GuilvSingleDoubleOld g:sdGuilvPeerOlds){
			boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			 
			if(falg){
				singleDoubleList.add(g);
			}
		}  
		
		List<Pl5GuilvSameOld> sameOlds=pageViewGuilvSameOld.getRecords();
		/*  for(Pl5GuilvSameOld p:sameOlds){
		    	System.out.println("wwwrerere");
				 Pl5GuilvRemoveCondition  conditions=conditionService.findGuilv(p.getFixation(), p.getBuchang(), p.getAddition(), p.getNumber(), 12);
				 Pl5LotteryGuilvSameUtils.condition(conditions, p,conditionService);
			 }*/
		
		List<Pl5GuilvSameOld> sameOldsList = new ArrayList<Pl5GuilvSameOld>(); 
		for(Pl5GuilvSameOld g:sameOlds){
			boolean falg=Pl5GuilvRemoveConditionUtils.removeGuilv2(conditionService.findGuilv(g.getFixation(), g.getBuchang(), g.getAddition(), g.getNumber(), 3), g.getAddition(), g.getBuchang(), g.getFixation(), g.getNumber(), g.getSum());
			 
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
			 request.setAttribute("peerList", peerList); 
		 
			  request.setAttribute("peer3List", peer3List); 
			 
			  request.setAttribute("singleDoubleList", singleDoubleList);
			  
			
			  request.setAttribute("scopeList", scopeList);
		
			   request.setAttribute("sbr",sbr); 
	 
			   
			   request.setAttribute("sames",sameOldsList); 
			  
		}
		
	 
	
	request.setAttribute("queryqi", qi);
	
		return BASE_PATH +"pl5_sum_error2";
	}
	
	
	
 
	
	private List<PropertyFilter>   getList(long qi,int type,int gui){
		List<PropertyFilter> filtersnewses = new ArrayList<PropertyFilter>();
		/*filtersnewses.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses.add(new PropertyFilter("type", MatchType.EQ, type));
	 
	 
		filtersnewses.add(new PropertyFilter("gui", MatchType.EQ, gui));
		filtersnewses.add(new PropertyFilter("info", MatchType.NNULL, null));*/
		
		return filtersnewses;
	}

	
	private void getVos2(String[]strs,int i,List<Pl5Lottery> ls,int sum,List<Pl5GuilvVo> vos){
		int s1 = Integer.valueOf(strs[i].trim())+sum;
       
		int v1 = Integer.valueOf(strs[i+1].trim()); 
		Pl5GuilvVo vo=new Pl5GuilvVo();
		 
			vo.setQi(ls.get(s1).getQi());
		 
		
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
 
	


	private void getVos(String[]strs,int i,List<Pl5Lottery> ls,int sum,List<Pl5GuilvVo> vos,int q){
		int s1 = Integer.valueOf(strs[i].trim())+sum+q;
        
		int v1 = Integer.valueOf(strs[i+1].trim()); 
		Pl5GuilvVo vo=new Pl5GuilvVo();
		if(s1!=0){
			vo.setQi(ls.get(s1-1).getQi());
		}else{
			vo.setQi(ls.get(0).getQi()+1);
		}
		
        vo.setValue(v1);
        
        vos.add(vo);
        
	}
	
	
 
	
	private void getValue(List<Pl5GuilvVo> vos,Pl5Lottery l,int key){
	          String qi=l.getQi()+"";
			for(Pl5GuilvVo g:vos){
				    
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
	
	
	private void getValue2(List<Pl5GuilvVo> vos,Pl5Lottery l,int key){
		  String qi=l.getQi()+"";
			for(Pl5GuilvVo g:vos){
				    
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
	
	
	
	
	private void getValue3(List<Pl5GuilvVo> vos,Pl5Lottery l,int key){
		  String qi=l.getQi()+"";
			for(Pl5GuilvVo g:vos){
				    
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
	
	
	private void getValue4(List<Pl5GuilvVo> vos,Pl5Lottery l,int key){
		  String qi=l.getQi()+"";
			for(Pl5GuilvVo g:vos){
				    
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
