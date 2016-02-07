<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>

<sql:query var="sqlClient" dataSource="${con}">
    select * from Client;
</sql:query>

<sql:query var="sqlTour" dataSource="${con}">
    select * from Tour;
</sql:query>


<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/form/forms.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/addform" method=post style="position:absolute; top:7%;">
    <p style="font-size:30px"> New form</p>

    <p> Client </p>
    <select name="clientid">
        <c:forEach var="row" items="${sqlClient.rows}">
            <option value=${row.client_id}>${row.surname} ${row.name} ${row.middle_name}</option>
        </c:forEach>
    </select>

    <p> Tour </p>
    <select name="tourid">
        <c:forEach var="row" items="${sqlTour.rows}">
            <option value=${row.tour_id}>${row.name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Add form">
</form>
</body>
</html>
