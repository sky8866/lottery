package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.GuilvLimitDao;  
import com.sky.modules.lottery.entity.guilv.GuilvLimit; 
@Repository
public class GuilvLimitDaoImpl extends HibernateDaoImpl<GuilvLimit> implements GuilvLimitDao {

}
