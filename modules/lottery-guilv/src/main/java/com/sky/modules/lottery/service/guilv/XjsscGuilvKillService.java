package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvKill;

public interface XjsscGuilvKillService {

	void saveGuilvKill(XjsscGuilvKill r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(XjsscGuilvKill r);

	QueryResult<XjsscGuilvKill> findList(PageView<XjsscGuilvKill> pv, List<PropertyFilter> filters);

	XjsscGuilvKill findGuilvKill(Long id);

	XjsscGuilvKill findGuilvKill(Object p, Object v);
	XjsscGuilvKill findGuilvKills(Object[] p, Object[] v);
	
    List<XjsscGuilvKill> findList(Object p, Object v);
    
    List<XjsscGuilvKill> findLists(long qi, int value,int type);
    List<XjsscGuilvKill> findLists(long qi, int sum, int type, int number,int addition);
    XjsscGuilvKill   findGuilvKill4(long qi,int type);
    
   
    XjsscGuilvKill   findGuilvKill(long qi, int type,int number,int sum,int addition); 
}
