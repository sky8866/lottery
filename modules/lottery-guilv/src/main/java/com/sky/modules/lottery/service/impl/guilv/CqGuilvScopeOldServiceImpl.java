package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;   
import com.sky.modules.lottery.dao.guilv.CqGuilvScopeOldDao; 
import com.sky.modules.lottery.entity.guilv.CqGuilvScopeOld;  
import com.sky.modules.lottery.service.guilv.CqGuilvScopeOldService;
@Service
public class CqGuilvScopeOldServiceImpl implements CqGuilvScopeOldService {
	@Autowired private CqGuilvScopeOldDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvScopeOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvScopeOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvScopeOld> findList(PageView<CqGuilvScopeOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvScopeOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvScopeOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvScopeOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvScopeOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
