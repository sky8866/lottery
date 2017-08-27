package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvScopeOld;

public interface Pl5GuilvScopeOldService {

	void saveGuilv(Pl5GuilvScopeOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvScopeOld r);

	QueryResult<Pl5GuilvScopeOld> findList(PageView<Pl5GuilvScopeOld> pv, List<PropertyFilter> filters);

	Pl5GuilvScopeOld findGuilv(Long id);

	Pl5GuilvScopeOld findGuilv(Object p, Object v);
	Pl5GuilvScopeOld findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvScopeOld> findList(Object p, Object v);
}
