package com.sky.apps.action.lottery.web.guilv;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.h2.table.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.service.guilv.Pl5PlanService;

@Controller
@RequestMapping(value = "/system/ajax/guilv/pl5")
public class Pl5PlanAjaxController {

	private final static String BASE_PATH = "guilv/";

	@Autowired
	private Pl5PlanService planService;

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
		
		
		PageView<Pl5Plan> pageViewGuilv3 = new PageView<Pl5Plan>(10, 1);
		pageViewGuilv3.setOrderby("id", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		pageViewGuilv3.setQueryResult(planService.findList(pageViewGuilv3,
				filtersnewses3));
		List<Pl5Plan> guilvs3 = pageViewGuilv3.getRecords();

		request.setAttribute("sbr", guilvs3);
		request.setAttribute("plantype", type);
		
		 
		return BASE_PATH + "pl5_query_plans";
	}
	
	
	 

}
