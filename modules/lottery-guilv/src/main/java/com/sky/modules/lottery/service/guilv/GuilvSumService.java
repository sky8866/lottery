package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
 
import com.sky.modules.lottery.entity.guilv.GuilvSum;

public interface GuilvSumService {

	void saveGuilvSum(GuilvSum r);

	void delGuilvSum(Serializable[] entityids);

	void updateGuilvSum(GuilvSum r);

	QueryResult<GuilvSum> findList(PageView<GuilvSum> pv, List<PropertyFilter> filters);

	GuilvSum findGuilvSum(Long id);

	GuilvSum findGuilvSum(Object p, Object v);
}
