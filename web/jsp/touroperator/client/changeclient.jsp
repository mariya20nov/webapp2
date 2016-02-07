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

<form action="/changeclient" method=post>
    <td valign=top>
        Client_id to change
        <select name="clientid">
            <c:forEach var="row" items="${db.rows}">
                <option value=${row.client_id}>${row.surname} ${row.name} ${row.middle_name}</option>
            </c:forEach>
        </select>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>CHANGE CLIENT</font>
        </th>

        <tr bgcolor="#c8d8f8">
            <td valign=top>
                Name

                <input type="text" name="clientname" value="" size=15 maxlength=20></td>
            <td valign=top>
                Middle name

                <input type="text" name="clientmiddlename" value="" size=15 maxlength=20></td>
        </tr>
        <td valign=top>
        <td  valign=top>
            Surname

            <input type="text" name="clientsurname" value="" size=15 maxlength=20></td>

        <td valign=top>
            Passport

            <input type="text" name="clientpassport" value="" size=25  maxlength=125>
        </td>

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
