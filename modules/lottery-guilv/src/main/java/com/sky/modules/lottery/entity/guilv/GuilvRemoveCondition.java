package com.sky.modules.lottery.entity.guilv;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;

@Entity
@Table(name = "t_guilv_remove_condition")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GuilvRemoveCondition extends IdLongEntity {
	
	private Integer fixation;
	
	private Integer buchang;
	
	
	private Integer addition; 
	
	private Integer number;  
	 
	private  Integer gui=1;
	
	private Integer sumCount;
	
	private  Integer sumMin;
	
	private Integer sum;
	
	private Integer sumNew;

	public Integer getFixation() {
		return fixation;
	}

	public void setFixation(Integer fixation) {
		this.fixation = fixation;
	}

	public Integer getBuchang() {
		return buchang;
	}

	public void setBuchang(Integer buchang) {
		this.buchang = buchang;
	}

	public Integer getAddition() {
		return addition;
	}

	public void setAddition(Integer addition) {
		this.addition = addition;
	}

	 

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

 

	public Integer getGui() {
		return gui;
	}

	public void setGui(Integer gui) {
		this.gui = gui;
	}

	public Integer getSumCount() {
		return sumCount;
	}

	public void setSumCount(Integer sumCount) {
		this.sumCount = sumCount;
	}

	public Integer getSumMin() {
		return sumMin;
	}

	public void setSumMin(Integer sumMin) {
		this.sumMin = sumMin;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getSumNew() {
		return sumNew;
	}

	public void setSumNew(Integer sumNew) {
		this.sumNew = sumNew;
	}
	
	
	
	
}
