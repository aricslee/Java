package com.cqu.edu.arics.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqu.edu.arics.JavaBean.Launcher.Launcher;
import com.cqu.edu.arics.JavaBean.News.News;

/**
 * Servlet implementation class ColumnServlet
 */
@WebServlet("/ColumnServlet")
public class ColumnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColumnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String columnAttribute=request.getParameter("columnAttribute");
		String columnID=request.getParameter("columnId");
		Launcher launcher=new Launcher();
		List<News> newslist=launcher.GetColumnNews(columnID);
	
		request.setAttribute("newslist", newslist);
		request.setAttribute("ColumnName",columnAttribute);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/ColumnShow.jsp");
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
