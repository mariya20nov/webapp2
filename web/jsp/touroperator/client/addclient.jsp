<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<a href="/jsp/touroperator/client/clients.jsp"><p style="position:absolute; top:0;">Back</p></a>

<a href="/logout" ><p style="position:absolute; top:0; left:75%;">Log out</p></a>

<form action="/addclient" method=post style="position:absolute; top:7%;">
    <p style="font-size:30px"> New client</p>

    <p> Surname </p> <input type="text" name="clientsurname" value="" size=15 maxlength=20>
    <p> Name </p> <input type="text" name="clientname" value="" size=15 maxlength=20>
    <p> Middle name </p> <input type="text" name="clientmiddlename" value="" size=15 maxlength=20>
    <p> Passport </p> <input type="text" name="clientpassport" value="" size=25  maxlength=10>

    <input type="submit" value="Add">
</form>
</body>
</html>
