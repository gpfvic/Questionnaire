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

public class UserMissingToothServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession(true);
		String sessionid = session.getId();

		String ans1 = request.getParameter("2-1");
		String ans1other = request.getParameter("2-1other_look");
		String ans2 = request.getParameter("2-2");
		String ans2other = request.getParameter("2-2other_eating");
		String ans3 = request.getParameter("2-3");
		String ans3other = request.getParameter("2-3other_comfort");
		String ans41 = request.getParameter("2-4-1");
		String ans42 = request.getParameter("2-4-2");
		String ans5 = request.getParameter("2-5");
		String ans5other = request.getParameter("2-5-other_risks");
		String ans6a = request.getParameter("2-6-a");
		String ans6b = request.getParameter("2-6-b");
		String ans6c1 = request.getParameter("2-6-c1");
		String ans6c2 = request.getParameter("2-6-c2");
		String ans6c3 = request.getParameter("2-6-c3");
		String ans6d = request.getParameter("2-6-d");
		String ans6e = request.getParameter("2-6-e");
		String ans6eother = request.getParameter("2-6-e-other");
		
		DBDao dbDao = new DBDao();
		dbDao.saveUserMissingTooth(sessionid, ans1,ans1other,ans2,ans2other,ans3,ans3other,ans41,ans42,ans5,ans5other,ans6a,
				ans6b,ans6c1,ans6c2,ans6c3,ans6d,ans6e,ans6eother
		);
		
		
		
		response.sendRedirect("/createQuestionnaire.jsp");
		
	
		
	}

}
