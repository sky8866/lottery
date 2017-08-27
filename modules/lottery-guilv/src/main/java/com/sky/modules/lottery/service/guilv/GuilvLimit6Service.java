package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit6;
 

public interface GuilvLimit6Service {

	void saveGuilv(GuilvLimit6 r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvLimit6 r);

	QueryResult<GuilvLimit6> findList(PageView<GuilvLimit6> pv, List<PropertyFilter> filters);

	GuilvLimit6 findGuilv(Long id);

	GuilvLimit6 findGuilv(Object p, Object v);
	GuilvLimit6 findGuilvs(Object[] p, Object[] v);
	
    List<GuilvLimit6> findList(Object p, Object v);
}
