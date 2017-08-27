package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvKill;

public interface Pl5GuilvKillService {

	void saveGuilvKill(Pl5GuilvKill r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(Pl5GuilvKill r);

	QueryResult<Pl5GuilvKill> findList(PageView<Pl5GuilvKill> pv, List<PropertyFilter> filters);

	Pl5GuilvKill findGuilvKill(Long id);

	Pl5GuilvKill findGuilvKill(Object p, Object v);
	Pl5GuilvKill findGuilvKills(Object[] p, Object[] v);
	
    List<Pl5GuilvKill> findList(Object p, Object v);
    
    List<Pl5GuilvKill> findLists(long qi, int value,int type);
    List<Pl5GuilvKill> findLists(long qi, int sum, int type, int number,int addition);
    Pl5GuilvKill   findGuilvKill6(long qi,int type);
    
   
    Pl5GuilvKill   findGuilvKill(long qi, int type,int number,int sum,int addition); 
}
