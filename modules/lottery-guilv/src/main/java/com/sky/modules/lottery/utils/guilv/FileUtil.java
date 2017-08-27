package com.sky.modules.lottery.utils.guilv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{
	public static void writeFile(String fileName, List<String> contentList)
	{
		try
		{
			File wfile = new File(fileName);// 写入的文件
			
			if(!wfile.exists())
			{
				if(wfile.createNewFile())
				{
					System.out.println("创建文件成功！");
				}
			}

			// 文件写出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(wfile)));
			// 逐行读取test.txt内容，保存在line里
			for (String content : contentList)
			{
				bw.write(content);// 写入到ck.txt
				bw.newLine();// 写完，换行
				bw.flush();// 刷新，将缓存内容写到文件里
			}
			bw.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static List<String> readFile(String fileName)
	{
		List<String> contentList = new ArrayList<String>();
		try
		{
			File rfile = new File(fileName);// 读取的文件
			// 文件读入流
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(rfile)));
			// 逐行读取test.txt内容，保存在line里
			for (String line = br.readLine(); line != null; line = br
					.readLine())
			{
				contentList.add(line);
			}
			br.close();
		} catch (Exception ex)
		{
		}
		return contentList;
	}
}
