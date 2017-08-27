package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult; 
import com.sky.modules.lottery.dao.guilv.GuilvPeer6OldDao; 
import com.sky.modules.lottery.entity.guilv.GuilvPeer6Old;
import com.sky.modules.lottery.service.guilv.GuilvPeer6OldService; 
@Service
public class GuilvPeer6OldServiceImpl implements GuilvPeer6OldService {
	@Autowired private GuilvPeer6OldDao guilvDao;

	@Override
	public void saveGuilv(GuilvPeer6Old r) {
		 this.guilvDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilv(GuilvPeer6Old r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<GuilvPeer6Old> findList(PageView<GuilvPeer6Old> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public GuilvPeer6Old findGuilv(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public GuilvPeer6Old findGuilv(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	@Override
	public GuilvPeer6Old findGuilvs(Object[] p, Object[] v) {
		// TODO Auto-generated method stub
		return this.guilvDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvPeer6Old> findList(Object p, Object v) {
 
		return this.guilvDao.findPropertyList(p, v);
	}

}
