package com.sky.modules.lottery.message;

public abstract class AbstractMessageFactory {
	public abstract AbstractMessage createMessage(String xml) throws Exception;
}
