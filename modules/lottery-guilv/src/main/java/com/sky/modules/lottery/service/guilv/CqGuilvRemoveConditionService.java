package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;
  
import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCondition;

public interface CqGuilvRemoveConditionService {
	void saveGuilv(CqGuilvRemoveCondition r);

	void delGuilv(Serializable... long1);

	void updateGuilv(CqGuilvRemoveCondition r);
 
	CqGuilvRemoveCondition findGuilv(Long id);

	CqGuilvRemoveCondition findGuilv(Object p, Object v);
	CqGuilvRemoveCondition findGuilvs(Object[] p, Object[] v);
	
    List<CqGuilvRemoveCondition> findList(Object p, Object v);
    
    CqGuilvRemoveCondition findGuilv(int fixation,int buchang,int addition,int number,int gui); 
}
