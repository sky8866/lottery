package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.CqGuilvPeer3OldDao; 
import com.sky.modules.lottery.entity.guilv.CqGuilvPeer3Old;
import com.sky.modules.lottery.service.guilv.CqGuilvPeer3OldService; 
@Service
public class CqGuilvPeer3OldServiceImpl implements CqGuilvPeer3OldService {
	@Autowired private CqGuilvPeer3OldDao guilvDao;

	@Override
	public void saveGuilv(CqGuilvPeer3Old r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(CqGuilvPeer3Old r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqGuilvPeer3Old> findList(PageView<CqGuilvPeer3Old> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqGuilvPeer3Old findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqGuilvPeer3Old findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public CqGuilvPeer3Old findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvPeer3Old> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
