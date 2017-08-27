package com.sky.modules.lottery.dao.impl.user;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.user.UserLogDao;
import com.sky.modules.lottery.entity.user.UserLog;
@Repository
public class UserLogDaoImpl extends HibernateDaoImpl<UserLog> implements
		UserLogDao {

}
