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
<table>
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
<a href="/jsp/forms.jsp">reset</a>

<form action="/findform" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>FIND FORM</font>
        </th>


        <td valign=top>
            Client

            <select name="clientid">
                <c:forEach var="row" items="${db2.rows}">
                    <option value=${row.client_id}>${row.surname} ${row.name} ${row.middle_name}</option>
                </c:forEach>
            </select>


        <tr bgcolor="#c8d8f8">
            <td  align=center colspan=2>
                <input type="submit" value="Find tour"> <input type="reset"
                                                               value="Reset">
            </td>
        </tr>

    </table>

</form>
<a href="/logout">sign out</a>
</body>
</html>
