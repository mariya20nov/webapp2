<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    ${sessionScope.sqlstr}
</sql:query>


<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/tour/tours.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<a href="/jsp/touroperator/tour/findtour.jsp" ><p style="position:absolute; top:12%;">Find another tour</p></a>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
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
</body>
</html>
