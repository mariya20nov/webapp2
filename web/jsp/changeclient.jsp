<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<td valign=top>
    Client_id to change
    <input type="text" name="clientid" value="" size=15 maxlength=20></td>

<form action="/changeclient" method=post>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>NEW CLIENT</font>
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
</body>
</html>
