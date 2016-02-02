<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 01.02.16
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addtour" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>NEW TOUR</font>
        </th>

        <tr bgcolor="#c8d8f8">
            <td valign=top>
                resort id

                <input type="text" name="resortid" value="" size=15 maxlength=20></td>
            <td valign=top>
                type id

                <input type="text" name="typeid" value="" size=15 maxlength=20></td>
        </tr>
        <td  valign=top>
            Name

            <input type="text" name="name" value="" size=15 maxlength=20></td>

        <td valign=top>
            Date of beginning

            <input type="text" name="datebeg" value="" size=25  maxlength=125>
        </td>

        <td valign=top>
            Date of ending

            <input type="text" name="dateend" value="" size=25  maxlength=125>
        </td>

        <td valign=top>
            Cost

            <input type="text" name="cost" value="" size=25  maxlength=125>
        </td>

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
