package com.sky.modules.lottery.service.impl.guilv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
import com.sky.modules.core.utils.Aes;
import com.sky.modules.core.utils.StringUtils;
import com.sky.modules.lottery.dao.guilv.XjsscLotteryDao;
import com.sky.modules.lottery.entity.guilv.XjsscLottery;
import com.sky.modules.lottery.service.guilv.XjsscLotteryService;
@Service
public class XjsscLotteryServiceImpl implements XjsscLotteryService {
@Autowired private XjsscLotteryDao reportDao;
	
	@Override
	public void saveReport(XjsscLottery r) {
	this.reportDao.save(r);

	}

	@Override
	public void delReport(Serializable... entityids) {
		 this.reportDao.delete(entityids);

	}

	@Override
	public void updateReport(XjsscLottery r) {
		this.reportDao.update(r);

	}

	@Override
	public QueryResult<XjsscLottery> findList(PageView<XjsscLottery> pv,
			List<PropertyFilter> filters) {
	 
		return this.reportDao.findPage(pv, filters);
	}

	 @Cacheable(value="departCache") 
		public QueryResult<XjsscLottery> findPageReport(PageView<XjsscLottery> pv,Long companyId,String userid,String query,String depquery ){
		 
		 StringBuffer hql = new StringBuffer("1=1 and ");
		 
		 List<Object> queryParams = new ArrayList<Object>();
		 hql.append("o.companyId=?").append(queryParams.size()+1);
		 queryParams.add(companyId);  
		 if(StringUtils.isNotEmpty(userid)){
			 hql.append(" and o.userId=?").append(queryParams.size()+1);
			 
			 queryParams.add(Aes.deparameter(userid));
		 }
		 if(StringUtils.isNotEmpty(depquery)){
			 hql.append(" and o.depId=?").append(queryParams.size()+1);
			 
			 queryParams.add(Aes.deparameter(depquery));
		 }
		 
       if(StringUtils.isNotEmpty(query)){
			 
       	hql.append(" and ( o.username like ?").append(queryParams.size()+1);
       	queryParams.add("%"+query+ "%");
       	hql.append(" or o.type like ?").append(queryParams.size()+1);
       	queryParams.add("%"+query+ "%");
       	hql.append(" or o.content like ?").append(queryParams.size()+1);
       	queryParams.add("%"+query+ "%");
       	hql.append(" )");
       	
		 }
		 
			 return findPageReport(pv,hql.toString(),  queryParams.toArray());
		}
	
	 @Cacheable(value="departCache") 
     public QueryResult<XjsscLottery> findPageReport(PageView<XjsscLottery> pv,String hql, Object[] queryParams){
         return this.reportDao.findPage(pv,   hql, queryParams);
     }
	@Override
	public XjsscLottery findReport(Long id) {
		 
		return this.reportDao.find(id);
	}

	@Override
	public XjsscLottery findReport(Object p, Object v) {
		 
		return this.reportDao.findProperty(p, v);
	}
 
	@Override
	public QueryResult<XjsscLottery> findReports(PageView pv, String query,String depquery,Long myuserid,String starttime,String endtime) {
	 
        
        return findReports(pv, query,depquery, myuserid,null,starttime, endtime);
	}
	
	
	@Override
	public QueryResult<XjsscLottery> findReports(PageView pv, String query,String depquery,Long myuserid,Long userid,String starttime,String endtime) {
	    String date="1=1 ";
        if (myuserid!=null) {
                date=date+"and gu.userId="+myuserid;
        }
        if (StringUtils.isNotEmpty(query)) {
            date=date+" and (u.username  like '%"+query+"%' or u.type like '%"+query+"%'  or u.content like '%"+query+"%')";
        }
        if(userid!=null){
        	 date=date+" and u.userId="+userid;
        }
        if (StringUtils.isNotEmpty(depquery)) {
            date=date+" and u.depId="+Aes.deparameter(depquery);
        }
        String start="";
        String end=""; 
        if (!StringUtils.isNotEmpty(starttime)) {
            start = "2014-01-01";
        }else{
            start=starttime+" 00:00:00";
        }
        if (!StringUtils.isNotEmpty(endtime)) {
            end = "2100-12-31";
        }else{
            end = endtime+" 23:59:59"; 
        }
         
        date=date+" and u.createDate between '"+start+"' and '"+end+"'";
        String hql="select  u from Report u,ReportUser gu where u.id=gu.reportId  and  "+date+"  order by u.createDate desc";  
        String chql="select  count(u) from Report u,ReportUser gu where u.id=gu.reportId  and  "+date+"  order by u.createDate desc";  
         
        
        return  reportDao.findHQLPage(pv, hql,chql);
	}

	@Override
	public XjsscLottery findLottery3() {
		 String hql="select  u from Lottery3 u  order by u.id desc";  
		 XjsscLottery Lottery3=this.reportDao.findHQL(hql);
		return Lottery3;
	}

	
}
