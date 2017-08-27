package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.GuilvOldDao; 
import com.sky.modules.lottery.dao.guilv.GuilvSameOldDao;
import com.sky.modules.lottery.entity.guilv.GuilvOld;
import com.sky.modules.lottery.entity.guilv.GuilvSameOld;
@Repository
public class GuilvSameOldDaoImpl extends HibernateDaoImpl<GuilvSameOld> implements GuilvSameOldDao {

}
