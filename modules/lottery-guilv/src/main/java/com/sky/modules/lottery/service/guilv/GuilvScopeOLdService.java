package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvScopeOld;

public interface GuilvScopeOLdService {

	void saveGuilv(GuilvScopeOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvScopeOld r);

	QueryResult<GuilvScopeOld> findList(PageView<GuilvScopeOld> pv, List<PropertyFilter> filters);

	GuilvScopeOld findGuilv(Long id);

	GuilvScopeOld findGuilv(Object p, Object v);
	GuilvScopeOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvScopeOld> findList(Object p, Object v);
}
