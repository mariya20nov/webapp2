<%@ taglib uri="/WEB-INF/TLD.tld" prefix="ct" %>

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
<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<p style="position:absolute; left:35%; font-size:30px">Tours</p>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
    <thead>
    <tr>
        <th>tour id</th>
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
            <td> ${row.name} </td>
            <td> ${row.date_beg} </td>
            <td> ${row.date_end} </td>
            <td> ${row.cost} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/jsp/client/showhottours.jsp"><p style="position:absolute; top:12%;">Hot tours</p></a>

<a href="/jsp/client/buytour.jsp"><p style="position:absolute; top:16%;">Buy tour</p></a>

<a href="/jsp/client/showtours.jsp"><p style="position:absolute; top:20%;">Show my tours</p></a>


<form action="/ordinaryclient" method=post style="position:absolute; top:30%;">
    <input type="submit" value="Find tour">

    <div> <select name="country">
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
    </select> </div>
</form>

<p> You logined as <ct:nametag name="${sessionScope.clientname}"/></p>
</body>
</html>
