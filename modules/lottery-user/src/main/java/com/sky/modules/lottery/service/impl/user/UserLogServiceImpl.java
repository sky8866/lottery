package com.sky.modules.lottery.service.impl.user;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.dao.user.UserLogDao;
import com.sky.modules.lottery.entity.user.UserLog;
import com.sky.modules.lottery.service.user.UserLogService;
 
@Service
public class UserLogServiceImpl implements UserLogService {
@Autowired private UserLogDao vipDao;
	@Override
	public UserLog findUserLog(Long id) {
		 
		return this.vipDao.find(id);
	}

	@Override
	public void saveUserLog(UserLog r) {
		this.vipDao.save(r);
		
	}

	@Override
	public void updateUserLog(UserLog r) {
		 this.vipDao.update(r);
		
	}

	@Override
	public void delUserLog(Serializable... entityids) {
		 this.vipDao.delete(entityids);
		
	}

	@Override
	public UserLog findUserLog(Object p, Object v) {
		 
		return this.vipDao.findProperty(p, v);
	}

	@Override
	public QueryResult<UserLog> findPageUser(PageView<UserLog> pv,
			List<PropertyFilter> filters) {
		 
		return this.vipDao.findPage(pv, filters);
	}

}
