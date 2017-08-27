package com.sky.modules.lottery.message;

import org.w3c.dom.Element;

/**
 * 音乐消息
 * @author nukix
 *
 */
public class MusicMessage extends AbstractMessage{

	@Override
	public void paserXml(Element element) {
		// 目前没有此类型的解析说明
	}

	@Override
	public String sendMessage(Object... args) {
		String format = "<xml><ToUserName><![CDATA[%1$s]]></ToUserName><FromUserName><![CDATA[%2$s]]></FromUserName><CreateTime>%3$s</CreateTime><MsgType><![CDATA[%4$s]]></MsgType><Music><Title><![CDATA[%5$s]]></Title><Description><![CDATA[%6$s]]></Description><MusicUrl><![CDATA[%7$s]]></MusicUrl><HQMusicUrl><![CDATA[%8$s]]></HQMusicUrl><ThumbMediaId><![CDATA[%9$s]]></ThumbMediaId></Music></xml>";
		if(args == null || args.length < 4 || args.length > 9){
			throw new IllegalArgumentException("发送音乐消息失败, 参数必须有4~9个!");
		}
		String title = null, description = null, musicURL = null, HQMusicUrl = null, ThumbMediaId = null;		
		if (args.length > 4 && args[4] != null) {
			title = args[4].toString();
		}
		
		if (args.length > 5 && args[5] != null) {
			description = args[5].toString();
		}
		
		if (args.length > 6 && args[6] != null) {
			musicURL = args[6].toString();
		}
		
		if (args.length > 7 && args[7] != null) {
			HQMusicUrl = args[7].toString();
		}
		
		if (args.length > 8 && args[8] != null) {
			ThumbMediaId = args[8].toString();
		}
		return String.format(format, args[0], args[1], args[2], args[3],
				title, description, musicURL, HQMusicUrl, ThumbMediaId);
	}

}
