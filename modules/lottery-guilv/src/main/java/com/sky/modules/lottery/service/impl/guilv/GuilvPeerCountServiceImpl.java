package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeerCountDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeerCount;
import com.sky.modules.lottery.service.guilv.GuilvPeerCountService; 
@Service
public class GuilvPeerCountServiceImpl implements GuilvPeerCountService {
	@Autowired private GuilvPeerCountDao guilvDao;

	@Override
	public void saveGuilv(GuilvPeerCount r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeerCount r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeerCount> findList(PageView<GuilvPeerCount> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeerCount findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeerCount findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeerCount findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeerCount> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
