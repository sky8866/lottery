 
package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.lottery.entity.guilv.TjsscLottery;
 

/**
 * 上报业务接口
 * @author sky
 * @version 1.0 2014-4-14
 */
public interface TjsscLotteryService {
    /**
     * 保存上报
     * @param r
     */
    public void saveReport(TjsscLottery r);
    /**
     * 删除上报
     * @param entityids
     */
    public void delReport(Serializable... entityids);
    
    public void updateReport(TjsscLottery r);
    
    /**
     * 根据条件查询上报列表
     */
    
    public  QueryResult<TjsscLottery> findList(PageView<TjsscLottery> pv, List<PropertyFilter> filters);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public TjsscLottery findReport(Long id);
    
    /**
     * 根据属性查询
     */
    public TjsscLottery findReport(Object p,Object v);
    
    
    public TjsscLottery findLottery6();
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
    public QueryResult<TjsscLottery> findReports(PageView pv, String query,String depquery,Long myuserid,String starttime,String endtime);

    public QueryResult<TjsscLottery> findPageReport(PageView<TjsscLottery> pv,Long companyId,String userid,String query,String depquery );
    /**
     * 查询与我相关的某人所发
     * @param pv
     * @param companyId
     * @param userid
     * @param query
     * @param depquery
     * @return
     */
    public QueryResult<TjsscLottery> findReports(PageView pv, String query,String depquery,Long userid,Long myuserid,String starttime,String endtime);
}
