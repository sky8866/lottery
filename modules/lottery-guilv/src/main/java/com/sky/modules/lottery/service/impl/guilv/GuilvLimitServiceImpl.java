package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
@Service
public class GuilvLimitServiceImpl implements GuilvLimitService {
	@Autowired private GuilvLimitDao guilvDao;

	@Override
	public void saveGuilv(GuilvLimit r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvLimit r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvLimit> findList(PageView<GuilvLimit> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvLimit findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvLimit findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvLimit findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvLimit> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
