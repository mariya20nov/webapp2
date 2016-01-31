<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.epam.java.courses.fundamentals.dto.Client" %>
<%
    Collection<Client> clients = (Collection<Client>) request.getAttribute("findclients");
%>
<html>
<head>
    <title>Find client</title>
</head>
<body>
<form action="/findclient" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>FIND CLIENT</font>
        </th>

        <td  valign=top>
            Surname

            <input type="text" name="surname" value="" size=15 maxlength=20></td>


        <tr bgcolor="#c8d8f8">
            <td  align=center colspan=2>
                <input type="submit" value="Submit"> <input type="reset"
                                                            value="Reset">
            </td>
        </tr>

    </table>

</form>
</body>
</html>
