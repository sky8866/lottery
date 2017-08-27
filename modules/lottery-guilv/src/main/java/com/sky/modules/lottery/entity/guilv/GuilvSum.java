package com.sky.modules.lottery.entity.guilv;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sky.modules.core.bean.IdLongEntity;
@Entity
@Table(name = "t_guilv_sum")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GuilvSum extends IdLongEntity {
	
	private String vaule;

	 
     String info;
     String info1;
     String info2;
     String info3;
     
     String info5;
     
     String info6;
     
     String info7;
     
     
	
	private Integer qi;

	
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
		return info1;
	}


	public void setInfo1(String info1) {
		this.info1 = info1;
	}


	public String getInfo2() {
		return info2;
	}


	public void setInfo2(String info2) {
		this.info2 = info2;
	}


	public String getInfo3() {
		return info3;
	}


	public void setInfo3(String info3) {
		this.info3 = info3;
	}


 

 
	public String getInfo5() {
		return info5;
	}


	public void setInfo5(String info5) {
		this.info5 = info5;
	}
	
	
	


	public String getInfo6() {
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


	public String getInfo7() {
		return info7;
	}


	public void setInfo7(String info7) {
		this.info7 = info7;
	}

	
	

}
