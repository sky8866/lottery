package com.sky.modules.lottery.hc.utils;

public class Ticket {

	private String ticket;
	
	private String expire_seconds;//如果是临时二维码，就设置时间长
	
	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	
}
