<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>
<%@ page errorPage="/welcome_info.jsp"%>

<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="org.afelo.questionnaire.db.PMF"%>
<%@ page import="org.afelo.questionnaire.db.DBDao"%>
<%@ page import="org.afelo.questionnaire.db.Choice"%>
<%@ page import="javax.jdo.Query"%>

<%
   if (session.isNew()) {
       session.setAttribute("error_msg", "Please enter the correct Questionnaire Code!");
       response.sendRedirect("/welcome_info.jsp");
   }else{
       Long questionnaireID = (Long)session.getAttribute("questionnaireID");
       if (questionnaireID > 4 || questionnaireID<1){
           response.sendRedirect("/welcome_info.jsp");
       }
   }

%>


<jsp:setProperty name="link" property="*" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>

<title>Vote Page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/index.css">

    <script type="text/javascript" language="javascript">
    function checkform(myform){
        var inputs = myform.getElementsByTagName('input');
        var radiolist = new Object();
        var radioes;
        var ipt;
        
        for (var i=0;i<inputs.length;i++){
            ipt = inputs[i];
            if(ipt.type=="radio"){
                radioes = radiolist[ipt.name];
                if(!radioes){
                    radioes = new Array();
                }
                radioes[radioes.length] = ipt;
                radiolist[ipt.name] = radioes;
            }
        }
        
        for (var name in radiolist){
            radioes = radiolist[name];
            var chk = false;
            var radio;
            for (var j=0;j<radioes.length;j++){
                var radio = radioes[j];
                if(radio.checked){
                    chk=true;
                    break;
                }
            }
            if(!chk){
                alert("Please select: Question " + name);
                return false;
            }
        }
        
        return true
    
    }
    </script>

<%    
      Long questionnaireID = (Long)session.getAttribute("questionnaireID");    
%> 

<style type="text/css">
       body {
            text-align: center;
            }
    #container {
            margin-left: auto;
            margin-right: auto;
            width: 700px;
            text-align: left
            }
    p{
     text-indent:2em;
    }
   </style>
   
</head>

<body style="margin: 0;">
    
        <iframe name="neepage" marginwidth="0" marginheight="0" src="./head.html" width="100%" height="80"></iframe>
    <div id="container">    
        <h1 align="center">Section 3. Treatment Choices</h1>
        <p style="word-break:keep-all">Before you answer any questions, please imagine that you have lost an <font color='red'>upper front tooth</font>, it has passed the painful stage, and you decide to seek a replacement. You do not have to have suffered from a tooth loss to take part in this survey.</p>
        <br />
        <p style="word-break:keep-all">In this section, we will present you with <font color='red'>7</font> choices. 
        Each of the following questions will ask you to choose your <font color='red'>MOST</font> preferred 
        and <font color='red'>LEAST</font> preferred treatment to replace your <font color='red'>missing upper 
        front tooth</font> from <font color='red'>Treatment A, B and C</font>. 
        You can also select <font color='red'>NONE OF THEM</font>, which means your
         upper front tooth <font color='red'>will not be replaced and stay missing</font>.</p>
        <br />
        <p>Treatment A, B and C differ according to: </p>
          <ul type='disc'>
              <li><b>Look/Appearance:</b>  'Like natural' or 'Artificial, fake'</li>
              <li><b>Chewing/Eating:</b>  'Like natural' or 'Compromised'</li>
              <li><b>Comfort/Fixation:</b>  'Fixed, comfortable' or 'Removable, less comfortable'</li>
              <li><b>How likely is it that it will work for 5 years: </b>  '60 out of 100', '80 out of 100', '90 out of 100' ,'99 out of 100'</li>
              <li><b>Procedure/Risk:</b>  Minor tooth removal’（ Removal of small amount of natural tooth ） or ‘Significant tooth removal ’（ Removal of significant amount of natural tooth ）or ‘Minor Surgery ’or ‘Complex Surgery’ </li>
              <li><b>Cost to you:</b>£250, £500, £2000, £3000</li>
          </ul>
        <br />
        <p style="word-break:keep-all">All other factors are the same in the different treatments. Please read the characteristic description in Section 2  or the appendix before you completing the survey. If you are using online questionnaire system, you can put your curser on the characteristics, and then the description will show up. </p>
        <br />
        <p style="word-break:keep-all">Please consider each choice separately and only choose ONE most preferred choice and ONE least preferred choice. Please answer every question. </p> 

        <form method="post" action="/questionnaireanswer" onsubmit="return checkform(this);">
            <table border=1>
        <% 
            DBDao db = new DBDao();
            db.insertData();
        
            
            PersistenceManager pm = PMF.get().getPersistenceManager();
            Query query = pm.newQuery(Choice.class,"questionnaire_id == qnid");
            query.declareParameters("Long qnid");
            List<Choice> choices = (List<Choice>) query.execute(questionnaireID);  
            
            
            int question_num = 7 ;
            
            String row_description [] = new String[6];
            row_description[0] = "Look/Appearance";
            row_description[1] = "Biting/Eating";
            row_description[2] = "Comfort/Fixation";
            row_description[3] = "Will it work for 5 years";
            row_description[4] = "Procedure/Risk";
            row_description[5] = "Cost";
               
            
            
            String q_most[] = {"q1_most","q2_most","q3_most","q4_most","q5_most","q6_most","q7_most"};
            String q_least[] = {"q1_least","q2_least","q3_least","q4_least","q5_least","q6_least","q7_least",};
      
            
            for(int j=0;j<7;j++){
                
            
            %>
                <tr>
                    <td colspan="5"><br>
                    <br></td>
                </tr>
                <tr>
                    <td style="border-bottom: none" colspan="5"><font size="3"><b><u><%="" + (j+1) %>:</u></b>&nbsp;&nbsp;
                            Which one of the following options would you prefer?</font></td>
                </tr>
                <tr border="0" height="0">
                    <td width="20%"></td>
                    <td width="20%" style="vertical-align: middle; text-align: center;"><b><abbr
                            title="testtest, title， title， title， title， title">Treatment
                                A</abbr></b></td>
                    <td width="20%" style="vertical-align: middle; text-align: center;"><b>Treatment
                            B</b></td>
                    <td width="20%" style="vertical-align: middle; text-align: center;"><b>Treatment
                            C</b></td>
                    <td width="20%" style="vertical-align: middle; text-align: center;"><b>Treatment
                            D</b></td>
                </tr>

                <tr>
                    <td style="vertical-align: middle; text-align: center;"><%= row_description[0] %></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+0).getLook_exp()%>"><%= choices.get(j*4+0).getLook() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+1).getLook_exp()%>"><%= choices.get(j*4+1).getLook() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+2).getLook_exp()%>"><%= choices.get(j*4+2).getLook() %></abbr></td>
                    <td rowspan="6" style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+3).getLook_exp()%>"><%= choices.get(j*4+3).getLook() %></abbr></td>
                </tr>
                <tr>
                    <td style="vertical-align: middle; text-align: center;"><%= row_description[1] %></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+0).getEating_exp()%>"><%= choices.get(j*4+0).getEating() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+1).getEating_exp()%>"><%= choices.get(j*4+1).getEating() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+2).getEating_exp()%>"><%= choices.get(j*4+2).getEating() %></abbr></td>
                   <!-- <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+3).getEating_exp()%>"><%= choices.get(j*4+3).getEating() %></abbr></td> -->
                </tr>
                <tr>
                    <td style="vertical-align: middle; text-align: center;"><%= row_description[2] %></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+0).getComfort_exp()%>"><%= choices.get(j*4+0).getComfort() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+1).getComfort_exp()%>"><%= choices.get(j*4+1).getComfort() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+2).getComfort_exp()%>"><%= choices.get(j*4+2).getComfort() %></abbr></td>
                   <!-- <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+3).getComfort_exp()%>"><%= choices.get(j*4+3).getComfort() %></abbr></td> -->
                </tr>
                <tr>
                    <td style="vertical-align: middle; text-align: center;"><%= row_description[3] %></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+0).getWorktime_exp()%>"><%= choices.get(j*4+0).getWorktime() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+1).getWorktime_exp()%>"><%= choices.get(j*4+1).getWorktime() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+2).getWorktime_exp()%>"><%= choices.get(j*4+2).getWorktime() %></abbr></td>
                   <!-- <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+3).getWorktime_exp()%>"><%= choices.get(j*4+3).getWorktime() %></abbr></td> -->
                </tr>
                <tr>
                    <td style="vertical-align: middle; text-align: center;"><%= row_description[4] %></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+0).getRisk_exp()%>"><%= choices.get(j*4+0).getRisk() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+1).getRisk_exp()%>"><%= choices.get(j*4+1).getRisk() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+2).getRisk_exp()%>"><%= choices.get(j*4+2).getRisk() %></abbr></td>
                   <!-- <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+3).getRisk_exp()%>"><%= choices.get(j*4+3).getRisk() %></abbr></td> -->
                </tr>
                <tr>
                    <td style="vertical-align: middle; text-align: center;"><%= row_description[5] %></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+0).getCost_exp()%>"><%= choices.get(j*4+0).getCost() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+1).getCost_exp()%>"><%= choices.get(j*4+1).getCost() %></abbr></td>
                    <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+2).getCost_exp()%>"><%= choices.get(j*4+2).getCost() %></abbr></td>
                    <!-- <td style="vertical-align: middle; text-align: center;"><abbr title="<%=choices.get(j*4+3).getCost_exp()%>"><%= choices.get(j*4+3).getCost() %></abbr></td> -->
                </tr>
                
                 <tr>
                    <td style="vertical-align: middle; text-align: center;">Your MOST preferred choice:</td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="MOST<%=j+1%>" value="1"></td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="MOST<%=j+1%>" value="2"></td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="MOST<%=j+1%>" value="3"></td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="MOST<%=j+1%>" value="4"></td>
                </tr>
                <tr>
                    <td style="vertical-align: middle; text-align: center;">Your LEAST preferred choice:</td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="LEAST<%=j+1%>" value="1"></td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="LEAST<%=j+1%>" value="2"></td>
                    <td style="vertical-align: middle; text-align: center;"><input type="radio" name="LEAST<%=j+1%>" value="3"></td>
                   <!-- <td style="vertical-align: middle; text-align: center;"><input type="radio" name="LEAST<%=j+1%>" value="4"></td>  --> 
                </tr>

    
                <%
            }
                %>


            </table>
           <br>
           <br>
          <p align="center"><input type="hidden"><input type="submit" value="Submit"></p>

        </form>
    </div>
</body>
</html>
