package com.sky.modules.lottery.service.guilv;
 
import java.util.List;
 

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.Pl5Plan;


public interface Pl5PlanService {

	void savePlan(Pl5Plan r);

	void delPlan(Long long1);

	void updatePlan(Pl5Plan r);

	QueryResult<Pl5Plan> findList(PageView<Pl5Plan> pv, List<PropertyFilter> filters);

	Pl5Plan findPlan(Long id);

	Pl5Plan findPlan(Object p, Object v);
	
	Pl5Plan findPlan(long qi, int type);
	
	List<Pl5Plan> findIntegers(Object p, Object v);
	List<Pl5Plan> findIntegers();
}
