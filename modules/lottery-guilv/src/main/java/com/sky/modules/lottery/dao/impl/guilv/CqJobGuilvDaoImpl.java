package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.guilv.CqGuilvDao; 
import com.sky.modules.lottery.dao.guilv.CqJobGuilvDao;
import com.sky.modules.lottery.entity.guilv.CqGuilv; 
import com.sky.modules.lottery.entity.guilv.CqJobGuilv;
@Repository
public class CqJobGuilvDaoImpl extends HibernateDaoImpl<CqJobGuilv> implements CqJobGuilvDao {

}
