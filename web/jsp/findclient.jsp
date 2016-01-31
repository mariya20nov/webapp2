<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Client;
</sql:query>


<html>
<head>
    <title>Find client</title>
</head>
<body>
<form action="/findclient" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>FIND CLIENT</font>
        </th>

        <td  valign=top>
            Surname

            <input type="text" name="surname" value="" size=15 maxlength=20></td>


        <tr bgcolor="#c8d8f8">
            <td  align=center colspan=2>
                <input type="submit" value="Submit"> <input type="reset"
                                                            value="Reset">
            </td>
        </tr>

    </table>

</form>

<table>
    <thead>
    <tr>
        <th>client_id</th>
        <th>surname</th>
        <th>name</th>
        <th>middle_name</th>
        <th>passport</th>
        <th>tour count</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.client_id} </td>
            <td> ${row.surname} </td>
            <td> ${row.middle_name} </td>
            <td> ${row.passport} </td>
            <td> ${row.tour_count} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
