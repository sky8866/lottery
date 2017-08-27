package com.sky.modules.lottery.service.user;




 
import java.io.File;
import java.io.Serializable;  
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.core.security.utils.Digests;
import com.sky.modules.core.utils.Aes;
import com.sky.modules.core.utils.Encodes;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.core.utils.UUID;
import com.sky.modules.core.utils.UtilDate;
import com.sky.modules.lottery.dao.user.UserDao;
import com.sky.modules.lottery.dao.user.UserVipDao;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.entity.user.UserVip;
import com.sky.modules.lottery.service.user.ShiroWebRealm.ShiroUser;
import com.sky.modules.lottery.utils.user.MD5Utils; 
     
 




/**
 * 创建用户等相关操作
 * @author sky
 *
 */
@Service
public class MemberManager {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	 
 
	 
	
	@Autowired 
	private  UserDao userDao;
	@Autowired 
	private  UserVipDao userVipDao;
 
	public void delUser(Serializable... entityids){
		this.userDao.delete(entityids);
	}
	/**
	 * 用户登录
	 */
	
	public User validate(String name, String password){

		return this.userDao.validate(name, MD5Utils.getMD5Str(password));
	}
 
	
	public User validate(String name){

		return this.userDao.validate(name);
	}
 

	public Boolean isPwd(String pwd){
		boolean flag = false;
		 
		
		 User user = findUser(getUserId());
		
		byte[] hashPassword = Digests.sha1(pwd.getBytes(),Encodes.decodeHex(user.getSalt()), HASH_INTERATIONS);
		String password=Encodes.encodeHex(hashPassword);
	
	 
	    if(user.getPassword().equals(password)){
	    	flag=true;
	    }
		
		return flag;
	}
	
 
	/**
	 * 判断邮箱是否存在
	 */
	public boolean checkEmailorMobile(String property,String name){
		return this.userDao.exsit(property, name);
	}
	
	/**
	 * 判断邮箱是否存在
	 */
	public boolean checkMobile(String name,Long uid){
		return this.userDao.exsitMobile(name,uid);
	}
	
	
	 
	public boolean checkMobile(String name){
		return this.userDao.exsitMobile(name);
	}
	 
	/**
	 * 根据登录名字查询用户
	 * @param name
	 * @return
	 */
	 
	@Cacheable(value="departCache") 
    public User findUserByMobile(String mobile){
        return this.userDao.findUserByMobile(mobile);
    }
	
	public QueryResult<User> findPageUser(PageView<User> pv,List<PropertyFilter> filters ){
		return this.userDao.findPage(pv, filters);
	}
	 @Cacheable(value="departCache") 
		public QueryResult<User> findPageUser(PageView<User> pv,String query,  Integer visible){
		 
		 StringBuffer hql = new StringBuffer("");
		 
		 List<Object> queryParams = new ArrayList<Object>();
		 
		 hql.append("o.visible=?").append(queryParams.size()+1);
		 queryParams.add(visible);
		  
		 
        if(StringUtils.isNotEmpty(query)){
			 
        	hql.append(" and ( o.name like ?").append(queryParams.size()+1);
        	queryParams.add("%"+query+ "%");
        	hql.append(" or o.loginName like ?").append(queryParams.size()+1);
        	queryParams.add("%"+query+ "%");
        	  
        	hql.append(" )");
        	
		 }
		 
			 return findPageUser(pv,hql.toString(),  queryParams.toArray());
		}
	 
	 
	 
	 @Cacheable(value="departCache") 
     public QueryResult<User> findPageUser(PageView<User> pv,String hql, Object[] queryParams){
         return this.userDao.findPage(pv,   hql, queryParams);
     }
	 
    public List<User> findList(){
    	return this.userDao.findLists();
    }
	
	@Cacheable(value="departCache") 
	public User findUserToken(String token,String value){
		return this.userDao.findProperty(token, value);
	}
	
	public User findUser(Object p,Object v){
		return this.userDao.findProperty(p, v);
	}
	public List<User> findUsers(Object p,Object v){
		return this.userDao.findPropertyList(p, v);
	}
	
	@Cacheable(value="departCache") 
	public User findUser(Long id){ 
		return this.userDao.find(id);
	}
	 
	 @Cacheable(value="departCache") 
		public List<User> findList(Object property,Object value){
		 Object[] op=new Object[2];
	       op[0]=property;
	       op[1]="visible";
	       
	       
	       Object[] vo=new Object[2];
	       vo[0]=value;
	       vo[1]=1;
			return this.userDao.findPropertyList(op, vo);
		}
	 
	 
	  public UserVip findUserVip(Object property,Object value ){
		  return this.userVipDao.findProperty(property, value);
	  }
	  
		 
		 
	public void saveUser(User user){
		 
		entryptPassword(user);
		 
		this.userDao.save(user);
	}
	
	public void updateUser(User user){
		if (StringUtils.isNotEmpty(user.getPlainPassword())) {
			entryptPassword(user);
		}
		this.userDao.update(user);
	}
	
 
	
 
	
 
 
	/**
	 * 设定安全的密码
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	public Long getUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
	
	
	public String getUserAesId() {
		 
		return Aes.enparameter(getUserId()+"");
	}
	 
  
	public String getUserName(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.name;
	}

	public String getLoninName(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginname;
	}
 
	public String getOpenId(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.openId;
	}
 
	public String getUserImage(){
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.userimage;
    }
 
	public User getUser(){
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.user;
    }
public void disableToUser(Integer visible,Long[] userids){
	this.userDao.disableToUser(visible, userids);
}

public void delToUser(Long[] userids){
	this.userDao.delToUser(userids);
}

public boolean exsitTokenid(String token_id){
	return this.userDao.exsitTokenid(token_id);
}
 
 
public  void addUserGuanZhu(String openId,String userPictureUrl,String userName,String unionid,String remark,String groupid){
	 try {
	
		 addUserGuanZhu(openId, userPictureUrl, userName, unionid, remark, groupid, "");
		 
		 
	} catch (Exception e) {
		
	}
}
 

public  void addUserGuanZhu(String openId,String userPictureUrl,String userName,String unionid,String remark,String groupid,String eveentKeyString){
	 try {
	     
		 User vo=userDao.findProperty("openId", openId);
		 
		 if(StringUtils.isNotEmpty(userName)&&StringUtils.isNotEmpty(userPictureUrl)){
				if(vo==null){
					 
					  
					vo=new User();
					vo.setTokenId(UUID.getUUID());
					vo.setOpenId(openId);
				    vo.setPicture(userPictureUrl);
				    
				    vo.setName(userName);
				   vo.setUnionid(unionid);
				   vo.setRemark(remark);
				   vo.setGroupid(groupid);
				    vo.setEventKey(eveentKeyString);
				    vo.setIsVip(1);
		          userDao.save(vo);
		          
		          UserVip vip=new UserVip();
		          vip.setStarttime(UtilDate.getDateFormatter(new Date(), "yyyy-MM-dd"));
		          vip.setEndtime(UtilDate.getDateFormatter(UtilDate.getOldDate(-30, new Date()), "yyyy-MM-dd"));
		          vip.setOpenId(vo.getOpenId());
		          this.userVipDao.save(vip);
		          
				}else{
					  vo.setPicture(userPictureUrl); 
					    vo.setName(userName);
					   vo.setUnionid(unionid);
					   vo.setRemark(remark);
					   vo.setGroupid(groupid);
					   userDao.update(vo);
				} 
		 }

		 
		 
	} catch (Exception e) {
		
	}
}
  
 

}
