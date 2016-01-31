<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.epam.java.courses.fundamentals.dto.Client" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
    Collection<Client> clients = (Collection<Client>) request.getAttribute("clients");
%>
<html>
<head>
    <title>Hello, World!</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>client_id</th>
            <th>surname</th>
            <th>name</th>
            <th>middle name</th>
            <th>passport</th>
            <th>tour count</th>
        </tr>
    </thead>
    <tbody>

<!        <% for (Client client:clients) { %>
            <tr>
                <td><%=client.getId()%></td>
                <td><%=client.getSurname()%></td>
                <td><%=client.getName()%></td>
                <td><%=client.getMiddleName()%></td>
                <td><%=client.getPassport()%></td>
                <td><%=client.getTourCount()%></td>
            </tr>
        <% } %>
    </tbody>
</table>
<a href="clients">reset</a>
<a href="/jsp/addclient.jsp">add client</a>
<a href="/jsp/deleteclient.jsp">delete client</a>
<a href="/jsp/changeclient.jsp">change client</a>
<a href="/jsp/addtourcount.jsp">add tour count</a>
<a href="/jsp/findclient.jsp">find client</a>
<a href="/jsp/sortclients.jsp">sort client</a>

<table>
    <c:forEach var="row" items="${TravelAgency.Client}">
        <tr>
            <td>row.getString("client_id")</td>
            <td>row.getString("name")</td>
            <td>row.getString("surname")</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
