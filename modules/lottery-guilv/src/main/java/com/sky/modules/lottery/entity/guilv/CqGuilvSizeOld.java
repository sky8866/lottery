package com.sky.modules.lottery.entity.guilv;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;
@Entity
@Table(name = "t_cq_guilv_size")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CqGuilvSizeOld extends IdLongEntity {
	
 
	
	private String queryValue;
	
	private String startQueryValue;

	private Integer sum; 
	
	private String value;
	
	private String startValue;
	
	private Integer fixation;
	
	private Integer buchang;
	
	
	private Integer addition;
	
	private Integer even;
	
	private Integer matchType;
	
	private Integer type;
	
	private Integer number; 
	
	private Long qi;
	
	private String  valueOld;

	private String valueNew;
	
	private String valueQueryNew;
	
	private String typeVaule;
	
	private  String  info;
	
	private  Integer gui=1;
	
	private String number_type;
	
	private Integer num;
	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
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

	public Integer getFixation() {
		return fixation;
	}

	public void setFixation(Integer fixation) {
		this.fixation = fixation;
	}

	public Integer getAddition() {
		return addition;
	}

	public void setAddition(Integer addition) {
		this.addition = addition;
	}

	public Integer getEven() {
		return even;
	}

	public void setEven(Integer even) {
		this.even = even;
	}

	public Integer getMatchType() {
		return matchType;
	}

	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getQi() {
		return qi;
	}

	public void setQi(Long qi) {
		this.qi = qi;
	}

	public Integer getBuchang() {
		return buchang;
	}

	public void setBuchang(Integer buchang) {
		this.buchang = buchang;
	}

	public String getValueOld() {
		return valueOld;
	}

	public void setValueOld(String valueOld) {
		this.valueOld = valueOld;
	}

	public String getValueNew() {
		return valueNew;
	}

	public void setValueNew(String valueNew) {
		this.valueNew = valueNew;
	}
	
	
	
	
	
	public String getTypeVaule() {
		return typeVaule;
	}

	public void setTypeVaule(String typeVaule) {
		this.typeVaule = typeVaule;
	}
	

	





	
	 
	public String getStartQueryValue() {
		return startQueryValue;
	}

	public void setStartQueryValue(String startQueryValue) {
		this.startQueryValue = startQueryValue;
	}

	public String getStartValue() {
		return startValue;
	}

	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		
		
		this.info = info;
	}

	public Integer getGui() {
		return gui;
	}

	public void setGui(Integer gui) {
		this.gui = gui;
	}

	public String getNumber_type() {
		return number_type;
	}

	public void setNumber_type(String number_type) {
		this.number_type = number_type;
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

	@Transient
    public String getValueType(){
		 String typeString="万";
		 if(type==1){
			 typeString="千"; 
		 }else if(type==2){
			 typeString="百";
		 }else if(type==3){
			 typeString="十";
		 }else if(type==4){
			 typeString="个";
		 }
    	 return typeString;
    			
    }

}
