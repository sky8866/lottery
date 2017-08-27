package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.dao.guilv.GuilvLimitOldDao;
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvLimitOld;
import com.sky.modules.lottery.service.guilv.GuilvLimitOldService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
@Service
public class GuilvLimitOldServiceImpl implements GuilvLimitOldService {
	@Autowired private GuilvLimitOldDao guilvDao;

	@Override
	public void saveGuilv(GuilvLimitOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvLimitOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvLimitOld> findList(PageView<GuilvLimitOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvLimitOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvLimitOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvLimitOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvLimitOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
