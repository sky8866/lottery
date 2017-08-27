package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.guilv.GuilvDao;
import com.sky.modules.lottery.dao.guilv.CqsscGuilvDao;
import com.sky.modules.lottery.dao.guilv.XjsscGuilvKillDao;
import com.sky.modules.lottery.dao.guilv.XjsscGuilvDao;
import com.sky.modules.lottery.dao.guilv.CqsscGuilvKillDao;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvKill;
import com.sky.modules.lottery.entity.guilv.XjsscGuilv;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvKill;
@Repository
public class XjsscGuilvKillDaoImpl extends HibernateDaoImpl<XjsscGuilvKill> implements XjsscGuilvKillDao {

}
