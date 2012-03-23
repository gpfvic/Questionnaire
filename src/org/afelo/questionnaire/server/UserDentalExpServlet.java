package org.afelo.questionnaire.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afelo.questionnaire.db.DBDao;
import org.afelo.questionnaire.db.UserDentalExpDB;

public class UserDentalExpServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession(true);
		String sessionid = session.getId();
		
		String ans1 = request.getParameter("1-1");
		String ans2 = request.getParameter("1-2");
		String ans3 = request.getParameter("1-3");
		String ans41 = request.getParameter("1-4-1");
		String ans42 = request.getParameter("1-4-2");
		String ans5 = request.getParameter("1-5");
		String ans6 = request.getParameter("1-6");
		String ans6where = request.getParameter("1-6-where");
	   		
		
		DBDao dbDao = new DBDao();
		dbDao.saveUserDentalExp(sessionid, ans1,ans2,ans3,ans41,ans42,ans5,ans6,ans6where);
		
		response.sendRedirect("/user_missing_tooth.jsp");

		
	}

}
