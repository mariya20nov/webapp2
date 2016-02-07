<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form action="/adduser" method=post style="position:absolute; top:7%;">
    <p style="font-size:30px"> New user</p>

    <p> Surname </p> <input type="text" name="clientsurname" value="" size=15 maxlength=20>
    <p> Name </p> <input type="text" name="clientname" value="" size=15 maxlength=20>
    <p> Middle name </p> <input type="text" name="clientmiddlename" value="" size=15 maxlength=20>
    <p> Passport </p> <input type="text" name="clientpassport" value="" size=25  maxlength=10>
    <p> Password </p> <input type="text" name="clientpassword" value="" size=25  maxlength=125>

    <input type="submit" value="Sign up">
</form>
</body>
</html>
