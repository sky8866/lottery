package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.TjsscGuilvLimit;
 

public interface TjsscGuilvLimitService {

	void saveGuilv(TjsscGuilvLimit r);

	void delGuilv(Serializable... long1);

	void updateGuilv(TjsscGuilvLimit r);

	QueryResult<TjsscGuilvLimit> findList(PageView<TjsscGuilvLimit> pv, List<PropertyFilter> filters);

	TjsscGuilvLimit findGuilv(Long id);

	TjsscGuilvLimit findGuilv(Object p, Object v);
	TjsscGuilvLimit findGuilvs(Object[] p, Object[] v);
	
    List<TjsscGuilvLimit> findList(Object p, Object v);
}
