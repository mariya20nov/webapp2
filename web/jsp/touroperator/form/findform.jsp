<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Form;
</sql:query>


<sql:query var="db2" dataSource="${con}">
    select * from Client;
</sql:query>


<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/form/forms.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/findform" method=post style="position:absolute; top:7%;">
    <p style="font-size:30px"> Find form</p>

    <p> Client </p>
    <select name="clientid">
        <c:forEach var="row" items="${db2.rows}">
            <option value=${row.client_id}>${row.surname} ${row.name} ${row.middle_name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Find form">
</form>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:35%">
    <thead>
    <tr>
        <th>form id</th>
        <th>client_id</th>
        <th>tour id</th>
        <th>date</th>
        <th>discount</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.form_id} </td>
            <td> ${row.client_id} </td>
            <td> ${row.tour_id} </td>
            <td> ${row.date} </td>
            <td> ${row.discount} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
