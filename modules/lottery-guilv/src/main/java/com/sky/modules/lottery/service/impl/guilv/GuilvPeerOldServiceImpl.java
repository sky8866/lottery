package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeerOldDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.service.guilv.GuilvPeerOldService; 
@Service
public class GuilvPeerOldServiceImpl implements GuilvPeerOldService {
	@Autowired private GuilvPeerOldDao guilvDao;

	@Override
	public void saveGuilv(GuilvPeerOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeerOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeerOld> findList(PageView<GuilvPeerOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeerOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeerOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeerOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeerOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
