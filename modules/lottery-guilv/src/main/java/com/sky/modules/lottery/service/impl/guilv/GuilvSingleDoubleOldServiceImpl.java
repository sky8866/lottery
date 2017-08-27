package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.GuilvSingleDoubleOldDao;  
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld; 
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleOLdService;
@Service
public class GuilvSingleDoubleOldServiceImpl implements GuilvSingleDoubleOLdService {
	@Autowired private GuilvSingleDoubleOldDao guilvDao;

	@Override
	public void saveGuilv(GuilvSingleDoubleOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvSingleDoubleOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvSingleDoubleOld> findList(PageView<GuilvSingleDoubleOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvSingleDoubleOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvSingleDoubleOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvSingleDoubleOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvSingleDoubleOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
