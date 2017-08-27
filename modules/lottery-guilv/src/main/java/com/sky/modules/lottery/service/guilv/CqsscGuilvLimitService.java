package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvLimit;
 

public interface CqsscGuilvLimitService {

	void saveGuilv(CqsscGuilvLimit r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqsscGuilvLimit r);

	QueryResult<CqsscGuilvLimit> findList(PageView<CqsscGuilvLimit> pv, List<PropertyFilter> filters);

	CqsscGuilvLimit findGuilv(Long id);

	CqsscGuilvLimit findGuilv(Object p, Object v);
	CqsscGuilvLimit findGuilvs(Object[] p, Object[] v);
	
    List<CqsscGuilvLimit> findList(Object p, Object v);
}
