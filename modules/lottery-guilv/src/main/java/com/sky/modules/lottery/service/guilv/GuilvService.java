package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvOld;

public interface GuilvService {

	void saveGuilv(Guilv r);
	public void saveGuilvOld(GuilvOld o);

	void delGuilv(Serializable... long1);

	void updateGuilv(Guilv r);

	QueryResult<Guilv> findList(PageView<Guilv> pv, List<PropertyFilter> filters);

	Guilv findGuilv(Long id);

	Guilv findGuilv(Object p, Object v);
	Guilv findGuilvs(Object[] p, Object[] v);
	
    List<Guilv> findList(Object p, Object v);
}
