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
    <title>Title</title>
</head>
<body>
<form action="/deletetour" method=post>
    <td valign=top>
        Tour

        <select name="tourid">
            <c:forEach var="row" items="${db.rows}">
                <option value=${row.tour_id}>${row.name}</option>
            </c:forEach>
        </select>

    <tr bgcolor="#c8d8f8">
        <td  align=center colspan=2>
            <input type="submit" value="Submit"> <input type="reset"
                                                        value="Reset">
        </td>
    </tr>
</form>
</body>
</html>
