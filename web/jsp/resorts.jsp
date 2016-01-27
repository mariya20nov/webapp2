<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.epam.java.courses.fundamentals.dto.Resort" %>
<%
    Collection<Resort> resorts = (Collection<Resort>) request.getAttribute("resorts");
%>
<html>
<head>
    <title>Resorts</title>
</head>
<body>
    <jsp:text>Resorts</jsp:text>
    <table>
        <thead>
        <tr>
            <th>resort_id</th>
            <th>name</th>
            <th>country</th>
            <th>location</th>
        </tr>
        </thead>
        <tbody>

        <% for (Resort resort:resorts) { %>
        <tr>
            <td><%=resort.getId()%></td>
            <td><%=resort.getName()%></td>
            <td><%=resort.getCountry()%></td>
            <td><%=resort.getLocation()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
