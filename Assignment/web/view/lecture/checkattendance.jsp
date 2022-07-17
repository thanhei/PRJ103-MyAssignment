<%-- 
    Document   : checkattendance
    Created on : Jul 11, 2022, 10:16:53 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="../css/check.css"/>

    </head>
    <body>
        <div>
            <h1>Single activity Attendance</h1>
            Attendance for <strong>${requestScope.gid}</strong> with lecture <strong>${lid}</strong>
        </div>      
        <div class="table">
            <form action="attendance" method="Post">
                <table border="1px">
                    <input type="hidden" name="seid" value="${requestScope.seid}">
                    <tr>
                        <th>No</th>              
                        <th>Group</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Status</th>
                        <th>Comment</th>
                        <th>Taker</th>

                    </tr>
                    <c:if test="${requestScope.students.size()>0}">
                        <c:forEach begin="0" end="${students.size()-1}" var="i" step="1">
                            <tr>
                                <td>${i+1}</td>                       
                                <td>${requestScope.gid}</td>
                                <td>${students.get(i).getRollnumber()}</td>
                            <input type="hidden" name="rollnumber" value="${students.get(i).getRollnumber()}">
                            <td>${students.get(i).getName()}</td>
                            <td></td>
                            <td> <input type="radio" name="status${i}" value="0" checked="checked"> Absent
                                <input type="radio" name="status${i}" value="1"> Present
                            </td>
                            <td></td>
                            <td>${lid}</td>
                            </tr>
                        </c:forEach>
                    </c:if> 

                    <c:if test="${requestScope.attendances.size()>0}">
                        <c:forEach begin="0" end="${attendances.size()-1}" var="i" step="1">
                            <tr>
                                <td>${i+1}</td>
                                <td>${requestScope.gid}</td>
                            <input type="hidden" name="rollnumber" value="${attendances.get(i).getStudent().getRollnumber()}">
                            <td>${attendances.get(i).getStudent().getRollnumber()}</td>
                            <input type="hidden" name="aid" value="${attendances.get(i).getAid()}">

                            <td>${attendances.get(i).getStudent().getName()}</td>
                            <td></td>
                            <td> <input type="radio" name="status${i}" value="0" 
                                        <c:if test="${attendances.get(i).getStatus() eq false}">
                                            checked="checked"
                                        </c:if>    > Absent
                                <input type="radio" name="status${i}" value="1"
                                       <c:if test="${attendances.get(i).getStatus() eq true}">
                                           checked="checked"
                                       </c:if>   > Present
                            </td>


                            <td></td>
                            <td>${lid}</td>


                            </tr>
                        </c:forEach>
                    </c:if>
                            




                </table>
                    <input style="float: right" type="submit" value="Save">
            </form>
        </div>

    </body>
</html>