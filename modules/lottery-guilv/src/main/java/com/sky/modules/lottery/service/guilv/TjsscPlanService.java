package com.sky.modules.lottery.service.guilv;
 
import java.util.List;
 

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.XjsscPlan;
import com.sky.modules.lottery.entity.guilv.TjsscPlan;


public interface TjsscPlanService {

	void savePlan(TjsscPlan r);

	void delPlan(Long long1);

	void updatePlan(TjsscPlan r);

	QueryResult<TjsscPlan> findList(PageView<TjsscPlan> pv, List<PropertyFilter> filters);

	TjsscPlan findPlan(Long id);

	TjsscPlan findPlan(Object p, Object v);
	
	TjsscPlan findPlan(long qi, int type);
	public TjsscPlan findPlan(int type) ;
	List<TjsscPlan> findIntegers(Object p, Object v);
	List<TjsscPlan> findIntegers();
}
