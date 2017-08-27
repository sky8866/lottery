package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;
 
import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.LotteryDao;
import com.sky.modules.lottery.entity.guilv.Lottery;
@Repository
public class LotteryDaoImpl extends HibernateDaoImpl<Lottery> implements
		LotteryDao {

}
