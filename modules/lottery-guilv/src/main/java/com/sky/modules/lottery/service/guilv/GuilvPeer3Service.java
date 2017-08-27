package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer3;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;

public interface GuilvPeer3Service {

	void saveGuilv(GuilvPeer3 r);
	public void saveGuilvPeer3Old(GuilvPeer3Old r) ;
	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvPeer3 r);

	QueryResult<GuilvPeer3> findList(PageView<GuilvPeer3> pv, List<PropertyFilter> filters);

	GuilvPeer3 findGuilv(Long id);

	GuilvPeer3 findGuilv(Object p, Object v);
	GuilvPeer3 findGuilvs(Object[] p, Object[] v);
	
    List<GuilvPeer3> findList(Object p, Object v);
}
