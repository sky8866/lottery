package com.sky.modules.lottery.service.impl.guilv;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.Pl5PlanDao; 
import com.sky.modules.lottery.entity.guilv.Pl5Plan;
import com.sky.modules.lottery.service.guilv.Pl5PlanService; 
 
@Service
public class Pl5PlanServiceImpl implements Pl5PlanService {
     @Autowired private Pl5PlanDao planDao;
	@Override
	public void savePlan(Pl5Plan r) {
		this.planDao.save(r); 
		
	}

	@Override
	public void delPlan(Long entityids) {
	    this.planDao.delete(entityids);
		
	}

	@Override
	public void updatePlan(Pl5Plan r) {
		 this.planDao.update(r);
		
	}

	@Override
	public QueryResult<Pl5Plan> findList(PageView<Pl5Plan> pv,
			List<PropertyFilter> filters) {
		 
		return this.planDao.findPage(pv, filters);
	}

	@Override
	public Pl5Plan findPlan(Long id) {
		
		return this.planDao.find(id);
	}

	@Override
	public Pl5Plan findPlan(Object p, Object v) {
		 
		return this.planDao.findProperty(p, v);
	}

	@Override
	public List<Pl5Plan> findIntegers(Object p, Object v) {
	 
		return this.planDao.findPropertyList(p, v);
	}

	@Override
	public List<Pl5Plan> findIntegers() {
	 
		return null;
	}

	@Override
	public Pl5Plan findPlan(long qi, int type) {
		
		Object[] p=new Object[2];
		p[0]="qi";
		p[1]="type";
		
		Object[] o=new Object[2];
		o[0]=qi;
		o[1]=type;
		 
		return this.planDao.findPropertys(p, o);
	}
	

	
}
