package com.cqu.edu.arics.JavaBean.Launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cqu.edu.arics.JavaBean.News.*;
import com.cqu.edu.arics.JavaBean.Printer.*;

public class Launcher {
	private ArrayList<NewsColumn> columnlist;
    public Launcher(){
    	columnlist=new ArrayList<NewsColumn>();
    	NewsColumn Scicolumn=new NewsColumn("重大科研","46");
    	columnlist.add(Scicolumn);
		NewsColumn Aducolumn=new NewsColumn("重大学术","47");
		columnlist.add(Aducolumn);
		NewsColumn Jobcolumn=new NewsColumn("重大就业","53");
		columnlist.add(Jobcolumn);
		NewsColumn Teacolumn=new NewsColumn("重大教学","48");
		columnlist.add(Teacolumn);
		NewsColumn Famcolumn=new NewsColumn("重大人物","49");
		columnlist.add(Famcolumn);
		
    	
    }
	public ArrayList<NewsColumn> getColumnlist() {
		return columnlist;
	}
	public void setColumnlist(ArrayList<NewsColumn> columnlist) {
		this.columnlist = columnlist;
	}
	public static void main(String[] args) throws IOException {
		
		Launcher launcher=new Launcher();
		launcher.constructNews();
                
				
			
	      }
	public  void constructNews() throws IOException
	{
		String rootURls="http://news.cqu.edu.cn";
			int i;
			String sep=File.separator;
			String lastpage = null;
	for( i=0;i<5;i++){
		int j=1;
		boolean end=false;
		while(end==false){
				String page="&page="+j;			
			    Document src1;
				NewsColumn column=columnlist.get(i);
				Document doc2 = Jsoup.connect("http://news.cqu.edu.cn/news/article/list.php?catid="+(column.getId())).get();
				Element page2 = doc2.select("div.pages").select("a").last();
				String lastPage=page2.attr("href");
				//System.out.println(lastPage);
				String currenturl="/news/article/list.php?catid="+column.getId()+page;
				//System.out.println(currenturl);
				src1 = Jsoup.connect(rootURls+currenturl).get();
				Elements eles=src1.select("div.linews li.tag_title");
				for(Element ele:eles){
				Element link=ele.select("a").first();
				String url=link.attr("href");
				News news=new News(null,url,null,null,null);
				String title=link.attr("title");
				if(title.contains("/")){
					title=title.replaceFirst("/", "即");
					}
				news.setTitle(title);
				//System.out.println(news.getURl());
				news.setContent(getnewsContent(news.getURl()));
				column.getNewslist().add(news);
				}
				if(currenturl.equals(lastPage)){
					end=true;
					//System.out.println(end);
					//break tog;
					
				}else{
				j++;
				}
			}
		}
			
	for(NewsColumn column:columnlist){
		
		for(News news:column.getNewslist()){
			Printer printer=new Printer("E:"+sep+"work"+sep+"news");
			printer.doprint(news, column.getAttribute());
			}
	    }
		
	
  }
			
 
	public String getnewsContent(String urls){
		Document doc;
		try {
			doc = Jsoup.connect("http://news.cqu.edu.cn"+urls).get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			return "error1";
		}
		Element content=doc.select("#zoom").first();
		Elements imgs=doc.select("img");
		for(Element img:imgs)
		{
			String src=img.attr("src");
			img.attr("src","http://news.cqu.edu.cn"+src );
		}
		try{
			content.attributes().remove("id");
			content.attributes().remove("class");
		}
		catch(NullPointerException e){
			return "error2";
		}
		return content.toString();
	}
	public List<News> GetColumnNews(String tar) {
		String path = null;
		ArrayList<News>columnnews=new ArrayList<News>();
		switch (tar) {
		case "46":
			path="E:\\work\\news\\重大科研";
			break;
		case "47":
			path="E:\\work\\news\\重大学术";
			break;
		case "48":
			path="E:\\work\\news\\重大教学";
			break;
		case "49":
			path="E:\\work\\news\\重大人物";
			break;
		case "53":
			path="E:\\work\\news\\重大就业";
			break;

		default:
			System.out.println("wrong happen");
			break;
		}
		File sorce=new File(path);
		File[]list=sorce.listFiles();
		for(File file:list){
		String Path=file.getName();
		String title=Path.substring(0,Path.lastIndexOf("."));
		String column=(file.getParent()).substring(file.getParent().lastIndexOf(File.separator)+1);
		News targetnew=new News(title, column);
		columnnews.add(targetnew);
		}
		return columnnews;
	}
	@SuppressWarnings("null")
	public List<File> GetAllLocalNews(){
		String sep=File.separator;
		ArrayList<File>fileslist=new ArrayList<File>();
		//System.out.println("E:"+sep+"work"+sep+"news"+sep+this.getColumnlist().get(0).getAttribute());
		for(NewsColumn column:this.columnlist){
		File f1=new File("E:"+sep+"work"+sep+"news"+sep+column.getAttribute());
		File[] files=f1.listFiles();
		for(File file:files){
			//System.out.println(file.getName());
			fileslist.add(file);
			}
		}
		return fileslist;
	}
		

		
}



		
		
			
	      


