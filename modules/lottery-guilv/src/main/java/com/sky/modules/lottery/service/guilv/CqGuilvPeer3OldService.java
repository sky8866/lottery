package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilvPeer3Old;

public interface CqGuilvPeer3OldService {

	void saveGuilv(CqGuilvPeer3Old r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvPeer3Old r);

	QueryResult<CqGuilvPeer3Old> findList(PageView<CqGuilvPeer3Old> pv, List<PropertyFilter> filters);

	CqGuilvPeer3Old findGuilv(Long id);

	CqGuilvPeer3Old findGuilv(Object p, Object v);
	CqGuilvPeer3Old findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvPeer3Old> findList(Object p, Object v);
}
