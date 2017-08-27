package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.GuilvLimitOld;
 

public interface GuilvLimitOldService {

	void saveGuilv(GuilvLimitOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvLimitOld r);

	QueryResult<GuilvLimitOld> findList(PageView<GuilvLimitOld> pv, List<PropertyFilter> filters);

	GuilvLimitOld findGuilv(Long id);

	GuilvLimitOld findGuilv(Object p, Object v);
	GuilvLimitOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvLimitOld> findList(Object p, Object v);
}
