package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvLimit;
 

public interface XjsscGuilvLimitService {

	void saveGuilv(XjsscGuilvLimit r);

	void delGuilv(Serializable... long1);

	void updateGuilv(XjsscGuilvLimit r);

	QueryResult<XjsscGuilvLimit> findList(PageView<XjsscGuilvLimit> pv, List<PropertyFilter> filters);

	XjsscGuilvLimit findGuilv(Long id);

	XjsscGuilvLimit findGuilv(Object p, Object v);
	XjsscGuilvLimit findGuilvs(Object[] p, Object[] v);
	
    List<XjsscGuilvLimit> findList(Object p, Object v);
}
