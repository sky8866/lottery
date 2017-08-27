package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSizeOld;

public interface Pl5GuilvSizeOldService {

	void saveGuilv(Pl5GuilvSizeOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvSizeOld r);

	QueryResult<Pl5GuilvSizeOld> findList(PageView<Pl5GuilvSizeOld> pv, List<PropertyFilter> filters);

	Pl5GuilvSizeOld findGuilv(Long id);

	Pl5GuilvSizeOld findGuilv(Object p, Object v);
	Pl5GuilvSizeOld findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvSizeOld> findList(Object p, Object v);
}
