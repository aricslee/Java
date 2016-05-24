package com.cqu.edu.arics.JavaBean.News;

public class News {
	private String title;
	private String URl;
	private String column;
	private String id;
	private String content;
	public String getcolumn() {
		return column;
	}
	public void setcolumn(String column) {
		this.column = column;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getURl() {
		return URl;
	}
	public void setURl(String uRl) {
		URl = uRl;
	}
	public News(String til,String URl,String column,String id,String content){
		this.title=til;
		this.URl=URl;
		this.column=column;
		this.id=id;
		this.content=content;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public News(){
		this.title=null;
		this.URl=null;
		this.column=null;
		this.id=null;
	}
	public News(String title,String column){
		this.title=title;
		this.URl=null;
		this.column=column;
		this.id=null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
