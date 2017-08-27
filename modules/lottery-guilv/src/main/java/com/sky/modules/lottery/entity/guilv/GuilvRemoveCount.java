package com.sky.modules.lottery.entity.guilv;

import javax.persistence.Entity;
import javax.persistence.Table; 
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;
@Entity
@Table(name = "t_guilv_remove_count")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GuilvRemoveCount extends IdLongEntity {
	
      private Integer qi;
      
      private Integer sum; 
       private String value;
  	
    	private String startValue;
      private String typeVaule;
  	  private  String  info;	 
  	  private String queryValue;
  	  
     private String startQueryValue; 
     private String valueNew;
 	 private String valueQueryNew;
  	  private Integer  num;
  	private Integer type;
	private  Integer gui=1;
	private Integer remove=0;
	
	private Integer number; 
	
	private Integer sort=0;
	
	private  Integer sumMin;
	
	public Integer getQi() {
		return qi;
	}
	public void setQi(Integer qi) {
		this.qi = qi;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStartValue() {
		return startValue;
	}
	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}
	public String getTypeVaule() {
		return typeVaule;
	}
	public void setTypeVaule(String typeVaule) {
		this.typeVaule = typeVaule;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getQueryValue() {
		return queryValue;
	}
	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}
	public String getStartQueryValue() {
		return startQueryValue;
	}
	public void setStartQueryValue(String startQueryValue) {
		this.startQueryValue = startQueryValue;
	}
	public String getValueNew() {
		return valueNew;
	}
	public void setValueNew(String valueNew) {
		this.valueNew = valueNew;
	}
	public String getValueQueryNew() {
		return valueQueryNew;
	}
	public void setValueQueryNew(String valueQueryNew) {
		this.valueQueryNew = valueQueryNew;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	 

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	
	
	
	public Integer getRemove() {
		return remove;
	}
	public void setRemove(Integer remove) {
		this.remove = remove;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getGui() {
		return gui;
	}
	public void setGui(Integer gui) {
		this.gui = gui;
	}
	
	
	
	
	public Integer getSumMin() {
		return sumMin;
	}
	public void setSumMin(Integer sumMin) {
		this.sumMin = sumMin;
	}
	@Transient
    public String getValueType(){
		 String typeString="头";
		 if(type==1){
			 typeString="百"; 
		 }else if(type==2){
			 typeString="十";
		 }else if(type==3){
			 typeString="尾";
		 }
    	 return typeString;
    			
    } 
  	  

}
