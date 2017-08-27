package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.TJsscGuilvKill;

public interface TJsscGuilvKillService {

	void saveGuilvKill(TJsscGuilvKill r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(TJsscGuilvKill r);

	QueryResult<TJsscGuilvKill> findList(PageView<TJsscGuilvKill> pv, List<PropertyFilter> filters);

	TJsscGuilvKill findGuilvKill(Long id);

	TJsscGuilvKill findGuilvKill(Object p, Object v);
	TJsscGuilvKill findGuilvKills(Object[] p, Object[] v);
	
    List<TJsscGuilvKill> findList(Object p, Object v);
    
    List<TJsscGuilvKill> findLists(long qi, int value,int type);
    List<TJsscGuilvKill> findLists(long qi, int sum, int type, int number,int addition);
    TJsscGuilvKill   findGuilvKill8(long qi,int type);
    
   
    TJsscGuilvKill   findGuilvKill(long qi, int type,int number,int sum,int addition); 
}
