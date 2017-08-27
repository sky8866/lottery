package com.sky.modules.lottery.dao.user;

import com.sky.modules.core.dao.HibernateDao;
import com.sky.modules.lottery.entity.user.User;

 

public interface UserDao extends HibernateDao<User> {
    public User validate( String name, String password);

    public User validate( String name);

   

    public boolean exsitMobile(String name, Long uid);

    public boolean exsitMobile(String name);

    public void disableToUser(Integer visible, Long[] userids);

    public void delToUser(Long[] userids);

    public boolean exsitTokenid(String token_id);
 
    User findUserByMobile( String mobile); 
}
