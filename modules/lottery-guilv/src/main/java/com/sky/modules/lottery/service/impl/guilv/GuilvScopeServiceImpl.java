package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.GuilvDao;
import com.sky.modules.lottery.dao.guilv.GuilvOldDao;
import com.sky.modules.lottery.dao.guilv.GuilvScopeDao;
import com.sky.modules.lottery.dao.guilv.GuilvScopeOldDao;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvScope;
import com.sky.modules.lottery.entity.guilv.GuilvScopeOld;
import com.sky.modules.lottery.service.guilv.GuilvScopeService;
import com.sky.modules.lottery.service.guilv.GuilvService;
@Service
public class GuilvScopeServiceImpl implements GuilvScopeService {
	@Autowired private GuilvScopeDao guilvDao;
	@Autowired private GuilvScopeOldDao guilvOldDao;

	@Override
	public void saveGuilv(GuilvScope r) {
		try {
			 this.guilvDao.save(r);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void saveGuilvOld(GuilvScopeOld o){
		this.guilvOldDao.save(o);
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvScope r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvScope> findList(PageView<GuilvScope> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvScope findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvScope findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvScope findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvScope> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
