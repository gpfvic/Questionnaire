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
    
    <title>Cost to you</title>
    
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
  <h1 align="center"><b>Section 2.  Cost to you</b></h1>
      <p align="left"><b>
      We are interested in finding out how much you value each of the treatments. One way of doing this is to ask you to imagine that you live in a country where you have to pay for all dental treatments. 
      </b></p>
    <form method="post" action="/usermissingtooth" onsubmit="return checkform(this);">
    <table>
<!--  <tr>
            <td><b>2-1. Looks/Appearance</b>
        </tr>
        <tr>
            <table border='1'>
                <tr>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-1" value="1">Like Natural<br>
                        <p>Like a natural healthy tooth, improve appearance, support shape of face and smiling.</p>
                    </td>
                    <td  width="33%">
                        <input type="radio" name="2-1" value="2">Fake, Artificial<br>
                        <p>Noticeable difference between healthy natural tooth and false tooth in colour, shape, etc.</p>
                    </td>
                    <td  width="33%">
                        <input type="radio" name="2-1" value="3">None of them <br>
                        <p>I would say</p><input type="text" name="2-1other_look" size='16'>
                    </td>
                </tr>
            </table>
        </tr>

        <tr>
            <td><b>2-1. Chewing/Eating</b>
        </tr>
        <tr>
            <table border='1'>
                <tr>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-2" value="1">Like Natural<br>
                        <p>Like a natural healthy tooth, improve appearance, support shape of face and smiling.</p>
                    </td>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-2" value="2">Compromised<br>
                        <p>Can not bite tough, sticky food, eating with care, feeling like a foreign object in your mouth, food may get stuck under the prosthesis.</p>
                    </td>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-2" value="3">None of them <br>
                        <p>I would say</p><input type="text" name="2-2other_eating" size='16'>
                    </td>
                </tr>
            </table>
        </tr>
        
        <tr>
            <td><b>2-2. Fixation/ Comfort </b>
        </tr>
        <tr>
            <table border='1'>
                <tr>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-3" value="1">Fixed, Comfortable<br>
                        <p>Fixed to your teeth or jawbone, secured and stabilised replacement, can’t be removed by your self. Comfortable, can be cleaned like natural teeth.</p>
                    </td>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-3" value="2">Removable<br>
                        <p>Removable, may slip and move in the mouth while eating and speaking, easy to remove, replace and clean, Less comfortable.</p>
                    </td>
                    <td  width="33%" valign="top">
                        <input type="radio" name="2-3" value="3">None of them<br>
                        <p>I would say</p><input type="text" name="2-3other_comfort" size='16'>
                    </td>
                </tr>
            </table>
        </tr>
        
        <tr>
            <td><b>2-3.</b></td>
        </tr>
        <br>
        <tr>
            <td>
                <b>Length of time it has been restored:</b><input type="text" name="2-4-1" size="16">years<br>
                <b>Length of time you expect it to last :</b><input type="text" name="2-4-2" size="16">years<br>
           </td>
        </tr>
        <tr>
            <td >
                <p>Research showed that prosthesis has a limited life span and 5 year survival rate will locate between 60%-99%, which means that 5 years later, at least 60 out of 100 prostheses will be still function and in use. The best scenario is that, for certain type of denture, 99 out of 100 will be still function and in use. It depends on patient’s oral health condition, oral hygiene behavior, denture type, treatment design and maintenance.</p>  
            </td>
        </tr>    
       
        <tr>
            <td><b>2-5.  Procedure and risks you have  been exposed. </b>
        </tr>
        <tr>
            <table border='1'>
                <tr>
                    <td  width="25%" valign="top">
                        <input type="radio" name="2-5" value="1">Minor grinding on teeth<br>
                        <p>Like small fillings.<br>Need to remove small amount of natural teeth, may develop secondary caries in a few years, may experience jaw bone loss on the missing teeth site, but no swelling.</p>
                    </td>
                    <td  width="25%" valign="top">
                        <input type="radio" name="2-5" value="2">Significant grinding on teeth<br>
                        <p>Like big fillings.<br>Need to remove significant amount of your natural teeth in order to place such a prosthesis, secondary decay may develop in a few years, may experience jaw bone loss on the missing teeth site, but no swelling.</p>
                    </td>
                    <td  width="25%" valign="top">
                        <input type="radio" name="2-5" value="3">Minor Surgery<br>
                        <p>Like an extraction.<br>Need to go through minor surgery on the jaw bone in order to provide better results. Swelling and bruising may develop after treatment for 7-14 days, but preserves jaw in long term and does not grind/drill other teeth.</p>
                        
                    </td>
                    <td  width="25%" valign="top">
                        <input type="radio" name="2-5" value="4">Complex Surgery<br>
                        <p>Like two extractions.<br>Need to go through 2 minor surgeries on the jaw bone in order to provide better results. Swelling and bruising may develop after treatment for 7-14 days, but preserves jaw in long term and does not grind/drill other teeth.</p>
                    </td>
                    <td valign="top">
                        <input type='radio' name='2-5' value="5">None of them
                        <br><br><br>I would say
                        <br><BR>
                        <input type="text" name='2-5-other_risks' size=16>
                        <br><br><BR><br><BR><br><BR>
                    </td>
                </tr>
            </table>
        </tr>

 
        <br>
        <tr>
            <td><b>2-4. Cost to you:</b></td>
        </tr>
     
        
 -->  
        <br>
        <tr>
            <td ><p>2-1. We are interested in finding out how much you value each of the treatments. One way of doing this is to ask you to imagine that you live in a country where you have to pay for all dental treatments.</p></td>
        </tr>
        <tr>
            <table border='1' align="center">
                <tr>
                    <th width='25%'></th>
                    <th  width='25%' align="center">Willing to pay for removable dentures</th>
                    <th  width='25%' align="center">Willing to pay for fixed bridges /dentures      </th>
                    <th  width='25%' align="center">Willing to pay for dental implants related dentures</th>
                </tr>
                <tr>
                    <td align="center">Amount in £’s</td>
                    <td align="center">
                        <select name="2-6-c1">
                            <option value="0">0</option>
                            <option value="30">30</option>
                            <option value="60">60</option>
                            <option value="120">120</option>
                            <option value="240">240</option>
                            <option value="480">480</option>
                            <option value="600">600</option>
                            <option value="800">800</option>
                            <option value="1000">1000</option>
                            <option value="1200">1200</option>
                            <option value="1500">1500</option>
                            <option value="2000">2000</option>
                            <option value="2500">2500</option>
                            <option value="3000">3000</option>
                            <option value=">3000">>3000</option>
                        </select>
                    </td>
                    <td align="center">
                        <select name="2-6-c2">
                            <option value="0">0</option>
                            <option value="30">30</option>
                            <option value="60">60</option>
                            <option value="120">120</option>
                            <option value="240">240</option>
                            <option value="480">480</option>
                            <option value="600">600</option>
                            <option value="800">800</option>
                            <option value="1000">1000</option>
                            <option value="1200">1200</option>
                            <option value="1500">1500</option>
                            <option value="2000">2000</option>
                            <option value="2500">2500</option>
                            <option value="3000">3000</option>
                            <option value=">3000">>3000</option>
                        </select>
                    </td>
                    <td align="center">
                        <select name="2-6-c3">
                            <option value="0">0</option>
                            <option value="30">30</option>
                            <option value="60">60</option>
                            <option value="120">120</option>
                            <option value="240">240</option>
                            <option value="480">480</option>
                            <option value="600">600</option>
                            <option value="800">800</option>
                            <option value="1000">1000</option>
                            <option value="1200">1200</option>
                            <option value="1500">1500</option>
                            <option value="2000">2000</option>
                            <option value="2500">2500</option>
                            <option value="3000">3000</option>
                            <option value=">3000">>3000</option>
                        </select>
                    </td>
                </tr>

                
            </table>
        </tr>
        <br><br>
        <tr>
            <td >2-2. If the amount you are willing to pay is greater than £3000, please state the maximum extra amount of money that you would be willing to pay £ <input type="text" name="2-6-d" size=16></td>
        </tr>
       <br><br>
        <tr>
            <td >2-3. If you choose 0, what is the main reason for this？</td>
        </tr>
        <br>
        <tr>
            <td >
              <table>
                <tr><td><input type="radio" name="2-6-e" value="1">Do not value the treatment</tr></td>
                <tr><td><input type="radio" name="2-6-e" value="2">Can not afford to pay</tr></td>
                <tr><td><input type="radio" name="2-6-e" value="3">I object in principle of have to pay </tr></td>
                <tr><td><input type="radio" name="2-6-e" value="4">Others (please state) <input type="text" name="2-6-e-other" size=16></tr></td>
                <tr><td><input type="radio" name="2-6-e" value="5">Did not choose 0 </tr></td>
           </table>
            </td> 
        </tr>
        <br><br>
        <tr> 
            <td>2-4. How much have you paid for the tooth replacement?   £ 
                <input type="text" name="2-6-a" size=16> 
            </td>
        </tr>
        <br>
        <tr>
            <td>
            <table>
               <tr><td> <input type="radio" name="2-6-b" value="1">Paid nothing</tr></td>
               <tr><td> <input type="radio" name="2-6-b" value="2">Less than 250</tr></td>
               <tr><td> <input type="radio" name="2-6-b" value="3">250-500</tr></td>
               <tr><td> <input type="radio" name="2-6-b" value="4">500-2000</tr></td>
               <tr><td> <input type="radio" name="2-6-b" value="5">More than 2000</tr></td>
               <tr><td> <input type="radio" name="2-6-b" value="6">Never had tooth replacement </tr></td>
              </table>
            </td>
        </tr>
        <br>
        
    </table>
    <br><br>
        <p align="center"><input type="submit" value="submit"></p>
    </form>
  </div>
  </body>
</html>
