<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Form where form_id=${sqlstr};
</sql:query>

<html>
<head>
    <title>Title</title>
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


<form action="/deleteform" method=post>
        <input type="hidden" name="formid" value="${sqlstr}" />

        <tr bgcolor="#c8d8f8">
            <td  align=center colspan=2>
                <input type="submit" value="Delete this form"> <input type="reset"
                                                            value="Reset">
            </td>
        </tr>
</form>
<a href="/logout">sign out</a>
</body>
</html>
