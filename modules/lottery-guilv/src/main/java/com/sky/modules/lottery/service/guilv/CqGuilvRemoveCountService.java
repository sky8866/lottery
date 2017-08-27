package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount;

public interface CqGuilvRemoveCountService {

	void saveGuilv(CqGuilvRemoveCount r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvRemoveCount r);

	QueryResult<CqGuilvRemoveCount> findList(PageView<CqGuilvRemoveCount> pv, List<PropertyFilter> filters);

	CqGuilvRemoveCount findGuilv(Long id);

	CqGuilvRemoveCount findGuilv(Object p, Object v);
	CqGuilvRemoveCount findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvRemoveCount> findList(Object p, Object v);
}
