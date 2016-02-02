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
    <title>Find resort</title>
</head>
<body>
<form action="/findresort" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>FIND RESORT</font>
        </th>

        <td  valign=top>
            Name

            <input type="text" name="resortname" value="" size=15 maxlength=20></td>


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
        <th>resort_id</th>
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
</body>
</html>
