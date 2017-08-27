package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvAllRightDao;
import com.sky.modules.lottery.dao.guilv.XjsscGuilvLimitDao;
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvLimit;
import com.sky.modules.lottery.service.guilv.GuilvAllRightService;
import com.sky.modules.lottery.service.guilv.XjsscGuilvLimitService;
import com.sky.modules.lottery.service.guilv.GuilvLimitService; 
@Service
public class XjsscGuilvLimitServiceImpl implements XjsscGuilvLimitService {
	@Autowired private XjsscGuilvLimitDao guilvDao;

	@Override
	public void saveGuilv(XjsscGuilvLimit r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(XjsscGuilvLimit r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<XjsscGuilvLimit> findList(PageView<XjsscGuilvLimit> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public XjsscGuilvLimit findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public XjsscGuilvLimit findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public XjsscGuilvLimit findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<XjsscGuilvLimit> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
