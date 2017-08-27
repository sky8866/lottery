package com.sky.apps.action.lottery.web.utils.guilv;

 

 

public class SumCountUtils {
	
 
	
	public  static boolean getGuilv(int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
		 
		 
		if(fixation!=0){
			fixation=1;
		}
		
		
		 if(addition==1&&buchang==5 && number==1&&sum>=4){
			 flag=true;
		 }else if(addition==1&&buchang==5 && number==0&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==3&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==4&&sum>=10){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==5&&sum>=13){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==6&&sum>=14){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==2&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==3&&sum>=9){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==4&&sum>=10){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==5&&sum>=14){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==6&&sum>=17){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==1&&sum>=4){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==2&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==3&&sum>=9){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==4&&sum>=11){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==5&&sum>=16){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==6&&sum>=20){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==2&&sum>=9){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==3&&sum>=11){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==4&&sum>=14){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==5&&sum>=19){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==6&&sum>=26){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==0&&sum>=9){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==2&&sum>=7){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==3&&sum>=11){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==4&&sum>=14){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==5&&sum>=19){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==6&&sum>=26){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==0&&sum>=10){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==2&&sum>=10){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==3&&sum>=13){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==4&&sum>=17){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==5&&sum>=24){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==0&&sum>=10){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==2&&sum>=10){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==3&&sum>=13){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==4&&sum>=17){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==5&&sum>=25){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==2&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==3&&sum>=16){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==4&&sum>=21){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&fixation==1&& number==5&&sum>=29){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==2&&sum>=11){
			 flag=true; 
		 }else if(addition==5&&buchang==5&&fixation==0&& number==3&&sum>=16){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==4&&sum>=21){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==5&&sum>=29){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==1&&sum>=8){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==0&&sum>=12){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==2&&sum>=12){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==3&&sum>=17){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==4&&sum>=23){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==5&&sum>=30){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==6&&sum>=36){
			 flag=true;
		 }else  if(addition==1&&buchang==10&&fixation==0&& number==1&&sum>=4){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==0&&sum>=6){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==2&&sum>=6){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==3&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==4&&sum>=12){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==5&&sum>=14){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==6&&sum>=17){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==2&&sum>=8){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==3&&sum>=9){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==4&&sum>=12){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==5&&sum>=15){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==6&&sum>=19){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==2&&sum>=8){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==3&&sum>=11){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==4&&sum>=12){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==5&&sum>=17){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==6&&sum>=21){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==0&&sum>=10){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==2&&sum>=9){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==3&&sum>=14){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==4&&sum>=17){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==5&&sum>=19){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==6&&sum>=27){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==0&&sum>=9){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==2&&sum>=9){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==3&&sum>=14){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==4&&sum>=17){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==5&&sum>=21){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==2&&sum>=11){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==3&&sum>=15){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==4&&sum>=21){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==5&&sum>=25){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==6&&sum>=32){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==2&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==3&&sum>=15){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==4&&sum>=21){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==5&&sum>=25){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==6&&sum>=34){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==1&&sum>=8){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==0&&sum>=12){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==2&&sum>=12){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==3&&sum>=19){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==4&&sum>=24){
			 flag=true; 
		 }else if(addition==4&&buchang==10&&fixation==1&& number==5&&sum>=29){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==6&&sum>=35){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==1&&sum>=9){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==0&&sum>=12){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==2&&sum>=12){
			 flag=true; 
		 }else if(addition==5&&buchang==10&&fixation==0&& number==3&&sum>=19){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==4&&sum>=24){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==5&&sum>=30){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==6&&sum>=36){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==1&&sum>=9){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==0&&sum>=13){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==2&&sum>=13){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==3&&sum>=21){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==4&&sum>=27){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==5&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==6&&sum>=37){
			 flag=true;
		 }
		
		return flag; 
	}
	
	
	public  static boolean getGuilv3(int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
		 
		 
		if(fixation!=0){
			fixation=1;
		}
		
		
		 if(addition==1&&buchang==5 && number==1&&sum>=4){
			 flag=true;
		 }else if(addition==1&&buchang==5 && number==0&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==3&&sum>=6){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==4&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==5&&sum>=9){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==6&&sum>=12){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==2&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==3&&sum>=8){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==4&&sum>=9){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==5&&sum>=13){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==6&&sum>=17){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==1&&sum>=4){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==2&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==3&&sum>=8){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==4&&sum>=10){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==5&&sum>=14){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==6&&sum>=20){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==2&&sum>=8){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==3&&sum>=10){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==4&&sum>=13){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==5&&sum>=18){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==6&&sum>=26){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==0&&sum>=9){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==2&&sum>=7){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==3&&sum>=10){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==4&&sum>=13){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==5&&sum>=18){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==6&&sum>=26){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==0&&sum>=10){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==2&&sum>=10){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==3&&sum>=12){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==4&&sum>=16){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==5&&sum>=23){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==0&&sum>=10){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==2&&sum>=10){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==3&&sum>=12){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==4&&sum>=16){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==5&&sum>=24){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==2&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==3&&sum>=15){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==4&&sum>=20){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&fixation==1&& number==5&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==2&&sum>=11){
			 flag=true; 
		 }else if(addition==5&&buchang==5&&fixation==0&& number==3&&sum>=15){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==4&&sum>=20){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==5&&sum>=28){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==1&&sum>=8){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==0&&sum>=12){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==2&&sum>=12){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==3&&sum>=16){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==4&&sum>=22){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==5&&sum>=29){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==6&&sum>=36){
			 flag=true;
		 }else  if(addition==1&&buchang==10&&fixation==0&& number==1&&sum>=4){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==0&&sum>=6){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==2&&sum>=6){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==3&&sum>=6){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==4&&sum>=9){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==5&&sum>=13){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==6&&sum>=17){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==2&&sum>=8){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==3&&sum>=8){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==4&&sum>=11){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==5&&sum>=14){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==6&&sum>=19){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==1&&sum>=5){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==0&&sum>=7){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==2&&sum>=8){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==3&&sum>=10){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==4&&sum>=11){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==5&&sum>=16){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==6&&sum>=20){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==0&&sum>=8){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==2&&sum>=9){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==3&&sum>=13){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==4&&sum>=16){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==5&&sum>=18){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==6&&sum>=27){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==1&&sum>=6){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==0&&sum>=9){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==2&&sum>=9){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==3&&sum>=13){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==4&&sum>=16){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==5&&sum>=20){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==2&&sum>=11){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==3&&sum>=14){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==4&&sum>=20){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==5&&sum>=23){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==6&&sum>=32){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==1&&sum>=7){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==0&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==2&&sum>=11){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==3&&sum>=14){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==4&&sum>=20){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==5&&sum>=24){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==6&&sum>=34){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==1&&sum>=8){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==0&&sum>=12){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==2&&sum>=12){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==3&&sum>=18){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==4&&sum>=23){
			 flag=true; 
		 }else if(addition==4&&buchang==10&&fixation==1&& number==5&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==6&&sum>=34){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==1&&sum>=8){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==0&&sum>=12){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==2&&sum>=12){
			 flag=true; 
		 }else if(addition==5&&buchang==10&&fixation==0&& number==3&&sum>=18){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==4&&sum>=23){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==5&&sum>=29){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==6&&sum>=36){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==1&&sum>=9){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==0&&sum>=13){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==2&&sum>=13){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==3&&sum>=20){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==4&&sum>=26){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==5&&sum>=30){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==6&&sum>=36){
			 flag=true;
		 }
		
		return flag; 
	}
	
	
	
	public  static boolean getGuilvScope(int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
		 
		 
		if(fixation!=0){
			fixation=1;
		}
		
		
		 if(addition==1&&buchang==5 && number==1&&sum>=4){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==0&& number==6&&sum>=13){
			 flag=true;
		 }else if(addition==1&&buchang==5&&fixation==1&& number==6&&sum>=17){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==0&& number==6&&sum>=20){
			 flag=true;
		 }else if(addition==2&&buchang==5&&fixation==1&& number==6&&sum>=26){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==0&& number==6&&sum>=26){
			 flag=true;
		 }else if(addition==3&&buchang==5&&fixation==1&& number==6&&sum>=28){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==0&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==4&&buchang==5&&fixation==1&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==0&& number==6&&sum>=31){
			 flag=true;
		 }else if(addition==5&&buchang==5&&fixation==1&& number==6&&sum>=36){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==0&& number==6&&sum>=17){
			 flag=true;
		 }else if(addition==1&&buchang==10&&fixation==1&& number==6&&sum>=19){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==0&& number==6&&sum>=21){
			 flag=true;
		 }else if(addition==2&&buchang==10&&fixation==1&& number==6&&sum>=27){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==0&& number==6&&sum>=29){
			 flag=true;
		 }else if(addition==3&&buchang==10&&fixation==1&& number==6&&sum>=32){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==0&& number==6&&sum>=33){
			 flag=true;
		 }else if(addition==4&&buchang==10&&fixation==1&& number==6&&sum>=34){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==0&& number==6&&sum>=36){
			 flag=true;
		 }else if(addition==5&&buchang==10&&fixation==1&& number==6&&sum>=37){
			 flag=true;
		 }
		
		return flag; 
	}
	

	public  static boolean getGuilvPeer(int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
			 
		 
		 if(addition==2&&buchang==5&&number==1&&sum>=5){
			 flag=true; 
		 }else if(addition==2&&buchang==5&&number==0&&sum>=9){
			 flag=true; 
		 }else if(addition==3&&buchang==5&&number==1&&sum>=8){
			 flag=true; 
		 }else if(addition==3&&buchang==5&&number==0&&sum>=12){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&number==1&&sum>=9){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&number==0&&sum>=14){
			 flag=true; 
		 }else if(addition==5&&buchang==5&&number==1&&sum>=9){
			 flag=true;  
		 }else if(addition==5&&buchang==5&&number==0&&sum>=14){
			 flag=true;  
		 }else if(addition==2&&buchang==10&&number==1&&sum>=6){
			 flag=true; 
		 }else if(addition==2&&buchang==10&&number==0&&sum>=9){
			 flag=true; 
		 }else if(addition==3&&buchang==10&&number==1&&sum>=10){
			 flag=true;  
		 }else if(addition==3&&buchang==10&&number==0&&sum>=13){
			 flag=true; 
		 }else if(addition==4&&buchang==10&&number==1&&sum>=10){
			 flag=true; 
		 }else if(addition==4&&buchang==10&&number==0&&sum>=14){
			 flag=true; 
		 }else if(addition==5&&buchang==10&&number==1&&sum>=10){
			 flag=true; 
		 }else if(addition==5&&buchang==10&&number==0&&sum>=15){
			 flag=true; 
		 }
		 
	    return flag;
	}

	
	public  static boolean getGuilvPeer3(int addition,int buchang,int fixation,int number, int sum){
		 boolean flag=false;
			 
		 
		 if(addition==2&&buchang==5&&number==1&&sum>=5){
			 flag=true; 
		 }else if(addition==2&&buchang==5&&number==0&&sum>=8){
			 flag=true; 
		 }else if(addition==3&&buchang==5&&number==1&&sum>=9){
			 flag=true; 
		 }else if(addition==3&&buchang==5&&number==0&&sum>=12){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&number==1&&sum>=9){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&number==0&&sum>=13){
			 flag=true; 
		 }else if(addition==5&&buchang==5&&number==1&&sum>=9){
			 flag=true;  
		 }else if(addition==5&&buchang==5&&number==0&&sum>=14){
			 flag=true;  
		 }else if(addition==2&&buchang==10&&number==1&&sum>=6){
			 flag=true; 
		 }else if(addition==2&&buchang==10&&number==0&&sum>=9){
			 flag=true; 
		 }else if(addition==3&&buchang==10&&number==1&&sum>=9){
			 flag=true;  
		 }else if(addition==3&&buchang==10&&number==0&&sum>=13){
			 flag=true; 
		 }else if(addition==4&&buchang==10&&number==1&&sum>=10){
			 flag=true; 
		 }else if(addition==4&&buchang==10&&number==0&&sum>=14){
			 flag=true; 
		 }else if(addition==5&&buchang==10&&number==1&&sum>=10){
			 flag=true; 
		 }else if(addition==5&&buchang==10&&number==0&&sum>=15){
			 flag=true; 
		 }
		 
	    return flag;
	}
	
	public  static boolean getSingleDouble(int addition,int buchang, int sum){
		 boolean flag=false;
			 
		 
		 if(addition==1&&buchang==5&&sum>=11){
			 flag=true; 
		 }else if(addition==2&&buchang==5&&sum>=13){
			 flag=true; 
		 }else if(addition==3&&buchang==5&&sum>=17){
			 flag=true; 
		 }else if(addition==4&&buchang==5&&sum>=20){
			 flag=true; 
		 }else if(addition==5&&buchang==5&&sum>=23){
			 flag=true; 
		 }else if(addition==1&&buchang==10&&sum>=12){
			 flag=true; 
		 }else if(addition==2&&buchang==10&&sum>=19){
			 flag=true; 
		 }else if(addition==3&&buchang==10&&sum>=20){
			 flag=true;  
		 }else if(addition==4&&buchang==10&&sum>=25){
			 flag=true;  
		 }else if(addition==5&&buchang==10&&sum>=27){
			 flag=true; 
		 }
		 
	    return flag;
	}

}
