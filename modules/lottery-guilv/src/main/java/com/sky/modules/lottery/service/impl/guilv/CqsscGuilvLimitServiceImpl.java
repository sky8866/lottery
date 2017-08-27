package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvAllRightDao;
import com.sky.modules.lottery.dao.guilv.CqsscGuilvLimitDao;
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvLimit;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.CqsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
@Service
public class CqsscGuilvLimitServiceImpl implements CqsscGuilvLimitService {
	@Autowired private CqsscGuilvLimitDao guilvDao;

	@Override
	public void saveGuilv(CqsscGuilvLimit r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqsscGuilvLimit r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqsscGuilvLimit> findList(PageView<CqsscGuilvLimit> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqsscGuilvLimit findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqsscGuilvLimit findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqsscGuilvLimit findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqsscGuilvLimit> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
