package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvPeerCount;

public interface GuilvPeerCountService {

	void saveGuilv(GuilvPeerCount r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeerCount r);

	QueryResult<GuilvPeerCount> findList(PageView<GuilvPeerCount> pv, List<PropertyFilter> filters);

	GuilvPeerCount findGuilv(Long id);

	GuilvPeerCount findGuilv(Object p, Object v);
	GuilvPeerCount findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeerCount> findList(Object p, Object v);
}
