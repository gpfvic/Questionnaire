package org.afelo.questionnaire.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afelo.questionnaire.db.DBDao;

public class UserInfoProcessServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

	    HttpSession session = request.getSession(true);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		Enumeration paramNames = request.getParameterNames();
		
		String[] result = new String[10];
		
		int count = 0;
		while(paramNames.hasMoreElements()){
			String paramName = (String)paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			
			if (paramValues.length == 1){
				String paramValue = paramValues[0];
				if (paramValue.length() == 0){
					out.println("No Value");
				}else{
					out.println(paramName +" " + paramValue);
					result[count++] = paramValue;
				}
			}else{
				for (int i=0; i<paramValues.length;i++){
					out.println(paramName +" -- " + paramValues[i]);
					result[count++] = paramValues[i];
				}
			}
			out.print("<br>");
		}
		
		DBDao dbDao = new DBDao();
		dbDao.saveUserInfo(result[0],result[1],result[2],result[3],result[4],result[5],result[6],result[7],
				result[8],result[9]
		);

		out.println(result);
		
		//response.sendRedirect("/logout.jsp");

	}

}
