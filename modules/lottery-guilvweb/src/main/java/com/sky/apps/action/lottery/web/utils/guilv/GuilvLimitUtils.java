package com.sky.apps.action.lottery.web.utils.guilv;

 
public class GuilvLimitUtils {
	
	
	public static String getSumValue(int query,int number){
		Integer[]  values=getQueryValue( query, number);
		String s="";
		for(Integer v:values){
			s=s+v;
		}
			
			return s;
		
	}
	
	public static Integer[] getQueryValue(int query,int number){
		Integer[] maps=new Integer[6];
	   if(number==0){
		   if(query==0||query==5||query==2||query==8){
				 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   		 maps[4]=7;
		   		 maps[5]=3;
			   	
			} else if(query==3||query==6||query==9){
				 maps[0]=3;
		   		 maps[1]=6;
		   		 maps[2]=9;
		   		 maps[3]=8;
		   		 maps[4]=1;
		   		 maps[5]=4;
			}else if(query==1||query==7||query==4){
				maps[0]=1;
		   		 maps[1]=4;
		   		 maps[2]=7;
		   		 maps[3]=6;
		   		 maps[4]=9;
		   		 maps[5]=2;
			   	
			}
			   
	   }else{
			if(query==0||query==5){
				 maps[0]=0;
		   		 maps[1]=1;
		   		 maps[2]=2;
		   		 maps[3]=5;
		   		 maps[4]=6;
		   		 maps[5]=7;
			   	
			} else if(query==1||query==6){
				 maps[0]=1;
		   		 maps[1]=2;
		   		 maps[2]=3;
		   		 maps[3]=6;
		   		 maps[4]=7;
		   		 maps[5]=8;
			}else if(query==2||query==7){
				maps[0]=2;
		   		 maps[1]=3;
		   		 maps[2]=4;
		   		 maps[3]=7;
		   		 maps[4]=8;
		   		 maps[5]=9;
			   	
			}else if(query==3||query==8){
			 
				maps[0]=3;
		   		 maps[1]=4;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   		 maps[4]=9;
		   		 maps[5]=0;
			}else if(query==4||query==9){
				maps[0]=4;
		   		 maps[1]=5;
		   		 maps[2]=6;
		   		 maps[3]=9;
		   		 maps[4]=0;
		   		 maps[5]=1;
			   	
			}  
	   }
		
		
 	
		
		return maps;
	}

}
