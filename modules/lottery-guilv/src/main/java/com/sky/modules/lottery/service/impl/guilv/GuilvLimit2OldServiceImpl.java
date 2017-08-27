package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.GuilvLimit2OldDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit2Old;
import com.sky.modules.lottery.service.guilv.GuilvLimit2OldService; 
@Service
public class GuilvLimit2OldServiceImpl implements GuilvLimit2OldService {
	@Autowired private GuilvLimit2OldDao guilvDao;

	@Override
	public void saveGuilv(GuilvLimit2Old r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvLimit2Old r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvLimit2Old> findList(PageView<GuilvLimit2Old> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvLimit2Old findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvLimit2Old findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvLimit2Old findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvLimit2Old> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
