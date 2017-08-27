package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
 

public interface GuilvAllRightService {

	void saveGuilv(GuilvAllRight r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvAllRight r);

	QueryResult<GuilvAllRight> findList(PageView<GuilvAllRight> pv, List<PropertyFilter> filters);

	GuilvAllRight findGuilv(Long id);

	GuilvAllRight findGuilv(Object p, Object v);
	GuilvAllRight findGuilvs(Object[] p, Object[] v);
	
    List<GuilvAllRight> findList(Object p, Object v);
}
