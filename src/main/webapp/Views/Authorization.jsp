<%--
  Created by IntelliJ IDEA.
  User: waffi
  Date: 08.11.2020
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <div>
            <form class="login-form" action="Authorization" method="post">
                <input type="text" placeholder="username" name="username"/>
                <input type="password" placeholder="password" name="password"/>
                <button>login</button>
                <p class="message">Not registered? <a href="../Registration.jsp">Create an account</a></p>
            </form>
        </div>
</body>
</html>
