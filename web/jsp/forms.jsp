<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.epam.java.courses.fundamentals.dto.Form" %>
<%
    Collection<Form> forms = (Collection<Form>) request.getAttribute("forms");
%>
<html>
<head>
    <title>Forms</title>
</head>
<body>
    <jsp:text>Forms</jsp:text>
    <table>
        <thead>
        <tr>
            <th>form_id</th>
            <th>client_id</th>
            <th>tour_id</th>
            <th>date</th>
            <th>discount</th>
        </tr>
        </thead>
        <tbody>

        <% for (Form form:forms) { %>
        <tr>
            <td><%=form.getId()%></td>
            <td><%=form.getClientId()%></td>
            <td><%=form.getTourId()%></td>
            <td><%=form.getDate()%></td>
            <td><%=form.getDiscount()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
