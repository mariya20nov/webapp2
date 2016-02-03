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


<html>
<head>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>form_id</th>
        <th>client_id</th>
        <th>tour_id</th>
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
<a href="/jsp/forms.jsp">reset</a>

<a href="/listofforms">add form</a>
<a href="/jsp/deleteform.jsp">delete form</a>
<a href="/jsp/findform.jsp">find form</a>

<a href="/touroperator">touroperator</a>
</body>
</html>

