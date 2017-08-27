package com.sky.modules.lottery.entity.guilv;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;
/**
 * 天津极限
 * @author dorong01
 *
 */
@Entity
@Table(name = "t_tjssc_guilv_limit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TjsscGuilvLimit extends IdLongEntity {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	 private Integer minSum;
	 
	 private  Integer type;
	 
	 private Integer num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMinSum() {
		return minSum;
	}

	public void setMinSum(Integer minSum) {
		this.minSum = minSum;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	 
	 
	 
	 
	

}
