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
import com.sky.modules.lottery.dao.guilv.XjsscPlanDao;
import com.sky.modules.lottery.dao.guilv.PlanDao;
import com.sky.modules.lottery.entity.guilv.CqsscPlan;
import com.sky.modules.lottery.entity.guilv.XjsscPlan;
import com.sky.modules.lottery.service.guilv.XjsscPlanService;
import com.sky.modules.lottery.service.guilv.CqsscPlanService;
 
@Service
public class XjsscPlanServiceImpl implements XjsscPlanService {
     @Autowired private XjsscPlanDao planDao;
	@Override
	public void savePlan(XjsscPlan r) {
		this.planDao.save(r); 
		
	}

	@Override
	public void delPlan(Long entityids) {
	    this.planDao.delete(entityids);
		
	}

	@Override
	public void updatePlan(XjsscPlan r) {
		 this.planDao.update(r);
		
	}

	@Override
	public QueryResult<XjsscPlan> findList(PageView<XjsscPlan> pv,
			List<PropertyFilter> filters) {
		 
		return this.planDao.findPage(pv, filters);
	}

	@Override
	public XjsscPlan findPlan(Long id) {
		
		return this.planDao.find(id);
	}

	@Override
	public XjsscPlan findPlan(Object p, Object v) {
		 
		return this.planDao.findProperty(p, v);
	}

	@Override
	public List<XjsscPlan> findIntegers(Object p, Object v) {
	 
		return this.planDao.findPropertyList(p, v);
	}

	@Override
	public List<XjsscPlan> findIntegers() {
		PageView<XjsscPlan> pageViewGuilv3 = new PageView<XjsscPlan>();
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("type2", MatchType.EQ, 0));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<XjsscPlan> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}

	@Override
	public XjsscPlan findPlan(long qi, int type) {
		
		Object[] p=new Object[2];
		p[0]="qi";
		p[1]="type";
		
		Object[] o=new Object[2];
		o[0]=qi;
		o[1]=type;
		 
		return this.planDao.findPropertys(p, o);
	}
	@Override
	public XjsscPlan findPlan(int type) {
		PageView<XjsscPlan> pageViewGuilv3 = new PageView<XjsscPlan>(1,1);
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<XjsscPlan> guilvs3 = pageViewGuilv3.getRecords();
			XjsscPlan plan=null;
			if(!guilvs3.isEmpty()){
				  plan=guilvs3.get(0);
			}
			return plan;
	}

	
}
