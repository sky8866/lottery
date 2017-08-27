package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;

public interface GuilvSameOldService {

	void saveGuilv(GuilvSameOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvSameOld r);

	QueryResult<GuilvSameOld> findList(PageView<GuilvSameOld> pv, List<PropertyFilter> filters);

	GuilvSameOld findGuilv(Long id);

	GuilvSameOld findGuilv(Object p, Object v);
	GuilvSameOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvSameOld> findList(Object p, Object v);
    List<GuilvSameOld> findList();
}
