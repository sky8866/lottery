package com.sky.modules.lottery.utils.guilv;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConnectionAndDocumentUtil
{
	// 抓取网页内容
	public static String attachContent(String url)
	{
		HttpHostConnection conn = new HttpHostConnection();

		String content = conn.getHostData(url, "utf-8");
       
		return content;
	}
	
	//解析网页内容
	public static Document parseHtmlContent(String content)
	{
		try
		{
			Document doc = Jsoup.parse(content);

			return doc;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
