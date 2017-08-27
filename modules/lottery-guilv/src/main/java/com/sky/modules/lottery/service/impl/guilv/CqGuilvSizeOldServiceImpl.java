package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.CqGuilvSizeOldDao;  
import com.sky.modules.lottery.entity.guilv.CqGuilvSizeOld; 
import com.sky.modules.lottery.service.guilv.CqGuilvSizeOldService;
@Service
public class CqGuilvSizeOldServiceImpl implements CqGuilvSizeOldService {
	@Autowired private CqGuilvSizeOldDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvSizeOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvSizeOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvSizeOld> findList(PageView<CqGuilvSizeOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvSizeOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvSizeOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvSizeOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvSizeOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
