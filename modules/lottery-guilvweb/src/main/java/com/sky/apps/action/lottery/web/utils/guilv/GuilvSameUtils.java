package com.sky.apps.action.lottery.web.utils.guilv;

 
public class GuilvSameUtils {
	
	
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
		if(number==1){
			maps=new Integer[1];   
			 maps[0]=query;  
		   	
		}else if(number==3){
		 
		   	if(query==0){
		   		maps=new Integer[4];  
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=5;
	   		 maps[3]=8;
		   	}else if(query==1){
		   	 maps[0]=1;
	   		 maps[1]=4;
	   		 maps[2]=7; 
		   	}else if(query==2){
		   		maps=new Integer[4];  
			   	 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   	}else if(query==3){
		   	 maps[0]=3;
	   		 maps[1]=6;
	   		 maps[2]=9; 
		   	}else if(query==4){
		   	 maps[0]=1;
	   		 maps[1]=4;
	   		 maps[2]=7; 
		   	}else if(query==5){
		   		maps=new Integer[4];  
			   	 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   	}else if(query==6){
		   	 maps[0]=3;
	   		 maps[1]=6;
	   		 maps[2]=9; 
		   	}else if(query==7){
		   	 maps[0]=1;
	   		 maps[1]=4;
	   		 maps[2]=7; 
		   	}else if(query==8){
		   		maps=new Integer[4];  
			   	 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   	}else if(query==9){
		   	 maps[0]=3;
	   		 maps[1]=6;
	   		 maps[2]=9; 
		   	}
		   	
		}else if(number==6){
		 
		   	if(query==0){
		   	 maps[0]=0;
	   		 maps[1]=2;
	   		 maps[2]=5;
	   		 maps[3]=8;
	   		 maps[4]=7;
	   		 maps[5]=3;
		   	}else if(query==1){
		   		maps[0]=1;
		   		 maps[1]=4;
		   		 maps[2]=7;
		   		 maps[3]=6;
		   		 maps[4]=9;
		   		 maps[5]=2;
		   	}else if(query==2){
		    	 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   		 maps[4]=7;
		   		 maps[5]=3;
		   	}else if(query==3){
		   		maps[0]=3;
		   		 maps[1]=6;
		   		 maps[2]=9;
		   		 maps[3]=1;
		   		 maps[4]=4;
		   		 maps[5]=8;
		   	}else if(query==4){
		   		maps[0]=1;
		   		 maps[1]=4;
		   		 maps[2]=7;
		   		 maps[3]=6;
		   		 maps[4]=9;
		   		 maps[5]=2;
		   	}else if(query==5){
		    	 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   		 maps[4]=7;
		   		 maps[5]=3;
		   	}else if(query==6){
		   		maps[0]=3;
		   		 maps[1]=6;
		   		 maps[2]=9;
		   		 maps[3]=1;
		   		 maps[4]=4;
		   		 maps[5]=8;
		   	}else if(query==7){
		   		maps[0]=1;
		   		 maps[1]=4;
		   		 maps[2]=7;
		   		 maps[3]=6;
		   		 maps[4]=9;
		   		 maps[5]=2;
		   	}else if(query==8){
		    	 maps[0]=0;
		   		 maps[1]=2;
		   		 maps[2]=5;
		   		 maps[3]=8;
		   		 maps[4]=7;
		   		 maps[5]=3;
		   	}else if(query==9){
		   		maps[0]=3;
		   		 maps[1]=6;
		   		 maps[2]=9;
		   		 maps[3]=1;
		   		 maps[4]=4;
		   		 maps[5]=8;
		   	}
		   	
		}else if(number==2){
			maps=new Integer[2];   
		   	if(query==0){
		   	 maps[0]=0;
	   		 maps[1]=5; 
		   	}else if(query==1){
		   		maps[0]=1;
		   		 maps[1]=6; 
		   	}else if(query==2){
		   		maps[0]=2;
		   		 maps[1]=7; 
		   	}else if(query==3){
		   		maps[0]=3;
		   		 maps[1]=8; 
		   	}else if(query==4){
		   		maps[0]=4;
		   		 maps[1]=9; 
		   	}else if(query==5){
		   		maps[0]=5;
		   		 maps[1]=0; 
		   	}else if(query==6){
		   		maps[0]=6;
		   		 maps[1]=1; 
		   	}else if(query==7){
		   		 maps[0]=7;
		   		 maps[1]=2; 
		   	}else if(query==8){
		   		 maps[0]=8;
		   		 maps[1]=3; 
		   	}else if(query==9){
		   	 maps[0]=9;
	   		 maps[1]=4; 
		   	}
		   	
		}
		
		return maps;
	}

}
