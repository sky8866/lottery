package com.sky.modules.lottery.message;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public abstract class AbstractMessage {
	// 开发者微信号
	protected String ToUserName;
	// 发送方帐号（一个OpenID）
	protected String FromUserName;
	// 消息创建时间 （整型）
	protected int CreateTime;
	// 消息类型:text, image, voice, video, location, link
	protected String MsgType;
	// 消息id, 64位整型
	protected long MsgId;
	
	/**
	 * 解析xml
	 * @param element
	 */
	public abstract void paserXml(Element element);
	
	/**
	 * 文本消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		text
	 * @param Content		必须		回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 * 
	 * 图片消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		image
	 * @param MediaId		必须		通过素材管理接口上传多媒体文件，得到的id。
	 * 
	 * 语音消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		voice
	 * @param MediaId		必须		通过素材管理接口上传多媒体文件，得到的id
	 * 
	 * 视频消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		video
	 * @param MediaId		必须		通过素材管理接口上传多媒体文件，得到的id
	 * @param Title			非必须	视频消息的标题
	 * @param Description	非必须	视频消息的描述
	 * 
	 * 音乐消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		music
	 * @param Title			非必须	音乐标题
	 * @param Description	非必须	音乐描述
	 * @param MusicURL		非必须	音乐链接
	 * @param HQMusicUrl	非必须	高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 * @param ThumbMediaId	非必须	缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
	 * 
	 * 图文消息:
	 * @param ToUserName	必须		接收方帐号（收到的OpenID）
	 * @param FromUserName	必须		开发者微信号
	 * @param CreateTime	必须		消息创建时间 （整型）
	 * @param MsgType		必须		news
	 * @param ArticleCount	必须		图文消息个数，限制为10条以内
	 * @param Articles		必须		多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	 * 注： Articles 参数不用写，即ArticleCount参数后面直接到Title
	 * @param Title			非必须	图文消息标题
	 * @param Description	非必须	图文消息描述
	 * @param PicUrl		非必须	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 * @param Url			非必须	点击图文消息跳转链接
	 * 注：如果有第二个图文消息, 在后面参数继续接Title, Description, PicUrl, Url
	 * @return 符合微信消息的xml
	 */
	public abstract String sendMessage(Object ... args);

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public int getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
	
}
