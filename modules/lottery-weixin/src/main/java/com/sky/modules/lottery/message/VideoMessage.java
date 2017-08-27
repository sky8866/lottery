package com.sky.modules.lottery.message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



/**
 * 瑙嗛娑堟伅
 * @author nukix
 *
 */
public class VideoMessage extends AbstractMessage{

	// 瑙嗛娑堟伅濯掍綋id锛屽彲浠ヨ皟鐢ㄥ濯掍綋鏂囦欢涓嬭浇鎺ュ彛鎷夊彇鏁版嵁銆�
	String MediaId;
	// 瑙嗛娑堟伅缂╃暐鍥剧殑濯掍綋id锛屽彲浠ヨ皟鐢ㄥ濯掍綋鏂囦欢涓嬭浇鎺ュ彛鎷夊彇鏁版嵁銆�
	String ThumbMediaId;

	@Override
	public void paserXml(Element element) {
		NodeList ToUserName = element.getElementsByTagName("ToUserName");
		NodeList FromUserName = element.getElementsByTagName("FromUserName");
		NodeList CreateTime = element.getElementsByTagName("CreateTime");
		NodeList MsgType = element.getElementsByTagName("MsgType");
		NodeList MediaId = element.getElementsByTagName("MediaId");
		NodeList ThumbMediaId = element.getElementsByTagName("ThumbMediaId");
		NodeList MsgId = element.getElementsByTagName("MsgId");
		
		this.ToUserName = ToUserName.item(0).getTextContent();
		this.FromUserName = FromUserName.item(0).getTextContent();
		this.CreateTime = Integer.parseInt(CreateTime.item(0).getTextContent());
		this.MsgType = MsgType.item(0).getTextContent();
		this.MediaId = MediaId.item(0).getTextContent();
		this.ThumbMediaId = ThumbMediaId.item(0).getTextContent();
		this.MsgId = Long.parseLong(MsgId.item(0).getTextContent());
	}

	@Override
	public String sendMessage(Object... args) {
		String format = "<xml><ToUserName><![CDATA[%1$s]]></ToUserName><FromUserName><![CDATA[%2$s]]></FromUserName><CreateTime>%3$s</CreateTime><MsgType><![CDATA[%4$s]]></MsgType><Video><MediaId><![CDATA[%5$s]]></MediaId><Title><![CDATA[%6$s]]></Title><Description><![CDATA[%7$s]]></Description></Video></xml>";
		if(args == null || args.length < 5 || args.length > 7){
			throw new IllegalArgumentException("鍙戦�佽棰戞秷鎭け璐�, 鍙傛暟蹇呴』鏈�5~7涓�!");
		}
		String title = null, description = null;
		if (args.length > 5 && args[5] != null) {
			title = args[5].toString();
		}
		if (args.length > 6 && args[6] != null) {
			description = args[6].toString();
		}
		return String.format(format, args[0], args[1], args[2], args[3], args[4], title, description);
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
}
