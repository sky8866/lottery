package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvOldDao; 
import com.sky.modules.lottery.dao.guilv.GuilvSameOldDao;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
import com.sky.modules.lottery.service.guilv.GuilvOLdService; 
import com.sky.modules.lottery.service.guilv.GuilvSameOldService;
@Service
public class GuilvSameOldServiceImpl implements GuilvSameOldService {
	@Autowired private GuilvSameOldDao guilvDao;

	@Override
	public void saveGuilv(GuilvSameOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvSameOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvSameOld> findList(PageView<GuilvSameOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvSameOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvSameOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvSameOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvSameOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

	@Override
	public List<GuilvSameOld> findList() {
	 
		return this.guilvDao.findLists();
	}

}
