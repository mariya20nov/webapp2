<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>

<sql:query var="db" dataSource="${con}">
    select * from Tour;
</sql:query>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<form action="/changetour" method=post>
    <td valign=top>
        Tour_id to change cost
        <select name="tourid">
            <c:forEach var="row" items="${db.rows}">
                <option value=${row.tour_id}>${row.name}</option>
            </c:forEach>
        </select>
        <table cellpadding=4 cellspacing=2 border=0>

            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>CHANGE Tour cost</font>
            </th>

            <td valign=top>
                Cost

                <input type="text" name="cost" value="" size=25  maxlength=125>
            </td>

            <tr bgcolor="#c8d8f8">
                <td  align=center colspan=2>
                    <input type="submit" value="Submit"> <input type="reset"
                                                                value="Reset">
                </td>
            </tr>

        </table>
</form>
<a href="/logout">sign out</a>
</body>
</html>
