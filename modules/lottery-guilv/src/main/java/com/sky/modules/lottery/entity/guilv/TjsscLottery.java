package com.sky.modules.lottery.entity.guilv;

 
 

import javax.persistence.Entity;
import javax.persistence.Table;  
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;
 
/**
 * 天津开奖
 * 
 * @author sky
 * @version 1.0 2014-4-14
 */
@Entity
@Table(name = "t_tjssc_lottery")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TjsscLottery extends IdLongEntity {
	private  Long qi;
	private Integer zhi;
     private Integer number1;
     private Integer number2;
     private Integer number3;
     private Integer number4;
     private Integer number5;
     private Integer number6;
     private Integer number7;
     
     private Long sum;
     
     private Integer key;
  
     
     
     
	public Long getQi() {
		return qi;
	}
	public void setQi(Long qi) {
		this.qi = qi;
	}
	public Integer getZhi() {
		return zhi;
	}
	public void setZhi(Integer zhi) {
		this.zhi = zhi;
	}
	public Integer getNumber1() {
		return number1;
	}
	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}
	public Integer getNumber2() {
		return number2;
	}
	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}
	public Integer getNumber3() {
		return number3;
	}
	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}
	public Integer getNumber4() {
		return number4;
	}
	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}
	public Integer getNumber5() {
		return number5;
	}
	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}
	public Integer getNumber6() {
		return number6;
	}
	public void setNumber6(Integer number6) {
		this.number6 = number6;
	}
	public Integer getNumber7() {
		return number7;
	}
	public void setNumber7(Integer number7) {
		this.number7 = number7;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	 
	
	@Transient
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	
	
	 private Integer v1;
     private Integer v2;
     private Integer v3;
     private Integer v4;
     private Integer v5;
     private Integer v6;
     private Integer v7;



     @Transient
	public Integer getV1() {
		return v1;
	}
	public void setV1(Integer v1) {
		this.v1 = v1;
	}
	@Transient
	public Integer getV2() {
		return v2;
	}
	public void setV2(Integer v2) {
		this.v2 = v2;
	}
	@Transient
	public Integer getV3() {
		return v3;
	}
	public void setV3(Integer v3) {
		this.v3 = v3;
	}
	@Transient
	public Integer getV4() {
		return v4;
	}
	public void setV4(Integer v4) {
		this.v4 = v4;
	}
	@Transient
	public Integer getV5() {
		return v5;
	}
	public void setV5(Integer v5) {
		this.v5 = v5;
	}
	@Transient
	public Integer getV6() {
		return v6;
	}
	public void setV6(Integer v6) {
		this.v6 = v6;
	}
	@Transient
	public Integer getV7() {
		return v7;
	}
	public void setV7(Integer v7) {
		this.v7 = v7;
	}
     
     
     
	
	
     
 

}
