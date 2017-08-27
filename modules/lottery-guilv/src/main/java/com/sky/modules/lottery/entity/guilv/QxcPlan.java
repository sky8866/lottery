package com.sky.modules.lottery.entity.guilv;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table; 

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy; 
import com.sky.modules.core.bean.IdLongEntity;
@Entity
@Table(name = "t_qxc_guilv_plan")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QxcPlan extends IdLongEntity {
 

	 
	 private String plan;
     private String vlaue; 
     private Integer type;
     /**
      * 0：开奖中，1:中，2：挂
      */
     private Integer prize=0;
     
	 private Integer qi;
	 
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getVlaue() {
		return vlaue;
	}
	public void setVlaue(String vlaue) {
		this.vlaue = vlaue;
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
	public Integer getQi() {
		return qi;
	}
	public void setQi(Integer qi) {
		this.qi = qi;
	}
	 
	 
    
	
	
	
	

}
