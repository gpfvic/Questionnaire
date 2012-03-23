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

public class QuestionnaireAnswerServlet extends HttpServlet{

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession(true);
		String sessionid = session.getId();
		
		String ans1 = request.getParameter("MOST1");
		String ans2 = request.getParameter("LEAST1");
		String ans3 = request.getParameter("MOST2");
		String ans4 = request.getParameter("LEAST2");
		String ans5 = request.getParameter("MOST3");
		String ans6 = request.getParameter("LEAST3");
		String ans7 = request.getParameter("MOST4");
		String ans8 = request.getParameter("LEAST4");
		String ans9 = request.getParameter("MOST5");
		String ans10 = request.getParameter("LEAST5");
		String ans11 = request.getParameter("MOST6");
		String ans12 = request.getParameter("LEAST6");
		String ans13 = request.getParameter("MOST7");
		String ans14 = request.getParameter("LEAST7");
		
		DBDao dbDao = new DBDao();
		dbDao.saveQuestionnaireAnswer(sessionid, ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10,
				ans11,ans12,ans13,ans14
			);
		
		response.sendRedirect("/user_details.jsp");

		
	}

}
