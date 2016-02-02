<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 01.02.16
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/deleteresort" method=post>
    <td valign=top>
        Resort id

        <input type="text" name="resortid" value="" size=15 maxlength=20></td>

    <tr bgcolor="#c8d8f8">
        <td  align=center colspan=2>
            <input type="submit" value="Submit"> <input type="reset"
                                                        value="Reset">
        </td>
    </tr>
</form>
</body>
</html>
