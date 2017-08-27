package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.CqGuilvSameOldDao; 
import com.sky.modules.lottery.entity.guilv.CqGuilvSameOld;  
import com.sky.modules.lottery.service.guilv.CqGuilvSameOldService;
@Service
public class CqGuilvSameOldServiceImpl implements CqGuilvSameOldService {
	@Autowired private CqGuilvSameOldDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvSameOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvSameOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvSameOld> findList(PageView<CqGuilvSameOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvSameOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvSameOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvSameOld findGuilvs(Object[] p, Object[] v) {
	 
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvSameOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

	@Override
	public List<CqGuilvSameOld> findList() {
	 
		return this.guilvDao.findLists();
	}

}
