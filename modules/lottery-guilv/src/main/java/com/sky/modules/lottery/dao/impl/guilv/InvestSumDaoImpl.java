package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.InvestSumDao; 
import com.sky.modules.lottery.entity.guilv.InvestSum;

@Repository
public class InvestSumDaoImpl extends HibernateDaoImpl<InvestSum> implements
		InvestSumDao {

}
