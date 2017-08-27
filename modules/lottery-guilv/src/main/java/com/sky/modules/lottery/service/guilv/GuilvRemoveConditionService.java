package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;
  
import com.sky.modules.lottery.entity.guilv.GuilvRemoveCondition;

public interface GuilvRemoveConditionService {
	void saveGuilv(GuilvRemoveCondition r);

	void delGuilv(Serializable... long1);

	void updateGuilv(GuilvRemoveCondition r);
 
	GuilvRemoveCondition findGuilv(Long id);

	GuilvRemoveCondition findGuilv(Object p, Object v);
	GuilvRemoveCondition findGuilvs(Object[] p, Object[] v);
	
    List<GuilvRemoveCondition> findList(Object p, Object v);
    
    GuilvRemoveCondition findGuilv(int fixation,int buchang,int addition,int number,int gui); 
}
