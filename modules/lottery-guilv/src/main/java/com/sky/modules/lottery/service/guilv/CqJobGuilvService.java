package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqJobGuilv;

public interface CqJobGuilvService {

	void saveGuilvKill(CqJobGuilv r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(CqJobGuilv r);

	QueryResult<CqJobGuilv> findList(PageView<CqJobGuilv> pv, List<PropertyFilter> filters);

	CqJobGuilv findGuilvKill(Long id);

	CqJobGuilv findGuilvKill(Object p, Object v); 
}
