package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvSameDao;
import com.sky.modules.lottery.dao.guilv.GuilvSameOldDao;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSame;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
import com.sky.modules.lottery.service.guilv.GuilvSameService;
@Service
public class GuilvSameServiceImpl implements GuilvSameService {
	@Autowired private GuilvSameDao guilvSameDao;
	@Autowired private GuilvSameOldDao guilvSameOldDao;

	@Override
	public void saveGuilvSame(GuilvSame r) {
		try {
			 this.guilvSameDao.save(r);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	 
	@Override
	public void saveGuilvSameOld(GuilvSameOld o) {
		this.guilvSameOldDao.save(o);	
	}
	
	@Override
	public void delGuilvSame(Serializable... entityids) {
		this.guilvSameDao.delete(entityids);
		
	}

	@Override
	public void updateGuilvSame(GuilvSame r) {
	    this.guilvSameDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvSame> findList(PageView<GuilvSame> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvSameDao.findPage(pv, filters);
	}

	@Override
	public GuilvSame findGuilvSame(Long id) {
		 
		return this.guilvSameDao.find(id);
	}

	@Override
	public GuilvSame findGuilvSame(Object p, Object v) {
		 
		return this.guilvSameDao.findProperty(p, v);
	}

	@Override
	public GuilvSame findGuilvSames(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvSameDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvSame> findList(Object p, Object v) {
 
		return this.guilvSameDao.findPropertyList(p, v);
	}

	@Override
	public List<GuilvSame> findList() {
	 
		return this.guilvSameDao.findLists();
	}


}
