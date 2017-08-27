package com.sky.modules.lottery.dao.impl.guilv;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl; 
import com.sky.modules.lottery.dao.guilv.NewPlanDao; 
import com.sky.modules.lottery.entity.guilv.NewPlan;
@Repository
public class NewPlanDaoImpl extends HibernateDaoImpl<NewPlan> implements NewPlanDao {

}
