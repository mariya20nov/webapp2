<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Client WHERE surname=${sqlstr};
</sql:query>


<html>
<head>
    <title>Find client</title>
</head>
<body>

<table>
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
            <td> ${row.middle_name} </td>
            <td> ${row.passport} </td>
            <td> ${row.tour_count} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/logout">sign out</a>
</body>
</html>
