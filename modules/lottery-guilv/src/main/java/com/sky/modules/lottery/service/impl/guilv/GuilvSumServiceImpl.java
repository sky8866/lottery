package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.GuilvSumDao;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
import com.sky.modules.lottery.service.guilv.GuilvSumService;
@Service
public class GuilvSumServiceImpl implements GuilvSumService {
	
	@Autowired private GuilvSumDao sumDao;

	@Override
	public void saveGuilvSum(GuilvSum r) {
	 this.sumDao.save(r);

	}

	@Override
	public void delGuilvSum(Serializable[] entityids) {
	   this.sumDao.delete(entityids);

	}

	@Override
	public void updateGuilvSum(GuilvSum r) {
		 this.sumDao.update(r);

	}

	@Override
	public QueryResult<GuilvSum> findList(PageView<GuilvSum> pv,
			List<PropertyFilter> filters) {
		 
		return this.sumDao.findPage(pv, filters);
	}

	@Override
	public GuilvSum findGuilvSum(Long id) {
		 
		return this.sumDao.find(id);
	}

	@Override
	public GuilvSum findGuilvSum(Object p, Object v) {
		 
		return this.sumDao.findProperty(p, v);
	}

}
