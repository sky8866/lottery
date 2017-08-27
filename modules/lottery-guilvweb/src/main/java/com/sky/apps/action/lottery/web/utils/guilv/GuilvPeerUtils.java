package com.sky.apps.action.lottery.web.utils.guilv;

 
public class GuilvPeerUtils {
	
	
	public static String getSumValue(int query,int number){
		Integer[]  values=getQueryValue( query, number);
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
		   	
		}else if(number==0){
			maps=new Integer[2];   
		   if(query==0||query==5){
				 maps[0]=0;
		   		 maps[1]=5; 
			   	
			} else if(query==1||query==6){
				 maps[0]=1;
		   		 maps[1]=6; 
			}else if(query==2||query==7){
				maps[0]=2;
		   		 maps[1]=7; 
			   	
			}else if(query==3||query==8){
				maps[0]=3;
		   		 maps[1]=8; 
			   	
			}else if(query==4||query==9){
				maps[0]=4;
		   		 maps[1]=9; 
			   	
			}
			   
	   }else if(number==4){
			 
			   if(query==0||query==5){
				     maps[0]=0;
			   		 maps[1]=1; 
			   		 maps[2]=5;
			   		 maps[3]=6; 
				   	
				} else if(query==1||query==6){
					 maps[0]=1;
			   		 maps[1]=2; 
			   		 maps[2]=6;
			   		 maps[3]=7;  
				}else if(query==2||query==7){
					 maps[0]=2;
			   		 maps[1]=3; 
			   		 maps[2]=7;
			   		 maps[3]=8;  
				   	
				}else if(query==3||query==8){
					 maps[0]=3;
			   		 maps[1]=4; 
			   		 maps[2]=8;
			   		 maps[3]=9; 
				   	
				}else if(query==4||query==9){
					 maps[0]=4;
			   		 maps[1]=5; 
			   		 maps[2]=9;
			   		 maps[3]=0; 
				   	
				}
				   
		   } 
		
 	
		
		return maps;
	}

}
