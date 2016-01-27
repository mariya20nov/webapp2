<%@ page session="false"
         pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <text>Login</text>
    </head>

    <body>
        <form action="j_security_check" method="post">
            <input type="login" name="j_username" title="Login"/>
            <input type="password" name="j_password" autocomplete="off" title="Password"/><br/>
            <input type="submit"/>
        </form>
    </body>

</html>
