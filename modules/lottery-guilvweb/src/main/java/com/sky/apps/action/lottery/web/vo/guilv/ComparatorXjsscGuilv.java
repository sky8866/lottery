package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.CqsscGuilv;
import com.sky.modules.lottery.entity.guilv.XjsscGuilv;
 

public class ComparatorXjsscGuilv   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		XjsscGuilv vo1=(XjsscGuilv) o1;
		XjsscGuilv vo2=(XjsscGuilv) o2;
		
		  int flag=vo1.getSum().compareTo(vo2.getSum());
		  if(flag==0){
		     int v= vo2.getDuiNum().compareTo(vo1.getDuiNum());
		     if(v==0){
		    	 int v2=vo2.getCountMin().compareTo(vo1.getCountMin());
		    	   if(v2==0){
		    		   return vo1.getErrorNum().compareTo(vo2.getErrorNum());
		    	   }else{
		    		   return v2;
		    	   }
		    	
		     }else{
		    	 return v;
		     }
		  }else{
		   return flag;
		  }
	}

}
