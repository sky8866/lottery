package com.sky.modules.lottery.service.guilv;
 
import java.util.List;
 

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.QxcPlan;


public interface QxcPlanService {

	void savePlan(QxcPlan r);

	void delPlan(Long long1);

	void updatePlan(QxcPlan r);

	QueryResult<QxcPlan> findList(PageView<QxcPlan> pv, List<PropertyFilter> filters);

	QxcPlan findPlan(Long id);

	QxcPlan findPlan(Object p, Object v);
	
	QxcPlan findPlan(long qi, int type);
	
	List<QxcPlan> findIntegers(Object p, Object v);
	List<QxcPlan> findIntegers();
}
