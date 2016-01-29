<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.epam.java.courses.fundamentals.dto.Tour" %>
<%
    Collection<Tour> tours = (Collection<Tour>) request.getAttribute("tours");
%>
<html>
<head>
    <title>Tours</title>
</head>
<body>
    <jsp:text>Tours</jsp:text>
    <table>
        <thead>
        <tr>
            <th>tour_id</th>
            <th>resort_id</th>
            <th>type_id</th>
            <th>name</th>
            <th>date_beg</th>
            <th>date_end</th>
            <th>cost</th>
        </tr>
        </thead>
        <tbody>

        <% for (Tour tour:tours) { %>
        <tr>
            <td><%=tour.getId()%></td>
            <td><%=tour.getResortId()%></td>
            <td><%=tour.getTypeId()%></td>
            <td><%=tour.getName()%></td>
            <td><%=tour.getDateBeg()%></td>
            <td><%=tour.getDateEnd()%></td>
            <td><%=tour.getCost()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
