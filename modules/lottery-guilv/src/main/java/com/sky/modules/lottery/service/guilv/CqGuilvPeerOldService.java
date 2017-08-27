package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilvPeerOld;

public interface CqGuilvPeerOldService {

	void saveGuilv(CqGuilvPeerOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvPeerOld r);

	QueryResult<CqGuilvPeerOld> findList(PageView<CqGuilvPeerOld> pv, List<PropertyFilter> filters);

	CqGuilvPeerOld findGuilv(Long id);

	CqGuilvPeerOld findGuilv(Object p, Object v);
	CqGuilvPeerOld findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvPeerOld> findList(Object p, Object v);
}
