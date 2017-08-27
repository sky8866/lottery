package com.sky.modules.lottery.entity.user;

  
import java.util.Date; 
 
import javax.persistence.Entity; 
import javax.persistence.Table; 
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;  
import com.sky.modules.core.bean.IdLongEntity;
import com.sky.modules.core.utils.Aes;
import com.sky.modules.core.utils.StringUtils; 
/**
 * 用户
 * @author sky
 *
 */
 


@Entity
@Table(name="p_user_log") 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserLog extends IdLongEntity{  
	/**
	  * 用户名
	  */
	private String name;   
	
	  
	   
    private String url;  
    
    private String modules;
    
    private Long userId;
    
    
    
    
    
    
	
	public Long getUserId() {
		return userId;
	}





	public void setUserId(Long userId) {
		this.userId = userId;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getUrl() {
		return url;
	}





	public void setUrl(String url) {
		this.url = url;
	}





	public String getModules() {
		return modules;
	}





	public void setModules(String modules) {
		this.modules = modules;
	}


    


	/*用户注册时间**/
    private Date createDate=new Date();
  
    
    

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateDate() {
		return createDate;
	}
	
	
	
	

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
 
	  
	
 
 
				

			
}
