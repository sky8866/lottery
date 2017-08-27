package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvOldDao; 
import com.sky.modules.lottery.dao.guilv.GuilvScopeOldDao;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvScopeOld;
import com.sky.modules.lottery.service.guilv.GuilvOLdService; 
import com.sky.modules.lottery.service.guilv.GuilvScopeOLdService;
@Service
public class GuilvScopeOldServiceImpl implements GuilvScopeOLdService {
	@Autowired private GuilvScopeOldDao guilvDao;

	@Override
	public void saveGuilv(GuilvScopeOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvScopeOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvScopeOld> findList(PageView<GuilvScopeOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvScopeOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvScopeOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvScopeOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvScopeOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
