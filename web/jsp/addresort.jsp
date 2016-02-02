<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 01.02.16
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addresort" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>NEW RESORT</font>
        </th>

        <tr bgcolor="#c8d8f8">
            <td valign=top>
                Name

                <input type="text" name="name" value="" size=15 maxlength=20></td>
            <td valign=top>
                Country

                <input type="text" name="country" value="" size=15 maxlength=20></td>
            <td valign=top>
                Location

                <input type="text" name="location" value="" size=15 maxlength=20></td>
        </tr>
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
