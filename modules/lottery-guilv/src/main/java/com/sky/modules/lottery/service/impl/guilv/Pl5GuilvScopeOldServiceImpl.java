package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;   
import com.sky.modules.lottery.dao.guilv.Pl5GuilvScopeOldDao; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvScopeOld;  
import com.sky.modules.lottery.service.guilv.Pl5GuilvScopeOldService;
@Service
public class Pl5GuilvScopeOldServiceImpl implements Pl5GuilvScopeOldService {
	@Autowired private Pl5GuilvScopeOldDao guilvDao;

	@Override
	public void saveGuilv(Pl5GuilvScopeOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(Pl5GuilvScopeOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<Pl5GuilvScopeOld> findList(PageView<Pl5GuilvScopeOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public Pl5GuilvScopeOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public Pl5GuilvScopeOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public Pl5GuilvScopeOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<Pl5GuilvScopeOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
