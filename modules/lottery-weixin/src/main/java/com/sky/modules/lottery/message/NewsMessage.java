package com.sky.modules.lottery.message;

import org.w3c.dom.Element;

/**
 * 图文消息
 * @author nukix
 *
 */
public class NewsMessage extends AbstractMessage{

	String AtricleCount;
	String Title;
	String Description;
	String PicUrl;
	String Url;

	@Override
	public void paserXml(Element element) {
		// 目前没有此类型的解析说明
	}

	@Override
	public String sendMessage(Object... args) {
		if(args == null || args.length < 5){
			throw new IllegalArgumentException("发送图文消息失败\n参数必须大于5!");
		}
		int articleCount = Integer.parseInt(args[4].toString());
		if (articleCount != ((args.length - 5) / 4 + (args.length -5) % 4)) {
			throw new IllegalArgumentException("发送图文消息失败\n参数必须跟ArticleCount对应\n即ArticleCount=0\n参数个数为5\nArticleCount=1\n参数个数为9!");
		} else if (articleCount > 10) {
			throw new IllegalArgumentException("发送图文消息失败, ArticleCount 必须在10条以内!");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>")
			.append("<ToUserName><![CDATA[%1$s]]></ToUserName>")
			.append("<FromUserName><![CDATA[%2$s]]></FromUserName>")
			.append("<CreateTime>%3$s</CreateTime>")
			.append("<MsgType><![CDATA[%4$s]]></MsgType>")
			.append("<ArticleCount>%5$s</ArticleCount>")
			.append("<Articles>");
		for (int i = 0; i < articleCount; i++) {
			sb.append("<item>");
			sb.append("<Title><![CDATA[%").append(4*i+6).append("$s]]></Title>");
			sb.append("<Description><![CDATA[%").append(4*i+7).append("$s]]></Description>");
			sb.append("<PicUrl><![CDATA[%").append(4*i+8).append("$s]]></PicUrl>");
			sb.append("<Url><![CDATA[%").append(4*i+9).append("$s]]></Url>");
			sb.append("</item>");
		}
		sb.append("</Articles>").append("</xml>");
		
		final String format = sb.toString();
		
		return String.format(format, args);
	}

}
