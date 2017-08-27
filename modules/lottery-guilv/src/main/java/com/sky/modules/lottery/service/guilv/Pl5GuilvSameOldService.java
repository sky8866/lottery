package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSameOld;

public interface Pl5GuilvSameOldService {

	void saveGuilv(Pl5GuilvSameOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvSameOld r);

	QueryResult<Pl5GuilvSameOld> findList(PageView<Pl5GuilvSameOld> pv, List<PropertyFilter> filters);

	Pl5GuilvSameOld findGuilv(Long id);

	Pl5GuilvSameOld findGuilv(Object p, Object v);
	Pl5GuilvSameOld findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvSameOld> findList(Object p, Object v);
    List<Pl5GuilvSameOld> findList();
}
