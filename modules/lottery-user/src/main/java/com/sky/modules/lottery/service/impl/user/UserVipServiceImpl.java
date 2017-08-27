package com.sky.modules.lottery.service.impl.user;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.user.UserVipDao;
import com.sky.modules.lottery.entity.user.UserVip;
import com.sky.modules.lottery.service.user.UserVipService;
 
@Service
public class UserVipServiceImpl implements UserVipService {
@Autowired private UserVipDao vipDao;
	@Override
	public UserVip findUserVip(Long id) {
		 
		return this.vipDao.find(id);
	}

	@Override
	public void saveUserVip(UserVip r) {
		this.vipDao.save(r);
		
	}

	@Override
	public void updateUserVip(UserVip r) {
		 this.vipDao.update(r);
		
	}

	@Override
	public void delUserVip(Serializable... entityids) {
		 this.vipDao.delete(entityids);
		
	}

	@Override
	public UserVip findUserVip(Object p, Object v) {
		 
		return this.vipDao.findProperty(p, v);
	}

	@Override
	public QueryResult<UserVip> findPageUser(PageView<UserVip> pv,
			List<PropertyFilter> filters) {
		 
		return this.vipDao.findPage(pv, filters);
	}

}
