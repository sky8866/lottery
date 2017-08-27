package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDouble;
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;

public interface GuilvSingleDoubleService {

	void saveGuilv(GuilvSingleDouble r);
	public void saveGuilvOld(GuilvSingleDoubleOld o);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvSingleDouble r);

	QueryResult<GuilvSingleDouble> findList(PageView<GuilvSingleDouble> pv, List<PropertyFilter> filters);

	GuilvSingleDouble findGuilv(Long id);

	GuilvSingleDouble findGuilv(Object p, Object v);
	GuilvSingleDouble findGuilvs(Object[] p, Object[] v);
	
    List<GuilvSingleDouble> findList(Object p, Object v);
}
