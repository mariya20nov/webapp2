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
</head>
<body>
<table>
    <thead>
    <tr>
        <th>tour id</th>
        <th>resort_id</th>
        <th>type_id</th>
        <th>name</th>
        <th>date_beg</th>
        <th>date_end</th>
        <th>cost</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.tour_id} </td>
            <td> ${row.resort_id} </td>
            <td> ${row.type_id} </td>
            <td> ${row.name} </td>
            <td> ${row.date_beg} </td>
            <td> ${row.date_end} </td>
            <td> ${row.cost} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/jsp/ordinaryclient.jsp">reset</a>

<form action="/ordinaryclient" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>FIND TOUR</font>
        </th>

        <select name="country">
            <option value="">Любая страна</option>
            <option value="Австрия">Австрия</option>
            <option value="Германия">Германия</option>
            <option value="Индия">Индия</option>
            <option value="Россия">Россия</option>
            <option value="Чехия">Чехия</option>
        </select>

        <select name="type">
            <option value="">Любой тип отдыха</option>
            <option value="Шоппинг">Шоппинг</option>
            <option value="Экскурсия">Экскурсия</option>
            <option value="Отдых">Отдых</option>
        </select>


        <tr bgcolor="#c8d8f8">
            <td  align=center colspan=2>
                <input type="submit" value="Find tour"> <input type="reset"
                                                            value="Reset">
            </td>
        </tr>

    </table>

</form>
</body>
</html>
