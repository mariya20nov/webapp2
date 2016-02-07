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
</head>
<body>
<a href="/jsp/touroperator/TourOperator.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<p style="position:absolute; left:35%; font-size:30px">Resorts</p>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
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

<a href="/jsp/touroperator/resort/addresort.jsp"><p style="position:absolute; top:15%;">add resort</p></a>
<a href="/jsp/touroperator/resort/deleteresort.jsp"><p style="position:absolute; top:18%;">delete resort</p></a>
<a href="/jsp/touroperator/resort/findresort.jsp"><p style="position:absolute; top:21%;">find resort</p></a>
</body>
</html>
