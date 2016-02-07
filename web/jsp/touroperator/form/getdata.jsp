<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Form where form_id=${sessionScope.formid};
</sql:query>

<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/form/forms.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<p style="position:absolute; left:35%; font-size:30px">Info about this form:</p>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
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


<form action="/deleteform" method=post style="position:absolute; top:12%;">
    <input type="hidden" name="formid" value="${sessionScope.formid}" />
    <input type="submit" value="Delete this form">
</form>
</body>
</html>
