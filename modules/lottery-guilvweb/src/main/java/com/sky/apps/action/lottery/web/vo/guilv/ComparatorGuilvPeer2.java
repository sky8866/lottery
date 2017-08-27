package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;
 
import com.sky.modules.lottery.entity.guilv.GuilvPeer2;
import com.sky.modules.lottery.entity.guilv.GuilvPeer3;

public class ComparatorGuilvPeer2   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GuilvPeer2 vo1=(GuilvPeer2) o1;
		GuilvPeer2 vo2=(GuilvPeer2) o2;
		
		  int flag=vo2.getSum().compareTo(vo1.getSum());
		  if(flag==0){
		     int v= vo2.getValue().compareTo(vo1.getValue());
		     if(v==0){
		    	 return vo2.getFixation().compareTo(vo1.getFixation());
		     }else{
		    	 return v;
		     }
		  }else{
		   return flag;
		  }
	}

}
