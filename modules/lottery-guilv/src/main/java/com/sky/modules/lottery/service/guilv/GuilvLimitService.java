package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
 

public interface GuilvLimitService {

	void saveGuilv(GuilvLimit r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvLimit r);

	QueryResult<GuilvLimit> findList(PageView<GuilvLimit> pv, List<PropertyFilter> filters);

	GuilvLimit findGuilv(Long id);

	GuilvLimit findGuilv(Object p, Object v);
	GuilvLimit findGuilvs(Object[] p, Object[] v);
	
    List<GuilvLimit> findList(Object p, Object v);
}
