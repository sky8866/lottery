package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.InvestSumDao;
import com.sky.modules.lottery.entity.guilv.InvestSum; 
import com.sky.modules.lottery.service.guilv.GuilvInvestSumService;
@Service
public class GuilvInvestSumServiceImpl implements GuilvInvestSumService {
	
	@Autowired private InvestSumDao sumDao;

	@Override
	public void saveInvestSum(InvestSum r) {
	 this.sumDao.save(r);

	}

	@Override
	public void delInvestSum(Serializable[] entityids) {
	   this.sumDao.delete(entityids);

	}

	@Override
	public void updateInvestSum(InvestSum r) {
		 this.sumDao.update(r);

	}

	@Override
	public QueryResult<InvestSum> findList(PageView<InvestSum> pv,
			List<PropertyFilter> filters) {
		 
		return this.sumDao.findPage(pv, filters);
	}

	@Override
	public InvestSum findInvestSum(Long id) {
		 
		return this.sumDao.find(id);
	}

	@Override
	public InvestSum findInvestSum(Object p, Object v) {
		 
		return this.sumDao.findProperty(p, v);
	}

	@Override
	public List<InvestSum> findIntegers(Object p, Object v) {
		 
		return this.sumDao.findPropertyList(p, v);
	}

	@Override
	public List<InvestSum> findInvestSum() {
		 
		return this.sumDao.findPropertyList("visible", 1);
	}

}
