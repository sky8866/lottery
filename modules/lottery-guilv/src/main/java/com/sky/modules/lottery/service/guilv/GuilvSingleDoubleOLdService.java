package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;

public interface GuilvSingleDoubleOLdService {

	void saveGuilv(GuilvSingleDoubleOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvSingleDoubleOld r);

	QueryResult<GuilvSingleDoubleOld> findList(PageView<GuilvSingleDoubleOld> pv, List<PropertyFilter> filters);

	GuilvSingleDoubleOld findGuilv(Long id);

	GuilvSingleDoubleOld findGuilv(Object p, Object v);
	GuilvSingleDoubleOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvSingleDoubleOld> findList(Object p, Object v);
}
