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
import com.sky.modules.lottery.entity.guilv.CqGuilv;
import com.sky.modules.lottery.service.guilv.CqGuilvService; 
@Service
public class CqGuilvServiceImpl implements CqGuilvService {
	@Autowired private com.sky.modules.lottery.dao.guilv.CqGuilvDao guilvDao; 

	@Override
	public void saveGuilvKill(CqGuilv r) {
		try {
			 this.guilvDao.save(r);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	 

	@Override
	public void delGuilvKill(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilvKill(CqGuilv r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilv> findList(PageView<CqGuilv> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilv findGuilvKill(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilv findGuilvKill(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilv findGuilvKills(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilv> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}
	@Override
	public List<CqGuilv> findLists(long qi, int value,int type) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		   
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("value", MatchType.EQ, value+""));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, 1));
		pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
	
 
	return guilvs3;
	}


	@Override
	public CqGuilv findGuilvKill5(long qi, int type) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, 1));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, 3));
		pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
		CqGuilv kill2=null;
		for(CqGuilv k:guilvs3){
			if(k.getSum()>3){
				kill2=k;
				break;	
			}
			
			if(k.getAddition()==2){
				kill2=k;
				break;
			}else{
				if(k.getAddition()==3&&k.getSum()>3){
					kill2=k;
					break;
				}
				
			}
			
		}
		return kill2;
	}
	
	
	@Override
	public CqGuilv findGuilvKill(long qi, int type,int number,int sum,int addition) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, number));

		filtersnewses3.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, sum));
		pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
		CqGuilv kill2=null;
		for(CqGuilv k:guilvs3){
			if(k.getSum()>3){
				kill2=k;
				break;	
			}
			
			if(k.getAddition()==2){
				kill2=k;
				break;
			}else{
				if(k.getAddition()==3&&k.getSum()>3){
					kill2=k;
					break;
				}
				
			}
			
		}
		return kill2;
	}
	


	@Override
	public List<CqGuilv> findLists(long qi, int sum, int type, int number,int addition) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, sum));
		
		pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}


	@Override
	public List<CqGuilv> findLists2(long qi,int type,int sum) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.LT, 6));
			pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
	@Override
	public List<CqGuilv> findLists3(long qi,int type,int sum) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.EQ, sum));
			pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public List<CqGuilv> findLists4(long qi,int type,int sum) {
		PageView<CqGuilv> pageViewGuilv3 = new PageView<CqGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.GT, sum));
			pageViewGuilv3.setQueryResult(guilvDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
}
