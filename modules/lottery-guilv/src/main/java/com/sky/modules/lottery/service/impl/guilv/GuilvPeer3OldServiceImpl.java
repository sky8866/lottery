package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeer3OldDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.service.guilv.GuilvPeer3OldService; 
@Service
public class GuilvPeer3OldServiceImpl implements GuilvPeer3OldService {
	@Autowired private GuilvPeer3OldDao guilvDao;

	@Override
	public void saveGuilv(GuilvPeer3Old r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeer3Old r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeer3Old> findList(PageView<GuilvPeer3Old> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeer3Old findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeer3Old findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeer3Old findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeer3Old> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
