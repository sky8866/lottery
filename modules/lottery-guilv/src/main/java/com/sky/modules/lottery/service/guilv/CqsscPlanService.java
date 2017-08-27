package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;


public interface CqsscPlanService {

	void savePlan(CqsscPlan r);

	void delPlan(Long long1);

	void updatePlan(CqsscPlan r);

	QueryResult<CqsscPlan> findList(PageView<CqsscPlan> pv, List<PropertyFilter> filters);

	CqsscPlan findPlan(Long id);

	CqsscPlan findPlan(Object p, Object v);
	
	CqsscPlan findPlan(int qi, int type);
	
	List<CqsscPlan> findIntegers(Object p, Object v);
	List<CqsscPlan> findIntegers();
	public CqsscPlan findPlan(int type);
}
