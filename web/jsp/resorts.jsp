<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Resort;
</sql:query>


<html>
<head>
    <title>Resorts</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>resort id</th>
        <th>name</th>
        <th>country</th>
        <th>location</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.resort_id} </td>
            <td> ${row.name} </td>
            <td> ${row.country} </td>
            <td> ${row.location} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="resorts.jsp">reset</a>

<a href="/jsp/addresort.jsp">add resort</a>
<a href="/jsp/deleteresort.jsp">delete resort</a>
<a href="/jsp/findresort.jsp">find resort</a>

<a href="/touroperator">touroperator</a>
<a href="/logout">sign out</a>
</body>
</html>
