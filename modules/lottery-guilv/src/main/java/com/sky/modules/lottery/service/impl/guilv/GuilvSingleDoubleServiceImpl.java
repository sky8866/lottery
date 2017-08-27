package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.dao.guilv.GuilvSingleDoubleDao; 
import com.sky.modules.lottery.dao.guilv.GuilvSingleDoubleOldDao; 
import com.sky.modules.lottery.entity.guilv.GuilvSingleDouble; 
import com.sky.modules.lottery.entity.guilv.GuilvSingleDoubleOld;
import com.sky.modules.lottery.service.guilv.GuilvSingleDoubleService;
@Service
public class GuilvSingleDoubleServiceImpl implements GuilvSingleDoubleService {
	@Autowired private GuilvSingleDoubleDao guilvDao;
	@Autowired private GuilvSingleDoubleOldDao guilvOldDao;

	@Override
	public void saveGuilv(GuilvSingleDouble r) {
		 this.guilvDao.save(r);
		
	}
	
	public void saveGuilvOld(GuilvSingleDoubleOld o){
		this.guilvOldDao.save(o);
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvSingleDouble r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvSingleDouble> findList(PageView<GuilvSingleDouble> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvSingleDouble findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvSingleDouble findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvSingleDouble findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvSingleDouble> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
