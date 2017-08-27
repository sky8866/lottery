package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeer2Dao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer2;  
import com.sky.modules.lottery.service.guilv.GuilvPeer2Service;
@Service
public class GuilvPeer2ServiceImpl implements GuilvPeer2Service {
	@Autowired private GuilvPeer2Dao guilvDao; 
	@Override
	public void saveGuilv(GuilvPeer2 r) {
		 this.guilvDao.save(r);
		
	}
	 

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeer2 r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeer2> findList(PageView<GuilvPeer2> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeer2 findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeer2 findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeer2 findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeer2> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
