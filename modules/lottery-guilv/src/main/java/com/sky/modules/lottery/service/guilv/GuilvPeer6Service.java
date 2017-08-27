package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer6;
import com.sky.modules.lottery.entity.guilv.GuilvPeer6Old;

public interface GuilvPeer6Service {

	void saveGuilv(GuilvPeer6 r);
	public void saveGuilvPeer6Old(GuilvPeer6Old r) ;
	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeer6 r);

	QueryResult<GuilvPeer6> findList(PageView<GuilvPeer6> pv, List<PropertyFilter> filters);

	GuilvPeer6 findGuilv(Long id);

	GuilvPeer6 findGuilv(Object p, Object v);
	GuilvPeer6 findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeer6> findList(Object p, Object v);
}
