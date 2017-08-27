package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.lottery.entity.guilv.GuilvPlan;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.entity.guilv.QxcPlan;
import com.sky.modules.lottery.service.guilv.GuilvPlanService;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;
import com.sky.modules.lottery.service.guilv.QxcPlanService;

@Controller
@RequestMapping(value = "/system/ajax/guilv/qxc")
public class QxcPlanAjaxController {

	private final static String BASE_PATH = "guilv/";

	@Autowired
	private QxcPlanService planService;
	@Autowired
	private GuilvPlanService guilvPlanService;
	@RequestMapping(value = "plan")
	public String query(
			@RequestParam(value = "addition", defaultValue = "1") int addition,
			@RequestParam(value = "buchang", defaultValue = "10") int buchang,
			@RequestParam(value = "type", defaultValue = "0") int type,
			@RequestParam(value = "even", defaultValue = "3") int even,
			@RequestParam(value = "fixation", defaultValue = "0") int fixation,
			@RequestParam(value = "matchType", defaultValue = "0") int matchType,
			@RequestParam(value = "number", defaultValue = "1") int number,
			@RequestParam(value = "qi", defaultValue = "0") int qi,
			String openId, HttpServletRequest request) {
		    int count=10;
		 if(type!=6){
			 PageView<GuilvPlan> pageViewGuilv3 = new PageView<GuilvPlan>(10, 1);
				pageViewGuilv3.setOrderby("id", "desc");
				List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
				filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
				pageViewGuilv3.setQueryResult(guilvPlanService.findList(pageViewGuilv3,
						filtersnewses3));
				List<GuilvPlan> guilvs3 = pageViewGuilv3.getRecords();

				request.setAttribute("sbr", guilvs3);
				request.setAttribute("plantype", type);
				
				 
				return BASE_PATH + "pl5_query_plans";
		 }else if(type==6){
			    PageView<QxcPlan> pageViewGuilv3 = new PageView<QxcPlan>(1, 1);
				List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
				pageViewGuilv3.setOrderby("id", "desc");
			
				filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, 2));
				pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
						filtersnewses3));
				List<QxcPlan> guilvs3 = pageViewGuilv3.getRecords();

				request.setAttribute("sbr2", guilvs3);
				 pageViewGuilv3 = new PageView<QxcPlan>(1, 1);
				 filtersnewses3 = new ArrayList<PropertyFilter>();
				pageViewGuilv3.setOrderby("id", "desc");
				
				filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, 1));
				pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
						filtersnewses3));
				  guilvs3 = pageViewGuilv3.getRecords();
				  request.setAttribute("sbr", guilvs3);
				  
				  pageViewGuilv3 = new PageView<QxcPlan>(1, 1);
					 filtersnewses3 = new ArrayList<PropertyFilter>();
					pageViewGuilv3.setOrderby("id", "desc");
					
					filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, 3));
					pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
							filtersnewses3));
					  guilvs3 = pageViewGuilv3.getRecords();
					  request.setAttribute("sbr3", guilvs3);
				  
					  return BASE_PATH + "qxc_query_plans";  
				  
		 }
		
		
		
		 return BASE_PATH + "qxc_query_plans";
		 
		
	}
	
	
	 

}
