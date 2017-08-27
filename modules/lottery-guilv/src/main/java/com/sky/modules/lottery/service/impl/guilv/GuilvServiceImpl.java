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
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.service.guilv.GuilvService;
@Service
public class GuilvServiceImpl implements GuilvService {
	@Autowired private GuilvDao guilvDao;
	@Autowired private GuilvOldDao guilvOldDao;

	@Override
	public void saveGuilv(Guilv r) {
		try {
			 this.guilvDao.save(r);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void saveGuilvOld(GuilvOld o){
		this.guilvOldDao.save(o);
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(Guilv r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<Guilv> findList(PageView<Guilv> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public Guilv findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public Guilv findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public Guilv findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<Guilv> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
