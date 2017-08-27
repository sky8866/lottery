package com.sky.modules.lottery.service.user;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.user.User;
import com.sky.modules.lottery.entity.user.UserVip;
 

public interface UserVipService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  UserVip  findUserVip(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveUserVip(UserVip r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateUserVip(UserVip r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delUserVip(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public UserVip findUserVip(Object p,Object v);
	
	public QueryResult<UserVip> findPageUser(PageView<UserVip> pv,List<PropertyFilter> filters );
}
