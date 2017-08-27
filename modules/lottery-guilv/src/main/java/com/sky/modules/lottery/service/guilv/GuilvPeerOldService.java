package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;

public interface GuilvPeerOldService {

	void saveGuilv(GuilvPeerOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeerOld r);

	QueryResult<GuilvPeerOld> findList(PageView<GuilvPeerOld> pv, List<PropertyFilter> filters);

	GuilvPeerOld findGuilv(Long id);

	GuilvPeerOld findGuilv(Object p, Object v);
	GuilvPeerOld findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeerOld> findList(Object p, Object v);
}
