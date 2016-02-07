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
<a href="/jsp/touroperator/tour/tours.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/changetour" method=post style="position:absolute; top:7%;">
    <p style="font-size:30px"> Change tour cost</p>

    <select name="tourid">
        <c:forEach var="row" items="${db.rows}">
            <option value=${row.tour_id}>${row.name}</option>
        </c:forEach>
    </select>

    <p> New cost </p> <input type="text" name="cost" value="" size=25  maxlength=15>

    <input type="submit" value="Submit">
</form>
</body>
</html>
