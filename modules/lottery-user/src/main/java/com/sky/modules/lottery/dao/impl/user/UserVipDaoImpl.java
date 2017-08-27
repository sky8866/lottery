package com.sky.modules.lottery.dao.impl.user;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.user.UserVipDao;
import com.sky.modules.lottery.entity.user.UserVip;
@Repository
public class UserVipDaoImpl extends HibernateDaoImpl<UserVip> implements
		UserVipDao {

}
