<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Client WHERE surname=${sessionScope.surname};
</sql:query>


<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/client/clients.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<a href="/jsp/touroperator/client/findclient.jsp" ><p style="position:absolute; top:12%;">Find another client</p></a>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
    <thead>
    <tr>
        <th>client_id</th>
        <th>surname</th>
        <th>name</th>
        <th>middle_name</th>
        <th>passport</th>
        <th>tour count</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.client_id} </td>
            <td> ${row.surname} </td>
            <td> ${row.name} </td>
            <td> ${row.middle_name} </td>
            <td> ${row.passport} </td>
            <td> ${row.tour_count} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
