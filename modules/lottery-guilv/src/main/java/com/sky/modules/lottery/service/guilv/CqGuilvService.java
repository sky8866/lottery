package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqGuilv;

public interface CqGuilvService {

	void saveGuilvKill(CqGuilv r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(CqGuilv r);

	QueryResult<CqGuilv> findList(PageView<CqGuilv> pv, List<PropertyFilter> filters);

	CqGuilv findGuilvKill(Long id);

	CqGuilv findGuilvKill(Object p, Object v);
	CqGuilv findGuilvKills(Object[] p, Object[] v);
	
    List<CqGuilv> findList(Object p, Object v);
    
    List<CqGuilv> findLists(long qi, int value,int type);
    List<CqGuilv> findLists2(long qi,int type,int sum);
    List<CqGuilv> findLists3(long qi,int type,int sum);
    List<CqGuilv> findLists4(long qi,int type,int sum);
    
    
    List<CqGuilv> findLists(long qi, int sum, int type, int number,int addition);
    CqGuilv   findGuilvKill5(long qi,int type);
    
   
    CqGuilv   findGuilvKill(long qi, int type,int number,int sum,int addition); 
}
