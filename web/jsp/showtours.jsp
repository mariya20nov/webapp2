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
<table>
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

<form action="/refusetour" method=post>
    <input type="hidden" name="client" value=${sessionScope.client}>

    <td valign=top>

        <select name="formid">
            <c:forEach var="row" items="${db.rows}">
                <option value=${row.form_id}>${row.name} </option>
            </c:forEach>
        </select>

        <tr bgcolor="#c8d8f8">
            <td  align=center colspan=2>
                <input type="submit" value="Refuse"> <input type="reset"
                                                            value="Reset">
            </td>
        </tr>
</form>

<a href="/jsp/ordinaryclient.jsp">to main page</a>
<a href="/logout">sign out</a>
</body>
</html>

