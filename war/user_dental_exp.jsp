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
			width: 500px;
			text-align: left
			}
   </style>

  </head>
  
  <body style= "margin:0;"><center>
  <iframe name="neepage" marginwidth="0" marginheight="0" src="./head.html" width="100%" height="80"></iframe>
  <h1 align="center"><b>Section 1.   Your Dental Experiences</b></h1>
  <h3>Please answer every question. </h3>
  
  <div id="container">
    <form method="post" action="/userdentalexp" onsubmit="return checkform(this);">
    <table>
        <tr>
            <td><b>1-1. Are you a ...</b></td>
        </tr>
        <tr>
            <table><tr>
                <td><input type="radio" name="1-1" value="1" onchange="">Patient</td>
                <td><input type="radio" name="1-1" value="2" onchange="">Dentist</td>
            </tr></table>
        </tr>
        <br>               
        <tr>
            <td><b>1-2. Have you ever lost any tooth since you were 21 years old? (Excluding the wisdom tooth)</b></td>
        </tr>
        <tr>
            <table><tr>
                <td><input type="radio" name="1-2" value="1" onchange="">Yes</td>
                <td><input type="radio" name="1-2" value="2" onchange="">No</td>
           </tr></table>
        </tr>
        <br>
        <tr>
            <td><b>1-3. How many natural teeth do you have?</b></td>
        </tr>
        <tr>
            <table>
	            <tr><td><input type="radio" name="1-3" value="1" onchange="">28-32（Full set of teeth is 32, including 4 wisdom teeth）</td></tr>
	            <tr><td><input type="radio" name="1-3" value="2" onchange="">21-27</td></tr>
	            <tr><td><input type="radio" name="1-3" value="3" onchange="">18-21</td></tr>
	            <tr><td><input type="radio" name="1-3" value="4" onchange="">10-18</td></tr>
	            <tr><td><input type="radio" name="1-3" value="5" onchange="">under 10 including none</td></tr>
	       </table>
        </tr>
        <br>
        <tr>
            <td><b>1-4. Hypothetically if you lost a tooth, would you choose to replace it ?</b></td>
        </tr>
        <tr>
            <table>
                <tr>
                    <td>In the front of the mouth</td>
                    <td><input type="radio" name="1-4-1" value="1" onchange="">Yes</td>
                    <td><input type="radio" name="1-4-1" value="2" onchange="">No</td>
                    <td><input type="radio" name="1-4-1" value="3" onchange="">Undecided</td>
                </tr>
                <tr>
                    <td>In the back of the mouth</td>
                    <td><input type="radio" name="1-4-2" value="1" onchange="">Yes</td>
                    <td><input type="radio" name="1-4-2" value="2" onchange="">No</td>
                    <td><input type="radio" name="1-4-2" value="3" onchange="">Undecided</td>
                </tr>
            </table>
        </tr>
        <br>
        <tr>
            <td><b>1-5. Which of the following dental treatment have you used the most in the last 5 years?  </b></td>
        </tr>
        <tr>
            <table>
                <tr><td><input type="radio" name="1-5" value="1">Dental bridges</td></tr>
                <tr><td><input type="radio" name="1-5" value="2">Removable dentrues</td></tr>
                <tr><td><input type="radio" name="1-5" value="3">Dental implant supported crown/bridge/denture</td></tr>
                <tr><td><input type="radio" name="1-5" value="4">Other dental treatment e.g. dental cleaning, fillings, extractions, etc. </td></tr>
            </table>
       </tr>
       <br>
       <tr>
            <td><b>1-6. Where did you get the dental treatment from?</b></td>
       </tr>
       <tr>
            <table>
                <tr><td><input type="radio" name="1-6" value="1" onchange="">In NHS hospital</td></tr>  
                <tr><td><input type="radio" name="1-6" value="2" onchange="">In NHS dental clinic</td></tr>
                <tr><td><input type="radio" name="1-6" value="3" onchange="">In Private Dental Practice/Surgery</td></tr>
                <tr><td><input type="radio" name="1-6" value="4" onchange="">Others or more than one  (please specify) 
                        <input type="text" name="1-6-where" size=20/>
                        </td></tr>
            </table>
       </tr>
       
        <br><br>

    </table>
        <P align="center"><input type="submit" value="continue"></P>
    </form>
  </div>
  </center>
  </body>
</html>
