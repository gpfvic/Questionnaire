<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="org.afelo.questionnaire.db.PMF" %>
<%@ page import="org.afelo.questionnaire.db.DBDao" %>
<%@ page import="org.afelo.questionnaire.db.Choice" %>
<%@ page import="javax.jdo.Query" %>








<html>

    <head>
        <link type="text/css" rel="stylesheet" href="/stylesheets/main.css" />
    </head>


  <body>


<%
out.println("werwe");
Enumeration paramNames = request.getParameterNames();
int count = 0;
while(paramNames.hasMoreElements()){
    String paramName = (String)paramNames.nextElement();
    String[] paramValues = request.getParameterValues(paramName);
    
    if (paramValues.length == 1){
        String paramValue = paramValues[0];
        if (paramValue.length() == 0){
        }else{
        }
    }else{
        for (int i=0; i<paramValues.length;i++){
            out.println("sdfsd");
        }
    }
}
%>
  </body>
</html>