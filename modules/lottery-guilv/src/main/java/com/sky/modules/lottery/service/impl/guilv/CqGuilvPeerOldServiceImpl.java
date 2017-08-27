package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.CqGuilvPeerOldDao; 
import com.sky.modules.lottery.entity.guilv.CqGuilvPeerOld;
import com.sky.modules.lottery.service.guilv.CqGuilvPeerOldService; 
@Service
public class CqGuilvPeerOldServiceImpl implements CqGuilvPeerOldService {
	@Autowired private CqGuilvPeerOldDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvPeerOld r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvPeerOld r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvPeerOld> findList(PageView<CqGuilvPeerOld> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvPeerOld findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvPeerOld findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvPeerOld findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvPeerOld> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
