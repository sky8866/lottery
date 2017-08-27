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
@Table(name="p_user") 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends IdLongEntity{ 
	
	
	
	/**
	  * 用户名
	  */
	private String name;
	/**
	 * 登录名，一般是手机号
	 */
	private String loginName;
	/**
	 * 密码
	 */
	private String password;  
	/**
	 * 性别
	 */
	private Integer gender=1;

	/**
	 * 密码，手机端的
	 */
	private String pwd;

	/**
	 * salt
	 */
	private String salt;

	
	/*头像**/
	private String picture;
	/**
	 * 此ID会随着密码改变而改变
	 */
	private String tokenId;
	 

	
	
	/**
	 * 1:启用，0：停用
	 */
	private Integer visible=1;
	
	/*最近登录时间**/
	private String  loaDate ;
	
	/**
	 * 来源
	 */
	
	private String source="web";
	 
	private String unionid; 
	private String remark;
	private String groupid;
   
	private Integer isVip=0;
    
	
	/*用户注册时间**/
    private Date createDate=new Date();
    
   
	private String openId;
	
	private String eventKey;
	
	private String ticket;
	
	private Integer type=0;
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	 
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	 
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	 
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	 
	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	 
	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	 
	public String getLoaDate() {
		return loaDate;
	}

	public void setLoaDate(String loaDate) {
		this.loaDate = loaDate;
	}
	 
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	 
	 
	 
	 
		

 

	 

	
	
	
 
	
	
	
  
 
	
	 

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateDate() {
		return createDate;
	}
	
	
	
	

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
 
	  
	
	 
		
		public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

		public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

		@Transient
		public String getImagePath(){ 
			if(picture!=null&&picture.length()>39) return picture;
			if(!StringUtils.isNotEmpty(picture)) return "http://www.yaoganma.com/static/images/user2-160x160.jpg";
			return null;
		}
		
		 
	
		  private String plainPassword;
			@Transient
			@JsonIgnore
			 
			public String getPlainPassword() {
				return plainPassword;
			}

			public void setPlainPassword(String plainPassword) {
				this.plainPassword = plainPassword;
			}
			
			@Transient
			public String getUsertype(){ 
				 if(isVip==1){
					 return "高级会员";
				 }
				return "普通会员";
			}
			
		   public String endDate;
		   @Transient
		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		   
		@Transient
	    public String getAes(){
	    	return Aes.enparameter(id+"");
	    			
	    }

		public String getTicket() {
			return ticket;
		}

		public void setTicket(String ticket) {
			this.ticket = ticket;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}
		   
				

			
}
