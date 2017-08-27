package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.entity.guilv.CqsscGuilv; 
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
@Service
public class CqsscGuilvServiceImpl implements CqsscGuilvService {
	@Autowired private com.sky.modules.lottery.dao.guilv.CqsscGuilvDao GuilvKillDao; 

	@Override
	public void saveGuilvKill(CqsscGuilv r) {
		try {
			 this.GuilvKillDao.save(r);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	 

	@Override
	public void delGuilvKill(Serializable... entityids) {
		this.GuilvKillDao.delete(entityids);
		
	}

	@Override
	public void updateGuilvKill(CqsscGuilv r) {
	    this.GuilvKillDao.update(r);
		
	}

	@Override
	public QueryResult<CqsscGuilv> findList(PageView<CqsscGuilv> pv,
			List<PropertyFilter> filters) {
	 
		return this.GuilvKillDao.findPage(pv, filters);
	}

	@Override
	public CqsscGuilv findGuilvKill(Long id) {
		 
		return this.GuilvKillDao.find(id);
	}

 

	@Override
	public CqsscGuilv findGuilvKills(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.GuilvKillDao.findPropertys(p, v);
	}
 
	
	
	@Override
	public List<CqsscGuilv> findLists(int qi, int value,int type,String typeLottery) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>();
		   
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses3.add(new PropertyFilter("value", MatchType.EQ, value+""));
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("typeLottery", MatchType.EQ, typeLottery));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public CqsscGuilv findGuilvKill(int qi,int type,String typeLottery) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi)); 
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.LT, 6));
			filtersnewses3.add(new PropertyFilter("typeLottery", MatchType.EQ, typeLottery));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
			CqsscGuilv kill=null;      
	       if(!guilvs3.isEmpty()){
	    	   kill=guilvs3.get(0) ;
	       }
		return kill;
	}
	@Override
	public List<CqsscGuilv> findLists(int qi,int type,String typeLottery) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.EQ, 1));
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("typeLottery", MatchType.EQ, typeLottery));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public List<CqsscGuilv> findLists2(int qi,int type,int sum,String typeLottery) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses3.add(new PropertyFilter("typeLottery", MatchType.EQ, typeLottery));
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.LT, 6));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
	@Override
	public List<CqsscGuilv> findLists3(int qi,int type,int sum,String typeLottery) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses3.add(new PropertyFilter("typeLottery", MatchType.EQ, typeLottery));
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.EQ, sum));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public List<CqsscGuilv> findLists4(int qi,int type,int sum,String typeLottery) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			filtersnewses3.add(new PropertyFilter("typeLottery", MatchType.EQ, typeLottery));
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.GT, sum));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public List<CqsscGuilv> findLists5(int type,int count) {
		PageView<CqsscGuilv> pageViewGuilv3 = new PageView<CqsscGuilv>(count,1);
		pageViewGuilv3.setOrderby("errorSum", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			 
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type)); 
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
}
