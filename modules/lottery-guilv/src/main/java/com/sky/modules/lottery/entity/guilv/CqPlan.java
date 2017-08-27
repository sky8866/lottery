package com.sky.modules.lottery.entity.guilv;

 

import javax.persistence.Entity;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy; 
import com.sky.modules.core.bean.IdLongEntity;

/**
 * 重庆计划
 * @author dorong01
 *
 */
@Entity
@Table(name = "t_cq_guilv_plan")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CqPlan extends IdLongEntity {
 

	 
	 private String number1;
     private String number2;
     private String number3;
     private String number4;
     private String number5; 
     
     private String value;
     
	
	private Long qi;
	 
	 
	
	private Integer sum=0;
	 
	 
	
	
	private Integer type;
  
	
	  /**
     * 0：开奖中，1:中，2：挂
     */
    private  Integer prize=0;


	public String getNumber1() {
		return number1;
	}


	public void setNumber1(String number1) {
		this.number1 = number1;
	}


	public String getNumber2() {
		return number2;
	}


	public void setNumber2(String number2) {
		this.number2 = number2;
	}


	public String getNumber3() {
		return number3;
	}


	public void setNumber3(String number3) {
		this.number3 = number3;
	}


	public String getNumber4() {
		return number4;
	}


	public void setNumber4(String number4) {
		this.number4 = number4;
	}


	public String getNumber5() {
		return number5;
	}


	public void setNumber5(String number5) {
		this.number5 = number5;
	}


	public Long getQi() {
		return qi;
	}


	public void setQi(Long qi) {
		this.qi = qi;
	}


	public Integer getSum() {
		return sum;
	}


	public void setSum(Integer sum) {
		this.sum = sum;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getPrize() {
		return prize;
	}


	public void setPrize(Integer prize) {
		this.prize = prize;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	 
	
    
    
    

}
