package org.afelo.questionnaire.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afelo.questionnaire.db.DBDao;
import org.afelo.questionnaire.db.ChoiceResult;

public class VotesProcessServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		Enumeration paramNames = request.getParameterNames();
		
		String[] result = new String[21];
		
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
		dbDao.saveVoteResult(result[0],result[1],result[2],result[3],result[4],result[5],result[6],result[7],
				result[8],result[9],result[10],result[11],result[12],result[13],result[14],
				result[15],result[16],result[17],result[18],result[19],result[20]
		);
		
		
		
		response.sendRedirect("/user_info.jsp");
		
	}
	
	

}
