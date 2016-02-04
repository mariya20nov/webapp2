<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Tour;
</sql:query>


<html>
<head>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>tour id</th>
        <th>resort_id</th>
        <th>type_id</th>
        <th>name</th>
        <th>date_beg</th>
        <th>date_end</th>
        <th>cost</th>
        <th>hot</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.tour_id} </td>
            <td> ${row.resort_id} </td>
            <td> ${row.type_id} </td>
            <td> ${row.name} </td>
            <td> ${row.date_beg} </td>
            <td> ${row.date_end} </td>
            <td> ${row.cost} </td>
            <td> ${row.hot} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/jsp/tours.jsp">reset</a>

<a href="/jsp/addtour.jsp">add tour</a>
<a href="/jsp/deletetour.jsp">delete tour</a>
<a href="/jsp/findtour.jsp">find tour</a>
<a href="/jsp/changetour.jsp">change cost</a>

<a href="/jsp/hottour.jsp">mark as hot</a>

<a href="/touroperator">touroperator</a>

<a href="/logout">sign out</a>
</body>
</html>
