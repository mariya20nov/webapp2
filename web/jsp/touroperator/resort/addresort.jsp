<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<a href="/jsp/touroperator/resort/resorts.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/addresort" method=post  style="position:absolute; top:7%;">
    <p style="font-size:30px"> New resort</p>

    <p> Name </p> <input type="text" name="name" value="" size=15 maxlength=20>
    <p> Country </p> <input type="text" name="country" value="" size=15 maxlength=20>
    <p> Location </p> <input type="text" name="location" value="" size=15 maxlength=20>

    <input type="submit" value="Add">
</form>
</body>
</html>
