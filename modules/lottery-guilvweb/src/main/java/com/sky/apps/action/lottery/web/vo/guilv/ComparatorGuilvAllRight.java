package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvLimit;
import com.sky.modules.lottery.entity.guilv.GuilvAllRight;

public class ComparatorGuilvAllRight   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GuilvAllRight vo1=(GuilvAllRight) o1;
		GuilvAllRight vo2=(GuilvAllRight) o2;
		
		  int flag=vo2.getSum().compareTo(vo1.getSum());
		  if(flag==0){
		      
		    	 return 0;
		      
		  }else{
		   return flag;
		  }
	}

}
