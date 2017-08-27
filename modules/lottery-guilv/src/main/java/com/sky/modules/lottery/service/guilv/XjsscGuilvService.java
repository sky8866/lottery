package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.TjsscGuilv;
import com.sky.modules.lottery.entity.guilv.XjsscGuilv;

public interface XjsscGuilvService {

	void saveGuilvKill(XjsscGuilv r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(XjsscGuilv r);

	QueryResult<XjsscGuilv> findList(PageView<XjsscGuilv> pv, List<PropertyFilter> filters);

	XjsscGuilv findGuilvKill(Long id);

	XjsscGuilv findGuilvKill(Object p, Object v);
	XjsscGuilv findGuilvKills(Object[] p, Object[] v);
	
    List<XjsscGuilv> findList(Object p, Object v);
    
    List<XjsscGuilv> findLists(long qi, int value,int type);
    List<XjsscGuilv> findLists2(long qi,int type,int sum);
    List<XjsscGuilv> findLists3(long qi,int type,int sum);
    List<XjsscGuilv> findLists4(long qi,int type,int sum);
    
    
    List<XjsscGuilv> findLists(long qi, int sum, int type, int number,int addition);
    XjsscGuilv   findGuilvKill3(long qi,int type);
    
   
    XjsscGuilv   findGuilvKill(long qi, int type,int number,int sum,int addition); 
    List<XjsscGuilv> findLists5( int type,int count);
}
