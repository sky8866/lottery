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
import com.sky.modules.lottery.entity.guilv.XjsscGuilv;
import com.sky.modules.lottery.service.guilv.XjsscGuilvService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvService;
@Service
public class XjsscGuilvServiceImpl implements XjsscGuilvService {
	@Autowired private com.sky.modules.lottery.dao.guilv.XjsscGuilvDao GuilvKillDao; 

	@Override
	public void saveGuilvKill(XjsscGuilv r) {
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
	public void updateGuilvKill(XjsscGuilv r) {
	    this.GuilvKillDao.update(r);
		
	}

	@Override
	public QueryResult<XjsscGuilv> findList(PageView<XjsscGuilv> pv,
			List<PropertyFilter> filters) {
	 
		return this.GuilvKillDao.findPage(pv, filters);
	}

	@Override
	public XjsscGuilv findGuilvKill(Long id) {
		 
		return this.GuilvKillDao.find(id);
	}

	@Override
	public XjsscGuilv findGuilvKill(Object p, Object v) {
		 
		return this.GuilvKillDao.findProperty(p, v);
	}

	@Override
	public XjsscGuilv findGuilvKills(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.GuilvKillDao.findPropertys(p, v);
	}

	@Override
	public List<XjsscGuilv> findList(Object p, Object v) {
 
		return this.GuilvKillDao.findPropertyList(p, v);
	}
	@Override
	public List<XjsscGuilv> findLists(long qi, int value,int type) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		   
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("value", MatchType.EQ, value+""));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, 1));
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
	
 
	return guilvs3;
	}


	@Override
	public XjsscGuilv findGuilvKill3(long qi, int type) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, 1));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, 3));
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
		XjsscGuilv kill2=null;
		for(XjsscGuilv k:guilvs3){
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
	public XjsscGuilv findGuilvKill(long qi, int type,int number,int sum,int addition) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, number));

		filtersnewses3.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, sum));
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
		XjsscGuilv kill2=null;
		for(XjsscGuilv k:guilvs3){
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
	public List<XjsscGuilv> findLists(long qi, int sum, int type, int number,int addition) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		 pageViewGuilv3.setOrderby("sum", "desc");
		List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
		filtersnewses3.add(new PropertyFilter("number", MatchType.EQ, number));
		filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
		filtersnewses3.add(new PropertyFilter("addition", MatchType.EQ, addition));
		filtersnewses3.add(new PropertyFilter("sum", MatchType.GE, sum));
		
		pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
				filtersnewses3));
		List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}


	@Override
	public List<XjsscGuilv> findLists2(long qi,int type,int sum) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.LT, 6));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
	@Override
	public List<XjsscGuilv> findLists3(long qi,int type,int sum) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.EQ, sum));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	@Override
	public List<XjsscGuilv> findLists4(long qi,int type,int sum) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		pageViewGuilv3.setOrderby("errorCou", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("qi", MatchType.EQ, qi));
			
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			filtersnewses3.add(new PropertyFilter("sum", MatchType.GT, sum));
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}


	@Override
	public List<XjsscGuilv> findLists5(int type, int count) {
		PageView<XjsscGuilv> pageViewGuilv3 = new PageView<XjsscGuilv>();
		pageViewGuilv3.setOrderby("errorSum", "asc");
			List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
		 
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type)); 
			pageViewGuilv3.setQueryResult(GuilvKillDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<XjsscGuilv> guilvs3 = pageViewGuilv3.getRecords();
		
	    
		return guilvs3;
	}
	
	
}
