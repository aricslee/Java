package com.cqu.edu.arics.JavaBean.News;



import java.util.ArrayList;
import java.util.List;



public class NewsColumn {
	private String attribute;
	private List<News>newslist;
	private String  id;
	public String getAttribute() {
		return attribute;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public NewsColumn(){
		this.attribute="";
		this.newslist=new ArrayList<News>();
	}
	public NewsColumn(String attribute,String id){
		this.attribute=attribute;
		this.newslist=new ArrayList<News>();
		this.id=id;
		
	}
	public NewsColumn(String attribute){
		this.attribute=attribute;
		this.newslist=new ArrayList<News>();
		this.id="";
		
	}
	public List<News> getNewslist() {
		return newslist;
	}
		
	

}
