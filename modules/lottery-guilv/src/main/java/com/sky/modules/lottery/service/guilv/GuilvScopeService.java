package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvScope;
import com.sky.modules.lottery.entity.guilv.GuilvScopeOld;

public interface GuilvScopeService {

	void saveGuilv(GuilvScope r);
	public void saveGuilvOld(GuilvScopeOld o);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvScope r);

	QueryResult<GuilvScope> findList(PageView<GuilvScope> pv, List<PropertyFilter> filters);

	GuilvScope findGuilv(Long id);

	GuilvScope findGuilv(Object p, Object v);
	GuilvScope findGuilvs(Object[] p, Object[] v);
	
    List<GuilvScope> findList(Object p, Object v);
}
