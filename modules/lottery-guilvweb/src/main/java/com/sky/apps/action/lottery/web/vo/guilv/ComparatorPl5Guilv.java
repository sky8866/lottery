package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.Pl5Guilv;
 

public class ComparatorPl5Guilv   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Pl5Guilv vo1=(Pl5Guilv) o1;
		Pl5Guilv vo2=(Pl5Guilv) o2;
		
		  int flag=vo1.getSum().compareTo(vo2.getSum());
		return flag;
		  
	}

}
