package com.sky.modules.lottery.service.user;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.entity.user.UserLog;
 

public interface UserLogService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  UserLog  findUserLog(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveUserLog(UserLog r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateUserLog(UserLog r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delUserLog(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public UserLog findUserLog(Object p,Object v);
	
	public QueryResult<UserLog> findPageUser(PageView<UserLog> pv,List<PropertyFilter> filters );
}
