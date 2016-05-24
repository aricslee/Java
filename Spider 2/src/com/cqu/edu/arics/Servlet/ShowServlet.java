package com.cqu.edu.arics.Servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String columnname=request.getParameter("ColumnName");
		String sep=File.separator;
		String newstitle=request.getParameter("NewsTitle");
		String path="E:"+sep+"work"+sep+"news"+sep+columnname;
		//System.out.println(path);
		File targetNews=new File(path,newstitle+".txt");
		String content ="";
		InputStreamReader in=new InputStreamReader(new FileInputStream(targetNews),"utf-8");
		BufferedReader reader=new BufferedReader(in);
		String temp;
		while ((temp=reader.readLine())!=null) {
			content+=temp;
			
		}
		request.setAttribute("NewsContent",content);
		RequestDispatcher rd=request.getRequestDispatcher("/NewsShow.jsp");
		rd.forward(request, response);
		reader.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
