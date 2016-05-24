package com.cqu.edu.arics.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryparser.classic.ParseException;

import com.cqu.edu.arics.JavaBean.LuceneSearch.LuceneSearcher;
import com.cqu.edu.arics.JavaBean.News.News;

/**
 * Servlet implementation class SearchResultServlet
 */
@WebServlet("/SearchResultServlet")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     try {
		    	 request.setCharacterEncoding("utf-8");
		 		String target=request.getParameter("search");
		 		LuceneSearcher searcher=new LuceneSearcher();
		 		List<News>targets=new ArrayList<News>();
				List <String>results=searcher.LuceneSearching(target);
				for(String result:results){
					File file=new File(result);
					String Path=file.getName();
					String title=Path.substring(0,Path.lastIndexOf("."));
					String column=(file.getParent()).substring(file.getParent().lastIndexOf(File.separator)+1);
					News targetnew=new News(title, column);
					targets.add(targetnew);
				}
				request.setAttribute("Targets", targets);
				RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/ResultsShow.jsp");
				rd.forward(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
