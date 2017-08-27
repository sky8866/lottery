package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;
 

public class ComparatorPl5GuilvRemoveCount   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Pl5GuilvRemoveCount vo1=(Pl5GuilvRemoveCount) o1;
		Pl5GuilvRemoveCount vo2=(Pl5GuilvRemoveCount) o2;
		
		  int flag=vo1.getSum().compareTo(vo2.getSum());
		  
		   
			   return flag;
			 
		  
	}

}
