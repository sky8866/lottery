package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;

public interface GuilvRemoveCountService {

	void saveGuilv(GuilvRemoveCount r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvRemoveCount r);

	QueryResult<GuilvRemoveCount> findList(PageView<GuilvRemoveCount> pv, List<PropertyFilter> filters);

	GuilvRemoveCount findGuilv(Long id);

	GuilvRemoveCount findGuilv(Object p, Object v);
	GuilvRemoveCount findGuilvs(Object[] p, Object[] v);
	
    List<GuilvRemoveCount> findList(Object p, Object v);
}
