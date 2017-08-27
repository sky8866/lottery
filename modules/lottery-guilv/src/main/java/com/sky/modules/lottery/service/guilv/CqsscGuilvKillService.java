package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvKill;

public interface CqsscGuilvKillService {

	void saveGuilvKill(CqsscGuilvKill r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(CqsscGuilvKill r);

	QueryResult<CqsscGuilvKill> findList(PageView<CqsscGuilvKill> pv, List<PropertyFilter> filters);

	CqsscGuilvKill findGuilvKill(Long id);

	CqsscGuilvKill findGuilvKill(Object p, Object v);
	CqsscGuilvKill findGuilvKills(Object[] p, Object[] v);
	
    List<CqsscGuilvKill> findList(Object p, Object v);
    
    List<CqsscGuilvKill> findLists(int qi, int value,int type);
    List<CqsscGuilvKill> findLists(int qi, int sum, int type, int number,int addition);
    CqsscGuilvKill   findGuilvKill2(int qi,int type);
    
   
    CqsscGuilvKill   findGuilvKill(int qi, int type,int number,int sum,int addition); 
}
