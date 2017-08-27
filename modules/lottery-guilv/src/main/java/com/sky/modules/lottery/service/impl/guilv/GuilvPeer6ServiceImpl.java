package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeer6Dao;
import com.sky.modules.lottery.dao.guilv.GuilvPeer6OldDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer6;
import com.sky.modules.lottery.entity.guilv.GuilvPeer6Old;
import com.sky.modules.lottery.service.guilv.GuilvPeer6Service; 
@Service
public class GuilvPeer6ServiceImpl implements GuilvPeer6Service {
	@Autowired private GuilvPeer6Dao guilvDao;
	@Autowired private GuilvPeer6OldDao guilvOldDao;
	@Override
	public void saveGuilv(GuilvPeer6 r) {
		 this.guilvDao.save(r);
		
	}
	
	public void saveGuilvPeer6Old(GuilvPeer6Old r) {
		 this.guilvOldDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeer6 r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeer6> findList(PageView<GuilvPeer6> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeer6 findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeer6 findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeer6 findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeer6> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
