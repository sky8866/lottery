package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;
 
import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.CqsscLotteryDao;
import com.sky.modules.lottery.dao.guilv.XjsscLotteryDao;
import com.sky.modules.lottery.dao.guilv.LotteryDao;
import com.sky.modules.lottery.entity.guilv.Lottery;
import com.sky.modules.lottery.entity.guilv.CqsscLottery;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
@Repository
public class XjsscLotteryDaoImpl extends HibernateDaoImpl<XjsscLottery> implements
		XjsscLotteryDao {

}
