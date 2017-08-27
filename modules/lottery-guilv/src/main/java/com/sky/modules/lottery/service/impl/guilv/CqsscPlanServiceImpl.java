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
import com.sky.modules.lottery.dao.guilv.PlanDao;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
 
@Service
public class CqsscPlanServiceImpl implements CqsscPlanService {
     @Autowired private PlanDao planDao;
	@Override
	public void savePlan(CqsscPlan r) {
		this.planDao.save(r); 
		
	}

	@Override
	public void delPlan(Long entityids) {
	    this.planDao.delete(entityids);
		
	}

	@Override
	public void updatePlan(CqsscPlan r) {
		 this.planDao.update(r);
		
	}

	@Override
	public QueryResult<CqsscPlan> findList(PageView<CqsscPlan> pv,
			List<PropertyFilter> filters) {
		 
		return this.planDao.findPage(pv, filters);
	}

	@Override
	public CqsscPlan findPlan(Long id) {
		
		return this.planDao.find(id);
	}

	@Override
	public CqsscPlan findPlan(Object p, Object v) {
		 
		return this.planDao.findProperty(p, v);
	}

	@Override
	public List<CqsscPlan> findIntegers(Object p, Object v) {
	 
		return this.planDao.findPropertyList(p, v);
	}

	@Override
	public List<CqsscPlan> findIntegers() {
		PageView<CqsscPlan> pageViewGuilv3 = new PageView<CqsscPlan>();
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("type2", MatchType.EQ, 0));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscPlan> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}

	@Override
	public CqsscPlan findPlan(int qi, int type) {
		
		Object[] p=new Object[2];
		p[0]="qi";
		p[1]="type";
		
		Object[] o=new Object[2];
		o[0]=qi;
		o[1]=type;
		 
		return this.planDao.findPropertys(p, o);
	}
	
	@Override
	public CqsscPlan findPlan(int type) {
		PageView<CqsscPlan> pageViewGuilv3 = new PageView<CqsscPlan>(1,1);
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<CqsscPlan> guilvs3 = pageViewGuilv3.getRecords();
			CqsscPlan plan=null;
			if(!guilvs3.isEmpty()){
				  plan=guilvs3.get(0);
			}
			return plan;
			
	}
	
}
