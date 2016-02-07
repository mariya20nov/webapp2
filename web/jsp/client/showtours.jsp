<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select Form.*, Tour.name, Tour.date_beg, Tour.date_end from Form JOIN Tour on Form.tour_id=Tour.tour_id WHERE client_id=${sessionScope.client};
</sql:query>


<html>
<head>
</head>
<body>
<a href="/jsp/client/ordinaryclient.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:55%;">Log out</p></a>

<p style="position:absolute; left:35%; font-size:30px">Tours</p>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
    <thead>
    <tr>
        <th>form_id</th>
        <th>tour_id</th>
        <th>tour name</th>
        <th>date of beg</th>
        <th>date of end</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.form_id} </td>
            <td> ${row.tour_id} </td>
            <td> ${row.name} </td>
            <td> ${row.date_beg} </td>
            <td> ${row.date_end} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="/refusetour" method=post style="position:absolute; top:14%;">
    <select name="formid">
        <c:forEach var="row" items="${db.rows}">
            <option value=${row.form_id}>${row.name} </option>
        </c:forEach>
    </select>

    <input type="submit" value="Refuse">
</form>
</body>
</html>

