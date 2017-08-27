package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.guilv.CqsscGuilvLimitDao;
import com.sky.modules.lottery.dao.guilv.XjsscGuilvLimitDao;
import com.sky.modules.lottery.dao.guilv.TjsscGuilvLimitDao;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvLimit;
import com.sky.modules.lottery.entity.guilv.XjsscGuilvLimit;
import com.sky.modules.lottery.entity.guilv.TjsscGuilvLimit;
@Repository
public class TjsscGuilvLimitDaoImpl extends HibernateDaoImpl<TjsscGuilvLimit> implements
		TjsscGuilvLimitDao {

}
