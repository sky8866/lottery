package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilvSameOld;

public interface CqGuilvSameOldService {

	void saveGuilv(CqGuilvSameOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvSameOld r);

	QueryResult<CqGuilvSameOld> findList(PageView<CqGuilvSameOld> pv, List<PropertyFilter> filters);

	CqGuilvSameOld findGuilv(Long id);

	CqGuilvSameOld findGuilv(Object p, Object v);
	CqGuilvSameOld findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvSameOld> findList(Object p, Object v);
    List<CqGuilvSameOld> findList();
}
