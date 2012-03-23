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

    int user_count = 1;
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
                
				out.print(user_count++);
				out.print(",");

				if (!qiddb.isEmpty()) {
					for (QuestionnaireIDDB qid : qiddb) {
						if (qid.getQuestionnaireID() != null) {
							out.print(qid.getQuestionnaireID());
							out.print(",");
						}
					}
				}

				//section 1
                out.print(ude.getType());
                out.print(",");
                out.print(ude.getLose_tooth());
                out.print(",");
                out.print(ude.getNum_teeth());
                out.print(",");
                out.print(ude.getReplace_front_teeth());
                out.print(",");
                out.print(ude.getReplace_back_teeth());
                out.print(",");
                out.print(ude.getTreatment());
                out.print(",");
                if (!ude.getWhere().equals("4"))
                    out.print(ude.getWhere());
                else
                    out.print(ude.getWhere() + "-"
                            + ude.getOtherWhere().replaceAll(",", "."));
                out.print(",");

                
                
                //section 2
                if (!umtdb.isEmpty()) {
                    for (UserMissingToothDB umt : umtdb) {
                        if (umt.getLook() != null) {

                            if (!umt.getLook().equals("3"))
                                out.print(umt.getLook());
                            else
                                out.print(umt.getLook() + "-"
                                        + umt.getOther_look()
                                                .replaceAll(",", "."));
                            out.print(",");

                            if (!umt.getEating().equals("3"))
                                out.print(umt.getEating());
                            else
                                out.print(umt.getEating()
                                        + " "
                                        + umt.getOther_eating()
                                                .replaceAll(",", "."));
                            out.print(",");

                            if (!umt.getComfort().equals("3"))
                                out.print(umt.getComfort());
                            else
                                out.print(umt.getComfort()
                                        + "-"
                                        + umt.getOther_comfort()
                                                .replaceAll(",", "."));
                            out.print(",");

                            out.print(umt.getTime_restored()+",");
                            out.print(umt.getTime_last()+",");

                            if (!umt.getRisks().equals("5"))
                                out.print(umt.getRisks());
                            else
                                out.print(umt.getRisks()
                                        + "-"
                                        + umt.getOther_risks()
                                                .replaceAll(",", "."));
                            out.print(",");

                            if (!umt.getCost_replacement().equals("4"))
                                out.print(umt.getCost_replacement());
                            else
                                out.print(umt.getCost_replacement()
                                        + "-"
                                        + umt.getOther_cost_replacement()
                                                .replaceAll(",", "."));
                            out.print(",");

                            out.print(umt.getRemove());
                            out.print(",");
                            out.print(umt.getFix());
                            out.print(",");
                            out.print(umt.getImplant());
                            out.print(",");
                            out.print(umt.getMax_pay()+",");

                            if (!umt.getReason_not_pay().equals("4"))
                                out.print(umt.getReason_not_pay());
                            else
                                out.print("4-"
                                        + umt.getOther_reason()
                                                .replaceAll(",", "."));
                            out.print(",");

                        }
                    }
                }

                //section3
                if (!qadb.isEmpty()) {
                    for (QuestionnaireAnswerDB qa : qadb) {
                        if (qa.getQ1_most() != null) {
                            out.print(qa.getQ1_most());
                            out.print(",");
                            out.print(qa.getQ1_least());
                            out.print(",");
                            out.print(qa.getQ2_most());
                            out.print(",");
                            out.print(qa.getQ2_least());
                            out.print(",");
                            out.print(qa.getQ3_most());
                            out.print(",");
                            out.print(qa.getQ3_least());
                            out.print(",");
                            out.print(qa.getQ4_most());
                            out.print(",");
                            out.print(qa.getQ4_least());
                            out.print(",");
                            out.print(qa.getQ5_most());
                            out.print(",");
                            out.print(qa.getQ5_least());
                            out.print(",");
                            out.print(qa.getQ6_most());
                            out.print(",");
                            out.print(qa.getQ6_least());
                            out.print(",");
                            out.print(qa.getQ7_most());
                            out.print(",");
                            out.print(qa.getQ7_least());
                            out.print(",");

                        }
                    }
                }

                //section 4
                if (!uddb.isEmpty()) {
                    for (UserDetailsDB ud : uddb) {
                        if (ud.getSex() != null) {
                            out.print(ud.getSex());
                            out.print(",");
                            out.print(ud.getAge());
                            out.print(",");
                            out.print(ud.getEdcuation());
                            out.print(",");
                            out.print(ud.getWork());
                            out.print(",");
                            out.print(ud.getSalary());
                            out.print(",");
                            out.print(ud.getComments()+"");
                        }
                    }
                }

                out.println("\r\n");

			}
		}
	}
%>