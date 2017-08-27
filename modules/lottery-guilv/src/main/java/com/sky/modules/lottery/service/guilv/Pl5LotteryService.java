 
package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.Pl5Lottery;
 

/**
 * 上报业务接口
 * @author sky
 * @version 1.0 2014-4-14
 */
public interface Pl5LotteryService {
    /**
     * 保存上报
     * @param r
     */
    public void saveReport(Pl5Lottery r);
    /**
     * 删除上报
     * @param entityids
     */
    public void delReport(Serializable... entityids);
    
    public void updateReport(Pl5Lottery r);
    
    /**
     * 根据条件查询上报列表
     */
    
    public  QueryResult<Pl5Lottery> findList(PageView<Pl5Lottery> pv, List<PropertyFilter> filters);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Pl5Lottery findReport(Long id);
    
    /**
     * 根据属性查询
     */
    public Pl5Lottery findReport(Object p,Object v);
    
    
    public Pl5Lottery findLottery5();
    /**
     * 查询与我相关的
     * @param pv
     * @param query
     * @param depquery
     * @param myuserid
     * @param starttime
     * @param endtime
     * @return
     */
    public QueryResult<Pl5Lottery> findReports(PageView pv, String query,String depquery,Long myuserid,String starttime,String endtime);

    public QueryResult<Pl5Lottery> findPageReport(PageView<Pl5Lottery> pv,Long companyId,String userid,String query,String depquery );
    /**
     * 查询与我相关的某人所发
     * @param pv
     * @param companyId
     * @param userid
     * @param query
     * @param depquery
     * @return
     */
    public QueryResult<Pl5Lottery> findReports(PageView pv, String query,String depquery,Long userid,Long myuserid,String starttime,String endtime);
}
