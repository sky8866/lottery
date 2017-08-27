package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvAllRightDao;
import com.sky.modules.lottery.dao.guilv.GuilvLimit6Dao;
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.GuilvLimit6;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.GuilvLimit6Service;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
@Service
public class GuilvLimit6ServiceImpl implements GuilvLimit6Service {
	@Autowired private GuilvLimit6Dao guilvDao;

	@Override
	public void saveGuilv(GuilvLimit6 r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvLimit6 r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvLimit6> findList(PageView<GuilvLimit6> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvLimit6 findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvLimit6 findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvLimit6 findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvLimit6> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
