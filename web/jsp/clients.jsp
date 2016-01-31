<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.epam.java.courses.fundamentals.dto.Client" %>
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

        <% for (Client client:clients) { %>
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
<a href="/jsp/addclient.jsp">add client</a>
<a href="/jsp/deleteclient.jsp">delete client</a>
<a href="/jsp/changeclient.jsp">change client</a>
<a href="/jsp/addtourcount.jsp">add tour count</a>
<a href="/jsp/findclient.jsp">find client</a>
<a href="/jsp/sortclientsID.jsp">sort client by ID</a>
<a href="/jsp/sortclientsSurname.jsp">sort client by surname</a>
</body>
</html>
