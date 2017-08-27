package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilvSingleDoubleOld;

public interface CqGuilvSingleDoubleOldService {

	void saveGuilv(CqGuilvSingleDoubleOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvSingleDoubleOld r);

	QueryResult<CqGuilvSingleDoubleOld> findList(PageView<CqGuilvSingleDoubleOld> pv, List<PropertyFilter> filters);

	CqGuilvSingleDoubleOld findGuilv(Long id);

	CqGuilvSingleDoubleOld findGuilv(Object p, Object v);
	CqGuilvSingleDoubleOld findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvSingleDoubleOld> findList(Object p, Object v);
}
