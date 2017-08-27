package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.guilv.XjsscPlan;


public interface XjsscPlanService {

	void savePlan(XjsscPlan r);

	void delPlan(Long long1);

	void updatePlan(XjsscPlan r);

	QueryResult<XjsscPlan> findList(PageView<XjsscPlan> pv, List<PropertyFilter> filters);

	XjsscPlan findPlan(Long id);

	XjsscPlan findPlan(Object p, Object v);
	
	XjsscPlan findPlan(long qi, int type);
	public XjsscPlan findPlan(int type) ;
	List<XjsscPlan> findIntegers(Object p, Object v);
	List<XjsscPlan> findIntegers();
}
