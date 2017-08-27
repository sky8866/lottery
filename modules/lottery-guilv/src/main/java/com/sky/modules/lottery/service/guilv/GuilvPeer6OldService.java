package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.GuilvPeer6Old;

public interface GuilvPeer6OldService {

	void saveGuilv(GuilvPeer6Old r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeer6Old r);

	QueryResult<GuilvPeer6Old> findList(PageView<GuilvPeer6Old> pv, List<PropertyFilter> filters);

	GuilvPeer6Old findGuilv(Long id);

	GuilvPeer6Old findGuilv(Object p, Object v);
	GuilvPeer6Old findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeer6Old> findList(Object p, Object v);
}
