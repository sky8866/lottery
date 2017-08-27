package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.GuilvSizeOldDao;  
import com.sky.modules.lottery.entity.guilv.GuilvSizeOld; 
import com.sky.modules.lottery.service.guilv.GuilvSizeOLdService;
@Service
public class GuilvSizeOldServiceImpl implements GuilvSizeOLdService {
	@Autowired private GuilvSizeOldDao guilvDao;
    
	@Override
	public void saveGuilv(GuilvSizeOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvSizeOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvSizeOld> findList(PageView<GuilvSizeOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvSizeOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvSizeOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvSizeOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvSizeOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

	@Override
	public void saveGuilvOld(GuilvSizeOld o) {
		// TODO Auto-generated method stub
		
	}

}
