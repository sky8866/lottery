package com.sky.apps.action.lottery.web.vo.guilv;

import java.util.Comparator;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvPeer;

public class ComparatorGuilvPeer   implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GuilvPeer vo1=(GuilvPeer) o1;
		GuilvPeer vo2=(GuilvPeer) o2;
		
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
