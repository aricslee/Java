package com.cqu.edu.arics.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqu.edu.arics.JavaBean.Launcher.Launcher;
import com.cqu.edu.arics.JavaBean.News.News;
import com.cqu.edu.arics.JavaBean.News.NewsColumn;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Launcher launcher=new Launcher();
		ArrayList<NewsColumn>columnlist=launcher.getColumnlist();
		for(NewsColumn column:columnlist){
			String columnattribute=column.getAttribute();
			List<News> newslist=column.getNewslist();
			request.setAttribute(columnattribute, newslist);
			
		}
		request.setAttribute("columnlist", columnlist);
		//RequestDispatcher rd=getServletContext().getRequestDispatcher("/HomePage.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("/HomePage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
