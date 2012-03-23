<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/checkstatus.jsp" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.PreparedQuery" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>

<%@ page import="javax.jdo.PersistenceManager"%>
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

<%

DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
Query mydeleteq = new Query();
PreparedQuery pq = datastore.prepare(mydeleteq);
for (Entity result : pq.asIterable()) {
    datastore.delete(result.getKey());      
}  

response.sendRedirect("/checkstatus.jsp");



%>