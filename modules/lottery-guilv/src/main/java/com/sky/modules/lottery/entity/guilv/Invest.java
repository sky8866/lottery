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
@Table(name = "t_guilv_invest")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Invest extends IdLongEntity {
	
	private String vaule;

	 
     String info;
     String info1;
     String info2;
     String info3;
     
     String info5;
     
     String info6;
     
     
	
	private Integer qi;
	
	private Double money;
	
	private Double sumMoney;
	
	private Double putInto;
	
	private Integer sum;
	
	private Double  money1;
	
	private Double money2;

	public Integer getSum() {
		return sum;
	}


	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	private  Integer prize1;
	
	private Integer prize2;
	
	
    private Integer type;
    
	private Integer p1=0;
	
	private Integer p2=0;
	
	
	private Integer visible=0;

	
	/*用户注册时间**/
    private Date createDate=new Date();

	public String getVaule() {
		return vaule;
	}


	public void setVaule(String vaule) {
		this.vaule = vaule;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public Integer getQi() {
		return qi;
	}


	public void setQi(Integer qi) {
		this.qi = qi;
	}

	 
	 
 
	public String getInfo1() {
		String ss="******";
		if(visible==1){
			return ss;
		}
		return info1;
	}


	public void setInfo1(String info1) {
		this.info1 = info1;
	}


	public String getInfo2() {
		String ss="******";
		if(visible==1){
			return ss;
		}
		return info2;
	}


	public void setInfo2(String info2) {
		this.info2 = info2;
	}


	public String getInfo3() {
		String ss="******";
		if(visible==1){
			return ss;
		}
		return info3;
	}


	public void setInfo3(String info3) {
		this.info3 = info3;
	}


 

 
	public String getInfo5() {
		String ss="******";
		if(visible==1){
			return ss;
		}
		return info5;
	}


	public void setInfo5(String info5) {
		this.info5 = info5;
	}
	
	
	


	public String getInfo6() {
		String ss="******";
		if(visible==1&&info6!=null){
			return ss;
		}
		return info6;
	}


	public void setInfo6(String info6) {
		this.info6 = info6;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Double getMoney() {
		return money;
	}


	public void setMoney(Double money) {
		this.money = money;
	}


	public Double getSumMoney() {
		return sumMoney;
	}


	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}


	public Double getPutInto() {
		return putInto;
	}


	public void setPutInto(Double putInto) {
		this.putInto = putInto;
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


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getP1() {
		return p1;
	}


	public void setP1(Integer p1) {
		this.p1 = p1;
	}


	public Integer getP2() {
		return p2;
	}


	public void setP2(Integer p2) {
		this.p2 = p2;
	}


	public Double getMoney1() {
		return money1;
	}


	public void setMoney1(Double money1) {
		this.money1 = money1;
	}


	public Double getMoney2() {
		return money2;
	}


	public void setMoney2(Double money2) {
		this.money2 = money2;
	}


	public Integer getVisible() {
		return visible;
	}


	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	
	
	
	
	
	

}
