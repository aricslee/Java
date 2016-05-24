<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="com.cqu.edu.arics.JavaBean.Launcher.Launcher"%>
<%@  page import="com.cqu.edu.arics.JavaBean.News.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home Page</title>
</head>
<body>
<table align="center" border="0">
<tr>
<td align="center">
<h1><img src="E:\work\news\logo\无标题.jpg" width="150" height="128" align="center" /></h1>
</td>
</tr>
<tr>
<td align="center">
<form action="SearchResultServlet"method="get">
<input type="text" name="search" size="50">
<input type="submit" value="搜索">
</form>
</td>
</tr>
</table>
<br>
<br>
<table align="center">
<%ArrayList<NewsColumn>columnlist=(ArrayList<NewsColumn>)request.getAttribute("columnlist"); %>
<tr>
<td align="center">
<%NewsColumn column1=(NewsColumn)columnlist.get(0);  %>
 <b><a href="ColumnServlet?columnAttribute=<%=column1.getAttribute() %>&columnId=<%=column1.getId() %>"><%=column1.getAttribute() %></a></b>
</td>
<td align="center">
<%NewsColumn column2=(NewsColumn)columnlist.get(1);  %>
 <b><a href="ColumnServlet?columnAttribute=<%=column2.getAttribute() %>&columnId=<%=column2.getId() %>"><%=column2.getAttribute() %></a></b>
</td>

<td align="center">
<%NewsColumn column3=(NewsColumn)columnlist.get(2);  %>
 <b><a href="ColumnServlet?columnAttribute=<%=column3.getAttribute() %>&columnId=<%=column3.getId()%>"><%=column3.getAttribute() %></a></b>
</td>

<td align="center">
<%NewsColumn column4=(NewsColumn)columnlist.get(3);  %>
 <b><a href="ColumnServlet?columnAttribute=<%=column4.getAttribute() %>&columnId=<%=column4.getId() %>"><%=column4.getAttribute() %></a></b>
 <td align="center">
<%NewsColumn column5=(NewsColumn)columnlist.get(4);  %>
 <b><a href="ColumnServlet?columnAttribute=<%=column5.getAttribute() %>&columnId=<%=column5.getId() %>"><%=column5.getAttribute() %></a></b>
</tr>
</table>

</body>
</html>