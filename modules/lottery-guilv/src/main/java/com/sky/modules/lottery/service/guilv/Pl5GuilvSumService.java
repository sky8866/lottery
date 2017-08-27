package com.sky.modules.lottery.service.guilv;

import java.io.Serializable;
import java.util.List;

import com.sky.modules.core.bean.PageView;
import com.sky.modules.core.bean.PropertyFilter;
import com.sky.modules.core.bean.QueryResult;
 
import com.sky.modules.lottery.entity.guilv.Pl5GuilvSum;

public interface Pl5GuilvSumService {

	void savePl5GuilvSum(Pl5GuilvSum r);

	void delPl5GuilvSum(Serializable[] entityids);

	void updatePl5GuilvSum(Pl5GuilvSum r);

	QueryResult<Pl5GuilvSum> findList(PageView<Pl5GuilvSum> pv, List<PropertyFilter> filters);

	Pl5GuilvSum findPl5GuilvSum(Long id);

	Pl5GuilvSum findPl5GuilvSum(Object p, Object v);
}
