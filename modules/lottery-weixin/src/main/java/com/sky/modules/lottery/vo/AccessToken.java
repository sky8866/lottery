package com.sky.modules.lottery.vo;

import java.io.Serializable;

public class AccessToken implements Serializable{
	private String accessToken;
	private long time;
	
	public AccessToken(String accessToken, long time) {
		this.accessToken = accessToken;
		this.time = time;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
}
