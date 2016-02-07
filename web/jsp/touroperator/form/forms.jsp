<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8"
                    user="root"
                    password="mkpwd"
/>


<sql:query var="db" dataSource="${con}">
    select * from Form;
</sql:query>


<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/TourOperator.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<p style="position:absolute; left:35%; font-size:30px">Forms</p>

<table border="2" cellpadding="10" bordercolor="green" style="position:absolute; top:12%; left:25%">
    <thead>
    <tr>
        <th>form_id</th>
        <th>client_id</th>
        <th>tour_id</th>
        <th>date</th>
        <th>discount</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${db.rows}">
        <tr>
            <td> ${row.form_id} </td>
            <td> ${row.client_id} </td>
            <td> ${row.tour_id} </td>
            <td> ${row.date} </td>
            <td> ${row.discount} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<a href="/jsp/touroperator/form/addform.jsp"><p style="position:absolute; top:15%;">add form</p></a>
<a href="/jsp/touroperator/form/findform.jsp"><p style="position:absolute; top:18%;">find form</p></a>

<form action="/getdata" method=post style="position:absolute; top:30%;">
    <p>Get data about form with ID</p>

    <select name="formid">
        <c:forEach var="row" items="${db.rows}">
            <option value=${row.form_id}>${row.form_id}</option>
        </c:forEach>
    </select>

    <tr bgcolor="#c8d8f8">
        <td  align=center colspan=2>
            <input type="submit" value="Get data">
        </td>
    </tr>
</form>

</body>
</html>

