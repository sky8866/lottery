package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;

public interface Pl5GuilvRemoveCountService {

	void saveGuilv(Pl5GuilvRemoveCount r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvRemoveCount r);

	QueryResult<Pl5GuilvRemoveCount> findList(PageView<Pl5GuilvRemoveCount> pv, List<PropertyFilter> filters);

	Pl5GuilvRemoveCount findGuilv(Long id);

	Pl5GuilvRemoveCount findGuilv(Object p, Object v);
	Pl5GuilvRemoveCount findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvRemoveCount> findList(Object p, Object v);
}
