package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.TjsscGuilv;

public interface TjsscGuilvService {

	void saveGuilvKill(TjsscGuilv r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(TjsscGuilv r);

	QueryResult<TjsscGuilv> findList(PageView<TjsscGuilv> pv, List<PropertyFilter> filters);

	TjsscGuilv findGuilvKill(Long id);

	TjsscGuilv findGuilvKill(Object p, Object v);
	TjsscGuilv findGuilvKills(Object[] p, Object[] v);
	
    List<TjsscGuilv> findList(Object p, Object v);
    
    List<TjsscGuilv> findLists(long qi, int value,int type);
    List<TjsscGuilv> findLists2(long qi,int type,int sum);
    List<TjsscGuilv> findLists3(long qi,int type,int sum);
    List<TjsscGuilv> findLists4(long qi,int type,int sum);
    
    
    List<TjsscGuilv> findLists(long qi, int sum, int type, int number,int addition);
    TjsscGuilv   findGuilvKill7(long qi,int type);
    
   
    TjsscGuilv   findGuilvKill(long qi, int type,int number,int sum,int addition); 
    List<TjsscGuilv> findLists5( int type,int count);
}
