package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvPeer3Old;

public interface Pl5GuilvPeer3OldService {

	void saveGuilv(Pl5GuilvPeer3Old r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvPeer3Old r);

	QueryResult<Pl5GuilvPeer3Old> findList(PageView<Pl5GuilvPeer3Old> pv, List<PropertyFilter> filters);

	Pl5GuilvPeer3Old findGuilv(Long id);

	Pl5GuilvPeer3Old findGuilv(Object p, Object v);
	Pl5GuilvPeer3Old findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvPeer3Old> findList(Object p, Object v);
}
