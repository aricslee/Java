<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.cqu.edu.arics.JavaBean.Launcher.Launcher"%>
<%@  page import="com.cqu.edu.arics.JavaBean.News.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%List<News> newslist=(List<News>)request.getAttribute("newslist"); 
String ColumnName=(String)request.getAttribute("ColumnName");%>
<title><%=ColumnName %></title>
</head>
<body>
<h1>重庆大学新闻网</h1>
<h2><%=ColumnName %></h2>
<div>
	<%
		for(News news:newslist)
		{
	%>
	<a href="ShowServlet?ColumnName=<%=ColumnName %>&NewsTitle=<%=news.getTitle() %>"><%=news.getTitle() %></a><br/>
	<%
		}
	%>
<p><a href="HomeServlet">返回</a></p>
</div>

</body>
</html>