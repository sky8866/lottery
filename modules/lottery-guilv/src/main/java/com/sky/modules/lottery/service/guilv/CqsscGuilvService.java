package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;

public interface CqsscGuilvService {

	void saveGuilvKill(CqsscGuilv r);

	void delGuilvKill(Serializable... long1);

	void updateGuilvKill(CqsscGuilv r);

	QueryResult<CqsscGuilv> findList(PageView<CqsscGuilv> pv, List<PropertyFilter> filters);

	CqsscGuilv findGuilvKill(Long id);
 
	CqsscGuilv findGuilvKills(Object[] p, Object[] v);
	 
    
    List<CqsscGuilv> findLists(int qi, int value,int type,String typeLottery);
    List<CqsscGuilv> findLists(int qi,int type,String typeLottery);
    List<CqsscGuilv> findLists2(int qi,int type,int sum,String typeLottery);
    List<CqsscGuilv> findLists3(int qi,int type,int sum,String typeLottery);
    List<CqsscGuilv> findLists4(int qi,int type,int sum,String typeLottery);
    CqsscGuilv findGuilvKill(int qi,int type,String typeLottery);

	List<CqsscGuilv> findLists5( int type,int count);
}
