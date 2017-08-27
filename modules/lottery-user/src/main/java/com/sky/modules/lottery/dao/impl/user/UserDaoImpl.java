package com.sky.modules.lottery.dao.impl.user;
 
 
 
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sky.modules.core.dao.impl.HibernateDaoImpl;
import com.sky.modules.lottery.dao.user.UserDao;
import com.sky.modules.lottery.entity.user.User;
 
@Repository
public class UserDaoImpl extends HibernateDaoImpl<User> implements UserDao {
	 @Override
	    public User validate( String name, String password) {

	 

	        Query q = (Query) em
	                .createQuery("select u from User u where u.loginName=?1 and u.pwd=?2  and u.visible=?4 ")
	                .setParameter(1, name).setParameter(2, password).setParameter(4, 1);
	        List list = q.getResultList();
	        if (!list.isEmpty()) {
	            return (User) list.get(0);
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public User validate( String name) {

	        String field = null;
	        /*
	         * if(VaildUtils.isVaildMobile(name)){ field=" u.loginName="; } else
	         * if(VaildUtils.isVaildMobile(name)){ field=" u.mobile="; } else{
	         * field=" u.groupAccount="; }
	         */
	        // select u Userfrom User u where"+field+"?1 and u.password=?2
	        Query q = (Query) em
	                .createQuery("select u from User u where u.loginName=?1  and u.visible=?4 ")
	                .setParameter(1, name).setParameter(4, 1);
	        List list = q.getResultList();
	        if (!list.isEmpty()) {
	            return (User) list.get(0);
	        } else {
	            return null;
	        }
	    }

	    
	   
	    @Override
	    public User findUserByMobile(String mobile) {

	     
	        Query q = (Query) em.createQuery("select u from User u where u.loginName=?1 ").setParameter(1, mobile);
	        List list = q.getResultList();
	        if (!list.isEmpty()) {
	            return (User) list.get(0);
	        } else {
	            return null;
	        }
	    }
	    @Override
	    public boolean exsitMobile(String name, Long uid) {
	        try {
	            long count = (Long) em
	                    .createQuery("select count(o) from User o where o.loginName=?1 and o.id!=?2 ")
	                    .setParameter(1, name).setParameter(2, uid).getSingleResult();

	            return count > 0;
	        } catch (Exception e) {
	            return false;
	        }

	    }
	    
	   
	    @Override
	    public boolean exsitTokenid(String token_id) {
	        try {
	            long count = (Long) em.createQuery("select count(o) from User o where o.tokenId=?1 and o.visible=?4")
	                    .setParameter(1, token_id).setParameter(4, 1).getSingleResult();

	            return count > 0;
	        } catch (Exception e) {
	            return false;
	        }

	    }

	    @Override
	    public boolean exsitMobile(String name) {
	        long count = 0;
	        try {
	            count = (Long) em.createQuery("select count(o) from User o where o.loginName=?1")
	                    .setParameter(1, name).getSingleResult();

	            return count > 0;
	        } catch (Exception e) {

	        }
	        return false;
	    }

	    public void disableToUser(Integer visible, Long[] userids) {
	        StringBuffer sb = new StringBuffer();
	        for (Long s : userids) {
	            sb.append(s);
	            sb.append(",");
	        }
	        if (sb.length() > 1) {
	            sb.deleteCharAt(sb.length() - 1);
	            String hql = "update User u set u.visible=" + visible + " where  u.isAdmin!=0 and u.id in(" + sb.toString()
	                    + ")";

	            Query query = em.createQuery(hql);

	            query.executeUpdate();
	        }

	    }

	 

	    public void delToUser(Long[] userids) {
	        StringBuffer sb = new StringBuffer();
	        for (Long s : userids) {
	            sb.append(s);
	            sb.append(",");
	        }
	        if (sb.length() > 1) {
	            sb.deleteCharAt(sb.length() - 1);
	            String hql = "update User u set u.visible=2, u.loginName='', u.departmentId='' where  u.isAdmin!=0 and u.id in("
	                    + sb.toString() + ")";

	            Query query = em.createQuery(hql);

	            query.executeUpdate();

	        }

	    }

		 
	    
}
