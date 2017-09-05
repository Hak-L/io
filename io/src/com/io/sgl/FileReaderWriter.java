/**
 * Copyright(C) 2015 普适 Software Technology Co.,Ltd.
 * Project Name:io
 * File Name:FileReaderWriter.java
 * Package Name:com.io.sgl
 * @Description:一句话描述该文件做什么
 * @author yun.jia
 * @Date:2017年8月22日 下午1:22:16
 */
package com.io.sgl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
  * 类说明
  * @author yun.jia
  * @version 1.0, 2017年8月22日  每次修改后更新版本号，日期和修改内容
  * @see	[相关类/方法]
  * @since	[产品/模块版本]
  */
public class FileReaderWriter {
	
	@Test
	public void testBuffered(){
		String src="F:/JAVA/网页 视频/divcss/divcss第二课,div选择器以及浮动布局/divcss第二课,div选择器以及浮动布局.avi";
		String desc="F:/JAVA/网页 视频/divcss/divcss第二课,div选择器以及浮动布局/2.avi";
		copyFile(src, desc);
	}
	
	//文件复制通用方法
	public void  copyFile(String src,String desc){
		File file1 = new File (src);
		File file2 = new File (desc);
		BufferedInputStream bis =null;
		BufferedOutputStream bos =null;
		try {
			long start = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte [] b = new byte[1024];
			int len;
			while((len = bis.read(b))!=-1){
				bos.write(b, 0, len);
				bos.flush();
			}
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	
	
	@Test
	public void testFileReader(){
		File file = new File("test.txt");
		File file2 = new File("test2.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try {
			 fr = new FileReader(file);
			 fw = new FileWriter(file2);
			char b[] = new char[5];
			int len;
			while((len = fr.read(b))!=-1){
				fw.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
