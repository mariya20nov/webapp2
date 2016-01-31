<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Client;
</sql:query>

<html>
<head>
    <title>Hello, World!</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>client_id</th>
        <th>name</th>
        <th>surname</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.client_id} </td>
            <td> ${row.name} </td>
            <td> ${row.surname} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>