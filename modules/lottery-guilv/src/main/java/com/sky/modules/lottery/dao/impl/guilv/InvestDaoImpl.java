package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.guilv.InvestDao;
import com.sky.modules.lottery.entity.guilv.Invest;

@Repository
public class InvestDaoImpl extends HibernateDaoImpl<Invest> implements
		InvestDao {

}
