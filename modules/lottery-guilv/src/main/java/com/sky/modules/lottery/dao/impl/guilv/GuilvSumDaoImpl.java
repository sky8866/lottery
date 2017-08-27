package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.guilv.GuilvSumDao;
import com.sky.modules.lottery.entity.guilv.GuilvSum;
@Repository
public class GuilvSumDaoImpl extends HibernateDaoImpl<GuilvSum> implements
		GuilvSumDao {

}
