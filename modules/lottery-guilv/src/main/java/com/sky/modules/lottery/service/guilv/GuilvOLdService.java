package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvOld;

public interface GuilvOLdService {

	void saveGuilv(GuilvOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvOld r);

	QueryResult<GuilvOld> findList(PageView<GuilvOld> pv, List<PropertyFilter> filters);

	GuilvOld findGuilv(Long id);

	GuilvOld findGuilv(Object p, Object v);
	GuilvOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvOld> findList(Object p, Object v);
}
