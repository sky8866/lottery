package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;
  
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCondition;

public interface Pl5GuilvRemoveConditionService {
	void saveGuilv(Pl5GuilvRemoveCondition r);

	void delGuilv(Serializable... long1);

	void updateGuilv(Pl5GuilvRemoveCondition r);
 
	Pl5GuilvRemoveCondition findGuilv(Long id);

	Pl5GuilvRemoveCondition findGuilv(Object p, Object v);
	Pl5GuilvRemoveCondition findGuilvs(Object[] p, Object[] v);
	
    List<Pl5GuilvRemoveCondition> findList(Object p, Object v);
    
    Pl5GuilvRemoveCondition findGuilv(int fixation,int buchang,int addition,int number,int gui); 
}
