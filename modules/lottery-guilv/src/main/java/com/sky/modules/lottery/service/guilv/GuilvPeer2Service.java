package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer2; 

public interface GuilvPeer2Service {

	void saveGuilv(GuilvPeer2 r); 
	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeer2 r);

	QueryResult<GuilvPeer2> findList(PageView<GuilvPeer2> pv, List<PropertyFilter> filters);

	GuilvPeer2 findGuilv(Long id);

	GuilvPeer2 findGuilv(Object p, Object v);
	GuilvPeer2 findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeer2> findList(Object p, Object v);
}
