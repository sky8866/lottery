package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount; 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvRemoveCount;
 

public class ComparatorPl5GuilvRemoveCount2   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Pl5GuilvRemoveCount vo1=(Pl5GuilvRemoveCount) o1;
		Pl5GuilvRemoveCount vo2=(Pl5GuilvRemoveCount) o2;
		
		  int flag=vo2.getSort().compareTo(vo1.getSort());
		 
		   
			   return flag;
			 
		  
	}

}
