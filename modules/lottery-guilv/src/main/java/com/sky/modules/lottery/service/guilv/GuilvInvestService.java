package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
 
import com.sky.modules.lottery.entity.guilv.Invest;

public interface GuilvInvestService {

	void saveInvest(Invest r);

	void delInvest(Serializable[] entityids);

	void updateInvest(Invest r);

	QueryResult<Invest> findList(PageView<Invest> pv, List<PropertyFilter> filters);

	Invest findInvest(Long id);

	Invest findInvest(Object p, Object v);
	
	List<Invest> findIntegers(Object p, Object v);
	List<Invest> findIntegers();
	
}
