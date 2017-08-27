package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.GuilvRemoveCount; 
 

public class ComparatorGuilvRemoveCount   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GuilvRemoveCount vo1=(GuilvRemoveCount) o1;
		GuilvRemoveCount vo2=(GuilvRemoveCount) o2;
		
		  int flag=vo1.getSum().compareTo(vo2.getSum());
		  
		   
			   return flag;
			 
		  
	}

}
