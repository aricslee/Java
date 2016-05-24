package com.cqu.edu.arics.JavaBean.Printer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.cqu.edu.arics.JavaBean.News.*;

public class Printer {
	private String des;
	public Printer(String des) {
		this.des=des;
		
	}
	public void doprint(News news,String column){
		File desfile=new File(this.des+File.separator+column);
		File file=new File(desfile,news.getTitle()+".txt");
		if(!file.exists()){
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
				FileOutputStream out = new FileOutputStream(file);
				String content="<h1 align=\"center\">"+news.getTitle()+"</h1>"+"\n"+news.getContent();
				out.write(content.getBytes());
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		


}
}
