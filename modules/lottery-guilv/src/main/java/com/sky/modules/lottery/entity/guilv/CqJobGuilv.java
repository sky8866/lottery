package com.sky.modules.lottery.entity.guilv;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;

/**
 * 排列规律
 * @author dorong01
 *
 */
@Entity
@Table(name = "t_cq_job_guilv")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CqJobGuilv extends IdLongEntity {
 
	private Long qi;

	public Long getQi() {
		return qi;
	}

	public void setQi(Long qi) {
		this.qi = qi;
	}
	
	 
	

}
