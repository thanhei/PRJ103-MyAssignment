<%-- 
    Document   : Schedule
    Created on : Jul 5, 2022, 6:39:28 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./style.css/timetable.css">
     <script> 
            function myfunction()
            {
                let  form=document.getElementById("form1");
                form.submit();
                   
                
            }
            
            function myfunction2()
            {
                let  form=document.getElementById("form1");
                form.submit();
                   
                
            }
           
        </script>
    
</head>

<body>
    <div class="header">
        <div class=header-tittle>
            <h1>
                FPT University Academic Portal
            </h1>
        </div>
        <div class="header-logo">
            <img src="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png" alt="">
        </div>

        <div>
            <table>
                <tr>
                    <td>
                        <h3>Available on</h3>
                    </td>
                    <td><a href="https://apps.apple.com/app/id1527723314">
                            <img src="https://fap.fpt.edu.vn/images/app-store.svg" style="width: 120px; height: 40px"
                                alt="apple store"></a></td>
                    <td>
                        <a href="https://play.google.com/store/apps/details?id=com.fuct">
                            <img src="https://fap.fpt.edu.vn/images/play-store.svg" style="width: 120px; height: 40px"
                                alt="google store"></a>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div style="text-align: center ;">
        <select name="" id="">
            <option value="" selected="selected">Fu-Hòa Lạc</option>
            <option value="">Fu-HCM</option>
            <option value="">Fu-ĐN</option>
        </select>
        </br>

        Lecture <input type="text" name="" id="" value="sonnt5">

    </div>
    </br>
    <div class="time-table">
        <form  id="form1" action="schedule" method="POST">
              <table border="1">
            <tr>
                <th>Year<select name="year" onchange="myfunction()">
                        <c:forEach items="${requestScope.years}" var="y">
                            <option value="${y}"
                                    
                                    <c:if test="${requestScope.today.getYear() eq y}">
                                        selected="selected"
                                    </c:if>        
                                    
                                    >${y}</option>
                                    
                                    
                              
                        </c:forEach>
                    </select> </th>
                <th>MON</th>
                <th>TUE</th>
                <th>WED</th>
                <th>THU</th>
                <th>FRI</th>
                <th>SAT</th>
                <th>SUN</th>
            </tr>
            <tr>
                    <th>Week
                        <select name="week1" onchange="myfunction()">
                            <c:forEach  items="${requestScope.weeks}" var="e">
                                <option value="${e.startdate}" style="text-align: center"                                  
                                        <c:forEach var="i" begin="0" end="6">
                                            <c:if test="${e.startdate.plusDays(i) eq requestScope.today}">
                                                selected="selected"                     
                                         </c:if>
                                              </c:forEach>
    
                                            
                                            >${e.startdate.getDayOfMonth()}/${e.startdate.getMonthValue()} to ${e.endate.getDayOfMonth()}/${e.endate.getMonthValue()}</option>
                            </c:forEach>                                 
                        </select>
                     </th>    
                     <c:forEach  items="${requestScope.weeks}" var="z">
                        <c:forEach var="i" begin="0" end="6">
                            <c:if test="${z.startdate.plusDays(i) eq requestScope.today}">
                                  <c:forEach var="j" begin="0" end="6">
                             <th>${z.startdate.plusDays(j).getDayOfMonth()}/${z.startdate.plusDays(j).getMonthValue()}</th>
                              </c:forEach>
                            </c:if>
                         
                    </c:forEach>
                      </c:forEach> 
                </tr>
            <tr>
                <td>slot1</td>
                <td>${requestScope.today2}</td>
                <td>JPD123-View Materials </br>
                    at DE-C201 </br>
                    (absent)</td>
                <td>PRJ301-View Materials</br>
                    at DE-C201</br>
                    (attended)</td>
                <td>PRJ301-View Materials</br>
                    at DE-C201</br>
                    (attended)</td>
                <td>PRJ301-View Materials</br>
                    at DE-C201</br>
                    (attended)</td>
                <td>PRJ301-View Materials</br>
                    at DE-C201</br>
                    (attended)</td>
                <td>PRJ301-View Materials</br>
                    at DE-C201</br>
                    (attended)</td>
            </tr>
            <tr>
                <td>slot 2</td>
                <td>DBI-View Materials </br>
                    at DE-C301 </br>
                    (attended)</td>
                <td>DBI-View Materials </br>
                    at DE-C301 </br>
                    (attended)</td>
                <td>DBI-View Materials </br>
                    at DE-C301 </br>
                    (attended)</td>
                <td>DBI-View Materials </br>
                    at DE-C301 </br>
                    (attended)</td>
                <td>PRJ301-View Materials</br>
                    at DE-C201</br>
                    (attended)</td>
                <td>>DBI-View Materials </br>
                    at DE-C301 </br>
                    (attended)</td>
                <td>DBI-View Materials </br>
                    at DE-C301 </br>
                    (attended)</td>
            </tr>
            <tr>
                <td>slot3</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>slot4</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>slot5</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>slot6</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>slot7</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>slot8</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>

        </table>
        </form>
    </div>


</body>

</html>