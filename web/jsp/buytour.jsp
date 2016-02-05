<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>

<sql:query var="sqlClient" dataSource="${con}">
    select * from Client WHERE client_id=${sessionScope.client};
</sql:query>

<sql:query var="sqlTour" dataSource="${con}">
    select * from Tour;
</sql:query>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/buytour" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>buy tour</font>
        </th>

        <tr bgcolor="#c8d8f8">
            <td valign=top>
                Client

                <select name="clientid">
                    <c:forEach var="row" items="${sqlClient.rows}">
                        <option value=${row.client_id}>${row.surname} ${row.name} ${row.middle_name}</option>
                    </c:forEach>
                </select>

            <td valign=top>
                Tour

                <select name="tourid">
                    <c:forEach var="row" items="${sqlTour.rows}">
                        <option value=${row.tour_id}>${row.name}</option>
                    </c:forEach>
                </select>
        </tr>

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
