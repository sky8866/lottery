package com.sky.modules.lottery.service.impl.guilv;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.QxcPlanDao; 
import com.sky.modules.lottery.entity.guilv.QxcPlan;
import com.sky.modules.lottery.service.guilv.QxcPlanService; 
 
@Service
public class QxcPlanServiceImpl implements QxcPlanService {
     @Autowired private QxcPlanDao planDao;
	@Override
	public void savePlan(QxcPlan r) {
		this.planDao.save(r); 
		
	}

	@Override
	public void delPlan(Long entityids) {
	    this.planDao.delete(entityids);
		
	}

	@Override
	public void updatePlan(QxcPlan r) {
		 this.planDao.update(r);
		
	}

	@Override
	public QueryResult<QxcPlan> findList(PageView<QxcPlan> pv,
			List<PropertyFilter> filters) {
		 
		return this.planDao.findPage(pv, filters);
	}

	@Override
	public QxcPlan findPlan(Long id) {
		
		return this.planDao.find(id);
	}

	@Override
	public QxcPlan findPlan(Object p, Object v) {
		 
		return this.planDao.findProperty(p, v);
	}

	@Override
	public List<QxcPlan> findIntegers(Object p, Object v) {
	 
		return this.planDao.findPropertyList(p, v);
	}

	@Override
	public List<QxcPlan> findIntegers() {
	 
		return null;
	}

	@Override
	public QxcPlan findPlan(long qi, int type) {
		
		Object[] p=new Object[2];
		p[0]="qi";
		p[1]="type";
		
		Object[] o=new Object[2];
		o[0]=qi;
		o[1]=type;
		 
		return this.planDao.findPropertys(p, o);
	}
	

	
}
