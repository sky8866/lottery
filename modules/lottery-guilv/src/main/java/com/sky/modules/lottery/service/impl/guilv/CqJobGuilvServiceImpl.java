package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;  
import com.sky.modules.lottery.entity.guilv.CqJobGuilv;
import com.sky.modules.lottery.service.guilv.CqJobGuilvService; 
@Service
public class CqJobGuilvServiceImpl implements CqJobGuilvService {
	@Autowired private com.sky.modules.lottery.dao.guilv.CqJobGuilvDao guilvDao; 

	@Override
	public void saveGuilvKill(CqJobGuilv r) {
		try {
			 this.guilvDao.save(r);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	 

	@Override
	public void delGuilvKill(Serializable... entityids) {
		this.guilvDao.delete(entityids);
		
	}

	@Override
	public void updateGuilvKill(CqJobGuilv r) {
	    this.guilvDao.update(r);
		
	}

	@Override
	public QueryResult<CqJobGuilv> findList(PageView<CqJobGuilv> pv,
			List<PropertyFilter> filters) {
	 
		return this.guilvDao.findPage(pv, filters);
	}

	@Override
	public CqJobGuilv findGuilvKill(Long id) {
		 
		return this.guilvDao.find(id);
	}

	@Override
	public CqJobGuilv findGuilvKill(Object p, Object v) {
		 
		return this.guilvDao.findProperty(p, v);
	}

	 
	
}
