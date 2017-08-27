package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvRemoveCountDao; 
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount;
import com.sky.modules.lottery.service.guilv.GuilvRemoveCountService; 
@Service
public class GuilvRemoveCountServiceImpl implements GuilvRemoveCountService {
	@Autowired private GuilvRemoveCountDao guilvDao;

	@Override
	public void saveGuilv(GuilvRemoveCount r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvRemoveCount r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvRemoveCount> findList(PageView<GuilvRemoveCount> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvRemoveCount findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvRemoveCount findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvRemoveCount findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvRemoveCount> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
