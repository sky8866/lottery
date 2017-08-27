package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;

public interface GuilvPeerService {

	void saveGuilv(GuilvPeer r);
	public void saveGuilvPeerOld(GuilvPeerOld r) ;
	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeer r);

	QueryResult<GuilvPeer> findList(PageView<GuilvPeer> pv, List<PropertyFilter> filters);

	GuilvPeer findGuilv(Long id);

	GuilvPeer findGuilv(Object p, Object v);
	GuilvPeer findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeer> findList(Object p, Object v);
}
