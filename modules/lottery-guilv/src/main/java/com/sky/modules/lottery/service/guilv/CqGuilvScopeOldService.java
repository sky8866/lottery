package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilvScopeOld;

public interface CqGuilvScopeOldService {

	void saveGuilv(CqGuilvScopeOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvScopeOld r);

	QueryResult<CqGuilvScopeOld> findList(PageView<CqGuilvScopeOld> pv, List<PropertyFilter> filters);

	CqGuilvScopeOld findGuilv(Long id);

	CqGuilvScopeOld findGuilv(Object p, Object v);
	CqGuilvScopeOld findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvScopeOld> findList(Object p, Object v);
}
