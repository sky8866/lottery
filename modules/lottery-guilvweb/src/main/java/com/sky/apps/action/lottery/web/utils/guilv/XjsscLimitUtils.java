package com.sky.apps.action.lottery.web.utils.guilv;
 
import com.sky.modules.lottery.entity.guilv.CqsscLottery; 
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
 


public class XjsscLimitUtils {
	 
	
	public  static boolean getQuery(XjsscLottery lotterie,int type){
                 Boolean flag=false;
                    if(type==0){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    	 
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    	
                    /*	System.out.println("qi:"+lotterie.getQi()+",号1："+lotterie.getNumber1()+",号二："+lotterie.getNumber2());
                        System.out.println("结果："+flag);*/
                    
                    }else if(type==1){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==2){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==3){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==4){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==5){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==6){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==7){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==8){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==9){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==10){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==11){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==12){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==13){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==14){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==15){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==16){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==17){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==18){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==19){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=5;mm[1]=6;mm[2]=7;mm[3]=8;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==20){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==21){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==22){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==23){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==24){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==25){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==26){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==27){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==28){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==29){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==30){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==31){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==32){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                     
                    }else if(type==33){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==34){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==35){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==36){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==37){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==38){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==39){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=1;mm[2]=2;mm[3]=3;mm[4]=4;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==40){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==41){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==42){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==43){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==44){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==45){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==46){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==47){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==48){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==49){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==50){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==51){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==52){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==53){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==54){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==55){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==56){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==57){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==58){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==59){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=1;mm[1]=3;mm[2]=5;mm[3]=7;mm[4]=9;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==60){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==61){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==62){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==63){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==64){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==65){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==66){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==67){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==68){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==69){
                    	int c=0;
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==70){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==71){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==72){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==73){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==74){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==75){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==76){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==77){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==78){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==79){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	
                    	Integer[] mm=new Integer[5];
                    	mm[0]=0;mm[1]=2;mm[2]=4;mm[3]=6;mm[4]=8;
                    	for(Integer m:mm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	
                    	
                    	if(c>1){
                    		flag=true;
                    	}
                    }else if(type==80){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=1;mmm[2]=2;mmm[3]=3;mmm[4]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==81){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=1;mmm[2]=2;mmm[3]=3;mmm[4]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==82){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=1;mmm[2]=2;mmm[3]=3;mmm[4]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==83){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=1;mmm[2]=2;mmm[3]=3;mmm[4]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==84){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=1;mmm[2]=2;mmm[3]=3;mmm[4]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==85){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==86){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==87){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==88){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==89){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=5;mmm[1]=6;mmm[2]=7;mmm[3]=8;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==90){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=2;mmm[2]=4;mmm[3]=6;mmm[4]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==91){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=2;mmm[2]=4;mmm[3]=6;mmm[4]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==92){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=2;mmm[2]=4;mmm[3]=6;mmm[4]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==93){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=2;mmm[2]=4;mmm[3]=6;mmm[4]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==94){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=0;mmm[1]=2;mmm[2]=4;mmm[3]=6;mmm[4]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==95){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==96){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==97){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==98){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==99){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[5];
                    	mmm[0]=1;mmm[1]=3;mmm[2]=5;mmm[3]=7;mmm[4]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==100){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=1;mmm[1]=2;mmm[2]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==101){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=4;mmm[1]=5;mmm[2]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==102){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=7;mmm[1]=8;mmm[2]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==103){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=1;mmm[1]=2;mmm[2]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==104){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=4;mmm[1]=5;mmm[2]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==105){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=7;mmm[1]=8;mmm[2]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==106){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=1;mmm[1]=2;mmm[2]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==107){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=4;mmm[1]=5;mmm[2]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==108){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=7;mmm[1]=8;mmm[2]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==109){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=1;mmm[1]=2;mmm[2]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==110){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=4;mmm[1]=5;mmm[2]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==111){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=7;mmm[1]=8;mmm[2]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==112){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=1;mmm[1]=2;mmm[2]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==113){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=4;mmm[1]=5;mmm[2]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==114){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[3];
                    	mmm[0]=7;mmm[1]=8;mmm[2]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==115){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=0; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==116){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=1; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==117){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=2; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==118){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==119){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==120){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==121){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==122){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==123){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==124){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==125){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=0; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==126){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=1; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==127){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=2; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==128){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==129){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==130){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==131){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==132){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==133){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==134){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==135){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=0; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==136){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=1; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==137){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=2; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==138){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==139){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==140){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==141){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==142){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==143){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==144){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==145){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=0; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==146){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=1; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==147){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=2; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==148){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==149){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==150){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==151){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==152){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==153){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==154){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==155){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=0; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==156){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=1; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==157){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=2; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==158){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==159){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=4; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==160){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==161){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=6; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==162){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==163){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=8; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==164){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[1];
                    	mmm[0]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==165){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=0; mmm[1]=1;
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==166){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=2; mmm[1]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==167){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=4; mmm[1]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==168){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=6; mmm[1]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==169){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=8; mmm[1]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber1()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==170){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=0; mmm[1]=1;
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==171){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=2; mmm[1]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==172){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=4; mmm[1]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==173){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=6; mmm[1]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==174){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=8; mmm[1]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber2()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==175){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=0; mmm[1]=1;
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==176){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=2; mmm[1]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==177){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=4; mmm[1]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==178){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=6; mmm[1]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==179){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=8; mmm[1]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber3()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==180){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=0; mmm[1]=1;
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==181){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=2; mmm[1]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==182){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=4; mmm[1]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==183){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=6; mmm[1]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==184){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=8; mmm[1]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber4()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==185){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=0; mmm[1]=1;
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==186){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=2; mmm[1]=3; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==187){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=4; mmm[1]=5; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==188){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=6; mmm[1]=7; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }else if(type==189){
                    	int c=0;
                    	
                    	Integer[] mmm=new Integer[2];
                    	mmm[0]=8; mmm[1]=9; 
                    	for(Integer m:mmm){
                    		if(lotterie.getNumber5()==m){
                    			c++;
                    		}
                    	}
                    	 
                    	
                    	if(c>=1){
                    		flag=true;
                    	}
                    }
		 
	            return flag;                         

				 
		    }
	
	
	
			
		
 
	
	 
 

}
