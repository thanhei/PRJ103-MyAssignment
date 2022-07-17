<%-- 
    Document   : viewattendance
    Created on : Jul 17, 2022, 12:19:23 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="../css/view.css"/>

    </head>
    <body >
        <div>
            <h1>View Attendance for ${requestScope.gcode}</h1>
        </div>
        <div style="width: 100%">
             <table border="1px" style="margin: auto; border-collapse: collapse">
            <th>
                No
            </th>
            <th>
                Rollnumber
            </th>
            <th>
                name
            </th>
            <th>
                Total Absent
            </th>
            <th>
                SLot1              
            </th>
            <th>
                SLot2            
            </th>
            <th>
                SLot3              
            </th>
            <th>
                SLot4              
            </th>
            <th>
                SLot5             
            </th>
            <th>
                SLot6             
            </th>
            <th>
                SLot7              
            </th>
            <th>
                SLot8              
            </th>
            <th>
                SLot9              
            </th>
            <th>
                SLot10              
            </th>
            <th>
                SLot11             
            </th>
            <th>
                SLot12             
            </th>
            <th>
                SLot13             
            </th>
            <th>
                SLot14             
            </th>
            <th>
                SLot15             
            </th>         
            <c:forEach begin="0" end="${slist.size()-1}" var="i" step="1">
                <tr>
                    <td>${i+1}</td>
                    <td>${slist.get(i).getRollnumber()}</td>
                    <td >${slist.get(i).getName()}</td>
                    <td>Demo</td>
                    <c:forEach items="${alist}" var="a">
                        <c:if test="${slist.get(i).getRollnumber() eq a.getStudent().getRollnumber()}">
                            <c:if test="${a.getStatus() eq true}">
                                <td>Present</td>
                            </c:if>
                                
                            <c:if test="${a.getStatus() eq false}">
                                <td>Absent</td>
                            </c:if>
                                
                        </c:if>
                    </c:forEach>
                                
                </tr>
            </c:forEach>
        </table>
        
        </div>

    </body>
</html>