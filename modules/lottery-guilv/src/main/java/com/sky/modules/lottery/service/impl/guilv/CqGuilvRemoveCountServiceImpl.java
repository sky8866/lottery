package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.CqGuilvRemoveCountDao; 
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveCountService; 
@Service
public class CqGuilvRemoveCountServiceImpl implements CqGuilvRemoveCountService {
	@Autowired private CqGuilvRemoveCountDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvRemoveCount r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvRemoveCount r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvRemoveCount> findList(PageView<CqGuilvRemoveCount> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvRemoveCount findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvRemoveCount findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvRemoveCount findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvRemoveCount> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
