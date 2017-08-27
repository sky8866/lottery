package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit2Old;
 

public interface GuilvLimit2OldService {

	void saveGuilv(GuilvLimit2Old r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvLimit2Old r);

	QueryResult<GuilvLimit2Old> findList(PageView<GuilvLimit2Old> pv, List<PropertyFilter> filters);

	GuilvLimit2Old findGuilv(Long id);

	GuilvLimit2Old findGuilv(Object p, Object v);
	GuilvLimit2Old findGuilvs(Object[] p, Object[] v);
	
    List<GuilvLimit2Old> findList(Object p, Object v);
}
