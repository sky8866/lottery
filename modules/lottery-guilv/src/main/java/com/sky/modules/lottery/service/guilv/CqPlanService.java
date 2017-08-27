package com.sky.modules.lottery.service.guilv;

 
import java.util.List; 

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.CqPlan;


public interface CqPlanService {

	void savePlan(CqPlan r);

	void delPlan(Long long1);

	void updatePlan(CqPlan r);

	QueryResult<CqPlan> findList(PageView<CqPlan> pv, List<PropertyFilter> filters);

	CqPlan findPlan(Long id);

	CqPlan findPlan(Object p, Object v);
	
	CqPlan findPlan(long qi, int type);
	
	List<CqPlan> findIntegers(Object p, Object v);
	List<CqPlan> findIntegers();
	public CqPlan findPlan(int type);
}
