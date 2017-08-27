package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
 
import com.sky.modules.lottery.entity.guilv.InvestSum;

public interface GuilvInvestSumService {

	void saveInvestSum(InvestSum r);

	void delInvestSum(Serializable[] entityids);

	void updateInvestSum(InvestSum r);

	QueryResult<InvestSum> findList(PageView<InvestSum> pv, List<PropertyFilter> filters);

	InvestSum findInvestSum(Long id);

	InvestSum findInvestSum(Object p, Object v);
	
	List<InvestSum> findIntegers(Object p, Object v);
	
	List<InvestSum> findInvestSum();
}
