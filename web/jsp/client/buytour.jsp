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
</head>
<body>
<a href="/jsp/client/ordinaryclient.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:55%;">Log out</p></a>

<p style="position:absolute; left:15%; font-size:30px">Tours</p>

<form action="/buytour" method=post style="position:absolute; top:15%;">
    <select name="tourid">
        <c:forEach var="row" items="${sqlTour.rows}">
            <option value=${row.tour_id}>${row.name}</option>
        </c:forEach>
    </select>

    <input type="submit" value="By">
</form>
</body>
</html>
