package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.MatchType;
import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.lottery.dao.guilv.GuilvRemoveConditionDao;
import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCondition;
import com.sky.modules.lottery.service.guilv.GuilvRemoveConditionService;
@Service
public class GuilvRemoveConditionServiceImpl implements
		GuilvRemoveConditionService {
    @Autowired private GuilvRemoveConditionDao conditionDao;
	@Override
	public void saveGuilv(GuilvRemoveCondition r) {
	    this.conditionDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... long1) {
		 this.conditionDao.delete(long1);
		
	}

	@Override
	public void updateGuilv(GuilvRemoveCondition r) {
		 this.conditionDao.update(r);		
	}

	@Override
	public GuilvRemoveCondition findGuilv(Long id) {
	 
		return this.conditionDao.find(id);
	}

	@Override
	public GuilvRemoveCondition findGuilv(Object p, Object v) {
		 
		return this.conditionDao.findProperty(p, v);
	}

	@Override
	public GuilvRemoveCondition findGuilvs(Object[] p, Object[] v) {
		 
		return this.conditionDao.findPropertys(p, v);
	}

	@Override
	public List<GuilvRemoveCondition> findList(Object p, Object v) {
		 
		return this.conditionDao.findPropertyList(p, v);
	}

	@Override
	public GuilvRemoveCondition findGuilv(int fixation, int buchang,
			int addition, int number, int gui) {
         if(0!=fixation){
        	 fixation=1;
         }
 
		Object[] objects=new Object[5];
		   objects[0]="fixation";
		   objects[1]="buchang";
		   objects[2]="addition";
		   objects[3]="number"; 
		   objects[4]="gui"; 
		   Object[]  var=new Object[5];
		   var[0]=fixation;
		   var[1]=buchang;
		   var[2]=addition;
		   var[3]=number; 
		   var[4]=gui; 
		return this.conditionDao.findPropertys(objects, var);
	}

}
