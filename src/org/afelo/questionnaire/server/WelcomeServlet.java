package org.afelo.questionnaire.server;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afelo.questionnaire.db.PMF;
import org.afelo.questionnaire.db.QuestionnaireIDDB;
import org.afelo.questionnaire.db.UserDentalExpDB;

public class WelcomeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession(true);
		List<String> codes = Arrays.asList("PXBQ", "WERF", "EWXC", "CXVO");

		String sessionid = session.getId();
		String qcode = (String) request.getParameter("questionnaireID");
		int qid = codes.indexOf(qcode) + 1;
		
		if(qid==0){
			session.setAttribute("error_msg", "Please enter the correct Questionnaire Code!");
			response.sendRedirect("/welcome_info.jsp");
		}
		
		Long questionnaireID = Long.valueOf(qid);

		session.setAttribute("questionnaireID", questionnaireID);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(QuestionnaireIDDB.class, "sessionid=='" + sessionid + "'");
		try {
			List<QuestionnaireIDDB> results = (List<QuestionnaireIDDB>) query.execute(query);
			if (results.isEmpty()) {
				QuestionnaireIDDB qiddb = new QuestionnaireIDDB(sessionid, Integer.toString(qid));
				pm.makePersistent(qiddb);

			} 
		} finally {
			query.closeAll();
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user_dental_exp.jsp");
		try {
			dispatcher.forward( request, response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
