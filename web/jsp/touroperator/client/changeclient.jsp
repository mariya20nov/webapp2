<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>

<sql:query var="db" dataSource="${con}">
    select * from Client;
</sql:query>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<a href="/jsp/touroperator/client/clients.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/changeclient" method=post style="position:absolute; top:7%;">
    <p style="font-size:30px"> Change client</p>

    <select name="clientid">
        <c:forEach var="row" items="${db.rows}">
            <option value=${row.client_id}>${row.surname} ${row.name} ${row.middle_name}</option>
        </c:forEach>
    </select>

    <p> Surname </p> <input type="text" name="clientsurname" value="" size=15 maxlength=20>
    <p> Name </p> <input type="text" name="clientname" value="" size=15 maxlength=20></td>
    <p> Middle name </p> <input type="text" name="clientmiddlename" value="" size=15 maxlength=20></td>
    <p> Passport </p> <input type="text" name="clientpassport" value="" size=25  maxlength=10>

    <input type="submit" value="Change">
</form>
</body>
</html>
