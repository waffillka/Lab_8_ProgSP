<%--
  Created by IntelliJ IDEA.
  User: waffi
  Date: 10.11.2020
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form class="login-form" action="WatchServlet" method="post">
                <input type="text" value="Delete Manufacturer By ID" readonly/>
                <input type="text" placeholder="id" name="id"/>
                <button name="deleteWatch">delete</button>
            </form>
        </div>
    </div>
</body>
</html>
