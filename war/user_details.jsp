<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="/welcome_info.jsp"%>



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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>General information</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="./index.css">
    
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
   </style>

  </head>
  
  <body style= "margin:0;">
  <iframe name="neepage" marginwidth="0" marginheight="0" src="./head.html" width="100%" height="80"></iframe>
  <div id="container">
      <h1 align="center"><b>Section 4.    Details About You</b></h1>
      <br>
      <Br>
      <h3>We would like to ask a few questions about you, so that we may better understand your answers to the questionnaire.</h3>

    <form method="post" action="/userdetails" onsubmit="return checkform(this);">
    <table>
        <tr>
            <td>
                <b>4-1. Are you...</b>
                <br>
                <input type='radio' name='4-1' value='1'>Male
                <input type='radio' name='4-1' value='2'>Female      
            </td>
        </tr>
        
        <br>
        
        <tr>
            <td><b>4-2. How old are you?</b></td>
        </tr>
        <tr>
            <td>
                <input type='radio' name='4-2' value='1'>21-24
                <input type='radio' name='4-2' value='2'>25-34
                <input type='radio' name='4-2' value='3'>35-44
                <input type='radio' name='4-2' value='4'>45-54
                <input type='radio' name='4-2' value='5'>55-64
                <input type='radio' name='4-2' value='6'>65-74
                <input type='radio' name='4-2' value='7'> 75+
            </td>
        </tr>
        
        <br>
        
        <tr>
            <td><b>4-3. What is the highest level of education you have completed? (Please tick one box only)</b></td>
        </tr>
        <tr><td><input type='radio' name='4-3' value='1'>Degree</td></tr>
        <tr><td><input type='radio' name='4-3' value='2'>Other professional/technical qualification/diploma after leaving school</td></tr>
        <tr><td><input type='radio' name='4-3' value='3'>Highers or equivalent</td></tr>
        <tr><td><input type='radio' name='4-3' value='4'>Standard grade/O levels or equivalent</td></tr>
        <tr><td><input type='radio' name='4-3' value='5'>No qualification</td></tr>
       
        <br>
        
        <tr>
            <td><b>4-4. Which statement best describes you at present?  (Please tick one box only)</b></td>
        </tr>
        <tr>    <td><input type='radio' name='4-4' value='1'>In paid work or self-employed – full time</td></tr>
        <tr>    <td><input type='radio' name='4-4' value='2'>In paid work or self-employed – part time</td></tr>
         <tr>   <td><input type='radio' name='4-4' value='3'>Unemployed and looking for work</td></tr>
         <tr>   <td><input type='radio' name='4-4' value='4'>Retired</td></tr>
        <tr>    <td><input type='radio' name='4-4' value='5'>Looking after the home or family –full time</td></tr>
        <tr>    <td><input type='radio' name='4-4' value='6'>Not looking for work</td></tr>
        <tr>    <td><input type='radio' name='4-4' value='7'>Not able to work</td></tr>
        <tr>    <td><input type='radio' name='4-4' value='8'>In full-time education</td></tr>
        
        
        <br>
        
        <tr>
            <td><b>4-5. What is your total household income from all sources before tax? Your total income includes money you earn through work, benefits or tax credits you receive, and any other income. (Please tick one box only)</b></td>
        </tr>
        <tr>
            <table align='left'>
                <tr>
                    <th>Per week</th>
                    <th></th>
                    <th>Per year</th>
                </tr>
                <tr>
                    <td>Less than £100</td>
                    <td><input type='radio' name='4-5' value='1'></td>
                    <td>Less than £5,200</td>
                </tr>     
                <tr>
                    <td>£100 - £199</td>
                    <td><input type='radio' name='4-5' value='2'></td>
                    <td>£ 5,200 to £10,399</td>
                </tr>
                <tr>
                    <td>£200 - £299</td>
                    <td><input type='radio' name='4-5' value='=3'></td>
                    <td>£ 10,400 to £15, 599</td>
                </tr>
                <tr>
                    <td>£300 - £399</td>
                    <td><input type='radio' name='4-5' value='4'></td>
                    <td>£15,600 to £20,799</td>
                </tr>
                <tr>
                    <td>£400 - £499</td>
                    <td><input type='radio' name='4-5' value='5'></td>
                    <td>£20,800 to £ 25,999</td>
                </tr>
                <tr>
                    <td>£500 - £599</td>
                    <td><input type='radio' name='4-5' value='6'></td>
                    <td>£26,000 to £31,199</td>
                </tr>
                <tr>
                    <td>£600 or more</td>
                    <td><input type='radio' name='4-5' value='7'></td>
                    <td>£ 32100 or more</td>
                </tr>
            </table>
        </tr>
       
    </table>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <p>
       <b>Are there any comments that you would like to make regarding the questionnaire?</b>
       <br><br>
       <textarea name='comments' rows="6" cols="60">
            Please input here ...
        </textarea>
    </p>
    
   <p align="center"><input type="submit" value="continue"></p>
    
    </form>
  </div>
</body>
</html>
        
