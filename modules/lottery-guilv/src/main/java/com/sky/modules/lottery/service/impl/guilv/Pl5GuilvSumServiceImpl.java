package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.Pl5GuilvSumDao;
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSum;
import com.sky.modules.lottery.service.guilv.Pl5GuilvSumService;
@Service
public class Pl5GuilvSumServiceImpl implements Pl5GuilvSumService {
	
	@Autowired private Pl5GuilvSumDao sumDao;

	@Override
	public void savePl5GuilvSum(Pl5GuilvSum r) {
	 this.sumDao.save(r);

	}

	@Override
	public void delPl5GuilvSum(Serializable[] entityids) {
	   this.sumDao.delete(entityids);

	}

	@Override
	public void updatePl5GuilvSum(Pl5GuilvSum r) {
		 this.sumDao.update(r);

	}

	@Override
	public QueryResult<Pl5GuilvSum> findList(PageView<Pl5GuilvSum> pv,
			List<PropertyFilter> filters) {
		 
		return this.sumDao.findPage(pv, filters);
	}

	@Override
	public Pl5GuilvSum findPl5GuilvSum(Long id) {
		 
		return this.sumDao.find(id);
	}

	@Override
	public Pl5GuilvSum findPl5GuilvSum(Object p, Object v) {
		 
		return this.sumDao.findProperty(p, v);
	}

}
