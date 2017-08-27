package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.Pl5GuilvSingleDoubleOldDao;  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSingleDoubleOld; 
import com.sky.modules.lottery.service.guilv.Pl5GuilvSingleDoubleOldService;
@Service
public class Pl5GuilvSingleDoubleOldServiceImpl implements Pl5GuilvSingleDoubleOldService {
	@Autowired private Pl5GuilvSingleDoubleOldDao guilvDao;

	@Override
	public void saveGuilv(Pl5GuilvSingleDoubleOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(Pl5GuilvSingleDoubleOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<Pl5GuilvSingleDoubleOld> findList(PageView<Pl5GuilvSingleDoubleOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public Pl5GuilvSingleDoubleOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public Pl5GuilvSingleDoubleOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public Pl5GuilvSingleDoubleOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<Pl5GuilvSingleDoubleOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
