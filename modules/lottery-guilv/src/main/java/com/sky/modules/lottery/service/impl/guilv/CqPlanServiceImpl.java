package com.sky.modules.lottery.service.impl.guilv;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.CqPlanDao; 
import com.sky.modules.lottery.entity.guilv.CqPlan;
import com.sky.modules.lottery.service.guilv.CqPlanService;
 
@Service
public class CqPlanServiceImpl implements CqPlanService {
     @Autowired private CqPlanDao planDao;
	@Override
	public void savePlan(CqPlan r) {
		this.planDao.save(r); 
		
	}

	@Override
	public void delPlan(Long entityids) {
	    this.planDao.delete(entityids);
		
	}

	@Override
	public void updatePlan(CqPlan r) {
		 this.planDao.update(r);
		
	}

	@Override
	public QueryResult<CqPlan> findList(PageView<CqPlan> pv,
			List<PropertyFilter> filters) {
		 
		return this.planDao.findPage(pv, filters);
	}

	@Override
	public CqPlan findPlan(Long id) {
		
		return this.planDao.find(id);
	}

	@Override
	public CqPlan findPlan(Object p, Object v) {
		 
		return this.planDao.findProperty(p, v);
	}

	@Override
	public List<CqPlan> findIntegers(Object p, Object v) {
	 
		return this.planDao.findPropertyList(p, v);
	}

	@Override
	public List<CqPlan> findIntegers() {
		PageView<CqPlan> pageViewGuilv3 = new PageView<CqPlan>();
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("value", MatchType.NULL, null));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqPlan> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}

	@Override
	public CqPlan findPlan(long qi, int type) {
		
		Object[] p=new Object[2];
		p[0]="qi";
		p[1]="type";
		
		Object[] o=new Object[2];
		o[0]=qi;
		o[1]=type;
		 
		return this.planDao.findPropertys(p, o);
	}
	
	@Override
	public CqPlan findPlan(int type) {
		PageView<CqPlan> pageViewGuilv3 = new PageView<CqPlan>(1,1);
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqPlan> guilvs3 = pageViewGuilv3.getRecords();
			CqPlan plan=null;
			if(!guilvs3.isEmpty()){
				  plan=guilvs3.get(0);
			}
			return plan;
			
	}
	
}
