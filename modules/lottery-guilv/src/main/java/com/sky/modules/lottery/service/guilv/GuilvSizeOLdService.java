package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.entity.guilv.GuilvSizeOld;

public interface GuilvSizeOLdService {

	void saveGuilv(GuilvSizeOld r);
	public void saveGuilvOld(GuilvSizeOld o);
	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvSizeOld r);

	QueryResult<GuilvSizeOld> findList(PageView<GuilvSizeOld> pv, List<PropertyFilter> filters);

	GuilvSizeOld findGuilv(Long id);

	GuilvSizeOld findGuilv(Object p, Object v);
	GuilvSizeOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvSizeOld> findList(Object p, Object v);
}
