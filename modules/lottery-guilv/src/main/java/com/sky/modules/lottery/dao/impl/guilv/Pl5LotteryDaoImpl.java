package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;
 
import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.CqsscLotteryDao;
import com.sky.modules.lottery.dao.guilv.XjsscLotteryDao;
import com.sky.modules.lottery.dao.guilv.Pl5LotteryDao;
import com.sky.modules.lottery.dao.guilv.LotteryDao;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
@Repository
public class Pl5LotteryDaoImpl extends HibernateDaoImpl<Pl5Lottery> implements
		Pl5LotteryDao {

}
