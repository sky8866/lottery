package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.CqGuilvRemoveCount; 
 

public class ComparatorCqGuilvRemoveCount2   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		CqGuilvRemoveCount vo1=(CqGuilvRemoveCount) o1;
		CqGuilvRemoveCount vo2=(CqGuilvRemoveCount) o2;
		
		  int flag=vo2.getSort().compareTo(vo1.getSort());
		 
		   
			   return flag;
			 
		  
	}

}
