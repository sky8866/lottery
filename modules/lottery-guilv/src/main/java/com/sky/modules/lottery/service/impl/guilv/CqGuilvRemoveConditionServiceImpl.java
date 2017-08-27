package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.sky.modules.lottery.dao.guilv.CqGuilvRemoveConditionDao; 
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCondition;
import com.sky.modules.lottery.service.guilv.CqGuilvRemoveConditionService;
@Service
public class CqGuilvRemoveConditionServiceImpl implements
		CqGuilvRemoveConditionService {
    @Autowired private CqGuilvRemoveConditionDao conditionDao;
	@Override
	public void saveGuilv(CqGuilvRemoveCondition r) {
	    this.conditionDao.save(r);
		
	}

	@Override
	public void delGuilv(Serializable... long1) {
		 this.conditionDao.delete(long1);
		
	}

	@Override
	public void updateGuilv(CqGuilvRemoveCondition r) {
		 this.conditionDao.update(r);		
	}

	@Override
	public CqGuilvRemoveCondition findGuilv(Long id) {
	 
		return this.conditionDao.find(id);
	}

	@Override
	public CqGuilvRemoveCondition findGuilv(Object p, Object v) {
		 
		return this.conditionDao.findProperty(p, v);
	}

	@Override
	public CqGuilvRemoveCondition findGuilvs(Object[] p, Object[] v) {
		 
		return this.conditionDao.findPropertys(p, v);
	}

	@Override
	public List<CqGuilvRemoveCondition> findList(Object p, Object v) {
		 
		return this.conditionDao.findPropertyList(p, v);
	}

	@Override
	public CqGuilvRemoveCondition findGuilv(int fixation, int buchang,
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
