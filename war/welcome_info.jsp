<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>


<jsp:useBean id="link" scope="application" class = "org.afelo.questionnaire.db.DBDao" />
<jsp:setProperty name="link" property="*" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>Welcome</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="/index2.css">
    
    <style type="text/css">
       body {
            text-align: center;
            }
    #container {
            margin-left: auto;
            margin-right: auto;
            width: 600px;
            text-align: left
            }
    p{
     text-indent:2em;
    }
   </style>

  </head>
  
  <body style= "margin:0;"> 
  <iframe name="neepage" marginwidth="0" marginheight="0" src="../head.html" width="100%" height="80"></iframe>
  <h2>QUESTIONNAIRE TO ASSESS PEOPLE’S VIEWS ON <br> DENTAL HEALTH & TOOTH REPLACEMENT</h2>
  
  <div id="container">
    <p>Thank you for logging into this questionnaire page. This survey contains four parts and it will take about 15 to 20 minutes to complete. All responses will be <u>STRICTLY CONFIDENTIAL</u> and will be used for the research purposes only. The choices you make on this questionnaire will not affect or alter your current dental care. You do not have to take part in this survey, participation is entirely voluntary. </p>
   </div>
    <form method="post" action="/welcome">
        <div align="center" valign="middle"> 
        <table>
            <tr>
                <br><br><br><br><br>
                <td>Questionnaire Code:</td>
                <td><input type="text" name="questionnaireID"></input></td>
                <td><input type="submit" value="Start" /></td>
            </tr>
            <tr>
                <%
                      if(session.getAttribute("error_msg")!=null){
                 %>
                    	 <font color="red"><%= session.getAttribute("error_msg")%></font>
                 <% 
                         session.removeAttribute("error_msg");
                      }
                
                %>
            </tr>
        </table>
        </div>
    </form>
  </body>
</html>
