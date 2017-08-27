package com.sky.modules.lottery.entity.guilv;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sky.modules.core.bean.IdLongEntity;
@Entity
@Table(name = "t_xjssc_guilv_plan")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XjsscPlan extends IdLongEntity {
 

	 
	 private String number1;
     private String number2;
     private String number3;
     private String number4;
     private String number5;
     private String number6;
     private String number7;
     
	
	private Long qi;
	 
	 
	
	private Integer sum;
	 
	

 
	
	private  Integer prize1=0;
	
	private Integer prize2=0;
	
	private Integer errorNum=0;
	private Integer errorMin=0;
	private Integer countMin=0;
	
	private Integer countNum=0;
	
	
	private Integer type;
 
	
	private Integer type2=0;
	
	private Integer type3=0;

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

	public String getNumber6() {
		return number6;
	}

	public void setNumber6(String number6) {
		this.number6 = number6;
	}

	public String getNumber7() {
		return number7;
	}

	public void setNumber7(String number7) {
		this.number7 = number7;
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

	public Integer getPrize1() {
		return prize1;
	}

	public void setPrize1(Integer prize1) {
		this.prize1 = prize1;
	}

	public Integer getPrize2() {
		return prize2;
	}

	public void setPrize2(Integer prize2) {
		this.prize2 = prize2;
	}

	public Integer getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

 

	public Integer getErrorMin() {
		return errorMin;
	}

	public void setErrorMin(Integer errorMin) {
		this.errorMin = errorMin;
	}

	public Integer getCountMin() {
		return countMin;
	}

	public void setCountMin(Integer countMin) {
		this.countMin = countMin;
	}

	public Integer getCountNum() {
		return countNum;
	}

	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType2() {
		return type2;
	}

	public void setType2(Integer type2) {
		this.type2 = type2;
	}

	public Integer getType3() {
		return type3;
	}

	public void setType3(Integer type3) {
		this.type3 = type3;
	}
	
	
	
	
	

}
