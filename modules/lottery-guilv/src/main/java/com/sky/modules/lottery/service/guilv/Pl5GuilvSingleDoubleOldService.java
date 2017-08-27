package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSingleDoubleOld;

public interface Pl5GuilvSingleDoubleOldService {

	void saveGuilv(Pl5GuilvSingleDoubleOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvSingleDoubleOld r);

	QueryResult<Pl5GuilvSingleDoubleOld> findList(PageView<Pl5GuilvSingleDoubleOld> pv, List<PropertyFilter> filters);

	Pl5GuilvSingleDoubleOld findGuilv(Long id);

	Pl5GuilvSingleDoubleOld findGuilv(Object p, Object v);
	Pl5GuilvSingleDoubleOld findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvSingleDoubleOld> findList(Object p, Object v);
}
