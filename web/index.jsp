<%@ page session="false"
         pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
    </head>

    <body>
        <form action="j_security_check" method="post">
            <p style="font-size:30px"> Log in</p>
            <p>Login</p> <input type="login" name="j_username" title="Login"/>
            <p>Password</p> <input type="password" name="j_password" autocomplete="off" title="Password"/><br/>
            <input type="submit" value="Log in"/>
        </form>

        <p></p>
        <a href="/jsp/signup.jsp">sign up</a>
    </body>

</html>
