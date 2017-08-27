package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.GuilvSame;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;

public interface GuilvSameService {

	void saveGuilvSame(GuilvSame r);
	public void saveGuilvSameOld(GuilvSameOld o);

	void delGuilvSame(Serializable... long1);

	void updateGuilvSame(GuilvSame r);

	QueryResult<GuilvSame> findList(PageView<GuilvSame> pv, List<PropertyFilter> filters);

	GuilvSame findGuilvSame(Long id);

	GuilvSame findGuilvSame(Object p, Object v);
	GuilvSame findGuilvSames(Object[] p, Object[] v);
	
    List<GuilvSame> findList(Object p, Object v);
    List<GuilvSame> findList();
}
