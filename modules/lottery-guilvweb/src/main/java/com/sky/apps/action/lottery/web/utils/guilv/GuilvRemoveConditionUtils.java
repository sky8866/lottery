package com.sky.apps.action.lottery.web.utils.guilv;

 

import com.sky.modules.lottery.entity.guilv.GuilvRemoveCondition;

public class GuilvRemoveConditionUtils {

	public  static boolean removeGuilv(GuilvRemoveCondition c ,int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
		 
		 
			if(fixation!=0){
				fixation=1;
			}
			
				if(c.getAddition()==addition&&c.getBuchang()==buchang&&c.getFixation()==fixation&&c.getNumber()==number&&sum>=c.getSum()){
					flag=true;
				}
				  
			
			
			
			
			return flag;
	}
	
	public  static boolean removeGuilv2(GuilvRemoveCondition c ,int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
		 
		 
			if(fixation!=0){
				fixation=1;
			}
			    if(c!=null){
					if(c.getAddition()==addition&&c.getBuchang()==buchang&&c.getFixation()==fixation&&c.getNumber()==number&&sum>=c.getSum()){
						flag=true;
					}else if(c.getAddition()==addition&&c.getBuchang()==buchang&&c.getFixation()==fixation&&c.getNumber()==number&&sum>=c.getSumNew()){
						flag=true;
					 
						
					}	
			    }

				  
			
			
			
			
			return flag;
	}
	
	public  static boolean removeGuilv3(GuilvRemoveCondition c ,int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
		 
		 
			if(fixation!=0){
				fixation=1;
			}
			
				if(c.getAddition()==addition&&c.getBuchang()==buchang&&c.getFixation()==fixation&&c.getNumber()==number&&sum==c.getSum()-1){
					flag=true;
				}
				  
			
			
			
			
			return flag;
	}
	
	
}
