package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilvKill;
 

public class ComparatorCqsscGuilvKill   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		CqsscGuilvKill vo1=(CqsscGuilvKill) o1;
		CqsscGuilvKill vo2=(CqsscGuilvKill) o2;
		
		  int flag=vo2.getSum().compareTo(vo1.getSum());
		  if(flag==0){
		     int v= vo1.getAddition().compareTo(vo2.getAddition());
		    
		    	 return v;
		     
		  }else{
		   return flag;
		  }
	}

}
