<%--
  Created by IntelliJ IDEA.
  User: waffi
  Date: 10.11.2020
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <!--//id, nameWatch, typeWatch, price, count, manufacturer,country;-->
        <form class="login-form" action="WatchServlet" method="post">
            <input type="text" placeholder="nameWatch" name="nameWatch"/>
            <input type="text" placeholder="typeWatch" name="typeWatch"/>
            <input type="text" placeholder="price" name="price"/>
            <input type="text" placeholder="count" name="count"/>
            <input type="text" placeholder="manufacturer" name="manufacturer"/>
            <input type="text" placeholder="country" name="country"/>
            <button name="addWatch">Add</button>
        </form>
    </div>
</body>
</html>
