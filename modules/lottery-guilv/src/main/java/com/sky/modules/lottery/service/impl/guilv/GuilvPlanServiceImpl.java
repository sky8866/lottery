package com.sky.modules.lottery.service.impl.guilv;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.GuilvPlanDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPlan;
import com.sky.modules.lottery.service.guilv.GuilvPlanService;
 
@Service
public class GuilvPlanServiceImpl implements GuilvPlanService {
     @Autowired private GuilvPlanDao planDao;
	@Override
	public void savePlan(GuilvPlan r) {
		this.planDao.save(r); 
		
	}

	@Override
	public void delPlan(Long entityids) {
	    this.planDao.delete(entityids);
		
	}

	@Override
	public void updatePlan(GuilvPlan r) {
		 this.planDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPlan> findList(PageView<GuilvPlan> pv,
			List<PropertyFilter> filters) {
		 
		return this.planDao.findPage(pv, filters);
	}

	@Override
	public GuilvPlan findPlan(Long id) {
		
		return this.planDao.find(id);
	}

	@Override
	public GuilvPlan findPlan(Object p, Object v) {
		 
		return this.planDao.findProperty(p, v);
	}

	@Override
	public List<GuilvPlan> findIntegers(Object p, Object v) {
	 
		return this.planDao.findPropertyList(p, v);
	}

	@Override
	public List<GuilvPlan> findIntegers() {
		PageView<GuilvPlan> pageViewGuilv3 = new PageView<GuilvPlan>();
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("value", MatchType.NULL, null));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<GuilvPlan> guilvs3 = pageViewGuilv3.getRecords();
		return guilvs3;
	}

	@Override
	public GuilvPlan findPlan(long qi, int type) {
		
		Object[] p=new Object[2];
		p[0]="qi";
		p[1]="type";
		
		Object[] o=new Object[2];
		o[0]=qi;
		o[1]=type;
		 
		return this.planDao.findPropertys(p, o);
	}
	
	@Override
	public GuilvPlan findPlan(int type) {
		PageView<GuilvPlan> pageViewGuilv3 = new PageView<GuilvPlan>(1,1);
		   pageViewGuilv3.setOrderby("id", "desc");
		   List<PropertyFilter> filtersnewses3 = new ArrayList<PropertyFilter>();
			filtersnewses3.add(new PropertyFilter("type", MatchType.EQ, type));
			pageViewGuilv3.setQueryResult(this.planDao.findPage(pageViewGuilv3,
					filtersnewses3));
			List<GuilvPlan> guilvs3 = pageViewGuilv3.getRecords();
			GuilvPlan plan=null;
			if(!guilvs3.isEmpty()){
				  plan=guilvs3.get(0);
			}
			return plan;
			
	}
	
}
