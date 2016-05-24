<%@page import="java.util.List"%>
<%@  page import="com.cqu.edu.arics.JavaBean.News.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索结果</title>
</head>
<body>
<%List<News>results=(List<News>)request.getAttribute("Targets"); %>

<%for(News result:results){
	%>
	<a href="ShowServlet?ColumnName=<%=result.getcolumn() %>&NewsTitle=<%=result.getTitle() %>"><%=result.getTitle() %></a><br/>
	<%
     }
%>
</body>
</html>