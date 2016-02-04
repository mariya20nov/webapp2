<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<form action="/addtourcount" method=post>
    <td valign=top>
        Client_id to change
        <input type="text" name="clientid" value="" size=15 maxlength=20></td>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>NEW CLIENT</font>
        </th>

        <tr bgcolor="#c8d8f8">
            <td valign=top>
                Tour count

                <input type="text" name="tourcounttoadd" value="" size=15 maxlength=20></td>
        </tr>
        <td valign=top>

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