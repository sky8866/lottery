package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilvSizeOld;

public interface CqGuilvSizeOldService {

	void saveGuilv(CqGuilvSizeOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvSizeOld r);

	QueryResult<CqGuilvSizeOld> findList(PageView<CqGuilvSizeOld> pv, List<PropertyFilter> filters);

	CqGuilvSizeOld findGuilv(Long id);

	CqGuilvSizeOld findGuilv(Object p, Object v);
	CqGuilvSizeOld findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvSizeOld> findList(Object p, Object v);
}
