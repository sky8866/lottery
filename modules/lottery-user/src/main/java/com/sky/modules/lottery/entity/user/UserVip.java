package com.sky.modules.lottery.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;

 
/**
 * 会员
 * @author sky
 *
 */
@Entity
@Table(name="p_user_vip") 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserVip extends IdLongEntity{
   
    
    private String starttime;
    
    private String endtime;
    
	private String openId;
    
 
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
    
    
    
    
}
