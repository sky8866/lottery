package com.sky.modules.lottery.entity.guilv;

 
 

import javax.persistence.Entity;
import javax.persistence.Table;  
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;
 
/**
 * 重庆开奖记录
 * 
 * @author sky
 * @version 1.0 2014-4-14
 */
@Entity
@Table(name = "t_cqssc_lottery")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CqsscLottery extends IdLongEntity {
	private  Integer qi;
	private Integer zhi;
     private Integer number1;
     private Integer number2;
     private Integer number3;
     private Integer number4;
     private Integer number5;
     private Integer number6;
     private Integer number7;
     
     private Integer sum;
     
     private Integer key;
  
     
     
     
	public Integer getQi() {
		return qi;
	}
	public void setQi(Integer qi) {
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
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
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
   
   
	 private Integer vv1;
   private Integer vv2;
   private Integer vv3;
   private Integer vv4;
   private Integer vv5;
   private Integer vv6;
   private Integer vv7;
   



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
	  @Transient
	public Integer getVv1() {
		return vv1;
	}
	public void setVv1(Integer vv1) {
		this.vv1 = vv1;
	}
	  @Transient
	public Integer getVv2() {
		return vv2;
	}
	public void setVv2(Integer vv2) {
		this.vv2 = vv2;
	}
	  @Transient
	public Integer getVv3() {
		return vv3;
	}
	public void setVv3(Integer vv3) {
		this.vv3 = vv3;
	}
	  @Transient
	public Integer getVv4() {
		return vv4;
	}
	public void setVv4(Integer vv4) {
		this.vv4 = vv4;
	}
	  @Transient
	public Integer getVv5() {
		return vv5;
	}
	public void setVv5(Integer vv5) {
		this.vv5 = vv5;
	}
	  @Transient
	public Integer getVv6() {
		return vv6;
	}
	public void setVv6(Integer vv6) {
		this.vv6 = vv6;
	}
	  @Transient
	public Integer getVv7() {
		return vv7;
	}
	public void setVv7(Integer vv7) {
		this.vv7 = vv7;
	}
   
   
	 private Integer p1;
   private Integer p2;
   private Integer p3;
   private Integer p4;
   private Integer p5;
   private Integer p6;
   private Integer p7;
	
	 private Integer pp1;
   private Integer pp2;
   private Integer pp3;
   private Integer pp4;
   private Integer pp5;
   private Integer pp6;
   private Integer pp7;



   @Transient
	public Integer getP1() {
		return p1;
	}
	public void setP1(Integer p1) {
		this.p1 = p1;
	}
	 @Transient
	public Integer getP2() {
		return p2;
	}
	public void setP2(Integer p2) {
		this.p2 = p2;
	} @Transient
	public Integer getP3() {
		return p3;
	}
	public void setP3(Integer p3) {
		this.p3 = p3;
	} @Transient
	public Integer getP4() {
		return p4;
	}
	public void setP4(Integer p4) {
		this.p4 = p4;
	} @Transient
	public Integer getP5() {
		return p5;
	}
	public void setP5(Integer p5) {
		this.p5 = p5;
	} @Transient
	public Integer getP6() {
		return p6;
	}
	public void setP6(Integer p6) {
		this.p6 = p6;
	} @Transient
	public Integer getP7() {
		return p7;
	}
	public void setP7(Integer p7) {
		this.p7 = p7;
	} @Transient
	public Integer getPp1() {
		return pp1;
	}
	public void setPp1(Integer pp1) {
		this.pp1 = pp1;
	} @Transient
	public Integer getPp2() {
		return pp2;
	}
	public void setPp2(Integer pp2) {
		this.pp2 = pp2;
	} @Transient
	public Integer getPp3() {
		return pp3;
	}
	public void setPp3(Integer pp3) {
		this.pp3 = pp3;
	} @Transient
	public Integer getPp4() {
		return pp4;
	}
	public void setPp4(Integer pp4) {
		this.pp4 = pp4;
	} @Transient
	public Integer getPp5() {
		return pp5;
	}
	public void setPp5(Integer pp5) {
		this.pp5 = pp5;
	} @Transient
	public Integer getPp6() {
		return pp6;
	}
	public void setPp6(Integer pp6) {
		this.pp6 = pp6;
	} @Transient
	public Integer getPp7() {
		return pp7;
	}
	public void setPp7(Integer pp7) {
		this.pp7 = pp7;
	}
	
   
	
     
 

}
