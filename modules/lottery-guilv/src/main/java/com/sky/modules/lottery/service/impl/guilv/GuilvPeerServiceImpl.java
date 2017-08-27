package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.guilv.GuilvDao;
import com.sky.modules.lottery.dao.guilv.GuilvPeerDao;
import com.sky.modules.lottery.dao.guilv.GuilvPeerOldDao;
import com.sky.modules.lottery.dao.impl.guilv.GuilvPeerDaoImpl;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvPeer;
import com.sky.modules.lottery.entity.guilv.GuilvPeerOld;
import com.sky.modules.lottery.service.guilv.GuilvPeerService;
import com.sky.modules.lottery.service.guilv.GuilvService;
@Service
public class GuilvPeerServiceImpl implements GuilvPeerService {
	@Autowired private GuilvPeerDao guilvDao;
	@Autowired private GuilvPeerOldDao guilvOldDao;
	@Override
	public void saveGuilv(GuilvPeer r) {
		 this.guilvDao.save(r);
		
	}
	
	public void saveGuilvPeerOld(GuilvPeerOld r) {
		 this.guilvOldDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeer r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeer> findList(PageView<GuilvPeer> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeer findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeer findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeer findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeer> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
