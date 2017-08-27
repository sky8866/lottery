package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.Lottery;

public class ComparatorLottery   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Lottery vo1=(Lottery) o1;
		Lottery vo2=(Lottery) o2;
		
		  int flag=vo2.getQi().compareTo(vo1.getQi());
		  if(flag==0){
		     
		    	 return 0;
		     
		  }else{
		   return flag;
		  }
	}

}
