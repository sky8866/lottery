package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;

public interface GuilvPeer3OldService {

	void saveGuilv(GuilvPeer3Old r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeer3Old r);

	QueryResult<GuilvPeer3Old> findList(PageView<GuilvPeer3Old> pv, List<PropertyFilter> filters);

	GuilvPeer3Old findGuilv(Long id);

	GuilvPeer3Old findGuilv(Object p, Object v);
	GuilvPeer3Old findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeer3Old> findList(Object p, Object v);
}
