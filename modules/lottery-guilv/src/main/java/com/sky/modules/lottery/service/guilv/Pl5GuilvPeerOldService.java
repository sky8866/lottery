package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeerOld;

public interface Pl5GuilvPeerOldService {

	void saveGuilv(Pl5GuilvPeerOld r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvPeerOld r);

	QueryResult<Pl5GuilvPeerOld> findList(PageView<Pl5GuilvPeerOld> pv, List<PropertyFilter> filters);

	Pl5GuilvPeerOld findGuilv(Long id);

	Pl5GuilvPeerOld findGuilv(Object p, Object v);
	Pl5GuilvPeerOld findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvPeerOld> findList(Object p, Object v);
}
