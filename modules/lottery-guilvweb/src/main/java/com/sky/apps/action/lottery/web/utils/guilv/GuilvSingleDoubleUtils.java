package com.sky.apps.action.lottery.web.utils.guilv;

 
public class GuilvSingleDoubleUtils {
	
	
	public static String getSumValue(int query,int number){
		Integer[]  values=getQueryValue(query, number);
		String s="";
		for(Integer v:values){
			s=s+v;
		}
			
			return s;
		
	}
	
	public static Integer[] getQueryValue(int query,int number){
		Integer[] maps=new Integer[number];
		if(number==5){
		 
		   	if(query==0){
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=4;
	   		 maps[3]=6;
	   		 maps[4]=8;
		   	}else if(query==1){
		   		maps[0]=1;
		   		 maps[1]=3;
		   		 maps[2]=5;
		   		 maps[3]=7;
		   		 maps[4]=9;
		   	}else if(query==2){
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=4;
	   		 maps[3]=6;
	   		 maps[4]=8;
		   	}else if(query==3){
		   		maps[0]=1;
		   		 maps[1]=3;
		   		 maps[2]=5;
		   		 maps[3]=7;
		   		 maps[4]=9;
		   	}else if(query==4){
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=4;
	   		 maps[3]=6;
	   		 maps[4]=8;
		   	}else if(query==5){
		   		maps[0]=1;
		   		 maps[1]=3;
		   		 maps[2]=5;
		   		 maps[3]=7;
		   		 maps[4]=9;
		   	}else if(query==6){
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=4;
	   		 maps[3]=6;
	   		 maps[4]=8;
		   	}else if(query==7){
		   		maps[0]=1;
		   		 maps[1]=3;
		   		 maps[2]=5;
		   		 maps[3]=7;
		   		 maps[4]=9;
		   	}else if(query==8){
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=4;
	   		 maps[3]=6;
	   		 maps[4]=8;
		   	}else if(query==9){
		   		maps[0]=1;
		   		 maps[1]=3;
		   		 maps[2]=5;
		   		 maps[3]=7;
		   		 maps[4]=9;
		   	}
		   	
		} 
		
		return maps;
	}

}
