package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.Pl5Guilv;

public interface Pl5GuilvService {

	void saveGuilvKill(Pl5Guilv r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(Pl5Guilv r);

	QueryResult<Pl5Guilv> findList(PageView<Pl5Guilv> pv, List<PropertyFilter> filters);

	Pl5Guilv findGuilvKill(Long id);

	Pl5Guilv findGuilvKill(Object p, Object v);
	Pl5Guilv findGuilvKills(Object[] p, Object[] v);
	
    List<Pl5Guilv> findList(Object p, Object v);
    
    List<Pl5Guilv> findLists(long qi, int value,int type);
    List<Pl5Guilv> findLists2(long qi,int type,int sum);
    List<Pl5Guilv> findLists3(long qi,int type,int sum);
    List<Pl5Guilv> findLists4(long qi,int type,int sum);
    
    
    List<Pl5Guilv> findLists(long qi, int sum, int type, int number,int addition);
    Pl5Guilv   findGuilvKill5(long qi,int type);
    
   
    Pl5Guilv   findGuilvKill(long qi, int type,int number,int sum,int addition); 
}
