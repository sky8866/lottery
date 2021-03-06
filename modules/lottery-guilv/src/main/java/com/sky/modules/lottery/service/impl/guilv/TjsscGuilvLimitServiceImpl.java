package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvAllRightDao;
import com.sky.modules.lottery.dao.guilv.TjsscGuilvLimitDao;
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.TjsscGuilvLimit;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.TjsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
@Service
public class TjsscGuilvLimitServiceImpl implements TjsscGuilvLimitService {
	@Autowired private TjsscGuilvLimitDao guilvDao;

	@Override
	public void saveGuilv(TjsscGuilvLimit r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(TjsscGuilvLimit r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<TjsscGuilvLimit> findList(PageView<TjsscGuilvLimit> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public TjsscGuilvLimit findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public TjsscGuilvLimit findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public TjsscGuilvLimit findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<TjsscGuilvLimit> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
