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
import com.sky.modules.lottery.entity.guilv.Pl5Guilv;
import com.sky.modules.lottery.service.guilv.Pl5GuilvService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
@Service
public class Pl5GuilvServiceImpl implements Pl5GuilvService {
	@Autowired private com.sky.modules.lottery.dao.guilv.Pl5GuilvDao GuilvKillDao; 

	@Override
	public void saveGuilvKill(Pl5Guilv r) {
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
	public void updateGuilvKill(Pl5Guilv r) {
	    this.GuilvKillDao.update(r);
		
	}

	@Override
	public QueryResult<Pl5Guilv> findList(PageView<Pl5Guilv> pv,
			List<PropertyFilter> filters) {
	 
		return this.GuilvKillDao.findPage(pv, filters);
	}

	@Override
	public Pl5Guilv findGuilvKill(Long id) {
		 
		return this.GuilvKillDao.find(id);
	}

	@Override
	public Pl5Guilv findGuilvKill(Object p, Object v) {
		 
		return this.GuilvKillDao.findProperty(p, v);
	}

	@Override
	public Pl5Guilv findGuilvKills(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.GuilvKillDao.findPropertys(p, v);
	}

	@Override
	public List<Pl5Guilv> findList(Object p, Object v) {
 
		return this.GuilvKillDao.findPropertyList(p, v);
	}
	@Override
	public List<Pl5Guilv> findLists(long qi, int value,int type) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		   
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("value", MatchType.EQ, value+""));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, 1));
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
	
 
	return guilvs3;
	}


	@Override
	public Pl5Guilv findGuilvKill5(long qi, int type) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, 1));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, 3));
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
		
		Pl5Guilv kill2=null;
		for(Pl5Guilv k:guilvs3){
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
	public Pl5Guilv findGuilvKill(long qi, int type,int number,int sum,int addition) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, number));

		filtersnewses3.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, sum));
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
		
		Pl5Guilv kill2=null;
		for(Pl5Guilv k:guilvs3){
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
	public List<Pl5Guilv> findLists(long qi, int sum, int type, int number,int addition) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, sum));
		
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}


	@Override
	public List<Pl5Guilv> findLists2(long qi,int type,int sum) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.LT, 6));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
	@Override
	public List<Pl5Guilv> findLists3(long qi,int type,int sum) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.EQ, sum));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public List<Pl5Guilv> findLists4(long qi,int type,int sum) {
		PageView<Pl5Guilv> pageViewGuilv3 = new PageView<Pl5Guilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.GT, sum));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<Pl5Guilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
}
