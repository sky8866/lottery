package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount; 
 

public class ComparatorGuilvRemoveCount2   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GuilvRemoveCount vo1=(GuilvRemoveCount) o1;
		GuilvRemoveCount vo2=(GuilvRemoveCount) o2;
		
		  int flag=vo2.getSort().compareTo(vo1.getSort());
		 
		   
			   return flag;
			 
		  
	}

}
