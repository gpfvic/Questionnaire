package org.afelo.questionnaire.server;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afelo.questionnaire.db.DBDao;

public class UserDetailsServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession(true);
		String sessionid = session.getId();
		
		String ans1 = request.getParameter("4-1");
		String ans2 = request.getParameter("4-2");
		String ans3 = request.getParameter("4-3");
		String ans4 = request.getParameter("4-4");
		String ans5 = request.getParameter("4-5");
		String ans6 = request.getParameter("comments");
		
		DBDao dbDao = new DBDao();
		dbDao.saveUserDetails(sessionid, ans1,ans2,ans3,ans4,ans5,ans6);
		
		response.sendRedirect("/thanks_bye.jsp");

		
		
	}

}
