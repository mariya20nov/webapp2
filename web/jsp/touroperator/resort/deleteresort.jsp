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
</head>
<body>
<a href="/jsp/touroperator/resort/resorts.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/deleteresort" method=post style="position:absolute; top:5%;">
    <p style="font-size:30px"> Delete resort</p>

    <select name="resortid">
        <c:forEach var="row" items="${db.rows}">
            <option value=${row.resort_id}>${row.name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Delete resort">
</form>
</body>
</html>
