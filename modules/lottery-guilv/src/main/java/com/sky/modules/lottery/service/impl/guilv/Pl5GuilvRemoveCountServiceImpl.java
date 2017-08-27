package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.Pl5GuilvRemoveCountDao; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;
import com.sky.modules.lottery.service.guilv.Pl5GuilvRemoveCountService; 
@Service
public class Pl5GuilvRemoveCountServiceImpl implements Pl5GuilvRemoveCountService {
	@Autowired private Pl5GuilvRemoveCountDao guilvDao;

	@Override
	public void saveGuilv(Pl5GuilvRemoveCount r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(Pl5GuilvRemoveCount r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<Pl5GuilvRemoveCount> findList(PageView<Pl5GuilvRemoveCount> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public Pl5GuilvRemoveCount findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public Pl5GuilvRemoveCount findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public Pl5GuilvRemoveCount findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<Pl5GuilvRemoveCount> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
