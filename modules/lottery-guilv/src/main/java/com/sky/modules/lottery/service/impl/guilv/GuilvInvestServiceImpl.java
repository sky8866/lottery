package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.InvestDao;
import com.sky.modules.lottery.entity.guilv.Invest; 
import com.sky.modules.lottery.service.guilv.GuilvInvestService;
@Service
public class GuilvInvestServiceImpl implements GuilvInvestService {
	
	@Autowired private InvestDao sumDao;

	@Override
	public void saveInvest(Invest r) {
	 this.sumDao.save(r);

	}

	@Override
	public void delInvest(Serializable[] entityids) {
	   this.sumDao.delete(entityids);

	}

	@Override
	public void updateInvest(Invest r) {
		 this.sumDao.update(r);

	}

	@Override
	public QueryResult<Invest> findList(PageView<Invest> pv,
			List<PropertyFilter> filters) {
		 
		return this.sumDao.findPage(pv, filters);
	}

	@Override
	public Invest findInvest(Long id) {
		 
		return this.sumDao.find(id);
	}

	@Override
	public Invest findInvest(Object p, Object v) {
		 
		return this.sumDao.findProperty(p, v);
	}

	@Override
	public List<Invest> findIntegers(Object p, Object v) {
		 
		return this.sumDao.findPropertyList(p, v);
	}

	@Override
	public List<Invest> findIntegers() {
		 
		return this.sumDao.findLists();
	}

}
