package com.sky.modules.lottery.service.guilv;
 
import java.util.List;
 

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.NewPlan;


public interface NewPlanService {

	void savePlan(NewPlan r);

	void delPlan(Long long1);

	void updatePlan(NewPlan r);

	QueryResult<NewPlan> findList(PageView<NewPlan> pv, List<PropertyFilter> filters);

	NewPlan findPlan(Long id);

	NewPlan findPlan(Object p, Object v);
	
	NewPlan findPlan(long qi, int type);
	
	List<NewPlan> findIntegers(Object p, Object v);
	List<NewPlan> findIntegers();
}
