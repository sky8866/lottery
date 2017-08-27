package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.Pl5GuilvSameOldDao; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSameOld;  
import com.sky.modules.lottery.service.guilv.Pl5GuilvSameOldService;
@Service
public class Pl5GuilvSameOldServiceImpl implements Pl5GuilvSameOldService {
	@Autowired private Pl5GuilvSameOldDao guilvDao;

	@Override
	public void saveGuilv(Pl5GuilvSameOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(Pl5GuilvSameOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<Pl5GuilvSameOld> findList(PageView<Pl5GuilvSameOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public Pl5GuilvSameOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public Pl5GuilvSameOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public Pl5GuilvSameOld findGuilvs(Object[] p, Object[] v) {
	 
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<Pl5GuilvSameOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

	@Override
	public List<Pl5GuilvSameOld> findList() {
	 
		return this.guilvDao.findLists();
	}

}
