package com.sky.modules.lottery.service.guilv;

 
import java.util.List; 

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.GuilvPlan;


public interface GuilvPlanService {

	void savePlan(GuilvPlan r);

	void delPlan(Long long1);

	void updatePlan(GuilvPlan r);

	QueryResult<GuilvPlan> findList(PageView<GuilvPlan> pv, List<PropertyFilter> filters);

	GuilvPlan findPlan(Long id);

	GuilvPlan findPlan(Object p, Object v);
	
	GuilvPlan findPlan(long qi, int type);
	
	List<GuilvPlan> findIntegers(Object p, Object v);
	List<GuilvPlan> findIntegers();
	public GuilvPlan findPlan(int type);
}
