package com.sky.modules.lottery.entity.guilv;

import javax.persistence.Entity;
import javax.persistence.Table; 
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sky.modules.core.bean.IdLongEntity;
@Entity
@Table(name = "t_guilv_peer_old")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GuilvPeerOld extends IdLongEntity {
	
	public GuilvPeerOld (){}
	public GuilvPeerOld(GuilvPeer g){
		
		this.addition=g.getAddition();
		this.buchang=g.getBuchang();
		this.even=g.getEven();
		this.fixation=g.getFixation();
		this.gui=g.getGui();
		this.info=g.getInfo();
		this.matchType=g.getMatchType();
		this.number=g.getNumber();
		this.number_type=g.getNumber_type();
		this.qi=g.getQi();
		this.queryValue=g.getQueryValue();
		this.startQueryValue=g.getStartQueryValue();
		this.startValue=g.getStartValue();
		this.sum=g.getSum();
		this.type=g.getType();
		this.typeVaule=g.getTypeVaule();
		this.value=g.getValue();
		this.valueNew=g.getValueNew();
		this.valueOld=g.getValueOld();
		this.valueQueryNew=g.getValueQueryNew();
	}
	
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
	
	private Integer qi;
	
	private String  valueOld;

	private String valueNew;
	
	private String valueQueryNew;
	
	private String typeVaule;
	
	private  String  info;
	
	private  Integer gui=1;
	
	private String number_type;
	
	private Integer  num;
	
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

	public Integer getQi() {
		return qi;
	}

	public void setQi(Integer qi) {
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
		if(sum>num){
			return sum;	
		}
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
