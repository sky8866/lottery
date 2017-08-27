package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.CqGuilvSingleDoubleOldDao;  
import com.sky.modules.lottery.entity.guilv.CqGuilvSingleDoubleOld; 
import com.sky.modules.lottery.service.guilv.CqGuilvSingleDoubleOldService;
@Service
public class CqGuilvSingleDoubleOldServiceImpl implements CqGuilvSingleDoubleOldService {
	@Autowired private CqGuilvSingleDoubleOldDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvSingleDoubleOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvSingleDoubleOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvSingleDoubleOld> findList(PageView<CqGuilvSingleDoubleOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvSingleDoubleOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvSingleDoubleOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvSingleDoubleOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvSingleDoubleOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
