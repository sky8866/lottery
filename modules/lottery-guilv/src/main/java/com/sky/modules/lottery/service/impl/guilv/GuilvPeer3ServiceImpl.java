package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeer3Dao;
import com.sky.modules.lottery.dao.guilv.GuilvPeer3OldDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer3;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3Old;
import com.sky.modules.lottery.service.guilv.GuilvPeer3Service; 
@Service
public class GuilvPeer3ServiceImpl implements GuilvPeer3Service {
	@Autowired private GuilvPeer3Dao guilvDao;
	@Autowired private GuilvPeer3OldDao guilvOldDao;
	@Override
	public void saveGuilv(GuilvPeer3 r) {
		 this.guilvDao.save(r);
		
	}
	
	public void saveGuilvPeer3Old(GuilvPeer3Old r) {
		 this.guilvOldDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeer3 r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeer3> findList(PageView<GuilvPeer3> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeer3 findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeer3 findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeer3 findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeer3> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
