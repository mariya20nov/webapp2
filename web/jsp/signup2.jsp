<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Client WHERE passport=${sessionScope.passport};
</sql:query>

<html>
<head>
    <title>Title</title>
</head>
<body>
Hello!

<table>
    <thead>
    <tr>
        <th>Your login</th>
        <th>Your password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.client_id} </td>
            <td> ${row.pwd} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<a href="/logout">sign out</a>
</body>
</html>
