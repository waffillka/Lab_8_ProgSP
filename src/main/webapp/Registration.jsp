<%--
  Created by IntelliJ IDEA.
  User: waffi
  Date: 07.11.2020
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
    <title>RegistrationView</title>
</head>
    <body>
        <div>
            <form class="login-form" action="Register" method="post">
                <input type="text" placeholder="First Name" name="firstName"/>
                <input type="text" placeholder="Surname" name="surname"/>
                <input type="text" placeholder="username" name="username"/>
                <input type="password" placeholder="Password" name="password"/>
                <input type="text" placeholder="Contact phone" name="contactPhone"/>
                <button>create</button>
                    <p class="message">Already registered? <a href="Views/Authorization.jsp">Sign In</a></p>
            </form>
        </div>
    </body>
</html>
