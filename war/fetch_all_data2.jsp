<%@ page language="java" import="java.util.*" import="java.sql.*"
	pageEncoding="UTF-8"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="javax.jdo.Extent"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.jdo.Query"%>


<%@ page import="org.afelo.questionnaire.db.PMF"%>

<%@ page import="org.afelo.questionnaire.db.UserDentalExpDB"%>
<%@ page import="org.afelo.questionnaire.db.UserDetailsDB"%>
<%@ page import="org.afelo.questionnaire.db.UserMissingToothDB"%>
<%@ page import="org.afelo.questionnaire.db.QuestionnaireAnswerDB"%>
<%@ page import="org.afelo.questionnaire.db.QuestionnaireIDDB"%>




<%

   if (session.isNew()) {
	   response.sendRedirect("/login.jsp");
   }else{
	   Boolean status = (Boolean)session.getAttribute("status");
	   if (!status){
		   response.sendRedirect("/login.jsp");
	   }
   }

%>


<jsp:useBean id="link" scope="application"
	class="org.afelo.questionnaire.db.DBDao" />
<jsp:setProperty name="link" property="*" />


<%
    response.setHeader("Cache-Control", "");
    response.setContentType("text/CSV");
    response.setHeader("Pragma", "");
    response.setHeader("Content-Disposition", "attachment; filename=questionnaire_data.csv");

    PersistenceManager pm = PMF.get().getPersistenceManager();

    Query query = pm.newQuery(UserDentalExpDB.class);
    List<UserDentalExpDB> udedb = (List<UserDentalExpDB>) query.execute();
    if(!udedb.isEmpty()){
    	for (UserDentalExpDB ude : udedb){
    		if (ude.getType() != null){
	    		String sessionid = ude.getSessionid();
	    		
	    		query = pm.newQuery(QuestionnaireIDDB.class,"sessionid == sid");
                query.declareParameters("String sid");
                List<QuestionnaireIDDB> qiddb = (List<QuestionnaireIDDB>) query.execute(sessionid);
	    		
	    		query = pm.newQuery(UserDetailsDB.class,"sessionid == sid");
                query.declareParameters("String sid");
                List<UserDetailsDB> uddb = (List<UserDetailsDB>) query.execute(sessionid);
                
                query = pm.newQuery(UserMissingToothDB.class,"sessionid == sid");
                query.declareParameters("String sid");
                List<UserMissingToothDB> umtdb = (List<UserMissingToothDB>) query.execute(sessionid);
                
                query = pm.newQuery(QuestionnaireAnswerDB.class,"sessionid == sid");
                query.declareParameters("String sid");
                List<QuestionnaireAnswerDB> qadb = (List<QuestionnaireAnswerDB>) query.execute(sessionid);
	    		
                
	    		out.println("User,,"+sessionid);
	    		if(!qiddb.isEmpty()){
                    for (QuestionnaireIDDB qid : qiddb){       
                        if(qid.getQuestionnaireID()!=null){
                        	out.println("Qestionnaire ID, ," + qid.getQuestionnaireID());
                        }
                    }
	    		}
	    		
	    		
	    		out.println("Section 1, Your Dental Experiences");
	    		out.println("1.1,dental or patient , ," + ude.getType());
	    		out.println("1.2,lose tooth , , " + ude.getLose_tooth());
	    		out.println("1.3,number of teeth , ," + ude.getNum_teeth());
	    		out.println("1.4,replace front teeth , ," + ude.getReplace_front_teeth());
	    		out.println("1.5,replace back teeth , ," + ude.getReplace_back_teeth());
	    		out.println("1.6,treatment , ," + ude.getTreatment());
	    		out.println("1.7,where , ," + ude.getWhere());
	    		out.println("1.8,where , ," + ude.getOtherWhere());
	    		
	    		if(!umtdb.isEmpty()){
		    		for (UserMissingToothDB umt : umtdb){		
			    		if(umt.getLook()!=null){
		                    out.println("Section 2, Characteristics of Dental Treatment for Missing Tooth");
		                    out.println("2.1 , look , ," + umt.getLook());
		                    out.println("2.2 , eating , ," + umt.getEating());
		                    out.println("2.3 , other-eating , ," + umt.getOther_eating());
		                    out.println("2.4 , comfort , ," + umt.getComfort());
		                    out.println("2.5 , other comfort , ," + umt.getOther_comfort());
		                    out.println("2.6 , time restore , ," + umt.getTime_restored());
		                    out.println("2.7 , time last , ," + umt.getTime_last());
		                    out.println("2.8 , risks , ," + umt.getRisks());
		                    out.println("2.9 , other risks , ," + umt.getOther_risks());
		                    out.println("2.10, cost replacement , ," + umt.getCost_replacement());
		                    out.println("2.11, remove , ," + umt.getRemove());
		                    out.println("2.12, fix , ," + umt.getFix());
		                    out.println("2.13, implant , ," + umt.getImplant());
		                    out.println("2.14, reason not pay , ," + umt.getReason_not_pay());
		                }
		    		}
	    		}
                
	    		if(!qadb.isEmpty()){
	                for(QuestionnaireAnswerDB qa : qadb){
		                if(qa.getQ1_most()!=null){
		                    out.println("Section 3, Treatment Choices");
		                    out.println("3.1, User most prefrerred Treamtment, ," + qa.getQ1_most());
		                    out.println("3.1, User least prefrerred Treamtment, ," + qa.getQ1_least());
		                    out.println("3.2, User most prefrerred Treamtment , ," + qa.getQ2_most());
		                    out.println("3.2, User least prefrerred Treamtment , ," + qa.getQ2_least());
		                    out.println("3.3, User most prefrerred Treamtment , ," + qa.getQ3_most());
		                    out.println("3.3, User least prefrerred Treamtment , ," + qa.getQ3_least());
		                    out.println("3.4, User most prefrerred Treamtment , ," + qa.getQ4_most());
		                    out.println("3.4, User least prefrerred Treamtment , ," + qa.getQ4_least());
		                    out.println("3.5, User most prefrerred Treamtment , ," + qa.getQ5_most());
		                    out.println("3.5, User least prefrerred Treamtment , ," + qa.getQ5_least());
		                    out.println("3.6, User most prefrerred Treamtment , ," + qa.getQ6_most());
		                    out.println("3.6, User least prefrerred Treamtment , ," + qa.getQ6_least());
		                    out.println("3.7,User most prefrerred Treamtment  , ," + qa.getQ7_most());      
		                    out.println("3.7, User least prefrerred Treamtment , ," + qa.getQ7_least()); 

		                }
	                }
                }
                
                if(!uddb.isEmpty()){    
	                for(UserDetailsDB ud : uddb){
		                if(ud.getSex()!=null){
		                    out.println("Section 4.    Details About You");
		                    out.println("4.1, , ," +ud.getSex());
		                    out.println("4.2, , ," +ud.getAge());
		                    out.println("4.3, , ," +ud.getEdcuation());
		                    out.println("4.4, , ," +ud.getWork());
		                    out.println("4.5, , ," +ud.getSalary());
		                    out.println("4.6, , ," +ud.getComments());
		                }
	                }
                }
                
                out.println("\r\n\r\n");
                
    		}
    	}
    }
    
    


%>