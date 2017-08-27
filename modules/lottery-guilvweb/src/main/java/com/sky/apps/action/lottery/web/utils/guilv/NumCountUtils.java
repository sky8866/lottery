package com.sky.apps.action.lottery.web.utils.guilv;

import com.sky.modules.lottery.entity.guilv.Guilv;
import com.sky.modules.lottery.entity.guilv.GuilvSame;
import com.sky.modules.lottery.entity.guilv.GuilvScope;

 

public class NumCountUtils {
	
	public  static int getCount(int addition,int buchang,int fixation,int number){
		int count=0;
		int b=5;
		int n=0;
		if(buchang==10){
			b=10;
			n=1;
		}
		
		if(fixation!=0){
			fixation=1;
		}
		
		 if(addition==1&&buchang==b&&fixation==0&& number==1){
			 count=3; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==0){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==2){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==3){
			 count=4+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==4){
			 count=4+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==5){
			 count=6+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==6){
			 count=8+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==1){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==0){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==2){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==3){
			 count=5+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==4){
			 count=7+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==5){
			 count=8+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==6){
			 count=13+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==1){
			 count=3+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==0){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==2){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==3){
			 count=5+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==4){
			 count=7+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==5){
			 count=8+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==6){
			 count=13+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==1){
			 count=3+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==0){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==2){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==3){
			 count=7+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==4){
			 count=9+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==5){
			 count=11+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==6){
			 count=15+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==1){
			 count=3+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==0){
			 count=5+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==2){
			 count=5+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==3){
			 count=7+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==4){
			 count=9+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==5){
			 count=11+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==6){
			 count=15+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==1){
			 count=4+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==0){
			 count=6+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==2){
			 count=6+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==3){
			 count=9+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==4){
			 count=13+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==5){
			 count=15+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==6){
			 count=17+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==1){
			 count=4+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==0){
			 count=6+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==2){
			 count=6+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==3){
			 count=9+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==4){
			 count=13+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==5){
			 count=15+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==6){
			 count=17+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==1){
			 count=5+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==0){
			 count=7+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==2){
			 count=7+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==3){
			 count=11+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==4){
			 count=15+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==5){
			 count=17+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==6){
			 count=22+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==1){
			 count=5+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==0){
			 count=7+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==2){
			 count=7+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==3){
			 count=11+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==4){
			 count=15+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==5){
			 count=17+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==6){
			 count=22+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==1){
			 count=6+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==0){
			 count=7+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==2){
			 count=7+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==3){
			 count=13+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==4){
			 count=17+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==5){
			 count=19+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==6){
			 count=25+n; 
		 }
		
		return count;
	}
	
	
	
	public  static int getCount2(int addition,int buchang,int fixation,int number){
		int count=0;
		int b=5;
		int n=0;
		if(buchang==10){
			b=10;
			n=1;
		}
		
		if(fixation!=0){
			fixation=1;
		}
		
		 if(addition==1&&buchang==b&&fixation==0&& number==1){
			 count=3; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==0){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==2){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==3){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==4){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==5){
			 count=4+n; 
		 }else if(addition==1&&buchang==b&&fixation==0&& number==6){
			 count=6+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==1){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==0){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==2){
			 count=3+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==3){
			 count=4+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==4){
			 count=5+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==5){
			 count=6+n; 
		 }else if(addition==1&&buchang==b&&fixation==1&& number==6){
			 count=9+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==1){
			 count=3+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==0){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==2){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==3){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==4){
			 count=5+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==5){
			 count=6+n; 
		 }else if(addition==2&&buchang==b&&fixation==0&& number==6){
			 count=10+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==1){
			 count=3+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==0){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==2){
			 count=4+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==3){
			 count=5+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==4){
			 count=7+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==5){
			 count=9+n; 
		 }else if(addition==2&&buchang==b&&fixation==1&& number==6){
			 count=12+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==1){
			 count=3+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==0){
			 count=5+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==2){
			 count=5+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==3){
			 count=6+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==4){
			 count=7+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==5){
			 count=9+n; 
		 }else if(addition==3&&buchang==b&&fixation==0&& number==6){
			 count=12+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==1){
			 count=4+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==0){
			 count=5+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==2){
			 count=5+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==3){
			 count=7+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==4){
			 count=10+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==5){
			 count=12+n; 
		 }else if(addition==3&&buchang==b&&fixation==1&& number==6){
			 count=14+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==1){
			 count=4+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==0){
			 count=5+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==2){
			 count=5+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==3){
			 count=7+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==4){
			 count=10+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==5){
			 count=12+n; 
		 }else if(addition==4&&buchang==b&&fixation==0&& number==6){
			 count=14+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==1){
			 count=5+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==0){
			 count=6+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==2){
			 count=6+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==3){
			 count=10+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==4){
			 count=12+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==5){
			 count=14+n; 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==6){
			 count=18+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==1){
			 count=5+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==0){
			 count=6+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==2){
			 count=6+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==3){
			 count=9+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==4){
			 count=12+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==5){
			 count=14+n; 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==6){
			 count=18+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==1){
			 count=5+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==0){
			 count=5+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==2){
			 count=6+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==3){
			 count=10+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==4){
			 count=15+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==5){
			 count=17+n; 
		 }else if(addition==5&&buchang==b&&fixation==1&& number==6){
			 count=20+n; 
		 }
		
		return count;
	}
	
	
	
	public  static void getGuilv(int addition,int buchang,int fixation,int number,Guilv vo, int sum,String infoString){
		 
		int b=5;
		int n=0;
		if(buchang==10){
			b=10;
			n=1;
		}
		if(fixation!=0){
			fixation=1;
		}
		
		
		 if(addition==1&&buchang==b&&fixation==0&& number==1&&sum>=4){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==0&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==2&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==3&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==4&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==5&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==6&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==0&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==2&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==3&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==4&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==5&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==6&&sum>=16){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==1&&sum>=4){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==0&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==2&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==3&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==4&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==5&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==6&&sum>=17){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==0&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==4&&sum>=12){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==5&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==6&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==0&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==4&&sum>=13){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==5&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==6&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==0&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==4&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==5&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==6&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==0&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==4&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==5&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==6&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==1&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==0&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==2&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==3&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==4&&sum>=18){
			 vo.setInfo(infoString); 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==5&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==6&&sum>=26){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==1&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==0&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==2&&sum>=10){
			 vo.setInfo(infoString); 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==3&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==4&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==5&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==6&&sum>=26){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==1&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==0&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==2&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==3&&sum>=16){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==4&&sum>=19){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==5&&sum>=22){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==6&&sum>=28){
			 vo.setInfo(infoString);
		 }
		
		 
	}

	
	public  static void getGuilvSame(int addition,int buchang,int fixation,int number,GuilvSame vo, int sum,String infoString){
		 
		int b=5;
		int n=0;
		if(buchang==10){
			b=10;
			n=1;
		}
		if(fixation!=0){
			fixation=1;
		}
		
		
		 if(addition==1&&buchang==b&&fixation==0&& number==1&&sum>=4){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==0&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==2&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==3&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==4&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==5&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==6&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==0&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==2&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==3&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==4&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==5&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==6&&sum>=16){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==1&&sum>=4){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==0&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==2&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==3&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==4&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==5&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==6&&sum>=17){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==0&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==4&&sum>=12){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==5&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==6&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==0&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==4&&sum>=13){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==5&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==6&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==0&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==4&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==5&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==6&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==0&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==4&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==5&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==6&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==1&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==0&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==2&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==3&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==4&&sum>=18){
			 vo.setInfo(infoString); 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==5&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==6&&sum>=26){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==1&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==0&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==2&&sum>=10){
			 vo.setInfo(infoString); 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==3&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==4&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==5&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==6&&sum>=26){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==1&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==0&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==2&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==3&&sum>=16){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==4&&sum>=19){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==5&&sum>=22){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==6&&sum>=28){
			 vo.setInfo(infoString);
		 }
		
		 
	}

	
	

	public  static void getGuilvScope(int addition,int buchang,int fixation,int number,GuilvScope vo, int sum,String infoString){
		 
		int b=5;
		int n=0;
		if(buchang==10){
			b=10;
			n=1;
		}
		if(fixation!=0){
			fixation=1;
		}
		
		
		 if(addition==1&&buchang==b&&fixation==0&& number==1&&sum>=4){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==0&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==2&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==3&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==4&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==5&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==0&& number==6&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==0&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==2&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==3&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==4&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==5&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==1&&buchang==b&&fixation==1&& number==6&&sum>=16){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==1&&sum>=4){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==0&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==2&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==3&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==4&&sum>=9){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==5&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==0&& number==6&&sum>=17){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==0&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==4&&sum>=12){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==5&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==2&&buchang==b&&fixation==1&& number==6&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==0&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==4&&sum>=13){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==5&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==0&& number==6&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==0&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==4&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==5&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==3&&buchang==b&&fixation==1&& number==6&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==1&&sum>=5){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==0&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==2&&sum>=8){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==3&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==4&&sum>=15){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==5&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==0&& number==6&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==1&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==0&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==2&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==3&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==4&&sum>=18){
			 vo.setInfo(infoString); 
		 }else if(addition==4&&buchang==b&&fixation==1&& number==5&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==4&&buchang==b&&fixation==1&& number==6&&sum>=26){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==1&&sum>=6){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==0&&sum>=10){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==2&&sum>=10){
			 vo.setInfo(infoString); 
		 }else if(addition==5&&buchang==b&&fixation==0&& number==3&&sum>=14){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==4&&sum>=18){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==5&&sum>=21){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==0&& number==6&&sum>=26){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==1&&sum>=7){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==0&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==2&&sum>=11){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==3&&sum>=16){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==4&&sum>=19){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==5&&sum>=22){
			 vo.setInfo(infoString);
		 }else if(addition==5&&buchang==b&&fixation==1&& number==6&&sum>=28){
			 vo.setInfo(infoString);
		 }
		
		 
	}
	
	
}
